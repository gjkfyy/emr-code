package pkuhit.iih.qa.qasys;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaSystemSegment extends BaseRelationModel {
 public QaSystemSegment(){
  super();
 }
 public QaSystemSegment(String code){
  super(code);
 }
 
 public static final String   OBJ_CD  = "QAK04";
// 质控体系段落编码
public static final   String  CODE = "QAK04.AT01";
// 质控体系医疗记录编码
public static final   String  QA_SYSTEM_MR_CODE = "QAK04.AT02";
// 段落类型编码
public static final   String  MR_SEGMENT_TYPE_CODE = "QAK04.AT03";
// 质控要求
public static final   String  REQUIRMENT = "QAK04.AT04";
// 总分值
public static final   String  TOTAL_SCORE = "QAK04.AT05";

// 质控体系段落编码
@Column(name="QA_SYS_SEG_CD") 
private  String code;
// 质控体系医疗记录编码
@Column(name="QA_SYS_MR_CD") 
private  String qaSystemMrCode;
// 段落类型编码
@Column(name="MR_SEG_TP_CD") 
private  String mrSegmentTypeCode;
// 质控要求
@Column(name="REQ") 
private  String requirment;
// 总分值
@Column(name="TTL_SCR") 
private  Integer totalScore;
// 段落类型名称
@DictionaryTag(code = "mrSegmentTypeCode")
private  String mrSegmentTypeName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getQaSystemMrCode()
 {
     return this.qaSystemMrCode;
 }
public  void  setQaSystemMrCode(String qaSystemMrCode)
 {
  this.qaSystemMrCode = qaSystemMrCode;
 }
public String getMrSegmentTypeCode()
 {
     return this.mrSegmentTypeCode;
 }
public  void  setMrSegmentTypeCode(String mrSegmentTypeCode)
 {
  this.mrSegmentTypeCode = mrSegmentTypeCode;
 }
public String getRequirment()
 {
     return this.requirment;
 }
public  void  setRequirment(String requirment)
 {
  this.requirment = requirment;
 }
public Integer getTotalScore()
 {
     return this.totalScore;
 }
public  void  setTotalScore(Integer totalScore)
 {
  this.totalScore = totalScore;
 }
public String getMrSegmentTypeName()
 {
     return this.mrSegmentTypeName;
 }
public  void  setMrSegmentTypeName(String mrSegmentTypeName)
 {
  this.mrSegmentTypeName = mrSegmentTypeName;
 }

}