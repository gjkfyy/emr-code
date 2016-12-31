package pkuhit.iih.qa.qaauto.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.qaauto.validator.baseValidator.BaseTimeBound;
import pkuhit.iih.qa.qaauto.validator.baseValidator.CommonTimeBoundValidator;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataModel;
import xap.ru.engin.data.SearchResult;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.validate.ValidateResult;
import xap.ru.engin.validate.Validator;

/**
 * 由于抽取了该类质控项的公共校验类,所以该类暂时不启用
 * @deprecated
 * @author wang_yanli
 *
 */
public class InRecordTimeBoundValidator extends BaseTimeBound implements Validator{

	@Override
	@SuppressWarnings("unchecked")
	public  void validate(DataModel dataModel,ItemEvent itemEvent) throws Exception {
		
		//校验结果保存到list
		List<QaValidateModel> qaValidateModelList = new ArrayList<QaValidateModel>();
		
		
		String[] msgAttr = new String[2];
		msgAttr[0] = "入科时间";
		msgAttr[1] = "入院记录提交时间";
		QaValidateMsgModel qaValidateMsg = new QaValidateMsgModel();
		qaValidateMsg.setMsgName("入院记录");
		qaValidateMsg.setMsgAttr(msgAttr);
		
		int deadHours = 24;
		
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
		CommonTimeBoundValidator commonTBValidator = new CommonTimeBoundValidator();
		//commonTBValidator.validateMrTimeBound(dataModel, itemEvent, qaValidateModelList, deadHours, qaValidateMsg);
		
		validateResult.setKey("InrecordQaResult");
		validateResult.setResultList(qaValidateModelList);
		dataModel.putValidateResult("InrecordQa", validateResult);
	
	}


}
