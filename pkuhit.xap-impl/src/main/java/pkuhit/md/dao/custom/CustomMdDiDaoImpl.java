package pkuhit.md.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.716+0800")
public class CustomMdDiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.md.dao.custom.CustomMdDiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomMdDiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.md.dao.auto.entity.MdDi> selectMdDiList(java.lang.String keyword) {
        entering("pkuhit.md.dao.custom.CustomMdDiDaoImpl", "selectMdDiList", keyword);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/md/dao/custom/CustomMdDiDao/selectMdDiList.sql");
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.setCallerClassName("pkuhit.md.dao.custom.CustomMdDiDaoImpl");
            __query.setCallerMethodName("selectMdDiList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(25);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.md.dao.auto.entity.MdDi>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.md.dao.auto.entity.MdDi>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.md.dao.auto.entity.MdDi>(pkuhit.md.dao.auto.entity._MdDi.getSingletonInternal()));
            java.util.List<pkuhit.md.dao.auto.entity.MdDi> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.md.dao.custom.CustomMdDiDaoImpl", "selectMdDiList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.md.dao.custom.CustomMdDiDaoImpl", "selectMdDiList", __e);
            throw __e;
        }
    }

}
