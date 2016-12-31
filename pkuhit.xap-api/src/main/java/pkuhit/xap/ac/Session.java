package pkuhit.xap.ac;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.util.Assert;

import xap.sv.app.Application;
import xap.sv.scope.ScopeManager;
import xap.sv.session.SessionScope;
import xap.sv.util.ConversionUtils;

@SuppressWarnings("serial")
public class Session implements Serializable
{
    public final static String SESSION_USER_ID_KEY = Session.class.getName()
        + "_session_user_id_key";

    public final static String SESSION_USER_NAME_KEY = Session.class.getName()
        + "_session_user_name_key";

    public final static String SESSION_DEPT_ID_KEY = Session.class.getName()
        + "_session_dept_id_key";

    public final static String SESSION_DEPT_NAME_KEY = Session.class.getName()
        + "_session_dept_name_key";

    public final static String SESSION_ORG_CD_KEY = Session.class.getName()
        + "_session_org_cd_key";

    String token;

    String userId;

    String userName;

    Date createTime;

    String remoteIP;

    String deptId;

    String deptName;

    public Session(String token, String userId, String userName, Date createTime)
    {
        Assert.hasText(token, "token must not be empty");
        this.token = token;
        Assert.hasText(userId, "userId must not be empty");
        this.userId = userId;
        Assert.hasText(userName, "userName must not be empty");
        this.userName = userName;
        // Assert.notNull(createTime, "createTime must not be null");
        this.createTime = createTime;
        // this.remoteIP = remoteIP;
    }

    public static Session get()
    {
        ScopeManager scopeMgr = Application.getInstance().getBundleContext().getServiceOfType(
                ScopeManager.class);
        SessionScope ss = scopeMgr.getScope(SessionScope.class);
        String userId = ss.get(SESSION_USER_ID_KEY, String.class);
        String userName = ss.get(SESSION_USER_NAME_KEY, String.class);
        String deptId = ss.get(SESSION_DEPT_ID_KEY, String.class);
        // String deptName = ss.get(SESSION_DEPT_NAME_KEY, String.class);

        String token = SessionScope.getSessionId();
        Date createTime = SessionScope.getStartTime();

        Session session = new Session(token, userId, userName, createTime);
        session.setDeptId(deptId);
        // TODO setDeptName
        return session;
    }

    public String getDeptId()
    {
        return deptId;
    }

    public void setDeptId(String deptId)
    {
        this.deptId = deptId;

        ScopeManager scopeMgr = Application.getInstance().getBundleContext().getServiceOfType(
                ScopeManager.class);
        SessionScope ss = scopeMgr.getScope(SessionScope.class);
        ss.put(SESSION_DEPT_ID_KEY, deptId);
    }

    public String getToken()
    {
        return token;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public String getRemoteIP()
    {
        return remoteIP;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setOrgCd(String orgCd)
    {
        ScopeManager scopeMgr = Application.getInstance().getBundleContext().getServiceOfType(
                ScopeManager.class);
        SessionScope ss = scopeMgr.getScope(SessionScope.class);
        ss.put(SESSION_ORG_CD_KEY, orgCd);
    }

    public String getOrgCd()
    {
        ScopeManager scopeMgr = Application.getInstance().getBundleContext().getServiceOfType(
                ScopeManager.class);
        SessionScope ss = scopeMgr.getScope(SessionScope.class);
        return ss.get(SESSION_ORG_CD_KEY, String.class);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> asMap()
    {
        return ConversionUtils.convert(this, Map.class);
    }
}
