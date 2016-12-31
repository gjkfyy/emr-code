package pkuhit.iih.qa.dao.qacustom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.090+0800")
public class CusQaFltItmDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.qa.dao.qacustom.CusQaFltItmDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusQaFltItmDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItmFst> selectQaFltItm() {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaFltItm");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaFltItmDao/selectQaFltItm.sql");
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl");
            __query.setCallerMethodName("selectQaFltItm");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItmFst>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItmFst>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaItmFst>(pkuhit.iih.qa.dao.auto.entity._QaItmFst.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItmFst> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaFltItm", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaFltItm", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItmSnd> selectQaSndItm(java.lang.String amrScoreCode) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaSndItm", amrScoreCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaFltItmDao/selectQaSndItm.sql");
            __query.addParameter("amrScoreCode", java.lang.String.class, amrScoreCode);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl");
            __query.setCallerMethodName("selectQaSndItm");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItmSnd>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItmSnd>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.qa.dao.auto.entity.QaItmSnd>(pkuhit.iih.qa.dao.auto.entity._QaItmSnd.getSingletonInternal()));
            java.util.List<pkuhit.iih.qa.dao.auto.entity.QaItmSnd> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaSndItm", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaSndItm", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaItmFst selectQaItmFstByNm(java.lang.String nm) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaItmFstByNm", nm);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaFltItmDao/selectQaItmFstByNm.sql");
            __query.addParameter("nm", java.lang.String.class, nm);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl");
            __query.setCallerMethodName("selectQaItmFstByNm");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItmFst> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItmFst>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaItmFst>(pkuhit.iih.qa.dao.auto.entity._QaItmFst.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaItmFst __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaItmFstByNm", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaItmFstByNm", __e);
            throw __e;
        }
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaItmSnd selectQaItmSndByNm(java.lang.String nm) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaItmSndByNm", nm);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaFltItmDao/selectQaItmSndByNm.sql");
            __query.addParameter("nm", java.lang.String.class, nm);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl");
            __query.setCallerMethodName("selectQaItmSndByNm");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItmSnd> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.qa.dao.auto.entity.QaItmSnd>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.qa.dao.auto.entity.QaItmSnd>(pkuhit.iih.qa.dao.auto.entity._QaItmSnd.getSingletonInternal()));
            pkuhit.iih.qa.dao.auto.entity.QaItmSnd __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaItmSndByNm", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectQaItmSndByNm", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.Integer selectCountQaFltByEnPk(java.lang.String qaTyCd, java.lang.String enPk) {
        entering("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectCountQaFltByEnPk", qaTyCd, enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/qa/dao/qacustom/CusQaFltItmDao/selectCountQaFltByEnPk.sql");
            __query.addParameter("qaTyCd", java.lang.String.class, qaTyCd);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl");
            __query.setCallerMethodName("selectCountQaFltByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), false));
            java.lang.Integer __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectCountQaFltByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.qa.dao.qacustom.CusQaFltItmDaoImpl", "selectCountQaFltByEnPk", __e);
            throw __e;
        }
    }

}
