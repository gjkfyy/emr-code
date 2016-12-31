package pkuhit.xap.task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapMessageDao;
import pkuhit.xap.dao.auto.XapTaskDao;
import pkuhit.xap.dao.auto.entity.XapMessage;
import pkuhit.xap.dao.auto.entity.XapTask;
import pkuhit.xap.dao.custom.CustomXapMessageDao;
import pkuhit.xap.dao.custom.CutomXapMrTaskDao;
import pkuhit.xap.mes.Message;
import pkuhit.xap.mes.MessageService;
import pkuhit.xap.ru.RuleEnginService;
import pkuhit.xap.task.cache.Cache;
import pkuhit.xap.task.cache.CacheManager;
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

  
public  class MrTaskServiceImpl implements EventListener{
  
/*	@Autowired
	XapTaskDao xapTaskDao;*/
	
	@Autowired
	CutomXapMrTaskDao cutomXapMrTaskDao;
	
	@Autowired
	CustomXapMessageDao customXapMessageDao;
	
	@Autowired
	XapMessageDao xapMessageDao;
	
	@Autowired
	XapTaskDao xapTaskDao;
	
	@Reference
	DictionaryService  dictionaryService;
	
	@Reference
	RuleEngin ruleEngin;
	
	@Reference
	RuleEnginService ruleEnginService;
	
	@Reference
	MessageService messageService;

	@Override
	public void callBack(EventObject arg0) {
		// TODO Auto-generated method stub
		EmrEventModel emrEventModel = (EmrEventModel)arg0.getSource();
		try {
			taskRuleHandler(emrEventModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void taskRuleHandler(EmrEventModel emrEventModel) throws Exception{
		String eventTypeCode = emrEventModel.getEventtype();
		String enPk = emrEventModel.getEncId().toString();
		/*Map conditionMap = new HashMap();
		conditionMap.put("eventTypeCode", eventTypeCode);
		ArrayResult<CusXapTaskTypeModel>  QaAutoItmConfigArrayResult = searchXapTaskType(conditionMap);*/
		//从缓存中取出事件对应的任务类型
		CusXapTaskTypeModel[] cusXapTaskTypeModelArray = simpleCache(eventTypeCode);
		
		List<Item<QaItem>> validateList = initValidateList(cusXapTaskTypeModelArray,enPk,emrEventModel);
		saveTask(validateList);
		
		//return null;
	}

	//查询事件类型
	public ArrayResult<CusXapTaskTypeModel> searchXapTaskType(Map condition)
			throws Exception {
		String eventTypeCode = "";
		if(null != condition){
			eventTypeCode = (String)condition.get("eventTypeCode");
		}
		ArrayResultBuilder<CusXapTaskTypeModel> arrayBuilder = ArrayResultBuilder.newArrayResult(CusXapTaskTypeModel.class);
		List<Map<String, Object>> cusXapTaskTypeModelList = null;
		Map<String, Object> mapXapTaskType = null;
		
		cusXapTaskTypeModelList = cutomXapMrTaskDao.searchTaskTypesByCondition(eventTypeCode);
		if(null != cusXapTaskTypeModelList && cusXapTaskTypeModelList.size()>0){
			
			CusXapTaskTypeModel[] cusXapTaskTypeModelArray = new CusXapTaskTypeModel[cusXapTaskTypeModelList.size()];
			for(int i=0;i<cusXapTaskTypeModelList.size();i++){
				CusXapTaskTypeModel cusXapTaskTypeModel = new CusXapTaskTypeModel();
				mapXapTaskType = cusXapTaskTypeModelList.get(i);
				BeanCopyUtil.mapToModel(cusXapTaskTypeModel, mapXapTaskType,dictionaryService);
				cusXapTaskTypeModelArray[i] = cusXapTaskTypeModel;
			}
			if(cusXapTaskTypeModelArray!=null){
				arrayBuilder.withData(cusXapTaskTypeModelArray);
			}
			
		}
		ArrayResult<CusXapTaskTypeModel> cusXapTaskTypeResult = arrayBuilder.build();
		return cusXapTaskTypeResult;
	}

	//初始化校验数据
	public List<Item<QaItem>> initValidateList(CusXapTaskTypeModel[] cusXapTaskTypeModelArray,String enPk,EmrEventModel emrEventModel)throws Exception{
		List<Item<QaItem>> list = (List<Item<QaItem>>) getListByEventCode("QAM18.02");
		List<Item<QaItem>> rsList =  new ArrayList<Item<QaItem>>();
		if(list != null){
			for (int i=0; i<list.size();i++) {
				
				Item<QaItem> item = list.get(i);
//				System.out.println("i==================="+i+"item============"+item.getCode());
				//如果配置的List中存在不需要质控的项，则该质控项从list中移除
				if(null != cusXapTaskTypeModelArray){
					for(CusXapTaskTypeModel xapTaskTypeModel:cusXapTaskTypeModelArray){
						if(null != xapTaskTypeModel.getTaskTypeCd() && !xapTaskTypeModel.getTaskTypeCd().equals(item.getCode())){
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
										searchCondition.put("mrTypeCode", xapTaskTypeModel.getMdMrTpCd());
										searchCondition.put("deadHours", xapTaskTypeModel.getDeadHours());
										searchCondition.put("eventTypeCode", xapTaskTypeModel.getEventTypeCd());
										searchCondition.put("qaRlCd", xapTaskTypeModel.getQaRlCd());//频率质控，质控规则
										searchCondition.put("qaRlTpCd", xapTaskTypeModel.getQaRlTpCd());//连续、重复
										searchCondition.put("jobTitleCd", xapTaskTypeModel.getJobTitleCd()); //完整性 医师职称
										searchCondition.put("dctOpTpCd", xapTaskTypeModel.getDctOpTpCd()); //完整性 医师操作类型
										searchCondition.put("qaItmTpCd", xapTaskTypeModel.getQaItmTpCd()); //质控项目类别,主数据QAM06：时限性、频率性、完整性
										searchCondition.put("memo", xapTaskTypeModel.getMemo());//频率质控，质控规则
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
					          if(null != itemEvent && !itemEvent.getCode().equals("QAM18.02")){
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
	
	public void saveTask(List<Item<QaItem>> rsList){
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
						String memo = "";
						EmrEventModel emrEventModel = null;
						if(condition != null){
							searchCondition = condition.getSearchCondition();
							mrTypeCode = (String)searchCondition.get("mrTypeCode");
							qaItemCode = (String)searchCondition.get("qaItemCode");
							enPk = (String)searchCondition.get("enPk");
							memo = (String)searchCondition.get("memo"); //任务描述
							emrEventModel = (EmrEventModel)searchCondition.get("emrEventModel");
						}
						//质控项
						String qaItemCd = item.getCode();
						for(String keyResult :itemEvent.getQaValidateModelMap().keySet()){
							ValidateResult<QaValidateModel> qa = (ValidateResult<QaValidateModel>) itemEvent.getQaValidateModelMap().get(keyResult);
							if(qa.getResultList()!=null && qa.getResultList().size()>0){
						    	QaValidateModel qaValidateModel = qa.getResultList().get(0);
						    	if(null!=qaValidateModel && !qaValidateModel.isValidateResult()){
						    		XapTask xapTask = new XapTask();
						    		String taskId = UUIDGenerator.getUUID();
						    		xapTask.setTaskId(taskId);
						    		xapTask.setTaskTypeCd(qaItemCode);
						    		//xapTask.setDocSn(mrTypeCode);
						    		xapTask.setStatus(XapTaskModel.UNDEAL);//置任务状态为未处理
						    		xapTask.setEventId(emrEventModel.getEventtype());
						    		xapTask.setEncounterSn(enPk);
						    		xapTask.setMemo(memo);
						    		xapTask.setBeginTime(qaValidateModel.getBizTime());
						    		if(qaValidateModel.getDeadDate() != null){
						    			xapTask.setEndTime(qaValidateModel.getDeadDate());
						    		}
						    		xapTaskDao.insert(xapTask);
						    		
						    		// 生成消息  add by chengfeng 2016-07-18 begin
						    		Timestamp tm = new Timestamp(System.currentTimeMillis());
									Message msg = new Message();
									String msgContent = "请及时处理患者就诊号为"+enPk+"的任务【"+memo+"】";
									String msgPk = UUIDGenerator.getUUID();
									msg.setMesId(msgPk);
//									msg.setSendUserId(userId);//发送人-系统
									msg.setSendDate(tm);//发送时间
									String curMngDctId = customXapMessageDao.selectMngDocCdByEnpk(enPk);
									msg.setReceiveUserId(curMngDctId);//接收人 -- 主管医生
									msg.setReceiveDate(tm);
									msg.setPortalCd("XAPM06.02"); //Portal编码
									msg.setMenuCd("XAPM07.05"); //菜单编码
									msg.setContent(msgContent);
									msg.setReadFlag(0+""); //未读
									msg.setMesLevel((short)1); //级别 严重
									msg.setMesType("0");//质控消息
									msg.setTaskId(taskId);
							    	messageService.sendMessage(msg);
									// 生成消息  add by chengfeng 2016-07-18 end
								}
						    }
						}
					}
				}
			}
		}
	}

	//如果缓存中没有值则查询
	public CusXapTaskTypeModel[] simpleCache(String eventTypeCode){

		String eventKey = eventTypeCode;
		Cache eventTaskCache = CacheManager.getCacheInfo(eventKey);
		Map<String,CusXapTaskTypeModel[]> eventTaskMap = new HashMap<String,CusXapTaskTypeModel[]>();
		CusXapTaskTypeModel[] cusXapTaskTypeModelArray = null;
		if(null != eventTaskCache){
			eventTaskMap = (Map<String, CusXapTaskTypeModel[]>) eventTaskCache.getValue();
			cusXapTaskTypeModelArray = eventTaskMap.get(eventKey);
		}else{
			//查询出某事件类型对应的任务类型集合，存放在cache中
			Map conditionMap = new HashMap();
			conditionMap.put("eventTypeCode", eventTypeCode);
			ArrayResult<CusXapTaskTypeModel> QaAutoItmConfigArrayResult;
			try {
				
				QaAutoItmConfigArrayResult = searchXapTaskType(conditionMap);
			
			    cusXapTaskTypeModelArray = QaAutoItmConfigArrayResult.getDataList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eventTaskMap.put(eventKey, cusXapTaskTypeModelArray);
			eventTaskCache = new Cache(eventKey,eventTaskMap,0,false);
			CacheManager.putCache(eventKey, eventTaskCache);
		}
		
		return cusXapTaskTypeModelArray;
		
	
	}
	
	
}
