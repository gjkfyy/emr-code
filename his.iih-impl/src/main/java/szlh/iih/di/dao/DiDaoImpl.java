package szlh.iih.di.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:26.343+0800")
public class DiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.di.dao.DiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public DiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.di.po.DiagnosisPo> getDisListByEnSn(java.lang.String enPk, java.lang.String patientId, java.lang.String times, java.lang.String isMainF, java.lang.String onlyNotStop, org.seasar.doma.jdbc.SelectOptions options) {
        entering("szlh.iih.di.dao.DiDaoImpl", "getDisListByEnSn", enPk, patientId, times, isMainF, onlyNotStop, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/di/dao/DiDao/getDisListByEnSn.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("isMainF", java.lang.String.class, isMainF);
            __query.addParameter("onlyNotStop", java.lang.String.class, onlyNotStop);
            __query.setCallerClassName("szlh.iih.di.dao.DiDaoImpl");
            __query.setCallerMethodName("getDisListByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.di.po.DiagnosisPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.di.po.DiagnosisPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.di.po.DiagnosisPo>(szlh.iih.di.po._DiagnosisPo.getSingletonInternal()));
            java.util.List<szlh.iih.di.po.DiagnosisPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.di.dao.DiDaoImpl", "getDisListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.di.dao.DiDaoImpl", "getDisListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public szlh.iih.di.po.DiagnosisPo getDibDiDetail(java.lang.String diPk) {
        entering("szlh.iih.di.dao.DiDaoImpl", "getDibDiDetail", diPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/di/dao/DiDao/getDibDiDetail.sql");
            __query.addParameter("diPk", java.lang.String.class, diPk);
            __query.setCallerClassName("szlh.iih.di.dao.DiDaoImpl");
            __query.setCallerMethodName("getDibDiDetail");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.di.po.DiagnosisPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.di.po.DiagnosisPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<szlh.iih.di.po.DiagnosisPo>(szlh.iih.di.po._DiagnosisPo.getSingletonInternal()));
            szlh.iih.di.po.DiagnosisPo __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.di.dao.DiDaoImpl", "getDibDiDetail", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.di.dao.DiDaoImpl", "getDibDiDetail", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<szlh.iih.di.po.MzPatientDiagnosisEntity> getDisListByDicodes(java.lang.String patientId, java.lang.String times, java.util.List<java.lang.String> diCodeList) {
        entering("szlh.iih.di.dao.DiDaoImpl", "getDisListByDicodes", patientId, times, diCodeList);
        try {
            if (diCodeList == null) {
                throw new org.seasar.doma.DomaNullPointerException("diCodeList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/di/dao/DiDao/getDisListByDicodes.sql");
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("diCodeList", java.util.List.class, diCodeList);
            __query.setCallerClassName("szlh.iih.di.dao.DiDaoImpl");
            __query.setCallerMethodName("getDisListByDicodes");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.di.po.MzPatientDiagnosisEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.di.po.MzPatientDiagnosisEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.di.po.MzPatientDiagnosisEntity>(szlh.iih.di.po._MzPatientDiagnosisEntity.getSingletonInternal()));
            java.util.List<szlh.iih.di.po.MzPatientDiagnosisEntity> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.di.dao.DiDaoImpl", "getDisListByDicodes", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.di.dao.DiDaoImpl", "getDisListByDicodes", __e);
            throw __e;
        }
    }

}
