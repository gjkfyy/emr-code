package iih.di.db.gen.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:37.047+0800")
public final class _MdDiEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.di.db.gen.entity.MdDiEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MdDiEntity __singleton = new _MdDiEntity();

    /** the diCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $diCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCd", "DI_CD");

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "DES", true, true);

    /** the icdCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $icdCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "icdCd", "ICD_CD", true, true);

    /** the infF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.Short, java.lang.Object> $infF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "infF", "INF_F", true, true);

    /** the symF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.Short, java.lang.Object> $symF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "symF", "SYM_F", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.math.BigInteger, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.sql.Timestamp, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.sql.Timestamp, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.MdDiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final iih.di.db.gen.entity.MdDiEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>> __entityPropertyTypeMap;

    private _MdDiEntity() {
        __listener = new iih.di.db.gen.entity.MdDiEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MdDiEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MD_DI";
        __qualifiedTableName = "MD_DI";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>>(19);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>>(19);
        __idList.add($diCd);
        __list.add($diCd);
        __map.put("diCd", $diCd);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($des);
        __map.put("des", $des);
        __list.add($icdCd);
        __map.put("icdCd", $icdCd);
        __list.add($infF);
        __map.put("infF", $infF);
        __list.add($symF);
        __map.put("symF", $symF);
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
    public void preInsert(iih.di.db.gen.entity.MdDiEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.di.db.gen.entity.MdDiEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.di.db.gen.entity.MdDiEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.di.db.gen.entity.MdDiEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.di.db.gen.entity.MdDiEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.di.db.gen.entity.MdDiEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.di.db.gen.entity.MdDiEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.di.db.gen.entity.MdDiEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.di.db.gen.entity.MdDiEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.di.db.gen.entity.MdDiEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.di.db.gen.entity.MdDiEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.di.db.gen.entity.MdDiEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.MdDiEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.di.db.gen.entity.MdDiEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.di.db.gen.entity.MdDiEntity newEntity() {
        return new iih.di.db.gen.entity.MdDiEntity();
    }

    @Override
    public iih.di.db.gen.entity.MdDiEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.di.db.gen.entity.MdDiEntity();
    }

    @Override
    public Class<iih.di.db.gen.entity.MdDiEntity> getEntityClass() {
        return iih.di.db.gen.entity.MdDiEntity.class;
    }

    @Override
    public iih.di.db.gen.entity.MdDiEntity getOriginalStates(iih.di.db.gen.entity.MdDiEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.di.db.gen.entity.MdDiEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MdDiEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MdDiEntity newInstance() {
        return new _MdDiEntity();
    }

}
