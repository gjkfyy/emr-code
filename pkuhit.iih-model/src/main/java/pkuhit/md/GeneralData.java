package pkuhit.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class GeneralData extends BaseMasterModel {
 public GeneralData(){
  super();
 }
 public GeneralData(String code){
  super(code);
 }
 
 /**
  * 数据对象编码
  */
 public static final String OBJ_CD = "MDM01";
 
 
// 通用主数据编码
public static final   String  CODE = "MDM01.AT01";
// 数据对象编码
public static final   String  OBJECT_CODE = "MDM01.AT02";
// 名称
public static final   String  NAME = "MDM01.AT03";
// 描述
public static final   String  DESCRIPTION = "MDM01.AT04";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "MDM01.AT05";
// 英文名称
public static final   String  ENGLISH_NAME = "MDM01.AT06";

// 通用主数据编码
@Column(name="GS_CD") 
private  String code;
// 数据对象编码
@Column(name="OBJ_CD") 
private  String objectCode;
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
public String getObjectCode()
 {
     return this.objectCode;
 }
public  void  setObjectCode(String objectCode)
 {
  this.objectCode = objectCode;
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