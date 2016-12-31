package pkuhit.xap.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.624+0800")
public class CustomXapMessageDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.custom.CustomXapMessageDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CustomXapMessageDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectXapMessageByUserId(java.lang.String userId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectXapMessageByUserId", userId, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapMessageDao/selectXapMessageByUserId.sql");
            __query.setOptions(options);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl");
            __query.setCallerMethodName("selectXapMessageByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectXapMessageByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectXapMessageByUserId", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectXapMessageByUserIdAndReadFlag(java.lang.String userId, java.lang.String readFlag) {
        entering("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectXapMessageByUserIdAndReadFlag", userId, readFlag);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapMessageDao/selectXapMessageByUserIdAndReadFlag.sql");
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("readFlag", java.lang.String.class, readFlag);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl");
            __query.setCallerMethodName("selectXapMessageByUserIdAndReadFlag");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectXapMessageByUserIdAndReadFlag", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectXapMessageByUserIdAndReadFlag", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.String selectMngDocCdByEnpk(java.lang.String enPk) {
        entering("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectMngDocCdByEnpk", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/custom/CustomXapMessageDao/selectMngDocCdByEnpk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl");
            __query.setCallerMethodName("selectMngDocCdByEnpk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.String>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.String>(new org.seasar.doma.wrapper.StringWrapper(), false));
            java.lang.String __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectMngDocCdByEnpk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.custom.CustomXapMessageDaoImpl", "selectMngDocCdByEnpk", __e);
            throw __e;
        }
    }

}
