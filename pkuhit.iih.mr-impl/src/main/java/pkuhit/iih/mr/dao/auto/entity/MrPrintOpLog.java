package pkuhit.iih.mr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 病历打印操作日志
 */
@Entity(listener = MrPrintOpLogListener.class)
@Table(name = "MR_PRINT_OP_LOG")
public class MrPrintOpLog {

    /** 病历打印操作日志主键 */
    @Id
    @Column(name = "PRINT_LOG_CD")
    String printLogCd;

    /** 就诊主键 */
    @Column(name = "EN_PK")
    String enPk;

    /** 患者ID */
    @Column(name = "PA_ID")
    String paId;

    /** 就诊次数 */
    @Column(name = "EN_CNT")
    String enCnt;

    /** 文书编码 */
    @Column(name = "MR_PK")
    String mrPk;

    /** 医生编码 */
    @Column(name = "PRINT_DOCTOR_CD")
    String printDoctorCd;

    /** 打印时间 */
    @Column(name = "PRINT_TIME")
    Timestamp printTime;

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

    /** 
     * Returns the printLogCd.
     * 
     * @return the printLogCd
     */
    public String getPrintLogCd() {
        return printLogCd;
    }

    /** 
     * Sets the printLogCd.
     * 
     * @param printLogCd the printLogCd
     */
    public void setPrintLogCd(String printLogCd) {
        this.printLogCd = printLogCd;
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
     * Returns the paId.
     * 
     * @return the paId
     */
    public String getPaId() {
        return paId;
    }

    /** 
     * Sets the paId.
     * 
     * @param paId the paId
     */
    public void setPaId(String paId) {
        this.paId = paId;
    }

    /** 
     * Returns the enCnt.
     * 
     * @return the enCnt
     */
    public String getEnCnt() {
        return enCnt;
    }

    /** 
     * Sets the enCnt.
     * 
     * @param enCnt the enCnt
     */
    public void setEnCnt(String enCnt) {
        this.enCnt = enCnt;
    }

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
     * Returns the printDoctorCd.
     * 
     * @return the printDoctorCd
     */
    public String getPrintDoctorCd() {
        return printDoctorCd;
    }

    /** 
     * Sets the printDoctorCd.
     * 
     * @param printDoctorCd the printDoctorCd
     */
    public void setPrintDoctorCd(String printDoctorCd) {
        this.printDoctorCd = printDoctorCd;
    }

    /** 
     * Returns the printTime.
     * 
     * @return the printTime
     */
    public Timestamp getPrintTime() {
        return printTime;
    }

    /** 
     * Sets the printTime.
     * 
     * @param printTime the printTime
     */
    public void setPrintTime(Timestamp printTime) {
        this.printTime = printTime;
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
}