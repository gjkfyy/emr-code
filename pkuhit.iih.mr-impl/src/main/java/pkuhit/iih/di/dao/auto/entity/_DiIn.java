package pkuhit.iih.di.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.775+0800")
public final class _DiIn extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.di.dao.auto.entity.DiIn> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DiIn __singleton = new _DiIn();

    /** the diSn */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $diSn = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSn", "DI_SN");

    /** the enSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $enSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enSn", "EN_SN", true, true);

    /** the parDiSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $parDiSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "parDiSn", "PAR_DI_SN", true, true);

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD", true, true);

    /** the lvl */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object> $lvl = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "lvl", "LVL", true, true);

    /** the lvl1SortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object> $lvl1SortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "lvl1SortNo", "LVL1_SORT_NO", true, true);

    /** the lvl2SortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object> $lvl2SortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "lvl2SortNo", "LVL2_SORT_NO", true, true);

    /** the diTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $diTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diTypeCd", "DI_TYPE_CD", true, true);

    /** the diCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $diCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCd", "DI_CD", true, true);

    /** the diNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $diNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diNm", "DI_NM", true, true);

    /** the icdCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $icdCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "icdCd", "ICD_CD", true, true);

    /** the addDescr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $addDescr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "addDescr", "ADD_DESCR", true, true);

    /** the mainF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object> $mainF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "mainF", "MAIN_F", true, true);

    /** the diTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.sql.Timestamp, java.lang.Object> $diTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "diTime", "DI_TIME", true, true);

    /** the diEmpId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $diEmpId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diEmpId", "DI_EMP_ID", true, true);

    /** the diDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $diDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diDeptCd", "DI_DEPT_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.math.BigInteger, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.Short, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the diTypeNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object> $diTypeNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, java.lang.String, java.lang.Object>(pkuhit.iih.di.dao.auto.entity.DiIn.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diTypeNm", "DI_TYPE_NM", true, true);

    private final pkuhit.iih.di.dao.auto.entity.DiInListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>> __entityPropertyTypeMap;

    private _DiIn() {
        __listener = new pkuhit.iih.di.dao.auto.entity.DiInListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DiIn";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DI_IN";
        __qualifiedTableName = "DI_IN";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>>(29);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>>(29);
        __idList.add($diSn);
        __list.add($diSn);
        __map.put("diSn", $diSn);
        __list.add($enSn);
        __map.put("enSn", $enSn);
        __list.add($parDiSn);
        __map.put("parDiSn", $parDiSn);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($lvl);
        __map.put("lvl", $lvl);
        __list.add($lvl1SortNo);
        __map.put("lvl1SortNo", $lvl1SortNo);
        __list.add($lvl2SortNo);
        __map.put("lvl2SortNo", $lvl2SortNo);
        __list.add($diTypeCd);
        __map.put("diTypeCd", $diTypeCd);
        __list.add($diCd);
        __map.put("diCd", $diCd);
        __list.add($diNm);
        __map.put("diNm", $diNm);
        __list.add($icdCd);
        __map.put("icdCd", $icdCd);
        __list.add($addDescr);
        __map.put("addDescr", $addDescr);
        __list.add($mainF);
        __map.put("mainF", $mainF);
        __list.add($diTime);
        __map.put("diTime", $diTime);
        __list.add($diEmpId);
        __map.put("diEmpId", $diEmpId);
        __list.add($diDeptCd);
        __map.put("diDeptCd", $diDeptCd);
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
        __list.add($diTypeNm);
        __map.put("diTypeNm", $diTypeNm);
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
    public void preInsert(pkuhit.iih.di.dao.auto.entity.DiIn entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.di.dao.auto.entity.DiIn> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.di.dao.auto.entity.DiIn entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.di.dao.auto.entity.DiIn> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.di.dao.auto.entity.DiIn entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.di.dao.auto.entity.DiIn> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.di.dao.auto.entity.DiIn entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.di.dao.auto.entity.DiIn> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.di.dao.auto.entity.DiIn entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.di.dao.auto.entity.DiIn> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.di.dao.auto.entity.DiIn entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.di.dao.auto.entity.DiIn> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.di.dao.auto.entity.DiIn, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.di.dao.auto.entity.DiIn, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.di.dao.auto.entity.DiIn newEntity() {
        return new pkuhit.iih.di.dao.auto.entity.DiIn();
    }

    @Override
    public pkuhit.iih.di.dao.auto.entity.DiIn newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.di.dao.auto.entity.DiIn();
    }

    @Override
    public Class<pkuhit.iih.di.dao.auto.entity.DiIn> getEntityClass() {
        return pkuhit.iih.di.dao.auto.entity.DiIn.class;
    }

    @Override
    public pkuhit.iih.di.dao.auto.entity.DiIn getOriginalStates(pkuhit.iih.di.dao.auto.entity.DiIn __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.di.dao.auto.entity.DiIn __entity) {
    }

    /**
     * @return the singleton
     */
    public static _DiIn getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _DiIn newInstance() {
        return new _DiIn();
    }

}
