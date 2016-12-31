package pkuhit.iih.mr.md;
import xap.model.BaseMasterModel;

public class MrTemplateStatus extends BaseMasterModel {
 public MrTemplateStatus(){
  super();
 }
 public MrTemplateStatus(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "MRM07";
 // 新建
public static final String CREATED = "MRM07.01";
// 已提交
public static final String SUBMITTED = "MRM07.02";
// 已驳回
public static final String REJECTED = "MRM07.03";
// 已审批
public static final String REVIEWED = "MRM07.04";
// 已启用
public static final String ACTIVED = "MRM07.05";
// 已停用
public static final String STOPPED = "MRM07.06";
}