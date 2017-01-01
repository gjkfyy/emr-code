package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.735+0800")
public class CutomXapTaskDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CutomXapTaskDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CutomXapTaskDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapTask> selectXapTaskList(java.util.List<java.lang.String> statusList, java.lang.String tgtObCd, java.lang.String tgtObPk) {
        entering("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectXapTaskList", statusList, tgtObCd, tgtObPk);
        try {
            if (statusList == null) {
                throw new org.seasar.doma.DomaNullPointerException("statusList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CutomXapTaskDao/selectXapTaskList.sql");
            __query.addParameter("statusList", java.util.List.class, statusList);
            __query.addParameter("tgtObCd", java.lang.String.class, tgtObCd);
            __query.addParameter("tgtObPk", java.lang.String.class, tgtObPk);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl");
            __query.setCallerMethodName("selectXapTaskList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapTask>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapTask>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapTask>(pkuhit.xap.dao.auto.entity._XapTask.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapTask> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectXapTaskList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectXapTaskList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapTask> searchSent(java.lang.String taskStaCd) {
        entering("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "searchSent", taskStaCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CutomXapTaskDao/searchSent.sql");
            __query.addParameter("taskStaCd", java.lang.String.class, taskStaCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl");
            __query.setCallerMethodName("searchSent");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapTask>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapTask>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapTask>(pkuhit.xap.dao.auto.entity._XapTask.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapTask> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "searchSent", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "searchSent", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchWaitForVerify(java.lang.String taskStaCd) {
        entering("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "searchWaitForVerify", taskStaCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CutomXapTaskDao/searchWaitForVerify.sql");
            __query.addParameter("taskStaCd", java.lang.String.class, taskStaCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl");
            __query.setCallerMethodName("searchWaitForVerify");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "searchWaitForVerify", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "searchWaitForVerify", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectXapTaskByEn(java.lang.String encounterSn) {
        entering("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectXapTaskByEn", encounterSn);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CutomXapTaskDao/selectXapTaskByEn.sql");
            __query.addParameter("encounterSn", java.lang.String.class, encounterSn);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl");
            __query.setCallerMethodName("selectXapTaskByEn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectXapTaskByEn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectXapTaskByEn", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapTask selectTaskByRevisionCd(java.lang.String revisionCd) {
        entering("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectTaskByRevisionCd", revisionCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CutomXapTaskDao/selectTaskByRevisionCd.sql");
            __query.addParameter("revisionCd", java.lang.String.class, revisionCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl");
            __query.setCallerMethodName("selectTaskByRevisionCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapTask> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapTask>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.xap.dao.auto.entity.XapTask>(pkuhit.xap.dao.auto.entity._XapTask.getSingletonInternal()));
            pkuhit.xap.dao.auto.entity.XapTask __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectTaskByRevisionCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectTaskByRevisionCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrTpCcatForTask(java.lang.String encounterSn, java.lang.String mrTpCd) {
        entering("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectMrTpCcatForTask", encounterSn, mrTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CutomXapTaskDao/selectMrTpCcatForTask.sql");
            __query.addParameter("encounterSn", java.lang.String.class, encounterSn);
            __query.addParameter("mrTpCd", java.lang.String.class, mrTpCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl");
            __query.setCallerMethodName("selectMrTpCcatForTask");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectMrTpCcatForTask", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CutomXapTaskDaoImpl", "selectMrTpCcatForTask", __e);
            throw __e;
        }
    }

}
