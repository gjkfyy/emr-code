package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.827+0800")
public final class _QaAutoItmConfig extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _QaAutoItmConfig __singleton = new _QaAutoItmConfig();

    /** the qaItmConfigCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $qaItmConfigCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaItmConfigCd", "QA_ITM_CONFIG_CD");

    /** the qaItmCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $qaItmCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaItmCd", "QA_ITM_CD", true, true);

    /** the req */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $req = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "req", "REQ", true, true);

    /** the mrTypes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $mrTypes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTypes", "MR_TYPES", true, true);

    /** the eventTypeCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $eventTypeCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "eventTypeCode", "EVENT_TYPE_CODE", true, true);

    /** the deadHours */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.math.BigDecimal, java.lang.Object> $deadHours = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.math.BigDecimal, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.math.BigDecimal.class, org.seasar.doma.wrapper.BigDecimalWrapper.class, null, null, "deadHours", "DEAD_HOURS", true, true);

    /** the useFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $useFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "useFlag", "USE_FLAG", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the mrOpType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $mrOpType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrOpType", "MR_OP_TYPE", true, true);

    /** the qaItmTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $qaItmTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaItmTpCd", "QA_ITM_TP_CD", true, true);

    /** the dctOpTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $dctOpTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dctOpTpCd", "DCT_OP_TP_CD", true, true);

    /** the jobTitleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $jobTitleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "jobTitleCd", "JOB_TITLE_CD", true, true);

    /** the qaRlTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $qaRlTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaRlTpCd", "QA_RL_TP_CD", true, true);

    /** the qaRlCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object> $qaRlCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaRlCd", "QA_RL_CD", true, true);

    /** the reTimeRemind */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.math.BigDecimal, java.lang.Object> $reTimeRemind = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, java.math.BigDecimal, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class, java.math.BigDecimal.class, org.seasar.doma.wrapper.BigDecimalWrapper.class, null, null, "reTimeRemind", "RE_TIME_REMIND", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfigListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>> __entityPropertyTypeMap;

    private _QaAutoItmConfig() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfigListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "QaAutoItmConfig";
        __catalogName = "";
        __schemaName = "";
        __tableName = "QA_AUTO_ITM_CONFIG";
        __qualifiedTableName = "QA_AUTO_ITM_CONFIG";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>>(26);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>>(26);
        __idList.add($qaItmConfigCd);
        __list.add($qaItmConfigCd);
        __map.put("qaItmConfigCd", $qaItmConfigCd);
        __list.add($qaItmCd);
        __map.put("qaItmCd", $qaItmCd);
        __list.add($req);
        __map.put("req", $req);
        __list.add($mrTypes);
        __map.put("mrTypes", $mrTypes);
        __list.add($eventTypeCode);
        __map.put("eventTypeCode", $eventTypeCode);
        __list.add($deadHours);
        __map.put("deadHours", $deadHours);
        __list.add($useFlag);
        __map.put("useFlag", $useFlag);
        __list.add($memo);
        __map.put("memo", $memo);
        __list.add($sortNo);
        __map.put("sortNo", $sortNo);
        __list.add($spellNo);
        __map.put("spellNo", $spellNo);
        __list.add($wubiNo);
        __map.put("wubiNo", $wubiNo);
        __list.add($updCnt);
        __map.put("updCnt", $updCnt);
        __list.add($crtTime);
        __map.put("crtTime", $crtTime);
        __list.add($crtUserId);
        __map.put("crtUserId", $crtUserId);
        __list.add($crtDeptCd);
        __map.put("crtDeptCd", $crtDeptCd);
        __list.add($lastUpdTime);
        __map.put("lastUpdTime", $lastUpdTime);
        __list.add($lastUpdDeptCd);
        __map.put("lastUpdDeptCd", $lastUpdDeptCd);
        __list.add($lastUpdUserId);
        __map.put("lastUpdUserId", $lastUpdUserId);
        __list.add($delF);
        __map.put("delF", $delF);
        __list.add($mrOpType);
        __map.put("mrOpType", $mrOpType);
        __list.add($qaItmTpCd);
        __map.put("qaItmTpCd", $qaItmTpCd);
        __list.add($dctOpTpCd);
        __map.put("dctOpTpCd", $dctOpTpCd);
        __list.add($jobTitleCd);
        __map.put("jobTitleCd", $jobTitleCd);
        __list.add($qaRlTpCd);
        __map.put("qaRlTpCd", $qaRlTpCd);
        __list.add($qaRlCd);
        __map.put("qaRlCd", $qaRlCd);
        __list.add($reTimeRemind);
        __map.put("reTimeRemind", $reTimeRemind);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig getOriginalStates(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig __entity) {
    }

    /**
     * @return the singleton
     */
    public static _QaAutoItmConfig getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _QaAutoItmConfig newInstance() {
        return new _QaAutoItmConfig();
    }

}
