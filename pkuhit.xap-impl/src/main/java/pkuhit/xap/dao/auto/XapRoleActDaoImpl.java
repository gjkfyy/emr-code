package pkuhit.xap.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.489+0800")
public class XapRoleActDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.auto.XapRoleActDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "insert", pkuhit.xap.dao.auto.entity.XapRoleAct.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "insertExludeNull", pkuhit.xap.dao.auto.entity.XapRoleAct.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "update", pkuhit.xap.dao.auto.entity.XapRoleAct.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "updateExcludeNull", pkuhit.xap.dao.auto.entity.XapRoleAct.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "markDelete", pkuhit.xap.dao.auto.entity.XapRoleAct.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "delete", pkuhit.xap.dao.auto.entity.XapRoleAct.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.XapRoleActDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public XapRoleActDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapRoleAct selectById(java.lang.String roleActCd) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "selectById", roleActCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/auto/XapRoleActDao/selectById.sql");
            __query.addParameter("roleActCd", java.lang.String.class, roleActCd);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapRoleAct> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.XapRoleAct>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal()));
            pkuhit.xap.dao.auto.entity.XapRoleAct __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(pkuhit.xap.dao.auto.entity.XapRoleAct entity) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(pkuhit.xap.dao.auto.entity.XapRoleAct entity) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(pkuhit.xap.dao.auto.entity.XapRoleAct entity) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
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
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(pkuhit.xap.dao.auto.entity.XapRoleAct entity) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
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
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(pkuhit.xap.dao.auto.entity.XapRoleAct entity) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
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
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(pkuhit.xap.dao.auto.entity.XapRoleAct entity) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<pkuhit.xap.dao.auto.entity.XapRoleAct> entities) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<pkuhit.xap.dao.auto.entity.XapRoleAct> entities) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
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
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<pkuhit.xap.dao.auto.entity.XapRoleAct> entities) {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.xap.dao.auto.entity.XapRoleAct> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.xap.dao.auto.entity.XapRoleAct>(pkuhit.xap.dao.auto.entity._XapRoleAct.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("pkuhit.xap.dao.auto.XapRoleActDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.XapRoleActDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
