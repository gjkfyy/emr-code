package iih.dr.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:05.118+0800")
public class CusRetrievalResultDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.dr.dao.custom.CusRetrievalResultDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusRetrievalResultDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectRetrievalAmrByCondition(java.util.Date lastUpdTime) {
        entering("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectRetrievalAmrByCondition", lastUpdTime);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalResultDao/selectRetrievalAmrByCondition.sql");
            __query.addParameter("lastUpdTime", java.util.Date.class, lastUpdTime);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalResultDaoImpl");
            __query.setCallerMethodName("selectRetrievalAmrByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectRetrievalAmrByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectRetrievalAmrByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectResultLastUpdTime() {
        entering("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectResultLastUpdTime");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalResultDao/selectResultLastUpdTime.sql");
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalResultDaoImpl");
            __query.setCallerMethodName("selectResultLastUpdTime");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectResultLastUpdTime", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectResultLastUpdTime", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectResultByRetrievalCd(java.lang.String retrievalCd) {
        entering("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectResultByRetrievalCd", retrievalCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalResultDao/selectResultByRetrievalCd.sql");
            __query.addParameter("retrievalCd", java.lang.String.class, retrievalCd);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalResultDaoImpl");
            __query.setCallerMethodName("selectResultByRetrievalCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectResultByRetrievalCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectResultByRetrievalCd", __e);
            throw __e;
        }
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrievalResult selectByResultCd(java.lang.String resultCd) {
        entering("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectByResultCd", resultCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalResultDao/selectByResultCd.sql");
            __query.addParameter("resultCd", java.lang.String.class, resultCd);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalResultDaoImpl");
            __query.setCallerMethodName("selectByResultCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<iih.dr.dao.auto.entity.IemrRetrievalResult> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<iih.dr.dao.auto.entity.IemrRetrievalResult>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<iih.dr.dao.auto.entity.IemrRetrievalResult>(iih.dr.dao.auto.entity._IemrRetrievalResult.getSingletonInternal()));
            iih.dr.dao.auto.entity.IemrRetrievalResult __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectByResultCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalResultDaoImpl", "selectByResultCd", __e);
            throw __e;
        }
    }

}
