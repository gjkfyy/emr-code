package pkuhit.iih.qa.dao.qacustom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.855+0800")
public class CusQaMrAmrDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaMrAmrDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, staIll, rcvTime, enStaCd, suF, qaFlag, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrByCondition", __e);
            throw __e;
        }
    }

    @Override
    public int selectQaCount(java.lang.String enPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaCount", enPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectQaCount.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectQaCount");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaCount", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaCount", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectQa(java.lang.String enPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQa", enPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectQa.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectQa");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQa", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQa", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectAmrFaultStatistical(java.lang.String enPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrFaultStatistical", enPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrFaultStatistical.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrFaultStatistical");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrFaultStatistical", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrFaultStatistical", __e);
            throw __e;
        }
    }

    @Override
    public int selectQaNoticeNum(java.lang.String enPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaNoticeNum", enPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectQaNoticeNum.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectQaNoticeNum");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaNoticeNum", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaNoticeNum", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectAmrFaultNoticeNum(java.lang.String enPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrFaultNoticeNum", enPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrFaultNoticeNum.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrFaultNoticeNum");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrFaultNoticeNum", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrFaultNoticeNum", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrByEnPkAndQaType(java.lang.String enPk) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrByEnPkAndQaType", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrByEnPkAndQaType.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrByEnPkAndQaType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrByEnPkAndQaType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrByEnPkAndQaType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectTerminalAmrByCondition(java.lang.String qaTypeCode, java.lang.String amrStatus, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String beginTime, java.lang.String endTime, java.lang.String enStaCd, java.lang.String qaAutoScrMin, java.lang.String qaAutoScrMax, java.lang.String terminalQaStaCd, java.lang.String deptQaStaCd, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrByCondition", qaTypeCode, amrStatus, curDeptNm, amrNo, patientName, beginTime, endTime, enStaCd, qaAutoScrMin, qaAutoScrMax, terminalQaStaCd, deptQaStaCd, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectTerminalAmrByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatus", java.lang.String.class, amrStatus);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("qaAutoScrMin", java.lang.String.class, qaAutoScrMin);
            __query.addParameter("qaAutoScrMax", java.lang.String.class, qaAutoScrMax);
            __query.addParameter("terminalQaStaCd", java.lang.String.class, terminalQaStaCd);
            __query.addParameter("deptQaStaCd", java.lang.String.class, deptQaStaCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectTerminalAmrByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectTerminalAmrZyAdtByCondition(java.lang.String qaTypeCode, java.lang.String amrStatus, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String beginTime, java.lang.String endTime, java.lang.String enStaCd, java.lang.String specialMr, java.lang.String qaAutoScrMin, java.lang.String qaAutoScrMax, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrZyAdtByCondition", qaTypeCode, amrStatus, curDeptNm, amrNo, patientName, beginTime, endTime, enStaCd, specialMr, qaAutoScrMin, qaAutoScrMax, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectTerminalAmrZyAdtByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatus", java.lang.String.class, amrStatus);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("specialMr", java.lang.String.class, specialMr);
            __query.addParameter("qaAutoScrMin", java.lang.String.class, qaAutoScrMin);
            __query.addParameter("qaAutoScrMax", java.lang.String.class, qaAutoScrMax);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectTerminalAmrZyAdtByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrZyAdtByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrZyAdtByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectTerminalAmrOrderByCondition(java.lang.String qaTypeCode, java.lang.String amrStatus, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String beginTime, java.lang.String endTime, java.lang.String enStaCd, java.lang.String specialMr, java.lang.String qaAutoScrMin, java.lang.String qaAutoScrMax, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrOrderByCondition", qaTypeCode, amrStatus, curDeptNm, amrNo, patientName, beginTime, endTime, enStaCd, specialMr, qaAutoScrMin, qaAutoScrMax, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectTerminalAmrOrderByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatus", java.lang.String.class, amrStatus);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("specialMr", java.lang.String.class, specialMr);
            __query.addParameter("qaAutoScrMin", java.lang.String.class, qaAutoScrMin);
            __query.addParameter("qaAutoScrMax", java.lang.String.class, qaAutoScrMax);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectTerminalAmrOrderByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrOrderByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrOrderByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectTerminalAmrJyByCondition(java.lang.String qaTypeCode, java.lang.String amrStatus, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String beginTime, java.lang.String endTime, java.lang.String enStaCd, java.lang.String qaAutoScrMin, java.lang.String qaAutoScrMax, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrJyByCondition", qaTypeCode, amrStatus, curDeptNm, amrNo, patientName, beginTime, endTime, enStaCd, qaAutoScrMin, qaAutoScrMax, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectTerminalAmrJyByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatus", java.lang.String.class, amrStatus);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("qaAutoScrMin", java.lang.String.class, qaAutoScrMin);
            __query.addParameter("qaAutoScrMax", java.lang.String.class, qaAutoScrMax);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectTerminalAmrJyByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrJyByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrJyByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectTerminalAmrZyByCondition(java.lang.String qaTypeCode, java.lang.String amrStatus, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String beginTime, java.lang.String endTime, java.lang.String enStaCd, java.lang.String qaAutoScrMin, java.lang.String qaAutoScrMax, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrZyByCondition", qaTypeCode, amrStatus, curDeptNm, amrNo, patientName, beginTime, endTime, enStaCd, qaAutoScrMin, qaAutoScrMax, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectTerminalAmrZyByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatus", java.lang.String.class, amrStatus);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("qaAutoScrMin", java.lang.String.class, qaAutoScrMin);
            __query.addParameter("qaAutoScrMax", java.lang.String.class, qaAutoScrMax);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectTerminalAmrZyByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrZyByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrZyByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectTerminalAmrOpByCondition(java.lang.String qaTypeCode, java.lang.String amrStatus, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String beginTime, java.lang.String endTime, java.lang.String enStaCd, java.lang.String qaAutoScrMin, java.lang.String qaAutoScrMax, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrOpByCondition", qaTypeCode, amrStatus, curDeptNm, amrNo, patientName, beginTime, endTime, enStaCd, qaAutoScrMin, qaAutoScrMax, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectTerminalAmrOpByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatus", java.lang.String.class, amrStatus);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("qaAutoScrMin", java.lang.String.class, qaAutoScrMin);
            __query.addParameter("qaAutoScrMax", java.lang.String.class, qaAutoScrMax);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectTerminalAmrOpByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrOpByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrOpByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectTerminalAmrSqtlByCondition(java.lang.String qaTypeCode, java.lang.String amrStatus, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String beginTime, java.lang.String endTime, java.lang.String enStaCd, java.lang.String qaAutoScrMin, java.lang.String qaAutoScrMax, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrSqtlByCondition", qaTypeCode, amrStatus, curDeptNm, amrNo, patientName, beginTime, endTime, enStaCd, qaAutoScrMin, qaAutoScrMax, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectTerminalAmrSqtlByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatus", java.lang.String.class, amrStatus);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("qaAutoScrMin", java.lang.String.class, qaAutoScrMin);
            __query.addParameter("qaAutoScrMax", java.lang.String.class, qaAutoScrMax);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectTerminalAmrSqtlByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrSqtlByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrSqtlByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectTerminalAmrYczlByCondition(java.lang.String qaTypeCode, java.lang.String amrStatus, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String specialMr, java.lang.String beginTime, java.lang.String endTime, java.lang.String enStaCd, java.lang.String qaAutoScrMin, java.lang.String qaAutoScrMax, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrYczlByCondition", qaTypeCode, amrStatus, curDeptNm, amrNo, patientName, specialMr, beginTime, endTime, enStaCd, qaAutoScrMin, qaAutoScrMax, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectTerminalAmrYczlByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatus", java.lang.String.class, amrStatus);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("specialMr", java.lang.String.class, specialMr);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("qaAutoScrMin", java.lang.String.class, qaAutoScrMin);
            __query.addParameter("qaAutoScrMax", java.lang.String.class, qaAutoScrMax);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectTerminalAmrYczlByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrYczlByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectTerminalAmrYczlByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> selectQaFaults(java.lang.String pk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaFaults", pk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectQaFaults.sql");
            __query.addParameter("pk", java.lang.String.class, pk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectQaFaults");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaFlt>(pkuhit.iih.qa.dao.auto.entity._QaFlt.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaFaults", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaFaults", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrAndFaultByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String beginTime, java.lang.String endTime, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, staIll, rcvTime, enStaCd, suF, qaFlag, beginTime, endTime, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrAndFaultByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrAndFaultByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrAndFaultZyAdtByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String beginTime, java.lang.String endTime, java.lang.String specialMr, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultZyAdtByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, staIll, rcvTime, enStaCd, suF, qaFlag, beginTime, endTime, specialMr, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrAndFaultZyAdtByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("specialMr", java.lang.String.class, specialMr);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrAndFaultZyAdtByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultZyAdtByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultZyAdtByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrAndFaultOrderByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String beginTime, java.lang.String endTime, java.lang.String specialMr, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultOrderByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, staIll, rcvTime, enStaCd, suF, qaFlag, beginTime, endTime, specialMr, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrAndFaultOrderByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("specialMr", java.lang.String.class, specialMr);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrAndFaultOrderByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultOrderByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultOrderByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrAndFaultJyByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String beginTime, java.lang.String endTime, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultJyByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, staIll, rcvTime, enStaCd, suF, qaFlag, beginTime, endTime, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrAndFaultJyByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrAndFaultJyByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultJyByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultJyByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrAndFaultZyByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String beginTime, java.lang.String endTime, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultZyByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, staIll, rcvTime, enStaCd, suF, qaFlag, beginTime, endTime, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrAndFaultZyByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrAndFaultZyByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultZyByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultZyByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrAndFaultOpByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String beginTime, java.lang.String endTime, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultOpByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, staIll, rcvTime, enStaCd, suF, qaFlag, beginTime, endTime, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrAndFaultOpByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrAndFaultOpByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultOpByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultOpByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrAndFaultSqtlByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String beginTime, java.lang.String endTime, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultSqtlByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, staIll, rcvTime, enStaCd, suF, qaFlag, beginTime, endTime, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrAndFaultSqtlByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrAndFaultSqtlByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultSqtlByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultSqtlByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrAndFaultYczlByCondition(java.lang.String qaTypeCode, java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String specialMr, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String beginTime, java.lang.String endTime, java.lang.String isNurseRole, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultYczlByCondition", qaTypeCode, statusStr, curDeptNm, amrNo, patientName, specialMr, staIll, rcvTime, enStaCd, suF, qaFlag, beginTime, endTime, isNurseRole, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectAmrAndFaultYczlByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("specialMr", java.lang.String.class, specialMr);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("beginTime", java.lang.String.class, beginTime);
            __query.addParameter("endTime", java.lang.String.class, endTime);
            __query.addParameter("isNurseRole", java.lang.String.class, isNurseRole);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectAmrAndFaultYczlByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultYczlByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectAmrAndFaultYczlByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaProcessAuto(java.lang.String statusStr, java.lang.String curDeptNm, java.lang.String amrNo, java.lang.String patientName, java.lang.String currentManageDoctorName, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaProcessAuto", statusStr, curDeptNm, amrNo, patientName, currentManageDoctorName, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectQaProcessAuto.sql");
            __query.setOptions(options);
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("currentManageDoctorName", java.lang.String.class, currentManageDoctorName);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectQaProcessAuto");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaProcessAuto", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaProcessAuto", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaAutoByCondition(java.lang.String curDeptNm, java.lang.String currentManageDoctorName, java.lang.String enStaCd, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaAutoByCondition", curDeptNm, currentManageDoctorName, enStaCd, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaMrAmrDao/selectQaAutoByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("currentManageDoctorName", java.lang.String.class, currentManageDoctorName);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl");
            __query.setCallerMethodName("selectQaAutoByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaAutoByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDaoImpl", "selectQaAutoByCondition", __e);
            throw __e;
        }
    }

}
