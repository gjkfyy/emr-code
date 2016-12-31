package pkuhit.iih.mr.md;
import xap.sv.annotation.Column;
import xap.model.BaseMasterModel;

public class MrGroupElementCustomCategory extends BaseMasterModel {
 public MrGroupElementCustomCategory(){
  super();
 }
 public MrGroupElementCustomCategory(String code){
  super(code);
 }
// 医疗记录组合元素自定义分类编码
public static final   String  CODE = "MRM19.AT01";
// 父医疗记录组合元素自定义分类编码
public static final   String  PARENT_CODE = "MRM19.AT02";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "MRM19.AT03";
// 名称
public static final   String  NAME = "MRM19.AT04";
// 描述
public static final   String  DESCRIPTION = "MRM19.AT05";
// 层级
public static final   String  LEVEL = "MRM19.AT06";
// 叶节点标志
public static final   String  LEAF_FLAG = "MRM19.AT07";

// 医疗记录组合元素自定义分类编码
//@Column(name="MR_GE_CCAT_CD") 
private  String code;
// 父医疗记录组合元素自定义分类编码
//@Column(name="PAR_MR_GE_CCAT_CD") 
private  String parentCode;
// 组织机构编码
//@Column(name="ORG_CD") 
private  String organizationCode;
// 名称
@Column(name="NM") 
private  String name;
// 描述
@Column(name="DES") 
private  String description;
// 层级
@Column(name="LVL") 
private  Integer level;
// 叶节点标志
@Column(name="LEAF_F") 
private  Integer leafFlag;
// 组织机构名称
//@DictionaryTag(code = "organizationCode")
private  String organizationName;
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
public String getOrganizationCode()
 {
     return this.organizationCode;
 }
public  void  setOrganizationCode(String organizationCode)
 {
  this.organizationCode = organizationCode;
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
public Integer getLevel()
 {
     return this.level;
 }
public  void  setLevel(Integer level)
 {
  this.level = level;
 }
public Integer getLeafFlag()
 {
     return this.leafFlag;
 }
public  void  setLeafFlag(Integer leafFlag)
 {
  this.leafFlag = leafFlag;
 }
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }

}