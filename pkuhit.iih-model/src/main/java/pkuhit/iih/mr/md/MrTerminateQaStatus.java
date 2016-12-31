package pkuhit.iih.mr.md;

import xap.model.BaseMasterModel;

// 终末质控状态
public class MrTerminateQaStatus extends BaseMasterModel {
	
	public static final String STARTED = "TQS.01";
	public static final String REFORM_SENT = "TQS.02";
	public static final String REFORM_RECEIVED = "TQS.03";
	public static final String REFORMED = "TQS.04";
	public static final String COMPLETED = "TQS.05";
}
