package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class UserStatus extends BaseMasterModel {
 public UserStatus(){
  super();
 }
 public UserStatus(String code){
  super(code);
 }
// 启用
public static final String ACTIVED = "XAPM01.01";
// 停用
public static final String STOPPED = "XAPM01.02";
// 未启用
public static final String NO_ACTIVED = "XAPM01.03";


}