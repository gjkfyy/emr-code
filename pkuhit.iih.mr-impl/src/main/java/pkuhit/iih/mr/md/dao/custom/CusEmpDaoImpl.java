package pkuhit.iih.mr.md.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.764+0800")
public class CusEmpDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.md.dao.custom.CusEmpDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusEmpDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectByDeptCdAndJobTitleCd(java.lang.String deptCd) {
        entering("pkuhit.iih.mr.md.dao.custom.CusEmpDaoImpl", "selectByDeptCdAndJobTitleCd", deptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusEmpDao/selectByDeptCdAndJobTitleCd.sql");
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusEmpDaoImpl");
            __query.setCallerMethodName("selectByDeptCdAndJobTitleCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusEmpDaoImpl", "selectByDeptCdAndJobTitleCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusEmpDaoImpl", "selectByDeptCdAndJobTitleCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectByDeptCdAndSignLvlCd(java.lang.String deptCd, java.lang.String signLvlCd) {
        entering("pkuhit.iih.mr.md.dao.custom.CusEmpDaoImpl", "selectByDeptCdAndSignLvlCd", deptCd, signLvlCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusEmpDao/selectByDeptCdAndSignLvlCd.sql");
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("signLvlCd", java.lang.String.class, signLvlCd);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusEmpDaoImpl");
            __query.setCallerMethodName("selectByDeptCdAndSignLvlCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusEmpDaoImpl", "selectByDeptCdAndSignLvlCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusEmpDaoImpl", "selectByDeptCdAndSignLvlCd", __e);
            throw __e;
        }
    }

}
