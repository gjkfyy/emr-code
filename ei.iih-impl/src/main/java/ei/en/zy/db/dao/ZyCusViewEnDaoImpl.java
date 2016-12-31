package ei.en.zy.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.843+0800")
public class ZyCusViewEnDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.en.zy.db.dao.ZyCusViewEnDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ZyCusViewEnDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public ei.en.db.dao.po.VwEnZyPo getViewEnZyPoByEnPk(java.lang.String enPk, java.lang.String patientId, java.lang.String times) {
        entering("ei.en.zy.db.dao.ZyCusViewEnDaoImpl", "getViewEnZyPoByEnPk", enPk, patientId, times);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/en/zy/db/dao/ZyCusViewEnDao/getViewEnZyPoByEnPk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.setCallerClassName("ei.en.zy.db.dao.ZyCusViewEnDaoImpl");
            __query.setCallerMethodName("getViewEnZyPoByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.en.db.dao.po.VwEnZyPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.en.db.dao.po.VwEnZyPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.en.db.dao.po.VwEnZyPo>(ei.en.db.dao.po._VwEnZyPo.getSingletonInternal()));
            ei.en.db.dao.po.VwEnZyPo __result = __command.execute();
            __query.complete();
            exiting("ei.en.zy.db.dao.ZyCusViewEnDaoImpl", "getViewEnZyPoByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.en.zy.db.dao.ZyCusViewEnDaoImpl", "getViewEnZyPoByEnPk", __e);
            throw __e;
        }
    }

}
