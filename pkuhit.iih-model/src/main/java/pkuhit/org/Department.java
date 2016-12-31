package pkuhit.org;
import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class Department extends BaseMasterModel {
 public Department(){
  super();
 }
 public Department(String code){
  super(code);
 }
 
 public static final String   OBJ_CD  = "ORGB02";
// 部门编码
public static final   String  CODE = "ORGB02.AT01";
// 部门类型编码
public static final   String  TYPE_CODE = "ORGB02.AT02";

// 部门编码
@Column(name="DEPT_CD") 
private  String code;
// 部门类型编码
@Column(name="DEPT_TP_CD") 
private  String typeCode;
// 部门类型名称
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
public String getTypeName()
 {
     return this.typeName;
 }
public  void  setTypeName(String typeName)
 {
  this.typeName = typeName;
 }

}