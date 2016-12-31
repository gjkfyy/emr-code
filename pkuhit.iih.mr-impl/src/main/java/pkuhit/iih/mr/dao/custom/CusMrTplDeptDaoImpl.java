package pkuhit.iih.mr.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.070+0800")
public class CusMrTplDeptDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.dao.custom.CusMrTplDeptDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrTplDeptDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDept> getTplDeptByTpl(java.lang.String mrTplCode) {
        entering("pkuhit.iih.mr.dao.custom.CusMrTplDeptDaoImpl", "getTplDeptByTpl", mrTplCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/dao/custom/CusMrTplDeptDao/getTplDeptByTpl.sql");
            __query.addParameter("mrTplCode", java.lang.String.class, mrTplCode);
            __query.setCallerClassName("pkuhit.iih.mr.dao.custom.CusMrTplDeptDaoImpl");
            __query.setCallerMethodName("getTplDeptByTpl");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDept>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDept>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTplDept>(pkuhit.iih.mr.dao.auto.entity._MrTplDept.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDept> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.dao.custom.CusMrTplDeptDaoImpl", "getTplDeptByTpl", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.dao.custom.CusMrTplDeptDaoImpl", "getTplDeptByTpl", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDept> getTplDeptByDept(java.lang.String tplUseTypeCode, java.util.List<java.lang.String> deptCode) {
        entering("pkuhit.iih.mr.dao.custom.CusMrTplDeptDaoImpl", "getTplDeptByDept", tplUseTypeCode, deptCode);
        try {
            if (deptCode == null) {
                throw new org.seasar.doma.DomaNullPointerException("deptCode");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/dao/custom/CusMrTplDeptDao/getTplDeptByDept.sql");
            __query.addParameter("tplUseTypeCode", java.lang.String.class, tplUseTypeCode);
            __query.addParameter("deptCode", java.util.List.class, deptCode);
            __query.setCallerClassName("pkuhit.iih.mr.dao.custom.CusMrTplDeptDaoImpl");
            __query.setCallerMethodName("getTplDeptByDept");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDept>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDept>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTplDept>(pkuhit.iih.mr.dao.auto.entity._MrTplDept.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTplDept> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.dao.custom.CusMrTplDeptDaoImpl", "getTplDeptByDept", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.dao.custom.CusMrTplDeptDaoImpl", "getTplDeptByDept", __e);
            throw __e;
        }
    }

}
