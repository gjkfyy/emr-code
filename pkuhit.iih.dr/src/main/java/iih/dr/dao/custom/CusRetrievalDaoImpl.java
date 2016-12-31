package iih.dr.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:05.129+0800")
public class CusRetrievalDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.dr.dao.custom.CusRetrievalDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusRetrievalDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectRetrievalByCondition(java.lang.String retrievalCd, java.lang.String retrievalNm, java.lang.String ownTpCd, java.lang.String responsibleCd, java.lang.String retrievalKey, java.lang.String deptCd, java.util.Date lastUpdTime) {
        entering("iih.dr.dao.custom.CusRetrievalDaoImpl", "selectRetrievalByCondition", retrievalCd, retrievalNm, ownTpCd, responsibleCd, retrievalKey, deptCd, lastUpdTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalDao/selectRetrievalByCondition.sql");
            __query.addParameter("retrievalCd", java.lang.String.class, retrievalCd);
            __query.addParameter("retrievalNm", java.lang.String.class, retrievalNm);
            __query.addParameter("ownTpCd", java.lang.String.class, ownTpCd);
            __query.addParameter("responsibleCd", java.lang.String.class, responsibleCd);
            __query.addParameter("retrievalKey", java.lang.String.class, retrievalKey);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("lastUpdTime", java.util.Date.class, lastUpdTime);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalDaoImpl");
            __query.setCallerMethodName("selectRetrievalByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalDaoImpl", "selectRetrievalByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalDaoImpl", "selectRetrievalByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAmrByEnpkstr(java.util.List<java.lang.String> enPkList) {
        entering("iih.dr.dao.custom.CusRetrievalDaoImpl", "selectAmrByEnpkstr", enPkList);
        try {
            if (enPkList == null) {
                throw new org.seasar.doma.DomaNullPointerException("enPkList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalDao/selectAmrByEnpkstr.sql");
            __query.addParameter("enPkList", java.util.List.class, enPkList);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalDaoImpl");
            __query.setCallerMethodName("selectAmrByEnpkstr");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalDaoImpl", "selectAmrByEnpkstr", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalDaoImpl", "selectAmrByEnpkstr", __e);
            throw __e;
        }
    }

}
