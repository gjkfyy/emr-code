package pkuhit.iih.mr.tpl.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:39.267+0800")
public class CusFrTplDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.tpl.dao.CusFrTplDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusFrTplDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrFrTpl> selectAll(java.lang.String excludeDelete, java.lang.String name, java.lang.String mrFrTplCd, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "selectAll", excludeDelete, name, mrFrTplCd, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusFrTplDao/selectAll.sql");
            __query.setOptions(options);
            __query.addParameter("excludeDelete", java.lang.String.class, excludeDelete);
            __query.addParameter("name", java.lang.String.class, name);
            __query.addParameter("mrFrTplCd", java.lang.String.class, mrFrTplCd);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrFrTpl>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrFrTpl>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrFrTpl>(pkuhit.iih.mr.dao.auto.entity._MrFrTpl.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrFrTpl> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int getCountOfName(java.lang.String code, java.lang.String name) {
        entering("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "getCountOfName", code, name);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusFrTplDao/getCountOfName.sql");
            __query.addParameter("code", java.lang.String.class, code);
            __query.addParameter("name", java.lang.String.class, name);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl");
            __query.setCallerMethodName("getCountOfName");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "getCountOfName", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "getCountOfName", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrFrTplTree(java.lang.String keyword, java.lang.String mrFrTplTpCd) {
        entering("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "selectMrFrTplTree", keyword, mrFrTplTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusFrTplDao/selectMrFrTplTree.sql");
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("mrFrTplTpCd", java.lang.String.class, mrFrTplTpCd);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl");
            __query.setCallerMethodName("selectMrFrTplTree");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "selectMrFrTplTree", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusFrTplDaoImpl", "selectMrFrTplTree", __e);
            throw __e;
        }
    }

}
