package pkuhit.iih.en.md;
import xap.model.BaseMasterModel;

public class IllStatus extends BaseMasterModel {
 public IllStatus(){
  super();
 }
 public IllStatus(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "ENM05";// 病危
public static final String DANGER_ILL = "ENM05.01";
// 病重
public static final String SERIOUSLY_ILL = "ENM05.02";
// 一般
public static final String NORMAL_ILL = "ENM05.03";
// 手术
public static final String SURGERY = "ENM05.04";


}