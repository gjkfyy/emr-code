package szlh.iih.lab.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.759+0800")
public class LabReportDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.lab.dao.LabReportDao {

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
    public java.util.List<szlh.iih.lab.po.LabReportPo> getLabByEnsn(java.lang.String enPk, java.lang.String patientId, java.lang.String times, org.seasar.doma.jdbc.SelectOptions options) {
        entering("szlh.iih.lab.dao.LabReportDaoImpl", "getLabByEnsn", enPk, patientId, times, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/lab/dao/LabReportDao/getLabByEnsn.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.addParameter("times", java.lang.String.class, times);
            __query.setCallerClassName("szlh.iih.lab.dao.LabReportDaoImpl");
            __query.setCallerMethodName("getLabByEnsn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.lab.po.LabReportPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.lab.po.LabReportPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.lab.po.LabReportPo>(szlh.iih.lab.po._LabReportPo.getSingletonInternal()));
            java.util.List<szlh.iih.lab.po.LabReportPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.lab.dao.LabReportDaoImpl", "getLabByEnsn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.lab.dao.LabReportDaoImpl", "getLabByEnsn", __e);
            throw __e;
        }
    }

    @Override
    public szlh.iih.lab.po.LabReportPo getLabByLabSn(java.lang.String labRpPk) {
        entering("szlh.iih.lab.dao.LabReportDaoImpl", "getLabByLabSn", labRpPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/lab/dao/LabReportDao/getLabByLabSn.sql");
            __query.addParameter("labRpPk", java.lang.String.class, labRpPk);
            __query.setCallerClassName("szlh.iih.lab.dao.LabReportDaoImpl");
            __query.setCallerMethodName("getLabByLabSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.lab.po.LabReportPo> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<szlh.iih.lab.po.LabReportPo>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<szlh.iih.lab.po.LabReportPo>(szlh.iih.lab.po._LabReportPo.getSingletonInternal()));
            szlh.iih.lab.po.LabReportPo __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.lab.dao.LabReportDaoImpl", "getLabByLabSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.lab.dao.LabReportDaoImpl", "getLabByLabSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<szlh.iih.lab.po.LabReportItemPo> getLabDetailItemListByReportId(java.lang.String labRpPk, org.seasar.doma.jdbc.SelectOptions options) {
        entering("szlh.iih.lab.dao.LabReportDaoImpl", "getLabDetailItemListByReportId", labRpPk, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/lab/dao/LabReportDao/getLabDetailItemListByReportId.sql");
            __query.setOptions(options);
            __query.addParameter("labRpPk", java.lang.String.class, labRpPk);
            __query.setCallerClassName("szlh.iih.lab.dao.LabReportDaoImpl");
            __query.setCallerMethodName("getLabDetailItemListByReportId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.lab.po.LabReportItemPo>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.lab.po.LabReportItemPo>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.lab.po.LabReportItemPo>(szlh.iih.lab.po._LabReportItemPo.getSingletonInternal()));
            java.util.List<szlh.iih.lab.po.LabReportItemPo> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.lab.dao.LabReportDaoImpl", "getLabDetailItemListByReportId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.lab.dao.LabReportDaoImpl", "getLabDetailItemListByReportId", __e);
            throw __e;
        }
    }

}
