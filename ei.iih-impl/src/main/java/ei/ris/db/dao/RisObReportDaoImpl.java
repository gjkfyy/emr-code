package ei.ris.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.897+0800")
public class RisObReportDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ris.db.dao.RisObReportDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public RisObReportDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ris.db.dao.RisObReport> selectRisVW() {
        entering("ei.ris.db.dao.RisObReportDaoImpl", "selectRisVW");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ris/db/dao/RisObReportDao/selectRisVW.sql");
            __query.setCallerClassName("ei.ris.db.dao.RisObReportDaoImpl");
            __query.setCallerMethodName("selectRisVW");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ris.db.dao.RisObReport>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ris.db.dao.RisObReport>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ris.db.dao.RisObReport>(ei.ris.db.dao._RisObReport.getSingletonInternal()));
            java.util.List<ei.ris.db.dao.RisObReport> __result = __command.execute();
            __query.complete();
            exiting("ei.ris.db.dao.RisObReportDaoImpl", "selectRisVW", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ris.db.dao.RisObReportDaoImpl", "selectRisVW", __e);
            throw __e;
        }
    }

}
