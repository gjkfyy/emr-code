package pkuhit.iih.mr.md.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.023+0800")
public class CusMdMrTpCcatItmDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMdMrTpCcatItmDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> getMdMrTpCcatItmByTemplateTypeAndEnTpCd(java.lang.String typeCode, java.lang.String enTpCd) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateTypeAndEnTpCd", typeCode, enTpCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatItmDao/getMdMrTpCcatItmByTemplateTypeAndEnTpCd.sql");
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl");
            __query.setCallerMethodName("getMdMrTpCcatItmByTemplateTypeAndEnTpCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcatItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateTypeAndEnTpCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateTypeAndEnTpCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> getOutMdMrTpCcatItmByTemplateType(java.lang.String typeCode) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getOutMdMrTpCcatItmByTemplateType", typeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatItmDao/getOutMdMrTpCcatItmByTemplateType.sql");
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl");
            __query.setCallerMethodName("getOutMdMrTpCcatItmByTemplateType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcatItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getOutMdMrTpCcatItmByTemplateType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getOutMdMrTpCcatItmByTemplateType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> getMdMrTpCcatItmByTemplateCategory(java.lang.String categoryCode) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateCategory", categoryCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatItmDao/getMdMrTpCcatItmByTemplateCategory.sql");
            __query.addParameter("categoryCode", java.lang.String.class, categoryCode);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl");
            __query.setCallerMethodName("getMdMrTpCcatItmByTemplateCategory");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcatItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateCategory", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateCategory", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> getMdMrTpCcatItmByTemplateType(java.lang.String typeCode) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateType", typeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatItmDao/getMdMrTpCcatItmByTemplateType.sql");
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl");
            __query.setCallerMethodName("getMdMrTpCcatItmByTemplateType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcatItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "getMdMrTpCcatItmByTemplateType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> selectEnTypeByTemplateType(java.lang.String typeCode) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "selectEnTypeByTemplateType", typeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatItmDao/selectEnTypeByTemplateType.sql");
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl");
            __query.setCallerMethodName("selectEnTypeByTemplateType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcatItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "selectEnTypeByTemplateType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "selectEnTypeByTemplateType", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> selectMrTpCcatByTemplateType(java.lang.String typeCode) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "selectMrTpCcatByTemplateType", typeCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatItmDao/selectMrTpCcatByTemplateType.sql");
            __query.addParameter("typeCode", java.lang.String.class, typeCode);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl");
            __query.setCallerMethodName("selectMrTpCcatByTemplateType");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcatItm.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "selectMrTpCcatByTemplateType", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDaoImpl", "selectMrTpCcatByTemplateType", __e);
            throw __e;
        }
    }

}
