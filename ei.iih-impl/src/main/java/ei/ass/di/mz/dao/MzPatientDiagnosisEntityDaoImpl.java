package ei.ass.di.mz.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.722+0800")
public class MzPatientDiagnosisEntityDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao.class, "insert", ei.ass.di.auto.po.MzPatientDiagnosisEntity.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao.class, "update", ei.ass.di.auto.po.MzPatientDiagnosisEntity.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao.class, "updateExcludeNull", ei.ass.di.auto.po.MzPatientDiagnosisEntity.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao.class, "markDelete", ei.ass.di.auto.po.MzPatientDiagnosisEntity.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao.class, "delete", ei.ass.di.auto.po.MzPatientDiagnosisEntity.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MzPatientDiagnosisEntityDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public ei.ass.di.auto.po.MzPatientDiagnosisEntity selectById(java.lang.Integer sn) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "selectById", sn);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/di/mz/dao/MzPatientDiagnosisEntityDao/selectById.sql");
            __query.addParameter("sn", java.lang.Integer.class, sn);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal()));
            ei.ass.di.auto.po.MzPatientDiagnosisEntity __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
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
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
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
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
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
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<ei.ass.di.auto.po.MzPatientDiagnosisEntity> entities) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<ei.ass.di.auto.po.MzPatientDiagnosisEntity> entities) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
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
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<ei.ass.di.auto.po.MzPatientDiagnosisEntity> entities) {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<ei.ass.di.auto.po.MzPatientDiagnosisEntity>(ei.ass.di.auto.po._MzPatientDiagnosisEntity.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.di.mz.dao.MzPatientDiagnosisEntityDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
