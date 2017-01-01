package pkuhit.iih.qa.dao.qacustom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.664+0800")
public class CusQaAutoDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.qacustom.CusQaAutoDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaAutoDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaMr(java.lang.String mrAmr, java.lang.String xapUser, java.lang.String orgEmp, java.lang.String enPk) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaMr", mrAmr, xapUser, orgEmp, enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoDao/selectQaMr.sql");
            __query.addParameter("mrAmr", java.lang.String.class, mrAmr);
            __query.addParameter("xapUser", java.lang.String.class, xapUser);
            __query.addParameter("orgEmp", java.lang.String.class, orgEmp);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl");
            __query.setCallerMethodName("selectQaMr");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaMr", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaMr", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectQaAutoCacheMrAmr(java.lang.String statusStr, java.lang.String curDeptId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoCacheMrAmr", statusStr, curDeptId, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoDao/selectQaAutoCacheMrAmr.sql");
            __query.setOptions(options);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptId", java.lang.String.class, curDeptId);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl");
            __query.setCallerMethodName("selectQaAutoCacheMrAmr");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoCacheMrAmr", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoCacheMrAmr", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaMrByCondition(java.lang.String enPk, java.util.List<java.lang.String> mrTypes, java.lang.String mrStaCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaMrByCondition", enPk, mrTypes, mrStaCd);
        try {
            if (mrTypes == null) {
                throw new org.seasar.doma.DomaNullPointerException("mrTypes");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoDao/selectQaMrByCondition.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrTypes", java.util.List.class, mrTypes);
            __query.addParameter("mrStaCd", java.lang.String.class, mrStaCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl");
            __query.setCallerMethodName("selectQaMrByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaMrByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaMrByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchQaItemsByCondition(java.lang.String eventTypeCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchQaItemsByCondition", eventTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoDao/searchQaItemsByCondition.sql");
            __query.addParameter("eventTypeCode", java.lang.String.class, eventTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl");
            __query.setCallerMethodName("searchQaItemsByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchQaItemsByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchQaItemsByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchPreFltQaItemsByCondition(java.lang.String currentTime, java.lang.String qaItmTpCd, java.lang.String fltFlag) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchPreFltQaItemsByCondition", currentTime, qaItmTpCd, fltFlag);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoDao/searchPreFltQaItemsByCondition.sql");
            __query.addParameter("currentTime", java.lang.String.class, currentTime);
            __query.addParameter("qaItmTpCd", java.lang.String.class, qaItmTpCd);
            __query.addParameter("fltFlag", java.lang.String.class, fltFlag);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl");
            __query.setCallerMethodName("searchPreFltQaItemsByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchPreFltQaItemsByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchPreFltQaItemsByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchMdMrType() {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchMdMrType");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoDao/searchMdMrType.sql");
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl");
            __query.setCallerMethodName("searchMdMrType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchMdMrType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "searchMdMrType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaAutoFltByCondition(java.lang.String currentManageDoctorId, java.lang.String deptCd, java.lang.String amrNo, java.lang.String patientName, java.lang.String mrTypes, java.lang.String enStaCd, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoFltByCondition", currentManageDoctorId, deptCd, amrNo, patientName, mrTypes, enStaCd, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoDao/selectQaAutoFltByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("currentManageDoctorId", java.lang.String.class, currentManageDoctorId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("mrTypes", java.lang.String.class, mrTypes);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl");
            __query.setCallerMethodName("selectQaAutoFltByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoFltByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoFltByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectQaAutoMrAmrByCondition() {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoMrAmrByCondition");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoDao/selectQaAutoMrAmrByCondition.sql");
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl");
            __query.setCallerMethodName("selectQaAutoMrAmrByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoMrAmrByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoDaoImpl", "selectQaAutoMrAmrByCondition", __e);
            throw __e;
        }
    }

}
