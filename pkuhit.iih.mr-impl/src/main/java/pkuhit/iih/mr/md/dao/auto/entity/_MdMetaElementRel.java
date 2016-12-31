package pkuhit.iih.mr.md.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.869+0800")
public final class _MdMetaElementRel extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MdMetaElementRel __singleton = new _MdMetaElementRel();

    /** the dataElementRelCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $dataElementRelCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataElementRelCd", "DATA_ELEMENT_REL_CD");

    /** the dataElementCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $dataElementCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataElementCd", "DATA_ELEMENT_CD", true, true);

    /** the codeSystemCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $codeSystemCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "codeSystemCd", "CODE_SYSTEM_CD", true, true);

    /** the codeSystemDataElementCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $codeSystemDataElementCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "codeSystemDataElementCd", "CODE_SYSTEM_DATA_ELEMENT_CD", true, true);

    /** the codeSystemDataElementVer */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.math.BigDecimal, java.lang.Object> $codeSystemDataElementVer = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.math.BigDecimal, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.math.BigDecimal.class, org.seasar.doma.wrapper.BigDecimalWrapper.class, null, null, "codeSystemDataElementVer", "CODE_SYSTEM_DATA_ELEMENT_VER", true, true);

    /** the descriptions */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $descriptions = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "descriptions", "DESCRIPTIONS", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRelListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>> __entityPropertyTypeMap;

    private _MdMetaElementRel() {
        __listener = new pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRelListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MdMetaElementRel";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MD_META_ELEMENT_REL";
        __qualifiedTableName = "MD_META_ELEMENT_REL";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>>(18);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>>(18);
        __idList.add($dataElementRelCd);
        __list.add($dataElementRelCd);
        __map.put("dataElementRelCd", $dataElementRelCd);
        __list.add($dataElementCd);
        __map.put("dataElementCd", $dataElementCd);
        __list.add($codeSystemCd);
        __map.put("codeSystemCd", $codeSystemCd);
        __list.add($codeSystemDataElementCd);
        __map.put("codeSystemDataElementCd", $codeSystemDataElementCd);
        __list.add($codeSystemDataElementVer);
        __map.put("codeSystemDataElementVer", $codeSystemDataElementVer);
        __list.add($descriptions);
        __map.put("descriptions", $descriptions);
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
    public void preInsert(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel newEntity() {
        return new pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel();
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel();
    }

    @Override
    public Class<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel> getEntityClass() {
        return pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel.class;
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel getOriginalStates(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementRel __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MdMetaElementRel getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MdMetaElementRel newInstance() {
        return new _MdMetaElementRel();
    }

}
