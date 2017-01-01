package pkuhit.iih.mr.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:39.078+0800")
public class CusMrTplDiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.dao.custom.CusMrTplDiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrTplDiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDi> getDiListByTpl(java.lang.String mrTemplateCode) {
        entering("pkuhit.iih.mr.dao.custom.CusMrTplDiDaoImpl", "getDiListByTpl", mrTemplateCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/dao/custom/CusMrTplDiDao/getDiListByTpl.sql");
            __query.addParameter("mrTemplateCode", java.lang.String.class, mrTemplateCode);
            __query.setCallerClassName("pkuhit.iih.mr.dao.custom.CusMrTplDiDaoImpl");
            __query.setCallerMethodName("getDiListByTpl");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDi>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDi>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTplDi>(pkuhit.iih.mr.dao.auto.entity._MrTplDi.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDi> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.dao.custom.CusMrTplDiDaoImpl", "getDiListByTpl", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.dao.custom.CusMrTplDiDaoImpl", "getDiListByTpl", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDi> getTplListByDi(java.lang.String diCode) {
        entering("pkuhit.iih.mr.dao.custom.CusMrTplDiDaoImpl", "getTplListByDi", diCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/dao/custom/CusMrTplDiDao/getTplListByDi.sql");
            __query.addParameter("diCode", java.lang.String.class, diCode);
            __query.setCallerClassName("pkuhit.iih.mr.dao.custom.CusMrTplDiDaoImpl");
            __query.setCallerMethodName("getTplListByDi");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDi>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDi>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTplDi>(pkuhit.iih.mr.dao.auto.entity._MrTplDi.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDi> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.dao.custom.CusMrTplDiDaoImpl", "getTplListByDi", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.dao.custom.CusMrTplDiDaoImpl", "getTplListByDi", __e);
            throw __e;
        }
    }

}
