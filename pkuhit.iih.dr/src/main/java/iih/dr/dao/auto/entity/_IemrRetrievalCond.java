package iih.dr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:05.090+0800")
public final class _IemrRetrievalCond extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.dr.dao.auto.entity.IemrRetrievalCond> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _IemrRetrievalCond __singleton = new _IemrRetrievalCond();

    /** the condCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $condCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "condCd", "COND_CD");

    /** the retrievalCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $retrievalCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "retrievalCd", "RETRIEVAL_CD", true, true);

    /** the condName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $condName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "condName", "COND_NAME", true, true);

    /** the relType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $relType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "relType", "REL_TYPE", true, true);

    /** the condType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $condType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "condType", "COND_TYPE", true, true);

    /** the objCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $objCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objCode", "OBJ_CODE", true, true);

    /** the objName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $objName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objName", "OBJ_NAME", true, true);

    /** the logic */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $logic = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "logic", "LOGIC", true, true);

    /** the valName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $valName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "valName", "VAL_NAME", true, true);

    /** the valCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $valCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "valCode", "VAL_CODE", true, true);

    /** the grade */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.Short, java.lang.Object> $grade = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.Short, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "grade", "GRADE", true, true);

    /** the upcond */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $upcond = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "upcond", "UPCOND", true, true);

    /** the fullPath */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $fullPath = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fullPath", "FULL_PATH", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "DES", true, true);

    /** the condNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.Short, java.lang.Object> $condNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.Short, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "condNo", "COND_NO", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.math.BigInteger, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.sql.Timestamp, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.sql.Timestamp, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.String, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, java.lang.Short, java.lang.Object>(iih.dr.dao.auto.entity.IemrRetrievalCond.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final iih.dr.dao.auto.entity.IemrRetrievalCondListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>> __entityPropertyTypeMap;

    private _IemrRetrievalCond() {
        __listener = new iih.dr.dao.auto.entity.IemrRetrievalCondListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "IemrRetrievalCond";
        __catalogName = "";
        __schemaName = "";
        __tableName = "IEMR_RETRIEVAL_COND";
        __qualifiedTableName = "IEMR_RETRIEVAL_COND";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>>(27);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>>(27);
        __idList.add($condCd);
        __list.add($condCd);
        __map.put("condCd", $condCd);
        __list.add($retrievalCd);
        __map.put("retrievalCd", $retrievalCd);
        __list.add($condName);
        __map.put("condName", $condName);
        __list.add($relType);
        __map.put("relType", $relType);
        __list.add($condType);
        __map.put("condType", $condType);
        __list.add($objCode);
        __map.put("objCode", $objCode);
        __list.add($objName);
        __map.put("objName", $objName);
        __list.add($logic);
        __map.put("logic", $logic);
        __list.add($valName);
        __map.put("valName", $valName);
        __list.add($valCode);
        __map.put("valCode", $valCode);
        __list.add($grade);
        __map.put("grade", $grade);
        __list.add($upcond);
        __map.put("upcond", $upcond);
        __list.add($fullPath);
        __map.put("fullPath", $fullPath);
        __list.add($des);
        __map.put("des", $des);
        __list.add($condNo);
        __map.put("condNo", $condNo);
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
    public void preInsert(iih.dr.dao.auto.entity.IemrRetrievalCond entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.dr.dao.auto.entity.IemrRetrievalCond> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.dr.dao.auto.entity.IemrRetrievalCond entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.dr.dao.auto.entity.IemrRetrievalCond> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.dr.dao.auto.entity.IemrRetrievalCond entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.dr.dao.auto.entity.IemrRetrievalCond> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.dr.dao.auto.entity.IemrRetrievalCond entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.dr.dao.auto.entity.IemrRetrievalCond> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.dr.dao.auto.entity.IemrRetrievalCond entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.dr.dao.auto.entity.IemrRetrievalCond> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.dr.dao.auto.entity.IemrRetrievalCond entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.dr.dao.auto.entity.IemrRetrievalCond> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.dr.dao.auto.entity.IemrRetrievalCond, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.dr.dao.auto.entity.IemrRetrievalCond, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrievalCond newEntity() {
        return new iih.dr.dao.auto.entity.IemrRetrievalCond();
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrievalCond newEntity(java.util.Map<String, Object> __args) {
        return new iih.dr.dao.auto.entity.IemrRetrievalCond();
    }

    @Override
    public Class<iih.dr.dao.auto.entity.IemrRetrievalCond> getEntityClass() {
        return iih.dr.dao.auto.entity.IemrRetrievalCond.class;
    }

    @Override
    public iih.dr.dao.auto.entity.IemrRetrievalCond getOriginalStates(iih.dr.dao.auto.entity.IemrRetrievalCond __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.dr.dao.auto.entity.IemrRetrievalCond __entity) {
    }

    /**
     * @return the singleton
     */
    public static _IemrRetrievalCond getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _IemrRetrievalCond newInstance() {
        return new _IemrRetrievalCond();
    }

}
