package pkuhit.iih.qa.md;
import xap.model.BaseMasterModel;

public class QaFaultConfirmResultStatus extends BaseMasterModel {
 public QaFaultConfirmResultStatus(){
  super();
 }
 public QaFaultConfirmResultStatus(String code){
  super(code);
 }

public static final String   OBJ_CD  = "QAM07";
// 未确认
public static final String UNCONFIRMED = "QAM07.01";
// 需整改
public static final String NEEDREFORM = "QAM07.02";
// 需扣分
public static final String NEETDROPSCORE = "QAM07.03";
// 不扣分
public static final String NONDROPSCORE = "QAM07.04";


}