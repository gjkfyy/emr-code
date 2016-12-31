package iih.di.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:57.480+0800")
public class DiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.di.db.dao.DiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public DiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.MdDiEntity> assistantQuerySpell(java.lang.String keyWord, boolean prefixF) {
        entering("iih.di.db.dao.DiDaoImpl", "assistantQuerySpell", keyWord, prefixF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/DiDao/assistantQuerySpell.sql");
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("prefixF", boolean.class, prefixF);
            __query.setCallerClassName("iih.di.db.dao.DiDaoImpl");
            __query.setCallerMethodName("assistantQuerySpell");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(50);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.MdDiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.DiDaoImpl", "assistantQuerySpell", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.DiDaoImpl", "assistantQuerySpell", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.MdDiEntity> assistantQueryEqualSpell(java.lang.String keyWord, boolean isEqual) {
        entering("iih.di.db.dao.DiDaoImpl", "assistantQueryEqualSpell", keyWord, isEqual);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/DiDao/assistantQueryEqualSpell.sql");
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("isEqual", boolean.class, isEqual);
            __query.setCallerClassName("iih.di.db.dao.DiDaoImpl");
            __query.setCallerMethodName("assistantQueryEqualSpell");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.MdDiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.DiDaoImpl", "assistantQueryEqualSpell", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.DiDaoImpl", "assistantQueryEqualSpell", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.MdDiEntity> assistantQueryAliasEqualSpell(java.lang.String keyWord, boolean isEqual) {
        entering("iih.di.db.dao.DiDaoImpl", "assistantQueryAliasEqualSpell", keyWord, isEqual);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/DiDao/assistantQueryAliasEqualSpell.sql");
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("isEqual", boolean.class, isEqual);
            __query.setCallerClassName("iih.di.db.dao.DiDaoImpl");
            __query.setCallerMethodName("assistantQueryAliasEqualSpell");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.MdDiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.DiDaoImpl", "assistantQueryAliasEqualSpell", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.DiDaoImpl", "assistantQueryAliasEqualSpell", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.MdDiEntity> assistantQueryAliasSpell(java.lang.String keyWord, boolean prefixF) {
        entering("iih.di.db.dao.DiDaoImpl", "assistantQueryAliasSpell", keyWord, prefixF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/DiDao/assistantQueryAliasSpell.sql");
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("prefixF", boolean.class, prefixF);
            __query.setCallerClassName("iih.di.db.dao.DiDaoImpl");
            __query.setCallerMethodName("assistantQueryAliasSpell");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(50);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.MdDiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.DiDaoImpl", "assistantQueryAliasSpell", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.DiDaoImpl", "assistantQueryAliasSpell", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.MdDiEntity> assistantQueryNm(java.lang.String keyWord, boolean prefixF) {
        entering("iih.di.db.dao.DiDaoImpl", "assistantQueryNm", keyWord, prefixF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/DiDao/assistantQueryNm.sql");
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("prefixF", boolean.class, prefixF);
            __query.setCallerClassName("iih.di.db.dao.DiDaoImpl");
            __query.setCallerMethodName("assistantQueryNm");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(50);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.MdDiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.DiDaoImpl", "assistantQueryNm", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.DiDaoImpl", "assistantQueryNm", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.MdDiEntity> assistantQueryAll() {
        entering("iih.di.db.dao.DiDaoImpl", "assistantQueryAll");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/DiDao/assistantQueryAll.sql");
            __query.setCallerClassName("iih.di.db.dao.DiDaoImpl");
            __query.setCallerMethodName("assistantQueryAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(50);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.MdDiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.MdDiEntity>(iih.di.db.gen.entity._MdDiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.MdDiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.DiDaoImpl", "assistantQueryAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.DiDaoImpl", "assistantQueryAll", __e);
            throw __e;
        }
    }

}
