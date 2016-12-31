package ei.his.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.839+0800")
public class HisIemrEnAdtEntityDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.his.db.dao.HisIemrEnAdtEntityDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "insert", ei.his.db.dao.auto.entity.IemrEnAdtEntity.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "insertExludeNull", ei.his.db.dao.auto.entity.IemrEnAdtEntity.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "update", ei.his.db.dao.auto.entity.IemrEnAdtEntity.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "updateExcludeNull", ei.his.db.dao.auto.entity.IemrEnAdtEntity.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "markDelete", ei.his.db.dao.auto.entity.IemrEnAdtEntity.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "delete", ei.his.db.dao.auto.entity.IemrEnAdtEntity.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.his.db.dao.HisIemrEnAdtEntityDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public HisIemrEnAdtEntityDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public ei.his.db.dao.auto.entity.IemrEnAdtEntity selectById(java.lang.String enAdtCd) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "selectById", enAdtCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/his/db/dao/HisIemrEnAdtEntityDao/selectById.sql");
            __query.addParameter("enAdtCd", java.lang.String.class, enAdtCd);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal()));
            ei.his.db.dao.auto.entity.IemrEnAdtEntity __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(ei.his.db.dao.auto.entity.IemrEnAdtEntity entity) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(ei.his.db.dao.auto.entity.IemrEnAdtEntity entity) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(ei.his.db.dao.auto.entity.IemrEnAdtEntity entity) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
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
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(ei.his.db.dao.auto.entity.IemrEnAdtEntity entity) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
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
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(ei.his.db.dao.auto.entity.IemrEnAdtEntity entity) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
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
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(ei.his.db.dao.auto.entity.IemrEnAdtEntity entity) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<ei.his.db.dao.auto.entity.IemrEnAdtEntity> entities) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<ei.his.db.dao.auto.entity.IemrEnAdtEntity> entities) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
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
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<ei.his.db.dao.auto.entity.IemrEnAdtEntity> entities) {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<ei.his.db.dao.auto.entity.IemrEnAdtEntity>(ei.his.db.dao.auto.entity._IemrEnAdtEntity.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.his.db.dao.HisIemrEnAdtEntityDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
