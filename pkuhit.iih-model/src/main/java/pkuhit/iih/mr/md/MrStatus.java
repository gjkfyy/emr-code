package pkuhit.iih.mr.md;
import xap.sv.annotation.Column;
import xap.model.BaseMasterModel;

public class MrStatus extends BaseMasterModel {
 public MrStatus(){
  super();
 }
 public MrStatus(String code){
  super(code);
 }
//枚举常量
 public static final String   OBJ_CD  = "MRM04";
//新建
public final static String CREATED = "MRM04.01";
//已提交
public final static String SUBMITTED = "MRM04.02";
//已一级审签
//public final static String SIGNED_LEVEL_1 = "MRM04.03";
//二级审签中
public final static String SIGNED_LEVEL_2ING = "MRM04.03";
//已二级审签
public final static String SIGNED_LEVEL_2 = "MRM04.04";
//三级审签中
public final static String SIGNED_LEVEL_3ING = "MRM04.05";
//已三级审签
public final static String SIGNED_LEVEL_3 = "MRM04.06";
// 医疗记录状态
public static final   String  CODE = "MRM04.AT01";
// 审签级别编码
public static final   String  SIGN_LEVEL_CODE = "MRM04.AT02";
// 下一医疗记录状态编码
public static final   String  NEXT_MR_STATUS_CODE = "MRM04.AT03";
// 上一医疗记录状态编码
public static final   String  PRE_MR_STATUS_CODE = "MRM04.AT04";
// 名称
public static final   String  NAME = "MRM04.AT05";
// 描述
public static final   String  DESCRIPTION = "MRM04.AT06";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME = "MRM04.AT07";
// 英文名称
public static final   String  ENGLISH_NAME = "MRM04.AT08";

// 医疗记录状态
@Column(name="MR_STA_CD") 
private  String code;
// 审签级别编码
@Column(name="SIGN_LVL_CD") 
private  String signLevelCode;
// 下一医疗记录状态编码
@Column(name="NEXT_MR_STA_CD") 
private  String nextMrStatusCode;
// 上一医疗记录状态编码
@Column(name="PRE_MR_STA_CD") 
private  String preMrStatusCode;
// 名称
@Column(name="NM") 
private  String name;
// 描述
@Column(name="DES") 
private  String description;
// 英文简称
@Column(name="SHT_NM_EN") 
private  String shortEnglishName;
// 英文名称
@Column(name="NM_EN") 
private  String englishName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getSignLevelCode()
 {
     return this.signLevelCode;
 }
public  void  setSignLevelCode(String signLevelCode)
 {
  this.signLevelCode = signLevelCode;
 }
public String getNextMrStatusCode()
 {
     return this.nextMrStatusCode;
 }
public  void  setNextMrStatusCode(String nextMrStatusCode)
 {
  this.nextMrStatusCode = nextMrStatusCode;
 }
public String getPreMrStatusCode()
 {
     return this.preMrStatusCode;
 }
public  void  setPreMrStatusCode(String preMrStatusCode)
 {
  this.preMrStatusCode = preMrStatusCode;
 }
public String getName()
 {
     return this.name;
 }
public  void  setName(String name)
 {
  this.name = name;
 }
public String getDescription()
 {
     return this.description;
 }
public  void  setDescription(String description)
 {
  this.description = description;
 }
public String getShortEnglishName()
 {
     return this.shortEnglishName;
 }
public  void  setShortEnglishName(String shortEnglishName)
 {
  this.shortEnglishName = shortEnglishName;
 }
public String getEnglishName()
 {
     return this.englishName;
 }
public  void  setEnglishName(String englishName)
 {
  this.englishName = englishName;
 }

}