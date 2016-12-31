package pkuhit.iih.qa.dao.qacustom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.614+0800")
public class CusQaDivideDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.qacustom.CusQaDivideDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaDivideDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaDivideByCondition(java.lang.String encounterPk, java.lang.String qaTypeCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivideByCondition", encounterPk, qaTypeCode, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaDivideDao/selectQaDivideByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("encounterPk", java.lang.String.class, encounterPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl");
            __query.setCallerMethodName("selectQaDivideByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivideByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivideByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaDivide(java.lang.String encounterPk, java.lang.String qaTypeCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivide", encounterPk, qaTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaDivideDao/selectQaDivide.sql");
            __query.addParameter("encounterPk", java.lang.String.class, encounterPk);
            __query.addParameter("qaTypeCode", java.lang.String.class, qaTypeCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl");
            __query.setCallerMethodName("selectQaDivide");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivide", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivide", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectQaDivideLevel() {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivideLevel");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaDivideDao/selectQaDivideLevel.sql");
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl");
            __query.setCallerMethodName("selectQaDivideLevel");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivideLevel", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectQaDivideLevel", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaDivideLevel selectLevelById(java.lang.String qaDivideLevelCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectLevelById", qaDivideLevelCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaDivideDao/selectLevelById.sql");
            __query.addParameter("qaDivideLevelCd", java.lang.String.class, qaDivideLevelCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl");
            __query.setCallerMethodName("selectLevelById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaDivideLevel> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaDivideLevel>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaDivideLevel>(pkuhit.iih.qa.dao.auto.entity._QaDivideLevel.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaDivideLevel __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectLevelById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectLevelById", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaItmFst selectFstById(java.lang.String fstCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectFstById", fstCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaDivideDao/selectFstById.sql");
            __query.addParameter("fstCd", java.lang.String.class, fstCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl");
            __query.setCallerMethodName("selectFstById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItmFst> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItmFst>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaItmFst>(pkuhit.iih.qa.dao.auto.entity._QaItmFst.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaItmFst __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectFstById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectFstById", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaItmSnd selectSndById(java.lang.String sndCd) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectSndById", sndCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaDivideDao/selectSndById.sql");
            __query.addParameter("sndCd", java.lang.String.class, sndCd);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl");
            __query.setCallerMethodName("selectSndById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItmSnd> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItmSnd>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaItmSnd>(pkuhit.iih.qa.dao.auto.entity._QaItmSnd.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaItmSnd __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectSndById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaDivideDaoImpl", "selectSndById", __e);
            throw __e;
        }
    }

}
