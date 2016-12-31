package pkuhit.org;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class WorkGroup extends BaseMasterModel {
 public WorkGroup(){
  super();
 }
 public WorkGroup(String code){
  super(code);
 }
// 工作组编码
public static final   String  CODE = "ORGB03.AT01";
// 工作组类型编码
public static final   String  TYPE_CODE = "ORGB03.AT02";

// 工作组编码
@Column(name="WG_CD") 
private  String code;
// 工作组类型编码
@Column(name="WG_TP_CD") 
private  String typeCode;
// 工作组类型名称
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