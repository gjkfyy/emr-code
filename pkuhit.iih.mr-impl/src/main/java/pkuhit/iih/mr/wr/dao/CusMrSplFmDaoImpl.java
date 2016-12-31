package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.257+0800")
public class CusMrSplFmDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusMrSplFmDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrSplFmDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrSplFm> selectAll(java.lang.String enPk, int fmType, java.lang.String fmName) {
        entering("pkuhit.iih.mr.wr.dao.CusMrSplFmDaoImpl", "selectAll", enPk, fmType, fmName);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMrSplFmDao/selectAll.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("fmType", int.class, fmType);
            __query.addParameter("fmName", java.lang.String.class, fmName);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMrSplFmDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrSplFm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrSplFm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrSplFm>(pkuhit.iih.mr.dao.auto.entity._MrSplFm.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrSplFm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMrSplFmDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMrSplFmDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

}
