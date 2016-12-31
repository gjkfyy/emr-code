package ei.ris.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.719+0800")
public class ObsDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ris.db.dao.ObsDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ObsDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ris.db.dao.po.ObservationReportPo> getObsListByEnpk(java.lang.String paId, java.lang.String enCnt) {
        entering("ei.ris.db.dao.ObsDaoImpl", "getObsListByEnpk", paId, enCnt);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ris/db/dao/ObsDao/getObsListByEnpk.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.addParameter("enCnt", java.lang.String.class, enCnt);
            __query.setCallerClassName("ei.ris.db.dao.ObsDaoImpl");
            __query.setCallerMethodName("getObsListByEnpk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ris.db.dao.po.ObservationReportPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ris.db.dao.po.ObservationReportPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ris.db.dao.po.ObservationReportPo>(ei.ris.db.dao.po._ObservationReportPo.getSingletonInternal()));
            java.util.List<ei.ris.db.dao.po.ObservationReportPo> __result = __command.execute();
            __query.complete();
            exiting("ei.ris.db.dao.ObsDaoImpl", "getObsListByEnpk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ris.db.dao.ObsDaoImpl", "getObsListByEnpk", __e);
            throw __e;
        }
    }

    @Override
    public ei.ris.db.dao.po.ObservationReportPo getObservationByObsSn(java.lang.String obRpPk) {
        entering("ei.ris.db.dao.ObsDaoImpl", "getObservationByObsSn", obRpPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ris/db/dao/ObsDao/getObservationByObsSn.sql");
            __query.addParameter("obRpPk", java.lang.String.class, obRpPk);
            __query.setCallerClassName("ei.ris.db.dao.ObsDaoImpl");
            __query.setCallerMethodName("getObservationByObsSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ris.db.dao.po.ObservationReportPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ris.db.dao.po.ObservationReportPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.ris.db.dao.po.ObservationReportPo>(ei.ris.db.dao.po._ObservationReportPo.getSingletonInternal()));
            ei.ris.db.dao.po.ObservationReportPo __result = __command.execute();
            __query.complete();
            exiting("ei.ris.db.dao.ObsDaoImpl", "getObservationByObsSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ris.db.dao.ObsDaoImpl", "getObservationByObsSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<ei.ris.db.dao.po.ObservationReportPo> getObsListByEnSn(java.lang.String enPk) {
        entering("ei.ris.db.dao.ObsDaoImpl", "getObsListByEnSn", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ris/db/dao/ObsDao/getObsListByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("ei.ris.db.dao.ObsDaoImpl");
            __query.setCallerMethodName("getObsListByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ris.db.dao.po.ObservationReportPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ris.db.dao.po.ObservationReportPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ris.db.dao.po.ObservationReportPo>(ei.ris.db.dao.po._ObservationReportPo.getSingletonInternal()));
            java.util.List<ei.ris.db.dao.po.ObservationReportPo> __result = __command.execute();
            __query.complete();
            exiting("ei.ris.db.dao.ObsDaoImpl", "getObsListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ris.db.dao.ObsDaoImpl", "getObsListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<ei.ris.db.dao.po.ObservationReportPo> getObsListByObsNo(java.util.List<java.lang.String> obRpNos) {
        entering("ei.ris.db.dao.ObsDaoImpl", "getObsListByObsNo", obRpNos);
        try {
            if (obRpNos == null) {
                throw new org.seasar.doma.DomaNullPointerException("obRpNos");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ris/db/dao/ObsDao/getObsListByObsNo.sql");
            __query.addParameter("obRpNos", java.util.List.class, obRpNos);
            __query.setCallerClassName("ei.ris.db.dao.ObsDaoImpl");
            __query.setCallerMethodName("getObsListByObsNo");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ris.db.dao.po.ObservationReportPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ris.db.dao.po.ObservationReportPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ris.db.dao.po.ObservationReportPo>(ei.ris.db.dao.po._ObservationReportPo.getSingletonInternal()));
            java.util.List<ei.ris.db.dao.po.ObservationReportPo> __result = __command.execute();
            __query.complete();
            exiting("ei.ris.db.dao.ObsDaoImpl", "getObsListByObsNo", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ris.db.dao.ObsDaoImpl", "getObsListByObsNo", __e);
            throw __e;
        }
    }

}
