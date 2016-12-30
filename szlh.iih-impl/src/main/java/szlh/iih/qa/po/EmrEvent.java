package szlh.iih.qa.po;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = EmrEventListener.class)
@Table(name = "emr_event")
public class EmrEvent {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventid")
    Integer eventid;

    /** */
    @Column(name = "recid")
    Integer recid;

    /** */
    @Column(name = "eventtype")
    String eventtype;

    /** */
    @Column(name = "happentime")
    Timestamp happentime;

    /** */
    @Column(name = "note")
    String note;

    /** */
    @Column(name = "treattime")
    Timestamp treattime;

    /** */
    @Column(name = "endtime")
    Timestamp endtime;

    /** */
    @Column(name = "evt_source")
    String evtSource;

    /** */
    @Column(name = "order_sn")
    Integer orderSn;

    /** */
    @Column(name = "enc_id")
    Integer encId;

    /** */
    @Column(name = "deleted_flag")
    String deletedFlag;

    /** 
     * Returns the eventid.
     * 
     * @return the eventid
     */
    public Integer getEventid() {
        return eventid;
    }

    /** 
     * Sets the eventid.
     * 
     * @param eventid the eventid
     */
    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    /** 
     * Returns the recid.
     * 
     * @return the recid
     */
    public Integer getRecid() {
        return recid;
    }

    /** 
     * Sets the recid.
     * 
     * @param recid the recid
     */
    public void setRecid(Integer recid) {
        this.recid = recid;
    }

    /** 
     * Returns the eventtype.
     * 
     * @return the eventtype
     */
    public String getEventtype() {
        return eventtype;
    }

    /** 
     * Sets the eventtype.
     * 
     * @param eventtype the eventtype
     */
    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    /** 
     * Returns the happentime.
     * 
     * @return the happentime
     */
    public Timestamp getHappentime() {
        return happentime;
    }

    /** 
     * Sets the happentime.
     * 
     * @param happentime the happentime
     */
    public void setHappentime(Timestamp happentime) {
        this.happentime = happentime;
    }

    /** 
     * Returns the note.
     * 
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /** 
     * Sets the note.
     * 
     * @param note the note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /** 
     * Returns the treattime.
     * 
     * @return the treattime
     */
    public Timestamp getTreattime() {
        return treattime;
    }

    /** 
     * Sets the treattime.
     * 
     * @param treattime the treattime
     */
    public void setTreattime(Timestamp treattime) {
        this.treattime = treattime;
    }

    /** 
     * Returns the endtime.
     * 
     * @return the endtime
     */
    public Timestamp getEndtime() {
        return endtime;
    }

    /** 
     * Sets the endtime.
     * 
     * @param endtime the endtime
     */
    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    /** 
     * Returns the evtSource.
     * 
     * @return the evtSource
     */
    public String getEvtSource() {
        return evtSource;
    }

    /** 
     * Sets the evtSource.
     * 
     * @param evtSource the evtSource
     */
    public void setEvtSource(String evtSource) {
        this.evtSource = evtSource;
    }

    /** 
     * Returns the orderSn.
     * 
     * @return the orderSn
     */
    public Integer getOrderSn() {
        return orderSn;
    }

    /** 
     * Sets the orderSn.
     * 
     * @param orderSn the orderSn
     */
    public void setOrderSn(Integer orderSn) {
        this.orderSn = orderSn;
    }

    /** 
     * Returns the encId.
     * 
     * @return the encId
     */
    public Integer getEncId() {
        return encId;
    }

    /** 
     * Sets the encId.
     * 
     * @param encId the encId
     */
    public void setEncId(Integer encId) {
        this.encId = encId;
    }

    /** 
     * Returns the deletedFlag.
     * 
     * @return the deletedFlag
     */
    public String getDeletedFlag() {
        return deletedFlag;
    }

    /** 
     * Sets the deletedFlag.
     * 
     * @param deletedFlag the deletedFlag
     */
    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }
}