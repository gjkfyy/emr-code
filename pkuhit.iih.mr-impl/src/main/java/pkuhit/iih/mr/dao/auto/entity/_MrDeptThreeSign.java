package pkuhit.iih.mr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.202+0800")
public final class _MrDeptThreeSign extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MrDeptThreeSign __singleton = new _MrDeptThreeSign();

    /** the singCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $singCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "singCd", "SING_CD");

    /** the deptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $deptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptCd", "DEPT_CD", true, true);

    /** the employeeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $employeeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "employeeCd", "EMPLOYEE_CD", true, true);

    /** the signLvlCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $signLvlCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "signLvlCd", "SIGN_LVL_CD", true, true);

    /** the mngDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $mngDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mngDctId", "MNG_DCT_ID", true, true);

    /** the supDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $supDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "supDctId", "SUP_DCT_ID", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSignListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>> __entityPropertyTypeMap;

    private _MrDeptThreeSign() {
        __listener = new pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSignListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MrDeptThreeSign";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MR_DEPT_THREE_SIGN";
        __qualifiedTableName = "MR_DEPT_THREE_SIGN";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>>(18);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>>(18);
        __idList.add($singCd);
        __list.add($singCd);
        __map.put("singCd", $singCd);
        __list.add($deptCd);
        __map.put("deptCd", $deptCd);
        __list.add($employeeCd);
        __map.put("employeeCd", $employeeCd);
        __list.add($signLvlCd);
        __map.put("signLvlCd", $signLvlCd);
        __list.add($mngDctId);
        __map.put("mngDctId", $mngDctId);
        __list.add($supDctId);
        __map.put("supDctId", $supDctId);
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
    public void preInsert(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign newEntity() {
        return new pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign();
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign();
    }

    @Override
    public Class<pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign> getEntityClass() {
        return pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign.class;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign getOriginalStates(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.dao.auto.entity.MrDeptThreeSign __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MrDeptThreeSign getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MrDeptThreeSign newInstance() {
        return new _MrDeptThreeSign();
    }

}
