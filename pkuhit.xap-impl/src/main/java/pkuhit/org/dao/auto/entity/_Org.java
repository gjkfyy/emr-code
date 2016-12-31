package pkuhit.org.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.387+0800")
public final class _Org extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.org.dao.auto.entity.Org> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _Org __singleton = new _Org();

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD");

    /** the orgTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $orgTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgTpCd", "ORG_TP_CD", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "DES", true, true);

    /** the shtNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $shtNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "shtNm", "SHT_NM", true, true);

    /** the aliasNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $aliasNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "aliasNm", "ALIAS_NM", true, true);

    /** the distCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $distCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "distCd", "DIST_CD", true, true);

    /** the subdistNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $subdistNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "subdistNm", "SUBDIST_NM", true, true);

    /** the zipNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $zipNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "zipNo", "ZIP_NO", true, true);

    /** the telNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $telNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "telNo", "TEL_NO", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.math.BigInteger, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, java.lang.Short, java.lang.Object>(pkuhit.org.dao.auto.entity.Org.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.org.dao.auto.entity.OrgListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>> __entityPropertyTypeMap;

    private _Org() {
        __listener = new pkuhit.org.dao.auto.entity.OrgListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "Org";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ORG";
        __qualifiedTableName = "ORG";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>>(22);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>>(22);
        __idList.add($orgCd);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($orgTpCd);
        __map.put("orgTpCd", $orgTpCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($des);
        __map.put("des", $des);
        __list.add($shtNm);
        __map.put("shtNm", $shtNm);
        __list.add($aliasNm);
        __map.put("aliasNm", $aliasNm);
        __list.add($distCd);
        __map.put("distCd", $distCd);
        __list.add($subdistNm);
        __map.put("subdistNm", $subdistNm);
        __list.add($zipNo);
        __map.put("zipNo", $zipNo);
        __list.add($telNo);
        __map.put("telNo", $telNo);
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
    public void preInsert(pkuhit.org.dao.auto.entity.Org entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.org.dao.auto.entity.Org> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.org.dao.auto.entity.Org entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.org.dao.auto.entity.Org> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.org.dao.auto.entity.Org entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.org.dao.auto.entity.Org> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.org.dao.auto.entity.Org entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.org.dao.auto.entity.Org> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.org.dao.auto.entity.Org entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.org.dao.auto.entity.Org> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.org.dao.auto.entity.Org entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.org.dao.auto.entity.Org> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.Org, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.Org, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.org.dao.auto.entity.Org newEntity() {
        return new pkuhit.org.dao.auto.entity.Org();
    }

    @Override
    public pkuhit.org.dao.auto.entity.Org newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.org.dao.auto.entity.Org();
    }

    @Override
    public Class<pkuhit.org.dao.auto.entity.Org> getEntityClass() {
        return pkuhit.org.dao.auto.entity.Org.class;
    }

    @Override
    public pkuhit.org.dao.auto.entity.Org getOriginalStates(pkuhit.org.dao.auto.entity.Org __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.org.dao.auto.entity.Org __entity) {
    }

    /**
     * @return the singleton
     */
    public static _Org getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _Org newInstance() {
        return new _Org();
    }

}
