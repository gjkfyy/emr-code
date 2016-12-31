package pkuhit.iih.mr.md;
import xap.model.BaseMasterModel;
public class MrBaseTemplateStatus extends BaseMasterModel {
 public MrBaseTemplateStatus(){
  super();
 }
 public MrBaseTemplateStatus(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "MRM06";// 已停用
public static final String STOPED = "MRM06.03";
// 新建
public static final String CREATED = "MRM06.01";
// 已启用
public static final String ACTIVED = "MRM06.02";


}