package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.894+0800")
public class CusMrFragmentTplTypeDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrFragmentTplTypeDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrFragmentTplType(java.lang.String userId) {
        entering("pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDaoImpl", "selectMrFragmentTplType", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrFragmentTplTypeDao/selectMrFragmentTplType.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDaoImpl");
            __query.setCallerMethodName("selectMrFragmentTplType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDaoImpl", "selectMrFragmentTplType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDaoImpl", "selectMrFragmentTplType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrFragmentTplAllType() {
        entering("pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDaoImpl", "selectMrFragmentTplAllType");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrFragmentTplTypeDao/selectMrFragmentTplAllType.sql");
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDaoImpl");
            __query.setCallerMethodName("selectMrFragmentTplAllType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDaoImpl", "selectMrFragmentTplAllType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDaoImpl", "selectMrFragmentTplAllType", __e);
            throw __e;
        }
    }

}
