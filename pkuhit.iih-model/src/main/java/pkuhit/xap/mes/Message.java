package pkuhit.xap.mes;

import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.seasar.doma.Id;


public class Message extends BaseMasterModel {

 public Message(){

  super();

 }

 public Message(String code){

  super(code);

 }

public static final String   OBJ_CD  = "XAPM14";

// 角色编码
public static final   String  CODE = "XAPM14.AT01";
// 组织机构编码
public static final   String  READ_FLAG_BEFORE = "0";

public static final   String  READ_FLAG_AFTER = "1";
// 名称
public static final   String  NAME = "XAPM14.AT03";
// 描述
public static final   String  DESCRIPTION = "XAPM14.AT04";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "XAPM14.AT05";
// 英文名称
public static final   String  ENGLISH_NAME = "XAPM14.AT06";
// 业务角色标志
public static final   String  BIZ_ROLE_CODE = "XAPM14.AT07";

@Column(name = "MES_ID")
String mesId;

/** 发送人 */
@Column(name = "SEND_USER_ID")
String sendUserId;
@DictionaryTag(code = "sendUserId",objCd ="ORGB04")
String sendUserName;

/** 发送时间 */
@Column(name = "SEND_DATE")
Timestamp sendDate;

/** 接收人 */
@Column(name = "RECEIVE_USER_ID")
String receiveUserId;

@DictionaryTag(code = "receiveUserId",objCd ="ORGB04")
String receiveUserName;

/** 接收时间 */
@Column(name = "RECEIVE_DATE")
Timestamp receiveDate;

/** 门户编码 */
@Column(name = "PORTAL_CD")
String portalCd;

@DictionaryTag(code = "portalCd",objCd ="XAPM12")
String portalName;

/** 菜单编码 */
@Column(name = "MENU_CD")
String menuCd;

@DictionaryTag(code = "menuCd",objCd ="XAPM12")
String menuName;

/** 内容 */
@Column(name = "CONTENT")
String content;

/** 已读标记 0  未读   1 已读 */
@Column(name = "READ_FLAG")
String readFlag;

/** 级别  0 一般  1 重要 */
@Column(name = "MES_LEVEL")
Short mesLevel;

/** 类型 0 质控消息  1 其他消息 */
@Column(name = "MES_TYPE")
String mesType;

/** */
@Column(name = "MEMO")
String memo;

/** */
@Column(name = "SORT_NO")
String sortNo;

/** */
@Column(name = "SPELL_NO")
String spellNo;

/** */
@Column(name = "WUBI_NO")
String wubiNo;

/** */
@Column(name = "UPD_CNT")
BigInteger updCnt;

/** */
@Column(name = "CRT_TIME")
Timestamp crtTime;

/** */
@Column(name = "CRT_USER_ID")
String crtUserId;

/** */
@Column(name = "CRT_DEPT_CD")
String crtDeptCd;

/** */
@Column(name = "LAST_UPD_TIME")
Timestamp lastUpdTime;

/** */
@Column(name = "LAST_UPD_DEPT_CD")
String lastUpdDeptCd;

/** */
@Column(name = "LAST_UPD_USER_ID")
String lastUpdUserId;

/** */
@Column(name = "DEL_F")
Short delF;

/** */
@Column(name = "TASK_ID")
String taskId;

/** */
@Column(name = "TASK_TYPE_CD")
String taskTypeCd;

/** */
@Column(name = "revisionCd")
String revisionCd;

/** */
@Column(name = "STATUS")
String status;

/**患者就诊流水号 */
@Column(name = "ENCOUNTER_SN")
String encounterSn;

public String getEncounterSn() {
	return encounterSn;
}

public void setEncounterSn(String encounterSn) {
	this.encounterSn = encounterSn;
}

public String getTaskId()
{
    return taskId;
}

public void setTaskId(String taskId)
{
    this.taskId = taskId;
}

public String getMesId() {
	return mesId;
}

public void setMesId(String mesId) {
	this.mesId = mesId;
}

public String getSendUserId() {
	return sendUserId;
}

public void setSendUserId(String sendUserId) {
	this.sendUserId = sendUserId;
}

public String getSendUserName() {
	return sendUserName;
}

public void setSendUserName(String sendUserName) {
	this.sendUserName = sendUserName;
}

public Timestamp getSendDate() {
	return sendDate;
}

public void setSendDate(Timestamp sendDate) {
	this.sendDate = sendDate;
}

public String getReceiveUserId() {
	return receiveUserId;
}

public void setReceiveUserId(String receiveUserId) {
	this.receiveUserId = receiveUserId;
}

public String getReceiveUserName() {
	return receiveUserName;
}

public void setReceiveUserName(String receiveUserName) {
	this.receiveUserName = receiveUserName;
}

public Timestamp getReceiveDate() {
	return receiveDate;
}

public void setReceiveDate(Timestamp receiveDate) {
	this.receiveDate = receiveDate;
}

public String getPortalCd() {
	return portalCd;
}

public void setPortalCd(String portalCd) {
	this.portalCd = portalCd;
}

public String getPortalName() {
	return portalName;
}

public void setPortalName(String portalName) {
	this.portalName = portalName;
}

public String getMenuCd() {
	return menuCd;
}

public void setMenuCd(String menuCd) {
	this.menuCd = menuCd;
}

public String getMenuName() {
	return menuName;
}

public void setMenuName(String menuName) {
	this.menuName = menuName;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getReadFlag() {
	return readFlag;
}

public void setReadFlag(String readFlag) {
	this.readFlag = readFlag;
}

public Short getMesLevel() {
	return mesLevel;
}

public void setMesLevel(Short mesLevel) {
	this.mesLevel = mesLevel;
}

public String getMesType() {
	return mesType;
}

public void setMesType(String mesType) {
	this.mesType = mesType;
}

public String getMemo() {
	return memo;
}

public void setMemo(String memo) {
	this.memo = memo;
}

public String getSortNo() {
	return sortNo;
}

public void setSortNo(String sortNo) {
	this.sortNo = sortNo;
}

public String getSpellNo() {
	return spellNo;
}

public void setSpellNo(String spellNo) {
	this.spellNo = spellNo;
}

public String getWubiNo() {
	return wubiNo;
}

public void setWubiNo(String wubiNo) {
	this.wubiNo = wubiNo;
}

public BigInteger getUpdCnt() {
	return updCnt;
}

public void setUpdCnt(BigInteger updCnt) {
	this.updCnt = updCnt;
}

public Timestamp getCrtTime() {
	return crtTime;
}

public void setCrtTime(Timestamp crtTime) {
	this.crtTime = crtTime;
}

public String getCrtUserId() {
	return crtUserId;
}

public void setCrtUserId(String crtUserId) {
	this.crtUserId = crtUserId;
}

public String getCrtDeptCd() {
	return crtDeptCd;
}

public void setCrtDeptCd(String crtDeptCd) {
	this.crtDeptCd = crtDeptCd;
}

public Timestamp getLastUpdTime() {
	return lastUpdTime;
}

public void setLastUpdTime(Timestamp lastUpdTime) {
	this.lastUpdTime = lastUpdTime;
}

public String getLastUpdDeptCd() {
	return lastUpdDeptCd;
}

public void setLastUpdDeptCd(String lastUpdDeptCd) {
	this.lastUpdDeptCd = lastUpdDeptCd;
}

public String getLastUpdUserId() {
	return lastUpdUserId;
}

public void setLastUpdUserId(String lastUpdUserId) {
	this.lastUpdUserId = lastUpdUserId;
}

public Short getDelF() {
	return delF;
}

public void setDelF(Short delF) {
	this.delF = delF;
}

public String getTaskTypeCd()
{
    return taskTypeCd;
}

public void setTaskTypeCd(String taskTypeCd)
{
    this.taskTypeCd = taskTypeCd;
}

public String getRevisionCd()
{
    return revisionCd;
}

public void setRevisionCd(String revisionCd)
{
    this.revisionCd = revisionCd;
}

public String getStatus()
{
    return status;
}

public void setStatus(String status)
{
    this.status = status;
}


}