package pkuhit.iih.mr.tth.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(listener = MrTeethExamListener.class)
@Table(name = "MR_TEETH_EXAM")
public class MrTeethExam
{
    /** 主键 */
    @Id
    @Column(name = "TEETH_PK")
    String teethPk;
    
    /** 就诊号 */
    @Column(name = "EN_PK")
    String enPk;
    
    /** 检查医生编码 */
    @Column(name = "EXAM_DOCTOR_CD")
    String examDoctorCd;
    
    /** 检查时间 */
    @Column(name = "EXAM_DATE")
    Date examDate;
    
    /** BOP% */
    @Column(name = "BOP")
    String bop;
    
    /** 诊断*/
    @Column(name = "DI_DESC")
    String diDesc;
    
    /** 其他*/
    @Column(name = "OTH_DESC")
    String othDesc;
    
    /** 治疗设计*/
    @Column(name = "TREAT_DESIGN")
    String treatDesign;
    
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

    public String getTeethPk()
    {
        return teethPk;
    }

    public void setTeethPk(String teethPk)
    {
        this.teethPk = teethPk;
    }

    public String getEnPk()
    {
        return enPk;
    }

    public void setEnPk(String enPk)
    {
        this.enPk = enPk;
    }

    public String getExamDoctorCd()
    {
        return examDoctorCd;
    }

    public void setExamDoctorCd(String examDoctorCd)
    {
        this.examDoctorCd = examDoctorCd;
    }

    public Date getExamDate()
    {
        return examDate;
    }

    public void setExamDate(Date examDate)
    {
        this.examDate = examDate;
    }

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String memo)
    {
        this.memo = memo;
    }

    public String getSortNo()
    {
        return sortNo;
    }

    public void setSortNo(String sortNo)
    {
        this.sortNo = sortNo;
    }

    public String getSpellNo()
    {
        return spellNo;
    }

    public void setSpellNo(String spellNo)
    {
        this.spellNo = spellNo;
    }

    public String getWubiNo()
    {
        return wubiNo;
    }

    public void setWubiNo(String wubiNo)
    {
        this.wubiNo = wubiNo;
    }

    public BigInteger getUpdCnt()
    {
        return updCnt;
    }

    public void setUpdCnt(BigInteger updCnt)
    {
        this.updCnt = updCnt;
    }

    public Timestamp getCrtTime()
    {
        return crtTime;
    }

    public void setCrtTime(Timestamp crtTime)
    {
        this.crtTime = crtTime;
    }

    public String getCrtUserId()
    {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId)
    {
        this.crtUserId = crtUserId;
    }

    public String getCrtDeptCd()
    {
        return crtDeptCd;
    }

    public void setCrtDeptCd(String crtDeptCd)
    {
        this.crtDeptCd = crtDeptCd;
    }

    public Timestamp getLastUpdTime()
    {
        return lastUpdTime;
    }

    public void setLastUpdTime(Timestamp lastUpdTime)
    {
        this.lastUpdTime = lastUpdTime;
    }

    public String getLastUpdDeptCd()
    {
        return lastUpdDeptCd;
    }

    public void setLastUpdDeptCd(String lastUpdDeptCd)
    {
        this.lastUpdDeptCd = lastUpdDeptCd;
    }

    public String getLastUpdUserId()
    {
        return lastUpdUserId;
    }

    public void setLastUpdUserId(String lastUpdUserId)
    {
        this.lastUpdUserId = lastUpdUserId;
    }

    public Short getDelF()
    {
        return delF;
    }

    public void setDelF(Short delF)
    {
        this.delF = delF;
    }

    public String getBop()
    {
        return bop;
    }

    public void setBop(String bop)
    {
        this.bop = bop;
    }

    public String getDiDesc()
    {
        return diDesc;
    }

    public void setDiDesc(String diDesc)
    {
        this.diDesc = diDesc;
    }

    public String getOthDesc()
    {
        return othDesc;
    }

    public void setOthDesc(String othDesc)
    {
        this.othDesc = othDesc;
    }

    public String getTreatDesign()
    {
        return treatDesign;
    }

    public void setTreatDesign(String treatDesign)
    {
        this.treatDesign = treatDesign;
    }
}
