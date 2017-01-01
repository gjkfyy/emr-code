package pkuhit.org.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.364+0800")
public final class _OrgWgEmp extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.org.dao.auto.entity.OrgWgEmp> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _OrgWgEmp __singleton = new _OrgWgEmp();

    /** the wgEmpCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $wgEmpCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wgEmpCd", "WG_EMP_CD");

    /** the empId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "EMP_ID", true, true);

    /** the wgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $wgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wgCd", "WG_CD", true, true);

    /** the bizRoleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $bizRoleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "bizRoleCd", "BIZ_ROLE_CD", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.math.BigInteger, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, java.lang.Short, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgWgEmp.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.org.dao.auto.entity.OrgWgEmpListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>> __entityPropertyTypeMap;

    private _OrgWgEmp() {
        __listener = new pkuhit.org.dao.auto.entity.OrgWgEmpListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "OrgWgEmp";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ORG_WG_EMP";
        __qualifiedTableName = "ORG_WG_EMP";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>>(13);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>>(13);
        __idList.add($wgEmpCd);
        __list.add($wgEmpCd);
        __map.put("wgEmpCd", $wgEmpCd);
        __list.add($empId);
        __map.put("empId", $empId);
        __list.add($wgCd);
        __map.put("wgCd", $wgCd);
        __list.add($bizRoleCd);
        __map.put("bizRoleCd", $bizRoleCd);
        __list.add($sortNo);
        __map.put("sortNo", $sortNo);
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
    public void preInsert(pkuhit.org.dao.auto.entity.OrgWgEmp entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.org.dao.auto.entity.OrgWgEmp> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.org.dao.auto.entity.OrgWgEmp entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.org.dao.auto.entity.OrgWgEmp> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.org.dao.auto.entity.OrgWgEmp entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.org.dao.auto.entity.OrgWgEmp> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.org.dao.auto.entity.OrgWgEmp entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.org.dao.auto.entity.OrgWgEmp> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.org.dao.auto.entity.OrgWgEmp entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.org.dao.auto.entity.OrgWgEmp> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.org.dao.auto.entity.OrgWgEmp entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.org.dao.auto.entity.OrgWgEmp> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgWgEmp, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgWgEmp, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgWgEmp newEntity() {
        return new pkuhit.org.dao.auto.entity.OrgWgEmp();
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgWgEmp newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.org.dao.auto.entity.OrgWgEmp();
    }

    @Override
    public Class<pkuhit.org.dao.auto.entity.OrgWgEmp> getEntityClass() {
        return pkuhit.org.dao.auto.entity.OrgWgEmp.class;
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgWgEmp getOriginalStates(pkuhit.org.dao.auto.entity.OrgWgEmp __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.org.dao.auto.entity.OrgWgEmp __entity) {
    }

    /**
     * @return the singleton
     */
    public static _OrgWgEmp getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _OrgWgEmp newInstance() {
        return new _OrgWgEmp();
    }

}
