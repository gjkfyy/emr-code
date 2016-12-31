package iih.di.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:37.085+0800")
public class CusDibDiDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.di.db.dao.CusDibDiDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusDibDiDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.DiEntity> selectByEnSn(java.lang.String enSn, java.lang.String orgCode, java.lang.Integer mainF) {
        entering("iih.di.db.dao.CusDibDiDaoImpl", "selectByEnSn", enSn, orgCode, mainF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/CusDibDiDao/selectByEnSn.sql");
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("mainF", java.lang.Integer.class, mainF);
            __query.setCallerClassName("iih.di.db.dao.CusDibDiDaoImpl");
            __query.setCallerMethodName("selectByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.DiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.DiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.DiEntity>(iih.di.db.gen.entity._DiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.DiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.CusDibDiDaoImpl", "selectByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.CusDibDiDaoImpl", "selectByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public iih.di.db.gen.entity.DiEntity selectDiNextRecord(java.lang.String enSn, java.lang.String orgCode, org.seasar.doma.jdbc.SelectOptions options) {
        entering("iih.di.db.dao.CusDibDiDaoImpl", "selectDiNextRecord", enSn, orgCode, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/CusDibDiDao/selectDiNextRecord.sql");
            __query.setOptions(options);
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.setCallerClassName("iih.di.db.dao.CusDibDiDaoImpl");
            __query.setCallerMethodName("selectDiNextRecord");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<iih.di.db.gen.entity.DiEntity> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<iih.di.db.gen.entity.DiEntity>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<iih.di.db.gen.entity.DiEntity>(iih.di.db.gen.entity._DiEntity.getSingletonInternal()));
            iih.di.db.gen.entity.DiEntity __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.CusDibDiDaoImpl", "selectDiNextRecord", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.CusDibDiDaoImpl", "selectDiNextRecord", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.DiEntity> selectDisByEnSn(java.lang.String enSn, java.lang.String orgCode) {
        entering("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByEnSn", enSn, orgCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/CusDibDiDao/selectDisByEnSn.sql");
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.setCallerClassName("iih.di.db.dao.CusDibDiDaoImpl");
            __query.setCallerMethodName("selectDisByEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.DiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.DiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.DiEntity>(iih.di.db.gen.entity._DiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.DiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.DiEntity> selectDisByOldEnSn(java.lang.String enSn, java.lang.String orgCode) {
        entering("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByOldEnSn", enSn, orgCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/CusDibDiDao/selectDisByOldEnSn.sql");
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.setCallerClassName("iih.di.db.dao.CusDibDiDaoImpl");
            __query.setCallerMethodName("selectDisByOldEnSn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.DiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.DiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.DiEntity>(iih.di.db.gen.entity._DiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.DiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByOldEnSn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByOldEnSn", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.di.db.gen.entity.DiEntity> selectDisByEnSnAndDicd(java.lang.String enSn, java.lang.String orgCode, java.lang.String diCd) {
        entering("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByEnSnAndDicd", enSn, orgCode, diCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/di/db/dao/CusDibDiDao/selectDisByEnSnAndDicd.sql");
            __query.addParameter("enSn", java.lang.String.class, enSn);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("diCd", java.lang.String.class, diCd);
            __query.setCallerClassName("iih.di.db.dao.CusDibDiDaoImpl");
            __query.setCallerMethodName("selectDisByEnSnAndDicd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.DiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.di.db.gen.entity.DiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.di.db.gen.entity.DiEntity>(iih.di.db.gen.entity._DiEntity.getSingletonInternal()));
            java.util.List<iih.di.db.gen.entity.DiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByEnSnAndDicd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.di.db.dao.CusDibDiDaoImpl", "selectDisByEnSnAndDicd", __e);
            throw __e;
        }
    }

}
