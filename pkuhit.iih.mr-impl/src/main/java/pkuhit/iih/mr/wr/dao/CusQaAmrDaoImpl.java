package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:39.126+0800")
public class CusQaAmrDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusQaAmrDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaAmrDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectAmrByStatusInProcess(java.lang.String statusStr) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByStatusInProcess", statusStr);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectAmrByStatusInProcess.sql");
            __query.addParameter("statusStr", java.lang.String.class, statusStr);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectAmrByStatusInProcess");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByStatusInProcess", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByStatusInProcess", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrByStatusInQa(java.lang.String qaTypeCode, java.util.List<java.lang.String> amrStatusList, java.lang.String curDeptNm, java.lang.String curMainDiNm, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String excuteUserId, java.lang.String executeDeptCode, java.lang.String workScreen, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByStatusInQa", qaTypeCode, amrStatusList, curDeptNm, curMainDiNm, staIll, rcvTime, enStaCd, suF, qaFlag, excuteUserId, executeDeptCode, workScreen, options);
        try {
            if (amrStatusList == null) {
                throw new org.seasar.doma.DomaNullPointerException("amrStatusList");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectAmrByStatusInQa.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatusList", java.util.List.class, amrStatusList);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("curMainDiNm", java.lang.String.class, curMainDiNm);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("excuteUserId", java.lang.String.class, excuteUserId);
            __query.addParameter("executeDeptCode", java.lang.String.class, executeDeptCode);
            __query.addParameter("workScreen", java.lang.String.class, workScreen);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectAmrByStatusInQa");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByStatusInQa", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByStatusInQa", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrByCondition(java.lang.String qaTypeCode, java.util.List<java.lang.String> amrStatusList, java.lang.String curDeptNm, java.lang.String curMainDiNm, java.lang.String staIll, java.lang.String rcvTime, java.lang.String enStaCd, java.lang.String suF, java.lang.String qaFlag, java.lang.String excuteUserId, java.lang.String executeDeptCode, java.lang.String workScreen, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByCondition", qaTypeCode, amrStatusList, curDeptNm, curMainDiNm, staIll, rcvTime, enStaCd, suF, qaFlag, excuteUserId, executeDeptCode, workScreen, options);
        try {
            if (amrStatusList == null) {
                throw new org.seasar.doma.DomaNullPointerException("amrStatusList");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectAmrByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("amrStatusList", java.util.List.class, amrStatusList);
            __query.addParameter("curDeptNm", java.lang.String.class, curDeptNm);
            __query.addParameter("curMainDiNm", java.lang.String.class, curMainDiNm);
            __query.addParameter("staIll", java.lang.String.class, staIll);
            __query.addParameter("rcvTime", java.lang.String.class, rcvTime);
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("suF", java.lang.String.class, suF);
            __query.addParameter("qaFlag", java.lang.String.class, qaFlag);
            __query.addParameter("excuteUserId", java.lang.String.class, excuteUserId);
            __query.addParameter("executeDeptCode", java.lang.String.class, executeDeptCode);
            __query.addParameter("workScreen", java.lang.String.class, workScreen);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
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
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectAmrFaultStatistical(java.lang.String enPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrFaultStatistical", enPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectAmrFaultStatistical.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
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
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrFaultStatistical", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectAmrFaultStatistical", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectEncounterByCondition(java.lang.String keyword, java.lang.String deptCd, java.lang.String userId, java.lang.String enTpCd, java.lang.String groupType, java.lang.String patientName, java.lang.String amrNo, java.lang.String currentBedCode, java.lang.String startDate, java.lang.String endDate, java.lang.String curMgDctId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterByCondition", keyword, deptCd, userId, enTpCd, groupType, patientName, amrNo, currentBedCode, startDate, endDate, curMgDctId, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectEncounterByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("groupType", java.lang.String.class, groupType);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("currentBedCode", java.lang.String.class, currentBedCode);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.addParameter("curMgDctId", java.lang.String.class, curMgDctId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectEncounterByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectReadEncounterByCondition(java.lang.String keyword, java.lang.String deptCd, java.lang.String userId, java.lang.String enTpCd, java.lang.String groupType, java.lang.String patientName, java.lang.String amrNo, java.lang.String patientId, java.lang.String currentBedCode, java.lang.String startDate, java.lang.String endDate, java.lang.String curMgDctId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectReadEncounterByCondition", keyword, deptCd, userId, enTpCd, groupType, patientName, amrNo, patientId, currentBedCode, startDate, endDate, curMgDctId, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectReadEncounterByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("groupType", java.lang.String.class, groupType);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("currentBedCode", java.lang.String.class, currentBedCode);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.addParameter("curMgDctId", java.lang.String.class, curMgDctId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectReadEncounterByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectReadEncounterByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectReadEncounterByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectOutReadEncounterByCondition(java.lang.String keyword, java.lang.String deptCd, java.lang.String userId, java.lang.String enTpCd, java.lang.String groupType, java.lang.String patientName, java.util.List<java.lang.String> enpkList, java.lang.String patientId, java.lang.String currentBedCode, java.lang.String startDate, java.lang.String endDate, java.lang.String curMgDctId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectOutReadEncounterByCondition", keyword, deptCd, userId, enTpCd, groupType, patientName, enpkList, patientId, currentBedCode, startDate, endDate, curMgDctId, options);
        try {
            if (enpkList == null) {
                throw new org.seasar.doma.DomaNullPointerException("enpkList");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectOutReadEncounterByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("groupType", java.lang.String.class, groupType);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("enpkList", java.util.List.class, enpkList);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("currentBedCode", java.lang.String.class, currentBedCode);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.addParameter("curMgDctId", java.lang.String.class, curMgDctId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectOutReadEncounterByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectOutReadEncounterByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectOutReadEncounterByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectEncounterToAssistant(java.lang.String patientId, java.lang.String cardCd) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterToAssistant", patientId, cardCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectEncounterToAssistant.sql");
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("cardCd", java.lang.String.class, cardCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectEncounterToAssistant");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterToAssistant", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterToAssistant", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectEncounterForOutPatient(java.lang.String deptCd, java.lang.String userId, java.lang.String groupType, java.lang.String patientId, java.lang.String patientName, java.lang.String startDate, java.lang.String endDate, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForOutPatient", deptCd, userId, groupType, patientId, patientName, startDate, endDate, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectEncounterForOutPatient.sql");
            __query.setOptions(options);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("groupType", java.lang.String.class, groupType);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectEncounterForOutPatient");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForOutPatient", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForOutPatient", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectEncounterForNursePatient(java.lang.String groupType, java.lang.String wardCd, java.lang.String userId, java.lang.String patientName, java.lang.String amrNo, java.lang.String currentBedCode, java.lang.String curMgNurId, java.lang.String startDate, java.lang.String endDate, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForNursePatient", groupType, wardCd, userId, patientName, amrNo, currentBedCode, curMgNurId, startDate, endDate, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectEncounterForNursePatient.sql");
            __query.setOptions(options);
            __query.addParameter("groupType", java.lang.String.class, groupType);
            __query.addParameter("wardCd", java.lang.String.class, wardCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("currentBedCode", java.lang.String.class, currentBedCode);
            __query.addParameter("curMgNurId", java.lang.String.class, curMgNurId);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectEncounterForNursePatient");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForNursePatient", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForNursePatient", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectEncounterForAdtPatient(java.lang.String deptCd, java.lang.String wardCd, java.lang.String patientName, java.lang.String amrNo, java.lang.String currentBedCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForAdtPatient", deptCd, wardCd, patientName, amrNo, currentBedCode, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectEncounterForAdtPatient.sql");
            __query.setOptions(options);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("wardCd", java.lang.String.class, wardCd);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("currentBedCode", java.lang.String.class, currentBedCode);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectEncounterForAdtPatient");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForAdtPatient", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForAdtPatient", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectEncounterById(java.lang.String enPk) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterById", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectEncounterById.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectEncounterById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterById", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectEncounterFromViewByCondition(java.lang.String keyword, java.lang.String deptCd, java.lang.String userId, java.lang.String enTpCd, java.lang.String groupType, java.lang.String patientName, java.lang.String amrNo, java.lang.String currentBedCode, java.lang.String startDate, java.lang.String endDate, java.lang.String curMgDctId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterFromViewByCondition", keyword, deptCd, userId, enTpCd, groupType, patientName, amrNo, currentBedCode, startDate, endDate, curMgDctId, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectEncounterFromViewByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("groupType", java.lang.String.class, groupType);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("currentBedCode", java.lang.String.class, currentBedCode);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.addParameter("curMgDctId", java.lang.String.class, curMgDctId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectEncounterFromViewByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterFromViewByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterFromViewByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectEncounterForNursePatientFromView(java.lang.String groupType, java.lang.String wardCd, java.lang.String userId, java.lang.String patientName, java.lang.String amrNo, java.lang.String currentBedCode, java.lang.String curMgNurId, java.lang.String startDate, java.lang.String endDate, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForNursePatientFromView", groupType, wardCd, userId, patientName, amrNo, currentBedCode, curMgNurId, startDate, endDate, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaAmrDao/selectEncounterForNursePatientFromView.sql");
            __query.setOptions(options);
            __query.addParameter("groupType", java.lang.String.class, groupType);
            __query.addParameter("wardCd", java.lang.String.class, wardCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("currentBedCode", java.lang.String.class, currentBedCode);
            __query.addParameter("curMgNurId", java.lang.String.class, curMgNurId);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl");
            __query.setCallerMethodName("selectEncounterForNursePatientFromView");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForNursePatientFromView", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaAmrDaoImpl", "selectEncounterForNursePatientFromView", __e);
            throw __e;
        }
    }

}
