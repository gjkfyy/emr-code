package ei.his.db.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.795+0800")
public final class _HisMdDi extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.his.db.dao.auto.entity.HisMdDi> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _HisMdDi __singleton = new _HisMdDi();

    /** the name */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.his.db.dao.auto.entity.HisMdDi, java.lang.String, java.lang.Object> $name = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.his.db.dao.auto.entity.HisMdDi, java.lang.String, java.lang.Object>(ei.his.db.dao.auto.entity.HisMdDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "name", "name", true, true);

    /** the code */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.his.db.dao.auto.entity.HisMdDi, java.lang.String, java.lang.Object> $code = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.his.db.dao.auto.entity.HisMdDi, java.lang.String, java.lang.Object>(ei.his.db.dao.auto.entity.HisMdDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "code", "code", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<ei.his.db.dao.auto.entity.HisMdDi> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>> __entityPropertyTypeMap;

    private _HisMdDi() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<ei.his.db.dao.auto.entity.HisMdDi>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "HisMdDi";
        __catalogName = "";
        __schemaName = "";
        __tableName = "HisMdDi";
        __qualifiedTableName = "HisMdDi";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>>(2);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>>(2);
        __list.add($name);
        __map.put("name", $name);
        __list.add($code);
        __map.put("code", $code);
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
    public void preInsert(ei.his.db.dao.auto.entity.HisMdDi entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.his.db.dao.auto.entity.HisMdDi> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.his.db.dao.auto.entity.HisMdDi entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.his.db.dao.auto.entity.HisMdDi> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.his.db.dao.auto.entity.HisMdDi entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.his.db.dao.auto.entity.HisMdDi> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.his.db.dao.auto.entity.HisMdDi entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.his.db.dao.auto.entity.HisMdDi> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.his.db.dao.auto.entity.HisMdDi entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.his.db.dao.auto.entity.HisMdDi> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.his.db.dao.auto.entity.HisMdDi entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.his.db.dao.auto.entity.HisMdDi> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.his.db.dao.auto.entity.HisMdDi, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.his.db.dao.auto.entity.HisMdDi, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.his.db.dao.auto.entity.HisMdDi, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.his.db.dao.auto.entity.HisMdDi newEntity() {
        return new ei.his.db.dao.auto.entity.HisMdDi();
    }

    @Override
    public ei.his.db.dao.auto.entity.HisMdDi newEntity(java.util.Map<String, Object> __args) {
        return new ei.his.db.dao.auto.entity.HisMdDi();
    }

    @Override
    public Class<ei.his.db.dao.auto.entity.HisMdDi> getEntityClass() {
        return ei.his.db.dao.auto.entity.HisMdDi.class;
    }

    @Override
    public ei.his.db.dao.auto.entity.HisMdDi getOriginalStates(ei.his.db.dao.auto.entity.HisMdDi __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.his.db.dao.auto.entity.HisMdDi __entity) {
    }

    /**
     * @return the singleton
     */
    public static _HisMdDi getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _HisMdDi newInstance() {
        return new _HisMdDi();
    }

}
