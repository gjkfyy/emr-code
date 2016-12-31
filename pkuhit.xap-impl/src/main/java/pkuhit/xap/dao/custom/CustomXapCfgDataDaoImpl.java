package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.764+0800")
public class CustomXapCfgDataDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapCfgDataDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapCfgDataDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapCfgData> selectCfgDataList(java.lang.String orgCd, java.lang.String cfgCd) {
        entering("pkuhit.xap.dao.custom.CustomXapCfgDataDaoImpl", "selectCfgDataList", orgCd, cfgCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapCfgDataDao/selectCfgDataList.sql");
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("cfgCd", java.lang.String.class, cfgCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapCfgDataDaoImpl");
            __query.setCallerMethodName("selectCfgDataList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapCfgData>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapCfgData>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapCfgData>(pkuhit.xap.dao.auto.entity._XapCfgData.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapCfgData> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapCfgDataDaoImpl", "selectCfgDataList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapCfgDataDaoImpl", "selectCfgDataList", __e);
            throw __e;
        }
    }

}
