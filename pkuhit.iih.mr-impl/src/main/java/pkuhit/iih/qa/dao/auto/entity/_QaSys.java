package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.209+0800")
public final class _QaSys extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.QaSys> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _QaSys __singleton = new _QaSys();

    /** the qaSysCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $qaSysCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaSysCd", "QA_SYS_CD");

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD", true, true);

    /** the rtQaSysCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $rtQaSysCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rtQaSysCd", "RT_QA_SYS_CD", true, true);

    /** the verNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $verNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "verNo", "VER_NO", true, true);

    /** the inUseF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.Short, java.lang.Object> $inUseF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "inUseF", "IN_USE_F", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSys.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.QaSysListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>> __entityPropertyTypeMap;

    private _QaSys() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.QaSysListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "QaSys";
        __catalogName = "";
        __schemaName = "";
        __tableName = "QA_SYS";
        __qualifiedTableName = "QA_SYS";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>>(17);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>>(17);
        __idList.add($qaSysCd);
        __list.add($qaSysCd);
        __map.put("qaSysCd", $qaSysCd);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($rtQaSysCd);
        __map.put("rtQaSysCd", $rtQaSysCd);
        __list.add($verNo);
        __map.put("verNo", $verNo);
        __list.add($inUseF);
        __map.put("inUseF", $inUseF);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.QaSys entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.QaSys> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.QaSys entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaSys> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.QaSys entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaSys> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.QaSys entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.QaSys> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.QaSys entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaSys> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.QaSys entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaSys> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSys, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSys, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSys newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.QaSys();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSys newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.QaSys();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.QaSys> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.QaSys.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSys getOriginalStates(pkuhit.iih.qa.dao.auto.entity.QaSys __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.QaSys __entity) {
    }

    /**
     * @return the singleton
     */
    public static _QaSys getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _QaSys newInstance() {
        return new _QaSys();
    }

}
