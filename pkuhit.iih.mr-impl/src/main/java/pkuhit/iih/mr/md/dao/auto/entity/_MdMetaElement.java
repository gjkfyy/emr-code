package pkuhit.iih.mr.md.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.232+0800")
public final class _MdMetaElement extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MdMetaElement __singleton = new _MdMetaElement();

    /** the dataElementCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $dataElementCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataElementCd", "DATA_ELEMENT_CD");

    /** the dataElementNmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $dataElementNmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataElementNmEn", "DATA_ELEMENT_NM_EN", true, true);

    /** the dataElementNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $dataElementNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataElementNm", "DATA_ELEMENT_NM", true, true);

    /** the dataMetaTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $dataMetaTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataMetaTypeCd", "DATA_META_TYPE_CD", true, true);

    /** the dataMetaStatusCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $dataMetaStatusCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataMetaStatusCd", "DATA_META_STATUS_CD", true, true);

    /** the dataTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $dataTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataTypeCd", "DATA_TYPE_CD", true, true);

    /** the defaultValue */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $defaultValue = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "defaultValue", "DEFAULT_VALUE", true, true);

    /** the defaultUnitCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $defaultUnitCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "defaultUnitCd", "DEFAULT_UNIT_CD", true, true);

    /** the relatedMasterTableCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $relatedMasterTableCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "relatedMasterTableCd", "RELATED_MASTER_TABLE_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>> __entityPropertyTypeMap;

    private _MdMetaElement() {
        __listener = new pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MdMetaElement";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MD_META_ELEMENT";
        __qualifiedTableName = "MD_META_ELEMENT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>>(21);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>>(21);
        __idList.add($dataElementCd);
        __list.add($dataElementCd);
        __map.put("dataElementCd", $dataElementCd);
        __list.add($dataElementNmEn);
        __map.put("dataElementNmEn", $dataElementNmEn);
        __list.add($dataElementNm);
        __map.put("dataElementNm", $dataElementNm);
        __list.add($dataMetaTypeCd);
        __map.put("dataMetaTypeCd", $dataMetaTypeCd);
        __list.add($dataMetaStatusCd);
        __map.put("dataMetaStatusCd", $dataMetaStatusCd);
        __list.add($dataTypeCd);
        __map.put("dataTypeCd", $dataTypeCd);
        __list.add($defaultValue);
        __map.put("defaultValue", $defaultValue);
        __list.add($defaultUnitCd);
        __map.put("defaultUnitCd", $defaultUnitCd);
        __list.add($relatedMasterTableCd);
        __map.put("relatedMasterTableCd", $relatedMasterTableCd);
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
    public void preInsert(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement newEntity() {
        return new pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement();
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement();
    }

    @Override
    public Class<pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement> getEntityClass() {
        return pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement.class;
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement getOriginalStates(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MdMetaElement getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MdMetaElement newInstance() {
        return new _MdMetaElement();
    }

}
