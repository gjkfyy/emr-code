package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-11-12T19:23:53.202+0800")
public class CusMrAmrDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusMrAmrDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrAmrDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectParientAll(java.lang.String currentDeptCode, java.lang.String receiveTime, java.lang.String finishTime, java.lang.String amrNo, java.lang.String patientName, java.lang.Integer checkQa, java.lang.Integer arcF, java.lang.String mrAmrType, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectParientAll", currentDeptCode, receiveTime, finishTime, amrNo, patientName, checkQa, arcF, mrAmrType, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/selectParientAll.sql");
            __query.setOptions(options);
            __query.addParameter("currentDeptCode", java.lang.String.class, currentDeptCode);
            __query.addParameter("receiveTime", java.lang.String.class, receiveTime);
            __query.addParameter("finishTime", java.lang.String.class, finishTime);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("checkQa", java.lang.Integer.class, checkQa);
            __query.addParameter("arcF", java.lang.Integer.class, arcF);
            __query.addParameter("mrAmrType", java.lang.String.class, mrAmrType);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectParientAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectParientAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectParientAll", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectMrAmrs(java.lang.String enStaCd, java.lang.String amrStaCd, java.lang.String curGrpCd, java.lang.String enTpCd, java.lang.String paId, java.lang.String amrGroupCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectMrAmrs", enStaCd, amrStaCd, curGrpCd, enTpCd, paId, amrGroupCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/selectMrAmrs.sql");
            __query.addParameter("enStaCd", java.lang.String.class, enStaCd);
            __query.addParameter("amrStaCd", java.lang.String.class, amrStaCd);
            __query.addParameter("curGrpCd", java.lang.String.class, curGrpCd);
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.addParameter("amrGroupCd", java.lang.String.class, amrGroupCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectMrAmrs");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectMrAmrs", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectMrAmrs", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectUnXmlConvertMrAmrs(java.lang.String arcTime) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectUnXmlConvertMrAmrs", arcTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/selectUnXmlConvertMrAmrs.sql");
            __query.addParameter("arcTime", java.lang.String.class, arcTime);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectUnXmlConvertMrAmrs");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectUnXmlConvertMrAmrs", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectUnXmlConvertMrAmrs", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectUnachiveMrAmrs(java.lang.String enTpCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectUnachiveMrAmrs", enTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/selectUnachiveMrAmrs.sql");
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectUnachiveMrAmrs");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectUnachiveMrAmrs", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectUnachiveMrAmrs", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectMrAmrByPaIdAndEnCnt(java.lang.String paId, java.math.BigInteger enCnt) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectMrAmrByPaIdAndEnCnt", paId, enCnt);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/selectMrAmrByPaIdAndEnCnt.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.addParameter("enCnt", java.math.BigInteger.class, enCnt);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectMrAmrByPaIdAndEnCnt");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectMrAmrByPaIdAndEnCnt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectMrAmrByPaIdAndEnCnt", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.Integer isExistEncounter(java.lang.String enPk) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "isExistEncounter", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/isExistEncounter.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("isExistEncounter");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), false));
            java.lang.Integer __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "isExistEncounter", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "isExistEncounter", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.Integer isExistPatient(java.lang.String patient_id) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "isExistPatient", patient_id);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/isExistPatient.sql");
            __query.addParameter("patient_id", java.lang.String.class, patient_id);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("isExistPatient");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), false));
            java.lang.Integer __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "isExistPatient", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "isExistPatient", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String selectOracleDate() {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectOracleDate");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/selectOracleDate.sql");
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectOracleDate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectOracleDate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectOracleDate", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> selectParientAllForMrb(java.util.List<java.lang.String> enTypeCodeList, java.util.List<java.lang.String> userRoleDeptListToSearch, java.lang.String doctorCode, java.lang.String receiveTime, java.lang.String finishTime, java.lang.String idCardNo, java.lang.String amrNo, java.lang.String paId, java.lang.String patientName, java.lang.String mobile, java.lang.String amrStaCd, java.util.List<java.lang.String> mrTypeList, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectParientAllForMrb", enTypeCodeList, userRoleDeptListToSearch, doctorCode, receiveTime, finishTime, idCardNo, amrNo, paId, patientName, mobile, amrStaCd, mrTypeList, options);
        try {
            if (enTypeCodeList == null) {
                throw new org.seasar.doma.DomaNullPointerException("enTypeCodeList");
            }
            if (userRoleDeptListToSearch == null) {
                throw new org.seasar.doma.DomaNullPointerException("userRoleDeptListToSearch");
            }
            if (mrTypeList == null) {
                throw new org.seasar.doma.DomaNullPointerException("mrTypeList");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/selectParientAllForMrb.sql");
            __query.setOptions(options);
            __query.addParameter("enTypeCodeList", java.util.List.class, enTypeCodeList);
            __query.addParameter("userRoleDeptListToSearch", java.util.List.class, userRoleDeptListToSearch);
            __query.addParameter("doctorCode", java.lang.String.class, doctorCode);
            __query.addParameter("receiveTime", java.lang.String.class, receiveTime);
            __query.addParameter("finishTime", java.lang.String.class, finishTime);
            __query.addParameter("idCardNo", java.lang.String.class, idCardNo);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("mobile", java.lang.String.class, mobile);
            __query.addParameter("amrStaCd", java.lang.String.class, amrStaCd);
            __query.addParameter("mrTypeList", java.util.List.class, mrTypeList);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectParientAllForMrb");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrAmr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectParientAllForMrb", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectParientAllForMrb", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MrAmr selectByPaIdAndEnCntAndVisitFlag(java.lang.String paId, java.lang.Integer enCnt, java.lang.String visitFlag) {
        entering("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectByPaIdAndEnCntAndVisitFlag", paId, enCnt, visitFlag);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrAmrDao/selectByPaIdAndEnCntAndVisitFlag.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.addParameter("enCnt", java.lang.Integer.class, enCnt);
            __query.addParameter("visitFlag", java.lang.String.class, visitFlag);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectByPaIdAndEnCntAndVisitFlag");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.dao.auto.entity.MrAmr> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.dao.auto.entity.MrAmr>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.mr.dao.auto.entity.MrAmr>(pkuhit.iih.mr.dao.auto.entity._MrAmr.getSingletonInternal()));
            pkuhit.iih.mr.dao.auto.entity.MrAmr __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectByPaIdAndEnCntAndVisitFlag", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrAmrDaoImpl", "selectByPaIdAndEnCntAndVisitFlag", __e);
            throw __e;
        }
    }

}
