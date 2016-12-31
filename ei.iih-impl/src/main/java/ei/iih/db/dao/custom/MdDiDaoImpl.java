package ei.iih.db.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.711+0800")
public class MdDiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.iih.db.dao.custom.MdDiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MdDiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.iih.db.dao.auto.entity.MdDi> selectMdDi() {
        entering("ei.iih.db.dao.custom.MdDiDaoImpl", "selectMdDi");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/iih/db/dao/custom/MdDiDao/selectMdDi.sql");
            __query.setCallerClassName("ei.iih.db.dao.custom.MdDiDaoImpl");
            __query.setCallerMethodName("selectMdDi");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.iih.db.dao.auto.entity.MdDi>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.iih.db.dao.auto.entity.MdDi>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.iih.db.dao.auto.entity.MdDi>(ei.iih.db.dao.auto.entity._MdDi.getSingletonInternal()));
            java.util.List<ei.iih.db.dao.auto.entity.MdDi> __result = __command.execute();
            __query.complete();
            exiting("ei.iih.db.dao.custom.MdDiDaoImpl", "selectMdDi", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.iih.db.dao.custom.MdDiDaoImpl", "selectMdDi", __e);
            throw __e;
        }
    }

}
