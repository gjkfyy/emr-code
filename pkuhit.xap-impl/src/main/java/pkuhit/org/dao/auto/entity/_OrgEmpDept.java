package pkuhit.org.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.340+0800")
public final class _OrgEmpDept extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.org.dao.auto.entity.OrgEmpDept> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _OrgEmpDept __singleton = new _OrgEmpDept();

    /** the empDeptCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $empDeptCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empDeptCd", "EMP_DEPT_CD");

    /** the wardDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $wardDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wardDeptCd", "WARD_DEPT_CD", true, true);

    /** the empId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "EMP_ID", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.math.BigInteger, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.Short, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the signLvlCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $signLvlCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "signLvlCd", "SIGN_LVL_CD", true, true);

    /** the curDrcDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $curDrcDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curDrcDctId", "CUR_DRC_DCT_ID", true, true);

    /** the curDeputyDrcDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object> $curDeputyDrcDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmpDept.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curDeputyDrcDctId", "CUR_DEPUTY_DRC_DCT_ID", true, true);

    private final pkuhit.org.dao.auto.entity.OrgEmpDeptListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>> __entityPropertyTypeMap;

    private _OrgEmpDept() {
        __listener = new pkuhit.org.dao.auto.entity.OrgEmpDeptListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "OrgEmpDept";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ORG_EMP_DEPT";
        __qualifiedTableName = "ORG_EMP_DEPT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>>(18);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>>(18);
        __idList.add($empDeptCd);
        __list.add($empDeptCd);
        __map.put("empDeptCd", $empDeptCd);
        __list.add($wardDeptCd);
        __map.put("wardDeptCd", $wardDeptCd);
        __list.add($empId);
        __map.put("empId", $empId);
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
        __list.add($signLvlCd);
        __map.put("signLvlCd", $signLvlCd);
        __list.add($curDrcDctId);
        __map.put("curDrcDctId", $curDrcDctId);
        __list.add($curDeputyDrcDctId);
        __map.put("curDeputyDrcDctId", $curDeputyDrcDctId);
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
    public void preInsert(pkuhit.org.dao.auto.entity.OrgEmpDept entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.org.dao.auto.entity.OrgEmpDept> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.org.dao.auto.entity.OrgEmpDept entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.org.dao.auto.entity.OrgEmpDept> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.org.dao.auto.entity.OrgEmpDept entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.org.dao.auto.entity.OrgEmpDept> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.org.dao.auto.entity.OrgEmpDept entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.org.dao.auto.entity.OrgEmpDept> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.org.dao.auto.entity.OrgEmpDept entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.org.dao.auto.entity.OrgEmpDept> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.org.dao.auto.entity.OrgEmpDept entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.org.dao.auto.entity.OrgEmpDept> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmpDept, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmpDept, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgEmpDept newEntity() {
        return new pkuhit.org.dao.auto.entity.OrgEmpDept();
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgEmpDept newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.org.dao.auto.entity.OrgEmpDept();
    }

    @Override
    public Class<pkuhit.org.dao.auto.entity.OrgEmpDept> getEntityClass() {
        return pkuhit.org.dao.auto.entity.OrgEmpDept.class;
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgEmpDept getOriginalStates(pkuhit.org.dao.auto.entity.OrgEmpDept __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.org.dao.auto.entity.OrgEmpDept __entity) {
    }

    /**
     * @return the singleton
     */
    public static _OrgEmpDept getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _OrgEmpDept newInstance() {
        return new _OrgEmpDept();
    }

}
