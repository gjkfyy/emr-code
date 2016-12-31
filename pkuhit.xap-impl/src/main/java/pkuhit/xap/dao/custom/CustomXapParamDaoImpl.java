package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.644+0800")
public class CustomXapParamDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapParamDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapParamDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapParam> selectXapParamList(org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamList", options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapParamDao/selectXapParamList.sql");
            __query.setOptions(options);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapParamDaoImpl");
            __query.setCallerMethodName("selectXapParamList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapParam>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapParam>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapParam>(pkuhit.xap.dao.auto.entity._XapParam.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapParam> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapParam> selectXapParamListByCondition(java.util.List<java.lang.String> conditionNmList, java.lang.String code, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamListByCondition", conditionNmList, code, options);
        try {
            if (conditionNmList == null) {
                throw new org.seasar.doma.DomaNullPointerException("conditionNmList");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapParamDao/selectXapParamListByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("conditionNmList", java.util.List.class, conditionNmList);
            __query.addParameter("code", java.lang.String.class, code);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapParamDaoImpl");
            __query.setCallerMethodName("selectXapParamListByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapParam>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapParam>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapParam>(pkuhit.xap.dao.auto.entity._XapParam.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapParam> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamListByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamListByCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String selectXapParamNm(java.lang.String nm, java.lang.String paramCd) {
        entering("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamNm", nm, paramCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapParamDao/selectXapParamNm.sql");
            __query.addParameter("nm", java.lang.String.class, nm);
            __query.addParameter("paramCd", java.lang.String.class, paramCd);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapParamDaoImpl");
            __query.setCallerMethodName("selectXapParamNm");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamNm", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamNm", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String selectXapParamCodeAndKey(java.lang.String paramCd, java.lang.String code, java.lang.String key) {
        entering("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamCodeAndKey", paramCd, code, key);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapParamDao/selectXapParamCodeAndKey.sql");
            __query.addParameter("paramCd", java.lang.String.class, paramCd);
            __query.addParameter("code", java.lang.String.class, code);
            __query.addParameter("key", java.lang.String.class, key);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapParamDaoImpl");
            __query.setCallerMethodName("selectXapParamCodeAndKey");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamCodeAndKey", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamCodeAndKey", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.XapParam> selectXapParamByCode(java.lang.String code) {
        entering("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamByCode", code);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapParamDao/selectXapParamByCode.sql");
            __query.addParameter("code", java.lang.String.class, code);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapParamDaoImpl");
            __query.setCallerMethodName("selectXapParamByCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapParam>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.XapParam>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.XapParam>(pkuhit.xap.dao.auto.entity._XapParam.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.XapParam> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamByCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectXapParamByCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.md.dao.auto.entity.MdGs> selectMdGsList(java.lang.String keyword, java.lang.String id, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectMdGsList", keyword, id, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapParamDao/selectMdGsList.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("id", java.lang.String.class, id);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapParamDaoImpl");
            __query.setCallerMethodName("selectMdGsList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.md.dao.auto.entity.MdGs>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.md.dao.auto.entity.MdGs>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.md.dao.auto.entity.MdGs>(pkuhit.md.dao.auto.entity._MdGs.getSingletonInternal()));
            java.util.List<pkuhit.md.dao.auto.entity.MdGs> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectMdGsList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapParamDaoImpl", "selectMdGsList", __e);
            throw __e;
        }
    }

}
