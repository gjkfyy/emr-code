package pkuhit.iih.qa.dao.qacustom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.009+0800")
public class CusQaAutoItmConfigDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaAutoItmConfigDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaAutoItmByCondition(java.lang.String qaItmCd, java.lang.String qaItmTpCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDaoImpl", "selectQaAutoItmByCondition", qaItmCd, qaItmTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoItmConfigDao/selectQaAutoItmByCondition.sql");
            __query.addParameter("qaItmCd", java.lang.String.class, qaItmCd);
            __query.addParameter("qaItmTpCd", java.lang.String.class, qaItmTpCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDaoImpl");
            __query.setCallerMethodName("selectQaAutoItmByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDaoImpl", "selectQaAutoItmByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDaoImpl", "selectQaAutoItmByCondition", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig selectByQaItmCd(java.lang.String qaItmCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDaoImpl", "selectByQaItmCd", qaItmCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaAutoItmConfigDao/selectByQaItmCd.sql");
            __query.addParameter("qaItmCd", java.lang.String.class, qaItmCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDaoImpl");
            __query.setCallerMethodName("selectByQaItmCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig>(pkuhit.iih.qa.dao.auto.entity._QaAutoItmConfig.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDaoImpl", "selectByQaItmCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDaoImpl", "selectByQaItmCd", __e);
            throw __e;
        }
    }

}
