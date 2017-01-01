package pkuhit.me.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.490+0800")
public class DataObjectMetadataDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.me.dao.custom.DataObjectMetadataDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public DataObjectMetadataDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> selectAllMetadata() {
        entering("pkuhit.me.dao.custom.DataObjectMetadataDaoImpl", "selectAllMetadata");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/me/dao/custom/DataObjectMetadataDao/selectAllMetadata.sql");
            __query.setCallerClassName("pkuhit.me.dao.custom.DataObjectMetadataDaoImpl");
            __query.setCallerMethodName("selectAllMetadata");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata>(pkuhit.me.dao.custom.entity._ObjectAttributeMetadata.getSingletonInternal()));
            java.util.List<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.me.dao.custom.DataObjectMetadataDaoImpl", "selectAllMetadata", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.me.dao.custom.DataObjectMetadataDaoImpl", "selectAllMetadata", __e);
            throw __e;
        }
    }

}
