package iih.kr.db.cs.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:18.108+0800")
public final class _DbDateEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.cs.entity.DbDateEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _DbDateEntity __singleton = new _DbDateEntity();

    /** the systimestamp */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DbDateEntity, java.util.Date, java.lang.Object> $systimestamp = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DbDateEntity, java.util.Date, java.lang.Object>(iih.kr.db.cs.entity.DbDateEntity.class, java.util.Date.class, org.seasar.doma.wrapper.UtilDateWrapper.class, null, null, "systimestamp", "systimestamp", true, true);

    /** the sysdateStr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DbDateEntity, java.lang.String, java.lang.Object> $sysdateStr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DbDateEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.DbDateEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sysdateStr", "sysdateStr", true, true);

    /** the systsStr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DbDateEntity, java.lang.String, java.lang.Object> $systsStr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.DbDateEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.DbDateEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "systsStr", "systsStr", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.DbDateEntity> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>> __entityPropertyTypeMap;

    private _DbDateEntity() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.DbDateEntity>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "DbDateEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "DbDateEntity";
        __qualifiedTableName = "DbDateEntity";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>>(3);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>>(3);
        __list.add($systimestamp);
        __map.put("systimestamp", $systimestamp);
        __list.add($sysdateStr);
        __map.put("sysdateStr", $sysdateStr);
        __list.add($systsStr);
        __map.put("systsStr", $systsStr);
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
    public void preInsert(iih.kr.db.cs.entity.DbDateEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.cs.entity.DbDateEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.cs.entity.DbDateEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.cs.entity.DbDateEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.cs.entity.DbDateEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.cs.entity.DbDateEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.cs.entity.DbDateEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.cs.entity.DbDateEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.cs.entity.DbDateEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.cs.entity.DbDateEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.cs.entity.DbDateEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.cs.entity.DbDateEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.DbDateEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.DbDateEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.cs.entity.DbDateEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.cs.entity.DbDateEntity newEntity() {
        return new iih.kr.db.cs.entity.DbDateEntity();
    }

    @Override
    public iih.kr.db.cs.entity.DbDateEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.cs.entity.DbDateEntity();
    }

    @Override
    public Class<iih.kr.db.cs.entity.DbDateEntity> getEntityClass() {
        return iih.kr.db.cs.entity.DbDateEntity.class;
    }

    @Override
    public iih.kr.db.cs.entity.DbDateEntity getOriginalStates(iih.kr.db.cs.entity.DbDateEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.cs.entity.DbDateEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _DbDateEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _DbDateEntity newInstance() {
        return new _DbDateEntity();
    }

}
