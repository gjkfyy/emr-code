package pkuhit.iih.mr.tth.dao.custom;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.705+0800")
public class CusTeethExamDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.tth.dao.custom.CusTeethExamDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusTeethExamDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam selectTeethExamByEnPk(java.lang.String enPk) {
        entering("pkuhit.iih.mr.tth.dao.custom.CusTeethExamDaoImpl", "selectTeethExamByEnPk", enPk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tth/dao/custom/CusTeethExamDao/selectTeethExamByEnPk.sql");
            __query.addParameter("enPk", java.lang.String.class, enPk);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.custom.CusTeethExamDaoImpl");
            __query.setCallerMethodName("selectTeethExamByEnPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExam.getSingletonInternal()));
            pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.custom.CusTeethExamDaoImpl", "selectTeethExamByEnPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.custom.CusTeethExamDaoImpl", "selectTeethExamByEnPk", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> selectTeethExamItemByPk(java.lang.String pk) {
        entering("pkuhit.iih.mr.tth.dao.custom.CusTeethExamDaoImpl", "selectTeethExamItemByPk", pk);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/tth/dao/custom/CusTeethExamDao/selectTeethExamItemByPk.sql");
            __query.addParameter("pk", java.lang.String.class, pk);
            __query.setCallerClassName("pkuhit.iih.mr.tth.dao.custom.CusTeethExamDaoImpl");
            __query.setCallerMethodName("selectTeethExamItemByPk");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem>(pkuhit.iih.mr.tth.dao.auto.entity._MrTeethExamItem.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.tth.dao.custom.CusTeethExamDaoImpl", "selectTeethExamItemByPk", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.tth.dao.custom.CusTeethExamDaoImpl", "selectTeethExamItemByPk", __e);
            throw __e;
        }
    }

}
