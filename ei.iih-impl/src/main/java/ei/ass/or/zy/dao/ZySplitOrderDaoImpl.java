package ei.ass.or.zy.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.884+0800")
public class ZySplitOrderDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.ass.or.zy.dao.ZySplitOrderDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ZySplitOrderDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.ass.or.auto.po.OrderPo> getOrderListByEnSn(java.lang.String patient_id, java.lang.String times, java.lang.String longOrF, java.lang.String orTpNm, java.lang.String svNm) {
        entering("ei.ass.or.zy.dao.ZySplitOrderDaoImpl", "getOrderListByEnSn", patient_id, times, longOrF, orTpNm, svNm);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/or/zy/dao/ZySplitOrderDao/getOrderListByEnSn.sql");
            __query.addParameter("patient_id", java.lang.String.class, patient_id);
            __query.addParameter("times", java.lang.String.class, times);
            __query.addParameter("longOrF", java.lang.String.class, longOrF);
            __query.addParameter("orTpNm", java.lang.String.class, orTpNm);
            __query.addParameter("svNm", java.lang.String.class, svNm);
            __query.setCallerClassName("ei.ass.or.zy.dao.ZySplitOrderDaoImpl");
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
            exiting("ei.ass.or.zy.dao.ZySplitOrderDaoImpl", "getOrderListByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.or.zy.dao.ZySplitOrderDaoImpl", "getOrderListByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public ei.ass.or.auto.po.OrderPo OrderDetailByOrderSn(java.lang.String orPk) {
        entering("ei.ass.or.zy.dao.ZySplitOrderDaoImpl", "OrderDetailByOrderSn", orPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/ass/or/zy/dao/ZySplitOrderDao/OrderDetailByOrderSn.sql");
            __query.addParameter("orPk", java.lang.String.class, orPk);
            __query.setCallerClassName("ei.ass.or.zy.dao.ZySplitOrderDaoImpl");
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
            exiting("ei.ass.or.zy.dao.ZySplitOrderDaoImpl", "OrderDetailByOrderSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.ass.or.zy.dao.ZySplitOrderDaoImpl", "OrderDetailByOrderSn", __e);
            throw __e;
        }
    }

}
