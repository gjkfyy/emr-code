package ei.en.db.dao.po;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

 



@Entity(listener = VwEnMzPoListener.class)
@Table(name = "VW_EN_MZ")
public class VwEnMzPo {
	 @Column(name = "MEMO")
	private String memo; //  
	 @Column(name = "SORT_NO")
	private String sortNo; //
	 @Column(name = "SPELL_NO")
	private String spellNo; // 
	 @Column(name = "WUBI_NO")
	private String wubiNo; //  
	 @Column(name = "UPD_CNT")
	private String updCnt; // 
	 @Column(name = "CRT_TIME")
	private String crtTime; // 
	 @Column(name = "CRT_USER_ID")
	private String crtUserId; //  
	 @Column(name = "CRT_DEPT_CD")
	private String crtDeptCd; // 
	 @Column(name = "LAST_UPD_TIME")
	private String lastUpdTime; //
	 @Column(name = "LAST_UPD_DEPT_CD")
	private String lastUpdDeptCd; // 
	 @Column(name = "LAST_UPD_USER_ID")
	private String lastUpdUserId; //
	 @Column(name = "DEL_F")
	private String delF; // 
	 @Column(name = "DEPT_QA_SCR")
	private String deptQaScr; //  科室评分
	@Id
    @Column(name = "id")
	private int id;
	@Column(name = "EN_PK")
	private String enPk; //  主键
	 @Column(name = "PA_ID")
	private String paId; //  患者ID
	 @Column(name = "EN_CNT")
	private Integer enCnt; //  EN_CNT
	 @Column(name = "PA_NM")
	private String paNm; //  患者姓名
	 @Column(name = "SEX_CD")
	private String sexCd; //  性别编码
	 @Column(name = "AGE")
	private String age; //  年龄
	@Column(name = "ORG_CD")
	private String orgCd; //  机构编码
	 @Column(name = "AMR_NO")
	private String amrNo; //  病案号
	 @Column(name = "EN_NO")
	private String enNo; //  就诊序号
	 @Column(name = "EN_TP_CD")
	private String enTpCd; //  就诊类型编码
	 @Column(name = "EN_STA_CD")
	private String enStaCd; //  就诊状态编码
	 @Column(name = "AMR_STA_CD")
	private String amrStaCd; //  病案状态编码
	 @Column(name = "AMR_RANK_CD")
	private String amrRankCd; //  病案等级编码
	 @Column(name = "QA_SCR")
	private String qaScr; //  质控评分
	 @Column(name = "REG_TIME")
	private String regTime; //  就诊登记时间
	 @Column(name = "REG_USER_ID")
	private String regUserId; //  就诊登记人
	 @Column(name = "REG_DEPT_CD")
	private String regDeptCd; //  就诊登记科室编码
	 @Column(name = "RCV_USER_ID")
	private String rcvUserId; //  接诊人
	 @Column(name = "RCV_DEPT_CD")
	private String rcvDeptCd; //  接诊科室编码
	 @Column(name = "RCV_TIME")
	private String rcvTime; //  接诊时间
	 @Column(name = "ILL_STA_CD")
	private String illStaCd; //  病情状态编码
	 @Column(name = "NU_LVL_CD")
	private String nuLvlCd; //  护理等级编码
	 @Column(name = "CUR_MAIN_DI_CD")
	private String curMainDiCd; //  当前主诊断编码
	 @Column(name = "CUR_DEPT_CD")
	private String curDeptCd; //  当前科室编码
	 @Column(name = "CUR_DEPT_INTO_TIME")
	private String curDeptInfoTime; //  当前入科时间
	 @Column(name = "CUR_WARD_CD")
	private String curWardCd; //  病区编码
	 @Column(name = "CUR_WARD_INTO_TIME")
	private String curWardInfoTime; //  入病区时间
	 @Column(name = "CUR_GRP_CD")
	private String curGrpCd; //  诊疗组编码
	 @Column(name = "CUR_BED_CD")
	private String curBedCd; //  床号编码
	 @Column(name = "CUR_MNG_DCT_ID")
	private String curMngDctId; //  主管医生
	 @Column(name = "CUR_MOJ_DCT_ID")
	private String curMojDctId; //  主治医生
	 @Column(name = "CUR_DRC_DCT_ID")
	private String curDrcDctId; //  主任(副主任)医生
	 @Column(name = "CUR_MNG_NUR_ID")
	private String curMngNurId; //  责任护士
	 @Column(name = "SU_F")
	private String suF; //  手术标志
	 @Column(name = "DEATH_F")
	private String deathF; //  死亡标志
	 @Column(name = "READM_F")
	private String readmF; //  再入院标志
	 @Column(name = "CALL_BACK_F")
	private String callBackF; //  召回标志
	 @Column(name = "FLUP_VISIT_F")
	private String flupVisitF; //  随访标志
	 @Column(name = "FNSH_TIME")
	private String fnshTime; //  诊毕时间
	 @Column(name = "FNSH_USER_ID")
	private String fnshUserId; //  诊毕人
	 @Column(name = "FNSH_DEPT_CD")
	private String fnshDeptCd; //  诊毕科室
	 @Column(name = "TERM_QA_CMPL_TIME")
	private String termQaCmplTime; //  质控完成时间
	 @Column(name = "TERM_QA_CMPL_USER_ID")
	private String termQaCmplUserId; //  质控完成人
	 @Column(name = "TERM_QA_CMPL_DEPT_CD")
	private String termQaCmplDeptCd; //  质控完成科室
	 @Column(name = "INPROCESS")
	private String inprocess; //  环节质控
	 @Column(name = "TERMINAL")
	private String terminal; //  终末质控
	 @Column(name = "DEPT_TERMINAL")
	private String deptTerminal; //  科室质控
	 @Column(name = "PA_INSUR_CD")
	private String paInsurCd; //患者身份编码
	@Column(name = "PA_INSUR_NM")
	private String paInsurNm;//患者身份名称
	
	@Column(name = "ID_CARD")
	private String idCard;//患者身份证号码，对应HIS的SOCIAL_NO';
	@Column(name = "HIC_NO")
	private String hicNo;//患者医疗证号，对于HIS的HIC_NO';
	@Column(name = "HOME_TEL")
	private String homeTel;//联系方式，对应HIS的HOME_TEL';
	@Column(name = "SOCIAL_SN")
	private String socialSn;//医保卡号，对应HIS的ADDITION_NO1';
	@Column(name = "BIRTH_DATE")
	private String birthDate;//出生日期

	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getHicNo() {
		return hicNo;
	}
	public void setHicNo(String hicNo) {
		this.hicNo = hicNo;
	}
	public String getHomeTel() {
		return homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}
	public String getSocialSn() {
		return socialSn;
	}
	public void setSocialSn(String socialSn) {
		this.socialSn = socialSn;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getSortNo() {
		return sortNo;
	}
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
	public String getSpellNo() {
		return spellNo;
	}
	public void setSpellNo(String spellNo) {
		this.spellNo = spellNo;
	}
	public String getWubiNo() {
		return wubiNo;
	}
	public void setWubiNo(String wubiNo) {
		this.wubiNo = wubiNo;
	}
	public String getUpdCnt() {
		return updCnt;
	}
	public void setUpdCnt(String updCnt) {
		this.updCnt = updCnt;
	}
	public String getCrtTime() {
	
		return crtTime;
	}
	public void setCrtTime(String crtTime) {
		if(crtTime != null){
			this.crtTime = crtTime.substring(0,crtTime.lastIndexOf("."));
		 }else{
		   this.crtTime = crtTime;
		 }
	}
	public String getCrtUserId() {
		return crtUserId;
	}
	public void setCrtUserId(String crtUserId) {
		this.crtUserId = crtUserId;
	}
	public String getCrtDeptCd() {
		return crtDeptCd;
	}
	public void setCrtDeptCd(String crtDeptCd) {
		this.crtDeptCd = crtDeptCd;
	}
	public String getLastUpdTime() {
		return lastUpdTime;
	}
	public void setLastUpdTime(String lastUpdTime) {
		if(lastUpdTime != null){
			this.crtTime = lastUpdTime.substring(0,lastUpdTime.lastIndexOf("."));
		 }else{
		   this.lastUpdTime = lastUpdTime;
		 }
	 
	}
	public String getLastUpdDeptCd() {
		return lastUpdDeptCd;
	}
	public void setLastUpdDeptCd(String lastUpdDeptCd) {
		this.lastUpdDeptCd = lastUpdDeptCd;
	}
	public String getLastUpdUserId() {
		return lastUpdUserId;
	}
	public void setLastUpdUserId(String lastUpdUserId) {
		this.lastUpdUserId = lastUpdUserId;
	}
	public String getDelF() {
		return delF;
	}
	public void setDelF(String delF) {
		this.delF = delF;
	}
	public String getDeptQaScr() {
		return deptQaScr;
	}
	public void setDeptQaScr(String deptQaScr) {
		this.deptQaScr = deptQaScr;
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
	public Integer getEnCnt() {
		return enCnt;
	}
	public void setEnCnt(Integer enCnt) {
		this.enCnt = enCnt;
	}
	public String getPaNm() {
		return paNm;
	}
	public void setPaNm(String paNm) {
		this.paNm = paNm;
	}
	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	public String getAmrNo() {
		return amrNo;
	}
	public void setAmrNo(String amrNo) {
		this.amrNo = amrNo;
	}
	public String getEnNo() {
		return enNo;
	}
	public void setEnNo(String enNo) {
		this.enNo = enNo;
	}
	public String getEnTpCd() {
		return enTpCd;
	}
	public void setEnTpCd(String enTpCd) {
		this.enTpCd = enTpCd;
	}
	public String getEnStaCd() {
		return enStaCd;
	}
	public void setEnStaCd(String enStaCd) {
		this.enStaCd = enStaCd;
	}
	public String getAmrStaCd() {
		return amrStaCd;
	}
	public void setAmrStaCd(String amrStaCd) {
		this.amrStaCd = amrStaCd;
	}
	public String getAmrRankCd() {
		return amrRankCd;
	}
	public void setAmrRankCd(String amrRankCd) {
		this.amrRankCd = amrRankCd;
	}
	public String getQaScr() {
		return qaScr;
	}
	public void setQaScr(String qaScr) {
		this.qaScr = qaScr;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		if(regTime != null){
			this.regTime = regTime.substring(0,regTime.lastIndexOf("."));
		 }else{
		   this.regTime = regTime;
		 }
	}
	public String getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	public String getRegDeptCd() {
		return regDeptCd;
	}
	public void setRegDeptCd(String regDeptCd) {
		this.regDeptCd = regDeptCd;
	}
	public String getRcvUserId() {
		return rcvUserId;
	}
	public void setRcvUserId(String rcvUserId) {
		this.rcvUserId = rcvUserId;
	}
	public String getRcvDeptCd() {
		return rcvDeptCd;
	}
	public void setRcvDeptCd(String rcvDeptCd) {
		this.rcvDeptCd = rcvDeptCd;
	}
	public String getRcvTime() {
		return rcvTime;
	}
	public void setRcvTime(String rcvTime) {
		if(rcvTime != null){
			this.rcvTime = rcvTime.substring(0,rcvTime.lastIndexOf("."));
		 }else{
		   this.rcvTime = rcvTime;
		 }
	}
	public String getIllStaCd() {
		return illStaCd;
	}
	public void setIllStaCd(String illStaCd) {
		this.illStaCd = illStaCd;
	}
	public String getNuLvlCd() {
		return nuLvlCd;
	}
	public void setNuLvlCd(String nuLvlCd) {
		this.nuLvlCd = nuLvlCd;
	}
	public String getCurMainDiCd() {
		return curMainDiCd;
	}
	public void setCurMainDiCd(String curMainDiCd) {
		this.curMainDiCd = curMainDiCd;
	}
	public String getCurDeptCd() {
		return curDeptCd;
	}
	public void setCurDeptCd(String curDeptCd) {
		this.curDeptCd = curDeptCd;
	}
	public String getCurDeptInfoTime() {
		return curDeptInfoTime;
	}
	public void setCurDeptInfoTime(String curDeptInfoTime) {
		if(curDeptInfoTime != null){
			this.curDeptInfoTime = curDeptInfoTime.substring(0,curDeptInfoTime.lastIndexOf("."));
		 }else{
		   this.curDeptInfoTime = curDeptInfoTime;
		 }
	}
	public String getCurWardCd() {
		return curWardCd;
	}
	public void setCurWardCd(String curWardCd) {
		this.curWardCd = curWardCd;
	}
	public String getCurWardInfoTime() {
		return curWardInfoTime;
	}
	public void setCurWardInfoTime(String curWardInfoTime) {
		if(curWardInfoTime != null){
			this.curWardInfoTime = curWardInfoTime.substring(0,curWardInfoTime.lastIndexOf("."));
		 }else{
		   this.curWardInfoTime = curWardInfoTime;
		 }
	}
	public String getCurGrpCd() {
		return curGrpCd;
	}
	public void setCurGrpCd(String curGrpCd) {
		this.curGrpCd = curGrpCd;
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
	public String getCurMojDctId() {
		return curMojDctId;
	}
	public void setCurMojDctId(String curMojDctId) {
		this.curMojDctId = curMojDctId;
	}
	public String getCurDrcDctId() {
		return curDrcDctId;
	}
	public void setCurDrcDctId(String curDrcDctId) {
		this.curDrcDctId = curDrcDctId;
	}
	public String getCurMngNurId() {
		return curMngNurId;
	}
	public void setCurMngNurId(String curMngNurId) {
		this.curMngNurId = curMngNurId;
	}
	public String getSuF() {
		return suF;
	}
	public void setSuF(String suF) {
		this.suF = suF;
	}
	public String getDeathF() {
		return deathF;
	}
	public void setDeathF(String deathF) {
		this.deathF = deathF;
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
		if(fnshTime != null){
			this.fnshTime = fnshTime.substring(0,fnshTime.lastIndexOf("."));
		 }else{
		   this.fnshTime = fnshTime;
		 }
	}
	public String getFnshUserId() {
		return fnshUserId;
	}
	public void setFnshUserId(String fnshUserId) {
		this.fnshUserId = fnshUserId;
	}
	public String getFnshDeptCd() {
		return fnshDeptCd;
	}
	public void setFnshDeptCd(String fnshDeptCd) {
		this.fnshDeptCd = fnshDeptCd;
	}
	public String getTermQaCmplTime() {
		return termQaCmplTime;
	}
	public void setTermQaCmplTime(String termQaCmplTime) {
		if(termQaCmplTime != null){
			this.termQaCmplTime = termQaCmplTime.substring(0,termQaCmplTime.lastIndexOf("."));
		 }else{
		   this.termQaCmplTime = termQaCmplTime;
		 }
	}
	public String getTermQaCmplUserId() {
		return termQaCmplUserId;
	}
	public void setTermQaCmplUserId(String termQaCmplUserId) {
		this.termQaCmplUserId = termQaCmplUserId;
	}
	public String getTermQaCmplDeptCd() {
		return termQaCmplDeptCd;
	}
	public void setTermQaCmplDeptCd(String termQaCmplDeptCd) {
		this.termQaCmplDeptCd = termQaCmplDeptCd;
	}
	public String getInprocess() {
		return inprocess;
	}
	public void setInprocess(String inprocess) {
		this.inprocess = inprocess;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getDeptTerminal() {
		return deptTerminal;
	}
	public void setDeptTerminal(String deptTerminal) {
		this.deptTerminal = deptTerminal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
