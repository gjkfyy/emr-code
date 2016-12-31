/**
 * 
 */
package pkuhit.xap.ass;

import xap.sv.annotation.Column;


/**
 * @author guo_zhongbao
 * 检验视图
 */
public class LabReport {
	
	
	@Column(name = "LAB_RP_PK")
	private String	 labRpPk	;//	检验报告主键
	
	@Column(name = "EN_PK")
	private String	 enPk	;//	就诊主键
	
	@Column(name = "PA_ID")
	private String	 paId	;//	患者ID
	
	@Column(name = "EN_CNT")
	private String	 enCnt	;//	就诊次数
	
	@Column(name = "PA_NM")
	private String	 paNm	;//	患者名称
	
	@Column(name = "LAB_RP_NO")
	private String	 labRpNo	;//	检验报告单号
	
	@Column(name = "LAB_RP_NM")
	private String	 labRpNm	;//	检验报告名称
	
	@Column(name = "EXEC_TIME")
	private String	 execTime	;//	执行时间
	
	@Column(name = "EXEC_DCT_ID")
	private String	 execDctId	;//	执行医生ID
	
	@Column(name = "EXEC_DCT_NM")
	private String	 execDctNm	;//	执行医生名称
	
	@Column(name = "EXEC_DEPT_CD")
	private String	 execDeptCd	;//	执行科室编码
	
	@Column(name = "EXEC_DEPT_NM")
	private String	 execDeptNm	;//	执行科室名称
	
	@Column(name = "RLS_USER_ID")
	private String	 rlsUserId	;//	发布人ID
	
	@Column(name = "RLS_USER_NM")
	private String	 rlsUserNm	;//	发布人名称
	
	@Column(name = "RLS_TIME")
	private String	 rlsTime	;//	发布时间
	
	@Column(name = "RQS_TIME")
	private String	rqsTime	;//	申请时间
	
	@Column(name = "RQS_DCT_ID")
	private String	rqsDctId	;//	申请医生ID
	
	@Column(name = "RQS_DCT_NM")
	private String	rqsDctNm	;//	申请医生名称
	
	@Column(name = "LAB_RP_STA_NM")
	private String	labRpStaNm	;//	检验报告状态 //wangyanli add
				
	
	private String	obDi	;//	检查诊断
	
	
	private String	adv	;//	建议

	
	public String getLabRpStaNm() {
		return labRpStaNm;
	}
	public void setLabRpStaNm(String labRpStaNm) {
		this.labRpStaNm = labRpStaNm;
	}
	@Column(name = "MEMO")
	private String memo;
	
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRqsTime() {
		return rqsTime;
	}
	public void setRqsTime(String rqsTime) {
		this.rqsTime = rqsTime;
	}
	public String getRqsDctId() {
		return rqsDctId;
	}
	public void setRqsDctId(String rqsDctId) {
		this.rqsDctId = rqsDctId;
	}
	public String getRqsDctNm() {
		return rqsDctNm;
	}
	public void setRqsDctNm(String rqsDctNm) {
		this.rqsDctNm = rqsDctNm;
	}
	public String getObDi() {
		return obDi;
	}
	public void setObDi(String obDi) {
		this.obDi = obDi;
	}
	public String getAdv() {
		return adv;
	}
	public void setAdv(String adv) {
		this.adv = adv;
	}
	public String getLabRpPk() {
		return labRpPk;
	}
	public void setLabRpPk(String labRpPk) {
		this.labRpPk = labRpPk;
	}
	public String getEnPk() {
		return enPk;
	}
	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}
	public String getPaId() {
		return paId;
	}
	public void setPaId(String paId) {
		this.paId = paId;
	}
	public String getEnCnt() {
		return enCnt;
	}
	public void setEnCnt(String enCnt) {
		this.enCnt = enCnt;
	}
	public String getPaNm() {
		return paNm;
	}
	public void setPaNm(String paNm) {
		this.paNm = paNm;
	}
	public String getLabRpNo() {
		return labRpNo;
	}
	public void setLabRpNo(String labRpNo) {
		this.labRpNo = labRpNo;
	}
	public String getLabRpNm() {
		return labRpNm;
	}
	public void setLabRpNm(String labRpNm) {
		this.labRpNm = labRpNm;
	}
	public String getExecTime() {
		return execTime;
	}
	public void setExecTime(String execTime) {
		this.execTime = execTime;
	}
	public String getExecDctId() {
		return execDctId;
	}
	public void setExecDctId(String execDctId) {
		this.execDctId = execDctId;
	}
	public String getExecDctNm() {
		return execDctNm;
	}
	public void setExecDctNm(String execDctNm) {
		this.execDctNm = execDctNm;
	}
	public String getExecDeptCd() {
		return execDeptCd;
	}
	public void setExecDeptCd(String execDeptCd) {
		this.execDeptCd = execDeptCd;
	}
	public String getExecDeptNm() {
		return execDeptNm;
	}
	public void setExecDeptNm(String execDeptNm) {
		this.execDeptNm = execDeptNm;
	}
	public String getRlsUserId() {
		return rlsUserId;
	}
	public void setRlsUserId(String rlsUserId) {
		this.rlsUserId = rlsUserId;
	}
	public String getRlsUserNm() {
		return rlsUserNm;
	}
	public void setRlsUserNm(String rlsUserNm) {
		this.rlsUserNm = rlsUserNm;
	}
	public String getRlsTime() {
		return rlsTime;
	}
	public void setRlsTime(String rlsTime) {
		this.rlsTime = rlsTime;
	}
	
}
