package iih.dr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:05.087+0800")
public final class _IemrRetrieval extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.dr.dao.auto.entity.IemrRetrieval> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _IemrRetrieval __singleton = new _IemrRetrieval();

    /** the retrievalCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $retrievalCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "retrievalCd", "RETRIEVAL_CD");

    /** the retrievalNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $retrievalNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "retrievalNm", "RETRIEVAL_NM", true, true);

    /** the ownTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $ownTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownTpCd", "OWN_TP_CD", true, true);

    /** the deptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $deptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptCd", "DEPT_CD", true, true);

    /** the responsibleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $responsibleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "responsibleCd", "RESPONSIBLE_CD", true, true);

    /** the retrievalKey */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $retrievalKey = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "retrievalKey", "RETRIEVAL_KEY", true, true);

    /** the statusF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.Short, java.lang.Object> $statusF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.Short, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "statusF", "STATUS_F", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.math.BigInteger, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.sql.Timestamp, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.sql.Timestamp, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, java.lang.Short, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrieval.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final iih.dr.dao.auto.entity.IemrRetrievalListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>> __entityPropertyTypeMap;

    private _IemrRetrieval() {
        __listener = new iih.dr.dao.auto.entity.IemrRetrievalListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "IemrRetrieval";
        __catalogName = "";
        __schemaName = "";
        __tableName = "IEMR_RETRIEVAL";
        __qualifiedTableName = "IEMR_RETRIEVAL";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>>(19);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>>(19);
        __idList.add($retrievalCd);
        __list.add($retrievalCd);
        __map.put("retrievalCd", $retrievalCd);
        __list.add($retrievalNm);
        __map.put("retrievalNm", $retrievalNm);
        __list.add($ownTpCd);
        __map.put("ownTpCd", $ownTpCd);
        __list.add($deptCd);
        __map.put("deptCd", $deptCd);
        __list.add($responsibleCd);
        __map.put("responsibleCd", $responsibleCd);
        __list.add($retrievalKey);
        __map.put("retrievalKey", $retrievalKey);
        __list.add($statusF);
        __map.put("statusF", $statusF);
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
    public void preInsert(iih.dr.dao.auto.entity.IemrRetrieval entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.dr.dao.auto.entity.IemrRetrieval> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.dr.dao.auto.entity.IemrRetrieval entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.dr.dao.auto.entity.IemrRetrieval> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.dr.dao.auto.entity.IemrRetrieval entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.dr.dao.auto.entity.IemrRetrieval> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.dr.dao.auto.entity.IemrRetrieval entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.dr.dao.auto.entity.IemrRetrieval> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.dr.dao.auto.entity.IemrRetrieval entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.dr.dao.auto.entity.IemrRetrieval> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.dr.dao.auto.entity.IemrRetrieval entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.dr.dao.auto.entity.IemrRetrieval> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrieval, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrieval, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrieval newEntity() {
        return new iih.dr.dao.auto.entity.IemrRetrieval();
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrieval newEntity(java.util.Map<String, Object> __args) {
        return new iih.dr.dao.auto.entity.IemrRetrieval();
    }

    @Override
    public Class<iih.dr.dao.auto.entity.IemrRetrieval> getEntityClass() {
        return iih.dr.dao.auto.entity.IemrRetrieval.class;
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrieval getOriginalStates(iih.dr.dao.auto.entity.IemrRetrieval __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.dr.dao.auto.entity.IemrRetrieval __entity) {
    }

    /**
     * @return the singleton
     */
    public static _IemrRetrieval getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _IemrRetrieval newInstance() {
        return new _IemrRetrieval();
    }

}
