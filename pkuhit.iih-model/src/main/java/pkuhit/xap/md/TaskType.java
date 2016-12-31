package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class TaskType extends BaseMasterModel {
 public TaskType(){
  super();
 }
 public TaskType(String code){
  super(code);
 }
// 病历整改任务
public static final String MR_REFORM_TASK = "XAPM04.01";


}