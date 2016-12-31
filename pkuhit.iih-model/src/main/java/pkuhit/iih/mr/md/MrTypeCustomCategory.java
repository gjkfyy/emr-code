package pkuhit.iih.mr.md;
import xap.sv.annotation.Column;
import xap.model.BaseMasterModel;

public class MrTypeCustomCategory extends BaseMasterModel {
 public MrTypeCustomCategory(){
  super();
 }
 public MrTypeCustomCategory(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "MRM14";// 医疗记录自定义分类编码
public static final   String  CODE = "MRM14.AT01";
// 父医疗记录自定义分类编码
public static final   String  PARENT_CODE = "MRM14.AT02";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "MRM14.AT03";
// 名称
public static final   String  NAME = "MRM14.AT04";
// 描述
public static final   String  DESCRIPTION = "MRM14.AT05";
// 层级
public static final   String  LEVEL = "MRM14.AT06";
// 叶节点标志
public static final   String  LEAF_FLAG = "MRM14.AT07";

// 医疗记录自定义分类编码
@Column(name="MR_TP_CCAT_CD") 
private  String code;
// 父医疗记录自定义分类编码
@Column(name="PAR_MR_TP_CCAT_CD") 
private  String parentCode;
// 组织机构编码
@Column(name="ORG_CD") 
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
// 父医疗记录自定义分类名称
//@DictionaryTag(code = "parentCode")
private  String parentName;
// 组织机构编码名称
//@DictionaryTag(code = "organizationCode")
private  String organizationName;

//是否续打标志
@Column(name="CONTINUE_PRINT_F") 
private  Integer continuePrintF;

//医护标记
@Column(name="DCT_NS_F") 
private  Integer dctNsF;

public String getSortNo()
{
    return sortNo;
}

public void setSortNo(String sortNo)
{
    this.sortNo = sortNo;
}
@Column(name = "SORT_NO")
private String sortNo;
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
public String getParentName()
 {
     return this.parentName;
 }
public  void  setParentName(String parentName)
 {
  this.parentName = parentName;
 }
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }

public Integer getContinuePrintF()
{
    return continuePrintF;
}

public void setContinuePrintF(Integer continuePrintF)
{
    this.continuePrintF = continuePrintF;
}

public Integer getDctNsF()
{
    return dctNsF;
}

public void setDctNsF(Integer dctNsF)
{
    this.dctNsF = dctNsF;
}

}