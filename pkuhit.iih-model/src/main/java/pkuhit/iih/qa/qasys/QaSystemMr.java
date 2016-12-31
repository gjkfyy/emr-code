package pkuhit.iih.qa.qasys;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaSystemMr extends BaseRelationModel {
 public QaSystemMr(){
  super();
 }
 public QaSystemMr(String code){
  super(code);
 }
// 质控体系医疗记录编码
public static final   String  CODE = "QAK03.AT01";
// 质控体系病案编码
public static final   String  QA_SYSTEM_AMR_CODE = "QAK03.AT02";
// 医疗记录类型编码
public static final   String  MR_TYPE_CODE = "QAK03.AT03";
// 质控要求
public static final   String  REQUIREMENT = "QAK03.AT04";
// 总分值
public static final   String  TOTAL_SCORE = "QAK03.AT05";

// 质控体系医疗记录编码
@Column(name="QA_SYS_MR_CD") 
private  String code;
// 质控体系病案编码
@Column(name="QA_SYS_AMR_CD") 
private  String qaSystemAmrCode;
// 医疗记录类型编码
@Column(name="MR_TP_CD") 
private  String mrTypeCode;
// 质控要求
@Column(name="REQ") 
private  String requirement;
// 总分值
@Column(name="TTL_SCR") 
private  Integer totalScore;
// 医疗记录类型名称
@DictionaryTag(code = "mrTypeCode")
private  String mrTypeName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getQaSystemAmrCode()
 {
     return this.qaSystemAmrCode;
 }
public  void  setQaSystemAmrCode(String qaSystemAmrCode)
 {
  this.qaSystemAmrCode = qaSystemAmrCode;
 }
public String getMrTypeCode()
 {
     return this.mrTypeCode;
 }
public  void  setMrTypeCode(String mrTypeCode)
 {
  this.mrTypeCode = mrTypeCode;
 }
public String getRequirement()
 {
     return this.requirement;
 }
public  void  setRequirement(String requirement)
 {
  this.requirement = requirement;
 }
public Integer getTotalScore()
 {
     return this.totalScore;
 }
public  void  setTotalScore(Integer totalScore)
 {
  this.totalScore = totalScore;
 }
public String getMrTypeName()
 {
     return this.mrTypeName;
 }
public  void  setMrTypeName(String mrTypeName)
 {
  this.mrTypeName = mrTypeName;
 }

}