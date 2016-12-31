package pkuhit.iih.qa.qamrwite;

import java.util.Map;

import pkuhit.iih.qa.QaValidateModel;
import xap.ru.engin.validate.ValidateResult;

/**
 * 
 * @author wang_yanli
 *
 */
public interface QaMrTypeService {


	public ValidateResult<QaValidateModel> haveMrDocValidate(Map map)throws Throwable;
	
	
	
	
}
