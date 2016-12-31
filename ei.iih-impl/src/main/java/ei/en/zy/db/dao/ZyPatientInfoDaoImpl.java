package ei.en.zy.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.950+0800")
public class ZyPatientInfoDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.en.zy.db.dao.ZyPatientInfoDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ZyPatientInfoDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.en.db.dao.po.PatientPo> getPatientDetailForZy(java.lang.String paId) {
        entering("ei.en.zy.db.dao.ZyPatientInfoDaoImpl", "getPatientDetailForZy", paId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/en/zy/db/dao/ZyPatientInfoDao/getPatientDetailForZy.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.setCallerClassName("ei.en.zy.db.dao.ZyPatientInfoDaoImpl");
            __query.setCallerMethodName("getPatientDetailForZy");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.en.db.dao.po.PatientPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.en.db.dao.po.PatientPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.en.db.dao.po.PatientPo>(ei.en.db.dao.po._PatientPo.getSingletonInternal()));
            java.util.List<ei.en.db.dao.po.PatientPo> __result = __command.execute();
            __query.complete();
            exiting("ei.en.zy.db.dao.ZyPatientInfoDaoImpl", "getPatientDetailForZy", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.en.zy.db.dao.ZyPatientInfoDaoImpl", "getPatientDetailForZy", __e);
            throw __e;
        }
    }

}
