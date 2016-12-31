package ei.lis.db.dao.po;

import org.seasar.doma.Entity;

@Entity
public class LabReportPo {

	private String	 	labRpPk	;//	检验报告主键
	private String	 	enPk	;//	就诊主键
	private String	 	paId	;//	患者ID
	private String	 	enCnt	;//	就诊次数
	private String	 	paNm	;//	患者名称
	private String	 	labRpNo	;//	检验报告单号
	private String	 	labRpNm	;//	检验报告名称
	private String	 	execTime	;//	执行时间
	private String	 	execDctId	;//	执行医生ID
	private String	 	execDctNm	;//	执行医生名称
	private String	 	execDeptCd	;//	执行科室编码
	private String	 	execDeptNm	;//	执行科室名称
	private String	 	rlsUserId	;//	发布人ID
	private String	 	rlsUserNm	;//	发布人名称
	private String	 	rlsTime	;//	发布时间
	
	private String	rqsTime	;//	申请时间
	private String	rqsDctId	;//	申请医生ID
	private String	rqsDctNm	;//	申请医生名称
				
	private String	obDi	;//	检查诊断               
	private String	adv	;//	建议

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
