package pkuhit.iih.mr.md.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:26.429+0800")
public class CusMdMrTpDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.md.dao.custom.CusMdMrTpDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMdMrTpDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> selectTreeList(java.lang.String rootCode, int maxDepthLevel) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectTreeList", rootCode, maxDepthLevel);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpDao/selectTreeList.sql");
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.addParameter("maxDepthLevel", int.class, maxDepthLevel);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl");
            __query.setCallerMethodName("selectTreeList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectTreeList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectTreeList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> getNextLevelChild(java.lang.String parentId) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "getNextLevelChild", parentId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpDao/getNextLevelChild.sql");
            __query.addParameter("parentId", java.lang.String.class, parentId);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl");
            __query.setCallerMethodName("getNextLevelChild");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "getNextLevelChild", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "getNextLevelChild", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> selectByEnTpCd(java.lang.String enTpCd, java.lang.String mrTpCcatCd) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByEnTpCd", enTpCd, mrTpCcatCd);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpDao/selectByEnTpCd.sql");
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("mrTpCcatCd", java.lang.String.class, mrTpCcatCd);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl");
            __query.setCallerMethodName("selectByEnTpCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByEnTpCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByEnTpCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> selectByEnTpCdAndDctNsF(java.lang.String enTpCd, java.lang.String mrTpCcatCd, java.lang.String dctNsF) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByEnTpCdAndDctNsF", enTpCd, mrTpCcatCd, dctNsF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpDao/selectByEnTpCdAndDctNsF.sql");
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("mrTpCcatCd", java.lang.String.class, mrTpCcatCd);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl");
            __query.setCallerMethodName("selectByEnTpCdAndDctNsF");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByEnTpCdAndDctNsF", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByEnTpCdAndDctNsF", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> selectLeafTypeCode() {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectLeafTypeCode");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpDao/selectLeafTypeCode.sql");
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl");
            __query.setCallerMethodName("selectLeafTypeCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectLeafTypeCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectLeafTypeCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> selectTypeCodeTree(java.util.List<java.lang.String> typeCodeList, java.lang.String keyWord, java.lang.String dctNsF) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectTypeCodeTree", typeCodeList, keyWord, dctNsF);
        try {
            if (typeCodeList == null) {
                throw new org.seasar.doma.DomaNullPointerException("typeCodeList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpDao/selectTypeCodeTree.sql");
            __query.addParameter("typeCodeList", java.util.List.class, typeCodeList);
            __query.addParameter("keyWord", java.lang.String.class, keyWord);
            __query.addParameter("dctNsF", java.lang.String.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl");
            __query.setCallerMethodName("selectTypeCodeTree");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectTypeCodeTree", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectTypeCodeTree", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> selectByMrTypeCcatId(java.lang.String mrTypeCcatId) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByMrTypeCcatId", mrTypeCcatId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpDao/selectByMrTypeCcatId.sql");
            __query.addParameter("mrTypeCcatId", java.lang.String.class, mrTypeCcatId);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl");
            __query.setCallerMethodName("selectByMrTypeCcatId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTp.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTp> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByMrTypeCcatId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpDaoImpl", "selectByMrTypeCcatId", __e);
            throw __e;
        }
    }

}
