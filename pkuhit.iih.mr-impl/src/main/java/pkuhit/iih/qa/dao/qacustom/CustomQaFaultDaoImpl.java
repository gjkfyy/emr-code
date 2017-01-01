package pkuhit.iih.qa.dao.qacustom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.874+0800")
public class CustomQaFaultDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.qacustom.CustomQaFaultDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomQaFaultDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaFaultByCondition(java.lang.String encounterPk, java.lang.String qaTypeCode, java.lang.String statusCode, java.lang.String submittedUserId, java.lang.String submittedDeptCode, java.lang.String reformUserId, java.lang.String reformDeptCode, java.lang.String reversionCd, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultByCondition", encounterPk, qaTypeCode, statusCode, submittedUserId, submittedDeptCode, reformUserId, reformDeptCode, reversionCd, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CustomQaFaultDao/selectQaFaultByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("encounterPk", java.lang.String.class, encounterPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("submittedUserId", java.lang.String.class, submittedUserId);
            __query.addParameter("submittedDeptCode", java.lang.String.class, submittedDeptCode);
            __query.addParameter("reformUserId", java.lang.String.class, reformUserId);
            __query.addParameter("reformDeptCode", java.lang.String.class, reformDeptCode);
            __query.addParameter("reversionCd", java.lang.String.class, reversionCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaFaultByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaFaultList(java.lang.String encounterPk, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultList", encounterPk, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CustomQaFaultDao/selectQaFaultList.sql");
            __query.setOptions(options);
            __query.addParameter("encounterPk", java.lang.String.class, encounterPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaFaultList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> selectQaFaultByRevisionCd(java.lang.String revisionCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultByRevisionCd", revisionCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CustomQaFaultDao/selectQaFaultByRevisionCd.sql");
            __query.addParameter("revisionCd", java.lang.String.class, revisionCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaFaultByRevisionCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaFlt>(pkuhit.iih.qa.dao.auto.entity._QaFlt.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultByRevisionCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CustomQaFaultDaoImpl", "selectQaFaultByRevisionCd", __e);
            throw __e;
        }
    }

}
