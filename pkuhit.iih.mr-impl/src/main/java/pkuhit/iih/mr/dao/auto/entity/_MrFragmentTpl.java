package pkuhit.iih.mr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.229+0800")
public final class _MrFragmentTpl extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MrFragmentTpl __singleton = new _MrFragmentTpl();

    /** the fragmentTplCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $fragmentTplCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fragmentTplCd", "FRAGMENT_TPL_CD");

    /** the fragmentTplContent */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $fragmentTplContent = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fragmentTplContent", "FRAGMENT_TPL_CONTENT", true, true);

    /** the fragmentTplTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $fragmentTplTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fragmentTplTypeCd", "FRAGMENT_TPL_TYPE_CD", true, true);

    /** the ownerTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $ownerTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerTypeCd", "OWNER_TYPE_CD", true, true);

    /** the ownerCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $ownerCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerCd", "OWNER_CD", true, true);

    /** the fragmentTplNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $fragmentTplNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fragmentTplNm", "FRAGMENT_TPL_NM", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.Long, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.Long, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.Long.class, org.seasar.doma.wrapper.LongWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.Integer, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.Integer, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.mr.dao.auto.entity.MrFragmentTplListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>> __entityPropertyTypeMap;

    private _MrFragmentTpl() {
        __listener = new pkuhit.iih.mr.dao.auto.entity.MrFragmentTplListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MrFragmentTpl";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MR_FRAGMENT_TPL";
        __qualifiedTableName = "MR_FRAGMENT_TPL";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>>(18);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>>(18);
        __idList.add($fragmentTplCd);
        __list.add($fragmentTplCd);
        __map.put("fragmentTplCd", $fragmentTplCd);
        __list.add($fragmentTplContent);
        __map.put("fragmentTplContent", $fragmentTplContent);
        __list.add($fragmentTplTypeCd);
        __map.put("fragmentTplTypeCd", $fragmentTplTypeCd);
        __list.add($ownerTypeCd);
        __map.put("ownerTypeCd", $ownerTypeCd);
        __list.add($ownerCd);
        __map.put("ownerCd", $ownerCd);
        __list.add($fragmentTplNm);
        __map.put("fragmentTplNm", $fragmentTplNm);
        __list.add($spellNo);
        __map.put("spellNo", $spellNo);
        __list.add($wubiNo);
        __map.put("wubiNo", $wubiNo);
        __list.add($sortNo);
        __map.put("sortNo", $sortNo);
        __list.add($memo);
        __map.put("memo", $memo);
        __list.add($updCnt);
        __map.put("updCnt", $updCnt);
        __list.add($crtUserId);
        __map.put("crtUserId", $crtUserId);
        __list.add($crtDeptCd);
        __map.put("crtDeptCd", $crtDeptCd);
        __list.add($crtTime);
        __map.put("crtTime", $crtTime);
        __list.add($lastUpdUserId);
        __map.put("lastUpdUserId", $lastUpdUserId);
        __list.add($lastUpdDeptCd);
        __map.put("lastUpdDeptCd", $lastUpdDeptCd);
        __list.add($lastUpdTime);
        __map.put("lastUpdTime", $lastUpdTime);
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
    public void preInsert(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl newEntity() {
        return new pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl();
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl();
    }

    @Override
    public Class<pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl> getEntityClass() {
        return pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl.class;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl getOriginalStates(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MrFragmentTpl getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MrFragmentTpl newInstance() {
        return new _MrFragmentTpl();
    }

}
