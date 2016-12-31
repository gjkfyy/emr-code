package pkuhit.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class OwnerType extends BaseMasterModel {
 public OwnerType(){
  super();
 }
 public OwnerType(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "MDM08";// 全院
public static final String HOSPITAL_WIDE = "MDM08.01";
// 科室
public static final String DEPARTMENT = "MDM08.02";
// 个人
public static final String PERSONAL = "MDM08.03";


}