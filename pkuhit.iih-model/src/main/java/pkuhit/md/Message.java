package pkuhit.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Message extends BaseMasterModel {
 public Message(){
  super();
 }
 public Message(String code){
  super(code);
 }
// 消息编码
public static final   String  CODE = "MDM11.AT01";
// 消息类型编码
public static final   String  TYPE_CODE = "MDM11.AT02";
// 名称
public static final   String  NAME = "MDM11.AT03";
// 描述
public static final   String  DESCRIPTION = "MDM11.AT04";
// 英文名称
public static final   String  ENGLISH_NAME = "MDM11.AT05";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME = "MDM11.AT06";

// 消息编码
@Column(name="MSG_CD") 
private  String code;
// 消息类型编码
@Column(name="MSG_TP_CD") 
private  String typeCode;
// 名称
@Column(name="NM") 
private  String name;
// 描述
@Column(name="DES") 
private  String description;
// 英文名称
@Column(name="NM_EN") 
private  String englishName;
// 英文简称
@Column(name="SHT_NM_EN") 
private  String shortEnglishName;
// 消息类型名称
@DictionaryTag(code = "typeCode")
private  String typeName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getTypeCode()
 {
     return this.typeCode;
 }
public  void  setTypeCode(String typeCode)
 {
  this.typeCode = typeCode;
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
public String getEnglishName()
 {
     return this.englishName;
 }
public  void  setEnglishName(String englishName)
 {
  this.englishName = englishName;
 }
public String getShortEnglishName()
 {
     return this.shortEnglishName;
 }
public  void  setShortEnglishName(String shortEnglishName)
 {
  this.shortEnglishName = shortEnglishName;
 }
public String getTypeName()
 {
     return this.typeName;
 }
public  void  setTypeName(String typeName)
 {
  this.typeName = typeName;
 }

}