package szlh.iih.or.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.770+0800")
public class OrderDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.or.dao.OrderDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public OrderDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.or.po.OrderPo> getOrderListByEnSn(java.lang.String patient_id, java.lang.String times, java.lang.String longOrF) {
        entering("szlh.iih.or.dao.OrderDaoImpl", "getOrderListByEnSn", patient_id, times, longOrF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/or/dao/OrderDao/getOrderListByEnSn.sql");
            __query.addParameter("patient_id", java.lang.String.class, patient_id);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("longOrF", java.lang.String.class, longOrF);
            __query.setCallerClassName("szlh.iih.or.dao.OrderDaoImpl");
            __query.setCallerMethodName("getOrderListByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.or.po.OrderPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.or.po.OrderPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.or.po.OrderPo>(szlh.iih.or.po._OrderPo.getSingletonInternal()));
            java.util.List<szlh.iih.or.po.OrderPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.or.dao.OrderDaoImpl", "getOrderListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.or.dao.OrderDaoImpl", "getOrderListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public szlh.iih.or.po.OrderPo OrderDetailByOrderSn(java.lang.String orPk) {
        entering("szlh.iih.or.dao.OrderDaoImpl", "OrderDetailByOrderSn", orPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/or/dao/OrderDao/OrderDetailByOrderSn.sql");
            __query.addParameter("orPk", java.lang.String.class, orPk);
            __query.setCallerClassName("szlh.iih.or.dao.OrderDaoImpl");
            __query.setCallerMethodName("OrderDetailByOrderSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.or.po.OrderPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.or.po.OrderPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<szlh.iih.or.po.OrderPo>(szlh.iih.or.po._OrderPo.getSingletonInternal()));
            szlh.iih.or.po.OrderPo __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.or.dao.OrderDaoImpl", "OrderDetailByOrderSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.or.dao.OrderDaoImpl", "OrderDetailByOrderSn", __e);
            throw __e;
        }
    }

}
