package pkuhit.iih.mr.tth;

import java.util.Date;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class TeethExamModel extends BaseMasterModel
{
    public TeethExamModel() {

        super();

    }

    public TeethExamModel(String code) {

        super(code);

    }
    
    public static final String   OBJ_CD  = "MRM98";
    
    /** 主键 */
    @Column(name = "TEETH_PK")
    private String teethPk;
    
    /** 就诊号 */
    @Column(name = "EN_PK")
    private String enPk;
    
    /** 检查医生编码 */
    @Column(name = "EXAM_DOCTOR_CD")
    private String examDoctorCd;
    
    /** 检查医生姓名 */
    @DictionaryTag(code = "examDoctorCd", objCd = "ORGB04")
    private String examDoctorNm;
    
    /** 检查时间 */
    @Column(name = "EXAM_DATE")
    private Date examDate;
    
    private TeethExamItemModel[] TeethExamItemArray;

    /** BOP% */
    @Column(name = "BOP")
    private String bop;
    
    /** 诊断*/
    @Column(name = "DI_DESC")
    private String diDesc;
    
    /** 其他*/
    @Column(name = "OTH_DESC")
    private String othDesc;
    
    /** 治疗设计*/
    @Column(name = "TREAT_DESIGN")
    private String treatDesign;
    
    private int bleeding;
    
    private int blValueCount;
    
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

    public String getExamDoctorNm()
    {
        return examDoctorNm;
    }

    public void setExamDoctorNm(String examDoctorNm)
    {
        this.examDoctorNm = examDoctorNm;
    }

    public Date getExamDate()
    {
        return examDate;
    }

    public void setExamDate(Date examDate)
    {
        this.examDate = examDate;
    }

    public TeethExamItemModel[] getTeethExamItemArray()
    {
        return TeethExamItemArray;
    }

    public void setTeethExamItemArray(TeethExamItemModel[] teethExamItemArray)
    {
        TeethExamItemArray = teethExamItemArray;
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

    public int getBleeding()
    {
        return bleeding;
    }

    public void setBleeding(int bleeding)
    {
        this.bleeding = bleeding;
    }

    public int getBlValueCount()
    {
        return blValueCount;
    }

    public void setBlValueCount(int blValueCount)
    {
        this.blValueCount = blValueCount;
    }
}
