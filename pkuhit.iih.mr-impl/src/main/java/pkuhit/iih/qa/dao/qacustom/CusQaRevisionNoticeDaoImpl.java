package pkuhit.iih.qa.dao.qacustom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.614+0800")
public class CusQaRevisionNoticeDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaRevisionNoticeDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaRevisionNotice(java.lang.String qaTypeCode, java.lang.String userId, java.lang.String deptId, java.lang.String workScreen, int verifiedDeadline) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectQaRevisionNotice", qaTypeCode, userId, deptId, workScreen, verifiedDeadline);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaRevisionNoticeDao/selectQaRevisionNotice.sql");
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptId", java.lang.String.class, deptId);
            __query.addParameter("workScreen", java.lang.String.class, workScreen);
            __query.addParameter("verifiedDeadline", int.class, verifiedDeadline);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl");
            __query.setCallerMethodName("selectQaRevisionNotice");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectQaRevisionNotice", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectQaRevisionNotice", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectFaultStatistical(java.lang.String revisionCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectFaultStatistical", revisionCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaRevisionNoticeDao/selectFaultStatistical.sql");
            __query.addParameter("revisionCd", java.lang.String.class, revisionCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl");
            __query.setCallerMethodName("selectFaultStatistical");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectFaultStatistical", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectFaultStatistical", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaByCondition(java.lang.String qaTypeCode, java.lang.String crtTimeStart, java.lang.String crtTimeEnd, java.lang.String amrNo, java.lang.String crtUserNm, java.lang.String curDeptNm, java.lang.String rfmTimeStart, java.lang.String rfmTimeEnd, java.lang.String currentManageDoctorName, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectQaByCondition", qaTypeCode, crtTimeStart, crtTimeEnd, amrNo, crtUserNm, curDeptNm, rfmTimeStart, rfmTimeEnd, currentManageDoctorName, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaRevisionNoticeDao/selectQaByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("crtTimeStart", java.lang.String.class, crtTimeStart);
            __query.addParameter("crtTimeEnd", java.lang.String.class, crtTimeEnd);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("crtUserNm", java.lang.String.class, crtUserNm);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("rfmTimeStart", java.lang.String.class, rfmTimeStart);
            __query.addParameter("rfmTimeEnd", java.lang.String.class, rfmTimeEnd);
            __query.addParameter("currentManageDoctorName", java.lang.String.class, currentManageDoctorName);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl");
            __query.setCallerMethodName("selectQaByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectQaByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDaoImpl", "selectQaByCondition", __e);
            throw __e;
        }
    }

}
