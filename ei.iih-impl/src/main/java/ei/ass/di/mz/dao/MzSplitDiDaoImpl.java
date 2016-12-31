package ei.ass.di.mz.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.804+0800")
public class MzSplitDiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ass.di.mz.dao.MzSplitDiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MzSplitDiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ass.di.auto.po.DiagnosisPo> getDisListByEnSn(java.lang.String patientId, java.lang.String times, java.lang.String isMainF, java.lang.String onlyNotStop, org.seasar.doma.jdbc.SelectOptions options) {
        entering("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDisListByEnSn", patientId, times, isMainF, onlyNotStop, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/mz/dao/MzSplitDiDao/getDisListByEnSn.sql");
            __query.setOptions(options);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("isMainF", java.lang.String.class, isMainF);
            __query.addParameter("onlyNotStop", java.lang.String.class, onlyNotStop);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzSplitDiDaoImpl");
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
            exiting("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDisListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDisListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public ei.ass.di.auto.po.DiagnosisPo getDibDiDetail(java.lang.String diPk) {
        entering("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDibDiDetail", diPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/mz/dao/MzSplitDiDao/getDibDiDetail.sql");
            __query.addParameter("diPk", java.lang.String.class, diPk);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzSplitDiDaoImpl");
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
            exiting("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDibDiDetail", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDibDiDetail", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<ei.ass.di.auto.po.MzPatientDiagnosisEntity> getDisListByDicodes(java.lang.String patientId, java.lang.String times, java.util.List<java.lang.String> diCodeList) {
        entering("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDisListByDicodes", patientId, times, diCodeList);
        try {
            if (diCodeList == null) {
                throw new org.seasar.doma.DomaNullPointerException("diCodeList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/mz/dao/MzSplitDiDao/getDisListByDicodes.sql");
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("diCodeList", java.util.List.class, diCodeList);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzSplitDiDaoImpl");
            __query.setCallerMethodName("getDisListByDicodes");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.di.auto.po.MzPatientDiagnosisEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.di.auto.po.MzPatientDiagnosisEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal()));
            java.util.List<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDisListByDicodes", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzSplitDiDaoImpl", "getDisListByDicodes", __e);
            throw __e;
        }
    }

}
