package pkuhit.iih.qa.qaauto.old;

import java.util.List;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.qaauto.QaTimeBoundService;
import pkuhit.iih.qa.util.QaAutoUtil;

//未按规定记录病程记录
public class IllConditionRecoredTBServiceImpl implements QaTimeBoundService{

	@Override
	public QaValidateModel autoQaItemForFault(List<QaAutoModel> qaAutoMrModelList, Amr amr)
			throws Exception {
		
		String[] msgAttr = new String[2];
		msgAttr[0] = "";
		msgAttr[1] = "";
		QaValidateMsgModel qaValidateMsg = new QaValidateMsgModel();
		qaValidateMsg.setMsgName("未按规定记录病程记录");
		qaValidateMsg.setMsgAttr(msgAttr);
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		
		resultValue = QaAutoUtil.validateIllConditionRecored(qaAutoMrModelList);
		qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
	
	}

	@Override
	public QaValidateModel autoQaItemForMessage(List<QaAutoModel> qaAutoMrModelList,Amr amr)
			throws Exception {
		return null;
	}

}
