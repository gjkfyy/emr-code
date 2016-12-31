package pkuhit.org.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class DeptType extends BaseMasterModel {
 public DeptType(){
  super();
 }
 public DeptType(String code){
  super(code);
 }
// 临床科室
public static final String CLINICAL_DEPARTMENT = "ORGM02.01";
// 医技科室
public static final String MEDICAL_LABORATORY = "ORGM02.02";
// 行政科室
public static final String ADMINISTRATIVE_DEPARTMENT = "ORGM02.03";
// 科研科室
public static final String SCIENTIFIC_RESEARCH_DEPARTMENT = "ORGM02.04";
// 病区
public static final String WARD = "ORGM02.05";
// 其他
public static final String OTHER = "ORGM02.06";


}