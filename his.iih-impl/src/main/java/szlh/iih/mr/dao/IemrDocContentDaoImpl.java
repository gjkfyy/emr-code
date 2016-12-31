package szlh.iih.mr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:26.369+0800")
public class IemrDocContentDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.mr.dao.IemrDocContentDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.mr.dao.IemrDocContentDao.class, "insert", szlh.iih.mr.po.IemrDocContent.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.mr.dao.IemrDocContentDao.class, "update", szlh.iih.mr.po.IemrDocContent.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.mr.dao.IemrDocContentDao.class, "updateExcludeNull", szlh.iih.mr.po.IemrDocContent.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.mr.dao.IemrDocContentDao.class, "markDelete", szlh.iih.mr.po.IemrDocContent.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.mr.dao.IemrDocContentDao.class, "delete", szlh.iih.mr.po.IemrDocContent.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.mr.dao.IemrDocContentDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.mr.dao.IemrDocContentDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.mr.dao.IemrDocContentDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public IemrDocContentDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public szlh.iih.mr.po.IemrDocContent selectById(java.lang.Integer id) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "selectById", id);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/mr/dao/IemrDocContentDao/selectById.sql");
            __query.addParameter("id", java.lang.Integer.class, id);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.mr.po.IemrDocContent> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.mr.po.IemrDocContent>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal()));
            szlh.iih.mr.po.IemrDocContent __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(szlh.iih.mr.po.IemrDocContent entity) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<szlh.iih.mr.po.IemrDocContent> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(szlh.iih.mr.po.IemrDocContent entity) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.mr.po.IemrDocContent> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
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
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(szlh.iih.mr.po.IemrDocContent entity) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.mr.po.IemrDocContent> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
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
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(szlh.iih.mr.po.IemrDocContent entity) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.mr.po.IemrDocContent> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
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
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(szlh.iih.mr.po.IemrDocContent entity) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.mr.po.IemrDocContent> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<szlh.iih.mr.po.IemrDocContent> entities) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<szlh.iih.mr.po.IemrDocContent> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<szlh.iih.mr.po.IemrDocContent> entities) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<szlh.iih.mr.po.IemrDocContent> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
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
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<szlh.iih.mr.po.IemrDocContent> entities) {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.mr.po.IemrDocContent> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("szlh.iih.mr.dao.IemrDocContentDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("szlh.iih.mr.dao.IemrDocContentDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.mr.dao.IemrDocContentDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.IemrDocContentDaoImpl", "createClob", __e);
            throw __e;
        }
    }

}
