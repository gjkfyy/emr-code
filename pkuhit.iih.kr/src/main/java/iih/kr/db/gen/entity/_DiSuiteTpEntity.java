package iih.kr.db.gen.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:18.131+0800")
public final class _DiSuiteTpEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.gen.entity.DiSuiteTpEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DiSuiteTpEntity __singleton = new _DiSuiteTpEntity();

    /** the diSuiteTpCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $diSuiteTpCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteTpCd", "DI_SUITE_TP_CD");

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD", true, true);

    /** the diSuiteTpNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $diSuiteTpNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteTpNm", "DI_SUITE_TP_NM", true, true);

    /** the descr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $descr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "descr", "DESCR", true, true);

    /** the ownerTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $ownerTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerTypeCd", "OWNER_TYPE_CD", true, true);

    /** the ownerCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $ownerCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerCd", "OWNER_CD", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.Integer, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.Integer, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.math.BigInteger, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.sql.Timestamp, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.sql.Timestamp, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.Short, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the enTypeCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object> $enTypeCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteTpEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enTypeCode", "EN_TP_CD", true, true);

    private final iih.kr.db.gen.entity.DiSuiteTpEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>> __entityPropertyTypeMap;

    private _DiSuiteTpEntity() {
        __listener = new iih.kr.db.gen.entity.DiSuiteTpEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DiSuiteTpEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DI_SUITE_TP";
        __qualifiedTableName = "DI_SUITE_TP";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>>(18);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>>(18);
        __idList.add($diSuiteTpCd);
        __list.add($diSuiteTpCd);
        __map.put("diSuiteTpCd", $diSuiteTpCd);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($diSuiteTpNm);
        __map.put("diSuiteTpNm", $diSuiteTpNm);
        __list.add($descr);
        __map.put("descr", $descr);
        __list.add($ownerTypeCd);
        __map.put("ownerTypeCd", $ownerTypeCd);
        __list.add($ownerCd);
        __map.put("ownerCd", $ownerCd);
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
        __list.add($enTypeCode);
        __map.put("enTypeCode", $enTypeCode);
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
    public void preInsert(iih.kr.db.gen.entity.DiSuiteTpEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.gen.entity.DiSuiteTpEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.gen.entity.DiSuiteTpEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.gen.entity.DiSuiteTpEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.gen.entity.DiSuiteTpEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.gen.entity.DiSuiteTpEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.gen.entity.DiSuiteTpEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.gen.entity.DiSuiteTpEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.gen.entity.DiSuiteTpEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.gen.entity.DiSuiteTpEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.gen.entity.DiSuiteTpEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.gen.entity.DiSuiteTpEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteTpEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteTpEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteTpEntity newEntity() {
        return new iih.kr.db.gen.entity.DiSuiteTpEntity();
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteTpEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.gen.entity.DiSuiteTpEntity();
    }

    @Override
    public Class<iih.kr.db.gen.entity.DiSuiteTpEntity> getEntityClass() {
        return iih.kr.db.gen.entity.DiSuiteTpEntity.class;
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteTpEntity getOriginalStates(iih.kr.db.gen.entity.DiSuiteTpEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.gen.entity.DiSuiteTpEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _DiSuiteTpEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _DiSuiteTpEntity newInstance() {
        return new _DiSuiteTpEntity();
    }

}
