package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.342+0800")
public class CusQaItemMrTpDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusQaItemMrTpDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaItemMrTpDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItemMrTp> selectByMrTpCd(java.lang.String mrTypeCode) {
        entering("pkuhit.iih.mr.wr.dao.CusQaItemMrTpDaoImpl", "selectByMrTpCd", mrTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusQaItemMrTpDao/selectByMrTpCd.sql");
            __query.addParameter("mrTypeCode", java.lang.String.class, mrTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusQaItemMrTpDaoImpl");
            __query.setCallerMethodName("selectByMrTpCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItemMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItemMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaItemMrTp>(pkuhit.iih.qa.dao.auto.entity._QaItemMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItemMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusQaItemMrTpDaoImpl", "selectByMrTpCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusQaItemMrTpDaoImpl", "selectByMrTpCd", __e);
            throw __e;
        }
    }

}
