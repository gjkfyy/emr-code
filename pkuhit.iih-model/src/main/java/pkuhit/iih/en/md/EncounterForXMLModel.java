package pkuhit.iih.en.md;

public class EncounterForXMLModel
{
    //就诊类型：门诊
    public static final String ENCOUNTER_TYPE_ONP_CODE = "ENM01.01";
    //就诊类型：门诊
    public static final String ENCOUNTER_TYPE_ONP_NAME = "门诊";
    //就诊类型：急诊
    public static final String ENCOUNTER_TYPE_EMG_CODE = "ENM01.02";
    //就诊类型：急诊
    public static final String ENCOUNTER_TYPE_EMG_NAME = "急诊";
    //就诊类型：住院
    public static final String ENCOUNTER_TYPE_INP_CODE = "ENM01.04";
    //就诊类型：住院
    public static final String ENCOUNTER_TYPE_INP_NAME = "住院";
    
    private String enPk; //  主键
    private String paId; //  患者ID
    private Integer enCnt; //就诊次
    private String paNm; //  患者姓名
    private String sexCd; //  性别编码
    private String age; //  年龄
    private String orgCd; //  机构编码
    private String amrNo; //  病案号
    private String enNo; //  就诊序号
    private String enTpCd; //  就诊类型编码
    private String enTpNm; //  就诊类型名称
    private String enStaCd; //  就诊状态编码
    private String amrStaCd; //  病案状态编码
    private String amrRankCd; //  病案等级编码
    private String regTime; //  就诊登记时间
    private String regUserId; //  就诊登记人
    private String regDeptCd; //  就诊登记科室编码
    private String rcvUserId; //  接诊人
    private String rcvUserNm; //  接诊人
    private String rcvDeptCd; //  接诊科室编码
    private String rcvDeptNm; //  接诊科室名称
    private String rcvTime; //  接诊时间
    private String illStaCd; //  病情状态编码
    private String nuLvlCd; //  护理等级编码
    private String curMainDiCd; //  当前主诊断编码
    private String curDeptCd; //  当前科室编码
    private String curDeptInfoTime; //  当前入科时间
    private String curWardCd; //  病区编码
    private String curWardInfoTime; //  入病区时间
    private String curGrpCd; //  诊疗组编码
    private String curBedCd; //  床号编码
    private String curMngDctId; //  主管医生
    private String curMojDctId; //  主治医生
    private String curDrcDctId; //  主任(副主任)医生
    private String curMngNurId; //  责任护士
    private String suF; //  手术标志
    private String deathF; //  死亡标志
    private String readmF; //  再入院标志
    private String callBackF; //  召回标志
    private String flupVisitF; //  随访标志
    private String fnshTime; //  诊毕时间
    private String fnshUserId; //  诊毕人
    private String fnshDeptCd; //  诊毕科室
    private String paInsurCd; //患者身份编码
    private String paInsurNm;//患者身份名称
    private String idCard;//患者身份证号码，对应HIS的SOCIAL_NO';
    private String hicNo;//患者医疗证号，对于HIS的HIC_NO';
    private String homeTel;//联系方式，对应HIS的HOME_TEL';
    private String socialSn;//医保卡号，对应HIS的ADDITION_NO1';
    private String birthDate;//出生日期
    
     public String getEnPk()
     {
         return enPk;
     }
     public void setEnPk(String enPk)
     {
         this.enPk = enPk;
     }
     public String getPaId()
     {
         return paId;
     }
     public void setPaId(String paId)
     {
         this.paId = paId;
     }
     public Integer getEnCnt()
     {
         return enCnt;
     }
     public void setEnCnt(Integer enCnt)
     {
         this.enCnt = enCnt;
     }
     public String getPaNm()
     {
         return paNm;
     }
     public void setPaNm(String paNm)
     {
         this.paNm = paNm;
     }
     public String getSexCd()
     {
         return sexCd;
     }
     public void setSexCd(String sexCd)
     {
         this.sexCd = sexCd;
     }
     public String getAge()
     {
         return age;
     }
     public void setAge(String age)
     {
         this.age = age;
     }
     public String getOrgCd()
     {
         return orgCd;
     }
     public void setOrgCd(String orgCd)
     {
         this.orgCd = orgCd;
     }
     public String getAmrNo()
     {
         return amrNo;
     }
     public void setAmrNo(String amrNo)
     {
         this.amrNo = amrNo;
     }
     public String getEnNo()
     {
         return enNo;
     }
     public void setEnNo(String enNo)
     {
         this.enNo = enNo;
     }
     public String getEnTpCd()
     {
         return enTpCd;
     }
     public void setEnTpCd(String enTpCd)
     {
         this.enTpCd = enTpCd;
     }
     public String getEnStaCd()
     {
         return enStaCd;
     }
     public void setEnStaCd(String enStaCd)
     {
         this.enStaCd = enStaCd;
     }
     public String getAmrStaCd()
     {
         return amrStaCd;
     }
     public void setAmrStaCd(String amrStaCd)
     {
         this.amrStaCd = amrStaCd;
     }
     public String getAmrRankCd()
     {
         return amrRankCd;
     }
     public void setAmrRankCd(String amrRankCd)
     {
         this.amrRankCd = amrRankCd;
     }
     public String getRegTime()
     {
         return regTime;
     }
     public void setRegTime(String regTime)
     {
         this.regTime = regTime;
     }
     public String getRegUserId()
     {
         return regUserId;
     }
     public void setRegUserId(String regUserId)
     {
         this.regUserId = regUserId;
     }
     public String getRegDeptCd()
     {
         return regDeptCd;
     }
     public void setRegDeptCd(String regDeptCd)
     {
         this.regDeptCd = regDeptCd;
     }
     public String getRcvUserId()
     {
         return rcvUserId;
     }
     public void setRcvUserId(String rcvUserId)
     {
         this.rcvUserId = rcvUserId;
     }
     public String getRcvDeptCd()
     {
         return rcvDeptCd;
     }
     public void setRcvDeptCd(String rcvDeptCd)
     {
         this.rcvDeptCd = rcvDeptCd;
     }
     public String getRcvTime()
     {
         return rcvTime;
     }
     public void setRcvTime(String rcvTime)
     {
         this.rcvTime = rcvTime;
     }
     public String getIllStaCd()
     {
         return illStaCd;
     }
     public void setIllStaCd(String illStaCd)
     {
         this.illStaCd = illStaCd;
     }
     public String getNuLvlCd()
     {
         return nuLvlCd;
     }
     public void setNuLvlCd(String nuLvlCd)
     {
         this.nuLvlCd = nuLvlCd;
     }
     public String getCurMainDiCd()
     {
         return curMainDiCd;
     }
     public void setCurMainDiCd(String curMainDiCd)
     {
         this.curMainDiCd = curMainDiCd;
     }
     public String getCurDeptCd()
     {
         return curDeptCd;
     }
     public void setCurDeptCd(String curDeptCd)
     {
         this.curDeptCd = curDeptCd;
     }
     public String getCurDeptInfoTime()
     {
         return curDeptInfoTime;
     }
     public void setCurDeptInfoTime(String curDeptInfoTime)
     {
         this.curDeptInfoTime = curDeptInfoTime;
     }
     public String getCurWardCd()
     {
         return curWardCd;
     }
     public void setCurWardCd(String curWardCd)
     {
         this.curWardCd = curWardCd;
     }
     public String getCurWardInfoTime()
     {
         return curWardInfoTime;
     }
     public void setCurWardInfoTime(String curWardInfoTime)
     {
         this.curWardInfoTime = curWardInfoTime;
     }
     public String getCurGrpCd()
     {
         return curGrpCd;
     }
     public void setCurGrpCd(String curGrpCd)
     {
         this.curGrpCd = curGrpCd;
     }
     public String getCurBedCd()
     {
         return curBedCd;
     }
     public void setCurBedCd(String curBedCd)
     {
         this.curBedCd = curBedCd;
     }
     public String getCurMngDctId()
     {
         return curMngDctId;
     }
     public void setCurMngDctId(String curMngDctId)
     {
         this.curMngDctId = curMngDctId;
     }
     public String getCurMojDctId()
     {
         return curMojDctId;
     }
     public void setCurMojDctId(String curMojDctId)
     {
         this.curMojDctId = curMojDctId;
     }
     public String getCurDrcDctId()
     {
         return curDrcDctId;
     }
     public void setCurDrcDctId(String curDrcDctId)
     {
         this.curDrcDctId = curDrcDctId;
     }
     public String getCurMngNurId()
     {
         return curMngNurId;
     }
     public void setCurMngNurId(String curMngNurId)
     {
         this.curMngNurId = curMngNurId;
     }
     public String getSuF()
     {
         return suF;
     }
     public void setSuF(String suF)
     {
         this.suF = suF;
     }
     public String getDeathF()
     {
         return deathF;
     }
     public void setDeathF(String deathF)
     {
         this.deathF = deathF;
     }
     public String getReadmF()
     {
         return readmF;
     }
     public void setReadmF(String readmF)
     {
         this.readmF = readmF;
     }
     public String getCallBackF()
     {
         return callBackF;
     }
     public void setCallBackF(String callBackF)
     {
         this.callBackF = callBackF;
     }
     public String getFlupVisitF()
     {
         return flupVisitF;
     }
     public void setFlupVisitF(String flupVisitF)
     {
         this.flupVisitF = flupVisitF;
     }
     public String getFnshTime()
     {
         return fnshTime;
     }
     public void setFnshTime(String fnshTime)
     {
         this.fnshTime = fnshTime;
     }
     public String getFnshUserId()
     {
         return fnshUserId;
     }
     public void setFnshUserId(String fnshUserId)
     {
         this.fnshUserId = fnshUserId;
     }
     public String getFnshDeptCd()
     {
         return fnshDeptCd;
     }
     public void setFnshDeptCd(String fnshDeptCd)
     {
         this.fnshDeptCd = fnshDeptCd;
     }
     public String getPaInsurCd()
     {
         return paInsurCd;
     }
     public void setPaInsurCd(String paInsurCd)
     {
         this.paInsurCd = paInsurCd;
     }
     public String getPaInsurNm()
     {
         return paInsurNm;
     }
     public void setPaInsurNm(String paInsurNm)
     {
         this.paInsurNm = paInsurNm;
     }
     public String getIdCard()
     {
         return idCard;
     }
     public void setIdCard(String idCard)
     {
         this.idCard = idCard;
     }
     public String getHicNo()
     {
         return hicNo;
     }
     public void setHicNo(String hicNo)
     {
         this.hicNo = hicNo;
     }
     public String getHomeTel()
     {
         return homeTel;
     }
     public void setHomeTel(String homeTel)
     {
         this.homeTel = homeTel;
     }
     public String getSocialSn()
     {
         return socialSn;
     }
     public void setSocialSn(String socialSn)
     {
         this.socialSn = socialSn;
     }
     public String getBirthDate()
     {
         return birthDate;
     }
     public void setBirthDate(String birthDate)
     {
         this.birthDate = birthDate;
     }
    public String getEnTpNm()
    {
        return enTpNm;
    }
    public void setEnTpNm(String enTpNm)
    {
        this.enTpNm = enTpNm;
    }
    public String getRcvDeptNm()
    {
        return rcvDeptNm;
    }
    public void setRcvDeptNm(String rcvDeptNm)
    {
        this.rcvDeptNm = rcvDeptNm;
    }
    public String getRcvUserNm()
    {
        return rcvUserNm;
    }
    public void setRcvUserNm(String rcvUserNm)
    {
        this.rcvUserNm = rcvUserNm;
    }
}
