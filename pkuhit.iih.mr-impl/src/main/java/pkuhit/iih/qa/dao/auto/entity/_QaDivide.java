package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.242+0800")
public final class _QaDivide extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.QaDivide> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _QaDivide __singleton = new _QaDivide();

    /** the qaDivideCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $qaDivideCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaDivideCd", "QA_DIVIDE_CD");

    /** the qaItmPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $qaItmPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaItmPk", "QA_ITM_PK", true, true);

    /** the qaTyCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $qaTyCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaTyCd", "QA_TY_CD", true, true);

    /** the sbmtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.sql.Timestamp, java.lang.Object> $sbmtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "sbmtTime", "SBMT_TIME", true, true);

    /** the sbmtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $sbmtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sbmtUserId", "SBMT_USER_ID", true, true);

    /** the sbmtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $sbmtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sbmtDeptCd", "SBMT_DEPT_CD", true, true);

    /** the rfmReq */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $rfmReq = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rfmReq", "RFM_REQ", true, true);

    /** the drpDes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $drpDes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "drpDes", "DRP_DES", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the deductScrTimes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.Integer, java.lang.Object> $deductScrTimes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.Integer, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "deductScrTimes", "DEDUCT_SCR_TIMES", true, true);

    /** the qaScr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.Integer, java.lang.Object> $qaScr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.Integer, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "qaScr", "QA_SCR", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaDivide.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.QaDivideListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>> __entityPropertyTypeMap;

    private _QaDivide() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.QaDivideListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "QaDivide";
        __catalogName = "";
        __schemaName = "";
        __tableName = "QA_DIVIDE";
        __qualifiedTableName = "QA_DIVIDE";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>>(23);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>>(23);
        __idList.add($qaDivideCd);
        __list.add($qaDivideCd);
        __map.put("qaDivideCd", $qaDivideCd);
        __list.add($qaItmPk);
        __map.put("qaItmPk", $qaItmPk);
        __list.add($qaTyCd);
        __map.put("qaTyCd", $qaTyCd);
        __list.add($sbmtTime);
        __map.put("sbmtTime", $sbmtTime);
        __list.add($sbmtUserId);
        __map.put("sbmtUserId", $sbmtUserId);
        __list.add($sbmtDeptCd);
        __map.put("sbmtDeptCd", $sbmtDeptCd);
        __list.add($rfmReq);
        __map.put("rfmReq", $rfmReq);
        __list.add($drpDes);
        __map.put("drpDes", $drpDes);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($deductScrTimes);
        __map.put("deductScrTimes", $deductScrTimes);
        __list.add($qaScr);
        __map.put("qaScr", $qaScr);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.QaDivide entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.QaDivide> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.QaDivide entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaDivide> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.QaDivide entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaDivide> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.QaDivide entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.QaDivide> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.QaDivide entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaDivide> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.QaDivide entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaDivide> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaDivide, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaDivide, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaDivide newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.QaDivide();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaDivide newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.QaDivide();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.QaDivide> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.QaDivide.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaDivide getOriginalStates(pkuhit.iih.qa.dao.auto.entity.QaDivide __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.QaDivide __entity) {
    }

    /**
     * @return the singleton
     */
    public static _QaDivide getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _QaDivide newInstance() {
        return new _QaDivide();
    }

}
