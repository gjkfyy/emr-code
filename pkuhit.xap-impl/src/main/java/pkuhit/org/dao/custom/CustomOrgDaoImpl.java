package pkuhit.org.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.485+0800")
public class CustomOrgDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.org.dao.custom.CustomOrgDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomOrgDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.org.dao.auto.entity.Org> selectOrgList(java.lang.String orgTpCd) {
        entering("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectOrgList", orgTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomOrgDao/selectOrgList.sql");
            __query.addParameter("orgTpCd", java.lang.String.class, orgTpCd);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomOrgDaoImpl");
            __query.setCallerMethodName("selectOrgList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.Org>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.Org>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.org.dao.auto.entity.Org>(pkuhit.org.dao.auto.entity._Org.getSingletonInternal()));
            java.util.List<pkuhit.org.dao.auto.entity.Org> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectOrgList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectOrgList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.org.dao.auto.entity.WardDept> selectDeptList(java.lang.String keyword, java.lang.String id, java.lang.String deptTpCd, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectDeptList", keyword, id, deptTpCd, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomOrgDao/selectDeptList.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("id", java.lang.String.class, id);
            __query.addParameter("deptTpCd", java.lang.String.class, deptTpCd);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomOrgDaoImpl");
            __query.setCallerMethodName("selectDeptList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.WardDept>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.WardDept>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.org.dao.auto.entity.WardDept>(pkuhit.org.dao.auto.entity._WardDept.getSingletonInternal()));
            java.util.List<pkuhit.org.dao.auto.entity.WardDept> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectDeptList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectDeptList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.org.dao.auto.entity.Org> selectUserDeptList(java.lang.String userId, java.lang.String deployMode) {
        entering("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectUserDeptList", userId, deployMode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomOrgDao/selectUserDeptList.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deployMode", java.lang.String.class, deployMode);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomOrgDaoImpl");
            __query.setCallerMethodName("selectUserDeptList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.Org>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.Org>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.org.dao.auto.entity.Org>(pkuhit.org.dao.auto.entity._Org.getSingletonInternal()));
            java.util.List<pkuhit.org.dao.auto.entity.Org> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectUserDeptList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectUserDeptList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.org.dao.auto.entity.OrgEmp> selectOrgEmpListByDept(java.lang.String keyword, java.lang.String deptCd, java.lang.String id, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectOrgEmpListByDept", keyword, deptCd, id, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomOrgDao/selectOrgEmpListByDept.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("id", java.lang.String.class, id);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomOrgDaoImpl");
            __query.setCallerMethodName("selectOrgEmpListByDept");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.OrgEmp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.OrgEmp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.org.dao.auto.entity.OrgEmp>(pkuhit.org.dao.auto.entity._OrgEmp.getSingletonInternal()));
            java.util.List<pkuhit.org.dao.auto.entity.OrgEmp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectOrgEmpListByDept", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomOrgDaoImpl", "selectOrgEmpListByDept", __e);
            throw __e;
        }
    }

}
