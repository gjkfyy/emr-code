package ei.en.mz.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.792+0800")
public class MzCusViewEnDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.en.mz.db.dao.MzCusViewEnDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MzCusViewEnDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public ei.en.db.dao.po.VwEnMzPo getViewEnMzPoByEnPk(java.lang.String enPk, java.lang.String patientId, java.lang.String times) {
        entering("ei.en.mz.db.dao.MzCusViewEnDaoImpl", "getViewEnMzPoByEnPk", enPk, patientId, times);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/en/mz/db/dao/MzCusViewEnDao/getViewEnMzPoByEnPk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.setCallerClassName("ei.en.mz.db.dao.MzCusViewEnDaoImpl");
            __query.setCallerMethodName("getViewEnMzPoByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.en.db.dao.po.VwEnMzPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.en.db.dao.po.VwEnMzPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.en.db.dao.po.VwEnMzPo>(ei.en.db.dao.po._VwEnMzPo.getSingletonInternal()));
            ei.en.db.dao.po.VwEnMzPo __result = __command.execute();
            __query.complete();
            exiting("ei.en.mz.db.dao.MzCusViewEnDaoImpl", "getViewEnMzPoByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.en.mz.db.dao.MzCusViewEnDaoImpl", "getViewEnMzPoByEnPk", __e);
            throw __e;
        }
    }

}
