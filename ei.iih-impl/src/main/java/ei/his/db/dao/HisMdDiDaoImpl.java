package ei.his.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.816+0800")
public class HisMdDiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.his.db.dao.HisMdDiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public HisMdDiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.his.db.dao.auto.entity.HisMdDi> selectHisMdDi() {
        entering("ei.his.db.dao.HisMdDiDaoImpl", "selectHisMdDi");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/his/db/dao/HisMdDiDao/selectHisMdDi.sql");
            __query.setCallerClassName("ei.his.db.dao.HisMdDiDaoImpl");
            __query.setCallerMethodName("selectHisMdDi");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.his.db.dao.auto.entity.HisMdDi>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.his.db.dao.auto.entity.HisMdDi>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.his.db.dao.auto.entity.HisMdDi>(ei.his.db.dao.auto.entity._HisMdDi.getSingletonInternal()));
            java.util.List<ei.his.db.dao.auto.entity.HisMdDi> __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisMdDiDaoImpl", "selectHisMdDi", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisMdDiDaoImpl", "selectHisMdDi", __e);
            throw __e;
        }
    }

}
