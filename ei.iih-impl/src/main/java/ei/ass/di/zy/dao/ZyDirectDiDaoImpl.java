package ei.ass.di.zy.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.807+0800")
public class ZyDirectDiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ass.di.zy.dao.ZyDirectDiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ZyDirectDiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ass.di.auto.po.DiagnosisPo> getDisListByEnSn(java.lang.String enPk, java.lang.String isMainF, java.lang.String onlyNotStop, org.seasar.doma.jdbc.SelectOptions options) {
        entering("ei.ass.di.zy.dao.ZyDirectDiDaoImpl", "getDisListByEnSn", enPk, isMainF, onlyNotStop, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/zy/dao/ZyDirectDiDao/getDisListByEnSn.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("isMainF", java.lang.String.class, isMainF);
            __query.addParameter("onlyNotStop", java.lang.String.class, onlyNotStop);
            __query.setCallerClassName("ei.ass.di.zy.dao.ZyDirectDiDaoImpl");
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
            exiting("ei.ass.di.zy.dao.ZyDirectDiDaoImpl", "getDisListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.zy.dao.ZyDirectDiDaoImpl", "getDisListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public ei.ass.di.auto.po.DiagnosisPo getDibDiDetail(java.lang.String diPk) {
        entering("ei.ass.di.zy.dao.ZyDirectDiDaoImpl", "getDibDiDetail", diPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/zy/dao/ZyDirectDiDao/getDibDiDetail.sql");
            __query.addParameter("diPk", java.lang.String.class, diPk);
            __query.setCallerClassName("ei.ass.di.zy.dao.ZyDirectDiDaoImpl");
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
            exiting("ei.ass.di.zy.dao.ZyDirectDiDaoImpl", "getDibDiDetail", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.zy.dao.ZyDirectDiDaoImpl", "getDibDiDetail", __e);
            throw __e;
        }
    }

}
