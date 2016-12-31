package ei.ass.di.zy.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.834+0800")
public class ZySplitDiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ass.di.zy.dao.ZySplitDiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ZySplitDiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ass.di.auto.po.DiagnosisPo> getDisListByEnSn(java.lang.String patientId, java.lang.String times, java.lang.String isMainF, java.lang.String onlyNotStop, org.seasar.doma.jdbc.SelectOptions options) {
        entering("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDisListByEnSn", patientId, times, isMainF, onlyNotStop, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/zy/dao/ZySplitDiDao/getDisListByEnSn.sql");
            __query.setOptions(options);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("isMainF", java.lang.String.class, isMainF);
            __query.addParameter("onlyNotStop", java.lang.String.class, onlyNotStop);
            __query.setCallerClassName("ei.ass.di.zy.dao.ZySplitDiDaoImpl");
            __query.setCallerMethodName("getDisListByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.di.auto.po.DiagnosisPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.di.auto.po.DiagnosisPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ass.di.auto.po.DiagnosisPo>(ei.ass.di.auto.po._DiagnosisPo.getSingletonInternal()));
            java.util.List<ei.ass.di.auto.po.DiagnosisPo> __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDisListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDisListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public ei.ass.di.auto.po.DiagnosisPo getDibDiDetail(java.lang.String diPk) {
        entering("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDibDiDetail", diPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/zy/dao/ZySplitDiDao/getDibDiDetail.sql");
            __query.addParameter("diPk", java.lang.String.class, diPk);
            __query.setCallerClassName("ei.ass.di.zy.dao.ZySplitDiDaoImpl");
            __query.setCallerMethodName("getDibDiDetail");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ass.di.auto.po.DiagnosisPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ass.di.auto.po.DiagnosisPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.ass.di.auto.po.DiagnosisPo>(ei.ass.di.auto.po._DiagnosisPo.getSingletonInternal()));
            ei.ass.di.auto.po.DiagnosisPo __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDibDiDetail", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDibDiDetail", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<ei.ass.di.auto.po.ZyPatientDiagnosisEntity> getDisListByDicodes(java.lang.String patientId, java.lang.String times, java.util.List<java.lang.String> diCodeList) {
        entering("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDisListByDicodes", patientId, times, diCodeList);
        try {
            if (diCodeList == null) {
                throw new org.seasar.doma.DomaNullPointerException("diCodeList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/zy/dao/ZySplitDiDao/getDisListByDicodes.sql");
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("diCodeList", java.util.List.class, diCodeList);
            __query.setCallerClassName("ei.ass.di.zy.dao.ZySplitDiDaoImpl");
            __query.setCallerMethodName("getDisListByDicodes");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.di.auto.po.ZyPatientDiagnosisEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.di.auto.po.ZyPatientDiagnosisEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ass.di.auto.po.ZyPatientDiagnosisEntity>(ei.ass.di.auto.po._ZyPatientDiagnosisEntity.getSingletonInternal()));
            java.util.List<ei.ass.di.auto.po.ZyPatientDiagnosisEntity> __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDisListByDicodes", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.zy.dao.ZySplitDiDaoImpl", "getDisListByDicodes", __e);
            throw __e;
        }
    }

}
