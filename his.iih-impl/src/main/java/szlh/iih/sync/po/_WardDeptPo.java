package szlh.iih.sync.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.623+0800")
public final class _WardDeptPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.sync.po.WardDeptPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _WardDeptPo __singleton = new _WardDeptPo();

    /** the wardId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.Integer, java.lang.Object> $wardId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.Integer, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "wardId", "WARD_ID");

    /** the deptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $deptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptCd", "deptCd", true, true);

    /** the wardCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $wardCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wardCd", "wardCd", true, true);

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "orgCd", true, true);

    /** the deptTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $deptTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptTpCd", "deptTpCd", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "nm", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "memo", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "spellNo", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "delF", "delF", true, true);

    /** the flag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object> $flag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.WardDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "flag", "flag", true, true);

    private final szlh.iih.sync.po.WardDeptPoListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>> __entityPropertyTypeMap;

    private _WardDeptPo() {
        __listener = new szlh.iih.sync.po.WardDeptPoListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "WardDeptPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "iemr_ward_dept";
        __qualifiedTableName = "iemr_ward_dept";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>>(10);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>>(10);
        __idList.add($wardId);
        __list.add($wardId);
        __map.put("wardId", $wardId);
        __list.add($deptCd);
        __map.put("deptCd", $deptCd);
        __list.add($wardCd);
        __map.put("wardCd", $wardCd);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($deptTpCd);
        __map.put("deptTpCd", $deptTpCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($memo);
        __map.put("memo", $memo);
        __list.add($spellNo);
        __map.put("spellNo", $spellNo);
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
    public void preInsert(szlh.iih.sync.po.WardDeptPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.sync.po.WardDeptPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.sync.po.WardDeptPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.sync.po.WardDeptPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.sync.po.WardDeptPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.sync.po.WardDeptPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.sync.po.WardDeptPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.sync.po.WardDeptPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.sync.po.WardDeptPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.sync.po.WardDeptPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.sync.po.WardDeptPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.sync.po.WardDeptPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.WardDeptPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.sync.po.WardDeptPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.sync.po.WardDeptPo newEntity() {
        return new szlh.iih.sync.po.WardDeptPo();
    }

    @Override
    public szlh.iih.sync.po.WardDeptPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.sync.po.WardDeptPo();
    }

    @Override
    public Class<szlh.iih.sync.po.WardDeptPo> getEntityClass() {
        return szlh.iih.sync.po.WardDeptPo.class;
    }

    @Override
    public szlh.iih.sync.po.WardDeptPo getOriginalStates(szlh.iih.sync.po.WardDeptPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.sync.po.WardDeptPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _WardDeptPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _WardDeptPo newInstance() {
        return new _WardDeptPo();
    }

}
