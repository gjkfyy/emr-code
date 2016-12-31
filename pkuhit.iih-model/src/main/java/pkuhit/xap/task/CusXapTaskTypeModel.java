package pkuhit.xap.task;

import java.math.BigDecimal;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
/**
 * 任务类型表
 */
public class CusXapTaskTypeModel extends BaseBizModel{
	
	public static final String TIMELIMIT = "QAM06.02";   //实现性
	public static final String FREQUENCY = "QAM06.05";    //频率性
	public static final String INTEGRITY = "QAM06.04";    //完整性

    /** 主键 */
    @Column(name = "TASK_TYPE_CD")
    private String taskTypeCd;

    /** 事件类型编码 */
    @Column(name = "EVENT_TYPE_CD")
    private String eventTypeCd;
    
    /** 名称 */
    @Column(name = "NM")
    private  String nm;

    /** 文书类型 */
    @Column(name = "MD_MR_TP_CD")
    private  String mdMrTpCd;

    /** */
    @Column(name = "MEMO")
    private String memo;


    /** 期限时间 */
    @Column(name = "DEAD_HOURS")
    private BigDecimal deadHours;

    /** 启用标记 */
    @Column(name = "USE_FLAG")
    private String useFlag;

    /** 质控项目类别,主数据QAM06：时限性、频率性、完整性 */
    @Column(name = "QA_ITM_TP_CD")
    private  String qaItmTpCd;

    /** 医生操作类型 01提交 02查房 */
    @Column(name = "DCT_OP_TP_CD")
    private  String dctOpTpCd;

    /** 医生职称 */
    @Column(name = "JOB_TITLE_CD")
    private String jobTitleCd;

    /** 校验规则类型，频率质控：01重复性 02连续性 */
    @Column(name = "QA_RL_TP_CD")
    private String qaRlTpCd;

    /** 校验规则 */
    @Column(name = "QA_RL_CD")
    private  String qaRlCd;

	public String getTaskTypeCd() {
		return taskTypeCd;
	}

	public void setTaskTypeCd(String taskTypeCd) {
		this.taskTypeCd = taskTypeCd;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getMdMrTpCd() {
		return mdMrTpCd;
	}

	public void setMdMrTpCd(String mdMrTpCd) {
		this.mdMrTpCd = mdMrTpCd;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public BigDecimal getDeadHours() {
		return deadHours;
	}

	public void setDeadHours(BigDecimal deadHours) {
		this.deadHours = deadHours;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getQaItmTpCd() {
		return qaItmTpCd;
	}

	public void setQaItmTpCd(String qaItmTpCd) {
		this.qaItmTpCd = qaItmTpCd;
	}

	public String getDctOpTpCd() {
		return dctOpTpCd;
	}

	public void setDctOpTpCd(String dctOpTpCd) {
		this.dctOpTpCd = dctOpTpCd;
	}

	public String getJobTitleCd() {
		return jobTitleCd;
	}

	public void setJobTitleCd(String jobTitleCd) {
		this.jobTitleCd = jobTitleCd;
	}

	public String getQaRlTpCd() {
		return qaRlTpCd;
	}

	public void setQaRlTpCd(String qaRlTpCd) {
		this.qaRlTpCd = qaRlTpCd;
	}

	public String getQaRlCd() {
		return qaRlCd;
	}

	public void setQaRlCd(String qaRlCd) {
		this.qaRlCd = qaRlCd;
	}

	public String getEventTypeCd() {
		return eventTypeCd;
	}

	public void setEventTypeCd(String eventTypeCd) {
		this.eventTypeCd = eventTypeCd;
	}

    
}