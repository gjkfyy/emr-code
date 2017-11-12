package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-11-12T19:23:52.590+0800")
public class CusMrSignDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusMrSignDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrSignDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrSign> selectByMrPkAndUserId(java.lang.String mrPk, java.lang.String userId) {
        entering("pkuhit.iih.mr.wr.dao.CusMrSignDaoImpl", "selectByMrPkAndUserId", mrPk, userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrSignDao/selectByMrPkAndUserId.sql");
            __query.addParameter("mrPk", java.lang.String.class, mrPk);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrSignDaoImpl");
            __query.setCallerMethodName("selectByMrPkAndUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrSign>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrSign>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrSign>(pkuhit.iih.mr.dao.auto.entity._MrSign.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrSign> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrSignDaoImpl", "selectByMrPkAndUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrSignDaoImpl", "selectByMrPkAndUserId", __e);
            throw __e;
        }
    }

}
