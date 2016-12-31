package szlh.iih.sync.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.626+0800")
public final class _XapOrgEmpPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.sync.po.XapOrgEmpPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _XapOrgEmpPo __singleton = new _XapOrgEmpPo();

    /** the orgEmpId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.Integer, java.lang.Object> $orgEmpId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.Integer, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "orgEmpId", "ORG_EMP_ID");

    /** the empId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "empId", true, true);

    /** the deptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $deptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptCd", "deptCd", true, true);

    /** the empNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $empNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empNo", "empNo", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "nm", true, true);

    /** the nmSpell */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $nmSpell = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nmSpell", "nmSpell", true, true);

    /** the sexCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $sexCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sexCd", "sexCd", true, true);

    /** the birthday */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $birthday = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "birthday", "birthday", true, true);

    /** the idCardNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $idCardNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "idCardNo", "idCardNo", true, true);

    /** the email */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $email = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "email", "email", true, true);

    /** the jobTitleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $jobTitleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "jobTitleCd", "jobTitleCd", true, true);

    /** the positionCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $positionCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "positionCd", "positionCd", true, true);

    /** the profCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $profCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "profCd", "profCd", true, true);

    /** the telNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $telNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "telNo", "telNo", true, true);

    /** the mobileNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $mobileNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mobileNo", "mobileNo", true, true);

    /** the iemrJobTitleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $iemrJobTitleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "iemrJobTitleCd", "iemrJobTitleCd", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "delF", "delF", true, true);

    /** the flag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object> $flag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapOrgEmpPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "flag", "flag", true, true);

    private final szlh.iih.sync.po.XapOrgEmpPoListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>> __entityPropertyTypeMap;

    private _XapOrgEmpPo() {
        __listener = new szlh.iih.sync.po.XapOrgEmpPoListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "XapOrgEmpPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "iemr_org_emp";
        __qualifiedTableName = "iemr_org_emp";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>>(18);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>>(18);
        __idList.add($orgEmpId);
        __list.add($orgEmpId);
        __map.put("orgEmpId", $orgEmpId);
        __list.add($empId);
        __map.put("empId", $empId);
        __list.add($deptCd);
        __map.put("deptCd", $deptCd);
        __list.add($empNo);
        __map.put("empNo", $empNo);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($nmSpell);
        __map.put("nmSpell", $nmSpell);
        __list.add($sexCd);
        __map.put("sexCd", $sexCd);
        __list.add($birthday);
        __map.put("birthday", $birthday);
        __list.add($idCardNo);
        __map.put("idCardNo", $idCardNo);
        __list.add($email);
        __map.put("email", $email);
        __list.add($jobTitleCd);
        __map.put("jobTitleCd", $jobTitleCd);
        __list.add($positionCd);
        __map.put("positionCd", $positionCd);
        __list.add($profCd);
        __map.put("profCd", $profCd);
        __list.add($telNo);
        __map.put("telNo", $telNo);
        __list.add($mobileNo);
        __map.put("mobileNo", $mobileNo);
        __list.add($iemrJobTitleCd);
        __map.put("iemrJobTitleCd", $iemrJobTitleCd);
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
    public void preInsert(szlh.iih.sync.po.XapOrgEmpPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.sync.po.XapOrgEmpPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.sync.po.XapOrgEmpPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.sync.po.XapOrgEmpPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.sync.po.XapOrgEmpPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.sync.po.XapOrgEmpPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.sync.po.XapOrgEmpPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.sync.po.XapOrgEmpPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.sync.po.XapOrgEmpPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.sync.po.XapOrgEmpPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.sync.po.XapOrgEmpPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.sync.po.XapOrgEmpPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapOrgEmpPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.sync.po.XapOrgEmpPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.sync.po.XapOrgEmpPo newEntity() {
        return new szlh.iih.sync.po.XapOrgEmpPo();
    }

    @Override
    public szlh.iih.sync.po.XapOrgEmpPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.sync.po.XapOrgEmpPo();
    }

    @Override
    public Class<szlh.iih.sync.po.XapOrgEmpPo> getEntityClass() {
        return szlh.iih.sync.po.XapOrgEmpPo.class;
    }

    @Override
    public szlh.iih.sync.po.XapOrgEmpPo getOriginalStates(szlh.iih.sync.po.XapOrgEmpPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.sync.po.XapOrgEmpPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _XapOrgEmpPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _XapOrgEmpPo newInstance() {
        return new _XapOrgEmpPo();
    }

}
