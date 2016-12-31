package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.127+0800")
public class CusMrDocValueDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusMrDocValueDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrDocValueDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrDocValue> selectByEnPkAndMrPkAndElemId(java.lang.String enPk, java.lang.String mrPk, java.lang.String elemId) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDocValueDaoImpl", "selectByEnPkAndMrPkAndElemId", enPk, mrPk, elemId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDocValueDao/selectByEnPkAndMrPkAndElemId.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrPk", java.lang.String.class, mrPk);
            __query.addParameter("elemId", java.lang.String.class, elemId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDocValueDaoImpl");
            __query.setCallerMethodName("selectByEnPkAndMrPkAndElemId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrDocValue>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrDocValue>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrDocValue>(pkuhit.iih.mr.dao.auto.entity._MrDocValue.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrDocValue> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDocValueDaoImpl", "selectByEnPkAndMrPkAndElemId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDocValueDaoImpl", "selectByEnPkAndMrPkAndElemId", __e);
            throw __e;
        }
    }

}
