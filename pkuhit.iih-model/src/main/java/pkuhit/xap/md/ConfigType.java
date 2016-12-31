package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ConfigType extends BaseMasterModel {
 public ConfigType(){
  super();
 }
 public ConfigType(String code){
  super(code);
 }
// 自由录入
public static final String FREE_INPUT = "XAPM02.01";
// 单选
public static final String RADIO = "XAPM02.02";
// 多选
public static final String CHOICE = "XAPM02.03";
// 范围
public static final String SCOPE = "XAPM02.04";


}