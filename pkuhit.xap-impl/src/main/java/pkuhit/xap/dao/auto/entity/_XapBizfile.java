package pkuhit.xap.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.263+0800")
public final class _XapBizfile extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.xap.dao.auto.entity.XapBizfile> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _XapBizfile __singleton = new _XapBizfile();

    /** the filePk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $filePk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "filePk", "FILE_PK");

    /** the fileFmtCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $fileFmtCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fileFmtCd", "FILE_FMT_CD", true, true);

    /** the fileData */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.sql.Clob, java.lang.Object> $fileData = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.sql.Clob, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.sql.Clob.class, org.seasar.doma.wrapper.ClobWrapper.class, null, null, "fileData", "FILE_DATA", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.math.BigInteger, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, java.lang.Short, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapBizfile.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.xap.dao.auto.entity.XapBizfileListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>> __entityPropertyTypeMap;

    private _XapBizfile() {
        __listener = new pkuhit.xap.dao.auto.entity.XapBizfileListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "XapBizfile";
        __catalogName = "";
        __schemaName = "";
        __tableName = "XAP_BIZFILE";
        __qualifiedTableName = "XAP_BIZFILE";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>>(15);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>>(15);
        __idList.add($filePk);
        __list.add($filePk);
        __map.put("filePk", $filePk);
        __list.add($fileFmtCd);
        __map.put("fileFmtCd", $fileFmtCd);
        __list.add($fileData);
        __map.put("fileData", $fileData);
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
    public void preInsert(pkuhit.xap.dao.auto.entity.XapBizfile entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.xap.dao.auto.entity.XapBizfile> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.xap.dao.auto.entity.XapBizfile entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.xap.dao.auto.entity.XapBizfile> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.xap.dao.auto.entity.XapBizfile entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.xap.dao.auto.entity.XapBizfile> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.xap.dao.auto.entity.XapBizfile entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.xap.dao.auto.entity.XapBizfile> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.xap.dao.auto.entity.XapBizfile entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.xap.dao.auto.entity.XapBizfile> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.xap.dao.auto.entity.XapBizfile entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.xap.dao.auto.entity.XapBizfile> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapBizfile, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapBizfile, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapBizfile newEntity() {
        return new pkuhit.xap.dao.auto.entity.XapBizfile();
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapBizfile newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.xap.dao.auto.entity.XapBizfile();
    }

    @Override
    public Class<pkuhit.xap.dao.auto.entity.XapBizfile> getEntityClass() {
        return pkuhit.xap.dao.auto.entity.XapBizfile.class;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapBizfile getOriginalStates(pkuhit.xap.dao.auto.entity.XapBizfile __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.xap.dao.auto.entity.XapBizfile __entity) {
    }

    /**
     * @return the singleton
     */
    public static _XapBizfile getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _XapBizfile newInstance() {
        return new _XapBizfile();
    }

}
