package pkuhit.iih.mr.tpl;

import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;










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


@Column(name="AMR_RANK_SCR_CD") 
private  String code;

@Column(name="AMR_RANK_CD") 
private  String armRankCode;

@Column(name="ORG_CD") 
private  String organizationCode;

@Column(name="MAX_SCR") 
private  String maxScore;

@Column(name="MIN_SCR") 
private  String minScore;
// 病案等级名称
@DictionaryTag(code = "armRankCode",objCd ="MRM10")
private  String armRankName;
// 组织机构名称
//@DictionaryTag(code = "organizationCode",objCd ="ORGB01")
private  String organizationName;

 {
     return this.code;
 }

 {
  this.code = code;
 }

 {
     return this.armRankCode;
 }

 {
  this.armRankCode = armRankCode;
 }

 {
     return this.organizationCode;
 }

 {
  this.organizationCode = organizationCode;
 }

 {
     return this.maxScore;
 }

 {
  this.maxScore = maxScore;
 }

 {
     return this.minScore;
 }

 {
  this.minScore = minScore;
 }

 {
     return this.armRankName;
 }

 {
  this.armRankName = armRankName;
 }

 {
     return this.organizationName;
 }

 {
  this.organizationName = organizationName;
 }

