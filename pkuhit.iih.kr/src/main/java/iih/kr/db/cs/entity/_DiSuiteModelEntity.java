package iih.kr.db.cs.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.102+0800")
public final class _DiSuiteModelEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.cs.entity.DiSuiteModelEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DiSuiteModelEntity __singleton = new _DiSuiteModelEntity();

    /** the diSuiteCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object> $diSuiteCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.DiSuiteModelEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteCode", "diSuiteCode", true, true);

    /** the diSuiteTypeName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object> $diSuiteTypeName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.DiSuiteModelEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteTypeName", "diSuiteTypeName", true, true);

    /** the diSuiteTypeCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object> $diSuiteTypeCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.DiSuiteModelEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diSuiteTypeCode", "diSuiteTypeCode", true, true);

    /** the diName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object> $diName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.DiSuiteModelEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diName", "diName", true, true);

    /** the diCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object> $diCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.DiSuiteModelEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCode", "diCode", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.DiSuiteModelEntity> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>> __entityPropertyTypeMap;

    private _DiSuiteModelEntity() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.DiSuiteModelEntity>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DiSuiteModelEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DiSuiteModelEntity";
        __qualifiedTableName = "DiSuiteModelEntity";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>>(5);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>>(5);
        __list.add($diSuiteCode);
        __map.put("diSuiteCode", $diSuiteCode);
        __list.add($diSuiteTypeName);
        __map.put("diSuiteTypeName", $diSuiteTypeName);
        __list.add($diSuiteTypeCode);
        __map.put("diSuiteTypeCode", $diSuiteTypeCode);
        __list.add($diName);
        __map.put("diName", $diName);
        __list.add($diCode);
        __map.put("diCode", $diCode);
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
    public void preInsert(iih.kr.db.cs.entity.DiSuiteModelEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.cs.entity.DiSuiteModelEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.cs.entity.DiSuiteModelEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.cs.entity.DiSuiteModelEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.cs.entity.DiSuiteModelEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.cs.entity.DiSuiteModelEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.cs.entity.DiSuiteModelEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.cs.entity.DiSuiteModelEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.cs.entity.DiSuiteModelEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.cs.entity.DiSuiteModelEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.cs.entity.DiSuiteModelEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.cs.entity.DiSuiteModelEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiSuiteModelEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiSuiteModelEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.cs.entity.DiSuiteModelEntity newEntity() {
        return new iih.kr.db.cs.entity.DiSuiteModelEntity();
    }

    @Override
    public iih.kr.db.cs.entity.DiSuiteModelEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.cs.entity.DiSuiteModelEntity();
    }

    @Override
    public Class<iih.kr.db.cs.entity.DiSuiteModelEntity> getEntityClass() {
        return iih.kr.db.cs.entity.DiSuiteModelEntity.class;
    }

    @Override
    public iih.kr.db.cs.entity.DiSuiteModelEntity getOriginalStates(iih.kr.db.cs.entity.DiSuiteModelEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.cs.entity.DiSuiteModelEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _DiSuiteModelEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _DiSuiteModelEntity newInstance() {
        return new _DiSuiteModelEntity();
    }

}
