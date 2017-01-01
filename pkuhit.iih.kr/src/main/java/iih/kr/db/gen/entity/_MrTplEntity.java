package iih.kr.db.gen.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.115+0800")
public final class _MrTplEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.gen.entity.MrTplEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MrTplEntity __singleton = new _MrTplEntity();

    /** the mrTplCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $mrTplCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTplCd", "MR_TPL_CD");

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD", true, true);

    /** the mrBaseTplCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $mrBaseTplCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrBaseTplCd", "MR_BASE_TPL_CD", true, true);

    /** the filePk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $filePk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "filePk", "FILE_PK", true, true);

    /** the mrTplStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $mrTplStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTplStaCd", "MR_TPL_STA_CD", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "DES", true, true);

    /** the ownTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $ownTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownTpCd", "OWN_TP_CD", true, true);

    /** the ownCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $ownCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownCd", "OWN_CD", true, true);

    /** the mrTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $mrTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTpCd", "MR_TP_CD", true, true);

    /** the mrSignLvlCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $mrSignLvlCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrSignLvlCd", "MR_SIGN_LVL_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.math.BigInteger, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.sql.Timestamp, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.sql.Timestamp, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.Short, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the enTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object> $enTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.String, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enTpCd", "EN_TP_CD", true, true);

    /** the defaultF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.Short, java.lang.Object> $defaultF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, java.lang.Short, java.lang.Object>(iih.kr.db.gen.entity.MrTplEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "defaultF", "DEFAULT_F", true, true);

    private final iih.kr.db.gen.entity.MrTplEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>> __entityPropertyTypeMap;

    private _MrTplEntity() {
        __listener = new iih.kr.db.gen.entity.MrTplEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MrTplEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MR_TPL";
        __qualifiedTableName = "MR_TPL";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>>(25);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>>(25);
        __idList.add($mrTplCd);
        __list.add($mrTplCd);
        __map.put("mrTplCd", $mrTplCd);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($mrBaseTplCd);
        __map.put("mrBaseTplCd", $mrBaseTplCd);
        __list.add($filePk);
        __map.put("filePk", $filePk);
        __list.add($mrTplStaCd);
        __map.put("mrTplStaCd", $mrTplStaCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($des);
        __map.put("des", $des);
        __list.add($ownTpCd);
        __map.put("ownTpCd", $ownTpCd);
        __list.add($ownCd);
        __map.put("ownCd", $ownCd);
        __list.add($mrTpCd);
        __map.put("mrTpCd", $mrTpCd);
        __list.add($mrSignLvlCd);
        __map.put("mrSignLvlCd", $mrSignLvlCd);
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
        __list.add($enTpCd);
        __map.put("enTpCd", $enTpCd);
        __list.add($defaultF);
        __map.put("defaultF", $defaultF);
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
    public void preInsert(iih.kr.db.gen.entity.MrTplEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.gen.entity.MrTplEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.gen.entity.MrTplEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.gen.entity.MrTplEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.gen.entity.MrTplEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.gen.entity.MrTplEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.gen.entity.MrTplEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.gen.entity.MrTplEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.gen.entity.MrTplEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.gen.entity.MrTplEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.gen.entity.MrTplEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.gen.entity.MrTplEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.gen.entity.MrTplEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.gen.entity.MrTplEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.gen.entity.MrTplEntity newEntity() {
        return new iih.kr.db.gen.entity.MrTplEntity();
    }

    @Override
    public iih.kr.db.gen.entity.MrTplEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.gen.entity.MrTplEntity();
    }

    @Override
    public Class<iih.kr.db.gen.entity.MrTplEntity> getEntityClass() {
        return iih.kr.db.gen.entity.MrTplEntity.class;
    }

    @Override
    public iih.kr.db.gen.entity.MrTplEntity getOriginalStates(iih.kr.db.gen.entity.MrTplEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.gen.entity.MrTplEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MrTplEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MrTplEntity newInstance() {
        return new _MrTplEntity();
    }

}
