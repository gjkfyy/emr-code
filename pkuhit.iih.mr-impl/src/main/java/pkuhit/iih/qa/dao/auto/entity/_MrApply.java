package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.705+0800")
public final class _MrApply extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.MrApply> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MrApply __singleton = new _MrApply();

    /** the applyCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $applyCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "applyCd", "APPLY_CD");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the mrTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $mrTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTpCd", "MR_TP_CD", true, true);

    /** the qaItmCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $qaItmCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaItmCd", "QA_ITM_CD", true, true);

    /** the qaAutoFltPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $qaAutoFltPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaAutoFltPk", "QA_AUTO_FLT_PK", true, true);

    /** the applyTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.sql.Timestamp, java.lang.Object> $applyTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "applyTime", "APPLY_TIME", true, true);

    /** the applyDctCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $applyDctCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "applyDctCd", "APPLY_DCT_CD", true, true);

    /** the applyStatus */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $applyStatus = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "applyStatus", "APPLY_STATUS", true, true);

    /** the applyDesc */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $applyDesc = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "applyDesc", "APPLY_DESC", true, true);

    /** the deptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $deptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptCd", "DEPT_CD", true, true);

    /** the approvalTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.sql.Timestamp, java.lang.Object> $approvalTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "approvalTime", "APPROVAL_TIME", true, true);

    /** the approvalDctCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $approvalDctCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "approvalDctCd", "APPROVAL_DCT_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the applyTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object> $applyTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.MrApply.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "applyTypeCd", "APPLY_TYPE_CD", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.MrApplyListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>> __entityPropertyTypeMap;

    private _MrApply() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.MrApplyListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MrApply";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MR_APPLY";
        __qualifiedTableName = "MR_APPLY";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>>(25);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>>(25);
        __idList.add($applyCd);
        __list.add($applyCd);
        __map.put("applyCd", $applyCd);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($mrTpCd);
        __map.put("mrTpCd", $mrTpCd);
        __list.add($qaItmCd);
        __map.put("qaItmCd", $qaItmCd);
        __list.add($qaAutoFltPk);
        __map.put("qaAutoFltPk", $qaAutoFltPk);
        __list.add($applyTime);
        __map.put("applyTime", $applyTime);
        __list.add($applyDctCd);
        __map.put("applyDctCd", $applyDctCd);
        __list.add($applyStatus);
        __map.put("applyStatus", $applyStatus);
        __list.add($applyDesc);
        __map.put("applyDesc", $applyDesc);
        __list.add($deptCd);
        __map.put("deptCd", $deptCd);
        __list.add($approvalTime);
        __map.put("approvalTime", $approvalTime);
        __list.add($approvalDctCd);
        __map.put("approvalDctCd", $approvalDctCd);
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
        __list.add($applyTypeCd);
        __map.put("applyTypeCd", $applyTypeCd);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.MrApply entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.MrApply> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.MrApply entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.MrApply> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.MrApply entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.MrApply> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.MrApply entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.MrApply> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.MrApply entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.MrApply> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.MrApply entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.MrApply> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.MrApply, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.MrApply, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.MrApply newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.MrApply();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.MrApply newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.MrApply();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.MrApply> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.MrApply.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.MrApply getOriginalStates(pkuhit.iih.qa.dao.auto.entity.MrApply __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.MrApply __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MrApply getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MrApply newInstance() {
        return new _MrApply();
    }

}
