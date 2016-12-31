package szlh.iih.sync.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.693+0800")
public class CusOrgEmpDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.sync.dao.CusOrgEmpDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.sync.dao.CusOrgEmpDao.class, "delete", szlh.iih.sync.po.XapOrgEmpPo.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(szlh.iih.sync.dao.CusOrgEmpDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusOrgEmpDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.sync.po.XapOrgEmpPo> selectAll(org.seasar.doma.jdbc.SelectOptions options) {
        entering("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "selectAll", options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/sync/dao/CusOrgEmpDao/selectAll.sql");
            __query.setOptions(options);
            __query.setCallerClassName("szlh.iih.sync.dao.CusOrgEmpDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.sync.po.XapOrgEmpPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.sync.po.XapOrgEmpPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.sync.po.XapOrgEmpPo>(szlh.iih.sync.po._XapOrgEmpPo.getSingletonInternal()));
            java.util.List<szlh.iih.sync.po.XapOrgEmpPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int delete(szlh.iih.sync.po.XapOrgEmpPo entity) {
        entering("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.sync.po.XapOrgEmpPo> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<szlh.iih.sync.po.XapOrgEmpPo>(szlh.iih.sync.po._XapOrgEmpPo.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("szlh.iih.sync.dao.CusOrgEmpDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<szlh.iih.sync.po.XapOrgEmpPo> entities) {
        entering("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.sync.po.XapOrgEmpPo> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<szlh.iih.sync.po.XapOrgEmpPo>(szlh.iih.sync.po._XapOrgEmpPo.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("szlh.iih.sync.dao.CusOrgEmpDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.sync.dao.CusOrgEmpDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

}
