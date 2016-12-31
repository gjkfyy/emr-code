package iih.di.db.gen.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 医疗记录
 */
@Entity(listener = MrEntityListener.class)
@Table(name = "MR")
public class MrEntity {

    /** 主键 */
    @Id
    @Column(name = "MR_PK")
    String mrPk;

    /** 医疗记录类型编码 */
    @Column(name = "MR_TP_CD")
    String mrTpCd;

    /** 就诊编码 */
    @Column(name = "EN_PK")
    String enPk;

    /** 模板类型编码 */
    @Column(name = "MR_TPL_CD")
    String mrTplCd;

    /** 病历文件编码1 */
    @Column(name = "FILE_PK")
    String filePk;

    /** 名称 */
    @Column(name = "NM")
    String nm;

    /** encounter_sn */
    @Column(name = "ENCOUNTER_SN")
    String encounterSn;

    /** 医疗记录状态 */
    @Column(name = "MR_STA_CD")
    String mrStaCd;

    /** 医疗质控状态编码 */
    @Column(name = "MR_QA_STA_CD")
    String mrQaStaCd;

    /** 完成编码 */
    @Column(name = "COMPLETED_F")
    Short completedF;

    /** 审签级别 */
    @Column(name = "SIGN_LVL_CD")
    String signLvlCd;

    /** 业务时间 */
    @Column(name = "BIZ_TIME")
    Timestamp bizTime;

    /** 上级查房医生 */
    @Column(name = "SUP_DCT_ID")
    String supDctId;

    /** 提交人 */
    @Column(name = "SUBMIT_CD")
    String submitCd;

    /** 提交时间 */
    @Column(name = "SUBMIT_DATE")
    Timestamp submitDate;

    /** 科室编码 */
    @Column(name = "DEPT_CD")
    String deptCd;

    /** 经治医生 */
    @Column(name = "TREAT_DOCTOR_CD")
    String treatDoctorCd;

    /** 主治医生 */
    @Column(name = "MAST_DOCTOR_CD")
    String mastDoctorCd;

    /** 主治医生审签时间 */
    @Column(name = "MAST_DOCTOR_DATE")
    Timestamp mastDoctorDate;

    /** 主任医生 */
    @Column(name = "DIR_DOCTOR_CD")
    String dirDoctorCd;

    /** 主任医生审签时间 */
    @Column(name = "DIR_DOCTOR_DATE")
    Timestamp dirDoctorDate;

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

    /** 逻辑提交时间 */
    @Column(name = "LGC_SMT_TIME")
    Timestamp lgcSmtTime;

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
     * Returns the encounterSn.
     * 
     * @return the encounterSn
     */
    public String getEncounterSn() {
        return encounterSn;
    }

    /** 
     * Sets the encounterSn.
     * 
     * @param encounterSn the encounterSn
     */
    public void setEncounterSn(String encounterSn) {
        this.encounterSn = encounterSn;
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
     * Returns the completedF.
     * 
     * @return the completedF
     */
    public Short getCompletedF() {
        return completedF;
    }

    /** 
     * Sets the completedF.
     * 
     * @param completedF the completedF
     */
    public void setCompletedF(Short completedF) {
        this.completedF = completedF;
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
     * Returns the submitCd.
     * 
     * @return the submitCd
     */
    public String getSubmitCd() {
        return submitCd;
    }

    /** 
     * Sets the submitCd.
     * 
     * @param submitCd the submitCd
     */
    public void setSubmitCd(String submitCd) {
        this.submitCd = submitCd;
    }

    /** 
     * Returns the submitDate.
     * 
     * @return the submitDate
     */
    public Timestamp getSubmitDate() {
        return submitDate;
    }

    /** 
     * Sets the submitDate.
     * 
     * @param submitDate the submitDate
     */
    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
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
     * Returns the treatDoctorCd.
     * 
     * @return the treatDoctorCd
     */
    public String getTreatDoctorCd() {
        return treatDoctorCd;
    }

    /** 
     * Sets the treatDoctorCd.
     * 
     * @param treatDoctorCd the treatDoctorCd
     */
    public void setTreatDoctorCd(String treatDoctorCd) {
        this.treatDoctorCd = treatDoctorCd;
    }

    /** 
     * Returns the mastDoctorCd.
     * 
     * @return the mastDoctorCd
     */
    public String getMastDoctorCd() {
        return mastDoctorCd;
    }

    /** 
     * Sets the mastDoctorCd.
     * 
     * @param mastDoctorCd the mastDoctorCd
     */
    public void setMastDoctorCd(String mastDoctorCd) {
        this.mastDoctorCd = mastDoctorCd;
    }

    /** 
     * Returns the mastDoctorDate.
     * 
     * @return the mastDoctorDate
     */
    public Timestamp getMastDoctorDate() {
        return mastDoctorDate;
    }

    /** 
     * Sets the mastDoctorDate.
     * 
     * @param mastDoctorDate the mastDoctorDate
     */
    public void setMastDoctorDate(Timestamp mastDoctorDate) {
        this.mastDoctorDate = mastDoctorDate;
    }

    /** 
     * Returns the dirDoctorCd.
     * 
     * @return the dirDoctorCd
     */
    public String getDirDoctorCd() {
        return dirDoctorCd;
    }

    /** 
     * Sets the dirDoctorCd.
     * 
     * @param dirDoctorCd the dirDoctorCd
     */
    public void setDirDoctorCd(String dirDoctorCd) {
        this.dirDoctorCd = dirDoctorCd;
    }

    /** 
     * Returns the dirDoctorDate.
     * 
     * @return the dirDoctorDate
     */
    public Timestamp getDirDoctorDate() {
        return dirDoctorDate;
    }

    /** 
     * Sets the dirDoctorDate.
     * 
     * @param dirDoctorDate the dirDoctorDate
     */
    public void setDirDoctorDate(Timestamp dirDoctorDate) {
        this.dirDoctorDate = dirDoctorDate;
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
}