package pkuhit.me.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.393+0800")
public final class _MeFuEv extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.me.dao.auto.entity.MeFuEv> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MeFuEv __singleton = new _MeFuEv();

    /** the fuEvCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $fuEvCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fuEvCd", "FU_EV_CD");

    /** the fuElCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $fuElCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fuElCd", "FU_EL_CD", true, true);

    /** the fuActCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $fuActCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fuActCd", "FU_ACT_CD", true, true);

    /** the evTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $evTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "evTpCd", "EV_TP_CD", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeFuEv.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.me.dao.auto.entity.MeFuEvListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>> __entityPropertyTypeMap;

    private _MeFuEv() {
        __listener = new pkuhit.me.dao.auto.entity.MeFuEvListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MeFuEv";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ME_FU_EV";
        __qualifiedTableName = "ME_FU_EV";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>>(13);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>>(13);
        __idList.add($fuEvCd);
        __list.add($fuEvCd);
        __map.put("fuEvCd", $fuEvCd);
        __list.add($fuElCd);
        __map.put("fuElCd", $fuElCd);
        __list.add($fuActCd);
        __map.put("fuActCd", $fuActCd);
        __list.add($evTpCd);
        __map.put("evTpCd", $evTpCd);
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
    public void preInsert(pkuhit.me.dao.auto.entity.MeFuEv entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.me.dao.auto.entity.MeFuEv> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.me.dao.auto.entity.MeFuEv entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.me.dao.auto.entity.MeFuEv> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.me.dao.auto.entity.MeFuEv entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.me.dao.auto.entity.MeFuEv> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.me.dao.auto.entity.MeFuEv entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.me.dao.auto.entity.MeFuEv> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.me.dao.auto.entity.MeFuEv entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.me.dao.auto.entity.MeFuEv> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.me.dao.auto.entity.MeFuEv entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.me.dao.auto.entity.MeFuEv> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeFuEv, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeFuEv, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeFuEv newEntity() {
        return new pkuhit.me.dao.auto.entity.MeFuEv();
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeFuEv newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.me.dao.auto.entity.MeFuEv();
    }

    @Override
    public Class<pkuhit.me.dao.auto.entity.MeFuEv> getEntityClass() {
        return pkuhit.me.dao.auto.entity.MeFuEv.class;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeFuEv getOriginalStates(pkuhit.me.dao.auto.entity.MeFuEv __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.me.dao.auto.entity.MeFuEv __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MeFuEv getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MeFuEv newInstance() {
        return new _MeFuEv();
    }

}
