package pkuhit.iih.mr.md.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.589+0800")
public class MdMetaElementValueDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "insert", pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "insertExludeNull", pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "update", pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "updateExcludeNull", pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "markDelete", pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "delete", pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MdMetaElementValueDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue selectById(java.lang.String dataElementValueCd) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "selectById", dataElementValueCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/auto/MdMetaElementValueDao/selectById.sql");
            __query.addParameter("dataElementValueCd", java.lang.String.class, dataElementValueCd);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal()));
            pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue entity) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue entity) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue entity) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
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
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue entity) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
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
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue entity) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
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
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue entity) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> entities) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> entities) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
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
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> entities) {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
