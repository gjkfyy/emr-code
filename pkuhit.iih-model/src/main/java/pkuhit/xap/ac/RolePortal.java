package pkuhit.xap.ac;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class RolePortal extends BaseRelationModel {
 public RolePortal(){
  super();
 }
 public RolePortal(String code){
  super(code);
 }
// 角色门户编码
public static final   String  CODE = "XAPM18.AT01";
// 角色编码
public static final   String  ROLE_CODE = "XAPM18.AT02";
// 门户编码
public static final   String  PORTAL_CODE = "XAPM18.AT03";

// 角色门户编码
@Column(name="ROLE_PO_CD") 
private  String code;
// 角色编码
@Column(name="ROLE_CD") 
private  String roleCode;
// 门户编码
@Column(name="PORTAL_CD") 
private  String portalCode;
// 角色名称
private  String roleName;
// 门户名称
private  String portalName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getRoleCode()
 {
     return this.roleCode;
 }
public  void  setRoleCode(String roleCode)
 {
  this.roleCode = roleCode;
 }
public String getPortalCode()
 {
     return this.portalCode;
 }
public  void  setPortalCode(String portalCode)
 {
  this.portalCode = portalCode;
 }
public String getRoleName()
 {
     return this.roleName;
 }
public  void  setRoleName(String roleName)
 {
  this.roleName = roleName;
 }
public String getPortalName()
 {
     return this.portalName;
 }
public  void  setPortalName(String portalName)
 {
  this.portalName = portalName;
 }

}