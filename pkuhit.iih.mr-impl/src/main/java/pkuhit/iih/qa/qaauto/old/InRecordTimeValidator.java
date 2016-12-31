package pkuhit.iih.qa.qaauto.old;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.util.QaAutoUtil;
import xap.ru.engin.data.DataModel;
import xap.ru.engin.data.SearchResult;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.ru.engin.validate.Validator;


public class InRecordTimeValidator implements Validator{/**/

	@Override
	public  void validate(DataModel dataModel,ItemEvent itemEvent) {
		System.out.println("this is validator");
		String[] msgAttr = new String[2];
		msgAttr[0] = "入科时间";
		msgAttr[1] = "入院记录提交时间";
		QaValidateMsgModel qaValidateMsg = new QaValidateMsgModel();
		qaValidateMsg.setMsgName("入院记录");
		qaValidateMsg.setMsgAttr(msgAttr);
		// TODO Auto-generated method stub
		SearchResult<QaAutoModel> searchResult =  (SearchResult<QaAutoModel>) dataModel.getSearchResult("enMrList");
		List<QaAutoModel> qaAutoMrModelList = searchResult.getResultList();
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
			for(QaAutoModel qaAutoModel: qaAutoMrModelList){
				//1=判断有无入院记录
				if(!qaAutoModel.getTypeCode().equals("MRM16.13")){ //初次
					qaValidateModel.setValidateMessage("无入院记录");
					continue;
				}
				
				//2=判断时间
				//mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
				Timestamp curDeptIntoTime = qaAutoModel.getCurDeptIntoTime();//入科时间
				Date subDate = qaAutoModel.getSubmitDate();
				Timestamp subDateTs = new Timestamp(subDate.getTime());
				qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, subDateTs, 24,qaValidateMsg);
				if(!qaValidateModel.isValidateResult()){
					break;
				}
				
				//3=判断是否为时非职业医师      如果org_emp表中对应的job_title_cd是非职业医师，则返回false
				if(qaAutoModel.getJobTitleCd().equals("aa")){
					resultValue = false;
					qaValidateModel.setValidateMessage("非职业医师");
					break;
				}
				//如果程序可以走到这说明，需校验的3个条件都满足书写要求，故置resultValue=true
				resultValue = true;
				break;
				
			}
			qaValidateModel.setValidateResult(resultValue);
		}
		List<QaValidateModel> qaValidateModelList = new ArrayList();
		qaValidateModelList.add(qaValidateModel);
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
		validateResult.setKey("InrecordQaResult");
		validateResult.setResultList(qaValidateModelList);//.setResultList(qaAutoMrModelList);
		dataModel.putValidateResult("InrecordQa", validateResult);
	}


}
