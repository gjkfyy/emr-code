package pkuhit.iih.mr.dao.auto.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 病案
 */
@Entity(listener = MrAmrListener.class)
@Table(name = "MR_AMR")
public class MrAmr {

    /** 主键 */
    @Id
    @Column(name = "EN_PK")
    String enPk;

    /** 患者ID */
    @Column(name = "PA_ID")
    String paId;

    /** EN_CNT */
    @Column(name = "EN_CNT")
    BigInteger enCnt;

    /** 患者姓名 */
    @Column(name = "PA_NM")
    String paNm;

    /** 性别编码 */
    @Column(name = "SEX_CD")
    String sexCd;

    /** 年龄 */
    @Column(name = "AGE")
    String age;

    /** 机构编码 */
    @Column(name = "ORG_CD")
    String orgCd;

    /** 病案号 */
    @Column(name = "AMR_NO")
    String amrNo;

    /** 就诊序号 */
    @Column(name = "EN_NO")
    String enNo;

    /** 就诊类型编码 */
    @Column(name = "EN_TP_CD")
    String enTpCd;

    /** 就诊状态编码 */
    @Column(name = "EN_STA_CD")
    String enStaCd;

    /** 病案状态编码 */
    @Column(name = "AMR_STA_CD")
    String amrStaCd;

    /** 病案等级编码 */
    @Column(name = "AMR_RANK_CD")
    String amrRankCd;

    /** 质控评分 */
    @Column(name = "QA_SCR")
    BigDecimal qaScr;
    
    /** 科室质控评分 */
    @Column(name = "DEPT_QA_SCR")
    BigDecimal deptQaScr;

    /** 就诊登记时间 */
    @Column(name = "REG_TIME")
    Timestamp regTime;

    /** 就诊登记人 */
    @Column(name = "REG_USER_ID")
    String regUserId;

    /** 就诊登记科室编码 */
    @Column(name = "REG_DEPT_CD")
    String regDeptCd;

    /** 接诊人 */
    @Column(name = "RCV_USER_ID")
    String rcvUserId;

    /** 接诊科室编码 */
    @Column(name = "RCV_DEPT_CD")
    String rcvDeptCd;

    /** 接诊时间 */
    @Column(name = "RCV_TIME")
    Timestamp rcvTime;

    /** 病情状态编码 */
    @Column(name = "ILL_STA_CD")
    String illStaCd;

    /** 护理等级编码 */
    @Column(name = "NU_LVL_CD")
    String nuLvlCd;

    /** 当前主诊断编码 */
    @Column(name = "CUR_MAIN_DI_CD")
    String curMainDiCd;

    /** 当前科室编码 */
    @Column(name = "CUR_DEPT_CD")
    String curDeptCd;

    /** 当前入科时间 */
    @Column(name = "CUR_DEPT_INTO_TIME")
    Timestamp curDeptIntoTime;

    /** 病区编码 */
    @Column(name = "CUR_WARD_CD")
    String curWardCd;

    /** 入病区时间 */
    @Column(name = "CUR_WARD_INTO_TIME")
    Timestamp curWardIntoTime;

    /** 诊疗组编码 */
    @Column(name = "CUR_GRP_CD")
    String curGrpCd;

    /** 床号编码 */
    @Column(name = "CUR_BED_CD")
    String curBedCd;

    /** 主管医生 */
    @Column(name = "CUR_MNG_DCT_ID")
    String curMngDctId;

    /** 主治医生 */
    @Column(name = "CUR_MOJ_DCT_ID")
    String curMojDctId;

    /** 主任(副主任)医生 */
    @Column(name = "CUR_DRC_DCT_ID")
    String curDrcDctId;

    /** 责任护士 */
    @Column(name = "CUR_MNG_NUR_ID")
    String curMngNurId;

    /** 手术标志 */
    @Column(name = "SU_F")
    Short suF;

    /** 死亡标志 */
    @Column(name = "DEATH_F")
    Short deathF;

    /** 再入院标志 */
    @Column(name = "READM_F")
    Short readmF;

    /** 召回标志 */
    @Column(name = "CALL_BACK_F")
    Short callBackF;

    /** 随访标志 */
    @Column(name = "FLUP_VISIT_F")
    Short flupVisitF;

    /** 诊毕时间 */
    @Column(name = "FNSH_TIME")
    Timestamp fnshTime;

    /** 诊毕人 */
    @Column(name = "FNSH_USER_ID")
    String fnshUserId;

    /** 诊毕科室 */
    @Column(name = "FNSH_DEPT_CD")
    String fnshDeptCd;

    /** 质控完成时间 */
    @Column(name = "TERM_QA_CMPL_TIME")
    Timestamp termQaCmplTime;

    /** 质控完成人 */
    @Column(name = "TERM_QA_CMPL_USER_ID")
    String termQaCmplUserId;

    /** 质控完成科室 */
    @Column(name = "TERM_QA_CMPL_DEPT_CD")
    String termQaCmplDeptCd;

    /** 环节质控 */
    @Column(name = "INPROCESS")
    String inprocess;

    /** 终末质控 */
    @Column(name = "TERMINAL")
    String terminal;

    /** 科室质控 */
    @Column(name = "DEPT_TERMINAL")
    String deptTerminal;

    /** */
    @Column(name = "MEMO")
    String memo;

    /** */
    @Column(name = "SORT_NO")
    String sortNo;

    /** */
    @Column(name = "SPELL_NO")
    String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    String wubiNo;

    /** */
    @Column(name = "UPD_CNT")
    BigInteger updCnt;

    /** */
    @Column(name = "CRT_TIME")
    Timestamp crtTime;

    /** */
    @Column(name = "CRT_USER_ID")
    String crtUserId;

    /** */
    @Column(name = "CRT_DEPT_CD")
    String crtDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    /** */
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;

    /** */
    @Column(name = "DEL_F")
    Short delF;
    /** 是否归档上传*/
    @Column(name = "ARC_F")
    Short arcF;
    /**就诊组编码*/
    @Column(name = "MR_AMR_GROUP_CD")
    String mrAmrGroupCd;
    
    /**患者医保名称*/ 
    @Column(name = "PA_INSUR_NM")
    private String paInsurNm;
    
    /** xml转换二维表完成标识'; */
    @Column(name = "XML_CVET_F")
    Integer xmlCvetF;
    
    /** 归档时间*/
    @Column(name = "ARC_TIME")
    Timestamp arcTime;
    
    /** 自动质控评分 */
    @Column(name = "QA_AUTO_SCR")
    BigDecimal qaAutoScr;
    
    /** 科室质控状态 */
    @Column(name = "DEPT_QA_STA_CD")
    String deptQaStaCd;
    
    /** 终末质控状态 */
    @Column(name = "TERMINAL_QA_STA_CD")
    String terminalQaStaCd;
    
    public Integer getXmlCvetF() {
		return xmlCvetF;
	}

	public void setXmlCvetF(Integer xmlCvetF) {
		this.xmlCvetF = xmlCvetF;
	}

	public Timestamp getArcTime() {
		return arcTime;
	}

	public void setArcTime(Timestamp arcTime) {
		this.arcTime = arcTime;
	}

	public Short getArcF() {
		return arcF;
	}

	public void setArcF(Short arcF) {
		this.arcF = arcF;
	}

	public String getPaInsurNm() {
		return paInsurNm;
	}

	public void setPaInsurNm(String paInsurNm) {
		this.paInsurNm = paInsurNm;
	}

	/** 
     * Returns the enPk.
     * 
     * @return the enPk
     */
    public String getEnPk() {
        return enPk;
    }

    /** 
     * Sets the enPk.
     * 
     * @param enPk the enPk
     */
    public void setEnPk(String enPk) {
        this.enPk = enPk;
    }

    /** 
     * Returns the paId.
     * 
     * @return the paId
     */
    public String getPaId() {
        return paId;
    }

    /** 
     * Sets the paId.
     * 
     * @param paId the paId
     */
    public void setPaId(String paId) {
        this.paId = paId;
    }

    /** 
     * Returns the enCnt.
     * 
     * @return the enCnt
     */
    public BigInteger getEnCnt() {
        return enCnt;
    }

    /** 
     * Sets the enCnt.
     * 
     * @param enCnt the enCnt
     */
    public void setEnCnt(BigInteger enCnt) {
        this.enCnt = enCnt;
    }

    /** 
     * Returns the paNm.
     * 
     * @return the paNm
     */
    public String getPaNm() {
        return paNm;
    }

    /** 
     * Sets the paNm.
     * 
     * @param paNm the paNm
     */
    public void setPaNm(String paNm) {
        this.paNm = paNm;
    }

    /** 
     * Returns the sexCd.
     * 
     * @return the sexCd
     */
    public String getSexCd() {
        return sexCd;
    }

    /** 
     * Sets the sexCd.
     * 
     * @param sexCd the sexCd
     */
    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }

    /** 
     * Returns the age.
     * 
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /** 
     * Sets the age.
     * 
     * @param age the age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /** 
     * Returns the orgCd.
     * 
     * @return the orgCd
     */
    public String getOrgCd() {
        return orgCd;
    }

    /** 
     * Sets the orgCd.
     * 
     * @param orgCd the orgCd
     */
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    /** 
     * Returns the amrNo.
     * 
     * @return the amrNo
     */
    public String getAmrNo() {
        return amrNo;
    }

    /** 
     * Sets the amrNo.
     * 
     * @param amrNo the amrNo
     */
    public void setAmrNo(String amrNo) {
        this.amrNo = amrNo;
    }

    /** 
     * Returns the enNo.
     * 
     * @return the enNo
     */
    public String getEnNo() {
        return enNo;
    }

    /** 
     * Sets the enNo.
     * 
     * @param enNo the enNo
     */
    public void setEnNo(String enNo) {
        this.enNo = enNo;
    }

    /** 
     * Returns the enTpCd.
     * 
     * @return the enTpCd
     */
    public String getEnTpCd() {
        return enTpCd;
    }

    /** 
     * Sets the enTpCd.
     * 
     * @param enTpCd the enTpCd
     */
    public void setEnTpCd(String enTpCd) {
        this.enTpCd = enTpCd;
    }

    /** 
     * Returns the enStaCd.
     * 
     * @return the enStaCd
     */
    public String getEnStaCd() {
        return enStaCd;
    }

    /** 
     * Sets the enStaCd.
     * 
     * @param enStaCd the enStaCd
     */
    public void setEnStaCd(String enStaCd) {
        this.enStaCd = enStaCd;
    }

    /** 
     * Returns the amrStaCd.
     * 
     * @return the amrStaCd
     */
    public String getAmrStaCd() {
        return amrStaCd;
    }

    /** 
     * Sets the amrStaCd.
     * 
     * @param amrStaCd the amrStaCd
     */
    public void setAmrStaCd(String amrStaCd) {
        this.amrStaCd = amrStaCd;
    }

    /** 
     * Returns the amrRankCd.
     * 
     * @return the amrRankCd
     */
    public String getAmrRankCd() {
        return amrRankCd;
    }

    /** 
     * Sets the amrRankCd.
     * 
     * @param amrRankCd the amrRankCd
     */
    public void setAmrRankCd(String amrRankCd) {
        this.amrRankCd = amrRankCd;
    }

    /** 
     * Returns the qaScr.
     * 
     * @return the qaScr
     */
    public BigDecimal getQaScr() {
        return qaScr;
    }

    /** 
     * Sets the qaScr.
     * 
     * @param qaScr the qaScr
     */
    public void setQaScr(BigDecimal qaScr) {
        this.qaScr = qaScr;
    }

    /** 
     * Returns the regTime.
     * 
     * @return the regTime
     */
    public Timestamp getRegTime() {
        return regTime;
    }

    /** 
     * Sets the regTime.
     * 
     * @param regTime the regTime
     */
    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    /** 
     * Returns the regUserId.
     * 
     * @return the regUserId
     */
    public String getRegUserId() {
        return regUserId;
    }

    /** 
     * Sets the regUserId.
     * 
     * @param regUserId the regUserId
     */
    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    /** 
     * Returns the regDeptCd.
     * 
     * @return the regDeptCd
     */
    public String getRegDeptCd() {
        return regDeptCd;
    }

    /** 
     * Sets the regDeptCd.
     * 
     * @param regDeptCd the regDeptCd
     */
    public void setRegDeptCd(String regDeptCd) {
        this.regDeptCd = regDeptCd;
    }

    /** 
     * Returns the rcvUserId.
     * 
     * @return the rcvUserId
     */
    public String getRcvUserId() {
        return rcvUserId;
    }

    /** 
     * Sets the rcvUserId.
     * 
     * @param rcvUserId the rcvUserId
     */
    public void setRcvUserId(String rcvUserId) {
        this.rcvUserId = rcvUserId;
    }

    /** 
     * Returns the rcvDeptCd.
     * 
     * @return the rcvDeptCd
     */
    public String getRcvDeptCd() {
        return rcvDeptCd;
    }

    /** 
     * Sets the rcvDeptCd.
     * 
     * @param rcvDeptCd the rcvDeptCd
     */
    public void setRcvDeptCd(String rcvDeptCd) {
        this.rcvDeptCd = rcvDeptCd;
    }

    /** 
     * Returns the rcvTime.
     * 
     * @return the rcvTime
     */
    public Timestamp getRcvTime() {
        return rcvTime;
    }

    /** 
     * Sets the rcvTime.
     * 
     * @param rcvTime the rcvTime
     */
    public void setRcvTime(Timestamp rcvTime) {
        this.rcvTime = rcvTime;
    }

    /** 
     * Returns the illStaCd.
     * 
     * @return the illStaCd
     */
    public String getIllStaCd() {
        return illStaCd;
    }

    /** 
     * Sets the illStaCd.
     * 
     * @param illStaCd the illStaCd
     */
    public void setIllStaCd(String illStaCd) {
        this.illStaCd = illStaCd;
    }

    /** 
     * Returns the nuLvlCd.
     * 
     * @return the nuLvlCd
     */
    public String getNuLvlCd() {
        return nuLvlCd;
    }

    /** 
     * Sets the nuLvlCd.
     * 
     * @param nuLvlCd the nuLvlCd
     */
    public void setNuLvlCd(String nuLvlCd) {
        this.nuLvlCd = nuLvlCd;
    }

    /** 
     * Returns the curMainDiCd.
     * 
     * @return the curMainDiCd
     */
    public String getCurMainDiCd() {
        return curMainDiCd;
    }

    /** 
     * Sets the curMainDiCd.
     * 
     * @param curMainDiCd the curMainDiCd
     */
    public void setCurMainDiCd(String curMainDiCd) {
        this.curMainDiCd = curMainDiCd;
    }

    /** 
     * Returns the curDeptCd.
     * 
     * @return the curDeptCd
     */
    public String getCurDeptCd() {
        return curDeptCd;
    }

    /** 
     * Sets the curDeptCd.
     * 
     * @param curDeptCd the curDeptCd
     */
    public void setCurDeptCd(String curDeptCd) {
        this.curDeptCd = curDeptCd;
    }

    /** 
     * Returns the curDeptIntoTime.
     * 
     * @return the curDeptIntoTime
     */
    public Timestamp getCurDeptIntoTime() {
        return curDeptIntoTime;
    }

    /** 
     * Sets the curDeptIntoTime.
     * 
     * @param curDeptIntoTime the curDeptIntoTime
     */
    public void setCurDeptIntoTime(Timestamp curDeptIntoTime) {
        this.curDeptIntoTime = curDeptIntoTime;
    }

    /** 
     * Returns the curWardCd.
     * 
     * @return the curWardCd
     */
    public String getCurWardCd() {
        return curWardCd;
    }

    /** 
     * Sets the curWardCd.
     * 
     * @param curWardCd the curWardCd
     */
    public void setCurWardCd(String curWardCd) {
        this.curWardCd = curWardCd;
    }

    /** 
     * Returns the curWardIntoTime.
     * 
     * @return the curWardIntoTime
     */
    public Timestamp getCurWardIntoTime() {
        return curWardIntoTime;
    }

    /** 
     * Sets the curWardIntoTime.
     * 
     * @param curWardIntoTime the curWardIntoTime
     */
    public void setCurWardIntoTime(Timestamp curWardIntoTime) {
        this.curWardIntoTime = curWardIntoTime;
    }

    /** 
     * Returns the curGrpCd.
     * 
     * @return the curGrpCd
     */
    public String getCurGrpCd() {
        return curGrpCd;
    }

    /** 
     * Sets the curGrpCd.
     * 
     * @param curGrpCd the curGrpCd
     */
    public void setCurGrpCd(String curGrpCd) {
        this.curGrpCd = curGrpCd;
    }

    /** 
     * Returns the curBedCd.
     * 
     * @return the curBedCd
     */
    public String getCurBedCd() {
        return curBedCd;
    }

    /** 
     * Sets the curBedCd.
     * 
     * @param curBedCd the curBedCd
     */
    public void setCurBedCd(String curBedCd) {
        this.curBedCd = curBedCd;
    }

    /** 
     * Returns the curMngDctId.
     * 
     * @return the curMngDctId
     */
    public String getCurMngDctId() {
        return curMngDctId;
    }

    /** 
     * Sets the curMngDctId.
     * 
     * @param curMngDctId the curMngDctId
     */
    public void setCurMngDctId(String curMngDctId) {
        this.curMngDctId = curMngDctId;
    }

    /** 
     * Returns the curMojDctId.
     * 
     * @return the curMojDctId
     */
    public String getCurMojDctId() {
        return curMojDctId;
    }

    /** 
     * Sets the curMojDctId.
     * 
     * @param curMojDctId the curMojDctId
     */
    public void setCurMojDctId(String curMojDctId) {
        this.curMojDctId = curMojDctId;
    }

    /** 
     * Returns the curDrcDctId.
     * 
     * @return the curDrcDctId
     */
    public String getCurDrcDctId() {
        return curDrcDctId;
    }

    /** 
     * Sets the curDrcDctId.
     * 
     * @param curDrcDctId the curDrcDctId
     */
    public void setCurDrcDctId(String curDrcDctId) {
        this.curDrcDctId = curDrcDctId;
    }

    /** 
     * Returns the curMngNurId.
     * 
     * @return the curMngNurId
     */
    public String getCurMngNurId() {
        return curMngNurId;
    }

    /** 
     * Sets the curMngNurId.
     * 
     * @param curMngNurId the curMngNurId
     */
    public void setCurMngNurId(String curMngNurId) {
        this.curMngNurId = curMngNurId;
    }

    /** 
     * Returns the suF.
     * 
     * @return the suF
     */
    public Short getSuF() {
        return suF;
    }

    /** 
     * Sets the suF.
     * 
     * @param suF the suF
     */
    public void setSuF(Short suF) {
        this.suF = suF;
    }

    /** 
     * Returns the deathF.
     * 
     * @return the deathF
     */
    public Short getDeathF() {
        return deathF;
    }

    /** 
     * Sets the deathF.
     * 
     * @param deathF the deathF
     */
    public void setDeathF(Short deathF) {
        this.deathF = deathF;
    }

    /** 
     * Returns the readmF.
     * 
     * @return the readmF
     */
    public Short getReadmF() {
        return readmF;
    }

    /** 
     * Sets the readmF.
     * 
     * @param readmF the readmF
     */
    public void setReadmF(Short readmF) {
        this.readmF = readmF;
    }

    /** 
     * Returns the callBackF.
     * 
     * @return the callBackF
     */
    public Short getCallBackF() {
        return callBackF;
    }

    /** 
     * Sets the callBackF.
     * 
     * @param callBackF the callBackF
     */
    public void setCallBackF(Short callBackF) {
        this.callBackF = callBackF;
    }

    /** 
     * Returns the flupVisitF.
     * 
     * @return the flupVisitF
     */
    public Short getFlupVisitF() {
        return flupVisitF;
    }

    /** 
     * Sets the flupVisitF.
     * 
     * @param flupVisitF the flupVisitF
     */
    public void setFlupVisitF(Short flupVisitF) {
        this.flupVisitF = flupVisitF;
    }

    /** 
     * Returns the fnshTime.
     * 
     * @return the fnshTime
     */
    public Timestamp getFnshTime() {
        return fnshTime;
    }

    /** 
     * Sets the fnshTime.
     * 
     * @param fnshTime the fnshTime
     */
    public void setFnshTime(Timestamp fnshTime) {
        this.fnshTime = fnshTime;
    }

    /** 
     * Returns the fnshUserId.
     * 
     * @return the fnshUserId
     */
    public String getFnshUserId() {
        return fnshUserId;
    }

    /** 
     * Sets the fnshUserId.
     * 
     * @param fnshUserId the fnshUserId
     */
    public void setFnshUserId(String fnshUserId) {
        this.fnshUserId = fnshUserId;
    }

    /** 
     * Returns the fnshDeptCd.
     * 
     * @return the fnshDeptCd
     */
    public String getFnshDeptCd() {
        return fnshDeptCd;
    }

    /** 
     * Sets the fnshDeptCd.
     * 
     * @param fnshDeptCd the fnshDeptCd
     */
    public void setFnshDeptCd(String fnshDeptCd) {
        this.fnshDeptCd = fnshDeptCd;
    }

    /** 
     * Returns the termQaCmplTime.
     * 
     * @return the termQaCmplTime
     */
    public Timestamp getTermQaCmplTime() {
        return termQaCmplTime;
    }

    /** 
     * Sets the termQaCmplTime.
     * 
     * @param termQaCmplTime the termQaCmplTime
     */
    public void setTermQaCmplTime(Timestamp termQaCmplTime) {
        this.termQaCmplTime = termQaCmplTime;
    }

    /** 
     * Returns the termQaCmplUserId.
     * 
     * @return the termQaCmplUserId
     */
    public String getTermQaCmplUserId() {
        return termQaCmplUserId;
    }

    /** 
     * Sets the termQaCmplUserId.
     * 
     * @param termQaCmplUserId the termQaCmplUserId
     */
    public void setTermQaCmplUserId(String termQaCmplUserId) {
        this.termQaCmplUserId = termQaCmplUserId;
    }

    /** 
     * Returns the termQaCmplDeptCd.
     * 
     * @return the termQaCmplDeptCd
     */
    public String getTermQaCmplDeptCd() {
        return termQaCmplDeptCd;
    }

    /** 
     * Sets the termQaCmplDeptCd.
     * 
     * @param termQaCmplDeptCd the termQaCmplDeptCd
     */
    public void setTermQaCmplDeptCd(String termQaCmplDeptCd) {
        this.termQaCmplDeptCd = termQaCmplDeptCd;
    }

    /** 
     * Returns the inprocess.
     * 
     * @return the inprocess
     */
    public String getInprocess() {
        return inprocess;
    }

    /** 
     * Sets the inprocess.
     * 
     * @param inprocess the inprocess
     */
    public void setInprocess(String inprocess) {
        this.inprocess = inprocess;
    }

    /** 
     * Returns the terminal.
     * 
     * @return the terminal
     */
    public String getTerminal() {
        return terminal;
    }

    /** 
     * Sets the terminal.
     * 
     * @param terminal the terminal
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /** 
     * Returns the deptTerminal.
     * 
     * @return the deptTerminal
     */
    public String getDeptTerminal() {
        return deptTerminal;
    }

    /** 
     * Sets the deptTerminal.
     * 
     * @param deptTerminal the deptTerminal
     */
    public void setDeptTerminal(String deptTerminal) {
        this.deptTerminal = deptTerminal;
    }

    /** 
     * Returns the memo.
     * 
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /** 
     * Sets the memo.
     * 
     * @param memo the memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /** 
     * Returns the sortNo.
     * 
     * @return the sortNo
     */
    public String getSortNo() {
        return sortNo;
    }

    /** 
     * Sets the sortNo.
     * 
     * @param sortNo the sortNo
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    /** 
     * Returns the spellNo.
     * 
     * @return the spellNo
     */
    public String getSpellNo() {
        return spellNo;
    }

    /** 
     * Sets the spellNo.
     * 
     * @param spellNo the spellNo
     */
    public void setSpellNo(String spellNo) {
        this.spellNo = spellNo;
    }

    /** 
     * Returns the wubiNo.
     * 
     * @return the wubiNo
     */
    public String getWubiNo() {
        return wubiNo;
    }

    /** 
     * Sets the wubiNo.
     * 
     * @param wubiNo the wubiNo
     */
    public void setWubiNo(String wubiNo) {
        this.wubiNo = wubiNo;
    }

    /** 
     * Returns the updCnt.
     * 
     * @return the updCnt
     */
    public BigInteger getUpdCnt() {
        return updCnt;
    }

    /** 
     * Sets the updCnt.
     * 
     * @param updCnt the updCnt
     */
    public void setUpdCnt(BigInteger updCnt) {
        this.updCnt = updCnt;
    }

    /** 
     * Returns the crtTime.
     * 
     * @return the crtTime
     */
    public Timestamp getCrtTime() {
        return crtTime;
    }

    /** 
     * Sets the crtTime.
     * 
     * @param crtTime the crtTime
     */
    public void setCrtTime(Timestamp crtTime) {
        this.crtTime = crtTime;
    }

    /** 
     * Returns the crtUserId.
     * 
     * @return the crtUserId
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /** 
     * Sets the crtUserId.
     * 
     * @param crtUserId the crtUserId
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    /** 
     * Returns the crtDeptCd.
     * 
     * @return the crtDeptCd
     */
    public String getCrtDeptCd() {
        return crtDeptCd;
    }

    /** 
     * Sets the crtDeptCd.
     * 
     * @param crtDeptCd the crtDeptCd
     */
    public void setCrtDeptCd(String crtDeptCd) {
        this.crtDeptCd = crtDeptCd;
    }

    /** 
     * Returns the lastUpdTime.
     * 
     * @return the lastUpdTime
     */
    public Timestamp getLastUpdTime() {
        return lastUpdTime;
    }

    /** 
     * Sets the lastUpdTime.
     * 
     * @param lastUpdTime the lastUpdTime
     */
    public void setLastUpdTime(Timestamp lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /** 
     * Returns the lastUpdDeptCd.
     * 
     * @return the lastUpdDeptCd
     */
    public String getLastUpdDeptCd() {
        return lastUpdDeptCd;
    }

    /** 
     * Sets the lastUpdDeptCd.
     * 
     * @param lastUpdDeptCd the lastUpdDeptCd
     */
    public void setLastUpdDeptCd(String lastUpdDeptCd) {
        this.lastUpdDeptCd = lastUpdDeptCd;
    }

    /** 
     * Returns the lastUpdUserId.
     * 
     * @return the lastUpdUserId
     */
    public String getLastUpdUserId() {
        return lastUpdUserId;
    }

    /** 
     * Sets the lastUpdUserId.
     * 
     * @param lastUpdUserId the lastUpdUserId
     */
    public void setLastUpdUserId(String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }

    /** 
     * Returns the delF.
     * 
     * @return the delF
     */
    public Short getDelF() {
        return delF;
    }

    /** 
     * Sets the delF.
     * 
     * @param delF the delF
     */
    public void setDelF(Short delF) {
        this.delF = delF;
    }

	public String getMrAmrGroupCd() {
		return mrAmrGroupCd;
	}

	public void setMrAmrGroupCd(String mrAmrGroupCd) {
		this.mrAmrGroupCd = mrAmrGroupCd;
	}

	public BigDecimal getQaAutoScr() {
		return qaAutoScr;
	}

	public void setQaAutoScr(BigDecimal qaAutoScr) {
		this.qaAutoScr = qaAutoScr;
	}

	public BigDecimal getDeptQaScr() {
		return deptQaScr;
	}

	public void setDeptQaScr(BigDecimal deptQaScr) {
		this.deptQaScr = deptQaScr;
	}

	public String getDeptQaStaCd() {
		return deptQaStaCd;
	}

	public void setDeptQaStaCd(String deptQaStaCd) {
		this.deptQaStaCd = deptQaStaCd;
	}

	public String getTerminalQaStaCd() {
		return terminalQaStaCd;
	}

	public void setTerminalQaStaCd(String terminalQaStaCd) {
		this.terminalQaStaCd = terminalQaStaCd;
	}
	
	
    
}