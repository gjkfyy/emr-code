package pkuhit.iih.mr.tth.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.651+0800")
public class MrTeethExamDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "insert", pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "insertExludeNull", pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "update", pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "updateExcludeNull", pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "markDelete", pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "delete", pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MrTeethExamDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam selectById(java.lang.String teethPk) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "selectById", teethPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tth/dao/auto/MrTeethExamDao/selectById.sql");
            __query.addParameter("teethPk", java.lang.String.class, teethPk);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal()));
            pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
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
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
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
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
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
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> entities) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> entities) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
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
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> entities) {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.auto.MrTeethExamDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
