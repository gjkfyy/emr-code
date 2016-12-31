package pkuhit.iih.qa.md;
import xap.model.BaseMasterModel;
public class QaStaus extends BaseMasterModel {
 public QaStaus(){
  super();
 }
 public QaStaus(String code){
  super(code);
 }

public static final String   OBJ_CD  = "QAM04";
// 终末质控已开始
public static final String QA_STARTED = "QAM04.01";
// 整改要求已发送
public static final String REFORM_FAULT_SUBMITTED = "QAM04.02";
// 整改要求已接收
public static final String REFORM_FAULT_RECEIVED_ = "QAM04.03";
// 整改已完成
public static final String REFORM_FAULT__COMPLETED = "QAM04.04";
// 终末质控已完成
public static final String QA_COMPLETED = "QAM04.05";


}