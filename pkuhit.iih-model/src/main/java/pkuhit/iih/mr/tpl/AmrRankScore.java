package pkuhit.iih.mr.tpl;
import xap.model.BaseRelationModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class AmrRankScore extends BaseRelationModel {
 public AmrRankScore(){
  super();
 }
 public AmrRankScore(String code){
  super(code);
 }
public static final String   OBJ_CD  = "MRK08";

// 病案等级分数阶段编码
public static final   String  CODE = "MRK08.AT01";
// 病案等级编码
public static final   String  ARM_RANK_CODE = "MRK08.AT02";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "MRK08.AT03";
// 最大分值
public static final   String  MAX_SCORE = "MRK08.AT04";
// 最小分值
public static final   String  MIN_SCORE = "MRK08.AT05";

// 病案等级分数阶段编码
@Column(name="AMR_RANK_SCR_CD") 
private  String code;
// 病案等级编码
@Column(name="AMR_RANK_CD") 
private  String armRankCode;
// 组织机构编码
@Column(name="ORG_CD") 
private  String organizationCode;
// 最大分值
@Column(name="MAX_SCR") 
private  String maxScore;
// 最小分值
@Column(name="MIN_SCR") 
private  String minScore;
// 病案等级名称
@DictionaryTag(code = "armRankCode",objCd ="MRM10")
private  String armRankName;
// 组织机构名称
//@DictionaryTag(code = "organizationCode",objCd ="ORGB01")
private  String organizationName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getArmRankCode()
 {
     return this.armRankCode;
 }
public  void  setArmRankCode(String armRankCode)
 {
  this.armRankCode = armRankCode;
 }
public String getOrganizationCode()
 {
     return this.organizationCode;
 }
public  void  setOrganizationCode(String organizationCode)
 {
  this.organizationCode = organizationCode;
 }
public String getMaxScore()
 {
     return this.maxScore;
 }
public  void  setMaxScore(String maxScore)
 {
  this.maxScore = maxScore;
 }
public String getMinScore()
 {
     return this.minScore;
 }
public  void  setMinScore(String minScore)
 {
  this.minScore = minScore;
 }
public String getArmRankName()
 {
     return this.armRankName;
 }
public  void  setArmRankName(String armRankName)
 {
  this.armRankName = armRankName;
 }
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }

}