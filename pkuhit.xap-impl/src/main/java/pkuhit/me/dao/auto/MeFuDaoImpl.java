package pkuhit.me.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.427+0800")
public class MeFuDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.me.dao.auto.MeFuDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "insert", pkuhit.me.dao.auto.entity.MeFu.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "insertExludeNull", pkuhit.me.dao.auto.entity.MeFu.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "update", pkuhit.me.dao.auto.entity.MeFu.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "updateExcludeNull", pkuhit.me.dao.auto.entity.MeFu.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "markDelete", pkuhit.me.dao.auto.entity.MeFu.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "delete", pkuhit.me.dao.auto.entity.MeFu.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MeFuDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeFu selectById(java.lang.String fuCd) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "selectById", fuCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/me/dao/auto/MeFuDao/selectById.sql");
            __query.addParameter("fuCd", java.lang.String.class, fuCd);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.me.dao.auto.entity.MeFu> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.me.dao.auto.entity.MeFu>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal()));
            pkuhit.me.dao.auto.entity.MeFu __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(pkuhit.me.dao.auto.entity.MeFu entity) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(pkuhit.me.dao.auto.entity.MeFu entity) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(pkuhit.me.dao.auto.entity.MeFu entity) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
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
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(pkuhit.me.dao.auto.entity.MeFu entity) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
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
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(pkuhit.me.dao.auto.entity.MeFu entity) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
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
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(pkuhit.me.dao.auto.entity.MeFu entity) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<pkuhit.me.dao.auto.entity.MeFu> entities) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<pkuhit.me.dao.auto.entity.MeFu> entities) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
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
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<pkuhit.me.dao.auto.entity.MeFu> entities) {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.me.dao.auto.entity.MeFu> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.me.dao.auto.entity.MeFu>(pkuhit.me.dao.auto.entity._MeFu.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("pkuhit.me.dao.auto.MeFuDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
