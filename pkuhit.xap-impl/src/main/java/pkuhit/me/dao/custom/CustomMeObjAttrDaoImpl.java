package pkuhit.me.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.630+0800")
public class CustomMeObjAttrDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.me.dao.custom.CustomMeObjAttrDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomMeObjAttrDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.me.dao.auto.entity.MeObjAttr> selectAllObjectAttribute(java.lang.String keyword, java.lang.String type, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.me.dao.custom.CustomMeObjAttrDaoImpl", "selectAllObjectAttribute", keyword, type, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/me/dao/custom/CustomMeObjAttrDao/selectAllObjectAttribute.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("type", java.lang.String.class, type);
            __query.setCallerClassName("pkuhit.me.dao.custom.CustomMeObjAttrDaoImpl");
            __query.setCallerMethodName("selectAllObjectAttribute");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.me.dao.auto.entity.MeObjAttr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.me.dao.auto.entity.MeObjAttr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.me.dao.auto.entity.MeObjAttr>(pkuhit.me.dao.auto.entity._MeObjAttr.getSingletonInternal()));
            java.util.List<pkuhit.me.dao.auto.entity.MeObjAttr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.custom.CustomMeObjAttrDaoImpl", "selectAllObjectAttribute", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.custom.CustomMeObjAttrDaoImpl", "selectAllObjectAttribute", __e);
            throw __e;
        }
    }

}
