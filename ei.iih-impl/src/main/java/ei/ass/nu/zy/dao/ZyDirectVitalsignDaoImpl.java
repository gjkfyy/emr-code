package ei.ass.nu.zy.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.715+0800")
public class ZyDirectVitalsignDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ass.nu.zy.dao.ZyDirectVitalsignDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ZyDirectVitalsignDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ass.nu.auto.po.VitalsignPo> getAcquisitionListByEnSn(java.lang.String enPk, java.lang.String acquisitionStartTime, java.lang.String acquisitionStopTime, java.lang.String isDesc, org.seasar.doma.jdbc.SelectOptions options) {
        entering("ei.ass.nu.zy.dao.ZyDirectVitalsignDaoImpl", "getAcquisitionListByEnSn", enPk, acquisitionStartTime, acquisitionStopTime, isDesc, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/nu/zy/dao/ZyDirectVitalsignDao/getAcquisitionListByEnSn.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("acquisitionStartTime", java.lang.String.class, acquisitionStartTime);
            __query.addParameter("acquisitionStopTime", java.lang.String.class, acquisitionStopTime);
            __query.addParameter("isDesc", java.lang.String.class, isDesc);
            __query.setCallerClassName("ei.ass.nu.zy.dao.ZyDirectVitalsignDaoImpl");
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
            exiting("ei.ass.nu.zy.dao.ZyDirectVitalsignDaoImpl", "getAcquisitionListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.nu.zy.dao.ZyDirectVitalsignDaoImpl", "getAcquisitionListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public ei.ass.nu.auto.po.VitalsignPo getAcquisitionListByVitalSignPk(java.lang.String vitalSignPk) {
        entering("ei.ass.nu.zy.dao.ZyDirectVitalsignDaoImpl", "getAcquisitionListByVitalSignPk", vitalSignPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/nu/zy/dao/ZyDirectVitalsignDao/getAcquisitionListByVitalSignPk.sql");
            __query.addParameter("vitalSignPk", java.lang.String.class, vitalSignPk);
            __query.setCallerClassName("ei.ass.nu.zy.dao.ZyDirectVitalsignDaoImpl");
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
            exiting("ei.ass.nu.zy.dao.ZyDirectVitalsignDaoImpl", "getAcquisitionListByVitalSignPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.nu.zy.dao.ZyDirectVitalsignDaoImpl", "getAcquisitionListByVitalSignPk", __e);
            throw __e;
        }
    }

}
