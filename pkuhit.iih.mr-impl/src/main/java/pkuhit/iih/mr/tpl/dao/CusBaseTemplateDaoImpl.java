package pkuhit.iih.mr.tpl.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.276+0800")
public class CusBaseTemplateDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.tpl.dao.CusBaseTemplateDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusBaseTemplateDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.math.BigInteger selectMaxVersionByRootCode(java.lang.String rootCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "selectMaxVersionByRootCode", rootCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusBaseTemplateDao/selectMaxVersionByRootCode.sql");
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl");
            __query.setCallerMethodName("selectMaxVersionByRootCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.math.BigInteger> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.math.BigInteger>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.math.BigInteger>(new org.seasar.doma.wrapper.BigIntegerWrapper(), false));
            java.math.BigInteger __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "selectMaxVersionByRootCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "selectMaxVersionByRootCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrBaseTpl> selectAll(java.lang.String excludeDelete, java.util.List<java.lang.String> statusCode, java.lang.String name, java.lang.String rootCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "selectAll", excludeDelete, statusCode, name, rootCode, options);
        try {
            if (statusCode == null) {
                throw new org.seasar.doma.DomaNullPointerException("statusCode");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusBaseTemplateDao/selectAll.sql");
            __query.setOptions(options);
            __query.addParameter("excludeDelete", java.lang.String.class, excludeDelete);
            __query.addParameter("statusCode", java.util.List.class, statusCode);
            __query.addParameter("name", java.lang.String.class, name);
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrBaseTpl>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrBaseTpl>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrBaseTpl>(pkuhit.iih.mr.dao.auto.entity._MrBaseTpl.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrBaseTpl> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int getCountOfName(java.lang.String code, java.lang.String name) {
        entering("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "getCountOfName", code, name);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusBaseTemplateDao/getCountOfName.sql");
            __query.addParameter("code", java.lang.String.class, code);
            __query.addParameter("name", java.lang.String.class, name);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl");
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
            exiting("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "getCountOfName", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusBaseTemplateDaoImpl", "getCountOfName", __e);
            throw __e;
        }
    }

}
