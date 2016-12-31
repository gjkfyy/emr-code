package pkuhit.iih.mr.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;

public class MrTypeSegment extends BaseRelationModel {
 public MrTypeSegment(){
  super();
 }
 public MrTypeSegment(String code){
  super(code);
 }
// 医疗记录类型段落编码
public static final   String  CODE = "MRM17.AT01";
// 医疗记录类型编码
public static final   String  MR_TYPE_CODE = "MRM17.AT02";
// 医疗记录段落类型编码
public static final   String  MR_SEGMENT_TYPE_CODE = "MRM17.AT03";

// 医疗记录类型段落编码
@Column(name="MR_TP_SEG_CD") 
private  String code;
// 医疗记录类型编码
@Column(name="MR_TP_CD") 
private  String mrTypeCode;
// 医疗记录段落类型编码
@Column(name="MR_SEG_TP_CD") 
private  String mrSegmentTypeCode;
// 医疗记录类型名称
@DictionaryTag(code = "mrTypeCode")
private  String mrTypeName;
// 医疗记录段落类型名称
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
public String getMrTypeCode()
 {
     return this.mrTypeCode;
 }
public  void  setMrTypeCode(String mrTypeCode)
 {
  this.mrTypeCode = mrTypeCode;
 }
public String getMrSegmentTypeCode()
 {
     return this.mrSegmentTypeCode;
 }
public  void  setMrSegmentTypeCode(String mrSegmentTypeCode)
 {
  this.mrSegmentTypeCode = mrSegmentTypeCode;
 }
public String getMrTypeName()
 {
     return this.mrTypeName;
 }
public  void  setMrTypeName(String mrTypeName)
 {
  this.mrTypeName = mrTypeName;
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