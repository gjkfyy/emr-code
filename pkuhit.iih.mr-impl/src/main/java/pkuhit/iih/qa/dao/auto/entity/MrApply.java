package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 病历超时申请表
 */
@Entity(listener = MrApplyListener.class)
@Table(name = "MR_APPLY")
public class MrApply {

    /** 主键 */
    @Id
    @Column(name = "APPLY_CD")
    String applyCd;

    /** 就诊序号 */
    @Column(name = "EN_PK")
    String enPk;

    /** 医疗记录类型编码 */
    @Column(name = "MR_TP_CD")
    String mrTpCd;

    /** 质控项编码 */
    @Column(name = "QA_ITM_CD")
    String qaItmCd;

    /** */
    @Column(name = "QA_AUTO_FLT_PK")
    String qaAutoFltPk;

    /** 申请时间 */
    @Column(name = "APPLY_TIME")
    Timestamp applyTime;

    /** 申请人 */
    @Column(name = "APPLY_DCT_CD")
    String applyDctCd;

    /** 申请状态 */
    @Column(name = "APPLY_STATUS")
    String applyStatus;

    /** 申请说明 */
    @Column(name = "APPLY_DESC")
    String applyDesc;

    /** 科室编码 */
    @Column(name = "DEPT_CD")
    String deptCd;

    /** 审批时间 */
    @Column(name = "APPROVAL_TIME")
    Timestamp approvalTime;

    /** 审批人 */
    @Column(name = "APPROVAL_DCT_CD")
    String approvalDctCd;

    /** 审批备注 */
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
    @Column(name = "APPLY_TYPE_CD")
    String applyTypeCd;

    /** 
     * Returns the applyCd.
     * 
     * @return the applyCd
     */
    public String getApplyCd() {
        return applyCd;
    }

    /** 
     * Sets the applyCd.
     * 
     * @param applyCd the applyCd
     */
    public void setApplyCd(String applyCd) {
        this.applyCd = applyCd;
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
     * Returns the mrTpCd.
     * 
     * @return the mrTpCd
     */
    public String getMrTpCd() {
        return mrTpCd;
    }

    /** 
     * Sets the mrTpCd.
     * 
     * @param mrTpCd the mrTpCd
     */
    public void setMrTpCd(String mrTpCd) {
        this.mrTpCd = mrTpCd;
    }

    /** 
     * Returns the qaItmCd.
     * 
     * @return the qaItmCd
     */
    public String getQaItmCd() {
        return qaItmCd;
    }

    /** 
     * Sets the qaItmCd.
     * 
     * @param qaItmCd the qaItmCd
     */
    public void setQaItmCd(String qaItmCd) {
        this.qaItmCd = qaItmCd;
    }

    /** 
     * Returns the qaAutoFltPk.
     * 
     * @return the qaAutoFltPk
     */
    public String getQaAutoFltPk() {
        return qaAutoFltPk;
    }

    /** 
     * Sets the qaAutoFltPk.
     * 
     * @param qaAutoFltPk the qaAutoFltPk
     */
    public void setQaAutoFltPk(String qaAutoFltPk) {
        this.qaAutoFltPk = qaAutoFltPk;
    }

    /** 
     * Returns the applyTime.
     * 
     * @return the applyTime
     */
    public Timestamp getApplyTime() {
        return applyTime;
    }

    /** 
     * Sets the applyTime.
     * 
     * @param applyTime the applyTime
     */
    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    /** 
     * Returns the applyDctCd.
     * 
     * @return the applyDctCd
     */
    public String getApplyDctCd() {
        return applyDctCd;
    }

    /** 
     * Sets the applyDctCd.
     * 
     * @param applyDctCd the applyDctCd
     */
    public void setApplyDctCd(String applyDctCd) {
        this.applyDctCd = applyDctCd;
    }

    /** 
     * Returns the applyStatus.
     * 
     * @return the applyStatus
     */
    public String getApplyStatus() {
        return applyStatus;
    }

    /** 
     * Sets the applyStatus.
     * 
     * @param applyStatus the applyStatus
     */
    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    /** 
     * Returns the applyDesc.
     * 
     * @return the applyDesc
     */
    public String getApplyDesc() {
        return applyDesc;
    }

    /** 
     * Sets the applyDesc.
     * 
     * @param applyDesc the applyDesc
     */
    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc;
    }

    /** 
     * Returns the deptCd.
     * 
     * @return the deptCd
     */
    public String getDeptCd() {
        return deptCd;
    }

    /** 
     * Sets the deptCd.
     * 
     * @param deptCd the deptCd
     */
    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    /** 
     * Returns the approvalTime.
     * 
     * @return the approvalTime
     */
    public Timestamp getApprovalTime() {
        return approvalTime;
    }

    /** 
     * Sets the approvalTime.
     * 
     * @param approvalTime the approvalTime
     */
    public void setApprovalTime(Timestamp approvalTime) {
        this.approvalTime = approvalTime;
    }

    /** 
     * Returns the approvalDctCd.
     * 
     * @return the approvalDctCd
     */
    public String getApprovalDctCd() {
        return approvalDctCd;
    }

    /** 
     * Sets the approvalDctCd.
     * 
     * @param approvalDctCd the approvalDctCd
     */
    public void setApprovalDctCd(String approvalDctCd) {
        this.approvalDctCd = approvalDctCd;
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
     * Returns the applyTypeCd.
     * 
     * @return the applyTypeCd
     */
    public String getApplyTypeCd() {
        return applyTypeCd;
    }

    /** 
     * Sets the applyTypeCd.
     * 
     * @param applyTypeCd the applyTypeCd
     */
    public void setApplyTypeCd(String applyTypeCd) {
        this.applyTypeCd = applyTypeCd;
    }
}