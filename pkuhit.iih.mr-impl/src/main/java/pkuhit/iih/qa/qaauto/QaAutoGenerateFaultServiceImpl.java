package pkuhit.iih.qa.qaauto;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.md.EncounterStatus;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.md.dao.auto.MdMrTpDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.CusQaAutoFltModel;
import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.apply.MrApplyServiceImpl;
import pkuhit.iih.qa.cache.CacheManager;
import pkuhit.iih.qa.dao.auto.QaAutoFltDao;
import pkuhit.iih.qa.dao.auto.QaDivideDao;
import pkuhit.iih.qa.dao.auto.entity.QaAutoFlt;
import pkuhit.iih.qa.dao.auto.entity.QaDivide;
import pkuhit.iih.qa.dao.qacustom.CusQaAutoDao;
import pkuhit.iih.qa.md.QaFltStatus;
import pkuhit.iih.qa.qacustom.QaScoreService;
import pkuhit.iih.qa.util.QaUtil;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.ru.RuleEnginService;
import pkuhit.xap.util.BeanCopyUtil;
import pkuhit.xap.util.Clone;
import xap.ru.engin.RuleEngin;
import xap.ru.engin.data.Condition;
import xap.ru.engin.item.Item;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.util.UUIDGenerator;

  
public  class QaAutoGenerateFaultServiceImpl implements QaAutoGenerateFaultService{
	
	public static Logger log = LoggerFactory
			.getLogger(QaAutoGenerateFaultServiceImpl.class);
			
	@Reference
	RuleEngin ruleEngin;
	@Reference
	RuleEnginService ruleEnginService;
	@Reference
	QaAutoDataProcessService qaAutoDataProcessService;
	@Reference
	QaScoreService qaScoreService;
	
	@Reference
	MrApplyServiceImpl mrApplyServiceImpl;
	
	@Reference
	DictionaryService dictionaryService;
	
	@Autowired
	CusQaAutoDao cusQaAutoDao;
	
	@Autowired
	MdMrTpDao mdMrTpDao;
	
	@Autowired
	QaDivideDao qaDivideDao;
	
	@Autowired
	QaAutoFltDao qaAutoFltDao;
	
	@Reference
	QaItemService qaItemService;
	
	@Reference
	ParamsService paramsService; //系统参数设置
	
	@Autowired
	MrAmrDao mrAmrDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		List<Item<QaItem>> list = (List<Item<QaItem>>) ruleEnginService.getList();
		ruleEngin.execute(list);
	}
	public void triggerCallQaAutoFlt()throws Exception{
		String qaAutoTypeCode = CusQaAutoFltModel.TIMELIMIT;
		initRuleData(qaAutoTypeCode);
		generateTerminalAutoQaDivide();
		generateTerminalAutoScore();
		
	}
	
	
	@Override
	public ArrayResult<CusQaAutoFltModel> initRuleData(String qaAutoTypeCode) throws Exception {
		
		//1 查询待质控的预生成缺陷
		Map map = new HashMap();
		//map.put("qaItmTpCd", CusQaAutoItmConfig.TIMELIMIT);//"QAM06.02"
		//临时处理 同时查询时限类和完整性质控（缺文书）
		String qaItmTpCds = CusQaAutoItmConfig.TIMELIMIT +","+CusQaAutoItmConfig.INTEGRITY;
		map.put("qaItmTpCd", qaItmTpCds);//"QAM06.02"
		ArrayResult<CusQaAutoFltModel>  QaAutoItmConfigArrayResult = searchPreFltItm(map);
		CusQaAutoFltModel[] dataList = QaAutoItmConfigArrayResult.getDataList();
		//如果dataList为null则不进行校验
		if(null == dataList || dataList.length == 0){
			ArrayResultBuilder<CusQaAutoFltModel> builder = ArrayResultBuilder
						.newArrayResult(CusQaAutoFltModel.class);
			return builder.build();
		}
		
		//2 获取QAM18.01事件的所有质控相关类
		List<Item<QaItem>> list = getListByEventCode("QAM18.01");//(List<Item<QaItem>>) ruleEnginService.getList();
		List<Item<QaItem>> rslist =  new ArrayList<Item<QaItem>>();
		if(list != null){
			for (int i=0; i<list.size();i++) {
				
				Item<QaItem> item = list.get(i);
				//如果配置的List中存在不需要质控的项，则该质控项从list中移除
				for(CusQaAutoFltModel configModel:dataList){
					//每次new新的item存值
					Item<QaItem> newItem = new Item<QaItem>();
					newItem = (Item<QaItem>) Clone.clone(item, 4);
					if(null != configModel.getQaItmCd() && !configModel.getQaItmCd().equals(newItem.getCode())){
						continue;
					}else{
						if (newItem.getItemEventMap() != null && newItem.getItemEventMap().size()>0) {
							 Iterator<Map.Entry<String, ItemEvent>> it = newItem.getItemEventMap().entrySet().iterator();  
						        while(it.hasNext()){  
						            Map.Entry<String, ItemEvent> entry=it.next();  
						            String key=entry.getKey();  
						          //每一个itemEvent有一个Condition
									Condition condition = new Condition();
									Map searchCondition = condition.getSearchCondition();
									searchCondition.put("enPk", configModel.getEncounterSn());
									searchCondition.put("qaItemCode", newItem.getCode());
									searchCondition.put("mrTypeCode", configModel.getMrTypes());
									searchCondition.put("deadHours", configModel.getDeadHours());
									searchCondition.put("eventTypeCode", configModel.getEventTypeCode());
									searchCondition.put("mrOpType", configModel.getMrOpType());
									searchCondition.put("qaRlCd", configModel.getQaRuleCd());//频率质控，质控规则
									searchCondition.put("qaRlTpCd", configModel.getQaRlTpCd());//连续、重复
									searchCondition.put("jobTitleCd", configModel.getJobTitleCd()); //完整性 医师职称
									searchCondition.put("dctOpTpCd", configModel.getDctOpTpCd()); //完整性 医师操作类型
									searchCondition.put("qaItmTpCd", configModel.getQaItmTpCd()); //质控项目类别,主数据QAM06：时限性、频率性、完整性
									searchCondition.put("cusQaAutoFltModel", configModel);
									//重要 判断是否读session
									searchCondition.put("haveSession", "false");

									ItemEvent itemEvent= newItem.getItemEventMap().get(key);
									if(itemEvent.getCondition() == null){
										itemEvent.setCondition(condition);
									}
						        }  
						}
						rslist.add(newItem);
						//break;
					}
				}
			}
		}
		
		//3 进行质控返回质控结果
		ruleEngin.execute(rslist);
		
		
		//4 质控完成，清空所有以患者为单位的  预生成缺陷所需的患者文书，患者相关事件  缓存信息
		for(CusQaAutoFltModel configModel:dataList){
		    String enPk = configModel.getEncounterSn();	
		     //质控方式：预生成缺陷质控
			String qaWay= "preFltQa";
			String mrKey = qaWay+"_mr_"+enPk;
			String emrEventKey = qaWay+"_emrEvent_"+enPk;
			CacheManager.clearAll(mrKey); 
			CacheManager.clearAll(emrEventKey); 
		}
		
		//5 质控结果处理 更新预生成缺陷列表，更新已经生成缺陷的信息
		if (rslist != null) {
			for (Item<QaItem> item : rslist) {
				if (item.getItemEventMap() != null && item.getItemEventMap().size()>0) {
					for (String key : item.getItemEventMap().keySet()) {
						
						String enPk = "";
						CusQaAutoFltModel cusQaAutoFltModel = new CusQaAutoFltModel();
						
						ItemEvent itemEvent= item.getItemEventMap().get(key);
						Condition condition = itemEvent.getCondition();
						Map<String, Object> searchCondition = null;
						String qaItmTpCd = "";
						if(condition != null){
							searchCondition = condition.getSearchCondition();
							qaItmTpCd = (String)searchCondition.get("qaItmTpCd");
							enPk = (String)searchCondition.get("enPk");
							cusQaAutoFltModel = (CusQaAutoFltModel)searchCondition.get("cusQaAutoFltModel");
						}
						//质控项
						String qaItemCd = item.getCode();
						for(String keyResult :itemEvent.getQaValidateModelMap().keySet()){
							ValidateResult<QaValidateModel> qa = (ValidateResult<QaValidateModel>) itemEvent.getQaValidateModelMap().get(keyResult);
							if(qa.getResultList()!=null && qa.getResultList().size()>0){
						    	QaValidateModel qaValidateModel = qa.getResultList().get(0);
						    	if(null == qaValidateModel){
						    		continue;
						    	}
						    	qaAutoDataProcessService.updateQaAutoFlt(cusQaAutoFltModel,qaValidateModel,qaItemCd,enPk,qaAutoTypeCode,qaItmTpCd);
								//如果为缺陷需要生成超时申请
						    	if(!qaValidateModel.isValidateResult() && qaItmTpCd != null && qaItmTpCd.equals(CusQaAutoItmConfig.TIMELIMIT)){ 
						    		try {
										mrApplyServiceImpl.create(cusQaAutoFltModel);
									} catch (Throwable e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
						    }
						}
					}
				}
			}
		}
		
	    
		ArrayResultBuilder<CusQaAutoFltModel> builder = ArrayResultBuilder
				.newArrayResult(CusQaAutoFltModel.class);
	    return builder.build();
	//	return qaDivideArrayResult;
	
	}
	/*查询预生成的缺陷项（事件发生时生成），即质控项*/
	@Override
	public ArrayResult<CusQaAutoFltModel> searchPreFltItm(Map condition)
			throws Exception {
		
		//初始化 容器、变量
		ArrayResultBuilder<CusQaAutoFltModel> arrayBuilder = ArrayResultBuilder.newArrayResult(CusQaAutoFltModel.class);
		List<Map<String, Object>> qaAutoFltList = null;
		Map<String, Object> mapQaItmConfig = null;
		
		//添加查询条件
		String qaItmTpCd = null ;
		String fltFlag = "0" ;//查已生成缺陷，还是未生成缺陷
		
		if(condition.containsKey("qaItmTpCd")){
			qaItmTpCd = condition.get("qaItmTpCd").toString();
		}
		if(condition.containsKey("fltFlag")){
			fltFlag = condition.get("fltFlag").toString();
		}
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(currentTimeTs);
		qaAutoFltList = cusQaAutoDao.searchPreFltQaItemsByCondition(currentTime,qaItmTpCd,fltFlag);
		if(null != qaAutoFltList && qaAutoFltList.size()>0){
			
			CusQaAutoFltModel[] cusQaAutoFltModelArray = new CusQaAutoFltModel[qaAutoFltList.size()];
			for(int i=0;i<qaAutoFltList.size();i++){
				CusQaAutoFltModel cusQaAutoFltModel = new CusQaAutoFltModel();
				mapQaItmConfig = qaAutoFltList.get(i);
				BeanCopyUtil.mapToModel(cusQaAutoFltModel, mapQaItmConfig,dictionaryService);
				cusQaAutoFltModelArray[i] = cusQaAutoFltModel;
			}
			if(cusQaAutoFltModelArray!=null){
				arrayBuilder.withData(cusQaAutoFltModelArray);
			}
			
		}
		ArrayResult<CusQaAutoFltModel> cusQaAutoFltModelResult = arrayBuilder.build();
		return cusQaAutoFltModelResult;
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
	
	//yaolijie 自动质控查询
	@Override
	public ArrayResult<CusQaAutoFltModel> searchQaAutoFlt(Map map) throws Exception {

		/*查询条件*/
		String currentManageDoctorId = map.get("currentManageDoctorId").toString(); //主管医师
		String deptCd = map.get("deptCd").toString(); //出诊科室
		String amrNo = QaUtil.getStringValueFromMap(map, "amrNo");//住院号
		String patientName = QaUtil.getStringValueFromMap(map, "patientName");//患者姓名

		String mrTypes = QaUtil.getStringValueFromMap(map, "mrTypes");//文书类型
		String enStaCd = QaUtil.getStringValueFromMap(map, "enStaCd");//就诊状态
		//---处理在院、出院---
		if(!StringUtils.isEmpty(enStaCd)){
			if("1".equals(enStaCd)){
				enStaCd = EncounterStatus.receipted;
			}else if("2".equals(enStaCd)){
				enStaCd = EncounterStatus.completed;
			}
		}
		String pageNum = null;
		String pageSize = null;
		if(map.containsKey("pageNum") && map.containsKey("pageSize")){
			pageNum = (String)map.get("pageNum");
			pageSize = (String)map.get("pageSize");
		}
		if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			pageNum= "1";
			pageSize = "25";
		}
		/*质控工作记录对象查询条件*/
		Session session = Session.get();
		String statusStr =  QaUtil.getStringValueFromMap(map, "amrState"); //病案状态
		String qaTypeCode = QaFltStatus.QA_TY_CD_AUTO_DEPT;//自动科室质控
		
		ArrayResultBuilder<CusQaAutoFltModel> builder = ArrayResultBuilder.newArrayResult(CusQaAutoFltModel.class);
		List<Map<String, Object>> qaAutoFltList = null; //自动质控缺陷列表
		String[] mrTypesList;
		//质控信息
		Map<String, Object> amrMap = null;

		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		qaAutoFltList = cusQaAutoDao.selectQaAutoFltByCondition(currentManageDoctorId,deptCd,amrNo,patientName,mrTypes,enStaCd,options);
		int total = 0;
		String nm = null;
		if(qaAutoFltList!=null&&qaAutoFltList.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			CusQaAutoFltModel [] qaWorks=new CusQaAutoFltModel[qaAutoFltList.size()];
			for(int i=0;i<qaAutoFltList.size();i++){
				CusQaAutoFltModel cusQaAutoFltModel = new CusQaAutoFltModel();
				amrMap = qaAutoFltList.get(i);
				BeanCopyUtil.mapToModel(cusQaAutoFltModel, amrMap, dictionaryService);
				String mrType = cusQaAutoFltModel.getMrTypes();
				mrTypesList = mrType.split(",");
				for(int j=0;j<mrTypesList.length;j++){
					MdMrTp mdMrTp = mdMrTpDao.selectById(mrTypesList[0]);
					nm = mdMrTp.getNm();
					break;
				}
				cusQaAutoFltModel.setNm(nm);
//				cusQaAutoFltModel.setPk((String)qaList.get(i).get("EN_PK"));
				qaWorks[i] = cusQaAutoFltModel;
			}
			if(qaWorks!=null){
				builder.withData(qaWorks);
			}
		}
		ArrayResult<CusQaAutoFltModel> amrResult = builder.build();
		amrResult.setTotal(total);
		return amrResult;
	
	}
	
	//根据预生成缺陷中  书写已完成+已出院 的患者 生成到质控评分表 并计算自动质控分数
	public SingleResult<Amr> generateTerminalAutoQaDivide() throws Exception {
		Map map = new HashMap();
		map.put("fltFlag", "1");
		String qaItmTpCds = CusQaAutoItmConfig.TIMELIMIT +","+CusQaAutoItmConfig.INTEGRITY;
		map.put("qaItmTpCd", qaItmTpCds);
		ArrayResult<CusQaAutoFltModel>  QaAutoItmConfigArrayResult = searchPreFltItm(map);
		CusQaAutoFltModel[] cusQaAutoFltModeList = QaAutoItmConfigArrayResult.getDataList();
			try{
				if (cusQaAutoFltModeList != null && cusQaAutoFltModeList.length > 0) {
					for (int i = 0; i < cusQaAutoFltModeList.length; i++) {
						String qaAutoTypeCode = QaFltStatus.QA_TY_CD_AUTO_TERMINAL;//终末自动质控
						CusQaAutoFltModel cusQaAutoFltModel = cusQaAutoFltModeList[i];
						//保存自动质控扣分记录
						QaDivide qaDivide = new QaDivide();
						String qaDivideCd = "";
						String drpDes = cusQaAutoFltModel.getMemo();
						qaDivideCd = UUIDGenerator.getUUID();
						qaDivide.setQaDivideCd(qaDivideCd);
						qaDivide.setQaItmPk(cusQaAutoFltModel.getQaItmCd());
						qaDivide.setQaTyCd(qaAutoTypeCode);
						qaDivide.setEnPk(cusQaAutoFltModel.getEncounterSn());
						
						qaDivide.setDrpDes(drpDes);
						qaDivide.setDeductScrTimes(1);
						qaDivideDao.insert(qaDivide);
						
						//更新qaAutoFlt 已生成评分标识 div_flag=1 表示已经生成到qa_divide 评分表
						QaAutoFlt qaAutoFlt = new QaAutoFlt();
						Short divFlag = 1;
					
						cusQaAutoFltModel.setDivFlag(divFlag);
						
						BeanCopyUtil.modelToEntity(qaAutoFlt, cusQaAutoFltModel);
						qaAutoFltDao.updateExcludeNull(qaAutoFlt);
					}
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			}		
		
		return null;	
	}
	
	//根据质控评分表QA_DIVIDE 中终末自动质控分数明细 ，计算自动质控分数
		public SingleResult<Amr> generateTerminalAutoScore() throws Exception {
			
			/*String statusStr = AmrStatus.WRITE_COMPLETED;//书写已完成
			String curDeptId = "";*/
			String qaTypeCode = "QAM13.06";
			
			List<MrAmr> mrAmrList = cusQaAutoDao.selectQaAutoMrAmrByCondition();
			for(MrAmr mrAmr : mrAmrList){
				String enPk = mrAmr.getEnPk();
				SingleResult<Amr> amrResult = qaScoreService.score(enPk, qaTypeCode, "");
				if(amrResult != null){
					Amr amrScore = amrResult.getData();
					mrAmr.setQaAutoScr(amrScore.getScore());
					mrAmrDao.updateExcludeNull(mrAmr);
				}
				
			}
			
					
			
			return null;	
		}
}
