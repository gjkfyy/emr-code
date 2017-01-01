package pkuhit.iih.mr.md.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.733+0800")
public class CusMdMrTpCcatDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusMdMrTpCcatDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> selectTreeList(java.lang.String orgCode, java.lang.String rootCode, int maxDepthLevel) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectTreeList", orgCode, rootCode, maxDepthLevel);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatDao/selectTreeList.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.addParameter("maxDepthLevel", int.class, maxDepthLevel);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl");
            __query.setCallerMethodName("selectTreeList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectTreeList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectTreeList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> getNextLevelChild(java.lang.String orgCode, java.lang.String rootCode) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "getNextLevelChild", orgCode, rootCode);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatDao/getNextLevelChild.sql");
            __query.addParameter("orgCode", java.lang.String.class, orgCode);
            __query.addParameter("rootCode", java.lang.String.class, rootCode);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl");
            __query.setCallerMethodName("getNextLevelChild");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "getNextLevelChild", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "getNextLevelChild", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> selectByEnTpCd(java.lang.String enTpCd, int doctorNuserFlag) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectByEnTpCd", enTpCd, doctorNuserFlag);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatDao/selectByEnTpCd.sql");
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("doctorNuserFlag", int.class, doctorNuserFlag);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl");
            __query.setCallerMethodName("selectByEnTpCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectByEnTpCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectByEnTpCd", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> selectSortTree(java.lang.String enTpCd, java.lang.String encounterPk, int dctNsF) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectSortTree", enTpCd, encounterPk, dctNsF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatDao/selectSortTree.sql");
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("encounterPk", java.lang.String.class, encounterPk);
            __query.addParameter("dctNsF", int.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl");
            __query.setCallerMethodName("selectSortTree");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectSortTree", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectSortTree", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> selectMrDocTree(java.lang.String enTpCd, java.lang.String enPk, java.lang.Integer dctNsF) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectMrDocTree", enTpCd, enPk, dctNsF);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatDao/selectMrDocTree.sql");
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.addParameter("dctNsF", java.lang.Integer.class, dctNsF);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl");
            __query.setCallerMethodName("selectMrDocTree");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectMrDocTree", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectMrDocTree", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> selectMrDocTreeByGroup(java.util.List<java.lang.String> enTpCdList, java.util.List<java.lang.String> enPks) {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectMrDocTreeByGroup", enTpCdList, enPks);
        try {
            if (enTpCdList == null) {
                throw new org.seasar.doma.DomaNullPointerException("enTpCdList");
            }
            if (enPks == null) {
                throw new org.seasar.doma.DomaNullPointerException("enPks");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatDao/selectMrDocTreeByGroup.sql");
            __query.addParameter("enTpCdList", java.util.List.class, enTpCdList);
            __query.addParameter("enPks", java.util.List.class, enPks);
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl");
            __query.setCallerMethodName("selectMrDocTreeByGroup");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectMrDocTreeByGroup", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectMrDocTreeByGroup", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> selectAll() {
        entering("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectAll");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/md/dao/custom/CusMdMrTpCcatDao/selectAll.sql");
            __query.setCallerClassName("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat>(pkuhit.iih.mr.md.dao.auto.entity._MdMrTpCcat.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

}
