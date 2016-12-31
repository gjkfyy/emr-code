package iih.di.db.gen.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:37.107+0800")
public class MdDiEntityDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.di.db.gen.dao.MdDiEntityDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "insert", iih.di.db.gen.entity.MdDiEntity.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "insertExludeNull", iih.di.db.gen.entity.MdDiEntity.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "update", iih.di.db.gen.entity.MdDiEntity.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "updateExcludeNull", iih.di.db.gen.entity.MdDiEntity.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "markDelete", iih.di.db.gen.entity.MdDiEntity.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "delete", iih.di.db.gen.entity.MdDiEntity.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.di.db.gen.dao.MdDiEntityDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MdDiEntityDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public iih.di.db.gen.entity.MdDiEntity selectById(java.lang.String diCd) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "selectById", diCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/gen/dao/MdDiEntityDao/selectById.sql");
            __query.addParameter("diCd", java.lang.String.class, diCd);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<iih.di.db.gen.entity.MdDiEntity> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<iih.di.db.gen.entity.MdDiEntity>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal()));
            iih.di.db.gen.entity.MdDiEntity __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(iih.di.db.gen.entity.MdDiEntity entity) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(iih.di.db.gen.entity.MdDiEntity entity) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(iih.di.db.gen.entity.MdDiEntity entity) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
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
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(iih.di.db.gen.entity.MdDiEntity entity) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
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
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(iih.di.db.gen.entity.MdDiEntity entity) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
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
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(iih.di.db.gen.entity.MdDiEntity entity) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<iih.di.db.gen.entity.MdDiEntity> entities) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<iih.di.db.gen.entity.MdDiEntity> entities) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
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
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<iih.di.db.gen.entity.MdDiEntity> entities) {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<iih.di.db.gen.entity.MdDiEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("iih.di.db.gen.dao.MdDiEntityDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("iih.di.db.gen.dao.MdDiEntityDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.gen.dao.MdDiEntityDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.gen.dao.MdDiEntityDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
