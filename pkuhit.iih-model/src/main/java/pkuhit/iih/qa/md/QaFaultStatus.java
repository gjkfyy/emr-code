package pkuhit.iih.qa.md;
import xap.model.BaseMasterModel;
public class QaFaultStatus extends BaseMasterModel {
 public QaFaultStatus(){
  super();
 }
 public QaFaultStatus(String code){
  super(code);
 }
public static final String   OBJ_CD  = "QAM01";
 // 新建
public static final String CREATED = "QAM01.01";
// 已提出
public static final String SUBMITTED = "QAM01.02";
// 已整改
public static final String REFORMED = "QAM01.03";
// 已审核
public static final String VERIFIED = "QAM01.04";

}