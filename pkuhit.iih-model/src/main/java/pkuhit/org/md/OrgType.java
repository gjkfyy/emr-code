package pkuhit.org.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class OrgType extends BaseMasterModel {
 public OrgType(){
  super();
 }
 public OrgType(String code){
  super(code);
 }
// 部门
public static final String DEPT = "ORGM01.04";
// 工作组
public static final String WORK_GROUP = "ORGM01.05";
// 集团
public static final String GROUP = "ORGM01.01";
// 院区
public static final String HOSPITAL = "ORGM01.02";
// 社区
public static final String COMMUNITY_HOSPITAL = "ORGM01.03";


}