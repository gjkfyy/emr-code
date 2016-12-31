package pkuhit.iih.en.md;
import xap.model.BaseMasterModel;

public class NurseLevel extends BaseMasterModel {
 public NurseLevel(){
  super();
 }
 public NurseLevel(String code){
  super(code);
 }

public static final String   OBJ_CD  = "ENM04";// 特级护理
public static final String NURSE_GRADE_VIP = "ENM04.01";
// 一级护理
public static final String NURSE_GRADE_A = "ENM04.02";
// 二级护理
public static final String NURSE_GRADE_B = "ENM04.03";
// 三级护理
public static final String NURSE_GRADE_C = "ENM04.04";


}