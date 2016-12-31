package szlh.iih.en.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.678+0800")
public class PatientDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.en.dao.PatientDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public PatientDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.en.po.PatientPo> getPatientDetail(java.lang.String paId) {
        entering("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetail", paId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/en/dao/PatientDao/getPatientDetail.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.setCallerClassName("szlh.iih.en.dao.PatientDaoImpl");
            __query.setCallerMethodName("getPatientDetail");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.en.po.PatientPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.en.po.PatientPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.en.po.PatientPo>(szlh.iih.en.po._PatientPo.getSingletonInternal()));
            java.util.List<szlh.iih.en.po.PatientPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetail", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetail", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<szlh.iih.en.po.PatientPo> getPatientDetailForMz(java.lang.String paId) {
        entering("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetailForMz", paId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/en/dao/PatientDao/getPatientDetailForMz.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.setCallerClassName("szlh.iih.en.dao.PatientDaoImpl");
            __query.setCallerMethodName("getPatientDetailForMz");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.en.po.PatientPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.en.po.PatientPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.en.po.PatientPo>(szlh.iih.en.po._PatientPo.getSingletonInternal()));
            java.util.List<szlh.iih.en.po.PatientPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetailForMz", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetailForMz", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<szlh.iih.en.po.PatientPo> getPatientDetailForZy(java.lang.String paId) {
        entering("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetailForZy", paId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/en/dao/PatientDao/getPatientDetailForZy.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.setCallerClassName("szlh.iih.en.dao.PatientDaoImpl");
            __query.setCallerMethodName("getPatientDetailForZy");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.en.po.PatientPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.en.po.PatientPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.en.po.PatientPo>(szlh.iih.en.po._PatientPo.getSingletonInternal()));
            java.util.List<szlh.iih.en.po.PatientPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetailForZy", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.en.dao.PatientDaoImpl", "getPatientDetailForZy", __e);
            throw __e;
        }
    }

}
