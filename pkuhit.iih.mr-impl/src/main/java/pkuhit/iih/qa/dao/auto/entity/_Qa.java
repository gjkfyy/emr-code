package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.249+0800")
public final class _Qa extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.Qa> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _Qa __singleton = new _Qa();

    /** the qaPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $qaPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaPk", "QA_PK");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the qaTyCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $qaTyCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaTyCd", "QA_TY_CD", true, true);

    /** the planTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object> $planTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "planTime", "PLAN_TIME", true, true);

    /** the execBeginTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object> $execBeginTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "execBeginTime", "EXEC_BEGIN_TIME", true, true);

    /** the execEndTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object> $execEndTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "execEndTime", "EXEC_END_TIME", true, true);

    /** the execUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $execUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execUserId", "EXEC_USER_ID", true, true);

    /** the execDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $execDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDeptCd", "EXEC_DEPT_CD", true, true);

    /** the cmplF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.Short, java.lang.Object> $cmplF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "cmplF", "CMPL_F", true, true);

    /** the haveFltF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.Short, java.lang.Object> $haveFltF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "haveFltF", "HAVE_FLT_F", true, true);

    /** the needRfmFltF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.Short, java.lang.Object> $needRfmFltF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "needRfmFltF", "NEED_RFM_FLT_F", true, true);

    /** the rfmDeadline */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.math.BigInteger, java.lang.Object> $rfmDeadline = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "rfmDeadline", "RFM_DEADLINE", true, true);

    /** the deadline */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object> $deadline = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "deadline", "DEADLINE", true, true);

    /** the revisionCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $revisionCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "revisionCd", "REVISION_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the qaWorkCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object> $qaWorkCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.Qa.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaWorkCd", "QA_WORK_CD", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.QaListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>> __entityPropertyTypeMap;

    private _Qa() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.QaListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "Qa";
        __catalogName = "";
        __schemaName = "";
        __tableName = "QA";
        __qualifiedTableName = "QA";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>>(27);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>>(27);
        __idList.add($qaPk);
        __list.add($qaPk);
        __map.put("qaPk", $qaPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($qaTyCd);
        __map.put("qaTyCd", $qaTyCd);
        __list.add($planTime);
        __map.put("planTime", $planTime);
        __list.add($execBeginTime);
        __map.put("execBeginTime", $execBeginTime);
        __list.add($execEndTime);
        __map.put("execEndTime", $execEndTime);
        __list.add($execUserId);
        __map.put("execUserId", $execUserId);
        __list.add($execDeptCd);
        __map.put("execDeptCd", $execDeptCd);
        __list.add($cmplF);
        __map.put("cmplF", $cmplF);
        __list.add($haveFltF);
        __map.put("haveFltF", $haveFltF);
        __list.add($needRfmFltF);
        __map.put("needRfmFltF", $needRfmFltF);
        __list.add($rfmDeadline);
        __map.put("rfmDeadline", $rfmDeadline);
        __list.add($deadline);
        __map.put("deadline", $deadline);
        __list.add($revisionCd);
        __map.put("revisionCd", $revisionCd);
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
        __list.add($qaWorkCd);
        __map.put("qaWorkCd", $qaWorkCd);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.Qa entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.Qa> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.Qa entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.Qa> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.Qa entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.Qa> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.Qa entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.Qa> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.Qa entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.Qa> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.Qa entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.Qa> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.Qa, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.Qa, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.Qa newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.Qa();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.Qa newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.Qa();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.Qa> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.Qa.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.Qa getOriginalStates(pkuhit.iih.qa.dao.auto.entity.Qa __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.Qa __entity) {
    }

    /**
     * @return the singleton
     */
    public static _Qa getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _Qa newInstance() {
        return new _Qa();
    }

}
