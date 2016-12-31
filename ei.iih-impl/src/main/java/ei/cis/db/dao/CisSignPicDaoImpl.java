package ei.cis.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.752+0800")
public class CisSignPicDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.cis.db.dao.CisSignPicDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CisSignPicDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.sql.Blob selectUserImg(java.lang.String empSn) {
        entering("ei.cis.db.dao.CisSignPicDaoImpl", "selectUserImg", empSn);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisSignPicDao/selectUserImg.sql");
            __query.addParameter("empSn", java.lang.String.class, empSn);
            __query.setCallerClassName("ei.cis.db.dao.CisSignPicDaoImpl");
            __query.setCallerMethodName("selectUserImg");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.sql.Blob> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.sql.Blob>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.sql.Blob>(new org.seasar.doma.wrapper.BlobWrapper(), false));
            java.sql.Blob __result = __command.execute();
            __query.complete();
            exiting("ei.cis.db.dao.CisSignPicDaoImpl", "selectUserImg", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisSignPicDaoImpl", "selectUserImg", __e);
            throw __e;
        }
    }

}
