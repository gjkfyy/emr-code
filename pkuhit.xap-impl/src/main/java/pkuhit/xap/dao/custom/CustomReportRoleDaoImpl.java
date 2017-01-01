package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.508+0800")
public class CustomReportRoleDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomReportRoleDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomReportRoleDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.IemrReport> selectReportList() {
        entering("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportList");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomReportRoleDao/selectReportList.sql");
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl");
            __query.setCallerMethodName("selectReportList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrReport>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrReport>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.IemrReport>(pkuhit.xap.dao.auto.entity._IemrReport.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.IemrReport> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.IemrReport> selectReportListByRoleCode(java.lang.String roleCode) {
        entering("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportListByRoleCode", roleCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomReportRoleDao/selectReportListByRoleCode.sql");
            __query.addParameter("roleCode", java.lang.String.class, roleCode);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl");
            __query.setCallerMethodName("selectReportListByRoleCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrReport>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrReport>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.IemrReport>(pkuhit.xap.dao.auto.entity._IemrReport.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.IemrReport> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportListByRoleCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportListByRoleCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.IemrReportRole> selectReportRoleListByRoleCode(java.lang.String roleCode) {
        entering("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportRoleListByRoleCode", roleCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomReportRoleDao/selectReportRoleListByRoleCode.sql");
            __query.addParameter("roleCode", java.lang.String.class, roleCode);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl");
            __query.setCallerMethodName("selectReportRoleListByRoleCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrReportRole>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrReportRole>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.IemrReportRole>(pkuhit.xap.dao.auto.entity._IemrReportRole.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.IemrReportRole> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportRoleListByRoleCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomReportRoleDaoImpl", "selectReportRoleListByRoleCode", __e);
            throw __e;
        }
    }

}
