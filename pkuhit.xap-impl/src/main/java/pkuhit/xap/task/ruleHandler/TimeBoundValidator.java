package pkuhit.xap.task.ruleHandler;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.xap.task.ruleHandler.baseValidator.BaseTimeBound;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataModel;
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
		EmrEventModel emrEventModel= null;
		String mrTypeCode = "";
		String eventTypeCode = "";
		int deadHours = 0;
		String enPk = ""; 
		
		if(condition != null){
			searchCondition = condition.getSearchCondition();
		}
		if(searchCondition != null){
			emrEventModel = (EmrEventModel)searchCondition.get("emrEventModel");
			mrTypeCode = searchCondition.get("mrTypeCode") != null ? searchCondition.get("mrTypeCode").toString() : "";
			if(null != searchCondition.get("deadHours")){
				deadHours = Integer.parseInt(searchCondition.get("deadHours").toString());
			}
			eventTypeCode = searchCondition.get("eventTypeCode") != null ? searchCondition.get("eventTypeCode").toString() : "";
			//mrOpType = searchCondition.get("mrOpType") != null ? searchCondition.get("mrOpType").toString() : "";
			enPk = searchCondition.get("enPk") !=null ? searchCondition.get("enPk").toString() : "";
		}
		
		/*Session session = Session.get();
		String curDeptId = session.getDeptId();
		String mrKey = curDeptId+"_mr_"+enPk;
		String emrEventKey = curDeptId+"_emrEvent_"+enPk;*/
		List<QaAutoModel> qaAutoMrModelList = null;
		
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		Timestamp bizTime = null;
		Date deadDate = null;
		//以下为判断流程
		
		qaValidateModel.setMrType(mrTypeCode);
		bizTime = emrEventModel.getHappentime();
		
		if(null != bizTime){
			deadDate = dateIncreaseByHours(bizTime, deadHours);
		}
		
		qaValidateModel.setBizTime(bizTime);
		if(null != deadDate){
			qaValidateModel.setDeadDate(new Timestamp(deadDate.getTime()));
		}
		qaValidateModelList.add(qaValidateModel);
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
			
		validateResult.setKey("InrecordQaResult");
		validateResult.setResultList(qaValidateModelList);
		dataModel.putValidateResult("InrecordQa", validateResult);
	
	}


}
