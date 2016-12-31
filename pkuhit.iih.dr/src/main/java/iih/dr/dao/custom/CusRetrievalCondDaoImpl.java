package iih.dr.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:05.110+0800")
public class CusRetrievalCondDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.dr.dao.custom.CusRetrievalCondDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusRetrievalCondDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectRetrievalCondByRetrievalcd(java.lang.String retrievalCd, java.lang.String condCd, java.lang.String grade) {
        entering("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByRetrievalcd", retrievalCd, condCd, grade);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalCondDao/selectRetrievalCondByRetrievalcd.sql");
            __query.addParameter("retrievalCd", java.lang.String.class, retrievalCd);
            __query.addParameter("condCd", java.lang.String.class, condCd);
            __query.addParameter("grade", java.lang.String.class, grade);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalCondDaoImpl");
            __query.setCallerMethodName("selectRetrievalCondByRetrievalcd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByRetrievalcd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByRetrievalcd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectRetrievalCondByUpcond(java.lang.String upcond) {
        entering("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByUpcond", upcond);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalCondDao/selectRetrievalCondByUpcond.sql");
            __query.addParameter("upcond", java.lang.String.class, upcond);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalCondDaoImpl");
            __query.setCallerMethodName("selectRetrievalCondByUpcond");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByUpcond", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByUpcond", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectRetrievalCondByCondno(java.lang.String retrievalCd, int grade, java.lang.String upcond) {
        entering("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByCondno", retrievalCd, grade, upcond);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalCondDao/selectRetrievalCondByCondno.sql");
            __query.addParameter("retrievalCd", java.lang.String.class, retrievalCd);
            __query.addParameter("grade", int.class, grade);
            __query.addParameter("upcond", java.lang.String.class, upcond);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalCondDaoImpl");
            __query.setCallerMethodName("selectRetrievalCondByCondno");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByCondno", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectRetrievalCondByCondno", __e);
            throw __e;
        }
    }

    @Override
    public int selectMaxCondNoByRetrievalcd(java.lang.String retrievalCd) {
        entering("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectMaxCondNoByRetrievalcd", retrievalCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalCondDao/selectMaxCondNoByRetrievalcd.sql");
            __query.addParameter("retrievalCd", java.lang.String.class, retrievalCd);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalCondDaoImpl");
            __query.setCallerMethodName("selectMaxCondNoByRetrievalcd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectMaxCondNoByRetrievalcd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectMaxCondNoByRetrievalcd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectCondLogicByRetrieval(java.lang.String retrievalCd, java.lang.String enPk) {
        entering("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectCondLogicByRetrieval", retrievalCd, enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalCondDao/selectCondLogicByRetrieval.sql");
            __query.addParameter("retrievalCd", java.lang.String.class, retrievalCd);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalCondDaoImpl");
            __query.setCallerMethodName("selectCondLogicByRetrieval");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectCondLogicByRetrieval", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectCondLogicByRetrieval", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectBaseTemplate(java.lang.String xmlFilePk) {
        entering("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectBaseTemplate", xmlFilePk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/dr/dao/custom/CusRetrievalCondDao/selectBaseTemplate.sql");
            __query.addParameter("xmlFilePk", java.lang.String.class, xmlFilePk);
            __query.setCallerClassName("iih.dr.dao.custom.CusRetrievalCondDaoImpl");
            __query.setCallerMethodName("selectBaseTemplate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectBaseTemplate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.dr.dao.custom.CusRetrievalCondDaoImpl", "selectBaseTemplate", __e);
            throw __e;
        }
    }

}
