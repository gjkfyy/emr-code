package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.713+0800")
public class CustomXapUserRoleDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapUserRoleDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapUserRoleDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole> selectXapUserRoleList(java.lang.String userId, java.lang.String orgCd, java.lang.String roleId) {
        entering("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectXapUserRoleList", userId, orgCd, roleId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserRoleDao/selectXapUserRoleList.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("roleId", java.lang.String.class, roleId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl");
            __query.setCallerMethodName("selectXapUserRoleList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapUserRole>(pkuhit.xap.dao.auto.entity._XapUserRole.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectXapUserRoleList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectXapUserRoleList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> deleteByUserId(java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "deleteByUserId", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserRoleDao/deleteByUserId.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl");
            __query.setCallerMethodName("deleteByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "deleteByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "deleteByUserId", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.org.dao.auto.entity.OrgEmpDept> selectXapUserOrgDeptList(java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectXapUserOrgDeptList", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserRoleDao/selectXapUserOrgDeptList.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl");
            __query.setCallerMethodName("selectXapUserOrgDeptList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.OrgEmpDept>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.OrgEmpDept>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.org.dao.auto.entity.OrgEmpDept>(pkuhit.org.dao.auto.entity._OrgEmpDept.getSingletonInternal()));
            java.util.List<pkuhit.org.dao.auto.entity.OrgEmpDept> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectXapUserOrgDeptList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectXapUserOrgDeptList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole> selectDoctorOrNurse(java.lang.String userId) {
        entering("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectDoctorOrNurse", userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserRoleDao/selectDoctorOrNurse.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl");
            __query.setCallerMethodName("selectDoctorOrNurse");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapUserRole>(pkuhit.xap.dao.auto.entity._XapUserRole.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectDoctorOrNurse", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectDoctorOrNurse", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole> selectCheckUserRole(java.lang.String userId, java.lang.String deptCd) {
        entering("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectCheckUserRole", userId, deptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapUserRoleDao/selectCheckUserRole.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl");
            __query.setCallerMethodName("selectCheckUserRole");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapUserRole>(pkuhit.xap.dao.auto.entity._XapUserRole.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapUserRole> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectCheckUserRole", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapUserRoleDaoImpl", "selectCheckUserRole", __e);
            throw __e;
        }
    }

}
