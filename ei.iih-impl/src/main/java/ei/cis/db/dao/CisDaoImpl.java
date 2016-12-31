package ei.cis.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.832+0800")
public class CisDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.cis.db.dao.CisDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CisDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getObsOrderByEnSn(java.lang.String enPk) {
        entering("ei.cis.db.dao.CisDaoImpl", "getObsOrderByEnSn", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisDao/getObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("ei.cis.db.dao.CisDaoImpl");
            __query.setCallerMethodName("getObsOrderByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.cis.db.dao.CisDaoImpl", "getObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisDaoImpl", "getObsOrderByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getZYConsMramrFromObsOrderByEnSn(java.lang.String enPk, java.lang.String statusCode, java.lang.String orderType, java.lang.String execUnit, java.lang.String oderStartTime, java.lang.String orderEndTime) {
        entering("ei.cis.db.dao.CisDaoImpl", "getZYConsMramrFromObsOrderByEnSn", enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisDao/getZYConsMramrFromObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("orderType", java.lang.String.class, orderType);
            __query.addParameter("execUnit", java.lang.String.class, execUnit);
            __query.addParameter("oderStartTime", java.lang.String.class, oderStartTime);
            __query.addParameter("orderEndTime", java.lang.String.class, orderEndTime);
            __query.setCallerClassName("ei.cis.db.dao.CisDaoImpl");
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
            exiting("ei.cis.db.dao.CisDaoImpl", "getZYConsMramrFromObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisDaoImpl", "getZYConsMramrFromObsOrderByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getZYStepMramrFromObsOrderByEnSn(java.lang.String enPk, java.lang.String statusCode, java.lang.String orderType, java.lang.String execUnit, java.lang.String oderStartTime, java.lang.String orderEndTime) {
        entering("ei.cis.db.dao.CisDaoImpl", "getZYStepMramrFromObsOrderByEnSn", enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisDao/getZYStepMramrFromObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("orderType", java.lang.String.class, orderType);
            __query.addParameter("execUnit", java.lang.String.class, execUnit);
            __query.addParameter("oderStartTime", java.lang.String.class, oderStartTime);
            __query.addParameter("orderEndTime", java.lang.String.class, orderEndTime);
            __query.setCallerClassName("ei.cis.db.dao.CisDaoImpl");
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
            exiting("ei.cis.db.dao.CisDaoImpl", "getZYStepMramrFromObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisDaoImpl", "getZYStepMramrFromObsOrderByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getMZConsMramrFromObsOrderByEnSn(java.lang.String enPk, java.lang.String statusCode, java.lang.String orderType, java.lang.String execUnit, java.lang.String oderStartTime, java.lang.String orderEndTime) {
        entering("ei.cis.db.dao.CisDaoImpl", "getMZConsMramrFromObsOrderByEnSn", enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisDao/getMZConsMramrFromObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("orderType", java.lang.String.class, orderType);
            __query.addParameter("execUnit", java.lang.String.class, execUnit);
            __query.addParameter("oderStartTime", java.lang.String.class, oderStartTime);
            __query.addParameter("orderEndTime", java.lang.String.class, orderEndTime);
            __query.setCallerClassName("ei.cis.db.dao.CisDaoImpl");
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
            exiting("ei.cis.db.dao.CisDaoImpl", "getMZConsMramrFromObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisDaoImpl", "getMZConsMramrFromObsOrderByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getMZStepMramrFromObsOrderByEnSn(java.lang.String enPk, java.lang.String statusCode, java.lang.String orderType, java.lang.String execUnit, java.lang.String oderStartTime, java.lang.String orderEndTime) {
        entering("ei.cis.db.dao.CisDaoImpl", "getMZStepMramrFromObsOrderByEnSn", enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisDao/getMZStepMramrFromObsOrderByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("orderType", java.lang.String.class, orderType);
            __query.addParameter("execUnit", java.lang.String.class, execUnit);
            __query.addParameter("oderStartTime", java.lang.String.class, oderStartTime);
            __query.addParameter("orderEndTime", java.lang.String.class, orderEndTime);
            __query.setCallerClassName("ei.cis.db.dao.CisDaoImpl");
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
            exiting("ei.cis.db.dao.CisDaoImpl", "getMZStepMramrFromObsOrderByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisDaoImpl", "getMZStepMramrFromObsOrderByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getUserByBJCACert(java.lang.String strCertId) {
        entering("ei.cis.db.dao.CisDaoImpl", "getUserByBJCACert", strCertId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisDao/getUserByBJCACert.sql");
            __query.addParameter("strCertId", java.lang.String.class, strCertId);
            __query.setCallerClassName("ei.cis.db.dao.CisDaoImpl");
            __query.setCallerMethodName("getUserByBJCACert");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.cis.db.dao.CisDaoImpl", "getUserByBJCACert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisDaoImpl", "getUserByBJCACert", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getUserByNetCACert(java.lang.String strCertId) {
        entering("ei.cis.db.dao.CisDaoImpl", "getUserByNetCACert", strCertId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisDao/getUserByNetCACert.sql");
            __query.addParameter("strCertId", java.lang.String.class, strCertId);
            __query.setCallerClassName("ei.cis.db.dao.CisDaoImpl");
            __query.setCallerMethodName("getUserByNetCACert");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.cis.db.dao.CisDaoImpl", "getUserByNetCACert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisDaoImpl", "getUserByNetCACert", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getCaStateByUserId(java.lang.String userId) {
        entering("ei.cis.db.dao.CisDaoImpl", "getCaStateByUserId", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisDao/getCaStateByUserId.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("ei.cis.db.dao.CisDaoImpl");
            __query.setCallerMethodName("getCaStateByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.cis.db.dao.CisDaoImpl", "getCaStateByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisDaoImpl", "getCaStateByUserId", __e);
            throw __e;
        }
    }

}
