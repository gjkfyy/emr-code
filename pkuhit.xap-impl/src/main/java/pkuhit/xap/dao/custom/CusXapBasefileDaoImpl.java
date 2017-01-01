package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.476+0800")
public class CusXapBasefileDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CusXapBasefileDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusXapBasefileDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapBasefile selectByIdForUpdate(java.lang.String filePk) {
        entering("pkuhit.xap.dao.custom.CusXapBasefileDaoImpl", "selectByIdForUpdate", filePk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CusXapBasefileDao/selectByIdForUpdate.sql");
            __query.addParameter("filePk", java.lang.String.class, filePk);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CusXapBasefileDaoImpl");
            __query.setCallerMethodName("selectByIdForUpdate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapBasefile> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapBasefile>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.xap.dao.auto.entity.XapBasefile>(pkuhit.xap.dao.auto.entity._XapBasefile.getSingletonInternal()));
            pkuhit.xap.dao.auto.entity.XapBasefile __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CusXapBasefileDaoImpl", "selectByIdForUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CusXapBasefileDaoImpl", "selectByIdForUpdate", __e);
            throw __e;
        }
    }

}
