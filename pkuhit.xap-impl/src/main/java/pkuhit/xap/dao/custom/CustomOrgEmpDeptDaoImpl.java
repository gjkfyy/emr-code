package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.723+0800")
public class CustomOrgEmpDeptDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomOrgEmpDeptDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomOrgEmpDeptDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectByUserId(java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectByUserId", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomOrgEmpDeptDao/selectByUserId.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl");
            __query.setCallerMethodName("selectByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectByUserId", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectByOrgCd(java.lang.String orgCd, java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectByOrgCd", orgCd, userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomOrgEmpDeptDao/selectByOrgCd.sql");
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl");
            __query.setCallerMethodName("selectByOrgCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectByOrgCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectByOrgCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectDeptByUserId(java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptByUserId", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomOrgEmpDeptDao/selectDeptByUserId.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl");
            __query.setCallerMethodName("selectDeptByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptByUserId", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectDeptNmByDeptCd(java.lang.String wardDeptCd) {
        entering("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptNmByDeptCd", wardDeptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomOrgEmpDeptDao/selectDeptNmByDeptCd.sql");
            __query.addParameter("wardDeptCd", java.lang.String.class, wardDeptCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl");
            __query.setCallerMethodName("selectDeptNmByDeptCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptNmByDeptCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptNmByDeptCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectDeptNmByOrgCd(java.lang.String orgCd) {
        entering("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptNmByOrgCd", orgCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomOrgEmpDeptDao/selectDeptNmByOrgCd.sql");
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl");
            __query.setCallerMethodName("selectDeptNmByOrgCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptNmByOrgCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectDeptNmByOrgCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectWardDeptByUserId(java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectWardDeptByUserId", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomOrgEmpDeptDao/selectWardDeptByUserId.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl");
            __query.setCallerMethodName("selectWardDeptByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectWardDeptByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomOrgEmpDeptDaoImpl", "selectWardDeptByUserId", __e);
            throw __e;
        }
    }

}
