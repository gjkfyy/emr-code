package pkuhit.iih.mr.tpl.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.969+0800")
public class CusTemplateDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.tpl.dao.CusTemplateDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusTemplateDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.math.BigInteger selectMaxVersionByRootCode(java.lang.String rootCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMaxVersionByRootCode", rootCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/selectMaxVersionByRootCode.sql");
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
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
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMaxVersionByRootCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMaxVersionByRootCode", __e);
            throw __e;
        }
    }

    @Override
    public int getCountOfName(java.lang.String orgCode, java.lang.String code, java.lang.String name, java.lang.String ownDeptCd) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountOfName", orgCode, code, name, ownDeptCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getCountOfName.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("code", java.lang.String.class, code);
            __query.addParameter("name", java.lang.String.class, name);
            __query.addParameter("ownDeptCd", java.lang.String.class, ownDeptCd);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
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
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountOfName", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountOfName", __e);
            throw __e;
        }
    }

    @Override
    public int getCounts() {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCounts");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getCounts.sql");
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getCounts");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCounts", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCounts", __e);
            throw __e;
        }
    }

    @Override
    public int getMaxSortNo() {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMaxSortNo");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getMaxSortNo.sql");
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getMaxSortNo");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMaxSortNo", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMaxSortNo", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> selectAll(java.util.List<java.lang.String> codeList, java.lang.String excludeDelete, java.util.List<java.lang.String> statusCode, java.lang.String name, java.lang.String rootCode, java.lang.String orgCode, java.lang.String ownerTypeCode, java.util.List<java.lang.String> ownerCode, java.util.List<java.lang.String> typeCode, java.lang.String baseTemplateCode, java.lang.String enTypeCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAll", codeList, excludeDelete, statusCode, name, rootCode, orgCode, ownerTypeCode, ownerCode, typeCode, baseTemplateCode, enTypeCode, options);
        try {
            if (codeList == null) {
                throw new org.seasar.doma.DomaNullPointerException("codeList");
            }
            if (statusCode == null) {
                throw new org.seasar.doma.DomaNullPointerException("statusCode");
            }
            if (ownerCode == null) {
                throw new org.seasar.doma.DomaNullPointerException("ownerCode");
            }
            if (typeCode == null) {
                throw new org.seasar.doma.DomaNullPointerException("typeCode");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/selectAll.sql");
            __query.setOptions(options);
            __query.addParameter("codeList", java.util.List.class, codeList);
            __query.addParameter("excludeDelete", java.lang.String.class, excludeDelete);
            __query.addParameter("statusCode", java.util.List.class, statusCode);
            __query.addParameter("name", java.lang.String.class, name);
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerTypeCode", java.lang.String.class, ownerTypeCode);
            __query.addParameter("ownerCode", java.util.List.class, ownerCode);
            __query.addParameter("typeCode", java.util.List.class, typeCode);
            __query.addParameter("baseTemplateCode", java.lang.String.class, baseTemplateCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTpl>(pkuhit.iih.mr.dao.auto.entity._MrTpl.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAllToUse(java.lang.String orgCode, java.lang.String name, java.lang.String ownerTypeCode, java.util.List<java.lang.String> ownerCode, java.util.List<java.lang.String> typeCode, java.lang.String enTypeCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAllToUse", orgCode, name, ownerTypeCode, ownerCode, typeCode, enTypeCode, options);
        try {
            if (ownerCode == null) {
                throw new org.seasar.doma.DomaNullPointerException("ownerCode");
            }
            if (typeCode == null) {
                throw new org.seasar.doma.DomaNullPointerException("typeCode");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/selectAllToUse.sql");
            __query.setOptions(options);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("name", java.lang.String.class, name);
            __query.addParameter("ownerTypeCode", java.lang.String.class, ownerTypeCode);
            __query.addParameter("ownerCode", java.util.List.class, ownerCode);
            __query.addParameter("typeCode", java.util.List.class, typeCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("selectAllToUse");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAllToUse", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAllToUse", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getCountByOrg(java.lang.String orgCode, java.util.List<java.lang.String> owerCodes, java.lang.String keyWord, java.lang.String enTypeCode, java.util.List<java.lang.String> scTemplateTypeCode, java.lang.String statusCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByOrg", orgCode, owerCodes, keyWord, enTypeCode, scTemplateTypeCode, statusCode);
        try {
            if (owerCodes == null) {
                throw new org.seasar.doma.DomaNullPointerException("owerCodes");
            }
            if (scTemplateTypeCode == null) {
                throw new org.seasar.doma.DomaNullPointerException("scTemplateTypeCode");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getCountByOrg.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("owerCodes", java.util.List.class, owerCodes);
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.addParameter("scTemplateTypeCode", java.util.List.class, scTemplateTypeCode);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getCountByOrg");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByOrg", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByOrg", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getCountOfMrTlCategoryByOwner(java.lang.String orgCode, java.lang.String ownerCode, java.lang.String keyWord, java.lang.String enTypeCode, java.lang.String scTemplateCategoryCode, java.lang.String scTemplateTypeCode, java.lang.String statusCode, java.lang.String dctNsF) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountOfMrTlCategoryByOwner", orgCode, ownerCode, keyWord, enTypeCode, scTemplateCategoryCode, scTemplateTypeCode, statusCode, dctNsF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getCountOfMrTlCategoryByOwner.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.addParameter("scTemplateCategoryCode", java.lang.String.class, scTemplateCategoryCode);
            __query.addParameter("scTemplateTypeCode", java.lang.String.class, scTemplateTypeCode);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getCountOfMrTlCategoryByOwner");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountOfMrTlCategoryByOwner", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountOfMrTlCategoryByOwner", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getCountByMrTlCategoryByCategory(java.lang.String orgCode, java.lang.String ownerCode, java.lang.String mrCategoryCode, java.lang.String keyWord, java.lang.String enTypeCode, java.lang.String dctNsF) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByCategory", orgCode, ownerCode, mrCategoryCode, keyWord, enTypeCode, dctNsF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getCountByMrTlCategoryByCategory.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("mrCategoryCode", java.lang.String.class, mrCategoryCode);
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getCountByMrTlCategoryByCategory");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByCategory", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByCategory", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getCountByMrTlCategoryByLeafCategory(java.lang.String orgCode, java.lang.String ownerCode, java.lang.String mrCategoryCode, java.lang.String keyWord, java.lang.String enTypeCode, java.lang.String scTemplateTypeCode, java.lang.String statusCode, java.lang.String dctNsF) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByLeafCategory", orgCode, ownerCode, mrCategoryCode, keyWord, enTypeCode, scTemplateTypeCode, statusCode, dctNsF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getCountByMrTlCategoryByLeafCategory.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("mrCategoryCode", java.lang.String.class, mrCategoryCode);
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.addParameter("scTemplateTypeCode", java.lang.String.class, scTemplateTypeCode);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getCountByMrTlCategoryByLeafCategory");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByLeafCategory", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByLeafCategory", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> getMrTlByLeafCategory(java.lang.String orgCode, java.lang.String ownerCode, java.lang.String mrCategoryCode, java.lang.String keyWord, java.lang.String enTypeCode, java.lang.String scTemplateTypeCode, java.lang.String statusCode, java.lang.String dctNsF) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMrTlByLeafCategory", orgCode, ownerCode, mrCategoryCode, keyWord, enTypeCode, scTemplateTypeCode, statusCode, dctNsF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getMrTlByLeafCategory.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("mrCategoryCode", java.lang.String.class, mrCategoryCode);
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.addParameter("scTemplateTypeCode", java.lang.String.class, scTemplateTypeCode);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getMrTlByLeafCategory");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTpl>(pkuhit.iih.mr.dao.auto.entity._MrTpl.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMrTlByLeafCategory", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMrTlByLeafCategory", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> getCountByMrTlCategoryByType(java.lang.String orgCode, java.lang.String ownerCode, java.lang.String TypeCode, java.lang.String keyWord, java.lang.String enTypeCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByType", orgCode, ownerCode, TypeCode, keyWord, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getCountByMrTlCategoryByType.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("TypeCode", java.lang.String.class, TypeCode);
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getCountByMrTlCategoryByType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTpl>(pkuhit.iih.mr.dao.auto.entity._MrTpl.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getCountByMrTlCategoryByType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> getMrTemplate(java.lang.String ownerCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMrTemplate", ownerCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getMrTemplate.sql");
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getMrTemplate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTpl>(pkuhit.iih.mr.dao.auto.entity._MrTpl.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMrTemplate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getMrTemplate", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> getDefaultTemplate(java.lang.String ownerCode, java.lang.String ownerTypeCode, java.lang.String mrTypeCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getDefaultTemplate", ownerCode, ownerTypeCode, mrTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/getDefaultTemplate.sql");
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("ownerTypeCode", java.lang.String.class, ownerTypeCode);
            __query.addParameter("mrTypeCode", java.lang.String.class, mrTypeCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("getDefaultTemplate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.MrTpl>(pkuhit.iih.mr.dao.auto.entity._MrTpl.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.MrTpl> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getDefaultTemplate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "getDefaultTemplate", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectAllToCreate(java.lang.String name, java.lang.String hospitalArea, java.lang.String departCode, java.lang.String userCode, java.lang.String mrCategoryCode, java.lang.String typeCode) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAllToCreate", name, hospitalArea, departCode, userCode, mrCategoryCode, typeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/selectAllToCreate.sql");
            __query.addParameter("name", java.lang.String.class, name);
            __query.addParameter("hospitalArea", java.lang.String.class, hospitalArea);
            __query.addParameter("departCode", java.lang.String.class, departCode);
            __query.addParameter("userCode", java.lang.String.class, userCode);
            __query.addParameter("mrCategoryCode", java.lang.String.class, mrCategoryCode);
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("selectAllToCreate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAllToCreate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectAllToCreate", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrTemplateTreeData(java.lang.String mrTplCCat, java.lang.String mrTplTypeCd, java.lang.String mrTplStatCd, java.lang.String keyWord, java.lang.String enTypeCode, java.lang.String dctNsF, java.lang.String orgCode, java.lang.String userId) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMrTemplateTreeData", mrTplCCat, mrTplTypeCd, mrTplStatCd, keyWord, enTypeCode, dctNsF, orgCode, userId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/selectMrTemplateTreeData.sql");
            __query.addParameter("mrTplCCat", java.lang.String.class, mrTplCCat);
            __query.addParameter("mrTplTypeCd", java.lang.String.class, mrTplTypeCd);
            __query.addParameter("mrTplStatCd", java.lang.String.class, mrTplStatCd);
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("selectMrTemplateTreeData");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMrTemplateTreeData", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMrTemplateTreeData", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectMrTplList(java.lang.String statusCode, java.lang.String name, java.lang.String dctNsF, java.lang.String orgCode, java.lang.String ownerTypeCode, java.lang.String ownerCode, java.lang.String typeCode, java.lang.String mrCategoryCode, java.lang.String enTypeCode, java.lang.String userCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMrTplList", statusCode, name, dctNsF, orgCode, ownerTypeCode, ownerCode, typeCode, mrCategoryCode, enTypeCode, userCode, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tpl/dao/CusTemplateDao/selectMrTplList.sql");
            __query.setOptions(options);
            __query.addParameter("statusCode", java.lang.String.class, statusCode);
            __query.addParameter("name", java.lang.String.class, name);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerTypeCode", java.lang.String.class, ownerTypeCode);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.addParameter("mrCategoryCode", java.lang.String.class, mrCategoryCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.addParameter("userCode", java.lang.String.class, userCode);
            __query.setCallerClassName("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl");
            __query.setCallerMethodName("selectMrTplList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMrTplList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tpl.dao.CusTemplateDaoImpl", "selectMrTplList", __e);
            throw __e;
        }
    }

}
