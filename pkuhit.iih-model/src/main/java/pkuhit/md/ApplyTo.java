package pkuhit.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ApplyTo extends BaseMasterModel {
 public ApplyTo(){
  super();
 }
 public ApplyTo(String code){
  super(code);
 }
public static final String   OBJ_CD  = "MDM12";
// 全院
public static final String HOSPITAL_WIDE = "MDM12.01";
// 科室
public static final String DEPARTMENT = "MDM12.02";
// 个人
public static final String PERSONAL = "MDM12.03";


}