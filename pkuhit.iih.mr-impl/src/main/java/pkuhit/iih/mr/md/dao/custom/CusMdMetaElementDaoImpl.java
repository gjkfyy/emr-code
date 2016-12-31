package pkuhit.iih.mr.md.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.518+0800")
public class CusMdMetaElementDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMdMetaElementDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> selectByMetaElementNm(java.lang.String metaElementNm, java.lang.String spellNo) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "selectByMetaElementNm", metaElementNm, spellNo);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMetaElementDao/selectByMetaElementNm.sql");
            __query.addParameter("metaElementNm", java.lang.String.class, metaElementNm);
            __query.addParameter("spellNo", java.lang.String.class, spellNo);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl");
            __query.setCallerMethodName("selectByMetaElementNm");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElement.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "selectByMetaElementNm", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "selectByMetaElementNm", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> selectByMetaElementNmOrSpellNo(java.lang.String cond, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "selectByMetaElementNmOrSpellNo", cond, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMetaElementDao/selectByMetaElementNmOrSpellNo.sql");
            __query.setOptions(options);
            __query.addParameter("cond", java.lang.String.class, cond);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl");
            __query.setCallerMethodName("selectByMetaElementNmOrSpellNo");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElement.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "selectByMetaElementNmOrSpellNo", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "selectByMetaElementNmOrSpellNo", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String getNewSn() {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "getNewSn");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMetaElementDao/getNewSn.sql");
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl");
            __query.setCallerMethodName("getNewSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "getNewSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDaoImpl", "getNewSn", __e);
            throw __e;
        }
    }

}
