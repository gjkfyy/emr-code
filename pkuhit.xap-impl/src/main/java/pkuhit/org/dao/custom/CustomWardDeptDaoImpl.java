package pkuhit.org.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.528+0800")
public class CustomWardDeptDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.org.dao.custom.CustomWardDeptDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomWardDeptDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.org.dao.auto.entity.Org> selectAll(java.lang.String deptCode, java.lang.String deptTypeCode) {
        entering("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectAll", deptCode, deptTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomWardDeptDao/selectAll.sql");
            __query.addParameter("deptCode", java.lang.String.class, deptCode);
            __query.addParameter("deptTypeCode", java.lang.String.class, deptTypeCode);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomWardDeptDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.Org>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.Org>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.org.dao.auto.entity.Org>(pkuhit.org.dao.auto.entity._Org.getSingletonInternal()));
            java.util.List<pkuhit.org.dao.auto.entity.Org> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectDept(java.lang.String deptCode, java.lang.String deptTypeCode) {
        entering("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectDept", deptCode, deptTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomWardDeptDao/selectDept.sql");
            __query.addParameter("deptCode", java.lang.String.class, deptCode);
            __query.addParameter("deptTypeCode", java.lang.String.class, deptTypeCode);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomWardDeptDaoImpl");
            __query.setCallerMethodName("selectDept");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectDept", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectDept", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectOrgEmpDeptListByUserId(java.lang.String userId, java.lang.String deployMode) {
        entering("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectOrgEmpDeptListByUserId", userId, deployMode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomWardDeptDao/selectOrgEmpDeptListByUserId.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deployMode", java.lang.String.class, deployMode);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomWardDeptDaoImpl");
            __query.setCallerMethodName("selectOrgEmpDeptListByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectOrgEmpDeptListByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomWardDeptDaoImpl", "selectOrgEmpDeptListByUserId", __e);
            throw __e;
        }
    }

}
