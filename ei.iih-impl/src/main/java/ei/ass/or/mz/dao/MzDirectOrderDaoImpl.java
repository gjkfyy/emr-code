package ei.ass.or.mz.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.768+0800")
public class MzDirectOrderDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ass.or.mz.dao.MzDirectOrderDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MzDirectOrderDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ass.or.auto.po.OrderPo> getOrderListByEnSn(java.lang.String enPk, java.lang.String longOrF, org.seasar.doma.jdbc.SelectOptions options) {
        entering("ei.ass.or.mz.dao.MzDirectOrderDaoImpl", "getOrderListByEnSn", enPk, longOrF, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/or/mz/dao/MzDirectOrderDao/getOrderListByEnSn.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("longOrF", java.lang.String.class, longOrF);
            __query.setCallerClassName("ei.ass.or.mz.dao.MzDirectOrderDaoImpl");
            __query.setCallerMethodName("getOrderListByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.or.auto.po.OrderPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.ass.or.auto.po.OrderPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.ass.or.auto.po.OrderPo>(ei.ass.or.auto.po._OrderPo.getSingletonInternal()));
            java.util.List<ei.ass.or.auto.po.OrderPo> __result = __command.execute();
            __query.complete();
            exiting("ei.ass.or.mz.dao.MzDirectOrderDaoImpl", "getOrderListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.or.mz.dao.MzDirectOrderDaoImpl", "getOrderListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public ei.ass.or.auto.po.OrderPo OrderDetailByOrderSn(java.lang.String orPk) {
        entering("ei.ass.or.mz.dao.MzDirectOrderDaoImpl", "OrderDetailByOrderSn", orPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/or/mz/dao/MzDirectOrderDao/OrderDetailByOrderSn.sql");
            __query.addParameter("orPk", java.lang.String.class, orPk);
            __query.setCallerClassName("ei.ass.or.mz.dao.MzDirectOrderDaoImpl");
            __query.setCallerMethodName("OrderDetailByOrderSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ass.or.auto.po.OrderPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.ass.or.auto.po.OrderPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.ass.or.auto.po.OrderPo>(ei.ass.or.auto.po._OrderPo.getSingletonInternal()));
            ei.ass.or.auto.po.OrderPo __result = __command.execute();
            __query.complete();
            exiting("ei.ass.or.mz.dao.MzDirectOrderDaoImpl", "OrderDetailByOrderSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.or.mz.dao.MzDirectOrderDaoImpl", "OrderDetailByOrderSn", __e);
            throw __e;
        }
    }

}
