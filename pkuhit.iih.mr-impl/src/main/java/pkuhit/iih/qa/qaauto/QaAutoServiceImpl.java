package pkuhit.iih.qa.qaauto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.cache.Cache;
import pkuhit.iih.qa.cache.CacheManager;
import pkuhit.iih.qa.dao.auto.QaAutoFltDao;
import pkuhit.iih.qa.dao.auto.entity.QaAutoFlt;
import pkuhit.iih.qa.dao.qacustom.CusQaAutoDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ru.RuleEnginService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.ru.engin.RuleEngin;
import xap.ru.engin.data.Condition;
import xap.ru.engin.item.Item;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.sv.annotation.Reference;
import xap.sv.event.listener.EventListener;
import xap.sv.event.object.EventObject;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.util.UUIDGenerator;

//预生成自动质控缺陷
public  class QaAutoServiceImpl implements EventListener{
	
	@Autowired
	CusQaAutoDao cusQaAutoDao;
	
	@Autowired
	QaAutoFltDao qaAutoFltDao;
	
	@Reference
	DictionaryService  dictionaryService;
	
	@Reference
	RuleEngin ruleEngin;
	
	@Reference
	RuleEnginService ruleEnginService;

	@Override
	public void callBack(EventObject arg0) {
		// TODO Auto-generated method stub
		EmrEventModel emrEventModel = (EmrEventModel)arg0.getSource();
		try {
			qaAutoRuleHandler(emrEventModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void qaAutoRuleHandler(EmrEventModel emrEventModel) throws Exception{
		String eventTypeCode = emrEventModel.getEventtype();
		String enPk = emrEventModel.getEncId().toString();
		//从缓存中取出事件对应的任务类型
		CusQaAutoItmConfig[] cusQaAutoItmConfigArray = simpleCache(eventTypeCode);
		
		List<Item<QaItem>> validateList = initValidateList(cusQaAutoItmConfigArray,enPk,emrEventModel);
		saveQaAutoFlt(validateList);
		
		//return null;
	}

	//查询事件类型
	public ArrayResult<CusQaAutoItmConfig> searchQaAutoItemType(Map condition)
			throws Exception {
		String eventTypeCode = "";
		if(null != condition){
			eventTypeCode = (String)condition.get("eventTypeCode_qa");
		}
		ArrayResultBuilder<CusQaAutoItmConfig> arrayBuilder = ArrayResultBuilder.newArrayResult(CusQaAutoItmConfig.class);
		List<Map<String, Object>> qaAutoItmConfigList = null;
		Map<String, Object> mapXapTaskType = null;
		
		qaAutoItmConfigList = cusQaAutoDao.searchQaItemsByCondition(eventTypeCode);
		if(null != qaAutoItmConfigList && qaAutoItmConfigList.size()>0){
			
			//CusXapTaskTypeModel[] cusXapTaskTypeModelArray = new CusXapTaskTypeModel[qaAutoItmConfigList.size()];
			
			CusQaAutoItmConfig[] qaAutoItmConfigArray = new CusQaAutoItmConfig[qaAutoItmConfigList.size()];
			for(int i=0;i<qaAutoItmConfigList.size();i++){
				CusQaAutoItmConfig cusQaAutoItmConfig = new CusQaAutoItmConfig();
				mapXapTaskType = qaAutoItmConfigList.get(i);
				BeanCopyUtil.mapToModel(cusQaAutoItmConfig, mapXapTaskType,dictionaryService);
				qaAutoItmConfigArray[i] = cusQaAutoItmConfig;
			}
			if(qaAutoItmConfigArray!=null){
				arrayBuilder.withData(qaAutoItmConfigArray);
			}
			
		}
		ArrayResult<CusQaAutoItmConfig> cusQaAutoItmConfigResult = arrayBuilder.build();
		return cusQaAutoItmConfigResult;
	}

	//初始化校验数据
	public List<Item<QaItem>> initValidateList(CusQaAutoItmConfig[] cusQaAutoItmConfigArray,String enPk,EmrEventModel emrEventModel)throws Exception{
		List<Item<QaItem>> list = (List<Item<QaItem>>) getListByEventCode("QAM18.03");
		List<Item<QaItem>> rsList =  new ArrayList<Item<QaItem>>();
		if(list != null){
			for (int i=0; i<list.size();i++) {
				
				Item<QaItem> item = list.get(i);
//				System.out.println("i==================="+i+"item============"+item.getCode());
				//如果配置的List中存在不需要质控的项，则该质控项从list中移除
				if(null != cusQaAutoItmConfigArray){
					for(CusQaAutoItmConfig cusQaAutoItmConfig:cusQaAutoItmConfigArray){
						if(null != cusQaAutoItmConfig.getQaItmCd() && !cusQaAutoItmConfig.getQaItmCd().equals(item.getCode())){
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
										searchCondition.put("emrEventModel", emrEventModel);
										searchCondition.put("qaItemCode", item.getCode());
										searchCondition.put("mrTypeCode", cusQaAutoItmConfig.getMrTypes());//文书类型集合
										searchCondition.put("deadHours", cusQaAutoItmConfig.getDeadHours());
										searchCondition.put("eventTypeCode", cusQaAutoItmConfig.getEventTypeCode());
										searchCondition.put("qaRlCd", cusQaAutoItmConfig.getQaRlCd());//频率质控，质控规则
										searchCondition.put("qaRlTpCd", cusQaAutoItmConfig.getQaRlTpCd());//连续、重复
										searchCondition.put("jobTitleCd", cusQaAutoItmConfig.getJobTitleCd()); //完整性 医师职称
										searchCondition.put("dctOpTpCd", cusQaAutoItmConfig.getDctOpTpCd()); //完整性 医师操作类型
										searchCondition.put("qaItmTpCd", cusQaAutoItmConfig.getQaItmTpCd()); //质控项目类别,主数据QAM06：时限性、频率性、完整性
										//重要 判断是否读session
										searchCondition.put("haveSession", "false");
										
										ItemEvent itemEvent= item.getItemEventMap().get(key);
										if(itemEvent.getCondition() == null){
											itemEvent.setCondition(condition);
										}
							        }  
							}
							rsList.add(item);
							break;
						}
					}
				}
				
			}
		}
		System.out.println("enPk============"+enPk);
		ruleEngin.execute(rsList);
		return rsList;
	}
	public List<Item<QaItem>> getListByEventCode(String eventCode) throws Exception{
		List<Item<QaItem>> list = (List<Item<QaItem>>) ruleEnginService.getList();
		if(list != null){
			for (int i=0; i<list.size();i++) {
				
				Item<QaItem> item = list.get(i);
				if (item.getItemEventMap() != null && item.getItemEventMap().size()>0) {
					 Iterator<Map.Entry<String, ItemEvent>> it = item.getItemEventMap().entrySet().iterator();  
				        while(it.hasNext()){
				        	  Map.Entry<String, ItemEvent> entry=it.next();  
					          ItemEvent itemEvent = entry.getValue();
					          if(null != itemEvent && !itemEvent.getCode().equals(eventCode)){
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
	
	public void saveQaAutoFlt(List<Item<QaItem>> rsList){
		if (rsList != null) {
			for (Item<QaItem> item : rsList) {
				if (item.getItemEventMap() != null && item.getItemEventMap().size()>0) {
					for (String key : item.getItemEventMap().keySet()) {
						
						ItemEvent itemEvent= item.getItemEventMap().get(key);
						Condition condition = itemEvent.getCondition();
						Map<String, Object> searchCondition = null;
						String mrTypeCode = "";
						String qaItemCode = "";
						String enPk = "";
						EmrEventModel emrEventModel = null;
						if(condition != null){
							searchCondition = condition.getSearchCondition();
							mrTypeCode = (String)searchCondition.get("mrTypeCode");
							qaItemCode = (String)searchCondition.get("qaItemCode");
							enPk = (String)searchCondition.get("enPk");
							emrEventModel = (EmrEventModel)searchCondition.get("emrEventModel");
						}
						//质控项
						String qaItemCd = item.getCode();
						for(String keyResult :itemEvent.getQaValidateModelMap().keySet()){
							ValidateResult<QaValidateModel> qa = (ValidateResult<QaValidateModel>) itemEvent.getQaValidateModelMap().get(keyResult);
							if(qa.getResultList()!=null && qa.getResultList().size()>0){
						    	QaValidateModel qaValidateModel = qa.getResultList().get(0);
						    	if(null!=qaValidateModel && !qaValidateModel.isValidateResult()){
						    		Short temp = 0;
						    		QaAutoFlt qaAutoFlt = new QaAutoFlt();
						    		String qaAutoFltPk = UUIDGenerator.getUUID();
						    		qaAutoFlt.setQaAutoFltPk(qaAutoFltPk);
						    		qaAutoFlt.setQaItmCd(qaItemCode);
						    		qaAutoFlt.setEventId(emrEventModel.getEventtype());
						    		qaAutoFlt.setEncounterSn(enPk);
						    		qaAutoFlt.setBeginTime(qaValidateModel.getBizTime());
						    		qaAutoFlt.setApplyFlag(temp);
						    		qaAutoFlt.setFltFlag(temp);
						    		qaAutoFlt.setDivFlag(temp);
						    		if(qaValidateModel.getDeadDate() != null){
						    			qaAutoFlt.setEndTime(qaValidateModel.getDeadDate());
						    		}
						    		qaAutoFltDao.insert(qaAutoFlt);
								}
						    }
						}
					}
				}
			}
		}
	}

	//如果缓存中没有值则查询
	public CusQaAutoItmConfig[] simpleCache(String eventTypeCode){

		String eventKey = eventTypeCode;
		Cache eventTaskCache = CacheManager.getCacheInfo(eventKey);
		Map<String,CusQaAutoItmConfig[]> eventTaskMap = new HashMap<String,CusQaAutoItmConfig[]>();
		CusQaAutoItmConfig[] cusQaAutoItmConfigArray = null;
		if(null != eventTaskCache){
			eventTaskMap = (Map<String, CusQaAutoItmConfig[]>) eventTaskCache.getValue();
			cusQaAutoItmConfigArray = eventTaskMap.get(eventKey);
		}else{
			//查询出某事件类型对应的自动质控类型集合，存放在cache中
			Map conditionMap = new HashMap();
			conditionMap.put("eventTypeCode_qa", eventTypeCode);
			ArrayResult<CusQaAutoItmConfig> QaAutoItmConfigArrayResult;
			try {
				
				QaAutoItmConfigArrayResult = searchQaAutoItemType(conditionMap);
			
				cusQaAutoItmConfigArray = QaAutoItmConfigArrayResult.getDataList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eventTaskMap.put(eventKey, cusQaAutoItmConfigArray);
			eventTaskCache = new Cache(eventKey,eventTaskMap,0,false);
			CacheManager.putCache(eventKey, eventTaskCache);
		}
		
		return cusQaAutoItmConfigArray;
		
	
	}
	
	
}
