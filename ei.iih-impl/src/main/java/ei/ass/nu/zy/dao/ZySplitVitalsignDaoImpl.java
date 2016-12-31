package ei.ass.nu.zy.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.838+0800")
public class ZySplitVitalsignDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ass.nu.zy.dao.ZySplitVitalsignDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ZySplitVitalsignDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ass.nu.auto.po.VitalsignPo> getAcquisitionListByEnSn(java.lang.String patientId, java.lang.String times, java.lang.String acquisitionStartTime, java.lang.String acquisitionStopTime, java.lang.String isDesc) {
        entering("ei.ass.nu.zy.dao.ZySplitVitalsignDaoImpl", "getAcquisitionListByEnSn", patientId, times, acquisitionStartTime, acquisitionStopTime, isDesc);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/nu/zy/dao/ZySplitVitalsignDao/getAcquisitionListByEnSn.sql");
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("acquisitionStartTime", java.lang.String.class, acquisitionStartTime);
            __query.addParameter("acquisitionStopTime", java.lang.String.class, acquisitionStopTime);
            __query.addParameter("isDesc", java.lang.String.class, isDesc);
            __query.setCallerClassName("ei.ass.nu.zy.dao.ZySplitVitalsignDaoImpl");
            __query.setCallerMethodName("getAcquisitionListByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.nu.auto.po.VitalsignPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.nu.auto.po.VitalsignPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ass.nu.auto.po.VitalsignPo>(ei.ass.nu.auto.po._VitalsignPo.getSingletonInternal()));
            java.util.List<ei.ass.nu.auto.po.VitalsignPo> __result = __command.execute();
            __query.complete();
            exiting("ei.ass.nu.zy.dao.ZySplitVitalsignDaoImpl", "getAcquisitionListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.nu.zy.dao.ZySplitVitalsignDaoImpl", "getAcquisitionListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public ei.ass.nu.auto.po.VitalsignPo getAcquisitionListByVitalSignPk(java.lang.String vitalSignPk) {
        entering("ei.ass.nu.zy.dao.ZySplitVitalsignDaoImpl", "getAcquisitionListByVitalSignPk", vitalSignPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/nu/zy/dao/ZySplitVitalsignDao/getAcquisitionListByVitalSignPk.sql");
            __query.addParameter("vitalSignPk", java.lang.String.class, vitalSignPk);
            __query.setCallerClassName("ei.ass.nu.zy.dao.ZySplitVitalsignDaoImpl");
            __query.setCallerMethodName("getAcquisitionListByVitalSignPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ass.nu.auto.po.VitalsignPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ass.nu.auto.po.VitalsignPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.ass.nu.auto.po.VitalsignPo>(ei.ass.nu.auto.po._VitalsignPo.getSingletonInternal()));
            ei.ass.nu.auto.po.VitalsignPo __result = __command.execute();
            __query.complete();
            exiting("ei.ass.nu.zy.dao.ZySplitVitalsignDaoImpl", "getAcquisitionListByVitalSignPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.nu.zy.dao.ZySplitVitalsignDaoImpl", "getAcquisitionListByVitalSignPk", __e);
            throw __e;
        }
    }

}
