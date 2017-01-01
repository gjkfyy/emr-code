package pkuhit.iih.mr.tpl.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.723+0800")
public class CusGroupElementDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.tpl.dao.CusGroupElementDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusGroupElementDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.math.BigInteger selectMaxVersionByRootCode(java.lang.String rootCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectMaxVersionByRootCode", rootCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusGroupElementDao/selectMaxVersionByRootCode.sql");
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl");
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
            exiting("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectMaxVersionByRootCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectMaxVersionByRootCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrGe> selectGroupElementByRootcode(java.lang.String rootCode, java.lang.String orgCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElementByRootcode", rootCode, orgCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusGroupElementDao/selectGroupElementByRootcode.sql");
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl");
            __query.setCallerMethodName("selectGroupElementByRootcode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrGe>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrGe>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrGe>(pkuhit.iih.mr.dao.auto.entity._MrGe.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrGe> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElementByRootcode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElementByRootcode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat> selectGroupElementCategory(java.lang.String orgCd, java.lang.String ownTpCd, java.lang.String ownCd, java.lang.String typeCode, java.lang.String parentCode, java.lang.String keyword) {
        entering("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElementCategory", orgCd, ownTpCd, ownCd, typeCode, parentCode, keyword);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusGroupElementDao/selectGroupElementCategory.sql");
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("ownTpCd", java.lang.String.class, ownTpCd);
            __query.addParameter("ownCd", java.lang.String.class, ownCd);
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.addParameter("parentCode", java.lang.String.class, parentCode);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl");
            __query.setCallerMethodName("selectGroupElementCategory");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrGeCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElementCategory", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElementCategory", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat> selectCategory(java.lang.String orgCd, java.lang.String parentCode, java.lang.String keyword) {
        entering("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectCategory", orgCd, parentCode, keyword);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusGroupElementDao/selectCategory.sql");
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("parentCode", java.lang.String.class, parentCode);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl");
            __query.setCallerMethodName("selectCategory");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrGeCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectCategory", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectCategory", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrGe> selectGroupElement(java.lang.String orgCd, java.lang.String ownTpCd, java.lang.String ownCd, java.lang.String typeCode, java.lang.String categoryCd, java.lang.String statusCode, java.lang.String keyword, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElement", orgCd, ownTpCd, ownCd, typeCode, categoryCd, statusCode, keyword, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusGroupElementDao/selectGroupElement.sql");
            __query.setOptions(options);
            __query.addParameter("orgCd", java.lang.String.class, orgCd);
            __query.addParameter("ownTpCd", java.lang.String.class, ownTpCd);
            __query.addParameter("ownCd", java.lang.String.class, ownCd);
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.addParameter("categoryCd", java.lang.String.class, categoryCd);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl");
            __query.setCallerMethodName("selectGroupElement");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrGe>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrGe>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrGe>(pkuhit.iih.mr.dao.auto.entity._MrGe.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrGe> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElement", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusGroupElementDaoImpl", "selectGroupElement", __e);
            throw __e;
        }
    }

}
