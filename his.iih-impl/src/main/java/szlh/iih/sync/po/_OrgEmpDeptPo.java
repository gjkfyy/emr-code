package szlh.iih.sync.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.599+0800")
public final class _OrgEmpDeptPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.sync.po.OrgEmpDeptPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _OrgEmpDeptPo __singleton = new _OrgEmpDeptPo();

    /** the orgEmpDeptId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.Integer, java.lang.Object> $orgEmpDeptId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.Integer, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "orgEmpDeptId", "ORG_EMP_DEPT_ID");

    /** the empDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object> $empDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empDeptCd", "empDeptCd", true, true);

    /** the wardDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object> $wardDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wardDeptCd", "wardDeptCd", true, true);

    /** the empId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "empId", true, true);

    /** the SignLvlCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object> $SignLvlCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "SignLvlCd", "SignLvlCd", true, true);

    /** the CurDrcDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object> $CurDrcDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "CurDrcDctId", "CurDrcDctId", true, true);

    /** the curDeputyDrcDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object> $curDeputyDrcDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curDeputyDrcDctId", "curDeputyDrcDctId", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "delF", "delF", true, true);

    /** the flag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object> $flag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgEmpDeptPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "flag", "flag", true, true);

    private final szlh.iih.sync.po.OrgEmpDeptPoListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>> __entityPropertyTypeMap;

    private _OrgEmpDeptPo() {
        __listener = new szlh.iih.sync.po.OrgEmpDeptPoListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "OrgEmpDeptPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "iemr_org_emp_dept";
        __qualifiedTableName = "iemr_org_emp_dept";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>>(9);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>>(9);
        __idList.add($orgEmpDeptId);
        __list.add($orgEmpDeptId);
        __map.put("orgEmpDeptId", $orgEmpDeptId);
        __list.add($empDeptCd);
        __map.put("empDeptCd", $empDeptCd);
        __list.add($wardDeptCd);
        __map.put("wardDeptCd", $wardDeptCd);
        __list.add($empId);
        __map.put("empId", $empId);
        __list.add($SignLvlCd);
        __map.put("SignLvlCd", $SignLvlCd);
        __list.add($CurDrcDctId);
        __map.put("CurDrcDctId", $CurDrcDctId);
        __list.add($curDeputyDrcDctId);
        __map.put("curDeputyDrcDctId", $curDeputyDrcDctId);
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
    public void preInsert(szlh.iih.sync.po.OrgEmpDeptPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.sync.po.OrgEmpDeptPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.sync.po.OrgEmpDeptPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.sync.po.OrgEmpDeptPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.sync.po.OrgEmpDeptPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.sync.po.OrgEmpDeptPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.sync.po.OrgEmpDeptPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.sync.po.OrgEmpDeptPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.sync.po.OrgEmpDeptPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.sync.po.OrgEmpDeptPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.sync.po.OrgEmpDeptPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.sync.po.OrgEmpDeptPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgEmpDeptPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.sync.po.OrgEmpDeptPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.sync.po.OrgEmpDeptPo newEntity() {
        return new szlh.iih.sync.po.OrgEmpDeptPo();
    }

    @Override
    public szlh.iih.sync.po.OrgEmpDeptPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.sync.po.OrgEmpDeptPo();
    }

    @Override
    public Class<szlh.iih.sync.po.OrgEmpDeptPo> getEntityClass() {
        return szlh.iih.sync.po.OrgEmpDeptPo.class;
    }

    @Override
    public szlh.iih.sync.po.OrgEmpDeptPo getOriginalStates(szlh.iih.sync.po.OrgEmpDeptPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.sync.po.OrgEmpDeptPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _OrgEmpDeptPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _OrgEmpDeptPo newInstance() {
        return new _OrgEmpDeptPo();
    }

}
