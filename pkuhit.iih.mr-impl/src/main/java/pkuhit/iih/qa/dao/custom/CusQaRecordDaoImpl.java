package pkuhit.iih.qa.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.784+0800")
public class CusQaRecordDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.custom.CusQaRecordDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaRecordDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.Qa> selectByEnPk(java.lang.String enPk, java.lang.String userId, short cmplF) {
        entering("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectByEnPk", enPk, userId, cmplF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaRecordDao/selectByEnPk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("cmplF", short.class, cmplF);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl");
            __query.setCallerMethodName("selectByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.Qa>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.Qa>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.Qa>(pkuhit.iih.qa.dao.auto.entity._Qa.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.Qa> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectByEnPk", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectFaultStatistical(java.lang.String qaPk, java.lang.String userId, java.lang.String deptCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectFaultStatistical", qaPk, userId, deptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaRecordDao/selectFaultStatistical.sql");
            __query.addParameter("qaPk", java.lang.String.class, qaPk);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl");
            __query.setCallerMethodName("selectFaultStatistical");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectFaultStatistical", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectFaultStatistical", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.Qa selectLastCompleted(java.lang.String enPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectLastCompleted", enPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaRecordDao/selectLastCompleted.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl");
            __query.setCallerMethodName("selectLastCompleted");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.Qa> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.Qa>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.Qa>(pkuhit.iih.qa.dao.auto.entity._Qa.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.Qa __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectLastCompleted", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectLastCompleted", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.Qa selectQaByFaultPk(java.lang.String faultPk) {
        entering("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectQaByFaultPk", faultPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaRecordDao/selectQaByFaultPk.sql");
            __query.addParameter("faultPk", java.lang.String.class, faultPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl");
            __query.setCallerMethodName("selectQaByFaultPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.Qa> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.Qa>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.Qa>(pkuhit.iih.qa.dao.auto.entity._Qa.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.Qa __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectQaByFaultPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaRecordDaoImpl", "selectQaByFaultPk", __e);
            throw __e;
        }
    }

}
