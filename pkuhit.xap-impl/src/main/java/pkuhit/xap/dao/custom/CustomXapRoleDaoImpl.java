package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.715+0800")
public class CustomXapRoleDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapRoleDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapRoleDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapRole> selectXapRoleList() {
        entering("pkuhit.xap.dao.custom.CustomXapRoleDaoImpl", "selectXapRoleList");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapRoleDao/selectXapRoleList.sql");
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapRoleDaoImpl");
            __query.setCallerMethodName("selectXapRoleList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapRole>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapRole>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapRole>(pkuhit.xap.dao.auto.entity._XapRole.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapRole> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapRoleDaoImpl", "selectXapRoleList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapRoleDaoImpl", "selectXapRoleList", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapRole selectByCode(java.lang.String roleCd) {
        entering("pkuhit.xap.dao.custom.CustomXapRoleDaoImpl", "selectByCode", roleCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapRoleDao/selectByCode.sql");
            __query.addParameter("roleCd", java.lang.String.class, roleCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapRoleDaoImpl");
            __query.setCallerMethodName("selectByCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapRole> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapRole>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.xap.dao.auto.entity.XapRole>(pkuhit.xap.dao.auto.entity._XapRole.getSingletonInternal()));
            pkuhit.xap.dao.auto.entity.XapRole __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapRoleDaoImpl", "selectByCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapRoleDaoImpl", "selectByCode", __e);
            throw __e;
        }
    }

}
