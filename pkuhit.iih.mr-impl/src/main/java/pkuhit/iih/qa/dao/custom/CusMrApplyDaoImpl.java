package pkuhit.iih.qa.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.241+0800")
public class CusMrApplyDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.custom.CusMrApplyDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrApplyDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectApplyByEnPk(java.lang.String applyTypeCd, java.lang.String userId, java.lang.String enPk, java.lang.String dtcCd, java.lang.String curDeptCd, java.lang.String applyStatus, java.lang.String timeStart, java.lang.String timeEnd, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyByEnPk", applyTypeCd, userId, enPk, dtcCd, curDeptCd, applyStatus, timeStart, timeEnd, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusMrApplyDao/selectApplyByEnPk.sql");
            __query.setOptions(options);
            __query.addParameter("applyTypeCd", java.lang.String.class, applyTypeCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("dtcCd", java.lang.String.class, dtcCd);
            __query.addParameter("curDeptCd", java.lang.String.class, curDeptCd);
            __query.addParameter("applyStatus", java.lang.String.class, applyStatus);
            __query.addParameter("timeStart", java.lang.String.class, timeStart);
            __query.addParameter("timeEnd", java.lang.String.class, timeEnd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl");
            __query.setCallerMethodName("selectApplyByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyByEnPk", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectApplyInfoById(java.lang.String applyCd) {
        entering("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyInfoById", applyCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusMrApplyDao/selectApplyInfoById.sql");
            __query.addParameter("applyCd", java.lang.String.class, applyCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl");
            __query.setCallerMethodName("selectApplyInfoById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyInfoById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyInfoById", __e);
            throw __e;
        }
    }

    @Override
    public int isMedicalWorkDept(java.lang.String deptCd) {
        entering("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "isMedicalWorkDept", deptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusMrApplyDao/isMedicalWorkDept.sql");
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl");
            __query.setCallerMethodName("isMedicalWorkDept");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "isMedicalWorkDept", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "isMedicalWorkDept", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String selectApplyDocCdByEnpk(java.lang.String enPk) {
        entering("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyDocCdByEnpk", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusMrApplyDao/selectApplyDocCdByEnpk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl");
            __query.setCallerMethodName("selectApplyDocCdByEnpk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyDocCdByEnpk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusMrApplyDaoImpl", "selectApplyDocCdByEnpk", __e);
            throw __e;
        }
    }

}
