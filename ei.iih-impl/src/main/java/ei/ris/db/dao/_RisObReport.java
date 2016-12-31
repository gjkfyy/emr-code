package ei.ris.db.dao;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.773+0800")
public final class _RisObReport extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.ris.db.dao.RisObReport> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _RisObReport __singleton = new _RisObReport();

    /** the ObRpPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ris.db.dao.RisObReport, java.lang.String, java.lang.Object> $ObRpPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ris.db.dao.RisObReport, java.lang.String, java.lang.Object>(ei.ris.db.dao.RisObReport.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ObRpPk", "ObRpPk", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ris.db.dao.RisObReport, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ris.db.dao.RisObReport, java.lang.String, java.lang.Object>(ei.ris.db.dao.RisObReport.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "enPk", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<ei.ris.db.dao.RisObReport> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>> __entityPropertyTypeMap;

    private _RisObReport() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<ei.ris.db.dao.RisObReport>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "RisObReport";
        __catalogName = "";
        __schemaName = "";
        __tableName = "RisObReport";
        __qualifiedTableName = "RisObReport";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>>(2);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>>(2);
        __list.add($ObRpPk);
        __map.put("ObRpPk", $ObRpPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
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
    public void preInsert(ei.ris.db.dao.RisObReport entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.ris.db.dao.RisObReport> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.ris.db.dao.RisObReport entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.ris.db.dao.RisObReport> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.ris.db.dao.RisObReport entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.ris.db.dao.RisObReport> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.ris.db.dao.RisObReport entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.ris.db.dao.RisObReport> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.ris.db.dao.RisObReport entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.ris.db.dao.RisObReport> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.ris.db.dao.RisObReport entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.ris.db.dao.RisObReport> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ris.db.dao.RisObReport, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.ris.db.dao.RisObReport, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.ris.db.dao.RisObReport, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.ris.db.dao.RisObReport newEntity() {
        return new ei.ris.db.dao.RisObReport();
    }

    @Override
    public ei.ris.db.dao.RisObReport newEntity(java.util.Map<String, Object> __args) {
        return new ei.ris.db.dao.RisObReport();
    }

    @Override
    public Class<ei.ris.db.dao.RisObReport> getEntityClass() {
        return ei.ris.db.dao.RisObReport.class;
    }

    @Override
    public ei.ris.db.dao.RisObReport getOriginalStates(ei.ris.db.dao.RisObReport __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.ris.db.dao.RisObReport __entity) {
    }

    /**
     * @return the singleton
     */
    public static _RisObReport getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _RisObReport newInstance() {
        return new _RisObReport();
    }

}
