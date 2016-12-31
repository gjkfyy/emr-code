package szlh.iih.sync.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.764+0800")
public class CusOrgDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.sync.dao.CusOrgDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.sync.dao.CusOrgDao.class, "delete", szlh.iih.sync.po.OrgPo.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.sync.dao.CusOrgDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusOrgDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.sync.po.OrgPo> selectAll(org.seasar.doma.jdbc.SelectOptions options) {
        entering("szlh.iih.sync.dao.CusOrgDaoImpl", "selectAll", options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/sync/dao/CusOrgDao/selectAll.sql");
            __query.setOptions(options);
            __query.setCallerClassName("szlh.iih.sync.dao.CusOrgDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.sync.po.OrgPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.sync.po.OrgPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.sync.po.OrgPo>(szlh.iih.sync.po._OrgPo.getSingletonInternal()));
            java.util.List<szlh.iih.sync.po.OrgPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusOrgDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusOrgDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int delete(szlh.iih.sync.po.OrgPo entity) {
        entering("szlh.iih.sync.dao.CusOrgDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.sync.po.OrgPo> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.sync.po.OrgPo>(szlh.iih.sync.po._OrgPo.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.sync.dao.CusOrgDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusOrgDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusOrgDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<szlh.iih.sync.po.OrgPo> entities) {
        entering("szlh.iih.sync.dao.CusOrgDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.sync.po.OrgPo> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.sync.po.OrgPo>(szlh.iih.sync.po._OrgPo.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.sync.dao.CusOrgDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusOrgDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusOrgDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

}
