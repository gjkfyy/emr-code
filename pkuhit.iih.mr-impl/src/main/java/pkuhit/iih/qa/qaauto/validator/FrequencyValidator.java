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
import pkuhit.iih.qa.qaauto.validator.baseValidator.BaseFrequency;
import pkuhit.iih.qa.util.QaUtil;
import pkuhit.xap.ac.Session;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataModel;
import xap.ru.engin.data.SearchResult;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.ru.engin.validate.Validator;


public class FrequencyValidator extends BaseFrequency implements Validator{

	//频率性质控
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
		String qaRlCd = "";//频率质控，质控规则
		String qaRlTpCd = "";//连续、重复
		String enPk = "";
		String haveSession = "true";
		
		if(condition != null){
			searchCondition = condition.getSearchCondition();
		}
		if(searchCondition != null){
			mrTypeCode = searchCondition.get("mrTypeCode") != null ? searchCondition.get("mrTypeCode").toString() : "";
			eventTypeCode = searchCondition.get("eventTypeCode") != null ? searchCondition.get("eventTypeCode").toString() : "";
			qaRlCd = searchCondition.get("qaRlCd") != null ? searchCondition.get("qaRlCd").toString() : "";
			qaRlTpCd = searchCondition.get("qaRlTpCd") != null ? searchCondition.get("qaRlTpCd").toString() : "";
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
				qaValidateModel.setValidateType(qaValidateModel.vaNoRecord);
			}
			
		}else if(null != eventTypeCode && eventTypeCode.equals("01")){
			qaValidateModel.setValidateResult(false);
			qaValidateModel.setValidateType(qaValidateModel.vaNoParam);
			if(qaValidateModelList.size()==0){
				qaValidateModelList.add(qaValidateModel);
			}
		}else{
			qaValidateModel.setValidateResult(true);
			if(qaValidateModelList.size()==0){
				qaValidateModelList.add(qaValidateModel);
			}
		}
		
		if(qaValidateModelList.size()==0){
			//3、存在mrTypeCode类型的文书，校验文书是否符合要求
			qaAutoHaveTypeMrList = qaValidateModel.getTempResultMap().get(mrTypeCode);
			qaValidateModel = validateMrList(eventTimeMap,eventTypeCode, qaAutoHaveTypeMrList, mrTypeCode,qaRlTpCd, qaRlCd, qaValidateMsg);
			qaValidateModelList.add(qaValidateModel);
			if(!qaValidateModel.isValidateResult()){
				qaValidateModel.setValidateType(qaValidateModel.vaNoRecord);//表示有记录但没有完全符合要求
			}
		}
		
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
		validateResult.setKey("InrecordQaResult");
		validateResult.setResultList(qaValidateModelList);
		dataModel.putValidateResult("InrecordQa", validateResult);
	
	}

}
