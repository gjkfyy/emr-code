package pkuhit.iih.mr.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.676+0800")
public class CusObserveReportCollectImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.dao.custom.CusObserveReportCollect {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusObserveReportCollectImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> selectByEnpk(java.lang.String enPk, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.dao.custom.CusObserveReportCollectImpl", "selectByEnpk", enPk, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/dao/custom/CusObserveReportCollect/selectByEnpk.sql");
            __query.setOptions(options);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.mr.dao.custom.CusObserveReportCollectImpl");
            __query.setCallerMethodName("selectByEnpk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity>(pkuhit.iih.mr.dao.auto.entity._ObsReportCollectEntity.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.dao.custom.CusObserveReportCollectImpl", "selectByEnpk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.dao.custom.CusObserveReportCollectImpl", "selectByEnpk", __e);
            throw __e;
        }
    }

}
