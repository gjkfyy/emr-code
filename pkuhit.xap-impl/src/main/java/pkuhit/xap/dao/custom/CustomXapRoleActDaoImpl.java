package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.587+0800")
public class CustomXapRoleActDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapRoleActDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapRoleActDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapRoleAct> selectXapRoleActList(java.lang.String roleCd) {
        entering("pkuhit.xap.dao.custom.CustomXapRoleActDaoImpl", "selectXapRoleActList", roleCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapRoleActDao/selectXapRoleActList.sql");
            __query.addParameter("roleCd", java.lang.String.class, roleCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapRoleActDaoImpl");
            __query.setCallerMethodName("selectXapRoleActList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapRoleAct>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapRoleAct>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapRoleAct> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapRoleActDaoImpl", "selectXapRoleActList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapRoleActDaoImpl", "selectXapRoleActList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.MeFuAct> selectFuActionListByRoleCd(java.lang.String roleCd) {
        entering("pkuhit.xap.dao.custom.CustomXapRoleActDaoImpl", "selectFuActionListByRoleCd", roleCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapRoleActDao/selectFuActionListByRoleCd.sql");
            __query.addParameter("roleCd", java.lang.String.class, roleCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapRoleActDaoImpl");
            __query.setCallerMethodName("selectFuActionListByRoleCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.MeFuAct>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.MeFuAct>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.MeFuAct>(pkuhit.xap.dao.auto.entity._MeFuAct.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.MeFuAct> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapRoleActDaoImpl", "selectFuActionListByRoleCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapRoleActDaoImpl", "selectFuActionListByRoleCd", __e);
            throw __e;
        }
    }

}
