package pkuhit.iih.mr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 *  转科记录本地查询
 */
@Entity(listener = EnAdtEntityListener.class)
@Table(name = "EN_ADT")
public class EnAdtEntity {

    /** 转科CD */
    @Id
    @Column(name = "EN_ADT_CD")
    String enAdtCd;

    /** 就诊序号 */
    @Column(name = "EN_PK")
    String enPk;

    /** 患者ID */
    @Column(name = "PATIENT_ID")
    String patientId;

    /** 就诊/住院次数 */
    @Column(name = "EN_CNT")
    String enCnt;

    /** 结账次数 */
    @Column(name = "LEDGER_SN")
    BigInteger ledgerSn;

    /** 转床次数 */
    @Column(name = "TRANS_TIMES")
    BigInteger transTimes;

    /** 住院时间 */
    @Column(name = "ADMISS_DATE")
    Timestamp admissDate;

    /** 出院时间 */
    @Column(name = "DIS_DATE")
    Timestamp disDate;

    /** 申请转科时间 */
    @Column(name = "TRANS_REG_DATE")
    Timestamp transRegDate;

    /** 转科日期 */
    @Column(name = "TRANS_DATE")
    Timestamp transDate;

    /** 转科类型:01转科;02转病区;03转房间;04转床 */
    @Column(name = "TRANS_TYPE")
    String transType;

    /** 原科室 */
    @Column(name = "ORIG_DEPT")
    String origDept;

    /** 原病区 */
    @Column(name = "ORIG_WARD")
    String origWard;

    /** 原房间号 */
    @Column(name = "ORIG_ROOM")
    String origRoom;

    /** 原床位 */
    @Column(name = "ORIG_BED")
    String origBed;

    /** 申请转科操作人 */
    @Column(name = "ORIG_OPERA")
    String origOpera;

    /** 新科室 */
    @Column(name = "CURR_DEPT")
    String currDept;

    /** 新病区 */
    @Column(name = "CURR_WARD")
    String currWard;

    /** 新房间号 */
    @Column(name = "CURR_ROOM")
    String currRoom;

    /** 新床位 */
    @Column(name = "CURR_BED")
    String currBed;

    /** 确认转科操作人 */
    @Column(name = "CURR_OPERA")
    String currOpera;

    /** 标记 */
    @Column(name = "MARK")
    String mark;

    /** 
     * Returns the enAdtCd.
     * 
     * @return the enAdtCd
     */
    public String getEnAdtCd() {
        return enAdtCd;
    }

    /** 
     * Sets the enAdtCd.
     * 
     * @param enAdtCd the enAdtCd
     */
    public void setEnAdtCd(String enAdtCd) {
        this.enAdtCd = enAdtCd;
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
     * Returns the patientId.
     * 
     * @return the patientId
     */
    public String getPatientId() {
        return patientId;
    }

    /** 
     * Sets the patientId.
     * 
     * @param patientId the patientId
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
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
     * Returns the ledgerSn.
     * 
     * @return the ledgerSn
     */
    public BigInteger getLedgerSn() {
        return ledgerSn;
    }

    /** 
     * Sets the ledgerSn.
     * 
     * @param ledgerSn the ledgerSn
     */
    public void setLedgerSn(BigInteger ledgerSn) {
        this.ledgerSn = ledgerSn;
    }

    /** 
     * Returns the transTimes.
     * 
     * @return the transTimes
     */
    public BigInteger getTransTimes() {
        return transTimes;
    }

    /** 
     * Sets the transTimes.
     * 
     * @param transTimes the transTimes
     */
    public void setTransTimes(BigInteger transTimes) {
        this.transTimes = transTimes;
    }

    /** 
     * Returns the admissDate.
     * 
     * @return the admissDate
     */
    public Timestamp getAdmissDate() {
        return admissDate;
    }

    /** 
     * Sets the admissDate.
     * 
     * @param admissDate the admissDate
     */
    public void setAdmissDate(Timestamp admissDate) {
        this.admissDate = admissDate;
    }

    /** 
     * Returns the disDate.
     * 
     * @return the disDate
     */
    public Timestamp getDisDate() {
        return disDate;
    }

    /** 
     * Sets the disDate.
     * 
     * @param disDate the disDate
     */
    public void setDisDate(Timestamp disDate) {
        this.disDate = disDate;
    }

    /** 
     * Returns the transRegDate.
     * 
     * @return the transRegDate
     */
    public Timestamp getTransRegDate() {
        return transRegDate;
    }

    /** 
     * Sets the transRegDate.
     * 
     * @param transRegDate the transRegDate
     */
    public void setTransRegDate(Timestamp transRegDate) {
        this.transRegDate = transRegDate;
    }

    /** 
     * Returns the transDate.
     * 
     * @return the transDate
     */
    public Timestamp getTransDate() {
        return transDate;
    }

    /** 
     * Sets the transDate.
     * 
     * @param transDate the transDate
     */
    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    /** 
     * Returns the transType.
     * 
     * @return the transType
     */
    public String getTransType() {
        return transType;
    }

    /** 
     * Sets the transType.
     * 
     * @param transType the transType
     */
    public void setTransType(String transType) {
        this.transType = transType;
    }

    /** 
     * Returns the origDept.
     * 
     * @return the origDept
     */
    public String getOrigDept() {
        return origDept;
    }

    /** 
     * Sets the origDept.
     * 
     * @param origDept the origDept
     */
    public void setOrigDept(String origDept) {
        this.origDept = origDept;
    }

    /** 
     * Returns the origWard.
     * 
     * @return the origWard
     */
    public String getOrigWard() {
        return origWard;
    }

    /** 
     * Sets the origWard.
     * 
     * @param origWard the origWard
     */
    public void setOrigWard(String origWard) {
        this.origWard = origWard;
    }

    /** 
     * Returns the origRoom.
     * 
     * @return the origRoom
     */
    public String getOrigRoom() {
        return origRoom;
    }

    /** 
     * Sets the origRoom.
     * 
     * @param origRoom the origRoom
     */
    public void setOrigRoom(String origRoom) {
        this.origRoom = origRoom;
    }

    /** 
     * Returns the origBed.
     * 
     * @return the origBed
     */
    public String getOrigBed() {
        return origBed;
    }

    /** 
     * Sets the origBed.
     * 
     * @param origBed the origBed
     */
    public void setOrigBed(String origBed) {
        this.origBed = origBed;
    }

    /** 
     * Returns the origOpera.
     * 
     * @return the origOpera
     */
    public String getOrigOpera() {
        return origOpera;
    }

    /** 
     * Sets the origOpera.
     * 
     * @param origOpera the origOpera
     */
    public void setOrigOpera(String origOpera) {
        this.origOpera = origOpera;
    }

    /** 
     * Returns the currDept.
     * 
     * @return the currDept
     */
    public String getCurrDept() {
        return currDept;
    }

    /** 
     * Sets the currDept.
     * 
     * @param currDept the currDept
     */
    public void setCurrDept(String currDept) {
        this.currDept = currDept;
    }

    /** 
     * Returns the currWard.
     * 
     * @return the currWard
     */
    public String getCurrWard() {
        return currWard;
    }

    /** 
     * Sets the currWard.
     * 
     * @param currWard the currWard
     */
    public void setCurrWard(String currWard) {
        this.currWard = currWard;
    }

    /** 
     * Returns the currRoom.
     * 
     * @return the currRoom
     */
    public String getCurrRoom() {
        return currRoom;
    }

    /** 
     * Sets the currRoom.
     * 
     * @param currRoom the currRoom
     */
    public void setCurrRoom(String currRoom) {
        this.currRoom = currRoom;
    }

    /** 
     * Returns the currBed.
     * 
     * @return the currBed
     */
    public String getCurrBed() {
        return currBed;
    }

    /** 
     * Sets the currBed.
     * 
     * @param currBed the currBed
     */
    public void setCurrBed(String currBed) {
        this.currBed = currBed;
    }

    /** 
     * Returns the currOpera.
     * 
     * @return the currOpera
     */
    public String getCurrOpera() {
        return currOpera;
    }

    /** 
     * Sets the currOpera.
     * 
     * @param currOpera the currOpera
     */
    public void setCurrOpera(String currOpera) {
        this.currOpera = currOpera;
    }

    /** 
     * Returns the mark.
     * 
     * @return the mark
     */
    public String getMark() {
        return mark;
    }

    /** 
     * Sets the mark.
     * 
     * @param mark the mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }
}