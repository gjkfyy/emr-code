package pkuhit.iih.mr.wr.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-11-12T19:23:53.691+0800")
public class CusEnAdtFromIemrDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.iih.mr.wr.dao.CusEnAdtFromIemrDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CusEnAdtFromIemrDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> selectEnAdtFromIemrList(java.lang.String en_pk, java.lang.String patient_id, java.lang.String en_cnt, java.lang.Integer ledger_sn, java.lang.Integer trans_times, java.lang.String admiss_date_start, java.lang.String admiss_date_end, java.lang.String dis_date_start, java.lang.String dis_date_end, java.lang.String trans_reg_date_start, java.lang.String trans_reg_date_end, java.lang.String trans_date_start, java.lang.String trans_date_end, java.lang.String trans_type, java.lang.String orig_dept, java.lang.String orig_ward, java.lang.String orig_room, java.lang.String orig_bed, java.lang.String orig_opera, java.lang.String curr_dept, java.lang.String curr_ward, java.lang.String curr_room, java.lang.String curr_bed, java.lang.String curr_opera, java.lang.String mark) {
        entering("pkuhit.iih.mr.wr.dao.CusEnAdtFromIemrDaoImpl", "selectEnAdtFromIemrList", en_pk, patient_id, en_cnt, ledger_sn, trans_times, admiss_date_start, admiss_date_end, dis_date_start, dis_date_end, trans_reg_date_start, trans_reg_date_end, trans_date_start, trans_date_end, trans_type, orig_dept, orig_ward, orig_room, orig_bed, orig_opera, curr_dept, curr_ward, curr_room, curr_bed, curr_opera, mark);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/iih/mr/wr/dao/CusEnAdtFromIemrDao/selectEnAdtFromIemrList.sql");
            __query.addParameter("en_pk", java.lang.String.class, en_pk);
            __query.addParameter("patient_id", java.lang.String.class, patient_id);
            __query.addParameter("en_cnt", java.lang.String.class, en_cnt);
            __query.addParameter("ledger_sn", java.lang.Integer.class, ledger_sn);
            __query.addParameter("trans_times", java.lang.Integer.class, trans_times);
            __query.addParameter("admiss_date_start", java.lang.String.class, admiss_date_start);
            __query.addParameter("admiss_date_end", java.lang.String.class, admiss_date_end);
            __query.addParameter("dis_date_start", java.lang.String.class, dis_date_start);
            __query.addParameter("dis_date_end", java.lang.String.class, dis_date_end);
            __query.addParameter("trans_reg_date_start", java.lang.String.class, trans_reg_date_start);
            __query.addParameter("trans_reg_date_end", java.lang.String.class, trans_reg_date_end);
            __query.addParameter("trans_date_start", java.lang.String.class, trans_date_start);
            __query.addParameter("trans_date_end", java.lang.String.class, trans_date_end);
            __query.addParameter("trans_type", java.lang.String.class, trans_type);
            __query.addParameter("orig_dept", java.lang.String.class, orig_dept);
            __query.addParameter("orig_ward", java.lang.String.class, orig_ward);
            __query.addParameter("orig_room", java.lang.String.class, orig_room);
            __query.addParameter("orig_bed", java.lang.String.class, orig_bed);
            __query.addParameter("orig_opera", java.lang.String.class, orig_opera);
            __query.addParameter("curr_dept", java.lang.String.class, curr_dept);
            __query.addParameter("curr_ward", java.lang.String.class, curr_ward);
            __query.addParameter("curr_room", java.lang.String.class, curr_room);
            __query.addParameter("curr_bed", java.lang.String.class, curr_bed);
            __query.addParameter("curr_opera", java.lang.String.class, curr_opera);
            __query.addParameter("mark", java.lang.String.class, mark);
            __query.setCallerClassName("pkuhit.iih.mr.wr.dao.CusEnAdtFromIemrDaoImpl");
            __query.setCallerMethodName("selectEnAdtFromIemrList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity>(pkuhit.iih.mr.dao.auto.entity._EnAdtEntity.getSingletonInternal()));
            java.util.List<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.iih.mr.wr.dao.CusEnAdtFromIemrDaoImpl", "selectEnAdtFromIemrList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.iih.mr.wr.dao.CusEnAdtFromIemrDaoImpl", "selectEnAdtFromIemrList", __e);
            throw __e;
        }
    }

}
