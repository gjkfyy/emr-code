package pkuhit.me.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.438+0800")
public class MeFuActDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.me.dao.auto.MeFuActDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "insert", pkuhit.me.dao.auto.entity.MeFuAct.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "insertExludeNull", pkuhit.me.dao.auto.entity.MeFuAct.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "update", pkuhit.me.dao.auto.entity.MeFuAct.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "updateExcludeNull", pkuhit.me.dao.auto.entity.MeFuAct.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "markDelete", pkuhit.me.dao.auto.entity.MeFuAct.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "delete", pkuhit.me.dao.auto.entity.MeFuAct.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.me.dao.auto.MeFuActDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MeFuActDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeFuAct selectById(java.lang.String fuActCd) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "selectById", fuActCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/me/dao/auto/MeFuActDao/selectById.sql");
            __query.addParameter("fuActCd", java.lang.String.class, fuActCd);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.me.dao.auto.entity.MeFuAct> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.me.dao.auto.entity.MeFuAct>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal()));
            pkuhit.me.dao.auto.entity.MeFuAct __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(pkuhit.me.dao.auto.entity.MeFuAct entity) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(pkuhit.me.dao.auto.entity.MeFuAct entity) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(pkuhit.me.dao.auto.entity.MeFuAct entity) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
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
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(pkuhit.me.dao.auto.entity.MeFuAct entity) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
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
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(pkuhit.me.dao.auto.entity.MeFuAct entity) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
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
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(pkuhit.me.dao.auto.entity.MeFuAct entity) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<pkuhit.me.dao.auto.entity.MeFuAct> entities) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<pkuhit.me.dao.auto.entity.MeFuAct> entities) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
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
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<pkuhit.me.dao.auto.entity.MeFuAct> entities) {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.me.dao.auto.entity.MeFuAct> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.me.dao.auto.entity.MeFuAct>(pkuhit.me.dao.auto.entity._MeFuAct.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("pkuhit.me.dao.auto.MeFuActDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("pkuhit.me.dao.auto.MeFuActDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.auto.MeFuActDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.auto.MeFuActDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
