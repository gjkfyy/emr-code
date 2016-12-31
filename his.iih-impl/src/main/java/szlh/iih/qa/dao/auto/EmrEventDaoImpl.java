package szlh.iih.qa.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.736+0800")
public class EmrEventDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.qa.dao.auto.EmrEventDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.qa.dao.auto.EmrEventDao.class, "insert", szlh.iih.qa.po.EmrEvent.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.qa.dao.auto.EmrEventDao.class, "update", szlh.iih.qa.po.EmrEvent.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.qa.dao.auto.EmrEventDao.class, "updateExcludeNull", szlh.iih.qa.po.EmrEvent.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.qa.dao.auto.EmrEventDao.class, "markDelete", szlh.iih.qa.po.EmrEvent.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.qa.dao.auto.EmrEventDao.class, "delete", szlh.iih.qa.po.EmrEvent.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.qa.dao.auto.EmrEventDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.qa.dao.auto.EmrEventDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.qa.dao.auto.EmrEventDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public EmrEventDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public szlh.iih.qa.po.EmrEvent selectById(java.lang.Integer eventid) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "selectById", eventid);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/qa/dao/auto/EmrEventDao/selectById.sql");
            __query.addParameter("eventid", java.lang.Integer.class, eventid);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.qa.po.EmrEvent> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.qa.po.EmrEvent>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal()));
            szlh.iih.qa.po.EmrEvent __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(szlh.iih.qa.po.EmrEvent entity) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<szlh.iih.qa.po.EmrEvent> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(szlh.iih.qa.po.EmrEvent entity) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.qa.po.EmrEvent> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
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
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(szlh.iih.qa.po.EmrEvent entity) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.qa.po.EmrEvent> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("updateExcludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
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
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(szlh.iih.qa.po.EmrEvent entity) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.qa.po.EmrEvent> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("markDelete");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
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
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(szlh.iih.qa.po.EmrEvent entity) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.qa.po.EmrEvent> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<szlh.iih.qa.po.EmrEvent> entities) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<szlh.iih.qa.po.EmrEvent> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<szlh.iih.qa.po.EmrEvent> entities) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<szlh.iih.qa.po.EmrEvent> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("batchUpdate");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIncluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchUpdateCommand __command = new org.seasar.doma.internal.jdbc.command.BatchUpdateCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<szlh.iih.qa.po.EmrEvent> entities) {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.qa.po.EmrEvent> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.qa.po.EmrEvent>(szlh.iih.qa.po._EmrEvent.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("szlh.iih.qa.dao.auto.EmrEventDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.qa.dao.auto.EmrEventDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
