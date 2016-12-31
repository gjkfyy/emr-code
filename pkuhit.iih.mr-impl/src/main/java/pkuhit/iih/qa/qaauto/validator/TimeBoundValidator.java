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
import pkuhit.iih.qa.qaauto.validator.baseValidator.BaseTimeBound;
import pkuhit.iih.qa.util.QaUtil;
import pkuhit.xap.ac.Session;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataModel;
import xap.ru.engin.data.SearchResult;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.ru.engin.validate.Validator;


public class TimeBoundValidator extends BaseTimeBound implements Validator{

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
		String mrOpType = "";
		int deadHours = 0;
		String enPk = "";
		String haveSession = "true";
		
		if(condition != null){
			searchCondition = condition.getSearchCondition();
		}
		if(searchCondition != null){
			mrTypeCode = searchCondition.get("mrTypeCode") != null ? searchCondition.get("mrTypeCode").toString() : "";
			if(null != searchCondition.get("deadHours")){
				deadHours = Integer.parseInt(searchCondition.get("deadHours").toString());
			}
			eventTypeCode = searchCondition.get("eventTypeCode") != null ? searchCondition.get("eventTypeCode").toString() : "";
			mrOpType = searchCondition.get("mrOpType") != null ? searchCondition.get("mrOpType").toString() : "";
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
		
		//1、调用父类中的方法，判断事件时间+deadHours compareto 当前系统时间
		
		qaValidateModel = validateCurrentAndEventTime(emrEventList, eventTypeCode, deadHours, qaValidateMsg);
		
		//根据业务时间，计算出文书的截止时间
		bizTime = qaValidateModel.getBizTime();
		if(null != bizTime){
			deadDate = QaUtil.dateIncreaseByHours(bizTime, deadHours);
		}
		
		//a、如果返回true，说明   【入科时间】+deadHours>当前时间，不需要继续判断
		//b、如果返回false，则判断是否为QaValidateModel.vaNoParam，如果是，则说明无入科时间，不需要后续判断
		if(qaValidateModel.isValidateResult() || qaValidateModel.getValidateType().equals(QaValidateModel.vaNoParam)){
			qaValidateModelList.add(qaValidateModel);
		}

		if(qaValidateModelList.size()==0){
			//2、根据返回的文书记录，判断是否存mrTypeCode类型的文书,如果不存在，则不需要继续判断
			qaValidateModel = validateHaveTypeMr(qaAutoMrModelList, mrTypeCode, qaValidateMsg);//(qaAutoMrModelList,mrTypeCode,deadHours,qaValidateMsg);
			if(!qaValidateModel.isValidateResult()){
				qaValidateModel.setValidateType(QaValidateModel.vaNoRecord);
				qaValidateModelList.add(qaValidateModel);
			}
		}
		if(qaValidateModelList.size()==0){
			//3、存在mrTypeCode类型的文书，校验文书是否符合要求
			qaAutoHaveTypeMrList = qaValidateModel.getTempResultMap().get(mrTypeCode);
			qaValidateModel = validateMrList(emrEventList,eventTypeCode, qaAutoHaveTypeMrList, mrTypeCode,mrOpType, deadHours, qaValidateMsg);
			qaValidateModelList.add(qaValidateModel);
		}
		qaValidateModel.setBizTime(bizTime);
		if(null != deadDate){
			qaValidateModel.setDeadDate(new Timestamp(deadDate.getTime()));
		}
		
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
		/*CommonTimeBoundValidator commonTBValidator = new CommonTimeBoundValidator();
		commonTBValidator.validateMrTimeBound(dataModel, itemEvent, qaValidateModelList, deadHours, qaValidateMsg);
	*/	
		validateResult.setKey("InrecordQaResult");
		validateResult.setResultList(qaValidateModelList);
		dataModel.putValidateResult("InrecordQa", validateResult);
	
	}


}
