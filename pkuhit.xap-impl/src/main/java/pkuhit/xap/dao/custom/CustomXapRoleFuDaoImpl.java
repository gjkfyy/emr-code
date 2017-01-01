package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.753+0800")
public class CustomXapRoleFuDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapRoleFuDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapRoleFuDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapRoleFu> selectXapRoleFuList(java.lang.String roleCd) {
        entering("pkuhit.xap.dao.custom.CustomXapRoleFuDaoImpl", "selectXapRoleFuList", roleCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapRoleFuDao/selectXapRoleFuList.sql");
            __query.addParameter("roleCd", java.lang.String.class, roleCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapRoleFuDaoImpl");
            __query.setCallerMethodName("selectXapRoleFuList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapRoleFu>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapRoleFu>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapRoleFu>(pkuhit.xap.dao.auto.entity._XapRoleFu.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapRoleFu> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapRoleFuDaoImpl", "selectXapRoleFuList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapRoleFuDaoImpl", "selectXapRoleFuList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.MeFu> selectFunctionListByRoleCd(java.lang.String roleCd) {
        entering("pkuhit.xap.dao.custom.CustomXapRoleFuDaoImpl", "selectFunctionListByRoleCd", roleCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapRoleFuDao/selectFunctionListByRoleCd.sql");
            __query.addParameter("roleCd", java.lang.String.class, roleCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapRoleFuDaoImpl");
            __query.setCallerMethodName("selectFunctionListByRoleCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.MeFu>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.MeFu>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.MeFu>(pkuhit.xap.dao.auto.entity._MeFu.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.MeFu> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapRoleFuDaoImpl", "selectFunctionListByRoleCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapRoleFuDaoImpl", "selectFunctionListByRoleCd", __e);
            throw __e;
        }
    }

}
