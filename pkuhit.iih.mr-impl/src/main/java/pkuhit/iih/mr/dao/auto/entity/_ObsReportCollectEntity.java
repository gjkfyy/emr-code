package pkuhit.iih.mr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.300+0800")
public final class _ObsReportCollectEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _ObsReportCollectEntity __singleton = new _ObsReportCollectEntity();

    /** the obRpPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obRpPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obRpPk", "OB_RP_PK");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the paId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $paId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paId", "PA_ID", true, true);

    /** the enCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $enCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enCnt", "EN_CNT", true, true);

    /** the paNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $paNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paNm", "PA_NM", true, true);

    /** the obRpStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obRpStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obRpStaCd", "OB_RP_STA_CD", true, true);

    /** the obRpStaNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obRpStaNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obRpStaNm", "OB_RP_STA_NM", true, true);

    /** the obRpNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obRpNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obRpNo", "OB_RP_NO", true, true);

    /** the obRpNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obRpNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obRpNm", "OB_RP_NM", true, true);

    /** the obImpr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obImpr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obImpr", "OB_IMPR", true, true);

    /** the obFndg */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obFndg = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obFndg", "OB_FNDG", true, true);

    /** the obVal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obVal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obVal", "OB_VAL", true, true);

    /** the normalFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $normalFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "normalFlag", "NORMAL_FLAG", true, true);

    /** the obItmCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obItmCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obItmCd", "OB_ITM_CD", true, true);

    /** the obItmNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obItmNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obItmNm", "OB_ITM_NM", true, true);

    /** the execTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $execTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execTime", "EXEC_TIME", true, true);

    /** the execDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $execDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDctId", "EXEC_DCT_ID", true, true);

    /** the execDctNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $execDctNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDctNm", "EXEC_DCT_NM", true, true);

    /** the execDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $execDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDeptCd", "EXEC_DEPT_CD", true, true);

    /** the execDeptNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $execDeptNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDeptNm", "EXEC_DEPT_NM", true, true);

    /** the rlsUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $rlsUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rlsUserId", "RLS_USER_ID", true, true);

    /** the rlsUserNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $rlsUserNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rlsUserNm", "RLS_USER_NM", true, true);

    /** the rlsTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $rlsTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rlsTime", "RLS_TIME", true, true);

    /** the rqsTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $rqsTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rqsTime", "RQS_TIME", true, true);

    /** the rqsDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $rqsDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rqsDctId", "RQS_DCT_ID", true, true);

    /** the rqsDctNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $rqsDctNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rqsDctNm", "RQS_DCT_NM", true, true);

    /** the obDi */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $obDi = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obDi", "OB_DI", true, true);

    /** the adv */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object> $adv = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "adv", "ADV", true, true);

    private final pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>> __entityPropertyTypeMap;

    private _ObsReportCollectEntity() {
        __listener = new pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "ObsReportCollectEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "OBS_REPORT_COLLECT";
        __qualifiedTableName = "OBS_REPORT_COLLECT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>>(28);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>>(28);
        __idList.add($obRpPk);
        __list.add($obRpPk);
        __map.put("obRpPk", $obRpPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($paId);
        __map.put("paId", $paId);
        __list.add($enCnt);
        __map.put("enCnt", $enCnt);
        __list.add($paNm);
        __map.put("paNm", $paNm);
        __list.add($obRpStaCd);
        __map.put("obRpStaCd", $obRpStaCd);
        __list.add($obRpStaNm);
        __map.put("obRpStaNm", $obRpStaNm);
        __list.add($obRpNo);
        __map.put("obRpNo", $obRpNo);
        __list.add($obRpNm);
        __map.put("obRpNm", $obRpNm);
        __list.add($obImpr);
        __map.put("obImpr", $obImpr);
        __list.add($obFndg);
        __map.put("obFndg", $obFndg);
        __list.add($obVal);
        __map.put("obVal", $obVal);
        __list.add($normalFlag);
        __map.put("normalFlag", $normalFlag);
        __list.add($obItmCd);
        __map.put("obItmCd", $obItmCd);
        __list.add($obItmNm);
        __map.put("obItmNm", $obItmNm);
        __list.add($execTime);
        __map.put("execTime", $execTime);
        __list.add($execDctId);
        __map.put("execDctId", $execDctId);
        __list.add($execDctNm);
        __map.put("execDctNm", $execDctNm);
        __list.add($execDeptCd);
        __map.put("execDeptCd", $execDeptCd);
        __list.add($execDeptNm);
        __map.put("execDeptNm", $execDeptNm);
        __list.add($rlsUserId);
        __map.put("rlsUserId", $rlsUserId);
        __list.add($rlsUserNm);
        __map.put("rlsUserNm", $rlsUserNm);
        __list.add($rlsTime);
        __map.put("rlsTime", $rlsTime);
        __list.add($rqsTime);
        __map.put("rqsTime", $rqsTime);
        __list.add($rqsDctId);
        __map.put("rqsDctId", $rqsDctId);
        __list.add($rqsDctNm);
        __map.put("rqsDctNm", $rqsDctNm);
        __list.add($obDi);
        __map.put("obDi", $obDi);
        __list.add($adv);
        __map.put("adv", $adv);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return __tableName;
    }

    @Override
    public String getQualifiedTableName() {
        return __qualifiedTableName;
    }

    @Override
    public void preInsert(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity newEntity() {
        return new pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity();
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity();
    }

    @Override
    public Class<pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity> getEntityClass() {
        return pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity.class;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity getOriginalStates(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _ObsReportCollectEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _ObsReportCollectEntity newInstance() {
        return new _ObsReportCollectEntity();
    }

}
