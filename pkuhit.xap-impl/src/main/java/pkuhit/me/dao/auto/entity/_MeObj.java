package pkuhit.me.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.287+0800")
public final class _MeObj extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.me.dao.auto.entity.MeObj> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MeObj __singleton = new _MeObj();

    /** the objCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $objCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objCd", "OBJ_CD");

    /** the parObjCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $parObjCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "parObjCd", "PAR_OBJ_CD", true, true);

    /** the doCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $doCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "doCd", "DO_CD", true, true);

    /** the rtObjCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $rtObjCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rtObjCd", "RT_OBJ_CD", true, true);

    /** the verNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $verNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "verNo", "VER_NO", true, true);

    /** the objTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $objTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objTpCd", "OBJ_TP_CD", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "DES", true, true);

    /** the shtNmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $shtNmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "shtNmEn", "SHT_NM_EN", true, true);

    /** the nmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $nmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nmEn", "NM_EN", true, true);

    /** the tabNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $tabNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "tabNm", "TAB_NM", true, true);

    /** the comMdF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object> $comMdF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "comMdF", "COM_MD_F", true, true);

    /** the tabF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object> $tabF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "tabF", "TAB_F", true, true);

    /** the cacheF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object> $cacheF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "cacheF", "CACHE_F", true, true);

    /** the constantF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object> $constantF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "constantF", "CONSTANT_F", true, true);

    /** the packagePath */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $packagePath = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "packagePath", "PACKAGE_PATH", true, true);

    /** the baseClass */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $baseClass = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "baseClass", "BASE_CLASS", true, true);

    /** the mrUseF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object> $mrUseF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "mrUseF", "MR_USE_F", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObj.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.me.dao.auto.entity.MeObjListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>> __entityPropertyTypeMap;

    private _MeObj() {
        __listener = new pkuhit.me.dao.auto.entity.MeObjListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MeObj";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ME_OBJ";
        __qualifiedTableName = "ME_OBJ";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>>(30);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>>(30);
        __idList.add($objCd);
        __list.add($objCd);
        __map.put("objCd", $objCd);
        __list.add($parObjCd);
        __map.put("parObjCd", $parObjCd);
        __list.add($doCd);
        __map.put("doCd", $doCd);
        __list.add($rtObjCd);
        __map.put("rtObjCd", $rtObjCd);
        __list.add($verNo);
        __map.put("verNo", $verNo);
        __list.add($objTpCd);
        __map.put("objTpCd", $objTpCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($des);
        __map.put("des", $des);
        __list.add($shtNmEn);
        __map.put("shtNmEn", $shtNmEn);
        __list.add($nmEn);
        __map.put("nmEn", $nmEn);
        __list.add($tabNm);
        __map.put("tabNm", $tabNm);
        __list.add($comMdF);
        __map.put("comMdF", $comMdF);
        __list.add($tabF);
        __map.put("tabF", $tabF);
        __list.add($cacheF);
        __map.put("cacheF", $cacheF);
        __list.add($constantF);
        __map.put("constantF", $constantF);
        __list.add($packagePath);
        __map.put("packagePath", $packagePath);
        __list.add($baseClass);
        __map.put("baseClass", $baseClass);
        __list.add($mrUseF);
        __map.put("mrUseF", $mrUseF);
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
        __list.add($lastUpdDeptCd);
        __map.put("lastUpdDeptCd", $lastUpdDeptCd);
        __list.add($lastUpdTime);
        __map.put("lastUpdTime", $lastUpdTime);
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
    public void preInsert(pkuhit.me.dao.auto.entity.MeObj entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.me.dao.auto.entity.MeObj> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.me.dao.auto.entity.MeObj entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.me.dao.auto.entity.MeObj> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.me.dao.auto.entity.MeObj entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.me.dao.auto.entity.MeObj> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.me.dao.auto.entity.MeObj entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.me.dao.auto.entity.MeObj> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.me.dao.auto.entity.MeObj entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.me.dao.auto.entity.MeObj> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.me.dao.auto.entity.MeObj entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.me.dao.auto.entity.MeObj> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObj, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObj, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeObj newEntity() {
        return new pkuhit.me.dao.auto.entity.MeObj();
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeObj newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.me.dao.auto.entity.MeObj();
    }

    @Override
    public Class<pkuhit.me.dao.auto.entity.MeObj> getEntityClass() {
        return pkuhit.me.dao.auto.entity.MeObj.class;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeObj getOriginalStates(pkuhit.me.dao.auto.entity.MeObj __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.me.dao.auto.entity.MeObj __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MeObj getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MeObj newInstance() {
        return new _MeObj();
    }

}
