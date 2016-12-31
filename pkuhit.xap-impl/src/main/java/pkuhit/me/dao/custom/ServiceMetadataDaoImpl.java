package pkuhit.me.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.687+0800")
public class ServiceMetadataDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.me.dao.custom.ServiceMetadataDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ServiceMetadataDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeXsv selectMetadataByRestInfo(java.lang.String restPattern, java.lang.String method) {
        entering("pkuhit.me.dao.custom.ServiceMetadataDaoImpl", "selectMetadataByRestInfo", restPattern, method);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/me/dao/custom/ServiceMetadataDao/selectMetadataByRestInfo.sql");
            __query.addParameter("restPattern", java.lang.String.class, restPattern);
            __query.addParameter("method", java.lang.String.class, method);
            __query.setCallerClassName("pkuhit.me.dao.custom.ServiceMetadataDaoImpl");
            __query.setCallerMethodName("selectMetadataByRestInfo");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.me.dao.auto.entity.MeXsv> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.me.dao.auto.entity.MeXsv>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.me.dao.auto.entity.MeXsv>(pkuhit.me.dao.auto.entity._MeXsv.getSingletonInternal()));
            pkuhit.me.dao.auto.entity.MeXsv __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.custom.ServiceMetadataDaoImpl", "selectMetadataByRestInfo", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.custom.ServiceMetadataDaoImpl", "selectMetadataByRestInfo", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.me.dao.auto.entity.MeXsv> selectAllMetadata() {
        entering("pkuhit.me.dao.custom.ServiceMetadataDaoImpl", "selectAllMetadata");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/me/dao/custom/ServiceMetadataDao/selectAllMetadata.sql");
            __query.setCallerClassName("pkuhit.me.dao.custom.ServiceMetadataDaoImpl");
            __query.setCallerMethodName("selectAllMetadata");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.me.dao.auto.entity.MeXsv>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.me.dao.auto.entity.MeXsv>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.me.dao.auto.entity.MeXsv>(pkuhit.me.dao.auto.entity._MeXsv.getSingletonInternal()));
            java.util.List<pkuhit.me.dao.auto.entity.MeXsv> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.custom.ServiceMetadataDaoImpl", "selectAllMetadata", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.custom.ServiceMetadataDaoImpl", "selectAllMetadata", __e);
            throw __e;
        }
    }

}
