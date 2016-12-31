package ei.lis.db.dao.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.756+0800")
public final class _LabReportItemPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.lis.db.dao.po.LabReportItemPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _LabReportItemPo __singleton = new _LabReportItemPo();

    /** the mrLabRpItmPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $mrLabRpItmPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrLabRpItmPk", "mrLabRpItmPk", true, true);

    /** the labRpPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $labRpPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labRpPk", "labRpPk", true, true);

    /** the labItmCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $labItmCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labItmCd", "labItmCd", true, true);

    /** the labItmNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $labItmNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labItmNm", "labItmNm", true, true);

    /** the labItmVal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $labItmVal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labItmVal", "labItmVal", true, true);

    /** the maxNrmlVal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $maxNrmlVal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "maxNrmlVal", "maxNrmlVal", true, true);

    /** the minNrmlVal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $minNrmlVal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "minNrmlVal", "minNrmlVal", true, true);

    /** the labItmUnitCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $labItmUnitCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labItmUnitCd", "labItmUnitCd", true, true);

    /** the labItmUnitNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $labItmUnitNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labItmUnitNm", "labItmUnitNm", true, true);

    /** the referRange */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $referRange = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "referRange", "referRange", true, true);

    /** the labItmCompare */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object> $labItmCompare = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, java.lang.String, java.lang.Object>(ei.lis.db.dao.po.LabReportItemPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labItmCompare", "labItmCompare", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<ei.lis.db.dao.po.LabReportItemPo> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>> __entityPropertyTypeMap;

    private _LabReportItemPo() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<ei.lis.db.dao.po.LabReportItemPo>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "LabReportItemPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "LabReportItemPo";
        __qualifiedTableName = "LabReportItemPo";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>>(11);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>>(11);
        __list.add($mrLabRpItmPk);
        __map.put("mrLabRpItmPk", $mrLabRpItmPk);
        __list.add($labRpPk);
        __map.put("labRpPk", $labRpPk);
        __list.add($labItmCd);
        __map.put("labItmCd", $labItmCd);
        __list.add($labItmNm);
        __map.put("labItmNm", $labItmNm);
        __list.add($labItmVal);
        __map.put("labItmVal", $labItmVal);
        __list.add($maxNrmlVal);
        __map.put("maxNrmlVal", $maxNrmlVal);
        __list.add($minNrmlVal);
        __map.put("minNrmlVal", $minNrmlVal);
        __list.add($labItmUnitCd);
        __map.put("labItmUnitCd", $labItmUnitCd);
        __list.add($labItmUnitNm);
        __map.put("labItmUnitNm", $labItmUnitNm);
        __list.add($referRange);
        __map.put("referRange", $referRange);
        __list.add($labItmCompare);
        __map.put("labItmCompare", $labItmCompare);
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
    public void preInsert(ei.lis.db.dao.po.LabReportItemPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.lis.db.dao.po.LabReportItemPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.lis.db.dao.po.LabReportItemPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.lis.db.dao.po.LabReportItemPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.lis.db.dao.po.LabReportItemPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.lis.db.dao.po.LabReportItemPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.lis.db.dao.po.LabReportItemPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.lis.db.dao.po.LabReportItemPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.lis.db.dao.po.LabReportItemPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.lis.db.dao.po.LabReportItemPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.lis.db.dao.po.LabReportItemPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.lis.db.dao.po.LabReportItemPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.lis.db.dao.po.LabReportItemPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.lis.db.dao.po.LabReportItemPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.lis.db.dao.po.LabReportItemPo newEntity() {
        return new ei.lis.db.dao.po.LabReportItemPo();
    }

    @Override
    public ei.lis.db.dao.po.LabReportItemPo newEntity(java.util.Map<String, Object> __args) {
        return new ei.lis.db.dao.po.LabReportItemPo();
    }

    @Override
    public Class<ei.lis.db.dao.po.LabReportItemPo> getEntityClass() {
        return ei.lis.db.dao.po.LabReportItemPo.class;
    }

    @Override
    public ei.lis.db.dao.po.LabReportItemPo getOriginalStates(ei.lis.db.dao.po.LabReportItemPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.lis.db.dao.po.LabReportItemPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _LabReportItemPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _LabReportItemPo newInstance() {
        return new _LabReportItemPo();
    }

}
