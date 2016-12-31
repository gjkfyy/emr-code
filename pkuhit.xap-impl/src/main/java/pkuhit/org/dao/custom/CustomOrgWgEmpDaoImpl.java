package pkuhit.org.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.726+0800")
public class CustomOrgWgEmpDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.org.dao.custom.CustomOrgWgEmpDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomOrgWgEmpDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.org.dao.auto.entity.OrgWgEmp> selectOrgWgEmpList(java.lang.String wgCd, java.lang.String empId) {
        entering("pkuhit.org.dao.custom.CustomOrgWgEmpDaoImpl", "selectOrgWgEmpList", wgCd, empId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CustomOrgWgEmpDao/selectOrgWgEmpList.sql");
            __query.addParameter("wgCd", java.lang.String.class, wgCd);
            __query.addParameter("empId", java.lang.String.class, empId);
            __query.setCallerClassName("pkuhit.org.dao.custom.CustomOrgWgEmpDaoImpl");
            __query.setCallerMethodName("selectOrgWgEmpList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.OrgWgEmp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.org.dao.auto.entity.OrgWgEmp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.org.dao.auto.entity.OrgWgEmp>(pkuhit.org.dao.auto.entity._OrgWgEmp.getSingletonInternal()));
            java.util.List<pkuhit.org.dao.auto.entity.OrgWgEmp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CustomOrgWgEmpDaoImpl", "selectOrgWgEmpList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CustomOrgWgEmpDaoImpl", "selectOrgWgEmpList", __e);
            throw __e;
        }
    }

}
