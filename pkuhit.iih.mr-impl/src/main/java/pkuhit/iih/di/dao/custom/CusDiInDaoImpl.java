package pkuhit.iih.di.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.966+0800")
public class CusDiInDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.di.dao.custom.CusDiInDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusDiInDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn> selectDiInsByEnSn(java.lang.String enSn) {
        entering("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInsByEnSn", enSn);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/di/dao/custom/CusDiInDao/selectDiInsByEnSn.sql");
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.setCallerClassName("pkuhit.iih.di.dao.custom.CusDiInDaoImpl");
            __query.setCallerMethodName("selectDiInsByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.di.dao.auto.entity.DiIn>(pkuhit.iih.di.dao.auto.entity._DiIn.getSingletonInternal()));
            java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInsByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInsByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn> selectDiIns(java.lang.String enSn) {
        entering("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiIns", enSn);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/di/dao/custom/CusDiInDao/selectDiIns.sql");
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.setCallerClassName("pkuhit.iih.di.dao.custom.CusDiInDaoImpl");
            __query.setCallerMethodName("selectDiIns");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.di.dao.auto.entity.DiIn>(pkuhit.iih.di.dao.auto.entity._DiIn.getSingletonInternal()));
            java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiIns", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiIns", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.di.dao.auto.entity.DiIn selectDiInByMainF(java.lang.String enSn, short mainF) {
        entering("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInByMainF", enSn, mainF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/di/dao/custom/CusDiInDao/selectDiInByMainF.sql");
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.addParameter("mainF", short.class, mainF);
            __query.setCallerClassName("pkuhit.iih.di.dao.custom.CusDiInDaoImpl");
            __query.setCallerMethodName("selectDiInByMainF");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.di.dao.auto.entity.DiIn> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.di.dao.auto.entity.DiIn>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.di.dao.auto.entity.DiIn>(pkuhit.iih.di.dao.auto.entity._DiIn.getSingletonInternal()));
            pkuhit.iih.di.dao.auto.entity.DiIn __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInByMainF", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInByMainF", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn> selectDiInSon(java.lang.String parDiSn) {
        entering("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInSon", parDiSn);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/di/dao/custom/CusDiInDao/selectDiInSon.sql");
            __query.addParameter("parDiSn", java.lang.String.class, parDiSn);
            __query.setCallerClassName("pkuhit.iih.di.dao.custom.CusDiInDaoImpl");
            __query.setCallerMethodName("selectDiInSon");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.di.dao.auto.entity.DiIn>(pkuhit.iih.di.dao.auto.entity._DiIn.getSingletonInternal()));
            java.util.List<pkuhit.iih.di.dao.auto.entity.DiIn> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInSon", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.di.dao.custom.CusDiInDaoImpl", "selectDiInSon", __e);
            throw __e;
        }
    }

}
