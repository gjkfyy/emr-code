package ei.his.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.784+0800")
public class HisDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.his.db.dao.HisDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public HisDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getZYConsMramrFromObsOrderByEnSn(java.lang.String enPk, java.lang.String statusCode, java.lang.String orderType, java.lang.String execUnit, java.lang.String oderStartTime, java.lang.String orderEndTime) {
        entering("ei.his.db.dao.HisDaoImpl", "getZYConsMramrFromObsOrderByEnSn", enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/his/db/dao/HisDao/getZYConsMramrFromObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("orderType", java.lang.String.class, orderType);
            __query.addParameter("execUnit", java.lang.String.class, execUnit);
            __query.addParameter("oderStartTime", java.lang.String.class, oderStartTime);
            __query.addParameter("orderEndTime", java.lang.String.class, orderEndTime);
            __query.setCallerClassName("ei.his.db.dao.HisDaoImpl");
            __query.setCallerMethodName("getZYConsMramrFromObsOrderByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisDaoImpl", "getZYConsMramrFromObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisDaoImpl", "getZYConsMramrFromObsOrderByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getZYStepMramrFromObsOrderByEnSn(java.lang.String enPk, java.lang.String statusCode, java.lang.String orderType, java.lang.String execUnit, java.lang.String oderStartTime, java.lang.String orderEndTime) {
        entering("ei.his.db.dao.HisDaoImpl", "getZYStepMramrFromObsOrderByEnSn", enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/his/db/dao/HisDao/getZYStepMramrFromObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("orderType", java.lang.String.class, orderType);
            __query.addParameter("execUnit", java.lang.String.class, execUnit);
            __query.addParameter("oderStartTime", java.lang.String.class, oderStartTime);
            __query.addParameter("orderEndTime", java.lang.String.class, orderEndTime);
            __query.setCallerClassName("ei.his.db.dao.HisDaoImpl");
            __query.setCallerMethodName("getZYStepMramrFromObsOrderByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisDaoImpl", "getZYStepMramrFromObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisDaoImpl", "getZYStepMramrFromObsOrderByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getMZConsMramrFromObsOrderByEnSn(java.lang.String enPk, java.lang.String statusCode, java.lang.String orderType, java.lang.String execUnit, java.lang.String oderStartTime, java.lang.String orderEndTime) {
        entering("ei.his.db.dao.HisDaoImpl", "getMZConsMramrFromObsOrderByEnSn", enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/his/db/dao/HisDao/getMZConsMramrFromObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("orderType", java.lang.String.class, orderType);
            __query.addParameter("execUnit", java.lang.String.class, execUnit);
            __query.addParameter("oderStartTime", java.lang.String.class, oderStartTime);
            __query.addParameter("orderEndTime", java.lang.String.class, orderEndTime);
            __query.setCallerClassName("ei.his.db.dao.HisDaoImpl");
            __query.setCallerMethodName("getMZConsMramrFromObsOrderByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisDaoImpl", "getMZConsMramrFromObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisDaoImpl", "getMZConsMramrFromObsOrderByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getMZStepMramrFromObsOrderByEnSn(java.lang.String enPk, java.lang.String statusCode, java.lang.String orderType, java.lang.String execUnit, java.lang.String oderStartTime, java.lang.String orderEndTime) {
        entering("ei.his.db.dao.HisDaoImpl", "getMZStepMramrFromObsOrderByEnSn", enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/his/db/dao/HisDao/getMZStepMramrFromObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("orderType", java.lang.String.class, orderType);
            __query.addParameter("execUnit", java.lang.String.class, execUnit);
            __query.addParameter("oderStartTime", java.lang.String.class, oderStartTime);
            __query.addParameter("orderEndTime", java.lang.String.class, orderEndTime);
            __query.setCallerClassName("ei.his.db.dao.HisDaoImpl");
            __query.setCallerMethodName("getMZStepMramrFromObsOrderByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisDaoImpl", "getMZStepMramrFromObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisDaoImpl", "getMZStepMramrFromObsOrderByEnSn", __e);
            throw __e;
        }
    }

}
