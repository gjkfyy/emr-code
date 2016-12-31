package ei.cis.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.725+0800")
public class CisMzClinicRoomConfigDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.cis.db.dao.CisMzClinicRoomConfigDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CisMzClinicRoomConfigDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectOrgByIp(java.lang.String ip) {
        entering("ei.cis.db.dao.CisMzClinicRoomConfigDaoImpl", "selectOrgByIp", ip);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisMzClinicRoomConfigDao/selectOrgByIp.sql");
            __query.addParameter("ip", java.lang.String.class, ip);
            __query.setCallerClassName("ei.cis.db.dao.CisMzClinicRoomConfigDaoImpl");
            __query.setCallerMethodName("selectOrgByIp");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.cis.db.dao.CisMzClinicRoomConfigDaoImpl", "selectOrgByIp", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisMzClinicRoomConfigDaoImpl", "selectOrgByIp", __e);
            throw __e;
        }
    }

}
