package pkuhit.iih.qa.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaType extends BaseMasterModel {
 public QaType(){
  super();
 }
 public QaType(String code){
  super(code);
 }
// 环节质控
public static final String IN_PROCESS_QA = "QAM03.01";
// 终末质控
public static final String TERMINAL_QA = "QAM03.02";


}