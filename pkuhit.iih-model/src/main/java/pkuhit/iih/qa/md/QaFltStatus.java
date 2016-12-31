package pkuhit.iih.qa.md;
import xap.model.BaseMasterModel;
public class QaFltStatus extends BaseMasterModel {
 public QaFltStatus(){
  super();
 }
 public QaFltStatus(String code){
  super(code);
 }


public static final String   OBJ_CD  = "QAM12";
 
//待整改
public static final String TOREFORM = "QAM12.01";
//已整改
public static final String REFORMED = "QAM12.02";
//审核通过
public static final String VERIFIED = "QAM12.03";
//扣分
public static final String DEDUCTIONED = "QAM12.04";

//质控类型-环节质控
public static final   String  QA_TY_CD_PROCESS = "QAM13.01";
//质控类型-科室质控
public static final   String  QA_TY_CD_DEPT = "QAM13.02";
//质控类型-终末质控
public static final   String  QA_TY_CD_TERMINAL = "QAM13.03";

//质控类型-自动环节质控
public static final   String  QA_TY_CD_AUTO_PROCESS = "QAM13.04";

//质控类型-自动科室质控
public static final   String  QA_TY_CD_AUTO_DEPT = "QAM13.05";

//质控类型-自动终末质控
public static final   String  QA_TY_CD_AUTO_TERMINAL = "QAM13.06";

//质控整改所在portalpublic static final   String  IIH_INP_FU_WK = "XAPM06.06";

//质控整改所在portal-护士
public static final   String  IIH_INP_FU_WK_NUR = "XAPM06.15";

//环节整改菜单
public static final   String  QA_RFM_MENU_PROCESS = "XAPM07.21";
//科室整改菜单
public static final   String  QA_RFM_MENU_DEPT = "XAPM07.49";
//终末整改菜单
public static final   String  QA_RFM_MENU_TERMINAL = "XAPM07.43";

//医嘱整改菜单
public static final   String  QA_RFM_MENU_ORDER = "XAPM07.115";

//质控类型-医嘱质控
public static final   String  QA_TY_CD_ORDER = "QAM13.07";

//环节整改菜单-护士
public static final   String  QA_RFM_MENU_PROCESS_NUR = "XAPM07.131";
//科室整改菜单-护士
public static final   String  QA_RFM_MENU_DEPT_NUR = "XAPM07.134";
//终末整改菜单-护士
public static final   String  QA_RFM_MENU_TERMINAL_NUR = "XAPM07.133";}