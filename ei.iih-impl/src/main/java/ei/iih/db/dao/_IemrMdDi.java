package ei.iih.db.dao;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.644+0800")
public final class _IemrMdDi extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.iih.db.dao.IemrMdDi> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _IemrMdDi __singleton = new _IemrMdDi();

    /** the diCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.iih.db.dao.IemrMdDi, java.lang.String, java.lang.Object> $diCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.iih.db.dao.IemrMdDi, java.lang.String, java.lang.Object>(ei.iih.db.dao.IemrMdDi.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCd", "diCd", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<ei.iih.db.dao.IemrMdDi> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>> __entityPropertyTypeMap;

    private _IemrMdDi() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<ei.iih.db.dao.IemrMdDi>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "IemrMdDi";
        __catalogName = "";
        __schemaName = "";
        __tableName = "IemrMdDi";
        __qualifiedTableName = "IemrMdDi";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>>(1);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>>(1);
        __list.add($diCd);
        __map.put("diCd", $diCd);
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
    public void preInsert(ei.iih.db.dao.IemrMdDi entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.iih.db.dao.IemrMdDi> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.iih.db.dao.IemrMdDi entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.iih.db.dao.IemrMdDi> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.iih.db.dao.IemrMdDi entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.iih.db.dao.IemrMdDi> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.iih.db.dao.IemrMdDi entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.iih.db.dao.IemrMdDi> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.iih.db.dao.IemrMdDi entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.iih.db.dao.IemrMdDi> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.iih.db.dao.IemrMdDi entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.iih.db.dao.IemrMdDi> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.iih.db.dao.IemrMdDi, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.iih.db.dao.IemrMdDi, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.iih.db.dao.IemrMdDi, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.iih.db.dao.IemrMdDi newEntity() {
        return new ei.iih.db.dao.IemrMdDi();
    }

    @Override
    public ei.iih.db.dao.IemrMdDi newEntity(java.util.Map<String, Object> __args) {
        return new ei.iih.db.dao.IemrMdDi();
    }

    @Override
    public Class<ei.iih.db.dao.IemrMdDi> getEntityClass() {
        return ei.iih.db.dao.IemrMdDi.class;
    }

    @Override
    public ei.iih.db.dao.IemrMdDi getOriginalStates(ei.iih.db.dao.IemrMdDi __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.iih.db.dao.IemrMdDi __entity) {
    }

    /**
     * @return the singleton
     */
    public static _IemrMdDi getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _IemrMdDi newInstance() {
        return new _IemrMdDi();
    }

}
