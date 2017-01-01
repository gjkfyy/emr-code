package pkuhit.me.dao.custom.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.291+0800")
public final class _ObjectAttributeMetadata extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _ObjectAttributeMetadata __singleton = new _ObjectAttributeMetadata();

    /** the objectCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object> $objectCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objectCd", "OBJECT_CD", true, true);

    /** the attributeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object> $attributeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "attributeCd", "ATTRIBUTE_CD", true, true);

    /** the tableName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object> $tableName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "tableName", "TABLE_NAME", true, true);

    /** the columnName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object> $columnName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "columnName", "COLUMN_NAME", true, true);

    /** the attributeName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object> $attributeName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "attributeName", "ATTRIBUTE_NAME", true, true);

    /** the attributeText */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object> $attributeText = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.String, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "attributeText", "ATTRIBUTE_TEXT", true, true);

    /** the primaryKeyFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.Integer, java.lang.Object> $primaryKeyFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.Integer, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "primaryKeyFlag", "PRIMARY_KEY_FLAG", true, true);

    /** the commonMDFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.Integer, java.lang.Object> $commonMDFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.Integer, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "commonMDFlag", "COMMON_MD_FLAG", true, true);

    /** the cacheFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.Integer, java.lang.Object> $cacheFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, java.lang.Integer, java.lang.Object>(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "cacheFlag", "CACHE_FLAG", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>> __entityPropertyTypeMap;

    private _ObjectAttributeMetadata() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "ObjectAttributeMetadata";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ObjectAttributeMetadata";
        __qualifiedTableName = "ObjectAttributeMetadata";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>>(9);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>>(9);
        __list.add($objectCd);
        __map.put("objectCd", $objectCd);
        __list.add($attributeCd);
        __map.put("attributeCd", $attributeCd);
        __list.add($tableName);
        __map.put("tableName", $tableName);
        __list.add($columnName);
        __map.put("columnName", $columnName);
        __list.add($attributeName);
        __map.put("attributeName", $attributeName);
        __list.add($attributeText);
        __map.put("attributeText", $attributeText);
        __list.add($primaryKeyFlag);
        __map.put("primaryKeyFlag", $primaryKeyFlag);
        __list.add($commonMDFlag);
        __map.put("commonMDFlag", $commonMDFlag);
        __list.add($cacheFlag);
        __map.put("cacheFlag", $cacheFlag);
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
    public void preInsert(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.me.dao.custom.entity.ObjectAttributeMetadata, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.me.dao.custom.entity.ObjectAttributeMetadata newEntity() {
        return new pkuhit.me.dao.custom.entity.ObjectAttributeMetadata();
    }

    @Override
    public pkuhit.me.dao.custom.entity.ObjectAttributeMetadata newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.me.dao.custom.entity.ObjectAttributeMetadata();
    }

    @Override
    public Class<pkuhit.me.dao.custom.entity.ObjectAttributeMetadata> getEntityClass() {
        return pkuhit.me.dao.custom.entity.ObjectAttributeMetadata.class;
    }

    @Override
    public pkuhit.me.dao.custom.entity.ObjectAttributeMetadata getOriginalStates(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.me.dao.custom.entity.ObjectAttributeMetadata __entity) {
    }

    /**
     * @return the singleton
     */
    public static _ObjectAttributeMetadata getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _ObjectAttributeMetadata newInstance() {
        return new _ObjectAttributeMetadata();
    }

}
