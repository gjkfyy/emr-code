package pkuhit.iih.qa.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaItemType extends BaseMasterModel {
 public QaItemType(){
  super();
 }
 public QaItemType(String code){
  super(code);
 }
// 时限性
public static final String DEADLINE_TYPE = "QAM06.02";
// 内容性
public static final String CONTENT_TYPE = "QAM06.01";
// 依赖性
public static final String DEPENDENCE_TYPE = "QAM06.03";
// 完整性
public static final String WHOLENESS_TYPE = "QAM06.04";


}