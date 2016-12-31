package iih.di.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:57.460+0800")
public class CusMrbMrDocDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.di.db.dao.CusMrbMrDocDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrbMrDocDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.MrEntity> selectMrsByEnSn(java.lang.String enSn) {
        entering("iih.di.db.dao.CusMrbMrDocDaoImpl", "selectMrsByEnSn", enSn);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/CusMrbMrDocDao/selectMrsByEnSn.sql");
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.setCallerClassName("iih.di.db.dao.CusMrbMrDocDaoImpl");
            __query.setCallerMethodName("selectMrsByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MrEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MrEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.MrEntity>(iih.di.db.gen.entity._MrEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.MrEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.CusMrbMrDocDaoImpl", "selectMrsByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.CusMrbMrDocDaoImpl", "selectMrsByEnSn", __e);
            throw __e;
        }
    }

}
