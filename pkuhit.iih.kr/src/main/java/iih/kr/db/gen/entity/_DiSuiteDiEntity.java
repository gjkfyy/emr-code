package iih.kr.db.gen.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:18.135+0800")
public final class _DiSuiteDiEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.gen.entity.DiSuiteDiEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DiSuiteDiEntity __singleton = new _DiSuiteDiEntity();

    /** the diSuiteDiCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $diSuiteDiCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteDiCd", "DI_SUITE_DI_CD");

    /** the diCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $diCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCd", "DI_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.Integer, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.Integer, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.math.BigInteger, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.sql.Timestamp, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.sql.Timestamp, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.Short, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the diSuiteTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $diSuiteTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteTpCd", "DI_SUITE_TP_CD", true, true);

    /** the diSuiteCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $diSuiteCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteCd", "DI_SUITE_CD", true, true);

    /** the relDiCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $relDiCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "relDiCd", "REL_DI_CD", true, true);

    /** the relDiNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $relDiNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "relDiNm", "REL_DI_NM", true, true);

    /** the relDiIcd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $relDiIcd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "relDiIcd", "REL_DI_ICD", true, true);

    /** the ownerTypeCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $ownerTypeCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerTypeCode", "OWNER_TYPE_CD", true, true);

    /** the ownerCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $ownerCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerCode", "OWNER_CD", true, true);

    /** the ownerName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $ownerName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerName", "OWNER_NM", true, true);

    /** the diNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $diNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diNm", "DI_NM", true, true);

    /** the enTypeCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object> $enTypeCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.DiSuiteDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enTypeCode", "EN_TP_CD", true, true);

    private final iih.kr.db.gen.entity.DiSuiteDiEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>> __entityPropertyTypeMap;

    private _DiSuiteDiEntity() {
        __listener = new iih.kr.db.gen.entity.DiSuiteDiEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DiSuiteDiEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DI_SUITE_DI";
        __qualifiedTableName = "DI_SUITE_DI";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>>(24);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>>(24);
        __idList.add($diSuiteDiCd);
        __list.add($diSuiteDiCd);
        __map.put("diSuiteDiCd", $diSuiteDiCd);
        __list.add($diCd);
        __map.put("diCd", $diCd);
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
        __list.add($diSuiteTpCd);
        __map.put("diSuiteTpCd", $diSuiteTpCd);
        __list.add($diSuiteCd);
        __map.put("diSuiteCd", $diSuiteCd);
        __list.add($relDiCd);
        __map.put("relDiCd", $relDiCd);
        __list.add($relDiNm);
        __map.put("relDiNm", $relDiNm);
        __list.add($relDiIcd);
        __map.put("relDiIcd", $relDiIcd);
        __list.add($ownerTypeCode);
        __map.put("ownerTypeCode", $ownerTypeCode);
        __list.add($ownerCode);
        __map.put("ownerCode", $ownerCode);
        __list.add($ownerName);
        __map.put("ownerName", $ownerName);
        __list.add($diNm);
        __map.put("diNm", $diNm);
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
    public void preInsert(iih.kr.db.gen.entity.DiSuiteDiEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.gen.entity.DiSuiteDiEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.gen.entity.DiSuiteDiEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.gen.entity.DiSuiteDiEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.gen.entity.DiSuiteDiEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.gen.entity.DiSuiteDiEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.gen.entity.DiSuiteDiEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.gen.entity.DiSuiteDiEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.gen.entity.DiSuiteDiEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.gen.entity.DiSuiteDiEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.gen.entity.DiSuiteDiEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.gen.entity.DiSuiteDiEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.DiSuiteDiEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.gen.entity.DiSuiteDiEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteDiEntity newEntity() {
        return new iih.kr.db.gen.entity.DiSuiteDiEntity();
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteDiEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.gen.entity.DiSuiteDiEntity();
    }

    @Override
    public Class<iih.kr.db.gen.entity.DiSuiteDiEntity> getEntityClass() {
        return iih.kr.db.gen.entity.DiSuiteDiEntity.class;
    }

    @Override
    public iih.kr.db.gen.entity.DiSuiteDiEntity getOriginalStates(iih.kr.db.gen.entity.DiSuiteDiEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.gen.entity.DiSuiteDiEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _DiSuiteDiEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _DiSuiteDiEntity newInstance() {
        return new _DiSuiteDiEntity();
    }

}
