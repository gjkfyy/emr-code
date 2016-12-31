package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.412+0800")
public class CusMdMrTpParaDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusMdMrTpParaDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMdMrTpParaDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> selectByMdMrTpCd(java.lang.String mdMrTpCd) {
        entering("pkuhit.iih.mr.wr.dao.CusMdMrTpParaDaoImpl", "selectByMdMrTpCd", mdMrTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusMdMrTpParaDao/selectByMdMrTpCd.sql");
            __query.addParameter("mdMrTpCd", java.lang.String.class, mdMrTpCd);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusMdMrTpParaDaoImpl");
            __query.setCallerMethodName("selectByMdMrTpCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara>(pkuhit.iih.mr.dao.auto.entity._MdMrTpPara.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusMdMrTpParaDaoImpl", "selectByMdMrTpCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusMdMrTpParaDaoImpl", "selectByMdMrTpCd", __e);
            throw __e;
        }
    }

}
