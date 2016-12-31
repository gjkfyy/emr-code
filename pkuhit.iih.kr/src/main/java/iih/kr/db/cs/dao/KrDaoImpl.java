package iih.kr.db.cs.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:18.206+0800")
public class KrDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.kr.db.cs.dao.KrDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public KrDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public iih.kr.db.cs.entity.DbDateEntity sysdate() {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "sysdate");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/sysdate.sql");
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("sysdate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<iih.kr.db.cs.entity.DbDateEntity> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<iih.kr.db.cs.entity.DbDateEntity>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<iih.kr.db.cs.entity.DbDateEntity>(iih.kr.db.cs.entity._DbDateEntity.getSingletonInternal()));
            iih.kr.db.cs.entity.DbDateEntity __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "sysdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "sysdate", __e);
            throw __e;
        }
    }

    @Override
    public int getMaxSortNoDiRelDi(java.lang.String ownerType, java.lang.String ownerCode, java.lang.String diSuiteTypeCode, java.lang.String diSuiteCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "getMaxSortNoDiRelDi", ownerType, ownerCode, diSuiteTypeCode, diSuiteCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/getMaxSortNoDiRelDi.sql");
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("diSuiteTypeCode", java.lang.String.class, diSuiteTypeCode);
            __query.addParameter("diSuiteCode", java.lang.String.class, diSuiteCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("getMaxSortNoDiRelDi");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "getMaxSortNoDiRelDi", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "getMaxSortNoDiRelDi", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.gen.entity.DiSuiteShareEntity> getSharedKr(java.lang.String sOwnerType, java.lang.String sOwnerCode, java.lang.String dOwnerType, java.lang.String dOwnerCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "getSharedKr", sOwnerType, sOwnerCode, dOwnerType, dOwnerCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/getSharedKr.sql");
            __query.addParameter("sOwnerType", java.lang.String.class, sOwnerType);
            __query.addParameter("sOwnerCode", java.lang.String.class, sOwnerCode);
            __query.addParameter("dOwnerType", java.lang.String.class, dOwnerType);
            __query.addParameter("dOwnerCode", java.lang.String.class, dOwnerCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("getSharedKr");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteShareEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteShareEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.gen.entity.DiSuiteShareEntity>(iih.kr.db.gen.entity._DiSuiteShareEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.gen.entity.DiSuiteShareEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "getSharedKr", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "getSharedKr", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.cs.entity.MrTplSimpleEntity> selectAllMrTemplate(java.lang.String orgCode, java.lang.String ownerType, java.lang.String ownerCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectAllMrTemplate", orgCode, ownerType, ownerCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectAllMrTemplate.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectAllMrTemplate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.MrTplSimpleEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.MrTplSimpleEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.cs.entity.MrTplSimpleEntity>(iih.kr.db.cs.entity._MrTplSimpleEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.cs.entity.MrTplSimpleEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectAllMrTemplate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectAllMrTemplate", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.gen.entity.DiSuiteEntity> selectCcdByCategoryCode(java.lang.String ownerType, java.lang.String ownerCode, java.lang.String orgCode, java.lang.String diSuiteTypeCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectCcdByCategoryCode", ownerType, ownerCode, orgCode, diSuiteTypeCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectCcdByCategoryCode.sql");
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("diSuiteTypeCode", java.lang.String.class, diSuiteTypeCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectCcdByCategoryCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.gen.entity.DiSuiteEntity>(iih.kr.db.gen.entity._DiSuiteEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.gen.entity.DiSuiteEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectCcdByCategoryCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectCcdByCategoryCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.gen.entity.MrTplEntity> selectCOmmonMrDoc(java.lang.String ownerType, java.lang.String ownerCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectCOmmonMrDoc", ownerType, ownerCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectCOmmonMrDoc.sql");
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectCOmmonMrDoc");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.MrTplEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.MrTplEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.gen.entity.MrTplEntity>(iih.kr.db.gen.entity._MrTplEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.gen.entity.MrTplEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectCOmmonMrDoc", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectCOmmonMrDoc", __e);
            throw __e;
        }
    }

    @Override
    public int selectCountOfCategoryName(java.lang.String diSuiteTypeName, java.lang.String orgCode, java.lang.String ownerType, java.lang.String ownerCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectCountOfCategoryName", diSuiteTypeName, orgCode, ownerType, ownerCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectCountOfCategoryName.sql");
            __query.addParameter("diSuiteTypeName", java.lang.String.class, diSuiteTypeName);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectCountOfCategoryName");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectCountOfCategoryName", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectCountOfCategoryName", __e);
            throw __e;
        }
    }

    @Override
    public int selectCountOfDiSuite(java.lang.String orgCode, java.lang.String ownerType, java.lang.String ownerCode, java.lang.String diSuiteTypeCode, java.lang.String diCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectCountOfDiSuite", orgCode, ownerType, ownerCode, diSuiteTypeCode, diCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectCountOfDiSuite.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("diSuiteTypeCode", java.lang.String.class, diSuiteTypeCode);
            __query.addParameter("diCode", java.lang.String.class, diCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectCountOfDiSuite");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), true));
            int __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectCountOfDiSuite", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectCountOfDiSuite", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.cs.entity.DiSuiteModelEntity> selectDiSuiteEntities(java.lang.String ownerType, java.lang.String ownerCode, java.lang.String orgCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectDiSuiteEntities", ownerType, ownerCode, orgCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectDiSuiteEntities.sql");
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectDiSuiteEntities");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.DiSuiteModelEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.DiSuiteModelEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.cs.entity.DiSuiteModelEntity>(iih.kr.db.cs.entity._DiSuiteModelEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.cs.entity.DiSuiteModelEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectDiSuiteEntities", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectDiSuiteEntities", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.cs.entity.DiSuiteModelEntity> selectDiSuiteEntitiesForAdmin(java.lang.String orgCode, java.lang.String ownerType, java.lang.String ownerCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectDiSuiteEntitiesForAdmin", orgCode, ownerType, ownerCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectDiSuiteEntitiesForAdmin.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectDiSuiteEntitiesForAdmin");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.DiSuiteModelEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.DiSuiteModelEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.cs.entity.DiSuiteModelEntity>(iih.kr.db.cs.entity._DiSuiteModelEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.cs.entity.DiSuiteModelEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectDiSuiteEntitiesForAdmin", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectDiSuiteEntitiesForAdmin", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.Integer selectMaxSortNoForCC(java.lang.String orgCode, java.lang.String ownerType, java.lang.String ownerCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForCC", orgCode, ownerType, ownerCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectMaxSortNoForCC.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectMaxSortNoForCC");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), false));
            java.lang.Integer __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForCC", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForCC", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.cs.entity.MdDiSimpleEntity> selectMdDi(java.lang.String orgCode, java.util.List<java.lang.String> diCodes) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectMdDi", orgCode, diCodes);
        try {
            if (diCodes == null) {
                throw new org.seasar.doma.DomaNullPointerException("diCodes");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectMdDi.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("diCodes", java.util.List.class, diCodes);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectMdDi");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.MdDiSimpleEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.MdDiSimpleEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.cs.entity.MdDiSimpleEntity>(iih.kr.db.cs.entity._MdDiSimpleEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.cs.entity.MdDiSimpleEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectMdDi", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectMdDi", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.gen.entity.DiSuiteDiEntity> selectRelDiByDiSuite(java.lang.String diSuiteCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectRelDiByDiSuite", diSuiteCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectRelDiByDiSuite.sql");
            __query.addParameter("diSuiteCode", java.lang.String.class, diSuiteCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectRelDiByDiSuite");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteDiEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteDiEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.gen.entity.DiSuiteDiEntity>(iih.kr.db.gen.entity._DiSuiteDiEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.gen.entity.DiSuiteDiEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectRelDiByDiSuite", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectRelDiByDiSuite", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.gen.entity.DiSuiteTemplateEntity> selectRelMrDocByDiSuite(java.lang.String diSuiteCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectRelMrDocByDiSuite", diSuiteCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectRelMrDocByDiSuite.sql");
            __query.addParameter("diSuiteCode", java.lang.String.class, diSuiteCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectRelMrDocByDiSuite");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteTemplateEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteTemplateEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.gen.entity.DiSuiteTemplateEntity>(iih.kr.db.gen.entity._DiSuiteTemplateEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.gen.entity.DiSuiteTemplateEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectRelMrDocByDiSuite", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectRelMrDocByDiSuite", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.cs.entity.MrTplSimpleEntity> selectMrTemplate(java.util.List<java.lang.String> mrCodes) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectMrTemplate", mrCodes);
        try {
            if (mrCodes == null) {
                throw new org.seasar.doma.DomaNullPointerException("mrCodes");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectMrTemplate.sql");
            __query.addParameter("mrCodes", java.util.List.class, mrCodes);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectMrTemplate");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.MrTplSimpleEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.cs.entity.MrTplSimpleEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.cs.entity.MrTplSimpleEntity>(iih.kr.db.cs.entity._MrTplSimpleEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.cs.entity.MrTplSimpleEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectMrTemplate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectMrTemplate", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.Integer selectMaxSortNoForRelDi(java.lang.String diSuiteCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForRelDi", diSuiteCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectMaxSortNoForRelDi.sql");
            __query.addParameter("diSuiteCode", java.lang.String.class, diSuiteCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectMaxSortNoForRelDi");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), false));
            java.lang.Integer __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForRelDi", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForRelDi", __e);
            throw __e;
        }
    }

    @Override
    public java.lang.Integer selectMaxSortNoForRelMr(java.lang.String diSuiteCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForRelMr", diSuiteCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectMaxSortNoForRelMr.sql");
            __query.addParameter("diSuiteCode", java.lang.String.class, diSuiteCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectMaxSortNoForRelMr");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.lang.Integer>(__query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(new org.seasar.doma.wrapper.IntegerWrapper(), false));
            java.lang.Integer __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForRelMr", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectMaxSortNoForRelMr", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<iih.kr.db.gen.entity.DiSuiteTpEntity> selectCategoryByOwner(java.lang.String orgCode, java.lang.String ownerType, java.lang.String ownerCode, java.lang.String enTypeCode) {
        entering("iih.kr.db.cs.dao.KrDaoImpl", "selectCategoryByOwner", orgCode, ownerType, ownerCode, enTypeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/iih/kr/db/cs/dao/KrDao/selectCategoryByOwner.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("ownerType", java.lang.String.class, ownerType);
            __query.addParameter("ownerCode", java.lang.String.class, ownerCode);
            __query.addParameter("enTypeCode", java.lang.String.class, enTypeCode);
            __query.setCallerClassName("iih.kr.db.cs.dao.KrDaoImpl");
            __query.setCallerMethodName("selectCategoryByOwner");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteTpEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<iih.kr.db.gen.entity.DiSuiteTpEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<iih.kr.db.gen.entity.DiSuiteTpEntity>(iih.kr.db.gen.entity._DiSuiteTpEntity.getSingletonInternal()));
            java.util.List<iih.kr.db.gen.entity.DiSuiteTpEntity> __result = __command.execute();
            __query.complete();
            exiting("iih.kr.db.cs.dao.KrDaoImpl", "selectCategoryByOwner", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("iih.kr.db.cs.dao.KrDaoImpl", "selectCategoryByOwner", __e);
            throw __e;
        }
    }

}
