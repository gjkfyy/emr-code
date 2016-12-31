package pkuhit.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Sex extends BaseMasterModel {
 public Sex(){
  super();
 }
 public Sex(String code){
  super(code);
 }
// 未知
public static final String UNKNOWN = "MDM05.00";
// 男
public static final String MALE = "MDM05.01";
// 女
public static final String FEMALE = "MDM05.02";
// 不明
public static final String UNIDENTIFIED = "MDM05.99";


}