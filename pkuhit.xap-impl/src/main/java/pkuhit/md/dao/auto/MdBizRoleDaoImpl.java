package pkuhit.md.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.667+0800")
public class MdBizRoleDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.md.dao.auto.MdBizRoleDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "insert", pkuhit.md.dao.auto.entity.MdBizRole.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "insertExludeNull", pkuhit.md.dao.auto.entity.MdBizRole.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "update", pkuhit.md.dao.auto.entity.MdBizRole.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "updateExcludeNull", pkuhit.md.dao.auto.entity.MdBizRole.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "markDelete", pkuhit.md.dao.auto.entity.MdBizRole.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "delete", pkuhit.md.dao.auto.entity.MdBizRole.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.md.dao.auto.MdBizRoleDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MdBizRoleDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.md.dao.auto.entity.MdBizRole selectById(java.lang.String bizRoleCd) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "selectById", bizRoleCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/md/dao/auto/MdBizRoleDao/selectById.sql");
            __query.addParameter("bizRoleCd", java.lang.String.class, bizRoleCd);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.md.dao.auto.entity.MdBizRole> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.md.dao.auto.entity.MdBizRole>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal()));
            pkuhit.md.dao.auto.entity.MdBizRole __result = __command.execute();
            __query.complete();
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(pkuhit.md.dao.auto.entity.MdBizRole entity) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(pkuhit.md.dao.auto.entity.MdBizRole entity) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(pkuhit.md.dao.auto.entity.MdBizRole entity) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
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
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(pkuhit.md.dao.auto.entity.MdBizRole entity) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
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
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(pkuhit.md.dao.auto.entity.MdBizRole entity) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
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
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(pkuhit.md.dao.auto.entity.MdBizRole entity) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<pkuhit.md.dao.auto.entity.MdBizRole> entities) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<pkuhit.md.dao.auto.entity.MdBizRole> entities) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
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
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<pkuhit.md.dao.auto.entity.MdBizRole> entities) {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.md.dao.auto.entity.MdBizRole> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.md.dao.auto.entity.MdBizRole>(pkuhit.md.dao.auto.entity._MdBizRole.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("pkuhit.md.dao.auto.MdBizRoleDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.auto.MdBizRoleDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
