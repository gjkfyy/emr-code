package pkuhit.iih.mr.tth.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.290+0800")
public final class _MrTeethExamItem extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MrTeethExamItem __singleton = new _MrTeethExamItem();

    /** the teethItemPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $teethItemPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "teethItemPk", "TEETH_ITEM_PK");

    /** the teethPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $teethPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "teethPk", "TEETH_PK", true, true);

    /** the teethLocation */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $teethLocation = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "teethLocation", "TEETH_LOCATION", true, true);

    /** the valueStr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $valueStr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "valueStr", "VALUE_STR", true, true);

    /** the colDisabled */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $colDisabled = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "colDisabled", "COL_DISABLED", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItemListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>> __entityPropertyTypeMap;

    private _MrTeethExamItem() {
        __listener = new pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItemListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MrTeethExamItem";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MR_TEETH_EXAM_ITEM";
        __qualifiedTableName = "MR_TEETH_EXAM_ITEM";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>>(17);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>>(17);
        __idList.add($teethItemPk);
        __list.add($teethItemPk);
        __map.put("teethItemPk", $teethItemPk);
        __list.add($teethPk);
        __map.put("teethPk", $teethPk);
        __list.add($teethLocation);
        __map.put("teethLocation", $teethLocation);
        __list.add($valueStr);
        __map.put("valueStr", $valueStr);
        __list.add($colDisabled);
        __map.put("colDisabled", $colDisabled);
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
    public void preInsert(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem newEntity() {
        return new pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem();
    }

    @Override
    public pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem();
    }

    @Override
    public Class<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem> getEntityClass() {
        return pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem.class;
    }

    @Override
    public pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem getOriginalStates(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MrTeethExamItem getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MrTeethExamItem newInstance() {
        return new _MrTeethExamItem();
    }

}
