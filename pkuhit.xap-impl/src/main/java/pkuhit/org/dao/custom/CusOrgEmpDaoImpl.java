package pkuhit.org.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.546+0800")
public class CusOrgEmpDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.org.dao.custom.CusOrgEmpDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusOrgEmpDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getEmpByDept(java.lang.String deptCode) {
        entering("pkuhit.org.dao.custom.CusOrgEmpDaoImpl", "getEmpByDept", deptCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/org/dao/custom/CusOrgEmpDao/getEmpByDept.sql");
            __query.addParameter("deptCode", java.lang.String.class, deptCode);
            __query.setCallerClassName("pkuhit.org.dao.custom.CusOrgEmpDaoImpl");
            __query.setCallerMethodName("getEmpByDept");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.org.dao.custom.CusOrgEmpDaoImpl", "getEmpByDept", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.org.dao.custom.CusOrgEmpDaoImpl", "getEmpByDept", __e);
            throw __e;
        }
    }

}
