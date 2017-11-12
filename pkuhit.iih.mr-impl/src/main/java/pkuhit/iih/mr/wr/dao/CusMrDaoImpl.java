package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-11-12T19:23:53.747+0800")
public class CusMrDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusMrDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectByEnPk(java.lang.String enPk, java.lang.String mrTypeCustomCode, java.lang.String mrTypeCode, java.lang.String deptCd, java.lang.Integer nsF, java.lang.String mrType) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPk", enPk, mrTypeCustomCode, mrTypeCode, deptCd, nsF, mrType);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectByEnPk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrTypeCustomCode", java.lang.String.class, mrTypeCustomCode);
            __query.addParameter("mrTypeCode", java.lang.String.class, mrTypeCode);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("nsF", java.lang.Integer.class, nsF);
            __query.addParameter("mrType", java.lang.String.class, mrType);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPk", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectByEnPkForContinuePrint(java.lang.String enPk, java.lang.String mrTypeCustomCode, java.lang.String deptCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForContinuePrint", enPk, mrTypeCustomCode, deptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectByEnPkForContinuePrint.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrTypeCustomCode", java.lang.String.class, mrTypeCustomCode);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectByEnPkForContinuePrint");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForContinuePrint", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForContinuePrint", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectByEnPks(java.util.List<java.lang.String> enPkList, java.lang.String mrTypeCustomCode, java.lang.String mrTypeCode) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPks", enPkList, mrTypeCustomCode, mrTypeCode);
        try {
            if (enPkList == null) {
                throw new org.seasar.doma.DomaNullPointerException("enPkList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectByEnPks.sql");
            __query.addParameter("enPkList", java.util.List.class, enPkList);
            __query.addParameter("mrTypeCustomCode", java.lang.String.class, mrTypeCustomCode);
            __query.addParameter("mrTypeCode", java.lang.String.class, mrTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectByEnPks");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPks", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPks", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectByEnPksForMerge(java.util.List<java.lang.String> enPkList, java.util.List<java.lang.String> mrTypeCustomCodes) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPksForMerge", enPkList, mrTypeCustomCodes);
        try {
            if (enPkList == null) {
                throw new org.seasar.doma.DomaNullPointerException("enPkList");
            }
            if (mrTypeCustomCodes == null) {
                throw new org.seasar.doma.DomaNullPointerException("mrTypeCustomCodes");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectByEnPksForMerge.sql");
            __query.addParameter("enPkList", java.util.List.class, enPkList);
            __query.addParameter("mrTypeCustomCodes", java.util.List.class, mrTypeCustomCodes);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectByEnPksForMerge");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPksForMerge", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPksForMerge", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectByEnPkForMerge(java.lang.String enPk, java.util.List<java.lang.String> mrTypeCustomCodes) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForMerge", enPk, mrTypeCustomCodes);
        try {
            if (mrTypeCustomCodes == null) {
                throw new org.seasar.doma.DomaNullPointerException("mrTypeCustomCodes");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectByEnPkForMerge.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrTypeCustomCodes", java.util.List.class, mrTypeCustomCodes);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectByEnPkForMerge");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForMerge", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForMerge", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectByEnPksForEmergencyMrNumber(java.util.List<java.lang.String> enPkList) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPksForEmergencyMrNumber", enPkList);
        try {
            if (enPkList == null) {
                throw new org.seasar.doma.DomaNullPointerException("enPkList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectByEnPksForEmergencyMrNumber.sql");
            __query.addParameter("enPkList", java.util.List.class, enPkList);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectByEnPksForEmergencyMrNumber");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPksForEmergencyMrNumber", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPksForEmergencyMrNumber", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectByEnPkForEmergencyMrNumber(java.lang.String enPk, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForEmergencyMrNumber", enPk, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectByEnPkForEmergencyMrNumber.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectByEnPkForEmergencyMrNumber");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForEmergencyMrNumber", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectByEnPkForEmergencyMrNumber", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrByEnPk(java.lang.String enPk, java.lang.String mrTypeCustomCode, java.lang.String mrTypeCode, java.lang.String mrType) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrByEnPk", enPk, mrTypeCustomCode, mrTypeCode, mrType);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectMrByEnPk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrTypeCustomCode", java.lang.String.class, mrTypeCustomCode);
            __query.addParameter("mrTypeCode", java.lang.String.class, mrTypeCode);
            __query.addParameter("mrType", java.lang.String.class, mrType);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectMrByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrByEnPk", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrByAmrGroup(java.util.List<java.lang.String> enPks, java.lang.String mrTypeCustomCode, java.lang.String mrTypeCode) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrByAmrGroup", enPks, mrTypeCustomCode, mrTypeCode);
        try {
            if (enPks == null) {
                throw new org.seasar.doma.DomaNullPointerException("enPks");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectMrByAmrGroup.sql");
            __query.addParameter("enPks", java.util.List.class, enPks);
            __query.addParameter("mrTypeCustomCode", java.lang.String.class, mrTypeCustomCode);
            __query.addParameter("mrTypeCode", java.lang.String.class, mrTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectMrByAmrGroup");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrByAmrGroup", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrByAmrGroup", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectSignedPatients(java.lang.String userId, java.lang.String deptCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectSignedPatients", userId, deptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectSignedPatients.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectSignedPatients");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectSignedPatients", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectSignedPatients", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectWaitDeptSignPatients(java.lang.String userId, java.lang.String deptCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitDeptSignPatients", userId, deptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectWaitDeptSignPatients.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectWaitDeptSignPatients");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitDeptSignPatients", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitDeptSignPatients", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectSignedMrs(java.lang.String userId, java.lang.String deptCd, java.lang.String patientId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectSignedMrs", userId, deptCd, patientId, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectSignedMrs.sql");
            __query.setOptions(options);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectSignedMrs");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectSignedMrs", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectSignedMrs", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectWaitSignedMrs(java.lang.String userId, java.lang.String deptCd, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitSignedMrs", userId, deptCd, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectWaitSignedMrs.sql");
            __query.setOptions(options);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectWaitSignedMrs");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitSignedMrs", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitSignedMrs", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectWaitDeptSignedMrs(java.lang.String userId, java.lang.String deptCd, java.lang.String patientId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitDeptSignedMrs", userId, deptCd, patientId, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectWaitDeptSignedMrs.sql");
            __query.setOptions(options);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectWaitDeptSignedMrs");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitDeptSignedMrs", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectWaitDeptSignedMrs", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaFltForMr(java.lang.String mrPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectQaFltForMr", mrPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectQaFltForMr.sql");
            __query.addParameter("mrPk", java.lang.String.class, mrPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectQaFltForMr");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectQaFltForMr", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectQaFltForMr", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectMrsByEnPk(java.lang.String enPk, java.util.List<java.lang.String> mrTypeCodes, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPk", enPk, mrTypeCodes, options);
        try {
            if (mrTypeCodes == null) {
                throw new org.seasar.doma.DomaNullPointerException("mrTypeCodes");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectMrsByEnPk.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrTypeCodes", java.util.List.class, mrTypeCodes);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectMrsByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPk", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectMrsByEnPkAndDel(java.lang.String enPk) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndDel", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectMrsByEnPkAndDel.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectMrsByEnPkAndDel");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndDel", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndDel", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectMrsByEnPkAndMrTypeCode(java.lang.String enPk, java.lang.String templateId) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndMrTypeCode", enPk, templateId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectMrsByEnPkAndMrTypeCode.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("templateId", java.lang.String.class, templateId);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectMrsByEnPkAndMrTypeCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndMrTypeCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndMrTypeCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectUnXmlConvertMrs(java.lang.String enPk) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectUnXmlConvertMrs", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectUnXmlConvertMrs.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectUnXmlConvertMrs");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectUnXmlConvertMrs", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectUnXmlConvertMrs", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String selectMrSplFmByEnPk(java.lang.String enPk) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrSplFmByEnPk", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectMrSplFmByEnPk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectMrSplFmByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrSplFmByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrSplFmByEnPk", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrsByEnPkAndMrType(java.lang.String enPk, java.lang.String mrTpCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndMrType", enPk, mrTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectMrsByEnPkAndMrType.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("mrTpCd", java.lang.String.class, mrTpCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectMrsByEnPkAndMrType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndMrType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByEnPkAndMrType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectMrsByConds(java.lang.String enPk, java.lang.String ctrTime, java.lang.String mrMypeCode) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByConds", enPk, ctrTime, mrMypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectMrsByConds.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("ctrTime", java.lang.String.class, ctrTime);
            __query.addParameter("mrMypeCode", java.lang.String.class, mrMypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectMrsByConds");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByConds", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectMrsByConds", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectBatchPrintMrs(java.lang.String enPk, java.lang.String tpCcatCd, java.lang.String dctNsF, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectBatchPrintMrs", enPk, tpCcatCd, dctNsF, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrDao/selectBatchPrintMrs.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("tpCcatCd", java.lang.String.class, tpCcatCd);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrDaoImpl");
            __query.setCallerMethodName("selectBatchPrintMrs");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectBatchPrintMrs", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrDaoImpl", "selectBatchPrintMrs", __e);
            throw __e;
        }
    }

}
