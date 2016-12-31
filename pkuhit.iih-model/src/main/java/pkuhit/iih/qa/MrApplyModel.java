
package pkuhit.iih.qa;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
public class MrApplyModel extends BaseBizModel {
	 public MrApplyModel(){
		 super();
	 }
		 public MrApplyModel(String applyCd){
		 super(applyCd);
	 }
	
	 /** 主键 */
	 @Column(name = "APPLY_CD")
	 private String applyCd;
	
	 /** 就诊序号 */
	 @Column(name = "EN_PK")
	 private String enPk;
	 
	 @Column(name = "PA_ID")
	 private String paId;
	 
	 @Column(name = "PA_NM")
	 private String paNm;
	 
	 @Column(name = "AMR_NO")
	 private String amrNo;
	 
	 @Column(name = "CUR_DEPT_CD")
	 private String curDeptCd;
	 
	 @Column(name = "CUR_DEPT_NM")
	 private String curDeptNm;
	 
	 @Column(name = "CUR_DEPT_INTO_TIME")
//	 private Timestamp curDeptIntoTime;
	 private String curDeptIntoTime;
	
	 /** 医疗记录类型编码 */
	 @Column(name = "MR_TP_CD")
	 private String mrTpCd;
	
	 /** 医疗记录类型名称 */
	 @Column(name = "MR_TP_NM")
	 private String mrTpNm;
	 
    /** 自动质控缺陷编码 QA_AUTO_FLT */
    @Column(name = "QA_AUTO_FLT_PK")
    private String qaAutoFltPk;
	    
	 /** 质控项编码 */
	 @Column(name = "QA_ITM_CD")
	 private String qaItmCd;
	 
	 @Column(name = "APPLY_TYPE_CD")
	 private String applyTypeCd ;
	 
	 @Column(name = "APPLY_TYPE_NM")
	 private String applyTypeNm ;
	 
	 @Column(name = "REQ")
	 private String req;

	 /** 扣分 */
	 @Column(name = "ONCE_DRP_SCR")
	 private String onceDrpScr;
	 
	 /** 申请时间 */
	 @Column(name = "APPLY_TIME")
//	 private Timestamp applyTime;
	 private String applyTime;
	
	 /** 申请人 */
	 @Column(name = "APPLY_DCT_CD")
	 private String applyDctCd;

	 @Column(name = "APPLY_DCT_NM")
	 private String applyDctNm;
	
	 /** 申请状态 */
	 @Column(name = "APPLY_STATUS")
	 private String applyStatus;
	 
	 @Column(name = "APPLY_STATUS_NM")
	 private String applyStatusNm;
	
	 /** 申请说明 */
	 @Column(name = "APPLY_DESC")
	 private String applyDesc;
	
	 /** 上级医师 */
	 @Column(name = "SUP_DCT_CD")
	 private String supDctCd;

	 @Column(name = "SUP_DCT_NM")
	 private String supDctNm;
	
	 /** 主管医生 */
	 @Column(name = "MNG_DCT_CD")
	 private String mngDctCd;

	 @Column(name = "MNG_DCT_NM")
	 private String mngDctNm;
	
	 /** 科室编码  医务科 */
	 @Column(name = "DEPT_CD")
	 private String deptCd;

	 @Column(name = "DEPT_NM")
	 private String deptNm;
	
	 /** 审批时间 */
	 @Column(name = "APPROVAL_TIME")
//	 private Timestamp approvalTime;
	 private String approvalTime;
	
	 /** 审批人 */
	 @Column(name = "APPROVAL_DCT_CD")
	 private String approvalDctCd;

	 @Column(name = "APPROVAL_DCT_NM")
	 private String approvalDctNm;
	
	 /** 审批备注 */
	 @Column(name = "MEMO")
	 private String memo;
	 
	 /** 是否医务科：0-医务科，1-非医务科 */
	 @Column(name = "ISMEDICALWORKDEPT")
	 private String isMedicalWorkDept;
	
	public String getApplyCd() {
		return applyCd;
	}
	
	public void setApplyCd(String applyCd) {
		this.applyCd = applyCd;
	}
	
	public String getEnPk() {
		return enPk;
	}
	
	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}
	
	public String getMrTpCd() {
		return mrTpCd;
	}
	
	public void setMrTpCd(String mrTpCd) {
		this.mrTpCd = mrTpCd;
	}
	
	public String getQaItmCd() {
		return qaItmCd;
	}
	
	public void setQaItmCd(String qaItmCd) {
		this.qaItmCd = qaItmCd;
	}
	
	public String getApplyDctCd() {
		return applyDctCd;
	}
	
	public void setApplyDctCd(String applyDctCd) {
		this.applyDctCd = applyDctCd;
	}
	
	public String getApplyStatus() {
		return applyStatus;
	}
	
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	
	public String getApplyDesc() {
		return applyDesc;
	}
	
	public void setApplyDesc(String applyDesc) {
		this.applyDesc = applyDesc;
	}
	
	public String getSupDctCd() {
		return supDctCd;
	}
	
	public void setSupDctCd(String supDctCd) {
		this.supDctCd = supDctCd;
	}
	
	public String getMngDctCd() {
		return mngDctCd;
	}
	
	public void setMngDctCd(String mngDctCd) {
		this.mngDctCd = mngDctCd;
	}
	
	public String getDeptCd() {
		return deptCd;
	}
	
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	
	public String getApprovalDctCd() {
		return approvalDctCd;
	}
	
	public void setApprovalDctCd(String approvalDctCd) {
		this.approvalDctCd = approvalDctCd;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMrTpNm() {
		return mrTpNm;
	}

	public void setMrTpNm(String mrTpNm) {
		this.mrTpNm = mrTpNm;
	}

	public String getApplyDctNm() {
		return applyDctNm;
	}

	public void setApplyDctNm(String applyDctNm) {
		this.applyDctNm = applyDctNm;
	}

	public String getSupDctNm() {
		return supDctNm;
	}

	public void setSupDctNm(String supDctNm) {
		this.supDctNm = supDctNm;
	}

	public String getMngDctNm() {
		return mngDctNm;
	}

	public void setMngDctNm(String mngDctNm) {
		this.mngDctNm = mngDctNm;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getApprovalDctNm() {
		return approvalDctNm;
	}

	public void setApprovalDctNm(String approvalDctNm) {
		this.approvalDctNm = approvalDctNm;
	}

	public String getPaId() {
		return paId;
	}

	public void setPaId(String paId) {
		this.paId = paId;
	}

	public String getPaNm() {
		return paNm;
	}

	public void setPaNm(String paNm) {
		this.paNm = paNm;
	}

	public String getCurDeptNm() {
		return curDeptNm;
	}

	public void setCurDeptNm(String curDeptNm) {
		this.curDeptNm = curDeptNm;
	}

	public String getApplyStatusNm() {
		return applyStatusNm;
	}

	public void setApplyStatusNm(String applyStatusNm) {
		this.applyStatusNm = applyStatusNm;
	}

	public String getOnceDrpScr() {
		return onceDrpScr;
	}

	public void setOnceDrpScr(String onceDrpScr) {
		this.onceDrpScr = onceDrpScr;
	}

	public String getCurDeptCd() {
		return curDeptCd;
	}

	public void setCurDeptCd(String curDeptCd) {
		this.curDeptCd = curDeptCd;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getIsMedicalWorkDept() {
		return isMedicalWorkDept;
	}

	public void setIsMedicalWorkDept(String isMedicalWorkDept) {
		this.isMedicalWorkDept = isMedicalWorkDept;
	}

	public String getQaAutoFltPk() {
		return qaAutoFltPk;
	}

	public void setQaAutoFltPk(String qaAutoFltPk) {
		this.qaAutoFltPk = qaAutoFltPk;
	}

	public String getCurDeptIntoTime() {
		return curDeptIntoTime;
	}

	public void setCurDeptIntoTime(String curDeptIntoTime) {
		this.curDeptIntoTime = curDeptIntoTime;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getApplyTypeCd() {
		return applyTypeCd;
	}

	public void setApplyTypeCd(String applyTypeCd) {
		this.applyTypeCd = applyTypeCd;
	}

	public String getApplyTypeNm() {
		return applyTypeNm;
	}

	public void setApplyTypeNm(String applyTypeNm) {
		this.applyTypeNm = applyTypeNm;
	}

	public String getAmrNo() {
		return amrNo;
	}

	public void setAmrNo(String amrNo) {
		this.amrNo = amrNo;
	}
	
}