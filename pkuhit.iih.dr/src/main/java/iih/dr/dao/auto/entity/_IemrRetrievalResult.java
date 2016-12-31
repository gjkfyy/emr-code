package iih.dr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:05.083+0800")
public final class _IemrRetrievalResult extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.dr.dao.auto.entity.IemrRetrievalResult> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _IemrRetrievalResult __singleton = new _IemrRetrievalResult();

    /** the resultCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $resultCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "resultCd", "RESULT_CD");

    /** the retrievalCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $retrievalCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "retrievalCd", "RETRIEVAL_CD", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the mrPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $mrPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrPk", "MR_PK", true, true);

    /** the condCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $condCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "condCd", "COND_CD", true, true);

    /** the condName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $condName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "condName", "COND_NAME", true, true);

    /** the condText */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $condText = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "condText", "COND_TEXT", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.math.BigInteger, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.sql.Timestamp, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.sql.Timestamp, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, java.lang.Short, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalResult.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final iih.dr.dao.auto.entity.IemrRetrievalResultListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>> __entityPropertyTypeMap;

    private _IemrRetrievalResult() {
        __listener = new iih.dr.dao.auto.entity.IemrRetrievalResultListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "IemrRetrievalResult";
        __catalogName = "";
        __schemaName = "";
        __tableName = "IEMR_RETRIEVAL_RESULT";
        __qualifiedTableName = "IEMR_RETRIEVAL_RESULT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>>(19);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>>(19);
        __idList.add($resultCd);
        __list.add($resultCd);
        __map.put("resultCd", $resultCd);
        __list.add($retrievalCd);
        __map.put("retrievalCd", $retrievalCd);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($mrPk);
        __map.put("mrPk", $mrPk);
        __list.add($condCd);
        __map.put("condCd", $condCd);
        __list.add($condName);
        __map.put("condName", $condName);
        __list.add($condText);
        __map.put("condText", $condText);
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
    public void preInsert(iih.dr.dao.auto.entity.IemrRetrievalResult entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.dr.dao.auto.entity.IemrRetrievalResult> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.dr.dao.auto.entity.IemrRetrievalResult entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.dr.dao.auto.entity.IemrRetrievalResult> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.dr.dao.auto.entity.IemrRetrievalResult entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.dr.dao.auto.entity.IemrRetrievalResult> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.dr.dao.auto.entity.IemrRetrievalResult entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.dr.dao.auto.entity.IemrRetrievalResult> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.dr.dao.auto.entity.IemrRetrievalResult entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.dr.dao.auto.entity.IemrRetrievalResult> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.dr.dao.auto.entity.IemrRetrievalResult entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.dr.dao.auto.entity.IemrRetrievalResult> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalResult, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalResult, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrievalResult newEntity() {
        return new iih.dr.dao.auto.entity.IemrRetrievalResult();
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrievalResult newEntity(java.util.Map<String, Object> __args) {
        return new iih.dr.dao.auto.entity.IemrRetrievalResult();
    }

    @Override
    public Class<iih.dr.dao.auto.entity.IemrRetrievalResult> getEntityClass() {
        return iih.dr.dao.auto.entity.IemrRetrievalResult.class;
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrievalResult getOriginalStates(iih.dr.dao.auto.entity.IemrRetrievalResult __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.dr.dao.auto.entity.IemrRetrievalResult __entity) {
    }

    /**
     * @return the singleton
     */
    public static _IemrRetrievalResult getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _IemrRetrievalResult newInstance() {
        return new _IemrRetrievalResult();
    }

}
