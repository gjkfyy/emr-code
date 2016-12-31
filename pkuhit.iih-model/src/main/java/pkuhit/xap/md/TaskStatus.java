package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class TaskStatus extends BaseMasterModel {
 public TaskStatus(){
  super();
 }
 public TaskStatus(String code){
  super(code);
 }
// 已发送
public static final String SENT = "XAPM05.01";
// 已接收
public static final String RECEIVED = "XAPM05.02";
// 已完成
public static final String COMPLETED = "XAPM05.03";


}