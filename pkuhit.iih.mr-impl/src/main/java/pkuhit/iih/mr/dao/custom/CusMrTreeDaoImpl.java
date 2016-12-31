package pkuhit.iih.mr.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.218+0800")
public class CusMrTreeDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.dao.custom.CusMrTreeDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMrTreeDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> selectMrCustCategory() {
        entering("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectMrCustCategory");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/dao/custom/CusMrTreeDao/selectMrCustCategory.sql");
            __query.setCallerClassName("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl");
            __query.setCallerMethodName("selectMrCustCategory");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectMrCustCategory", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectMrCustCategory", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> selectMr(java.lang.String encounterCode, java.lang.String custCategoryCode) {
        entering("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectMr", encounterCode, custCategoryCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/dao/custom/CusMrTreeDao/selectMr.sql");
            __query.addParameter("encounterCode", java.lang.String.class, encounterCode);
            __query.addParameter("custCategoryCode", java.lang.String.class, custCategoryCode);
            __query.setCallerClassName("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl");
            __query.setCallerMethodName("selectMr");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.Mr>(pkuhit.iih.mr.dao.auto.entity._Mr.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.Mr> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectMr", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectMr", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> selectTemplateCategory() {
        entering("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectTemplateCategory");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/dao/custom/CusMrTreeDao/selectTemplateCategory.sql");
            __query.setCallerClassName("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl");
            __query.setCallerMethodName("selectTemplateCategory");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectTemplateCategory", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.dao.custom.CusMrTreeDaoImpl", "selectTemplateCategory", __e);
            throw __e;
        }
    }

}
