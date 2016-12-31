package szlh.iih.ob.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.725+0800")
public class ObsDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.ob.dao.ObsDao {

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
    public java.util.List<szlh.iih.ob.po.ObservationReportPo> getObsListByEnSn(java.lang.String enPk, java.lang.String patientId, java.lang.String times, org.seasar.doma.jdbc.SelectOptions options) {
        entering("szlh.iih.ob.dao.ObsDaoImpl", "getObsListByEnSn", enPk, patientId, times, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/ob/dao/ObsDao/getObsListByEnSn.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.setCallerClassName("szlh.iih.ob.dao.ObsDaoImpl");
            __query.setCallerMethodName("getObsListByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.ob.po.ObservationReportPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.ob.po.ObservationReportPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.ob.po.ObservationReportPo>(szlh.iih.ob.po._ObservationReportPo.getSingletonInternal()));
            java.util.List<szlh.iih.ob.po.ObservationReportPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.ob.dao.ObsDaoImpl", "getObsListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.ob.dao.ObsDaoImpl", "getObsListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public szlh.iih.ob.po.ObservationReportPo getObservationByObsSn(java.lang.String obRpPk) {
        entering("szlh.iih.ob.dao.ObsDaoImpl", "getObservationByObsSn", obRpPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/ob/dao/ObsDao/getObservationByObsSn.sql");
            __query.addParameter("obRpPk", java.lang.String.class, obRpPk);
            __query.setCallerClassName("szlh.iih.ob.dao.ObsDaoImpl");
            __query.setCallerMethodName("getObservationByObsSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.ob.po.ObservationReportPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.ob.po.ObservationReportPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<szlh.iih.ob.po.ObservationReportPo>(szlh.iih.ob.po._ObservationReportPo.getSingletonInternal()));
            szlh.iih.ob.po.ObservationReportPo __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.ob.dao.ObsDaoImpl", "getObservationByObsSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.ob.dao.ObsDaoImpl", "getObservationByObsSn", __e);
            throw __e;
        }
    }

}
