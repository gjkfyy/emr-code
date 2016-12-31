package iih.di;

public class DefectNotice
{
    String defectNoticeCd;

    Defect[] defects;

    public String getDefectNoticeCd()
    {
        return defectNoticeCd;
    }

    public void setDefectNoticeCd(String defectNoticeCd)
    {
        this.defectNoticeCd = defectNoticeCd;
    }

    public Defect[] getDefects()
    {
        return defects;
    }

    public void setDefects(Defect[] defects)
    {
        this.defects = defects;
    }
}
