package iih.kr.db.gen.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:18.156+0800")
public class DiSuiteTemplateEntityDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.kr.db.gen.dao.DiSuiteTemplateEntityDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "insert", iih.kr.db.gen.entity.DiSuiteTemplateEntity.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "insertExludeNull", iih.kr.db.gen.entity.DiSuiteTemplateEntity.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "update", iih.kr.db.gen.entity.DiSuiteTemplateEntity.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "updateExcludeNull", iih.kr.db.gen.entity.DiSuiteTemplateEntity.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "markDelete", iih.kr.db.gen.entity.DiSuiteTemplateEntity.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "delete", iih.kr.db.gen.entity.DiSuiteTemplateEntity.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(iih.kr.db.gen.dao.DiSuiteTemplateEntityDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public DiSuiteTemplateEntityDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteTemplateEntity selectById(java.lang.String diSuiteTemplateCd) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "selectById", diSuiteTemplateCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/gen/dao/DiSuiteTemplateEntityDao/selectById.sql");
            __query.addParameter("diSuiteTemplateCd", java.lang.String.class, diSuiteTemplateCd);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal()));
            iih.kr.db.gen.entity.DiSuiteTemplateEntity __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(iih.kr.db.gen.entity.DiSuiteTemplateEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(iih.kr.db.gen.entity.DiSuiteTemplateEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(iih.kr.db.gen.entity.DiSuiteTemplateEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
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
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(iih.kr.db.gen.entity.DiSuiteTemplateEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
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
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(iih.kr.db.gen.entity.DiSuiteTemplateEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
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
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(iih.kr.db.gen.entity.DiSuiteTemplateEntity entity) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<iih.kr.db.gen.entity.DiSuiteTemplateEntity> entities) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<iih.kr.db.gen.entity.DiSuiteTemplateEntity> entities) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
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
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<iih.kr.db.gen.entity.DiSuiteTemplateEntity> entities) {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.gen.dao.DiSuiteTemplateEntityDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
