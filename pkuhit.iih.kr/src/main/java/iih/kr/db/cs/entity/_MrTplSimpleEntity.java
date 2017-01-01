package iih.kr.db.cs.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.131+0800")
public final class _MrTplSimpleEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.cs.entity.MrTplSimpleEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MrTplSimpleEntity __singleton = new _MrTplSimpleEntity();

    /** the mrTplCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, java.lang.String, java.lang.Object> $mrTplCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.MrTplSimpleEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTplCd", "MR_TPL_CD");

    /** the mrTpCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, java.lang.String, java.lang.Object> $mrTpCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.MrTplSimpleEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTpCd", "MR_TP_CD");

    /** the filePk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, java.lang.String, java.lang.Object> $filePk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.MrTplSimpleEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "filePk", "FILE_PK", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.MrTplSimpleEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.MrTplSimpleEntity> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>> __entityPropertyTypeMap;

    private _MrTplSimpleEntity() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.MrTplSimpleEntity>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MrTplSimpleEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MrTplSimpleEntity";
        __qualifiedTableName = "MrTplSimpleEntity";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>>(4);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>>(4);
        __idList.add($mrTplCd);
        __list.add($mrTplCd);
        __map.put("mrTplCd", $mrTplCd);
        __idList.add($mrTpCd);
        __list.add($mrTpCd);
        __map.put("mrTpCd", $mrTpCd);
        __list.add($filePk);
        __map.put("filePk", $filePk);
        __list.add($nm);
        __map.put("nm", $nm);
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
    public void preInsert(iih.kr.db.cs.entity.MrTplSimpleEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.cs.entity.MrTplSimpleEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.cs.entity.MrTplSimpleEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.cs.entity.MrTplSimpleEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.cs.entity.MrTplSimpleEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.cs.entity.MrTplSimpleEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.cs.entity.MrTplSimpleEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.cs.entity.MrTplSimpleEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.cs.entity.MrTplSimpleEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.cs.entity.MrTplSimpleEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.cs.entity.MrTplSimpleEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.cs.entity.MrTplSimpleEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MrTplSimpleEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.cs.entity.MrTplSimpleEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.cs.entity.MrTplSimpleEntity newEntity() {
        return new iih.kr.db.cs.entity.MrTplSimpleEntity();
    }

    @Override
    public iih.kr.db.cs.entity.MrTplSimpleEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.cs.entity.MrTplSimpleEntity();
    }

    @Override
    public Class<iih.kr.db.cs.entity.MrTplSimpleEntity> getEntityClass() {
        return iih.kr.db.cs.entity.MrTplSimpleEntity.class;
    }

    @Override
    public iih.kr.db.cs.entity.MrTplSimpleEntity getOriginalStates(iih.kr.db.cs.entity.MrTplSimpleEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.cs.entity.MrTplSimpleEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MrTplSimpleEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MrTplSimpleEntity newInstance() {
        return new _MrTplSimpleEntity();
    }

}
