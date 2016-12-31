package pkuhit.iih.qa.qaauto;

import java.util.List;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import xap.sv.model.ArrayResult;
/**
 * 
 * @author wang_yanli
 *
 */
public interface QaTimeBoundService {

	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现:质控项
	 * @throws Exception
	 */
	QaValidateModel autoQaItemForFault(List<QaAutoModel> qaAutoMrModelList,Amr amr) throws Exception;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现:消息提醒
	 * @throws Exception
	 */
	QaValidateModel autoQaItemForMessage(List<QaAutoModel> qaAutoMrModelList,Amr amr) throws Exception;
	

	
}
