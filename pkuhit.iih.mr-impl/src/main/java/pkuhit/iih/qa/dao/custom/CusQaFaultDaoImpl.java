package pkuhit.iih.qa.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.918+0800")
public class CusQaFaultDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.custom.CusQaFaultDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaFaultDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaFltByCondition(java.lang.String encounterPk, java.lang.String qaTypeCode, java.lang.String statusCode, java.lang.String dropFlag, java.lang.String submittedUserId, java.lang.String submittedDeptCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFltByCondition", encounterPk, qaTypeCode, statusCode, dropFlag, submittedUserId, submittedDeptCode, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaFltByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("encounterPk", java.lang.String.class, encounterPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("dropFlag", java.lang.String.class, dropFlag);
            __query.addParameter("submittedUserId", java.lang.String.class, submittedUserId);
            __query.addParameter("submittedDeptCode", java.lang.String.class, submittedDeptCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaFltByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFltByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFltByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaFaultByCondition(java.lang.String encounterPk, java.lang.String qaTypeCode, java.lang.String statusCode, java.lang.String dropFlag, java.lang.String submittedUserId, java.lang.String submittedDeptCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByCondition", encounterPk, qaTypeCode, statusCode, dropFlag, submittedUserId, submittedDeptCode, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaFaultByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("encounterPk", java.lang.String.class, encounterPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("dropFlag", java.lang.String.class, dropFlag);
            __query.addParameter("submittedUserId", java.lang.String.class, submittedUserId);
            __query.addParameter("submittedDeptCode", java.lang.String.class, submittedDeptCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
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
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> selectQaFltExtendInProcess(java.lang.String enPk) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFltExtendInProcess", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaFltExtendInProcess.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaFltExtendInProcess");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaFlt>(pkuhit.iih.qa.dao.auto.entity._QaFlt.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFltExtendInProcess", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFltExtendInProcess", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.lang.String> selectNeedReformFault(java.lang.String qaPk) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectNeedReformFault", qaPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectNeedReformFault.sql");
            __query.addParameter("qaPk", java.lang.String.class, qaPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectNeedReformFault");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.lang.String>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.lang.String>>(__query, new org.seasar.doma.internal.jdbc.command.BasicResultListHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper()));
            java.util.List<java.lang.String> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectNeedReformFault", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectNeedReformFault", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.lang.String> selectUnSendFault(java.lang.String qaPk) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectUnSendFault", qaPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectUnSendFault.sql");
            __query.addParameter("qaPk", java.lang.String.class, qaPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectUnSendFault");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.lang.String>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.lang.String>>(__query, new org.seasar.doma.internal.jdbc.command.BasicResultListHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper()));
            java.util.List<java.lang.String> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectUnSendFault", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectUnSendFault", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSysAmr selectQaSysAmrBy(java.lang.String qaSysCd, java.lang.String enTpCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysAmrBy", qaSysCd, enTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaSysAmrBy.sql");
            __query.addParameter("qaSysCd", java.lang.String.class, qaSysCd);
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaSysAmrBy");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaSysAmr> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaSysAmr>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaSysAmr>(pkuhit.iih.qa.dao.auto.entity._QaSysAmr.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaSysAmr __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysAmrBy", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysAmrBy", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm> selectQaSysItemBy(java.lang.String qaSysAmrCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysItemBy", qaSysAmrCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaSysItemBy.sql");
            __query.addParameter("qaSysAmrCd", java.lang.String.class, qaSysAmrCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaSysItemBy");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaSysItm>(pkuhit.iih.qa.dao.auto.entity._QaSysItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysItemBy", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysItemBy", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysMr> selectQaSysMrBy(java.lang.String qaSysAmrCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysMrBy", qaSysAmrCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaSysMrBy.sql");
            __query.addParameter("qaSysAmrCd", java.lang.String.class, qaSysAmrCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaSysMrBy");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysMr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysMr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaSysMr>(pkuhit.iih.qa.dao.auto.entity._QaSysMr.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysMr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysMrBy", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysMrBy", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> selectMrTpByParentCd(java.lang.String parentCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectMrTpByParentCd", parentCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectMrTpByParentCd.sql");
            __query.addParameter("parentCd", java.lang.String.class, parentCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectMrTpByParentCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectMrTpByParentCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectMrTpByParentCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysSeg> selectQaSysSegsBy(java.lang.String qaSysMrCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysSegsBy", qaSysMrCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaSysSegsBy.sql");
            __query.addParameter("qaSysMrCd", java.lang.String.class, qaSysMrCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaSysSegsBy");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysSeg>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysSeg>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaSysSeg>(pkuhit.iih.qa.dao.auto.entity._QaSysSeg.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysSeg> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysSegsBy", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysSegsBy", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm> selectQaItemByMrType(java.lang.String qaSysMrCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaItemByMrType", qaSysMrCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaItemByMrType.sql");
            __query.addParameter("qaSysMrCd", java.lang.String.class, qaSysMrCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaItemByMrType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaSysItm>(pkuhit.iih.qa.dao.auto.entity._QaSysItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaItemByMrType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaItemByMrType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm> selectQaItemByMrSeg(java.lang.String qaSysSegCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaItemByMrSeg", qaSysSegCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaItemByMrSeg.sql");
            __query.addParameter("qaSysSegCd", java.lang.String.class, qaSysSegCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaItemByMrSeg");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaSysItm>(pkuhit.iih.qa.dao.auto.entity._QaSysItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaItemByMrSeg", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaItemByMrSeg", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> selectQaFaultByEnPkandQaSysItemCode(java.lang.String enPk, java.lang.String qaSysItmCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByEnPkandQaSysItemCode", enPk, qaSysItmCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaFaultByEnPkandQaSysItemCode.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaSysItmCd", java.lang.String.class, qaSysItmCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaFaultByEnPkandQaSysItemCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaFlt>(pkuhit.iih.qa.dao.auto.entity._QaFlt.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByEnPkandQaSysItemCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByEnPkandQaSysItemCode", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSysMr selectQaSysMrByMrTpCd(java.lang.String mrTpCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysMrByMrTpCd", mrTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaSysMrByMrTpCd.sql");
            __query.addParameter("mrTpCd", java.lang.String.class, mrTpCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaSysMrByMrTpCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaSysMr> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaSysMr>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaSysMr>(pkuhit.iih.qa.dao.auto.entity._QaSysMr.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaSysMr __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysMrByMrTpCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysMrByMrTpCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> selectQaSysAmrRankScoreByQaSysAmrCd(java.lang.String qaSysAmrCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysAmrRankScoreByQaSysAmrCd", qaSysAmrCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaSysAmrRankScoreByQaSysAmrCd.sql");
            __query.addParameter("qaSysAmrCd", java.lang.String.class, qaSysAmrCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectQaSysAmrRankScoreByQaSysAmrCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr>(pkuhit.iih.qa.dao.auto.entity._QaSysAmrRankScr.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysAmrRankScoreByQaSysAmrCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaSysAmrRankScoreByQaSysAmrCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> selectCheckFaultReformResult(java.lang.String enPk) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectCheckFaultReformResult", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectCheckFaultReformResult.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectCheckFaultReformResult");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaFlt>(pkuhit.iih.qa.dao.auto.entity._QaFlt.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectCheckFaultReformResult", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectCheckFaultReformResult", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> selectFaultByEnpkAndQaPk(java.lang.String enPk, java.lang.String qaPk) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectFaultByEnpkAndQaPk", enPk, qaPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectFaultByEnpkAndQaPk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("qaPk", java.lang.String.class, qaPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectFaultByEnpkAndQaPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaFlt>(pkuhit.iih.qa.dao.auto.entity._QaFlt.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectFaultByEnpkAndQaPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectFaultByEnpkAndQaPk", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> selectQaFaultByRevisionCd(java.lang.String revisionCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByRevisionCd", revisionCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectQaFaultByRevisionCd.sql");
            __query.addParameter("revisionCd", java.lang.String.class, revisionCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
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
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByRevisionCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectQaFaultByRevisionCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> selectRfmUsersByEnpk(java.lang.String enPk) {
        entering("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectRfmUsersByEnpk", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaFaultDao/selectRfmUsersByEnpk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl");
            __query.setCallerMethodName("selectRfmUsersByEnpk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaFlt>(pkuhit.iih.qa.dao.auto.entity._QaFlt.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaFlt> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectRfmUsersByEnpk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaFaultDaoImpl", "selectRfmUsersByEnpk", __e);
            throw __e;
        }
    }

}
