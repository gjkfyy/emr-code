package ei.cis.db.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.890+0800")
public class CisEnViewDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements ei.cis.db.dao.CisEnViewDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CisEnViewDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> selectEncounterFromViewByCondition(java.lang.String keyword, java.lang.String deptCd, java.lang.String userId, java.lang.String enTpCd, java.lang.String groupType, java.lang.String patientName, java.lang.String amrNo, java.lang.String currentBedCode, java.lang.String startDate, java.lang.String endDate, java.lang.String curMgDctId, org.seasar.doma.jdbc.SelectOptions options) {
        entering("ei.cis.db.dao.CisEnViewDaoImpl", "selectEncounterFromViewByCondition", keyword, deptCd, userId, enTpCd, groupType, patientName, amrNo, currentBedCode, startDate, endDate, curMgDctId, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/ei/cis/db/dao/CisEnViewDao/selectEncounterFromViewByCondition.sql");
            __query.setOptions(options);
            __query.addParameter("keyword", java.lang.String.class, keyword);
            __query.addParameter("deptCd", java.lang.String.class, deptCd);
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.addParameter("enTpCd", java.lang.String.class, enTpCd);
            __query.addParameter("groupType", java.lang.String.class, groupType);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("amrNo", java.lang.String.class, amrNo);
            __query.addParameter("currentBedCode", java.lang.String.class, currentBedCode);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.addParameter("curMgDctId", java.lang.String.class, curMgDctId);
            __query.setCallerClassName("ei.cis.db.dao.CisEnViewDaoImpl");
            __query.setCallerMethodName("selectEncounterFromViewByCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>>(__query, new org.seasar.doma.internal.jdbc.command.MapResultListHandler(org.seasar.doma.MapKeyNamingType.NONE));
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> __result = __command.execute();
            __query.complete();
            exiting("ei.cis.db.dao.CisEnViewDaoImpl", "selectEncounterFromViewByCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("ei.cis.db.dao.CisEnViewDaoImpl", "selectEncounterFromViewByCondition", __e);
            throw __e;
        }
    }

}
