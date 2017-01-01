package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.589+0800")
public class CustomXapExternalInterfDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapExternalInterfDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapExternalInterfDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapExterInterf> selectXapExternalInterList(org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.custom.CustomXapExternalInterfDaoImpl", "selectXapExternalInterList", options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapExternalInterfDao/selectXapExternalInterList.sql");
            __query.setOptions(options);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapExternalInterfDaoImpl");
            __query.setCallerMethodName("selectXapExternalInterList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapExterInterf>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapExterInterf>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapExterInterf>(pkuhit.xap.dao.auto.entity._XapExterInterf.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapExterInterf> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapExternalInterfDaoImpl", "selectXapExternalInterList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapExternalInterfDaoImpl", "selectXapExternalInterList", __e);
            throw __e;
        }
    }

}
