package ei.pa.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.758+0800")
public class PatientDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.pa.dao.PatientDao {

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
    public java.util.List<ei.pa.po.PatientInfoForXMLPo> getPatientInfoForXML(java.lang.String patientId, java.lang.String inVisitTimes, java.lang.String outVisitTimes, java.lang.String enPk) {
        entering("ei.pa.dao.PatientDaoImpl", "getPatientInfoForXML", patientId, inVisitTimes, outVisitTimes, enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/pa/dao/PatientDao/getPatientInfoForXML.sql");
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("inVisitTimes", java.lang.String.class, inVisitTimes);
            __query.addParameter("outVisitTimes", java.lang.String.class, outVisitTimes);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("ei.pa.dao.PatientDaoImpl");
            __query.setCallerMethodName("getPatientInfoForXML");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.pa.po.PatientInfoForXMLPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.pa.po.PatientInfoForXMLPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.pa.po.PatientInfoForXMLPo>(ei.pa.po._PatientInfoForXMLPo.getSingletonInternal()));
            java.util.List<ei.pa.po.PatientInfoForXMLPo> __result = __command.execute();
            __query.complete();
            exiting("ei.pa.dao.PatientDaoImpl", "getPatientInfoForXML", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.pa.dao.PatientDaoImpl", "getPatientInfoForXML", __e);
            throw __e;
        }
    }

}
