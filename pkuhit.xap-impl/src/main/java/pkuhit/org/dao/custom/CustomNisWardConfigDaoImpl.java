package pkuhit.org.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.523+0800")
public class CustomNisWardConfigDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.org.dao.custom.CustomNisWardConfigDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomNisWardConfigDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.org.dao.auto.entity.EiNisWardConfig> selectLikeIps(java.lang.String ip) {
        entering("pkuhit.org.dao.custom.CustomNisWardConfigDaoImpl", "selectLikeIps", ip);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomNisWardConfigDao/selectLikeIps.sql");
            __query.addParameter("ip", java.lang.String.class, ip);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomNisWardConfigDaoImpl");
            __query.setCallerMethodName("selectLikeIps");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.EiNisWardConfig>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.EiNisWardConfig>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.org.dao.auto.entity.EiNisWardConfig>(pkuhit.org.dao.auto.entity._EiNisWardConfig.getSingletonInternal()));
            java.util.List<pkuhit.org.dao.auto.entity.EiNisWardConfig> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomNisWardConfigDaoImpl", "selectLikeIps", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomNisWardConfigDaoImpl", "selectLikeIps", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectOrgByIp(java.lang.String ip) {
        entering("pkuhit.org.dao.custom.CustomNisWardConfigDaoImpl", "selectOrgByIp", ip);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomNisWardConfigDao/selectOrgByIp.sql");
            __query.addParameter("ip", java.lang.String.class, ip);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomNisWardConfigDaoImpl");
            __query.setCallerMethodName("selectOrgByIp");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomNisWardConfigDaoImpl", "selectOrgByIp", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomNisWardConfigDaoImpl", "selectOrgByIp", __e);
            throw __e;
        }
    }

}
