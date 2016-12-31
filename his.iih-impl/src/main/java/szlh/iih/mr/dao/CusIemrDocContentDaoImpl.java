package szlh.iih.mr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.696+0800")
public class CusIemrDocContentDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.mr.dao.CusIemrDocContentDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusIemrDocContentDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<szlh.iih.mr.po.IemrDocContent> selectByDocId(java.lang.String docId) {
        entering("szlh.iih.mr.dao.CusIemrDocContentDaoImpl", "selectByDocId", docId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/szlh/iih/mr/dao/CusIemrDocContentDao/selectByDocId.sql");
            __query.addParameter("docId", java.lang.String.class, docId);
            __query.setCallerClassName("szlh.iih.mr.dao.CusIemrDocContentDaoImpl");
            __query.setCallerMethodName("selectByDocId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.mr.po.IemrDocContent>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<szlh.iih.mr.po.IemrDocContent>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<szlh.iih.mr.po.IemrDocContent>(szlh.iih.mr.po._IemrDocContent.getSingletonInternal()));
            java.util.List<szlh.iih.mr.po.IemrDocContent> __result = __command.execute();
            __query.complete();
            exiting("szlh.iih.mr.dao.CusIemrDocContentDaoImpl", "selectByDocId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("szlh.iih.mr.dao.CusIemrDocContentDaoImpl", "selectByDocId", __e);
            throw __e;
        }
    }

}
