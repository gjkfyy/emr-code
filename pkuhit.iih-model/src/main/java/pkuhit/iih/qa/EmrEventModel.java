package pkuhit.iih.qa;

import java.sql.Timestamp;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;

/**
 * @author wang_yanli
 * cis事件model
 */

public class EmrEventModel  extends BaseBizModel {
	
	//起始时间
	public static  String startTime = "2016-07-10 00:00:00";
	//截止时间
	public static  String endTime = "";
	
	
	@Column(name = "eventid")
	private Integer	 eventid	;  // 事件主键
	
	@Column(name = "recid")
	private Integer  recid	;  // 未知
	
	@Column(name = "eventtype")
	private String  eventtype; // 事件类型
	
	@Column(name = "happentime")
	private Timestamp	happentime;// 事件发生的时间
	
    @Column(name = "endtime")
    private Timestamp endtime;// 事件结束时间
	
	@Column(name = "enc_id")
	private Integer  encId;     // 就诊序号
	
	@Column(name = "deleted_flag")
	private String  deletedFlag;//删除标识

	public Integer getEventid() {
		return eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public Integer getRecid() {
		return recid;
	}

	public void setRecid(Integer recid) {
		this.recid = recid;
	}

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

	public Timestamp getHappentime() {
		return happentime;
	}

	public void setHappentime(Timestamp happentime) {
		this.happentime = happentime;
	}

	public Integer getEncId() {
		return encId;
	}

	public void setEncId(Integer encId) {
		this.encId = encId;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	

}
