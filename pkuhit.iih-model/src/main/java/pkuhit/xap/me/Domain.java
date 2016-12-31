package pkuhit.xap.me;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Domain extends BaseMasterModel {
 public Domain(){
  super();
 }
 public Domain(String code){
  super(code);
 }
// 领域编码
public static final   String  CODE = "MEB01.AT01";
// 父领域编码
public static final   String  PARENT_CODE = "MEB01.AT02";
// 名称
public static final   String  NAME = "MEB01.AT03";
// 描述
public static final   String  DESCRIPTION = "MEB01.AT04";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "MEB01.AT05";
// 英文名称
public static final   String  ENGLISH_NAME = "MEB01.AT06";

// 领域编码
@Column(name="DO_CD") 
private  String code;
// 父领域编码
@Column(name="PAR_DO_CD") 
private  String parentCode;
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
public String getParentCode()
 {
     return this.parentCode;
 }
public  void  setParentCode(String parentCode)
 {
  this.parentCode = parentCode;
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