package pkuhit.iih.qa.qaauto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoEventService;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.cache.CacheManager;
import pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDao;
import pkuhit.iih.qa.md.QaFltStatus;
import pkuhit.iih.qa.old.QaItem;
import pkuhit.iih.qa.qacustom.QaScoreService;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ru.RuleEnginService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.ru.engin.RuleEngin;
import xap.ru.engin.data.Condition;
import xap.ru.engin.item.Item;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class QaItemServiceImpl implements QaItemService {
	
	@Reference
	RuleEngin ruleEngin;
	@Reference
	RuleEnginService ruleEnginService;
	@Reference
	QaAutoDataProcessService qaAutoDataProcessService;
	@Reference
	QaScoreService qaScoreService;
	
	@Reference
	DictionaryService dictionaryService;
	
	@Autowired
	CusQaAutoItmConfigDao cusQaAutoItmDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		List<Item<QaItem>> list = (List<Item<QaItem>>) ruleEnginService.getList();
		ruleEngin.execute(list);
	}
	@Override
	public ArrayResult<QaDivideModel> qaAutoTest(String enPk,String qaAutoTypeCode) throws Exception {
		//每次进入本方法都先清空当前患者缓存的dataSearch信息
		/*Session session = Session.get();
		String curDeptId = session.getDeptId();
		String mrKey = curDeptId+"_mr_"+enPk;
		String emrEventKey = curDeptId+"_emrEvent_"+enPk;*/

		String mrKey = "mr_"+enPk;
		String emrEventKey = "emrEvent_"+enPk;
		CacheManager.clearAll(mrKey); 
		CacheManager.clearAll(emrEventKey); 
		Map map = new HashMap();
		ArrayResult<CusQaAutoItmConfig>  QaAutoItmConfigArrayResult = searchQaAutoItm(map);
		CusQaAutoItmConfig[] dataList = QaAutoItmConfigArrayResult.getDataList();
		//如果autoItemConfigMap为null则不进行校验
		if(null == dataList || dataList.length == 0){
			ArrayResultBuilder<QaDivideModel> builder = ArrayResultBuilder
						.newArrayResult(QaDivideModel.class);
			return builder.build();
		}
		List<Item<QaItem>> list = getListByEventCode("QAM18.01");//(List<Item<QaItem>>) ruleEnginService.getList();
		List<Item<QaItem>> rslist =  new ArrayList<Item<QaItem>>();
		if(list != null){
			for (int i=0; i<list.size();i++) {
				
				Item<QaItem> item = list.get(i);
				//如果配置的List中存在不需要质控的项，则该质控项从list中移除
				for(CusQaAutoItmConfig configModel:dataList){
					if(null != configModel.getQaItmCd() && !configModel.getQaItmCd().equals(item.getCode())){
						continue;
					}else{
						if (item.getItemEventMap() != null && item.getItemEventMap().size()>0) {
							 Iterator<Map.Entry<String, ItemEvent>> it = item.getItemEventMap().entrySet().iterator();  
						        while(it.hasNext()){  
						            Map.Entry<String, ItemEvent> entry=it.next();  
						            String key=entry.getKey();  
						          //每一个itemEvent有一个Condition
									Condition condition = new Condition();
									Map searchCondition = condition.getSearchCondition();
									searchCondition.put("enPk", enPk);
									searchCondition.put("qaItemCode", item.getCode());
									searchCondition.put("mrTypeCode", configModel.getMrTypes());
									searchCondition.put("deadHours", configModel.getDeadHours());
									searchCondition.put("eventTypeCode", configModel.getEventTypeCode());
									searchCondition.put("mrOpType", configModel.getMrOpType());
									searchCondition.put("qaRlCd", configModel.getQaRuleCd());//频率质控，质控规则
									searchCondition.put("qaRlTpCd", configModel.getQaRlTpCd());//连续、重复
									searchCondition.put("jobTitleCd", configModel.getJobTitleCd()); //完整性 医师职称
									searchCondition.put("dctOpTpCd", configModel.getDctOpTpCd()); //完整性 医师操作类型
									searchCondition.put("qaItmTpCd", configModel.getQaItmTpCd()); //质控项目类别,主数据QAM06：时限性、频率性、完整性

									ItemEvent itemEvent= item.getItemEventMap().get(key);
									if(itemEvent.getCondition() == null){
										itemEvent.setCondition(condition);
									}
						        }  
						}
						rslist.add(item);
						break;
					}
				}
			}
		}
		ruleEngin.execute(rslist);
		
		//开始环节自动质控时，先删除已有的环节自动质控扣分项
		if(qaAutoTypeCode.equals(QaFltStatus.QA_TY_CD_AUTO_PROCESS)){
			
			qaAutoDataProcessService.batchDeleteDivide(enPk);
		}
		if (rslist != null) {
			for (Item<QaItem> item : rslist) {
				if (item.getItemEventMap() != null && item.getItemEventMap().size()>0) {
					for (String key : item.getItemEventMap().keySet()) {
						
						ItemEvent itemEvent= item.getItemEventMap().get(key);
						Condition condition = itemEvent.getCondition();
						Map<String, Object> searchCondition = null;
						String qaItmTpCd = "";
						if(condition != null){
							searchCondition = condition.getSearchCondition();
							qaItmTpCd = (String)searchCondition.get("qaItmTpCd");
						}
						//质控项
						String qaItemCd = item.getCode();
						for(String keyResult :itemEvent.getQaValidateModelMap().keySet()){
							ValidateResult<QaValidateModel> qa = (ValidateResult<QaValidateModel>) itemEvent.getQaValidateModelMap().get(keyResult);
							if(qa.getResultList()!=null && qa.getResultList().size()>0){
						    	QaValidateModel qaValidateModel = qa.getResultList().get(0);
						    	if(null!=qaValidateModel && !qaValidateModel.isValidateResult()){
									qaAutoDataProcessService.saveQaDivide(qaValidateModel,qaItemCd,enPk,qaAutoTypeCode,qaItmTpCd);
								}
						    }
						}
					}
				}
			}
		}
		
	    ArrayResult<QaDivideModel> qaDivideArrayResult = null;
	    Map searchMap = new HashMap();
	    searchMap.put("encounterPk", enPk);
	    searchMap.put("workScreen", "12");
	    try {
			qaDivideArrayResult = qaScoreService.search(searchMap);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    CacheManager.clearAll(mrKey); 
		CacheManager.clearAll(emrEventKey); 
		return qaDivideArrayResult;
	
	}
	@Override
	public ArrayResult<CusQaAutoItmConfig> searchQaAutoItm(Map condition)
			throws Exception {
		
		ArrayResultBuilder<CusQaAutoItmConfig> arrayBuilder = ArrayResultBuilder.newArrayResult(CusQaAutoItmConfig.class);
		List<Map<String, Object>> qaAutoItmConfigList = null;
		Map<String, Object> mapQaItmConfig = null;
		
		//添加查询条件
		String qaItmCd = null ;
		String qaItmTpCd = null ;
		
		if(condition.containsKey("qaItmCd")){
			qaItmCd = condition.get("qaItmCd").toString();
		}
		if(condition.containsKey("qaItmTpCd")){
			qaItmTpCd = condition.get("qaItmTpCd").toString();
		}
		
		qaAutoItmConfigList = cusQaAutoItmDao.selectQaAutoItmByCondition(qaItmCd,qaItmTpCd);
		if(null != qaAutoItmConfigList && qaAutoItmConfigList.size()>0){
			
			CusQaAutoItmConfig[] qaAutoItmConfigArray = new CusQaAutoItmConfig[qaAutoItmConfigList.size()];
			for(int i=0;i<qaAutoItmConfigList.size();i++){
				CusQaAutoItmConfig qaAutoItmConfig = new CusQaAutoItmConfig();
				mapQaItmConfig = qaAutoItmConfigList.get(i);
				BeanCopyUtil.mapToModel(qaAutoItmConfig, mapQaItmConfig,dictionaryService);
				qaAutoItmConfigArray[i] = qaAutoItmConfig;
			}
			if(qaAutoItmConfigArray!=null){
				arrayBuilder.withData(qaAutoItmConfigArray);
			}
			
		}
		ArrayResult<CusQaAutoItmConfig> qaAutoItmConfigResult = arrayBuilder.build();
		return qaAutoItmConfigResult;
	}
	public List<Item<QaItem>> getListByEventCode(String EventCode) throws Exception{
		List<Item<QaItem>> list = (List<Item<QaItem>>) ruleEnginService.getList();
		if(list != null){
			for (int i=0; i<list.size();i++) {
				
				Item<QaItem> item = list.get(i);
				if (item.getItemEventMap() != null && item.getItemEventMap().size()>0) {
					 Iterator<Map.Entry<String, ItemEvent>> it = item.getItemEventMap().entrySet().iterator();  
				        while(it.hasNext()){
				        	  Map.Entry<String, ItemEvent> entry=it.next();  
					          ItemEvent itemEvent = entry.getValue();
					          if(null != itemEvent && !itemEvent.getCode().equals(EventCode)){//"QAM18.01"
					        	  it.remove();
					          }
				        }  
				}
				if(item.getItemEventMap() == null || item.getItemEventMap().size()==0){
					list.remove(i);
					i--;
				}
			}
		}
		return list;
	}
	
}
