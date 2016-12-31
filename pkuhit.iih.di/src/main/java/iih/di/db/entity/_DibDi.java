package iih.di.db.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:57.440+0800")
public final class _DibDi extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.di.db.entity.DibDi> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DibDi __singleton = new _DibDi();

    /** the diSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object> $diSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSn", "diSn", true, true);

    /** the parDiSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object> $parDiSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "parDiSn", "parDiSn", true, true);

    /** the enSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object> $enSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enSn", "enSn", true, true);

    /** the lvl */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object> $lvl = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "lvl", "lvl", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "sortNo", "sortNo", true, true);

    /** the diCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object> $diCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCd", "diCd", true, true);

    /** the diNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object> $diNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diNm", "diNm", true, true);

    /** the icdCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object> $icdCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "icdCd", "icdCd", true, true);

    /** the addDescr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object> $addDescr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "addDescr", "addDescr", true, true);

    /** the mainF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object> $mainF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "mainF", "mainF", true, true);

    /** the uncertainF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object> $uncertainF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "uncertainF", "uncertainF", true, true);

    /** the stopUseF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object> $stopUseF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.Short, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "stopUseF", "stopUseF", true, true);

    /** the diEmpId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object> $diEmpId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.lang.String, java.lang.Object>(iih.di.db.entity.DibDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diEmpId", "diEmpId", true, true);

    /** the diTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.sql.Timestamp, java.lang.Object> $diTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.di.db.entity.DibDi, java.sql.Timestamp, java.lang.Object>(iih.di.db.entity.DibDi.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "diTime", "diTime", true, true);

    private final iih.di.db.entity.DibDiListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>> __entityPropertyTypeMap;

    private _DibDi() {
        __listener = new iih.di.db.entity.DibDiListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DibDi";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DIB_DI";
        __qualifiedTableName = "DIB_DI";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>>(14);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>>(14);
        __list.add($diSn);
        __map.put("diSn", $diSn);
        __list.add($parDiSn);
        __map.put("parDiSn", $parDiSn);
        __list.add($enSn);
        __map.put("enSn", $enSn);
        __list.add($lvl);
        __map.put("lvl", $lvl);
        __list.add($sortNo);
        __map.put("sortNo", $sortNo);
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
        __list.add($stopUseF);
        __map.put("stopUseF", $stopUseF);
        __list.add($diEmpId);
        __map.put("diEmpId", $diEmpId);
        __list.add($diTime);
        __map.put("diTime", $diTime);
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
    public void preInsert(iih.di.db.entity.DibDi entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.di.db.entity.DibDi> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.di.db.entity.DibDi entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.di.db.entity.DibDi> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.di.db.entity.DibDi entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.di.db.entity.DibDi> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.di.db.entity.DibDi entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.di.db.entity.DibDi> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.di.db.entity.DibDi entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.di.db.entity.DibDi> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.di.db.entity.DibDi entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.di.db.entity.DibDi> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.di.db.entity.DibDi, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.di.db.entity.DibDi, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.di.db.entity.DibDi, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.di.db.entity.DibDi newEntity() {
        return new iih.di.db.entity.DibDi();
    }

    @Override
    public iih.di.db.entity.DibDi newEntity(java.util.Map<String, Object> __args) {
        return new iih.di.db.entity.DibDi();
    }

    @Override
    public Class<iih.di.db.entity.DibDi> getEntityClass() {
        return iih.di.db.entity.DibDi.class;
    }

    @Override
    public iih.di.db.entity.DibDi getOriginalStates(iih.di.db.entity.DibDi __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.di.db.entity.DibDi __entity) {
    }

    /**
     * @return the singleton
     */
    public static _DibDi getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _DibDi newInstance() {
        return new _DibDi();
    }

}
