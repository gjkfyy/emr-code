package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 整改通知
 */
@Entity(listener = QaRevisionNoticeListener.class)
@Table(name = "QA_REVISION_NOTICE")
public class QaRevisionNotice {

    /** 主键 */
    @Id
    @Column(name = "REVISION_CD")
    String revisionCd;

    /** 状态 */
    @Column(name = "STATUS")
    String status;

    /** 发送时间 */
    @Column(name = "SEND_TIME")
    Timestamp sendTime;

    /** 质控医师 */
    @Column(name = "EXEC_DOCTOR_CD")
    String execDoctorCd;

    /** 整改期限 */
    @Column(name = "RFM_DEADLINE")
    BigInteger rfmDeadline;

    /** 截止时间 */
    @Column(name = "DEADLINE")
    Timestamp deadline;

    /** 质控科室 */
    @Column(name = "EXEC_DEPT_CD")
    String execDeptCd;

    /** 就诊序号 */
    @Column(name = "EN_PK")
    String enPk;

    /** 整改医生 */
    @Column(name = "RFM_DOCTOR_CD")
    String rfmDoctorCd;

    /** 整改科室 */
    @Column(name = "RFM_DEPT_CD")
    String rfmDeptCd;

    /** 质控类型 */
    @Column(name = "QA_TY_CD")
    String qaTyCd;

    /** 完成标志 */
    @Column(name = "CMPL_F")
    String cmplF;

    /** 整改完成时间 */
    @Column(name = "RFM_TIME")
    Timestamp rfmTime;

    /** 审核时间 */
    @Column(name = "VRF_TIME")
    Timestamp vrfTime;

    /** 整改说明 */
    @Column(name = "DES")
    String des;

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

    /** 审核人 */
    @Column(name = "VRF_USER_ID")
    String vrfUserId;

    /** 审核科室 */
    @Column(name = "VRF_DEPT_CD")
    String vrfDeptCd;
    
    /** 
     * Returns the revisionCd.
     * 
     * @return the revisionCd
     */
    public String getRevisionCd() {
        return revisionCd;
    }

    /** 
     * Sets the revisionCd.
     * 
     * @param revisionCd the revisionCd
     */
    public void setRevisionCd(String revisionCd) {
        this.revisionCd = revisionCd;
    }

    /** 
     * Returns the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /** 
     * Sets the status.
     * 
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 
     * Returns the sendTime.
     * 
     * @return the sendTime
     */
    public Timestamp getSendTime() {
        return sendTime;
    }

    /** 
     * Sets the sendTime.
     * 
     * @param sendTime the sendTime
     */
    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    /** 
     * Returns the execDoctorCd.
     * 
     * @return the execDoctorCd
     */
    public String getExecDoctorCd() {
        return execDoctorCd;
    }

    /** 
     * Sets the execDoctorCd.
     * 
     * @param execDoctorCd the execDoctorCd
     */
    public void setExecDoctorCd(String execDoctorCd) {
        this.execDoctorCd = execDoctorCd;
    }

    /** 
     * Returns the rfmDeadline.
     * 
     * @return the rfmDeadline
     */
    public BigInteger getRfmDeadline() {
        return rfmDeadline;
    }

    /** 
     * Sets the rfmDeadline.
     * 
     * @param rfmDeadline the rfmDeadline
     */
    public void setRfmDeadline(BigInteger rfmDeadline) {
        this.rfmDeadline = rfmDeadline;
    }

    /** 
     * Returns the deadline.
     * 
     * @return the deadline
     */
    public Timestamp getDeadline() {
        return deadline;
    }

    /** 
     * Sets the deadline.
     * 
     * @param deadline the deadline
     */
    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    /** 
     * Returns the execDeptCd.
     * 
     * @return the execDeptCd
     */
    public String getExecDeptCd() {
        return execDeptCd;
    }

    /** 
     * Sets the execDeptCd.
     * 
     * @param execDeptCd the execDeptCd
     */
    public void setExecDeptCd(String execDeptCd) {
        this.execDeptCd = execDeptCd;
    }

    /** 
     * Returns the enPk.
     * 
     * @return the enPk
     */
    public String getEnPk() {
        return enPk;
    }

    /** 
     * Sets the enPk.
     * 
     * @param enPk the enPk
     */
    public void setEnPk(String enPk) {
        this.enPk = enPk;
    }

    /** 
     * Returns the rfmDoctorCd.
     * 
     * @return the rfmDoctorCd
     */
    public String getRfmDoctorCd() {
        return rfmDoctorCd;
    }

    /** 
     * Sets the rfmDoctorCd.
     * 
     * @param rfmDoctorCd the rfmDoctorCd
     */
    public void setRfmDoctorCd(String rfmDoctorCd) {
        this.rfmDoctorCd = rfmDoctorCd;
    }

    /** 
     * Returns the rfmDeptCd.
     * 
     * @return the rfmDeptCd
     */
    public String getRfmDeptCd() {
        return rfmDeptCd;
    }

    /** 
     * Sets the rfmDeptCd.
     * 
     * @param rfmDeptCd the rfmDeptCd
     */
    public void setRfmDeptCd(String rfmDeptCd) {
        this.rfmDeptCd = rfmDeptCd;
    }

    /** 
     * Returns the qaTyCd.
     * 
     * @return the qaTyCd
     */
    public String getQaTyCd() {
        return qaTyCd;
    }

    /** 
     * Sets the qaTyCd.
     * 
     * @param qaTyCd the qaTyCd
     */
    public void setQaTyCd(String qaTyCd) {
        this.qaTyCd = qaTyCd;
    }

    /** 
     * Returns the cmplF.
     * 
     * @return the cmplF
     */
    public String getCmplF() {
        return cmplF;
    }

    /** 
     * Sets the cmplF.
     * 
     * @param cmplF the cmplF
     */
    public void setCmplF(String cmplF) {
        this.cmplF = cmplF;
    }

    /** 
     * Returns the rfmTime.
     * 
     * @return the rfmTime
     */
    public Timestamp getRfmTime() {
        return rfmTime;
    }

    /** 
     * Sets the rfmTime.
     * 
     * @param rfmTime the rfmTime
     */
    public void setRfmTime(Timestamp rfmTime) {
        this.rfmTime = rfmTime;
    }

    /** 
     * Returns the vrfTime.
     * 
     * @return the vrfTime
     */
    public Timestamp getVrfTime() {
        return vrfTime;
    }

    /** 
     * Sets the vrfTime.
     * 
     * @param vrfTime the vrfTime
     */
    public void setVrfTime(Timestamp vrfTime) {
        this.vrfTime = vrfTime;
    }

    /** 
     * Returns the des.
     * 
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /** 
     * Sets the des.
     * 
     * @param des the des
     */
    public void setDes(String des) {
        this.des = des;
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
     * Returns the vrfUserId.
     * 
     * @return the vrfUserId
     */
    public String getVrfUserId() {
        return vrfUserId;
    }

    /** 
     * Sets the vrfUserId.
     * 
     * @param vrfUserId the vrfUserId
     */
    public void setVrfUserId(String vrfUserId) {
        this.vrfUserId = vrfUserId;
    }

    /** 
     * Returns the vrfDeptCd.
     * 
     * @return the vrfDeptCd
     */
    public String getVrfDeptCd() {
        return vrfDeptCd;
    }

    /** 
     * Sets the vrfDeptCd.
     * 
     * @param vrfDeptCd the vrfDeptCd
     */
    public void setVrfDeptCd(String vrfDeptCd) {
        this.vrfDeptCd = vrfDeptCd;
    }
    
}