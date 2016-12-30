/**
 * 
 */
package szlh.iih.en.po;


import org.seasar.doma.Entity;

/**
 * @author guo_zhongbao
 * 就诊视图model
 */
@Entity
public class EncounterPo {
	private String	 		enPk	;//	就诊主键	
	private String	 		paId	;//	患者ID	
	private String	 		paNm	;//	患者名称	
	private String	 		paInsurCd	;//	患者医保编码	
	private String	 		paInsurNm	;//	患者医保名称	
	private String	 		enCnt	;//	就诊次数	
	private String	 		enTpCd	;//	就诊类型编码    EncounterType	
	private String	 		enTpNm	;//	就诊类型名称	
	private String	 		enStaCd	;//	就诊状态编码       EncounterStatus	
	private String	 		enStaNm	;//	就诊状态名称      	
	private String	 		nuLvlCd	;//	护理等级编码  NurseLevel	
	private String	 		nuLvlNm	;//	护理等级名称	
	private String	 		illStaCd	;//	病情状态编码  IllStatus	
	private String	 		illStaNm	;//	病情状态名称	
	private String	 		regTime	;//	就诊登记时间	
	private String	 		rcvTime	;//	就诊接诊时间	
	private String	 		rcvUserId	;//	就诊接诊人ID	
	private String	 		rcvUserNm	;//	就诊接诊人名称	
	private String	 		rcvDeptCd	;//	就诊接诊科室编码	
	private String	 		rcvDeptNm	;//	就诊接诊科室名称	
	private String	 		curMainDiCd	;//	当前主诊断编码	
	private String	 		curMainDiNm	;//	当前主诊断名称	
	private String	 		curDeptCd	;//	当前科室编码	
	private String	 		curDeptNm	;//	当前科室名称	
	private String	 		curDeptIntoTime	;//	当前科室入科时间	
	private String	 		curWardCd	;//	当前病区编码	
	private String	 		curWardNm	;//	当前病区名称	
	private String	 		curWardIntoTime	;//	当前病区入病区时间	
	private String	 		curGrpCd	;//	当前诊疗组编码	
	private String	 		curGrpNm	;//	当前诊疗组名称	
	private String	 		curBedCd	;//	当前床位编码	
	private String	 		curMngDctId	;//	当前主管医生ID	
	private String	 		curMngDctNm	;//	当前主管医生名称	
	private String	 		curMngNurId	;//	当前责任护士ID	
	private String	 		curMngNurNm	;//	当前责任护士名称	
	private String	        		readmF	;//	再入院标志	
	private String	 		callBackF	;//	召回标志	
	private String	 		flupVisitF	;//	随访标志	
	private String	 		fnshTime	;//	诊毕时间	
	private String	 		fnshUserId	;//	诊毕人ID	
	private String	 		fnshUserNm	;//	诊毕人名称	
	private String	 		fnshDeptCd	;//	诊毕科室编码	
	private String	 		fnshDeptNm	;//	诊毕科室名称	
	
	
	private String			sexCd	;//	性别编码
	private String			sexNm	;//	性别名称
	private String			age	;//	年龄
	private String			enNo	;//	就诊号
	private String			amrNo	;//	病案号
	private String			suF	;//	手术标志

	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	public String getSexNm() {
		return sexNm;
	}
	public void setSexNm(String sexNm) {
		this.sexNm = sexNm;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEnNo() {
		return enNo;
	}
	public void setEnNo(String enNo) {
		this.enNo = enNo;
	}
	public String getAmrNo() {
		return amrNo;
	}
	public void setAmrNo(String amrNo) {
		this.amrNo = amrNo;
	}
	public String getSuF() {
		return suF;
	}
	public void setSuF(String suF) {
		this.suF = suF;
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
	public String getPaNm() {
		return paNm;
	}
	public void setPaNm(String paNm) {
		this.paNm = paNm;
	}
	public String getPaInsurCd() {
		return paInsurCd;
	}
	public void setPaInsurCd(String paInsurCd) {
		this.paInsurCd = paInsurCd;
	}
	public String getPaInsurNm() {
		return paInsurNm;
	}
	public void setPaInsurNm(String paInsurNm) {
		this.paInsurNm = paInsurNm;
	}
	public String getEnCnt() {
		return enCnt;
	}
	public void setEnCnt(String enCnt) {
		this.enCnt = enCnt;
	}
	public String getEnTpCd() {
		return enTpCd;
	}
	public void setEnTpCd(String enTpCd) {
		this.enTpCd = enTpCd;
	}
	public String getEnTpNm() {
		return enTpNm;
	}
	public void setEnTpNm(String enTpNm) {
		this.enTpNm = enTpNm;
	}
	public String getEnStaCd() {
		return enStaCd;
	}
	public void setEnStaCd(String enStaCd) {
		this.enStaCd = enStaCd;
	}
	public String getEnStaNm() {
		return enStaNm;
	}
	public void setEnStaNm(String enStaNm) {
		this.enStaNm = enStaNm;
	}
	public String getNuLvlCd() {
		return nuLvlCd;
	}
	public void setNuLvlCd(String nuLvlCd) {
		this.nuLvlCd = nuLvlCd;
	}
	public String getNuLvlNm() {
		return nuLvlNm;
	}
	public void setNuLvlNm(String nuLvlNm) {
		this.nuLvlNm = nuLvlNm;
	}
	public String getIllStaCd() {
		return illStaCd;
	}
	public void setIllStaCd(String illStaCd) {
		this.illStaCd = illStaCd;
	}
	public String getIllStaNm() {
		return illStaNm;
	}
	public void setIllStaNm(String illStaNm) {
		this.illStaNm = illStaNm;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getRcvTime() {
		return rcvTime;
	}
	public void setRcvTime(String rcvTime) {
		this.rcvTime = rcvTime;
	}
	public String getRcvUserId() {
		return rcvUserId;
	}
	public void setRcvUserId(String rcvUserId) {
		this.rcvUserId = rcvUserId;
	}
	public String getRcvUserNm() {
		return rcvUserNm;
	}
	public void setRcvUserNm(String rcvUserNm) {
		this.rcvUserNm = rcvUserNm;
	}
	public String getRcvDeptCd() {
		return rcvDeptCd;
	}
	public void setRcvDeptCd(String rcvDeptCd) {
		this.rcvDeptCd = rcvDeptCd;
	}
	public String getRcvDeptNm() {
		return rcvDeptNm;
	}
	public void setRcvDeptNm(String rcvDeptNm) {
		this.rcvDeptNm = rcvDeptNm;
	}
	public String getCurMainDiCd() {
		return curMainDiCd;
	}
	public void setCurMainDiCd(String curMainDiCd) {
		this.curMainDiCd = curMainDiCd;
	}
	public String getCurMainDiNm() {
		return curMainDiNm;
	}
	public void setCurMainDiNm(String curMainDiNm) {
		this.curMainDiNm = curMainDiNm;
	}
	public String getCurDeptCd() {
		return curDeptCd;
	}
	public void setCurDeptCd(String curDeptCd) {
		this.curDeptCd = curDeptCd;
	}
	public String getCurDeptNm() {
		return curDeptNm;
	}
	public void setCurDeptNm(String curDeptNm) {
		this.curDeptNm = curDeptNm;
	}
	public String getCurDeptIntoTime() {
		return curDeptIntoTime;
	}
	public void setCurDeptIntoTime(String curDeptIntoTime) {
		this.curDeptIntoTime = curDeptIntoTime;
	}
	public String getCurWardIntoTime() {
		return curWardIntoTime;
	}
	public void setCurWardIntoTime(String curWardIntoTime) {
		this.curWardIntoTime = curWardIntoTime;
	}
	public String getCurWardCd() {
		return curWardCd;
	}
	public void setCurWardCd(String curWardCd) {
		this.curWardCd = curWardCd;
	}
	public String getCurWardNm() {
		return curWardNm;
	}
	public void setCurWardNm(String curWardNm) {
		this.curWardNm = curWardNm;
	}
	public String getCurGrpCd() {
		return curGrpCd;
	}
	public void setCurGrpCd(String curGrpCd) {
		this.curGrpCd = curGrpCd;
	}
	public String getCurGrpNm() {
		return curGrpNm;
	}
	public void setCurGrpNm(String curGrpNm) {
		this.curGrpNm = curGrpNm;
	}
	public String getCurBedCd() {
		return curBedCd;
	}
	public void setCurBedCd(String curBedCd) {
		this.curBedCd = curBedCd;
	}
	public String getCurMngDctId() {
		return curMngDctId;
	}
	public void setCurMngDctId(String curMngDctId) {
		this.curMngDctId = curMngDctId;
	}
	public String getCurMngDctNm() {
		return curMngDctNm;
	}
	public void setCurMngDctNm(String curMngDctNm) {
		this.curMngDctNm = curMngDctNm;
	}
	public String getCurMngNurId() {
		return curMngNurId;
	}
	public void setCurMngNurId(String curMngNurId) {
		this.curMngNurId = curMngNurId;
	}
	public String getCurMngNurNm() {
		return curMngNurNm;
	}
	public void setCurMngNurNm(String curMngNurNm) {
		this.curMngNurNm = curMngNurNm;
	}
	public String getReadmF() {
		return readmF;
	}
	public void setReadmF(String readmF) {
		this.readmF = readmF;
	}
	public String getCallBackF() {
		return callBackF;
	}
	public void setCallBackF(String callBackF) {
		this.callBackF = callBackF;
	}
	public String getFlupVisitF() {
		return flupVisitF;
	}
	public void setFlupVisitF(String flupVisitF) {
		this.flupVisitF = flupVisitF;
	}
	public String getFnshTime() {
		return fnshTime;
	}
	public void setFnshTime(String fnshTime) {
		this.fnshTime = fnshTime;
	}
	public String getFnshUserId() {
		return fnshUserId;
	}
	public void setFnshUserId(String fnshUserId) {
		this.fnshUserId = fnshUserId;
	}
	public String getFnshUserNm() {
		return fnshUserNm;
	}
	public void setFnshUserNm(String fnshUserNm) {
		this.fnshUserNm = fnshUserNm;
	}
	public String getFnshDeptCd() {
		return fnshDeptCd;
	}
	public void setFnshDeptCd(String fnshDeptCd) {
		this.fnshDeptCd = fnshDeptCd;
	}
	public String getFnshDeptNm() {
		return fnshDeptNm;
	}
	public void setFnshDeptNm(String fnshDeptNm) {
		this.fnshDeptNm = fnshDeptNm;
	}

	

}
