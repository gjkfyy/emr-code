package pkuhit.me.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.240+0800")
public final class _MeXsv extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.me.dao.auto.entity.MeXsv> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MeXsv __singleton = new _MeXsv();

    /** the xsvCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $xsvCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "xsvCd", "XSV_CD");

    /** the objCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $objCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objCd", "OBJ_CD", true, true);

    /** the rtXsvCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $rtXsvCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rtXsvCd", "RT_XSV_CD", true, true);

    /** the verNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $verNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "verNo", "VER_NO", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "DES", true, true);

    /** the shtNmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $shtNmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "shtNmEn", "SHT_NM_EN", true, true);

    /** the nmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $nmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nmEn", "NM_EN", true, true);

    /** the restActCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $restActCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "restActCd", "REST_ACT_CD", true, true);

    /** the restRe */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $restRe = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "restRe", "REST_RE", true, true);

    /** the acAuF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.Short, java.lang.Object> $acAuF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "acAuF", "AC_AU_F", true, true);

    /** the pfmAuF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.Short, java.lang.Object> $pfmAuF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "pfmAuF", "PFM_AU_F", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.Short, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeXsv.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.me.dao.auto.entity.MeXsvListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>> __entityPropertyTypeMap;

    private _MeXsv() {
        __listener = new pkuhit.me.dao.auto.entity.MeXsvListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MeXsv";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ME_XSV";
        __qualifiedTableName = "ME_XSV";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>>(24);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>>(24);
        __idList.add($xsvCd);
        __list.add($xsvCd);
        __map.put("xsvCd", $xsvCd);
        __list.add($objCd);
        __map.put("objCd", $objCd);
        __list.add($rtXsvCd);
        __map.put("rtXsvCd", $rtXsvCd);
        __list.add($verNo);
        __map.put("verNo", $verNo);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($des);
        __map.put("des", $des);
        __list.add($shtNmEn);
        __map.put("shtNmEn", $shtNmEn);
        __list.add($nmEn);
        __map.put("nmEn", $nmEn);
        __list.add($restActCd);
        __map.put("restActCd", $restActCd);
        __list.add($restRe);
        __map.put("restRe", $restRe);
        __list.add($acAuF);
        __map.put("acAuF", $acAuF);
        __list.add($pfmAuF);
        __map.put("pfmAuF", $pfmAuF);
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
    public void preInsert(pkuhit.me.dao.auto.entity.MeXsv entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.me.dao.auto.entity.MeXsv> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.me.dao.auto.entity.MeXsv entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.me.dao.auto.entity.MeXsv> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.me.dao.auto.entity.MeXsv entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.me.dao.auto.entity.MeXsv> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.me.dao.auto.entity.MeXsv entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.me.dao.auto.entity.MeXsv> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.me.dao.auto.entity.MeXsv entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.me.dao.auto.entity.MeXsv> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.me.dao.auto.entity.MeXsv entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.me.dao.auto.entity.MeXsv> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeXsv, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeXsv, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeXsv newEntity() {
        return new pkuhit.me.dao.auto.entity.MeXsv();
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeXsv newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.me.dao.auto.entity.MeXsv();
    }

    @Override
    public Class<pkuhit.me.dao.auto.entity.MeXsv> getEntityClass() {
        return pkuhit.me.dao.auto.entity.MeXsv.class;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeXsv getOriginalStates(pkuhit.me.dao.auto.entity.MeXsv __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.me.dao.auto.entity.MeXsv __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MeXsv getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MeXsv newInstance() {
        return new _MeXsv();
    }

}
