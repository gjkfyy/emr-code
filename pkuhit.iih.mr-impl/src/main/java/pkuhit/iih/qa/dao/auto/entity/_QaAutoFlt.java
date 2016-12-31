package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.799+0800")
public final class _QaAutoFlt extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _QaAutoFlt __singleton = new _QaAutoFlt();

    /** the qaAutoFltPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $qaAutoFltPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaAutoFltPk", "QA_AUTO_FLT_PK");

    /** the qaItmCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $qaItmCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaItmCd", "QA_ITM_CD", true, true);

    /** the docSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $docSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "docSn", "DOC_SN", true, true);

    /** the eventId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $eventId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "eventId", "EVENT_ID", true, true);

    /** the beginTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object> $beginTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "beginTime", "BEGIN_TIME", true, true);

    /** the endTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object> $endTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "endTime", "END_TIME", true, true);

    /** the encounterSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $encounterSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "encounterSn", "ENCOUNTER_SN", true, true);

    /** the completeTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object> $completeTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "completeTime", "COMPLETE_TIME", true, true);

    /** the applyFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.Short, java.lang.Object> $applyFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "applyFlag", "APPLY_FLAG", true, true);

    /** the fltFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.Short, java.lang.Object> $fltFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "fltFlag", "FLT_FLAG", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the divFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.Short, java.lang.Object> $divFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "divFlag", "DIV_FLAG", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.QaAutoFltListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>> __entityPropertyTypeMap;

    private _QaAutoFlt() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.QaAutoFltListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "QaAutoFlt";
        __catalogName = "";
        __schemaName = "";
        __tableName = "QA_AUTO_FLT";
        __qualifiedTableName = "QA_AUTO_FLT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>>(23);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>>(23);
        __idList.add($qaAutoFltPk);
        __list.add($qaAutoFltPk);
        __map.put("qaAutoFltPk", $qaAutoFltPk);
        __list.add($qaItmCd);
        __map.put("qaItmCd", $qaItmCd);
        __list.add($docSn);
        __map.put("docSn", $docSn);
        __list.add($eventId);
        __map.put("eventId", $eventId);
        __list.add($beginTime);
        __map.put("beginTime", $beginTime);
        __list.add($endTime);
        __map.put("endTime", $endTime);
        __list.add($encounterSn);
        __map.put("encounterSn", $encounterSn);
        __list.add($completeTime);
        __map.put("completeTime", $completeTime);
        __list.add($applyFlag);
        __map.put("applyFlag", $applyFlag);
        __list.add($fltFlag);
        __map.put("fltFlag", $fltFlag);
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
        __list.add($divFlag);
        __map.put("divFlag", $divFlag);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaAutoFlt, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaAutoFlt newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.QaAutoFlt();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaAutoFlt newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.QaAutoFlt();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.QaAutoFlt> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.QaAutoFlt.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaAutoFlt getOriginalStates(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.QaAutoFlt __entity) {
    }

    /**
     * @return the singleton
     */
    public static _QaAutoFlt getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _QaAutoFlt newInstance() {
        return new _QaAutoFlt();
    }

}
