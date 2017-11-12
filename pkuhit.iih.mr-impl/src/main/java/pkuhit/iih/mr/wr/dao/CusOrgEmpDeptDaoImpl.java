package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-11-12T19:23:53.887+0800")
public class CusOrgEmpDeptDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusOrgEmpDeptDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusOrgEmpDeptDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectByDeptCdAndEmpId(java.lang.String deptCd, java.lang.String empId) {
        entering("pkuhit.iih.mr.wr.dao.CusOrgEmpDeptDaoImpl", "selectByDeptCdAndEmpId", deptCd, empId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusOrgEmpDeptDao/selectByDeptCdAndEmpId.sql");
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("empId", java.lang.String.class, empId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusOrgEmpDeptDaoImpl");
            __query.setCallerMethodName("selectByDeptCdAndEmpId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusOrgEmpDeptDaoImpl", "selectByDeptCdAndEmpId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusOrgEmpDeptDaoImpl", "selectByDeptCdAndEmpId", __e);
            throw __e;
        }
    }

}
