package szlh.iih.qa.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.686+0800")
public class CusQaAutoEventDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.qa.dao.CusQaAutoEventDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaAutoEventDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.qa.po.EmrEvent> selectEmrEvents(java.lang.String encId) {
        entering("szlh.iih.qa.dao.CusQaAutoEventDaoImpl", "selectEmrEvents", encId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/qa/dao/CusQaAutoEventDao/selectEmrEvents.sql");
            __query.addParameter("encId", java.lang.String.class, encId);
            __query.setCallerClassName("szlh.iih.qa.dao.CusQaAutoEventDaoImpl");
            __query.setCallerMethodName("selectEmrEvents");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.qa.po.EmrEvent>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.qa.po.EmrEvent>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal()));
            java.util.List<szlh.iih.qa.po.EmrEvent> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.CusQaAutoEventDaoImpl", "selectEmrEvents", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.CusQaAutoEventDaoImpl", "selectEmrEvents", __e);
            throw __e;
        }
    }

}
