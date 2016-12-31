package szlh.iih.en.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.645+0800")
public final class _TreatmentGroupMemberPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.en.po.TreatmentGroupMemberPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _TreatmentGroupMemberPo __singleton = new _TreatmentGroupMemberPo();

    /** the enGrpMenPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object> $enGrpMenPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.TreatmentGroupMemberPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enGrpMenPk", "enGrpMenPk", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.TreatmentGroupMemberPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "enPk", true, true);

    /** the empId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.TreatmentGroupMemberPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "empId", true, true);

    /** the roleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object> $roleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.TreatmentGroupMemberPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "roleCd", "roleCd", true, true);

    /** the patientID */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object> $patientID = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.TreatmentGroupMemberPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientID", "patientID", true, true);

    /** the enCount */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object> $enCount = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.TreatmentGroupMemberPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enCount", "enCount", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<szlh.iih.en.po.TreatmentGroupMemberPo> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>> __entityPropertyTypeMap;

    private _TreatmentGroupMemberPo() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<szlh.iih.en.po.TreatmentGroupMemberPo>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "TreatmentGroupMemberPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "TreatmentGroupMemberPo";
        __qualifiedTableName = "TreatmentGroupMemberPo";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>>(6);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>>(6);
        __list.add($enGrpMenPk);
        __map.put("enGrpMenPk", $enGrpMenPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($empId);
        __map.put("empId", $empId);
        __list.add($roleCd);
        __map.put("roleCd", $roleCd);
        __list.add($patientID);
        __map.put("patientID", $patientID);
        __list.add($enCount);
        __map.put("enCount", $enCount);
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
    public void preInsert(szlh.iih.en.po.TreatmentGroupMemberPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.en.po.TreatmentGroupMemberPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.en.po.TreatmentGroupMemberPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.en.po.TreatmentGroupMemberPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.en.po.TreatmentGroupMemberPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.en.po.TreatmentGroupMemberPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.en.po.TreatmentGroupMemberPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.en.po.TreatmentGroupMemberPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.en.po.TreatmentGroupMemberPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.en.po.TreatmentGroupMemberPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.en.po.TreatmentGroupMemberPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.en.po.TreatmentGroupMemberPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.TreatmentGroupMemberPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.en.po.TreatmentGroupMemberPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.en.po.TreatmentGroupMemberPo newEntity() {
        return new szlh.iih.en.po.TreatmentGroupMemberPo();
    }

    @Override
    public szlh.iih.en.po.TreatmentGroupMemberPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.en.po.TreatmentGroupMemberPo();
    }

    @Override
    public Class<szlh.iih.en.po.TreatmentGroupMemberPo> getEntityClass() {
        return szlh.iih.en.po.TreatmentGroupMemberPo.class;
    }

    @Override
    public szlh.iih.en.po.TreatmentGroupMemberPo getOriginalStates(szlh.iih.en.po.TreatmentGroupMemberPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.en.po.TreatmentGroupMemberPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _TreatmentGroupMemberPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _TreatmentGroupMemberPo newInstance() {
        return new _TreatmentGroupMemberPo();
    }

}
