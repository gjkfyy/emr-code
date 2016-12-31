package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.466+0800")
public class CustomXapUserDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapUserDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapUserDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapUser> selectXapUserList(java.lang.String orgCd, java.lang.String statusCd, java.lang.String userId, java.lang.String name, java.lang.String curDeptNm, java.lang.String empId, java.lang.String dctNsF, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapUserList", orgCd, statusCd, userId, name, curDeptNm, empId, dctNsF, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserDao/selectXapUserList.sql");
            __query.setOptions(options);
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("statusCd", java.lang.String.class, statusCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("name", java.lang.String.class, name);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("empId", java.lang.String.class, empId);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserDaoImpl");
            __query.setCallerMethodName("selectXapUserList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUser>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUser>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapUser>(pkuhit.xap.dao.auto.entity._XapUser.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapUser> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapUserList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapUserList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapPortal> selectXapPortalListByUserId(java.lang.String userId, java.lang.String orgCd) {
        entering("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapPortalListByUserId", userId, orgCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserDao/selectXapPortalListByUserId.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserDaoImpl");
            __query.setCallerMethodName("selectXapPortalListByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapPortal>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapPortal>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapPortal>(pkuhit.xap.dao.auto.entity._XapPortal.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapPortal> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapPortalListByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapPortalListByUserId", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapPortal> selectDefaultPortalList(java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectDefaultPortalList", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserDao/selectDefaultPortalList.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserDaoImpl");
            __query.setCallerMethodName("selectDefaultPortalList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapPortal>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapPortal>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapPortal>(pkuhit.xap.dao.auto.entity._XapPortal.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapPortal> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectDefaultPortalList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectDefaultPortalList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapMenu> selectXapMenuListByUserId(java.lang.String userId, java.lang.String portalCd, java.lang.String orgCd, java.lang.String parMenuCd) {
        entering("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapMenuListByUserId", userId, portalCd, orgCd, parMenuCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserDao/selectXapMenuListByUserId.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("portalCd", java.lang.String.class, portalCd);
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("parMenuCd", java.lang.String.class, parMenuCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserDaoImpl");
            __query.setCallerMethodName("selectXapMenuListByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapMenu>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapMenu>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapMenu>(pkuhit.xap.dao.auto.entity._XapMenu.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapMenu> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapMenuListByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapMenuListByUserId", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapMenu> selectDefaultMenuList(java.lang.String userId, java.lang.String portalCd, java.lang.String parMenuCd) {
        entering("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectDefaultMenuList", userId, portalCd, parMenuCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserDao/selectDefaultMenuList.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("portalCd", java.lang.String.class, portalCd);
            __query.addParameter("parMenuCd", java.lang.String.class, parMenuCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserDaoImpl");
            __query.setCallerMethodName("selectDefaultMenuList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapMenu>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapMenu>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapMenu>(pkuhit.xap.dao.auto.entity._XapMenu.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapMenu> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectDefaultMenuList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectDefaultMenuList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapUser> selectXapUserOnCheck(java.lang.String orgCd, java.lang.String iemrPwd, java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapUserOnCheck", orgCd, iemrPwd, userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserDao/selectXapUserOnCheck.sql");
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("iemrPwd", java.lang.String.class, iemrPwd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserDaoImpl");
            __query.setCallerMethodName("selectXapUserOnCheck");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUser>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUser>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapUser>(pkuhit.xap.dao.auto.entity._XapUser.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapUser> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapUserOnCheck", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "selectXapUserOnCheck", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String searchJobTitle(java.lang.String jobTitleCode) {
        entering("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "searchJobTitle", jobTitleCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserDao/searchJobTitle.sql");
            __query.addParameter("jobTitleCode", java.lang.String.class, jobTitleCode);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserDaoImpl");
            __query.setCallerMethodName("searchJobTitle");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "searchJobTitle", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserDaoImpl", "searchJobTitle", __e);
            throw __e;
        }
    }

}
