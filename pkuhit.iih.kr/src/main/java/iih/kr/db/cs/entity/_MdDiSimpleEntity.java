package iih.kr.db.cs.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:18.111+0800")
public final class _MdDiSimpleEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.kr.db.cs.entity.MdDiSimpleEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MdDiSimpleEntity __singleton = new _MdDiSimpleEntity();

    /** the diCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.MdDiSimpleEntity, java.lang.String, java.lang.Object> $diCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.MdDiSimpleEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.MdDiSimpleEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCd", "DI_CD");

    /** the diNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.MdDiSimpleEntity, java.lang.String, java.lang.Object> $diNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.MdDiSimpleEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.MdDiSimpleEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diNm", "NM", true, true);

    /** the icdCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.MdDiSimpleEntity, java.lang.String, java.lang.Object> $icdCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.kr.db.cs.entity.MdDiSimpleEntity, java.lang.String, java.lang.Object>(iih.kr.db.cs.entity.MdDiSimpleEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "icdCd", "ICD_CD", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.MdDiSimpleEntity> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>> __entityPropertyTypeMap;

    private _MdDiSimpleEntity() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<iih.kr.db.cs.entity.MdDiSimpleEntity>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MdDiSimpleEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MdDiSimpleEntity";
        __qualifiedTableName = "MdDiSimpleEntity";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>>(3);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>>(3);
        __idList.add($diCd);
        __list.add($diCd);
        __map.put("diCd", $diCd);
        __list.add($diNm);
        __map.put("diNm", $diNm);
        __list.add($icdCd);
        __map.put("icdCd", $icdCd);
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
    public void preInsert(iih.kr.db.cs.entity.MdDiSimpleEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.kr.db.cs.entity.MdDiSimpleEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.kr.db.cs.entity.MdDiSimpleEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.kr.db.cs.entity.MdDiSimpleEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.kr.db.cs.entity.MdDiSimpleEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.kr.db.cs.entity.MdDiSimpleEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.kr.db.cs.entity.MdDiSimpleEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.kr.db.cs.entity.MdDiSimpleEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.kr.db.cs.entity.MdDiSimpleEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.kr.db.cs.entity.MdDiSimpleEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.kr.db.cs.entity.MdDiSimpleEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.kr.db.cs.entity.MdDiSimpleEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.kr.db.cs.entity.MdDiSimpleEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.kr.db.cs.entity.MdDiSimpleEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.kr.db.cs.entity.MdDiSimpleEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.kr.db.cs.entity.MdDiSimpleEntity newEntity() {
        return new iih.kr.db.cs.entity.MdDiSimpleEntity();
    }

    @Override
    public iih.kr.db.cs.entity.MdDiSimpleEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.kr.db.cs.entity.MdDiSimpleEntity();
    }

    @Override
    public Class<iih.kr.db.cs.entity.MdDiSimpleEntity> getEntityClass() {
        return iih.kr.db.cs.entity.MdDiSimpleEntity.class;
    }

    @Override
    public iih.kr.db.cs.entity.MdDiSimpleEntity getOriginalStates(iih.kr.db.cs.entity.MdDiSimpleEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.kr.db.cs.entity.MdDiSimpleEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MdDiSimpleEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MdDiSimpleEntity newInstance() {
        return new _MdDiSimpleEntity();
    }

}
