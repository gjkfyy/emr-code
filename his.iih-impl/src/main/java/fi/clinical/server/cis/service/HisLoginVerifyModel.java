package fi.clinical.server.cis.service;

import java.io.Serializable;

public class HisLoginVerifyModel implements Serializable
{
    private static final long serialVersionUID = 1L;

    // 用户编码
    private String userCd;

    // 登录门户编码
    private String portalCd;

    // 登录科室编码
    private String deptCd;

    // 登录病区编码
    private String wardAreaCd;

    // 就诊序号
    private String encounterSn;

    // 病历文书序号
    private String docSn;

    // 登录组织机构编码，默认为：SZLH，可不传入
    private String organizationCd;

    // 登录验证UUID
    private String uuid;

    // 产生时间
    private String createTime;

    // 就诊次数
    private String times;
    
    // 患者ID
    private String patientId;

    public String getTimes()
    {
        return times;
    }

    public void setTimes(String times)
    {
        this.times = times;
    }

    public String getPatientId()
    {
        return patientId;
    }

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }

    public String getUserCd()
    {
        return userCd;
    }

    public void setUserCd(String userCd)
    {
        this.userCd = userCd;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getPortalCd()
    {
        return portalCd;
    }

    public void setPortalCd(String portalCd)
    {
        this.portalCd = portalCd;
    }

    public String getOrganizationCd()
    {
        return organizationCd;
    }

    public void setOrganizationCd(String organizationCd)
    {
        this.organizationCd = organizationCd;
    }

    public String getDeptCd()
    {
        return deptCd;
    }

    public void setDeptCd(String deptCd)
    {
        this.deptCd = deptCd;
    }

    public String getWardAreaCd()
    {
        return wardAreaCd;
    }

    public void setWardAreaCd(String wardAreaCd)
    {
        this.wardAreaCd = wardAreaCd;
    }

    public String getEncounterSn()
    {
        return encounterSn;
    }

    public void setEncounterSn(String encounterSn)
    {
        this.encounterSn = encounterSn;
    }

    public String getDocSn()
    {
        return docSn;
    }

    public void setDocSn(String docSn)
    {
        this.docSn = docSn;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

}
