package pkuhit.iih.qa.qaauto.validator;

import java.util.ArrayList;
import java.util.List;

import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.qaauto.validator.baseValidator.BaseTimeBound;
import pkuhit.iih.qa.qaauto.validator.baseValidator.CommonTimeBoundValidator;
import xap.ru.engin.data.DataModel;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.ru.engin.validate.Validator;

/**
 * 由于抽取了该类质控项的公共校验类,所以该类暂时不启用
 * @deprecated
 * @author wang_yanli
 *
 */
public class FirstDiseaseRecordTBValidator extends BaseTimeBound implements Validator{

	/**
	 * 1、mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
	 * 2、文书的提交时间为逻辑提交时间LGC_SMT_TIME
	 * 3、文书类型mrTypeCode="MRM16.17"
	 * @deprecated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public  void validate(DataModel dataModel,ItemEvent itemEvent) throws Exception{
		String[] msgAttr = new String[2];
		msgAttr[0] = "首次病程";
		msgAttr[1] = "首次病程提交时间";
		QaValidateMsgModel qaValidateMsg = new QaValidateMsgModel();
		qaValidateMsg.setMsgName("首次病程");
		qaValidateMsg.setMsgAttr(msgAttr);
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		int deadHours = 8;
		
		//校验结果保存到list
		List<QaValidateModel> qaValidateModelList = new ArrayList<QaValidateModel>();
		CommonTimeBoundValidator commonTBValidator = new CommonTimeBoundValidator();
		//commonTBValidator.validateMrTimeBound(dataModel, itemEvent, qaValidateModelList, deadHours, qaValidateMsg);
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
		validateResult.setKey("firstDiseaseRecordQaResult");
		validateResult.setResultList(qaValidateModelList);
		dataModel.putValidateResult("firstDiseaseQa", validateResult);
	
	}

}
