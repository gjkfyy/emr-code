package pkuhit.iih.mr.md;
import xap.model.BaseMasterModel;
public class MrGroupElementStatus extends BaseMasterModel {
 public MrGroupElementStatus(){
  super();
 }
 public MrGroupElementStatus(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "MRM05";

//新建
public static final String CREATED = "MRM05.01";
//已提交
public static final String SUBMITTED = "MRM05.02";
//已驳回
public static final String REJECTED = "MRM05.03";
//已审批
//public static final String REVIEWED = "MRM05.04";
//已启用
public static final String ACTIVED = "MRM05.05";
//已停用
public static final String STOPPED = "MRM05.06";


}