package ei.his.db.dao.auto.entity;

import java.util.Date;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = IemrEnAdtEntityListener.class)
@Table(name = "IEMR_EN_ADT")
public class IemrEnAdtEntity {


    /** */
    @Id
    @Column(name = "en_adt_cd")
    String enAdtCd;

    /** */
    @Column(name = "en_pk")
    String enPk;

    /** */
    @Column(name = "patient_id")
    String patientId;

    /** */
    @Column(name = "en_cnt")
    String enCnt;

    /** */
    @Column(name = "ledger_sn")
    Integer ledgerSn;

    /** */
    @Column(name = "trans_times")
    Integer transTimes;

    /** */
    @Column(name = "admiss_date")
    Date admissDate;

    /** */
    @Column(name = "dis_date")
    Date disDate;

    /** */
    @Column(name = "trans_reg_date")
    Date transRegDate;

    /** */
    @Column(name = "trans_date")
    Date transDate;

    /** */
    @Column(name = "trans_type")
    String transType;

    /** */
    @Column(name = "orig_dept")
    String origDept;

    /** */
    @Column(name = "orig_ward")
    String origWard;

    /** */
    @Column(name = "orig_room")
    String origRoom;

    /** */
    @Column(name = "orig_bed")
    String origBed;

    /** */
    @Column(name = "orig_opera")
    String origOpera;

    /** */
    @Column(name = "curr_dept")
    String currDept;

    /** */
    @Column(name = "curr_ward")
    String currWard;

    /** */
    @Column(name = "curr_room")
    String currRoom;

    /** */
    @Column(name = "curr_bed")
    String currBed;

    /** */
    @Column(name = "curr_opera")
    String currOpera;

    /** */
    @Column(name = "mark")
    String mark;
    /** */
    @Column(name = "flag")
    String flag;

    
    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
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
    public Integer getLedgerSn() {
        return ledgerSn;
    }

    /** 
     * Sets the ledgerSn.
     * 
     * @param ledgerSn the ledgerSn
     */
    public void setLedgerSn(Integer ledgerSn) {
        this.ledgerSn = ledgerSn;
    }

    /** 
     * Returns the transTimes.
     * 
     * @return the transTimes
     */
    public Integer getTransTimes() {
        return transTimes;
    }

    /** 
     * Sets the transTimes.
     * 
     * @param transTimes the transTimes
     */
    public void setTransTimes(Integer transTimes) {
        this.transTimes = transTimes;
    }

    /** 
     * Returns the admissDate.
     * 
     * @return the admissDate
     */
    public Date getAdmissDate() {
        return admissDate;
    }

    /** 
     * Sets the admissDate.
     * 
     * @param admissDate the admissDate
     */
    public void setAdmissDate(Date admissDate) {
        this.admissDate = admissDate;
    }

    /** 
     * Returns the disDate.
     * 
     * @return the disDate
     */
    public Date getDisDate() {
        return disDate;
    }

    /** 
     * Sets the disDate.
     * 
     * @param disDate the disDate
     */
    public void setDisDate(Date disDate) {
        this.disDate = disDate;
    }

    /** 
     * Returns the transRegDate.
     * 
     * @return the transRegDate
     */
    public Date getTransRegDate() {
        return transRegDate;
    }

    /** 
     * Sets the transRegDate.
     * 
     * @param transRegDate the transRegDate
     */
    public void setTransRegDate(Date transRegDate) {
        this.transRegDate = transRegDate;
    }

    /** 
     * Returns the transDate.
     * 
     * @return the transDate
     */
    public Date getTransDate() {
        return transDate;
    }

    /** 
     * Sets the transDate.
     * 
     * @param transDate the transDate
     */
    public void setTransDate(Date transDate) {
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