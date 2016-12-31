package pkuhit.iih.qa.dao.qacustom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.511+0800")
public class CusQaItemnDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.qacustom.CusQaItemnDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaItemnDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItm> searchQaItem(java.lang.String itemFirstCode, java.lang.String itemSecondCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "searchQaItem", itemFirstCode, itemSecondCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaItemnDao/searchQaItem.sql");
            __query.addParameter("itemFirstCode", java.lang.String.class, itemFirstCode);
            __query.addParameter("itemSecondCode", java.lang.String.class, itemSecondCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl");
            __query.setCallerMethodName("searchQaItem");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaItm>(pkuhit.iih.qa.dao.auto.entity._QaItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "searchQaItem", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "searchQaItem", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchQaItemList(java.lang.String itemFirstCode, java.lang.String itemSecondCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "searchQaItemList", itemFirstCode, itemSecondCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaItemnDao/searchQaItemList.sql");
            __query.addParameter("itemFirstCode", java.lang.String.class, itemFirstCode);
            __query.addParameter("itemSecondCode", java.lang.String.class, itemSecondCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl");
            __query.setCallerMethodName("searchQaItemList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "searchQaItemList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "searchQaItemList", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaItm selectQaItmById(java.lang.String qaItmCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "selectQaItmById", qaItmCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaItemnDao/selectQaItmById.sql");
            __query.addParameter("qaItmCd", java.lang.String.class, qaItmCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl");
            __query.setCallerMethodName("selectQaItmById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItm> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItm>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaItm>(pkuhit.iih.qa.dao.auto.entity._QaItm.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaItm __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "selectQaItmById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaItemnDaoImpl", "selectQaItmById", __e);
            throw __e;
        }
    }

}
