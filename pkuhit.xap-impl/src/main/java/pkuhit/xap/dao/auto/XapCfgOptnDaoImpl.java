package pkuhit.xap.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.729+0800")
public class XapCfgOptnDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.auto.XapCfgOptnDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "insert", pkuhit.xap.dao.auto.entity.XapCfgOptn.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "insertExludeNull", pkuhit.xap.dao.auto.entity.XapCfgOptn.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "update", pkuhit.xap.dao.auto.entity.XapCfgOptn.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "updateExcludeNull", pkuhit.xap.dao.auto.entity.XapCfgOptn.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "markDelete", pkuhit.xap.dao.auto.entity.XapCfgOptn.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "delete", pkuhit.xap.dao.auto.entity.XapCfgOptn.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapCfgOptnDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public XapCfgOptnDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapCfgOptn selectById(java.lang.String optnCd) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "selectById", optnCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/auto/XapCfgOptnDao/selectById.sql");
            __query.addParameter("optnCd", java.lang.String.class, optnCd);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapCfgOptn> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapCfgOptn>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal()));
            pkuhit.xap.dao.auto.entity.XapCfgOptn __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(pkuhit.xap.dao.auto.entity.XapCfgOptn entity) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(pkuhit.xap.dao.auto.entity.XapCfgOptn entity) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(pkuhit.xap.dao.auto.entity.XapCfgOptn entity) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
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
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(pkuhit.xap.dao.auto.entity.XapCfgOptn entity) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
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
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(pkuhit.xap.dao.auto.entity.XapCfgOptn entity) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
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
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(pkuhit.xap.dao.auto.entity.XapCfgOptn entity) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<pkuhit.xap.dao.auto.entity.XapCfgOptn> entities) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<pkuhit.xap.dao.auto.entity.XapCfgOptn> entities) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
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
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<pkuhit.xap.dao.auto.entity.XapCfgOptn> entities) {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.xap.dao.auto.entity.XapCfgOptn>(pkuhit.xap.dao.auto.entity._XapCfgOptn.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapCfgOptnDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
