package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.876+0800")
public final class _QaSysItm extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.QaSysItm> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _QaSysItm __singleton = new _QaSysItm();

    /** the qaSysItmCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $qaSysItmCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaSysItmCd", "QA_SYS_ITM_CD");

    /** the qaSysMrCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $qaSysMrCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaSysMrCd", "QA_SYS_MR_CD", true, true);

    /** the qaSysSegCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $qaSysSegCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaSysSegCd", "QA_SYS_SEG_CD", true, true);

    /** the qaSysAmrCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $qaSysAmrCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaSysAmrCd", "QA_SYS_AMR_CD", true, true);

    /** the req */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $req = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "req", "REQ", true, true);

    /** the qaDrpScrTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $qaDrpScrTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaDrpScrTpCd", "QA_DRP_SCR_TP_CD", true, true);

    /** the onceDrpScr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.math.BigDecimal, java.lang.Object> $onceDrpScr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.math.BigDecimal, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.math.BigDecimal.class, org.seasar.doma.wrapper.BigDecimalWrapper.class, null, null, "onceDrpScr", "ONCE_DRP_SCR", true, true);

    /** the maxDrpScr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.math.BigDecimal, java.lang.Object> $maxDrpScr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.math.BigDecimal, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.math.BigDecimal.class, org.seasar.doma.wrapper.BigDecimalWrapper.class, null, null, "maxDrpScr", "MAX_DRP_SCR", true, true);

    /** the dftRfmF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.Short, java.lang.Object> $dftRfmF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "dftRfmF", "DFT_RFM_F", true, true);

    /** the autoQaF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.Short, java.lang.Object> $autoQaF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "autoQaF", "AUTO_QA_F", true, true);

    /** the qaItmTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $qaItmTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaItmTpCd", "QA_ITM_TP_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysItm.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.QaSysItmListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>> __entityPropertyTypeMap;

    private _QaSysItm() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.QaSysItmListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "QaSysItm";
        __catalogName = "";
        __schemaName = "";
        __tableName = "QA_SYS_ITM";
        __qualifiedTableName = "QA_SYS_ITM";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>>(23);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>>(23);
        __idList.add($qaSysItmCd);
        __list.add($qaSysItmCd);
        __map.put("qaSysItmCd", $qaSysItmCd);
        __list.add($qaSysMrCd);
        __map.put("qaSysMrCd", $qaSysMrCd);
        __list.add($qaSysSegCd);
        __map.put("qaSysSegCd", $qaSysSegCd);
        __list.add($qaSysAmrCd);
        __map.put("qaSysAmrCd", $qaSysAmrCd);
        __list.add($req);
        __map.put("req", $req);
        __list.add($qaDrpScrTpCd);
        __map.put("qaDrpScrTpCd", $qaDrpScrTpCd);
        __list.add($onceDrpScr);
        __map.put("onceDrpScr", $onceDrpScr);
        __list.add($maxDrpScr);
        __map.put("maxDrpScr", $maxDrpScr);
        __list.add($dftRfmF);
        __map.put("dftRfmF", $dftRfmF);
        __list.add($autoQaF);
        __map.put("autoQaF", $autoQaF);
        __list.add($qaItmTpCd);
        __map.put("qaItmTpCd", $qaItmTpCd);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.QaSysItm entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.QaSysItm> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.QaSysItm entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaSysItm> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.QaSysItm entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaSysItm> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.QaSysItm entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.QaSysItm> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.QaSysItm entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaSysItm> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.QaSysItm entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaSysItm> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysItm, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSysItm newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.QaSysItm();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSysItm newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.QaSysItm();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.QaSysItm> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.QaSysItm.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSysItm getOriginalStates(pkuhit.iih.qa.dao.auto.entity.QaSysItm __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.QaSysItm __entity) {
    }

    /**
     * @return the singleton
     */
    public static _QaSysItm getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _QaSysItm newInstance() {
        return new _QaSysItm();
    }

}
