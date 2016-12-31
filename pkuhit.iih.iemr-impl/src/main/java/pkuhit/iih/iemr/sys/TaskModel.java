package pkuhit.iih.iemr.sys;

import java.util.Date;

/**
 * 
 * @author meng.xinhua
 *
 */
public class TaskModel
{
    private String taskPk;  //任务主键
    private String qaFltPk;  //缺陷主键
    private String taskStaCd;  //任务状态
    private String taskStaNm;  //任务状态
    private String des;  //任务问题描述
    private String sbmtDeptCd;  //提出科室
    private String sbmtDeptNm;  //提出科室
    private String sbmtUserId;  //提出人
    private String sbmtUserNm;  //提出人
    private Date sbmtTime;  //提出时间
    private Date deadline;  //整改截止时间
    private String fltFromCd;  //业务活动
    private String fltFromNm;  //业务活动
    private String segTpCd;  //段落类型
    private String segTpNm;  //段落类型
    private String rfmReq;  //整改要求
    private String rfmDes;  //整改说明
    
    public String getTaskPk()
    {
        return taskPk;
    }
    public void setTaskPk(String taskPk)
    {
        this.taskPk = taskPk;
    }
    public String getQaFltPk()
    {
        return qaFltPk;
    }
    public void setQaFltPk(String qaFltPk)
    {
        this.qaFltPk = qaFltPk;
    }
    public String getTaskStaCd()
    {
        return taskStaCd;
    }
    public void setTaskStaCd(String taskStaCd)
    {
        this.taskStaCd = taskStaCd;
    }
    public String getDes()
    {
        return des;
    }
    public void setDes(String des)
    {
        this.des = des;
    }
    public String getSbmtDeptCd()
    {
        return sbmtDeptCd;
    }
    public void setSbmtDeptCd(String sbmtDeptCd)
    {
        this.sbmtDeptCd = sbmtDeptCd;
    }
    public String getSbmtUserId()
    {
        return sbmtUserId;
    }
    public void setSbmtUserId(String sbmtUserId)
    {
        this.sbmtUserId = sbmtUserId;
    }
    public Date getSbmtTime()
    {
        return sbmtTime;
    }
    public void setSbmtTime(Date sbmtTime)
    {
        this.sbmtTime = sbmtTime;
    }
    public Date getDeadline()
    {
        return deadline;
    }
    public void setDeadline(Date deadline)
    {
        this.deadline = deadline;
    }
    public String getFltFromCd()
    {
        return fltFromCd;
    }
    public void setFltFromCd(String fltFromCd)
    {
        this.fltFromCd = fltFromCd;
    }
    public String getSegTpCd()
    {
        return segTpCd;
    }
    public void setSegTpCd(String segTpCd)
    {
        this.segTpCd = segTpCd;
    }
    public String getRfmReq()
    {
        return rfmReq;
    }
    public void setRfmReq(String rfmReq)
    {
        this.rfmReq = rfmReq;
    }
    public String getRfmDes()
    {
        return rfmDes;
    }
    public void setRfmDes(String rfmDes)
    {
        this.rfmDes = rfmDes;
    }
    public String getTaskStaNm()
    {
        return taskStaNm;
    }
    public void setTaskStaNm(String taskStaNm)
    {
        this.taskStaNm = taskStaNm;
    }
    public String getSbmtDeptNm()
    {
        return sbmtDeptNm;
    }
    public void setSbmtDeptNm(String sbmtDeptNm)
    {
        this.sbmtDeptNm = sbmtDeptNm;
    }
    public String getSbmtUserNm()
    {
        return sbmtUserNm;
    }
    public void setSbmtUserNm(String sbmtUserNm)
    {
        this.sbmtUserNm = sbmtUserNm;
    }
    public String getFltFromNm()
    {
        return fltFromNm;
    }
    public void setFltFromNm(String fltFromNm)
    {
        this.fltFromNm = fltFromNm;
    }
    public String getSegTpNm()
    {
        return segTpNm;
    }
    public void setSegTpNm(String segTpNm)
    {
        this.segTpNm = segTpNm;
    }
}
