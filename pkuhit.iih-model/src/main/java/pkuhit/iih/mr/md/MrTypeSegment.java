package pkuhit.iih.mr.md;

import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;









public static final   String  CODE = "MRM17.AT01";
// 医疗记录类型编码
public static final   String  MR_TYPE_CODE = "MRM17.AT02";
// 医疗记录段落类型编码
public static final   String  MR_SEGMENT_TYPE_CODE = "MRM17.AT03";


@Column(name="MR_TP_SEG_CD") 
private  String code;

@Column(name="MR_TP_CD") 
private  String mrTypeCode;

@Column(name="MR_SEG_TP_CD") 
private  String mrSegmentTypeCode;
// 医疗记录类型名称
@DictionaryTag(code = "mrTypeCode")
private  String mrTypeName;
// 医疗记录段落类型名称
@DictionaryTag(code = "mrSegmentTypeCode")
private  String mrSegmentTypeName;

 {
     return this.code;
 }

 {
  this.code = code;
 }

 {
     return this.mrTypeCode;
 }

 {
  this.mrTypeCode = mrTypeCode;
 }

 {
     return this.mrSegmentTypeCode;
 }

 {
  this.mrSegmentTypeCode = mrSegmentTypeCode;
 }

 {
     return this.mrTypeName;
 }

 {
  this.mrTypeName = mrTypeName;
 }

 {
     return this.mrSegmentTypeName;
 }

 {
  this.mrSegmentTypeName = mrSegmentTypeName;
 }

