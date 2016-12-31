package pkuhit.xap.task;


import java.util.Date;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
/**
 * 任务表model
 * wangyanli20150710
 */
public class XapTaskModel extends BaseBizModel{
	/* public XapTaskModel(){

		  super();

		 }

		 public XapTaskModel(String code){

		  super(code);

		 }*/

	//待处理
	public static final String UNDEAL = "XAPM20.01";
	//处理中
	public static final String DEALING = "XAPM20.02";
	//已处理
	public static final String DEALED = "XAPM20.03";
	
    /** 主键 */
    @Column(name = "TASK_ID")
    private String taskId;

    /** 任务类型 */
    @Column(name = "TASK_TYPE_CD")
    private String taskTypeCd;

    /** 任务类型 */
    @Column(name = "TASK_TYPE_NM")
    private String taskTypeNm;
    
    /** 文书 */
    @Column(name = "DOC_SN")
    private String docSn;

    /** 事件编码 */
    @Column(name = "EVENT_ID")
    private String eventId;

    /** 开始时间 */
    @Column(name = "BEGIN_TIME")
    private Date beginTime;

    /** 结束时间 */
    @Column(name = "END_TIME")
    private Date endTime;

    /** 就诊序号 */
    @Column(name = "ENCOUNTER_SN")
    private String encounterSn;

    /** 完成时间 */
    @Column(name = "COMPLETE_TIME")
    private Date completeTime;

    /** 剩余时间 */
    @Column(name = "SURPLUS_TIME")
    private Integer surplusTime;
    
    /** 状态。待处理、处理中、已处理 */
    @Column(name = "STATUS")
    private String status;

    /** */
    @Column(name = "MEMO")
    private String memo;
    
    /**文书类型 */
    @Column(name = "MD_MR_TP_CD")
    private String mrTpCd;
    
    /**文书类型名称 */
    @Column(name = "MD_MR_TP_NM")
    private String mrTpNm;
    
    /** */
    @Column(name = "DEL_F")
    private Short delF;
    
    /**文书类型组 */
    @Column(name = "MR_TP_CCAT_CD")
    private String mrTpCcatCd;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskTypeCd() {
		return taskTypeCd;
	}

	public void setTaskTypeCd(String taskTypeCd) {
		this.taskTypeCd = taskTypeCd;
	}

	public String getDocSn() {
		return docSn;
	}

	public void setDocSn(String docSn) {
		this.docSn = docSn;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getEncounterSn() {
		return encounterSn;
	}

	public void setEncounterSn(String encounterSn) {
		this.encounterSn = encounterSn;
	}

	

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

    public String getTaskTypeNm()
    {
        return taskTypeNm;
    }

    public void setTaskTypeNm(String taskTypeNm)
    {
        this.taskTypeNm = taskTypeNm;
    }

    public String getMrTpCd()
    {
        return mrTpCd;
    }

    public void setMrTpCd(String mrTpCd)
    {
        this.mrTpCd = mrTpCd;
    }

    public String getMrTpNm()
    {
        return mrTpNm;
    }

    public void setMrTpNm(String mrTpNm)
    {
        this.mrTpNm = mrTpNm;
    }

    public Integer getSurplusTime()
    {
        return surplusTime;
    }

    public void setSurplusTime(Integer surplusTime)
    {
        this.surplusTime = surplusTime;
    }

	public Short getDelF() {
		return delF;
	}

	public void setDelF(Short delF) {
		this.delF = delF;
	}

    public String getMrTpCcatCd()
    {
        return mrTpCcatCd;
    }

    public void setMrTpCcatCd(String mrTpCcatCd)
    {
        this.mrTpCcatCd = mrTpCcatCd;
    }

   
}