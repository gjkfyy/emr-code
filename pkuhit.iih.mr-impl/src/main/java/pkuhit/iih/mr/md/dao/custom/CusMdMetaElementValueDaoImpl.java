package pkuhit.iih.mr.md.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.398+0800")
public class CusMdMetaElementValueDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMdMetaElementValueDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> selectByDataElementCd(java.lang.String dataElementCd) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "selectByDataElementCd", dataElementCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMetaElementValueDao/selectByDataElementCd.sql");
            __query.addParameter("dataElementCd", java.lang.String.class, dataElementCd);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl");
            __query.setCallerMethodName("selectByDataElementCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue>(pkuhit.iih.mr.md.dao.auto.entity._MdMetaElementValue.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "selectByDataElementCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "selectByDataElementCd", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String getNewSn() {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "getNewSn");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMetaElementValueDao/getNewSn.sql");
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl");
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
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "getNewSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "getNewSn", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String getMaxDimenValueCode(java.lang.String dataElementCd) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "getMaxDimenValueCode", dataElementCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMetaElementValueDao/getMaxDimenValueCode.sql");
            __query.addParameter("dataElementCd", java.lang.String.class, dataElementCd);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl");
            __query.setCallerMethodName("getMaxDimenValueCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "getMaxDimenValueCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDaoImpl", "getMaxDimenValueCode", __e);
            throw __e;
        }
    }

}
