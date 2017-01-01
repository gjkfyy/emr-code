package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.782+0800")
public class CustomXapRolePortalDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapRolePortalDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapRolePortalDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapRolePortal> selectXapRolePortalList(java.lang.String roleCd) {
        entering("pkuhit.xap.dao.custom.CustomXapRolePortalDaoImpl", "selectXapRolePortalList", roleCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapRolePortalDao/selectXapRolePortalList.sql");
            __query.addParameter("roleCd", java.lang.String.class, roleCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapRolePortalDaoImpl");
            __query.setCallerMethodName("selectXapRolePortalList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapRolePortal>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapRolePortal>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapRolePortal>(pkuhit.xap.dao.auto.entity._XapRolePortal.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapRolePortal> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapRolePortalDaoImpl", "selectXapRolePortalList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapRolePortalDaoImpl", "selectXapRolePortalList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapPortal> selectXapPortalListByRoleId(java.lang.String roleCd) {
        entering("pkuhit.xap.dao.custom.CustomXapRolePortalDaoImpl", "selectXapPortalListByRoleId", roleCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapRolePortalDao/selectXapPortalListByRoleId.sql");
            __query.addParameter("roleCd", java.lang.String.class, roleCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapRolePortalDaoImpl");
            __query.setCallerMethodName("selectXapPortalListByRoleId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapPortal>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapPortal>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapPortal>(pkuhit.xap.dao.auto.entity._XapPortal.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapPortal> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapRolePortalDaoImpl", "selectXapPortalListByRoleId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapRolePortalDaoImpl", "selectXapPortalListByRoleId", __e);
            throw __e;
        }
    }

}
