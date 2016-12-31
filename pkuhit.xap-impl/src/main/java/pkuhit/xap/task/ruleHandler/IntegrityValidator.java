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
import pkuhit.xap.ac.Session;
import pkuhit.xap.task.ruleHandler.baseValidator.BaseIntegrity;
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
		EmrEventModel emrEventModel= null;
		String mrTypeCode = "";
		String eventTypeCode = "";
		String jobTitleCd = "";
		String enPk = "";
		
		if(condition != null){
			searchCondition = condition.getSearchCondition();
		}
		if(searchCondition != null){
			emrEventModel = (EmrEventModel)searchCondition.get("emrEventModel");
			mrTypeCode = searchCondition.get("mrTypeCode") != null ? searchCondition.get("mrTypeCode").toString() : "";
			eventTypeCode = searchCondition.get("eventTypeCode") != null ? searchCondition.get("eventTypeCode").toString() : "";
			jobTitleCd = searchCondition.get("jobTitleCd") != null ? searchCondition.get("jobTitleCd").toString() : "";
			enPk = searchCondition.get("enPk") !=null ? searchCondition.get("enPk").toString() : "";
		}
		
			
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		Timestamp bizTime = null;
		Date deadDate = null;
		
		//以下为判断流程
		
		qaValidateModel.setMrType(mrTypeCode);
		bizTime = emrEventModel.getHappentime();
		qaValidateModel.setBizTime(bizTime);

		qaValidateModelList.add(qaValidateModel);
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
			
		validateResult.setKey("InrecordQaResult");
		validateResult.setResultList(qaValidateModelList);
		dataModel.putValidateResult("InrecordQa", validateResult);
	
	}

}
