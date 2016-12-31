package iih.di.db.gen.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:37.059+0800")
public final class _DiEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.di.db.gen.entity.DiEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DiEntity __singleton = new _DiEntity();

    /** the diSn */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $diSn = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSn", "DI_SN");

    /** the enSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $enSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enSn", "EN_SN", true, true);

    /** the parDiSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $parDiSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "parDiSn", "PAR_DI_SN", true, true);

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD", true, true);

    /** the lvl */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $lvl = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "lvl", "LVL", true, true);

    /** the lvl1SortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $lvl1SortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "lvl1SortNo", "LVL1_SORT_NO", true, true);

    /** the lvl2SortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $lvl2SortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "lvl2SortNo", "LVL2_SORT_NO", true, true);

    /** the diCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $diCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCd", "DI_CD", true, true);

    /** the diNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $diNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diNm", "DI_NM", true, true);

    /** the icdCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $icdCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "icdCd", "ICD_CD", true, true);

    /** the addDescr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $addDescr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "addDescr", "ADD_DESCR", true, true);

    /** the mainF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $mainF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "mainF", "MAIN_F", true, true);

    /** the uncertainF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $uncertainF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "uncertainF", "UNCERTAIN_F", true, true);

    /** the contagionF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $contagionF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "contagionF", "CONTAGION_F", true, true);

    /** the treatResultCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $treatResultCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "treatResultCd", "TREAT_RESULT_CD", true, true);

    /** the diTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.sql.Timestamp, java.lang.Object> $diTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.sql.Timestamp, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "diTime", "DI_TIME", true, true);

    /** the diEmpId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $diEmpId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diEmpId", "DI_EMP_ID", true, true);

    /** the diDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $diDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diDeptCd", "DI_DEPT_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Integer, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Integer, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.sql.Timestamp, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.sql.Timestamp, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the unknowF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $unknowF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "unknowF", "UNKNOW_F", true, true);

    /** the setOwnerTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $setOwnerTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "setOwnerTypeCd", "SET_OWNER_TYPE_CD", true, true);

    /** the setOwnerCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object> $setOwnerCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.String, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "setOwnerCd", "SET_OWNER_CD", true, true);

    /** the copyFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object> $copyFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, java.lang.Short, java.lang.Object>(iih.di.db.gen.entity.DiEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "copyFlag", "COPY_FLAG", true, true);

    private final iih.di.db.gen.entity.DiEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>> __entityPropertyTypeMap;

    private _DiEntity() {
        __listener = new iih.di.db.gen.entity.DiEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DiEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DI";
        __qualifiedTableName = "DI";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>>(34);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>>(34);
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
        __list.add($uncertainF);
        __map.put("uncertainF", $uncertainF);
        __list.add($contagionF);
        __map.put("contagionF", $contagionF);
        __list.add($treatResultCd);
        __map.put("treatResultCd", $treatResultCd);
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
        __list.add($unknowF);
        __map.put("unknowF", $unknowF);
        __list.add($setOwnerTypeCd);
        __map.put("setOwnerTypeCd", $setOwnerTypeCd);
        __list.add($setOwnerCd);
        __map.put("setOwnerCd", $setOwnerCd);
        __list.add($copyFlag);
        __map.put("copyFlag", $copyFlag);
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
    public void preInsert(iih.di.db.gen.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.di.db.gen.entity.DiEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.di.db.gen.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.di.db.gen.entity.DiEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.di.db.gen.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.di.db.gen.entity.DiEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.di.db.gen.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.di.db.gen.entity.DiEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.di.db.gen.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.di.db.gen.entity.DiEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.di.db.gen.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.di.db.gen.entity.DiEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.gen.entity.DiEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.di.db.gen.entity.DiEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.di.db.gen.entity.DiEntity newEntity() {
        return new iih.di.db.gen.entity.DiEntity();
    }

    @Override
    public iih.di.db.gen.entity.DiEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.di.db.gen.entity.DiEntity();
    }

    @Override
    public Class<iih.di.db.gen.entity.DiEntity> getEntityClass() {
        return iih.di.db.gen.entity.DiEntity.class;
    }

    @Override
    public iih.di.db.gen.entity.DiEntity getOriginalStates(iih.di.db.gen.entity.DiEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.di.db.gen.entity.DiEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _DiEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _DiEntity newInstance() {
        return new _DiEntity();
    }

}
