package iih.mr.db.gen.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * MR
 */
@Entity(listener = MrEntityListener.class)
@Table(name = "MR")
public class MrEntity {

    /** */
    @Id
    @Column(name = "MR_PK")
    String mrPk;

    /** */
    @Column(name = "EN_PK")
    String enPk;

    /** */
    @Column(name = "MR_TPL_CD")
    String mrTplCd;

    /** */
    @Column(name = "FILE_PK")
    String filePk;

    /** */
    @Column(name = "NM")
    String nm;

    /** */
    @Column(name = "MR_TP_CD")
    String mrTpCd;

    /** */
    @Column(name = "MR_STA_CD")
    String mrStaCd;

    /** */
    @Column(name = "MR_QA_STA_CD")
    String mrQaStaCd;

    /** */
    @Column(name = "EDIG_LOCK_F")
    Short edigLockF;

    /** 0：未驳回
1：已驳回 */
    @Column(name = "REJECT_F")
    Short rejectF;

    /** 0：未完成
1：已完成 */
    @Column(name = "COMPLETE_F")
    Short completeF;

    /** */
    @Column(name = "SIGN_LVL_CD")
    String signLvlCd;

    /** 医疗记录对应医疗活动的发生时间 */
    @Column(name = "BIZ_TIME")
    Timestamp bizTime;

    /** superior doctor */
    @Column(name = "SUP_DCT_ID")
    String supDctId;

    /** */
    @Column(name = "LGC_SMT_TIME")
    Timestamp lgcSmtTime;

    /** */
    @Column(name = "LGC_SMT_USER_ID")
    String lgcSmtUserId;

    /** */
    @Column(name = "LGC_SMT_DEPT_CD")
    String lgcSmtDeptCd;

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

    /** 
     * Returns the mrPk.
     * 
     * @return the mrPk
     */
    public String getMrPk() {
        return mrPk;
    }

    /** 
     * Sets the mrPk.
     * 
     * @param mrPk the mrPk
     */
    public void setMrPk(String mrPk) {
        this.mrPk = mrPk;
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
     * Returns the mrTplCd.
     * 
     * @return the mrTplCd
     */
    public String getMrTplCd() {
        return mrTplCd;
    }

    /** 
     * Sets the mrTplCd.
     * 
     * @param mrTplCd the mrTplCd
     */
    public void setMrTplCd(String mrTplCd) {
        this.mrTplCd = mrTplCd;
    }

    /** 
     * Returns the filePk.
     * 
     * @return the filePk
     */
    public String getFilePk() {
        return filePk;
    }

    /** 
     * Sets the filePk.
     * 
     * @param filePk the filePk
     */
    public void setFilePk(String filePk) {
        this.filePk = filePk;
    }

    /** 
     * Returns the nm.
     * 
     * @return the nm
     */
    public String getNm() {
        return nm;
    }

    /** 
     * Sets the nm.
     * 
     * @param nm the nm
     */
    public void setNm(String nm) {
        this.nm = nm;
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
     * Returns the mrStaCd.
     * 
     * @return the mrStaCd
     */
    public String getMrStaCd() {
        return mrStaCd;
    }

    /** 
     * Sets the mrStaCd.
     * 
     * @param mrStaCd the mrStaCd
     */
    public void setMrStaCd(String mrStaCd) {
        this.mrStaCd = mrStaCd;
    }

    /** 
     * Returns the mrQaStaCd.
     * 
     * @return the mrQaStaCd
     */
    public String getMrQaStaCd() {
        return mrQaStaCd;
    }

    /** 
     * Sets the mrQaStaCd.
     * 
     * @param mrQaStaCd the mrQaStaCd
     */
    public void setMrQaStaCd(String mrQaStaCd) {
        this.mrQaStaCd = mrQaStaCd;
    }

    /** 
     * Returns the edigLockF.
     * 
     * @return the edigLockF
     */
    public Short getEdigLockF() {
        return edigLockF;
    }

    /** 
     * Sets the edigLockF.
     * 
     * @param edigLockF the edigLockF
     */
    public void setEdigLockF(Short edigLockF) {
        this.edigLockF = edigLockF;
    }

    /** 
     * Returns the rejectF.
     * 
     * @return the rejectF
     */
    public Short getRejectF() {
        return rejectF;
    }

    /** 
     * Sets the rejectF.
     * 
     * @param rejectF the rejectF
     */
    public void setRejectF(Short rejectF) {
        this.rejectF = rejectF;
    }

    /** 
     * Returns the completeF.
     * 
     * @return the completeF
     */
    public Short getCompleteF() {
        return completeF;
    }

    /** 
     * Sets the completeF.
     * 
     * @param completeF the completeF
     */
    public void setCompleteF(Short completeF) {
        this.completeF = completeF;
    }

    /** 
     * Returns the signLvlCd.
     * 
     * @return the signLvlCd
     */
    public String getSignLvlCd() {
        return signLvlCd;
    }

    /** 
     * Sets the signLvlCd.
     * 
     * @param signLvlCd the signLvlCd
     */
    public void setSignLvlCd(String signLvlCd) {
        this.signLvlCd = signLvlCd;
    }

    /** 
     * Returns the bizTime.
     * 
     * @return the bizTime
     */
    public Timestamp getBizTime() {
        return bizTime;
    }

    /** 
     * Sets the bizTime.
     * 
     * @param bizTime the bizTime
     */
    public void setBizTime(Timestamp bizTime) {
        this.bizTime = bizTime;
    }

    /** 
     * Returns the supDctId.
     * 
     * @return the supDctId
     */
    public String getSupDctId() {
        return supDctId;
    }

    /** 
     * Sets the supDctId.
     * 
     * @param supDctId the supDctId
     */
    public void setSupDctId(String supDctId) {
        this.supDctId = supDctId;
    }

    /** 
     * Returns the lgcSmtTime.
     * 
     * @return the lgcSmtTime
     */
    public Timestamp getLgcSmtTime() {
        return lgcSmtTime;
    }

    /** 
     * Sets the lgcSmtTime.
     * 
     * @param lgcSmtTime the lgcSmtTime
     */
    public void setLgcSmtTime(Timestamp lgcSmtTime) {
        this.lgcSmtTime = lgcSmtTime;
    }

    /** 
     * Returns the lgcSmtUserId.
     * 
     * @return the lgcSmtUserId
     */
    public String getLgcSmtUserId() {
        return lgcSmtUserId;
    }

    /** 
     * Sets the lgcSmtUserId.
     * 
     * @param lgcSmtUserId the lgcSmtUserId
     */
    public void setLgcSmtUserId(String lgcSmtUserId) {
        this.lgcSmtUserId = lgcSmtUserId;
    }

    /** 
     * Returns the lgcSmtDeptCd.
     * 
     * @return the lgcSmtDeptCd
     */
    public String getLgcSmtDeptCd() {
        return lgcSmtDeptCd;
    }

    /** 
     * Sets the lgcSmtDeptCd.
     * 
     * @param lgcSmtDeptCd the lgcSmtDeptCd
     */
    public void setLgcSmtDeptCd(String lgcSmtDeptCd) {
        this.lgcSmtDeptCd = lgcSmtDeptCd;
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
}