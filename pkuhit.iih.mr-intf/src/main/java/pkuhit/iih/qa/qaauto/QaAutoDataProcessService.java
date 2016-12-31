package pkuhit.iih.qa.qaauto;

import java.util.List;
import java.util.Map;

import pkuhit.iih.qa.CusQaAutoFltModel;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.QaValidateModel;
/**
 * 
 * @author wang_yanli
 *
 */
public interface QaAutoDataProcessService {

	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	void batchDeleteDivide(String enPk) throws Exception;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	List<QaItem>  qaItems(String qaType) throws Exception;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	Map  qaValidateMap(String qaType) throws Exception;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	void saveQaDivide(QaValidateModel qaValidateModel, String qaItemCode,String enPk,String qaAutoTypeCode,String qaItmTpCd) throws Exception;
	
	/**
	 * @param  根据校验结果产生自动质控缺陷（将预生成的缺陷fltFlag=1）
	 *           
	 * @return 产生缺陷
	 * @throws Exception
	 */
	public void updateQaAutoFlt(CusQaAutoFltModel cusQaAutoFltModel, QaValidateModel qaValidateModel, String qaItemCode, String enPk, String qaAutoTypeCode,String qaItmTpCd) throws Exception;


	
}
