package iih.dr.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:05.121+0800")
public class IemrRetrievalResultDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.dr.dao.auto.IemrRetrievalResultDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "insert", iih.dr.dao.auto.entity.IemrRetrievalResult.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "insertExludeNull", iih.dr.dao.auto.entity.IemrRetrievalResult.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "update", iih.dr.dao.auto.entity.IemrRetrievalResult.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "updateExcludeNull", iih.dr.dao.auto.entity.IemrRetrievalResult.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "markDelete", iih.dr.dao.auto.entity.IemrRetrievalResult.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "delete", iih.dr.dao.auto.entity.IemrRetrievalResult.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.dr.dao.auto.IemrRetrievalResultDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public IemrRetrievalResultDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrievalResult selectById(java.lang.String resultCd) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "selectById", resultCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/auto/IemrRetrievalResultDao/selectById.sql");
            __query.addParameter("resultCd", java.lang.String.class, resultCd);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<iih.dr.dao.auto.entity.IemrRetrievalResult> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<iih.dr.dao.auto.entity.IemrRetrievalResult>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal()));
            iih.dr.dao.auto.entity.IemrRetrievalResult __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(iih.dr.dao.auto.entity.IemrRetrievalResult entity) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(iih.dr.dao.auto.entity.IemrRetrievalResult entity) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(iih.dr.dao.auto.entity.IemrRetrievalResult entity) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
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
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(iih.dr.dao.auto.entity.IemrRetrievalResult entity) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
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
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(iih.dr.dao.auto.entity.IemrRetrievalResult entity) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
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
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(iih.dr.dao.auto.entity.IemrRetrievalResult entity) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<iih.dr.dao.auto.entity.IemrRetrievalResult> entities) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<iih.dr.dao.auto.entity.IemrRetrievalResult> entities) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
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
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<iih.dr.dao.auto.entity.IemrRetrievalResult> entities) {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<iih.dr.dao.auto.entity.IemrRetrievalResult> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("iih.dr.dao.auto.IemrRetrievalResultDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.auto.IemrRetrievalResultDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
