package pkuhit.iih.qa.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:39.033+0800")
public class CusQaItemDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.custom.CusQaItemDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaItemDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public int selectByQaItemPk(java.util.List<java.lang.String> qaItemPkList) {
        entering("pkuhit.iih.qa.dao.custom.CusQaItemDaoImpl", "selectByQaItemPk", qaItemPkList);
        try {
            if (qaItemPkList == null) {
                throw new org.seasar.doma.DomaNullPointerException("qaItemPkList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaItemDao/selectByQaItemPk.sql");
            __query.addParameter("qaItemPkList", java.util.List.class, qaItemPkList);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaItemDaoImpl");
            __query.setCallerMethodName("selectByQaItemPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaItemDaoImpl", "selectByQaItemPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaItemDaoImpl", "selectByQaItemPk", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaFltItm selectFaultItemByFaultPk(java.lang.String faultPk) {
        entering("pkuhit.iih.qa.dao.custom.CusQaItemDaoImpl", "selectFaultItemByFaultPk", faultPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaItemDao/selectFaultItemByFaultPk.sql");
            __query.addParameter("faultPk", java.lang.String.class, faultPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaItemDaoImpl");
            __query.setCallerMethodName("selectFaultItemByFaultPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaFltItm> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaFltItm>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaFltItm>(pkuhit.iih.qa.dao.auto.entity._QaFltItm.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaFltItm __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaItemDaoImpl", "selectFaultItemByFaultPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaItemDaoImpl", "selectFaultItemByFaultPk", __e);
            throw __e;
        }
    }

}
