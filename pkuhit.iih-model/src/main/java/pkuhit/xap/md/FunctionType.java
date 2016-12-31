package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class FunctionType extends BaseMasterModel {
 public FunctionType(){
  super();
 }
 public FunctionType(String code){
  super(code);
 }
// 画面功能
public static final String ONLINE = "ON";
// 接口功能
public static final String INTERFACE = "IF";
// 批处理功能
public static final String BATCH = "BATCH";
// 报表功能
public static final String REPORT = "RP";
// 门户组件
public static final String PORTLET = "PL";


}