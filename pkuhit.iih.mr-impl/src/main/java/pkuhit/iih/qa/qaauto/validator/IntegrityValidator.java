package pkuhit.iih.qa.qaauto.validator;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.qaauto.validator.baseValidator.BaseIntegrity;
import pkuhit.xap.ac.Session;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataModel;
import xap.ru.engin.data.SearchResult;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.ru.engin.validate.Validator;


public class IntegrityValidator extends BaseIntegrity implements Validator{

	//完整性质控
	@Override
	@SuppressWarnings("unchecked")
	public  void validate(DataModel dataModel,ItemEvent itemEvent) throws Exception {
		
		//校验结果保存到list
		List<QaValidateModel> qaValidateModelList = new ArrayList<QaValidateModel>();
		
		
		String[] msgAttr = new String[2];
		msgAttr[0] = "";
		msgAttr[1] = "";
		QaValidateMsgModel qaValidateMsg = new QaValidateMsgModel();
		qaValidateMsg.setMsgName("");
		qaValidateMsg.setMsgAttr(msgAttr);
		

		//获取itemEvent中的condition
		Condition condition = itemEvent.getCondition();
		Map<String, Object> searchCondition = null;
		//质控的文书类型
		String mrTypeCode = "";
		String eventTypeCode = "";
		String jobTitleCd = "";
		String enPk = "";
		String haveSession = "true";
		
		if(condition != null){
			searchCondition = condition.getSearchCondition();
		}
		if(searchCondition != null){
			mrTypeCode = searchCondition.get("mrTypeCode") != null ? searchCondition.get("mrTypeCode").toString() : "";
			eventTypeCode = searchCondition.get("eventTypeCode") != null ? searchCondition.get("eventTypeCode").toString() : "";
			jobTitleCd = searchCondition.get("jobTitleCd") != null ? searchCondition.get("jobTitleCd").toString() : "";
			enPk = searchCondition.get("enPk") !=null ? searchCondition.get("enPk").toString() : "";
			haveSession = searchCondition.get("haveSession") !=null ? searchCondition.get("haveSession").toString() : "true";
		}
		
		String mrKey = "";
		String emrEventKey = "";
		if(haveSession.equals("true")){
			Session session = Session.get();
			String curDeptId = session.getDeptId();
			mrKey = curDeptId+"_mr_"+enPk;
			emrEventKey = curDeptId+"_emrEvent_"+enPk;
		}else{ //预生成缺陷没有session，使用此key
			String qaWay= "preFltQa";
			mrKey = qaWay+"_mr_"+enPk;
			emrEventKey = qaWay+"_emrEvent_"+enPk;
		}
		//获得患者病历文书
		SearchResult<QaAutoModel> searchResult =  (SearchResult<QaAutoModel>) dataModel.getSearchResult(mrKey);
		List<QaAutoModel> qaAutoMrModelList = null;
		if(null!=searchResult){
			
			qaAutoMrModelList = searchResult.getResultList();
		}
		List<QaAutoModel> qaAutoHaveTypeMrList = null;//存放过滤出的需校验的文书列表
		//获得所有该患者的事件
		List<EmrEventModel> emrEventList = null;
		SearchResult<EmrEventModel> emrEventSearchResult =  (SearchResult<EmrEventModel>) dataModel.getSearchResult(emrEventKey);
		if(null!=emrEventSearchResult){
			
			emrEventList = emrEventSearchResult.getResultList();
		}
/*		EmrEventModel emrEventModel = null;
		if(emrEventList != null && emrEventList.size() > 0){
			amr = amrList.get(0);
		}*/
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		Timestamp bizTime = null;
		Date deadDate = null;
		//以下为判断流程
		
		//1、从emrEventList中获取校验所需的事件
		
		Map<String, List> eventTimeMap = getEventTimeMap(emrEventList, eventTypeCode);//(emrEventList, eventTypeCode, deadHours, qaValidateMsg);
		
		//2、如果eventTimeMap有值，则判断有没有校验所需的文书
		if(eventTimeMap.size()>0){
			qaValidateModel = validateHaveTypeMr(qaAutoMrModelList, mrTypeCode, qaValidateMsg);//(qaAutoMrModelList,mrTypeCode,deadHours,qaValidateMsg);
			if(!qaValidateModel.isValidateResult()){
				qaValidateModelList.add(qaValidateModel);
			}
			//根据当前质控项的事件类型从事件List中得到该事件发生的事件
			Timestamp eventTime = null;
			eventTime = getEventTime(emrEventList, eventTypeCode);
			qaValidateModel.setBizTime(eventTime);//业务时间
		}else if(!eventTypeCode.equals("01")){
			qaValidateModel.setValidateResult(true);
			if(qaValidateModelList.size()==0){
				
				qaValidateModelList.add(qaValidateModel);
			}
		}else{
			qaValidateModel.setValidateResult(false);
			if(qaValidateModelList.size()==0){
				
				qaValidateModelList.add(qaValidateModel);
			}
		}
		//判断医师职称
			if(qaValidateModelList.size()==0){
				if(eventTypeCode.equals("07")){
					//3、存在mrTypeCode类型的文书，校验文书是否符合要求
					qaAutoHaveTypeMrList = qaValidateModel.getTempResultMap().get(mrTypeCode);
					if(null != jobTitleCd){
						qaValidateModel = validateMrList(eventTimeMap,eventTypeCode,qaAutoMrModelList,mrTypeCode,jobTitleCd, qaValidateMsg);
					}
					qaValidateModelList.add(qaValidateModel);
				}else{
					qaValidateModelList.add(qaValidateModel);
				}
			}
		
		
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
		validateResult.setKey("InrecordQaResult");
		validateResult.setResultList(qaValidateModelList);
		dataModel.putValidateResult("InrecordQa", validateResult);
	
	}

}
