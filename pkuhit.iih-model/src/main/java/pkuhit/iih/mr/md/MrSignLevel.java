package pkuhit.iih.mr.md;
import xap.model.BaseMasterModel;

public class MrSignLevel extends BaseMasterModel {
 public MrSignLevel(){
  super();
 }
 public MrSignLevel(String code){
  super(code);
 }
public static final String   OBJ_CD  = "MRM02";// 无需审签
public static final String NEED_NOT_SIGN = "MRM02.01";
// 一级审签
public static final String LEVEL_ONE_SIGN = "MRM02.02";
// 二级审签
public static final String LEVEL_TWO_SIGN = "MRM02.03";
// 三级审签
public static final String LEVEL_THREE_SIGN = "MRM02.04";


}