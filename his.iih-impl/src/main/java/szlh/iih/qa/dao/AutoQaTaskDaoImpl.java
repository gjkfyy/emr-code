package szlh.iih.qa.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:26.336+0800")
public class AutoQaTaskDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.qa.dao.AutoQaTaskDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public AutoQaTaskDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.qa.po.EmrEvent> selectEmrEventsByTime(java.lang.String startTime, java.lang.String endTime) {
        entering("szlh.iih.qa.dao.AutoQaTaskDaoImpl", "selectEmrEventsByTime", startTime, endTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/qa/dao/AutoQaTaskDao/selectEmrEventsByTime.sql");
            __query.addParameter("startTime", java.lang.String.class, startTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.setCallerClassName("szlh.iih.qa.dao.AutoQaTaskDaoImpl");
            __query.setCallerMethodName("selectEmrEventsByTime");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.qa.po.EmrEvent>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.qa.po.EmrEvent>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal()));
            java.util.List<szlh.iih.qa.po.EmrEvent> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.AutoQaTaskDaoImpl", "selectEmrEventsByTime", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.AutoQaTaskDaoImpl", "selectEmrEventsByTime", __e);
            throw __e;
        }
    }

}
