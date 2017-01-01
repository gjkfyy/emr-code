package pkuhit.iih.mr.md.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:39.155+0800")
public class CusMdMrTpSignLvlDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.md.dao.custom.CusMdMrTpSignLvlDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMdMrTpSignLvlDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMrTpSignLvl selectByTpDi(java.lang.String deptCode, java.lang.String mrTypeCode, java.lang.String mainDiCode) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpSignLvlDaoImpl", "selectByTpDi", deptCode, mrTypeCode, mainDiCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpSignLvlDao/selectByTpDi.sql");
            __query.addParameter("deptCode", java.lang.String.class, deptCode);
            __query.addParameter("mrTypeCode", java.lang.String.class, mrTypeCode);
            __query.addParameter("mainDiCode", java.lang.String.class, mainDiCode);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpSignLvlDaoImpl");
            __query.setCallerMethodName("selectByTpDi");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpSignLvl> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpSignLvl>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpSignLvl>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpSignLvl.getSingletonInternal()));
            pkuhit.iih.mr.md.dao.auto.entity.MdMrTpSignLvl __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpSignLvlDaoImpl", "selectByTpDi", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpSignLvlDaoImpl", "selectByTpDi", __e);
            throw __e;
        }
    }

}
