package pkuhit.iih.qa.md;

import xap.model.BaseMasterModel;

public class QaRevisionNoticeStatus extends BaseMasterModel {

	 public QaRevisionNoticeStatus(){

	  super();

	 }

	 public QaRevisionNoticeStatus(String code){

	  super(code);

	 }


	public static final String   OBJ_CD  = "QAM11";
	 
	//待整改
	public static final String TOREFORM = "QAM11.01";
	
	//整改中
	public static final String REFORMING = "QAM11.02";
	
	//已整改
	public static final String REFORMED = "QAM11.03";
	
	//已审核
	public static final String VERIFIED = "QAM11.04";
}
