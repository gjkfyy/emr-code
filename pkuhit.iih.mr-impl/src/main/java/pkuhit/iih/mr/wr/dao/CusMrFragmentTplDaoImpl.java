package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:39.299+0800")
public class CusMrFragmentTplDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusMrFragmentTplDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrFragmentTplDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrFragmentTpl(java.lang.String userId, java.lang.String deptCd, java.lang.String ownerTypeCd, java.lang.String inName, java.lang.String keyword) {
        entering("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectMrFragmentTpl", userId, deptCd, ownerTypeCd, inName, keyword);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrFragmentTplDao/selectMrFragmentTpl.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("ownerTypeCd", java.lang.String.class, ownerTypeCd);
            __query.addParameter("inName", java.lang.String.class, inName);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl");
            __query.setCallerMethodName("selectMrFragmentTpl");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectMrFragmentTpl", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectMrFragmentTpl", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectById(java.lang.String fragmentTplCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectById", fragmentTplCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrFragmentTplDao/selectById.sql");
            __query.addParameter("fragmentTplCd", java.lang.String.class, fragmentTplCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrFragmentTplByCondition(java.lang.String ownerCd, java.lang.String keyword, java.lang.String fragmentTplTypeCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectMrFragmentTplByCondition", ownerCd, keyword, fragmentTplTypeCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrFragmentTplDao/selectMrFragmentTplByCondition.sql");
            __query.addParameter("ownerCd", java.lang.String.class, ownerCd);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("fragmentTplTypeCd", java.lang.String.class, fragmentTplTypeCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl");
            __query.setCallerMethodName("selectMrFragmentTplByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectMrFragmentTplByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrFragmentTplDaoImpl", "selectMrFragmentTplByCondition", __e);
            throw __e;
        }
    }

}
