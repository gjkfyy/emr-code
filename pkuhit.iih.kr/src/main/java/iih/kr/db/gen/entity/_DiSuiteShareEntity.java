package iih.kr.db.gen.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:18.116+0800")
public final class _DiSuiteShareEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.gen.entity.DiSuiteShareEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DiSuiteShareEntity __singleton = new _DiSuiteShareEntity();

    /** the diSuiteShareCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $diSuiteShareCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteShareCd", "DI_SUITE_SHARE_CD");

    /** the ownerTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $ownerTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerTypeCd", "OWNER_TYPE_CD", true, true);

    /** the ownerCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $ownerCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerCd", "OWNER_CD", true, true);

    /** the shareNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $shareNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "shareNm", "SHARE_NM", true, true);

    /** the toOwnerTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $toOwnerTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "toOwnerTypeCd", "TO_OWNER_TYPE_CD", true, true);

    /** the toOwnerCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $toOwnerCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "toOwnerCd", "TO_OWNER_CD", true, true);

    /** the toShareNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $toShareNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "toShareNm", "TO_SHARE_NM", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.Integer, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.Integer, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.math.BigInteger, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.sql.Timestamp, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.sql.Timestamp, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, java.lang.Short, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteShareEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final iih.kr.db.gen.entity.DiSuiteShareEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>> __entityPropertyTypeMap;

    private _DiSuiteShareEntity() {
        __listener = new iih.kr.db.gen.entity.DiSuiteShareEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DiSuiteShareEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DI_SUITE_SHARE";
        __qualifiedTableName = "DI_SUITE_SHARE";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>>(19);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>>(19);
        __idList.add($diSuiteShareCd);
        __list.add($diSuiteShareCd);
        __map.put("diSuiteShareCd", $diSuiteShareCd);
        __list.add($ownerTypeCd);
        __map.put("ownerTypeCd", $ownerTypeCd);
        __list.add($ownerCd);
        __map.put("ownerCd", $ownerCd);
        __list.add($shareNm);
        __map.put("shareNm", $shareNm);
        __list.add($toOwnerTypeCd);
        __map.put("toOwnerTypeCd", $toOwnerTypeCd);
        __list.add($toOwnerCd);
        __map.put("toOwnerCd", $toOwnerCd);
        __list.add($toShareNm);
        __map.put("toShareNm", $toShareNm);
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
    public void preInsert(iih.kr.db.gen.entity.DiSuiteShareEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.gen.entity.DiSuiteShareEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.gen.entity.DiSuiteShareEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.gen.entity.DiSuiteShareEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.gen.entity.DiSuiteShareEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.gen.entity.DiSuiteShareEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.gen.entity.DiSuiteShareEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.gen.entity.DiSuiteShareEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.gen.entity.DiSuiteShareEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.gen.entity.DiSuiteShareEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.gen.entity.DiSuiteShareEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.gen.entity.DiSuiteShareEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteShareEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteShareEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteShareEntity newEntity() {
        return new iih.kr.db.gen.entity.DiSuiteShareEntity();
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteShareEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.gen.entity.DiSuiteShareEntity();
    }

    @Override
    public Class<iih.kr.db.gen.entity.DiSuiteShareEntity> getEntityClass() {
        return iih.kr.db.gen.entity.DiSuiteShareEntity.class;
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteShareEntity getOriginalStates(iih.kr.db.gen.entity.DiSuiteShareEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.gen.entity.DiSuiteShareEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _DiSuiteShareEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _DiSuiteShareEntity newInstance() {
        return new _DiSuiteShareEntity();
    }

}
