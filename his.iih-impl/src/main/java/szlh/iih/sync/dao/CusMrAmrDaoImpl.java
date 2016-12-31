package szlh.iih.sync.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.706+0800")
public class CusMrAmrDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.sync.dao.CusMrAmrDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.sync.dao.CusMrAmrDao.class, "delete", szlh.iih.sync.po.MrAmrPo.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.sync.dao.CusMrAmrDao.class, "batchDelete", java.util.List.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.sync.dao.CusMrAmrDao.class, "update", szlh.iih.sync.po.MrAmrPo.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrAmrDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.sync.po.MrAmrPo> selectAll(org.seasar.doma.jdbc.SelectOptions options) {
        entering("szlh.iih.sync.dao.CusMrAmrDaoImpl", "selectAll", options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/sync/dao/CusMrAmrDao/selectAll.sql");
            __query.setOptions(options);
            __query.setCallerClassName("szlh.iih.sync.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.sync.po.MrAmrPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.sync.po.MrAmrPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.sync.po.MrAmrPo>(szlh.iih.sync.po._MrAmrPo.getSingletonInternal()));
            java.util.List<szlh.iih.sync.po.MrAmrPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusMrAmrDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusMrAmrDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int delete(szlh.iih.sync.po.MrAmrPo entity) {
        entering("szlh.iih.sync.dao.CusMrAmrDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.sync.po.MrAmrPo> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.sync.po.MrAmrPo>(szlh.iih.sync.po._MrAmrPo.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.sync.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusMrAmrDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusMrAmrDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<szlh.iih.sync.po.MrAmrPo> entities) {
        entering("szlh.iih.sync.dao.CusMrAmrDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.sync.po.MrAmrPo> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.sync.po.MrAmrPo>(szlh.iih.sync.po._MrAmrPo.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.sync.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusMrAmrDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusMrAmrDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public int update(szlh.iih.sync.po.MrAmrPo entity) {
        entering("szlh.iih.sync.dao.CusMrAmrDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.sync.po.MrAmrPo> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.sync.po.MrAmrPo>(szlh.iih.sync.po._MrAmrPo.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.sync.dao.CusMrAmrDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setVersionIncluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.UpdateCommand __command = new org.seasar.doma.internal.jdbc.command.UpdateCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusMrAmrDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusMrAmrDaoImpl", "update", __e);
            throw __e;
        }
    }

}
