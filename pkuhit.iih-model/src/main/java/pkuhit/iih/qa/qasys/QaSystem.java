package pkuhit.iih.qa.qasys;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaSystem extends BaseMasterModel {
 public QaSystem(){
  super();
 }
 public QaSystem(String code){
  super(code);
 }
// 质控体系编码
public static final   String  CODE = "QAK01.AT01";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "QAK01.AT02";
// 根质控体系编码
public static final   String  ROOT_CODE = "QAK01.AT03";
// 版本号
public static final   String  VERSION_NO = "QAK01.AT04";
// 使用中标志
public static final   String  IN_USE_FLAG = "QAK01.AT05";

// 质控体系编码
@Column(name="QA_SYS_CD") 
private  String code;
// 组织机构编码
@Column(name="ORG_CD") 
private  String organizationCode;
// 根质控体系编码
@Column(name="RT_QA_SYS_CD") 
private  String rootCode;
// 版本号
@Column(name="VER_NO") 
private  String versionNo;
// 使用中标志
@Column(name="IN_USE_F") 
private  Integer inUseFlag;
// 组织机构名称
//@DictionaryTag(code = "organizationCode")
private  String organizationName;
// 根质控体系名称
@DictionaryTag(code = "rootCode")
private  String rootName;
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
public String getRootCode()
 {
     return this.rootCode;
 }
public  void  setRootCode(String rootCode)
 {
  this.rootCode = rootCode;
 }
public String getVersionNo()
 {
     return this.versionNo;
 }
public  void  setVersionNo(String versionNo)
 {
  this.versionNo = versionNo;
 }
public Integer getInUseFlag()
 {
     return this.inUseFlag;
 }
public  void  setInUseFlag(Integer inUseFlag)
 {
  this.inUseFlag = inUseFlag;
 }
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }
public String getRootName()
 {
     return this.rootName;
 }
public  void  setRootName(String rootName)
 {
  this.rootName = rootName;
 }

}