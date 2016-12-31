package pkuhit.iih.qa.qasys;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaSystemAmr extends BaseRelationModel {
 public QaSystemAmr(){
  super();
 }
 public QaSystemAmr(String code){
  super(code);
 }
// 质控体系病案编码
public static final   String  CODE = "QAK02.AT01";
// 质控体系编码
public static final   String  QA_SYSTEM_CODE = "QAK02.AT02";
// 就诊类型编码
public static final   String  ENCOUNTER_TYPE_CODE = "QAK02.AT03";
// 质控要求
public static final   String  REQUIREMENT = "QAK02.AT04";
// 总分值
public static final   String  TOTAL_SCORE = "QAK02.AT05";

// 质控体系病案编码
@Column(name="QA_SYS_AMR_CD") 
private  String code;
// 质控体系编码
@Column(name="QA_SYS_CD") 
private  String qaSystemCode;
// 就诊类型编码
@Column(name="EN_TP_CD") 
private  String encounterTypeCode;
// 质控要求
@Column(name="REQ") 
private  String requirement;
// 总分值
@Column(name="TTL_SCR") 
private  Integer totalScore;
// 质控体系名称
private  String qaSystemName;
// 就诊类型名称
private  String encounterTypeName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getQaSystemCode()
 {
     return this.qaSystemCode;
 }
public  void  setQaSystemCode(String qaSystemCode)
 {
  this.qaSystemCode = qaSystemCode;
 }
public String getEncounterTypeCode()
 {
     return this.encounterTypeCode;
 }
public  void  setEncounterTypeCode(String encounterTypeCode)
 {
  this.encounterTypeCode = encounterTypeCode;
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
public String getQaSystemName()
 {
     return this.qaSystemName;
 }
public  void  setQaSystemName(String qaSystemName)
 {
  this.qaSystemName = qaSystemName;
 }
public String getEncounterTypeName()
 {
     return this.encounterTypeName;
 }
public  void  setEncounterTypeName(String encounterTypeName)
 {
  this.encounterTypeName = encounterTypeName;
 }

}