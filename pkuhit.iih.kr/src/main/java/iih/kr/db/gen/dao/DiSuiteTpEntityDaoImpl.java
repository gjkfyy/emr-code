package iih.kr.db.gen.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.155+0800")
public class DiSuiteTpEntityDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.kr.db.gen.dao.DiSuiteTpEntityDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "insert", iih.kr.db.gen.entity.DiSuiteTpEntity.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "insertExludeNull", iih.kr.db.gen.entity.DiSuiteTpEntity.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "update", iih.kr.db.gen.entity.DiSuiteTpEntity.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "updateExcludeNull", iih.kr.db.gen.entity.DiSuiteTpEntity.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "markDelete", iih.kr.db.gen.entity.DiSuiteTpEntity.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "delete", iih.kr.db.gen.entity.DiSuiteTpEntity.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTpEntityDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public DiSuiteTpEntityDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteTpEntity selectById(java.lang.String diSuiteTpCd) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "selectById", diSuiteTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/gen/dao/DiSuiteTpEntityDao/selectById.sql");
            __query.addParameter("diSuiteTpCd", java.lang.String.class, diSuiteTpCd);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<iih.kr.db.gen.entity.DiSuiteTpEntity> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<iih.kr.db.gen.entity.DiSuiteTpEntity>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal()));
            iih.kr.db.gen.entity.DiSuiteTpEntity __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(iih.kr.db.gen.entity.DiSuiteTpEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(iih.kr.db.gen.entity.DiSuiteTpEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(iih.kr.db.gen.entity.DiSuiteTpEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
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
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(iih.kr.db.gen.entity.DiSuiteTpEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
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
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(iih.kr.db.gen.entity.DiSuiteTpEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
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
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(iih.kr.db.gen.entity.DiSuiteTpEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<iih.kr.db.gen.entity.DiSuiteTpEntity> entities) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<iih.kr.db.gen.entity.DiSuiteTpEntity> entities) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
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
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<iih.kr.db.gen.entity.DiSuiteTpEntity> entities) {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<iih.kr.db.gen.entity.DiSuiteTpEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTpEntityDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
