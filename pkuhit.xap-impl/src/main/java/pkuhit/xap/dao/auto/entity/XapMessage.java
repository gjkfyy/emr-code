package pkuhit.xap.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 消息
 */
@Entity(listener = XapMessageListener.class)
@Table(name = "XAP_MESSAGE")
public class XapMessage {

    /** 主键 */
    @Id
    @Column(name = "MES_ID")
    String mesId;

    /** 发送人 */
    @Column(name = "SEND_USER_ID")
    String sendUserId;

    /** 发送时间 */
    @Column(name = "SEND_DATE")
    Timestamp sendDate;

    /** 接收人 */
    @Column(name = "RECEIVE_USER_ID")
    String receiveUserId;

    /** 接收时间 */
    @Column(name = "RECEIVE_DATE")
    Timestamp receiveDate;

    /** 门户编码 */
    @Column(name = "PORTAL_CD")
    String portalCd;

    /** 菜单编码 */
    @Column(name = "MENU_CD")
    String menuCd;

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

    /** 
     * Returns the mesId.
     * 
     * @return the mesId
     */
    public String getMesId() {
        return mesId;
    }

    /** 
     * Sets the mesId.
     * 
     * @param mesId the mesId
     */
    public void setMesId(String mesId) {
        this.mesId = mesId;
    }

    /** 
     * Returns the sendUserId.
     * 
     * @return the sendUserId
     */
    public String getSendUserId() {
        return sendUserId;
    }

    /** 
     * Sets the sendUserId.
     * 
     * @param sendUserId the sendUserId
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    /** 
     * Returns the sendDate.
     * 
     * @return the sendDate
     */
    public Timestamp getSendDate() {
        return sendDate;
    }

    /** 
     * Sets the sendDate.
     * 
     * @param sendDate the sendDate
     */
    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    /** 
     * Returns the receiveUserId.
     * 
     * @return the receiveUserId
     */
    public String getReceiveUserId() {
        return receiveUserId;
    }

    /** 
     * Sets the receiveUserId.
     * 
     * @param receiveUserId the receiveUserId
     */
    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    /** 
     * Returns the receiveDate.
     * 
     * @return the receiveDate
     */
    public Timestamp getReceiveDate() {
        return receiveDate;
    }

    /** 
     * Sets the receiveDate.
     * 
     * @param receiveDate the receiveDate
     */
    public void setReceiveDate(Timestamp receiveDate) {
        this.receiveDate = receiveDate;
    }

    /** 
     * Returns the portalCd.
     * 
     * @return the portalCd
     */
    public String getPortalCd() {
        return portalCd;
    }

    /** 
     * Sets the portalCd.
     * 
     * @param portalCd the portalCd
     */
    public void setPortalCd(String portalCd) {
        this.portalCd = portalCd;
    }

    /** 
     * Returns the menuCd.
     * 
     * @return the menuCd
     */
    public String getMenuCd() {
        return menuCd;
    }

    /** 
     * Sets the menuCd.
     * 
     * @param menuCd the menuCd
     */
    public void setMenuCd(String menuCd) {
        this.menuCd = menuCd;
    }

    /** 
     * Returns the content.
     * 
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /** 
     * Sets the content.
     * 
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /** 
     * Returns the readFlag.
     * 
     * @return the readFlag
     */
    public String getReadFlag() {
        return readFlag;
    }

    /** 
     * Sets the readFlag.
     * 
     * @param readFlag the readFlag
     */
    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    /** 
     * Returns the mesLevel.
     * 
     * @return the mesLevel
     */
    public Short getMesLevel() {
        return mesLevel;
    }

    /** 
     * Sets the mesLevel.
     * 
     * @param mesLevel the mesLevel
     */
    public void setMesLevel(Short mesLevel) {
        this.mesLevel = mesLevel;
    }

    /** 
     * Returns the mesType.
     * 
     * @return the mesType
     */
    public String getMesType() {
        return mesType;
    }

    /** 
     * Sets the mesType.
     * 
     * @param mesType the mesType
     */
    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    /** 
     * Returns the memo.
     * 
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /** 
     * Sets the memo.
     * 
     * @param memo the memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /** 
     * Returns the sortNo.
     * 
     * @return the sortNo
     */
    public String getSortNo() {
        return sortNo;
    }

    /** 
     * Sets the sortNo.
     * 
     * @param sortNo the sortNo
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    /** 
     * Returns the spellNo.
     * 
     * @return the spellNo
     */
    public String getSpellNo() {
        return spellNo;
    }

    /** 
     * Sets the spellNo.
     * 
     * @param spellNo the spellNo
     */
    public void setSpellNo(String spellNo) {
        this.spellNo = spellNo;
    }

    /** 
     * Returns the wubiNo.
     * 
     * @return the wubiNo
     */
    public String getWubiNo() {
        return wubiNo;
    }

    /** 
     * Sets the wubiNo.
     * 
     * @param wubiNo the wubiNo
     */
    public void setWubiNo(String wubiNo) {
        this.wubiNo = wubiNo;
    }

    /** 
     * Returns the updCnt.
     * 
     * @return the updCnt
     */
    public BigInteger getUpdCnt() {
        return updCnt;
    }

    /** 
     * Sets the updCnt.
     * 
     * @param updCnt the updCnt
     */
    public void setUpdCnt(BigInteger updCnt) {
        this.updCnt = updCnt;
    }

    /** 
     * Returns the crtTime.
     * 
     * @return the crtTime
     */
    public Timestamp getCrtTime() {
        return crtTime;
    }

    /** 
     * Sets the crtTime.
     * 
     * @param crtTime the crtTime
     */
    public void setCrtTime(Timestamp crtTime) {
        this.crtTime = crtTime;
    }

    /** 
     * Returns the crtUserId.
     * 
     * @return the crtUserId
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /** 
     * Sets the crtUserId.
     * 
     * @param crtUserId the crtUserId
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    /** 
     * Returns the crtDeptCd.
     * 
     * @return the crtDeptCd
     */
    public String getCrtDeptCd() {
        return crtDeptCd;
    }

    /** 
     * Sets the crtDeptCd.
     * 
     * @param crtDeptCd the crtDeptCd
     */
    public void setCrtDeptCd(String crtDeptCd) {
        this.crtDeptCd = crtDeptCd;
    }

    /** 
     * Returns the lastUpdTime.
     * 
     * @return the lastUpdTime
     */
    public Timestamp getLastUpdTime() {
        return lastUpdTime;
    }

    /** 
     * Sets the lastUpdTime.
     * 
     * @param lastUpdTime the lastUpdTime
     */
    public void setLastUpdTime(Timestamp lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /** 
     * Returns the lastUpdDeptCd.
     * 
     * @return the lastUpdDeptCd
     */
    public String getLastUpdDeptCd() {
        return lastUpdDeptCd;
    }

    /** 
     * Sets the lastUpdDeptCd.
     * 
     * @param lastUpdDeptCd the lastUpdDeptCd
     */
    public void setLastUpdDeptCd(String lastUpdDeptCd) {
        this.lastUpdDeptCd = lastUpdDeptCd;
    }

    /** 
     * Returns the lastUpdUserId.
     * 
     * @return the lastUpdUserId
     */
    public String getLastUpdUserId() {
        return lastUpdUserId;
    }

    /** 
     * Sets the lastUpdUserId.
     * 
     * @param lastUpdUserId the lastUpdUserId
     */
    public void setLastUpdUserId(String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }

    /** 
     * Returns the delF.
     * 
     * @return the delF
     */
    public Short getDelF() {
        return delF;
    }

    /** 
     * Sets the delF.
     * 
     * @param delF the delF
     */
    public void setDelF(Short delF) {
        this.delF = delF;
    }

    /** 
     * Returns the taskId.
     * 
     * @return the taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /** 
     * Sets the taskId.
     * 
     * @param taskId the taskId
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}