package iih.kr.db.cs.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:18.133+0800")
public final class _DiEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.cs.entity.DiEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DiEntity __singleton = new _DiEntity();

    private final org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.DiEntity> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>> __entityPropertyTypeMap;

    private _DiEntity() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.DiEntity>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DiEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DiEntity";
        __qualifiedTableName = "DiEntity";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>>(0);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>>(0);
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
    public void preInsert(iih.kr.db.cs.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.cs.entity.DiEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.cs.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.cs.entity.DiEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.cs.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.cs.entity.DiEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.cs.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.cs.entity.DiEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.cs.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.cs.entity.DiEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.cs.entity.DiEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.cs.entity.DiEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DiEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.cs.entity.DiEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.cs.entity.DiEntity newEntity() {
        return new iih.kr.db.cs.entity.DiEntity();
    }

    @Override
    public iih.kr.db.cs.entity.DiEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.cs.entity.DiEntity();
    }

    @Override
    public Class<iih.kr.db.cs.entity.DiEntity> getEntityClass() {
        return iih.kr.db.cs.entity.DiEntity.class;
    }

    @Override
    public iih.kr.db.cs.entity.DiEntity getOriginalStates(iih.kr.db.cs.entity.DiEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.cs.entity.DiEntity __entity) {
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
