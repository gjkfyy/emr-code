package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.651+0800")
public class CutomXapMrTaskDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CutomXapMrTaskDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CutomXapMrTaskDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchTaskTypesByCondition(java.lang.String eventTypeCode) {
        entering("pkuhit.xap.dao.custom.CutomXapMrTaskDaoImpl", "searchTaskTypesByCondition", eventTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CutomXapMrTaskDao/searchTaskTypesByCondition.sql");
            __query.addParameter("eventTypeCode", java.lang.String.class, eventTypeCode);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CutomXapMrTaskDaoImpl");
            __query.setCallerMethodName("searchTaskTypesByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CutomXapMrTaskDaoImpl", "searchTaskTypesByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CutomXapMrTaskDaoImpl", "searchTaskTypesByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchTasksByCondition(java.lang.String enPk, java.lang.String mrTypeCode) {
        entering("pkuhit.xap.dao.custom.CutomXapMrTaskDaoImpl", "searchTasksByCondition", enPk, mrTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CutomXapMrTaskDao/searchTasksByCondition.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrTypeCode", java.lang.String.class, mrTypeCode);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CutomXapMrTaskDaoImpl");
            __query.setCallerMethodName("searchTasksByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CutomXapMrTaskDaoImpl", "searchTasksByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CutomXapMrTaskDaoImpl", "searchTasksByCondition", __e);
            throw __e;
        }
    }

}
