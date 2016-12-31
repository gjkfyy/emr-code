package pkuhit.iih.mr.tpl;
import java.math.BigInteger;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class MrGroupElement extends BaseMasterModel {
 public MrGroupElement(){
  super();
 }
 public MrGroupElement(String code){
  super(code);
 }
public static final String   OBJ_CD  = "MRK06";

// 医疗记录组合元素编码
public static final   String  CODE = "MRK06.AT01";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "MRK06.AT02";
// 文件主键
public static final   String  FILE_PK = "MRK06.AT03";
// 根医疗记录组合元素编码
public static final   String  ROOT_CODE = "MRK06.AT04";
// 版本号
public static final   String  VERSION_NO = "MRK06.AT05";
// 医疗记录组合元素类型编码
public static final   String  TYPE_CODE = "MRK06.AT06";
// 医疗记录组合元素状态编码
public static final   String  STATUS_CODE = "MRK06.AT07";
// 名称
public static final   String  NAME = "MRK06.AT08";
// 描述
public static final   String  DESCRIPTION = "MRK06.AT09";
// 所属类型编码
public static final   String  OWNER_TYPE_CODE = "MRK06.AT10";
// 所属编码
public static final   String  OWNER_CODE = "MRK06.AT11";
// 医疗记录组合元素的自定义分类编码
public static final   String  CUSTOM_CATEGORY_CODE = "MRK06.AT19";

// 医疗记录组合元素编码
@Column(name="MR_GE_CD") 
private  String code;
// 组织机构编码
@Column(name="ORG_CD") 
private  String organizationCode;
// 文件主键
@Column(name="FILE_PK") 
private  String filePk;

//Added by wujunhui 2014/12/12
// 文件
private String odtFile;
// 根医疗记录组合元素编码
@Column(name="RT_MR_EG_CD") 
private  String rootCode;
// 版本号
@Column(name="VER_NO") 
private  BigInteger versionNo;
// 医疗记录组合元素类型编码
@Column(name="MR_GE_TP_CD") 
private  String typeCode;
// 医疗记录组合元素状态编码
@Column(name="MR_GE_STA_CD") 
private  String statusCode;
// 名称
@Column(name="NM") 
private  String name;
// 描述
@Column(name="DES") 
private  String description;
// 所属类型编码
@Column(name="OWN_TP_CD") 
private  String ownerTypeCode;
// 所属编码
@Column(name="OWN_CD") 
private  String ownerCode;
// 组织机构名称
//@DictionaryTag(code = "organizationCode",objCd ="ORGB01")
private  String organizationName;
// 医疗记录组合元素类型名称
@DictionaryTag(code = "typeCode",objCd ="MRM11")
private  String typeName;
// 医疗记录组合元素状态名称
@DictionaryTag(code = "statusCode",objCd ="MRM05")
private  String statusName;
// 所属类型名称
@DictionaryTag(code = "ownerTypeCode",objCd ="MDM08")
private  String ownerTypeName;
// 所属名称
//@DictionaryTag(code = "ownerCode",objCd ="null")
private  String ownerName;
// 可删除标志
private  Integer canDelete;
// 可升级标志
private  Integer canUpgrade;
// 医疗记录组合元素的自定义分类编码
@Column(name="MR_GE_CCAT_CD") 
private  String customCategoryCode;
// 可启用标志
private  Integer canActivated;
// 可停用标志
private  Integer canStop;
// 可驳回标志
private  Integer canReject;
// 医疗记录组合元素的自定义分类名称
@DictionaryTag(code = "customCategoryCode",objCd ="MRM19")
private  String customCategoryName;
// 可审批标志
private  Integer canReview;
// 可提交标志
private  Integer canSubmit;
//可更改标志
private  Integer canUpdate;
public Integer getCanUpdate() {
	return canUpdate;
}

public void setCanUpdate(Integer canUpdate) {
	this.canUpdate = canUpdate;
}

public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getOrganizationCode()
 {
     return this.organizationCode;
 }
public  void  setOrganizationCode(String organizationCode)
 {
  this.organizationCode = organizationCode;
 }
public String getFilePk()
 {
     return this.filePk;
 }
public  void  setFilePk(String filePk)
 {
  this.filePk = filePk;
 }
public String getRootCode()
 {
     return this.rootCode;
 }
public  void  setRootCode(String rootCode)
 {
  this.rootCode = rootCode;
 }
public BigInteger getVersionNo()
 {
     return this.versionNo;
 }
public  void  setVersionNo(BigInteger versionNo)
 {
  this.versionNo = versionNo;
 }
public String getTypeCode()
 {
     return this.typeCode;
 }
public  void  setTypeCode(String typeCode)
 {
  this.typeCode = typeCode;
 }
public String getStatusCode()
 {
     return this.statusCode;
 }
public  void  setStatusCode(String statusCode)
 {
  this.statusCode = statusCode;
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
public String getOwnerTypeCode()
 {
     return this.ownerTypeCode;
 }
public  void  setOwnerTypeCode(String ownerTypeCode)
 {
  this.ownerTypeCode = ownerTypeCode;
 }
public String getOwnerCode()
 {
     return this.ownerCode;
 }
public  void  setOwnerCode(String ownerCode)
 {
  this.ownerCode = ownerCode;
 }
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }
public String getTypeName()
 {
     return this.typeName;
 }
public  void  setTypeName(String typeName)
 {
  this.typeName = typeName;
 }
public String getStatusName()
 {
     return this.statusName;
 }
public  void  setStatusName(String statusName)
 {
  this.statusName = statusName;
 }
public String getOwnerTypeName()
 {
     return this.ownerTypeName;
 }
public  void  setOwnerTypeName(String ownerTypeName)
 {
  this.ownerTypeName = ownerTypeName;
 }
public String getOwnerName()
 {
     return this.ownerName;
 }
public  void  setOwnerName(String ownerName)
 {
  this.ownerName = ownerName;
 }
public Integer getCanDelete()
 {
     return this.canDelete;
 }
public  void  setCanDelete(Integer canDelete)
 {
  this.canDelete = canDelete;
 }
public Integer getCanUpgrade()
 {
     return this.canUpgrade;
 }
public  void  setCanUpgrade(Integer canUpgrade)
 {
  this.canUpgrade = canUpgrade;
 }
public String getCustomCategoryCode()
 {
     return this.customCategoryCode;
 }
public  void  setCustomCategoryCode(String customCategoryCode)
 {
  this.customCategoryCode = customCategoryCode;
 }
public Integer getCanActivated()
 {
     return this.canActivated;
 }
public  void  setCanActivated(Integer canActivated)
 {
  this.canActivated = canActivated;
 }
public Integer getCanStop()
 {
     return this.canStop;
 }
public  void  setCanStop(Integer canStop)
 {
  this.canStop = canStop;
 }
public Integer getCanReject()
 {
     return this.canReject;
 }
public  void  setCanReject(Integer canReject)
 {
  this.canReject = canReject;
 }
public String getCustomCategoryName()
 {
     return this.customCategoryName;
 }
public  void  setCustomCategoryName(String customCategoryName)
 {
  this.customCategoryName = customCategoryName;
 }
public Integer getCanReview()
 {
     return this.canReview;
 }
public  void  setCanReview(Integer canReview)
 {
  this.canReview = canReview;
 }
public Integer getCanSubmit()
 {
     return this.canSubmit;
 }
public  void  setCanSubmit(Integer canSubmit)
 {
  this.canSubmit = canSubmit;
 }

public String getOdtFile() {
	return odtFile;
}

public void setOdtFile(String odtFile) {
	this.odtFile = odtFile;
}

}