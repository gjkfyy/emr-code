package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:39.086+0800")
public class CusFileDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusFileDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusFileDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> selectBizFileIsXml(java.lang.String paId, java.lang.String enCnt, java.util.List<java.lang.String> mrTpCds) {
        entering("pkuhit.iih.mr.wr.dao.CusFileDaoImpl", "selectBizFileIsXml", paId, enCnt, mrTpCds);
        try {
            if (mrTpCds == null) {
                throw new org.seasar.doma.DomaNullPointerException("mrTpCds");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusFileDao/selectBizFileIsXml.sql");
            __query.addParameter("paId", java.lang.String.class, paId);
            __query.addParameter("enCnt", java.lang.String.class, enCnt);
            __query.addParameter("mrTpCds", java.util.List.class, mrTpCds);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusFileDaoImpl");
            __query.setCallerMethodName("selectBizFileIsXml");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.Map<java.lang.String, java.lang.Object>>(__query, new org.seasar.doma.internal.jdbc.command.MapSingleResultHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.Map<java.lang.String, java.lang.Object> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusFileDaoImpl", "selectBizFileIsXml", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusFileDaoImpl", "selectBizFileIsXml", __e);
            throw __e;
        }
    }

}
