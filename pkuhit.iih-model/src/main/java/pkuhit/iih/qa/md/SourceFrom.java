package pkuhit.iih.qa.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class SourceFrom extends BaseMasterModel {
 public SourceFrom(){
  super();
 }
 public SourceFrom(String code){
  super(code);
 }
// 环节质控
public static final String IN_PROCESS_QA = "QAM05.01";
// 终末质控
public static final String TERMINAL_QA = "QAM05.02";
// 自动质控
public static final String AUTO_QA = "QAM05.03";


}