package pkuhit.me.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.293+0800")
public final class _MeDataAcru extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.me.dao.auto.entity.MeDataAcru> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MeDataAcru __singleton = new _MeDataAcru();

    /** the dataAcruCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $dataAcruCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataAcruCd", "DATA_ACRU_CD");

    /** the objCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $objCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objCd", "OBJ_CD", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "DES", true, true);

    /** the shtNmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $shtNmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "shtNmEn", "SHT_NM_EN", true, true);

    /** the nmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $nmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nmEn", "NM_EN", true, true);

    /** the rule */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $rule = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rule", "RULE", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeDataAcru.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.me.dao.auto.entity.MeDataAcruListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>> __entityPropertyTypeMap;

    private _MeDataAcru() {
        __listener = new pkuhit.me.dao.auto.entity.MeDataAcruListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MeDataAcru";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ME_DATA_ACRU";
        __qualifiedTableName = "ME_DATA_ACRU";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>>(16);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>>(16);
        __idList.add($dataAcruCd);
        __list.add($dataAcruCd);
        __map.put("dataAcruCd", $dataAcruCd);
        __list.add($objCd);
        __map.put("objCd", $objCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($des);
        __map.put("des", $des);
        __list.add($shtNmEn);
        __map.put("shtNmEn", $shtNmEn);
        __list.add($nmEn);
        __map.put("nmEn", $nmEn);
        __list.add($rule);
        __map.put("rule", $rule);
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
    public void preInsert(pkuhit.me.dao.auto.entity.MeDataAcru entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.me.dao.auto.entity.MeDataAcru> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.me.dao.auto.entity.MeDataAcru entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.me.dao.auto.entity.MeDataAcru> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.me.dao.auto.entity.MeDataAcru entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.me.dao.auto.entity.MeDataAcru> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.me.dao.auto.entity.MeDataAcru entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.me.dao.auto.entity.MeDataAcru> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.me.dao.auto.entity.MeDataAcru entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.me.dao.auto.entity.MeDataAcru> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.me.dao.auto.entity.MeDataAcru entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.me.dao.auto.entity.MeDataAcru> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeDataAcru, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeDataAcru, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeDataAcru newEntity() {
        return new pkuhit.me.dao.auto.entity.MeDataAcru();
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeDataAcru newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.me.dao.auto.entity.MeDataAcru();
    }

    @Override
    public Class<pkuhit.me.dao.auto.entity.MeDataAcru> getEntityClass() {
        return pkuhit.me.dao.auto.entity.MeDataAcru.class;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeDataAcru getOriginalStates(pkuhit.me.dao.auto.entity.MeDataAcru __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.me.dao.auto.entity.MeDataAcru __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MeDataAcru getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MeDataAcru newInstance() {
        return new _MeDataAcru();
    }

}
