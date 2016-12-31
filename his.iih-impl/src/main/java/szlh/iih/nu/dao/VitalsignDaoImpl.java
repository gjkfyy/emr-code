package szlh.iih.nu.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:26.359+0800")
public class VitalsignDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.nu.dao.VitalsignDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public VitalsignDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.nu.po.VitalsignPo> getAcquisitionListByEnSn(java.lang.String enPk, java.lang.String patientId, java.lang.String times, java.lang.String acquisitionStartTime, java.lang.String acquisitionStopTime, java.lang.String isDesc) {
        entering("szlh.iih.nu.dao.VitalsignDaoImpl", "getAcquisitionListByEnSn", enPk, patientId, times, acquisitionStartTime, acquisitionStopTime, isDesc);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/nu/dao/VitalsignDao/getAcquisitionListByEnSn.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("acquisitionStartTime", java.lang.String.class, acquisitionStartTime);
            __query.addParameter("acquisitionStopTime", java.lang.String.class, acquisitionStopTime);
            __query.addParameter("isDesc", java.lang.String.class, isDesc);
            __query.setCallerClassName("szlh.iih.nu.dao.VitalsignDaoImpl");
            __query.setCallerMethodName("getAcquisitionListByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.nu.po.VitalsignPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.nu.po.VitalsignPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.nu.po.VitalsignPo>(szlh.iih.nu.po._VitalsignPo.getSingletonInternal()));
            java.util.List<szlh.iih.nu.po.VitalsignPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.nu.dao.VitalsignDaoImpl", "getAcquisitionListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.nu.dao.VitalsignDaoImpl", "getAcquisitionListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public szlh.iih.nu.po.VitalsignPo getAcquisitionListByVitalSignPk(java.lang.String vitalSignPk) {
        entering("szlh.iih.nu.dao.VitalsignDaoImpl", "getAcquisitionListByVitalSignPk", vitalSignPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/nu/dao/VitalsignDao/getAcquisitionListByVitalSignPk.sql");
            __query.addParameter("vitalSignPk", java.lang.String.class, vitalSignPk);
            __query.setCallerClassName("szlh.iih.nu.dao.VitalsignDaoImpl");
            __query.setCallerMethodName("getAcquisitionListByVitalSignPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.nu.po.VitalsignPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.nu.po.VitalsignPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<szlh.iih.nu.po.VitalsignPo>(szlh.iih.nu.po._VitalsignPo.getSingletonInternal()));
            szlh.iih.nu.po.VitalsignPo __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.nu.dao.VitalsignDaoImpl", "getAcquisitionListByVitalSignPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.nu.dao.VitalsignDaoImpl", "getAcquisitionListByVitalSignPk", __e);
            throw __e;
        }
    }

}
