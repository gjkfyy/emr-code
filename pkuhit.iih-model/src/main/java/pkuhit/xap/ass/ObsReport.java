package pkuhit.xap.ass;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;

public class ObsReport extends BaseMasterModel{

	public ObsReport() {
		super();
	}
	
	 public ObsReport(String code){
        super(code);
    }
	

	@Column(name = "OB_RP_PK")
	private String	 obRpPk	;//	检查报告主键
	
	private String	 enPk	;//	就诊主键
	
	@Column(name = "PA_ID")
	private String	 paId	;//	患者ID
	
	@Column(name = "EN_CNT")
	private String	 enCnt	;//	就诊次数
	
	@Column(name = "PA_NM")
	private String	 paNm	;//	患者名称
	
	@Column(name = "OB_RP_STA_CD")
	private String	 obRpStaCd	;//	检查报告状态编码
	
	@Column(name = "OB_RP_STA_NM")
	private String	 obRpStaNm	;//	检查报告状态名称
	
	@Column(name = "OB_RP_NO")
	private String	 obRpNo	;//	检查报告单号
	
	@Column(name = "OB_RP_NM")
	private String	 obRpNm	;//	检查报告单名称
	
	@Column(name = "OB_IMPR")
	private String	 obImpr	;//	检查印象
	
	@Column(name = "OB_FNDG")
	private String	 obFndg	;//	检查所见
	
	@Column(name = "OB_VAL")
	private String	 obVal	;//	测量值
	
	private String	 nrmlF	;//	结果正常标志
	
	@Column(name = "OB_ITM_CD")
	private String	 obItmCd	;//	检查项目编码
	
	@Column(name = "OB_ITM_NM")
	private String	 obItmNm	;//	检查项目名称
	
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

	@Column(name = "OB_DI")
	private String		obDi	;//	检查诊断  
	
	@Column(name = "ADV")
	private String		adv	;//	建议

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

	public String getObRpPk() {
		return obRpPk;
	}

	public void setObRpPk(String obRpPk) {
		this.obRpPk = obRpPk;
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

	public String getObRpStaCd() {
		return obRpStaCd;
	}

	public void setObRpStaCd(String obRpStaCd) {
		this.obRpStaCd = obRpStaCd;
	}

	public String getObRpStaNm() {
		return obRpStaNm;
	}

	public void setObRpStaNm(String obRpStaNm) {
		this.obRpStaNm = obRpStaNm;
	}

	public String getObRpNo() {
		return obRpNo;
	}

	public void setObRpNo(String obRpNo) {
		this.obRpNo = obRpNo;
	}

	public String getObRpNm() {
		return obRpNm;
	}

	public void setObRpNm(String obRpNm) {
		this.obRpNm = obRpNm;
	}

	public String getObImpr() {
		return obImpr;
	}

	public void setObImpr(String obImpr) {
		this.obImpr = obImpr;
	}

	public String getObFndg() {
		return obFndg;
	}

	public void setObFndg(String obFndg) {
		this.obFndg = obFndg;
	}

	public String getObVal() {
		return obVal;
	}

	public void setObVal(String obVal) {
		this.obVal = obVal;
	}

	public String getNrmlF() {
		return nrmlF;
	}

	public void setNrmlF(String nrmlF) {
		this.nrmlF = nrmlF;
	}

	public String getObItmCd() {
		return obItmCd;
	}

	public void setObItmCd(String obItmCd) {
		this.obItmCd = obItmCd;
	}

	public String getObItmNm() {
		return obItmNm;
	}

	public void setObItmNm(String obItmNm) {
		this.obItmNm = obItmNm;
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