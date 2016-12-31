package szlh.iih.sync.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.650+0800")
public final class _MdDiPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.sync.po.MdDiPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MdDiPo __singleton = new _MdDiPo();

    /** the mdId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.Integer, java.lang.Object> $mdId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.Integer, java.lang.Object>(szlh.iih.sync.po.MdDiPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "mdId", "MD_ID");

    /** the diCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object> $diCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.MdDiPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diCd", "diCd", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.MdDiPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "nm", true, true);

    /** the icdCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object> $icdCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.MdDiPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "icdCd", "icdCd", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.MdDiPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "spellNo", true, true);

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.MdDiPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "orgCd", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.MdDiPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "delF", "delF", true, true);

    /** the flag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object> $flag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.MdDiPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "flag", "flag", true, true);

    private final szlh.iih.sync.po.MdDiPoListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>> __entityPropertyTypeMap;

    private _MdDiPo() {
        __listener = new szlh.iih.sync.po.MdDiPoListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MdDiPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "iemr_md_di";
        __qualifiedTableName = "iemr_md_di";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>>(8);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>>(8);
        __idList.add($mdId);
        __list.add($mdId);
        __map.put("mdId", $mdId);
        __list.add($diCd);
        __map.put("diCd", $diCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($icdCd);
        __map.put("icdCd", $icdCd);
        __list.add($spellNo);
        __map.put("spellNo", $spellNo);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($delF);
        __map.put("delF", $delF);
        __list.add($flag);
        __map.put("flag", $flag);
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
    public void preInsert(szlh.iih.sync.po.MdDiPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.sync.po.MdDiPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.sync.po.MdDiPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.sync.po.MdDiPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.sync.po.MdDiPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.sync.po.MdDiPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.sync.po.MdDiPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.sync.po.MdDiPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.sync.po.MdDiPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.sync.po.MdDiPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.sync.po.MdDiPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.sync.po.MdDiPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.MdDiPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.sync.po.MdDiPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.sync.po.MdDiPo newEntity() {
        return new szlh.iih.sync.po.MdDiPo();
    }

    @Override
    public szlh.iih.sync.po.MdDiPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.sync.po.MdDiPo();
    }

    @Override
    public Class<szlh.iih.sync.po.MdDiPo> getEntityClass() {
        return szlh.iih.sync.po.MdDiPo.class;
    }

    @Override
    public szlh.iih.sync.po.MdDiPo getOriginalStates(szlh.iih.sync.po.MdDiPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.sync.po.MdDiPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MdDiPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MdDiPo newInstance() {
        return new _MdDiPo();
    }

}
