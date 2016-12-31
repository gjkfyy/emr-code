package ei.lis.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.811+0800")
public class LabReportDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.lis.db.dao.LabReportDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public LabReportDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<ei.lis.db.dao.po.LabReportPo> getLabByEnsn(java.lang.String paId, java.lang.String enCnt) {
        entering("ei.lis.db.dao.LabReportDaoImpl", "getLabByEnsn", paId, enCnt);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/lis/db/dao/LabReportDao/getLabByEnsn.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.addParameter("enCnt", java.lang.String.class, enCnt);
            __query.setCallerClassName("ei.lis.db.dao.LabReportDaoImpl");
            __query.setCallerMethodName("getLabByEnsn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.lis.db.dao.po.LabReportPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.lis.db.dao.po.LabReportPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.lis.db.dao.po.LabReportPo>(ei.lis.db.dao.po._LabReportPo.getSingletonInternal()));
            java.util.List<ei.lis.db.dao.po.LabReportPo> __result = __command.execute();
            __query.complete();
            exiting("ei.lis.db.dao.LabReportDaoImpl", "getLabByEnsn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.lis.db.dao.LabReportDaoImpl", "getLabByEnsn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<ei.lis.db.dao.po.LabReportPo> getLabByEnpk(java.lang.String enPk) {
        entering("ei.lis.db.dao.LabReportDaoImpl", "getLabByEnpk", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/lis/db/dao/LabReportDao/getLabByEnpk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("ei.lis.db.dao.LabReportDaoImpl");
            __query.setCallerMethodName("getLabByEnpk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.lis.db.dao.po.LabReportPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.lis.db.dao.po.LabReportPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.lis.db.dao.po.LabReportPo>(ei.lis.db.dao.po._LabReportPo.getSingletonInternal()));
            java.util.List<ei.lis.db.dao.po.LabReportPo> __result = __command.execute();
            __query.complete();
            exiting("ei.lis.db.dao.LabReportDaoImpl", "getLabByEnpk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.lis.db.dao.LabReportDaoImpl", "getLabByEnpk", __e);
            throw __e;
        }
    }

    @Override
    public ei.lis.db.dao.po.LabReportPo getLabByLabSn(java.lang.String labRpPk) {
        entering("ei.lis.db.dao.LabReportDaoImpl", "getLabByLabSn", labRpPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/lis/db/dao/LabReportDao/getLabByLabSn.sql");
            __query.addParameter("labRpPk", java.lang.String.class, labRpPk);
            __query.setCallerClassName("ei.lis.db.dao.LabReportDaoImpl");
            __query.setCallerMethodName("getLabByLabSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<ei.lis.db.dao.po.LabReportPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<ei.lis.db.dao.po.LabReportPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<ei.lis.db.dao.po.LabReportPo>(ei.lis.db.dao.po._LabReportPo.getSingletonInternal()));
            ei.lis.db.dao.po.LabReportPo __result = __command.execute();
            __query.complete();
            exiting("ei.lis.db.dao.LabReportDaoImpl", "getLabByLabSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.lis.db.dao.LabReportDaoImpl", "getLabByLabSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<ei.lis.db.dao.po.LabReportItemPo> getLabDetailItemListByReportId(java.lang.String labRpPk) {
        entering("ei.lis.db.dao.LabReportDaoImpl", "getLabDetailItemListByReportId", labRpPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/lis/db/dao/LabReportDao/getLabDetailItemListByReportId.sql");
            __query.addParameter("labRpPk", java.lang.String.class, labRpPk);
            __query.setCallerClassName("ei.lis.db.dao.LabReportDaoImpl");
            __query.setCallerMethodName("getLabDetailItemListByReportId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.lis.db.dao.po.LabReportItemPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<ei.lis.db.dao.po.LabReportItemPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<ei.lis.db.dao.po.LabReportItemPo>(ei.lis.db.dao.po._LabReportItemPo.getSingletonInternal()));
            java.util.List<ei.lis.db.dao.po.LabReportItemPo> __result = __command.execute();
            __query.complete();
            exiting("ei.lis.db.dao.LabReportDaoImpl", "getLabDetailItemListByReportId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.lis.db.dao.LabReportDaoImpl", "getLabDetailItemListByReportId", __e);
            throw __e;
        }
    }

}
