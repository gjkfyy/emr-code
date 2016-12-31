package pkuhit.iih.qa.qaauto.old;

import java.util.List;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.qaauto.QaTimeBoundService;

//上级医师查房记录
public class UpDoctorFirstRecoredTBServiceImpl extends BaseTimeBound implements QaTimeBoundService{

	/**
	 * 1、mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
	 * 2、文书的提交时间为逻辑提交时间LGC_SMT_TIME
	 * 3、文书类型mrTypeCode="MRM16.19"
	 */
	@Override
	public QaValidateModel autoQaItemForFault(List<QaAutoModel> qaAutoMrModelList, Amr amr)
			throws Exception {
		
		String[] msgAttr = new String[2];
		msgAttr[0] = "";
		msgAttr[1] = "";
		QaValidateMsgModel qaValidateMsg = new QaValidateMsgModel();
		qaValidateMsg.setMsgName("上级医师查房记录");
		qaValidateMsg.setMsgAttr(msgAttr);
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		int deadHours = 48;
		String mrTypeCode = "MRM16.19";
		
		//调用父类中的方法，判断入科时间+deadHours compareto 当前系统时间
		qaValidateModel = validateCurrentAndDeptIntoTime(amr,deadHours,qaValidateMsg);
		
		//1、如果返回true，说明   入科时间+deadHours>当前时间，不需要继续判断
		//2、如果返回false，则判断是否为QaValidateModel.vaNoParam，如果是，则说明无入科时间，不需要后续判断
		if(qaValidateModel.isValidateResult() || qaValidateModel.getValidateType().equals(QaValidateModel.vaNoParam)){
			return qaValidateModel;
		}

		//根据返回的文书记录，判断此类文书的缺陷
		qaValidateModel = validateMrList(qaAutoMrModelList,mrTypeCode,deadHours,qaValidateMsg);
		
		return qaValidateModel;
	
	}

	@Override
	public QaValidateModel autoQaItemForMessage(List<QaAutoModel> qaAutoMrModelList,Amr amr)
			throws Exception {
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		String[] msgAttr = new String[2];
		msgAttr[0] = "上级医师查房记录";
		msgAttr[1] = "上级医师查房记录提交时间";
		QaValidateMsgModel qaValidateMsg = new QaValidateMsgModel();
		qaValidateMsg.setMsgName("上级医师查房记录");
		qaValidateMsg.setMsgAttr(msgAttr);
		int deadHours = 48;
		String mrTypeCode = "MRM16.19";
		qaValidateModel = validateUnWriteMr(qaAutoMrModelList,amr,mrTypeCode,deadHours,qaValidateMsg);
		qaValidateModel.setQaItem("上级医师首次查房记录在患者入院后48小时内完成");
		qaValidateModel.setMrType("上级医师首次查房记录");
		if(null!=qaValidateModel.getValidateType() && qaValidateModel.getValidateType().equals(QaValidateModel.vaMesgCorrect)){
			qaValidateModel.setValidateResult(false);
		}else{
			qaValidateModel.setValidateResult(true);
		}
		return qaValidateModel;
	
	}

}
