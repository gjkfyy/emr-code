package ei.his.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.876+0800")
public class CusHisIemrEnAdtEntityDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.his.db.dao.CusHisIemrEnAdtEntityDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusHisIemrEnAdtEntityDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.his.db.dao.auto.entity.IemrEnAdtEntity> selectAll() {
        entering("ei.his.db.dao.CusHisIemrEnAdtEntityDaoImpl", "selectAll");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/his/db/dao/CusHisIemrEnAdtEntityDao/selectAll.sql");
            __query.setCallerClassName("ei.his.db.dao.CusHisIemrEnAdtEntityDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.his.db.dao.auto.entity.IemrEnAdtEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.his.db.dao.auto.entity.IemrEnAdtEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal()));
            java.util.List<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.CusHisIemrEnAdtEntityDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.CusHisIemrEnAdtEntityDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

}
