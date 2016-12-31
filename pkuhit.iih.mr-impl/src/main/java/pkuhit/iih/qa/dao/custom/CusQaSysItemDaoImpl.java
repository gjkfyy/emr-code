package pkuhit.iih.qa.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.124+0800")
public class CusQaSysItemDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.custom.CusQaSysItemDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaSysItemDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.custom.entity.CusQaSysItm> searchQaSysItem(java.lang.String enTpCd, java.util.List<java.lang.String> mrTpCds, java.lang.String mrSegmentTemplateCode) {
        entering("pkuhit.iih.qa.dao.custom.CusQaSysItemDaoImpl", "searchQaSysItem", enTpCd, mrTpCds, mrSegmentTemplateCode);
        try {
            if (mrTpCds == null) {
                throw new org.seasar.doma.DomaNullPointerException("mrTpCds");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaSysItemDao/searchQaSysItem.sql");
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("mrTpCds", java.util.List.class, mrTpCds);
            __query.addParameter("mrSegmentTemplateCode", java.lang.String.class, mrSegmentTemplateCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaSysItemDaoImpl");
            __query.setCallerMethodName("searchQaSysItem");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.custom.entity.CusQaSysItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.custom.entity.CusQaSysItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.custom.entity.CusQaSysItm>(pkuhit.iih.qa.dao.custom.entity._CusQaSysItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.custom.entity.CusQaSysItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaSysItemDaoImpl", "searchQaSysItem", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaSysItemDaoImpl", "searchQaSysItem", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMrTp selectParentMrTpByMrTpCd(java.lang.String mrTpCd) {
        entering("pkuhit.iih.qa.dao.custom.CusQaSysItemDaoImpl", "selectParentMrTpByMrTpCd", mrTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/custom/CusQaSysItemDao/selectParentMrTpByMrTpCd.sql");
            __query.addParameter("mrTpCd", java.lang.String.class, mrTpCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.custom.CusQaSysItemDaoImpl");
            __query.setCallerMethodName("selectParentMrTpByMrTpCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            pkuhit.iih.mr.md.dao.auto.entity.MdMrTp __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.custom.CusQaSysItemDaoImpl", "selectParentMrTpByMrTpCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.custom.CusQaSysItemDaoImpl", "selectParentMrTpByMrTpCd", __e);
            throw __e;
        }
    }

}
