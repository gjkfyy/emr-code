package szlh.iih.sync.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.634+0800")
public final class _XapUserPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.sync.po.XapUserPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _XapUserPo __singleton = new _XapUserPo();

    /** the xapUserId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.Integer, java.lang.Object> $xapUserId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.Integer, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "xapUserId", "XAP_USER_ID");

    /** the xapUserPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $xapUserPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "xapUserPk", "xapUserPk", true, true);

    /** the userId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $userId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "userId", "userId", true, true);

    /** the empId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "empId", true, true);

    /** the userStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $userStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "userStaCd", "userStaCd", true, true);

    /** the SignPic */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $SignPic = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "SignPic", "SignPic", true, true);

    /** the pwd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $pwd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "pwd", "pwd", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "nm", true, true);

    /** the nmSpell */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $nmSpell = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nmSpell", "nmSpell", true, true);

    /** the sexCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $sexCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sexCd", "sexCd", true, true);

    /** the email */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $email = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "email", "email", true, true);

    /** the jobTitleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $jobTitleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "jobTitleCd", "jobTitleCd", true, true);

    /** the mobileNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $mobileNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mobileNo", "mobileNo", true, true);

    /** the telNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $telNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "telNo", "telNo", true, true);

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "orgCd", true, true);

    /** the loginNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $loginNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "loginNm", "loginNm", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "delF", "delF", true, true);

    /** the dctNsF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $dctNsF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dctNsF", "dctNsF", true, true);

    /** the flag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object> $flag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.XapUserPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "flag", "flag", true, true);

    private final szlh.iih.sync.po.XapUserPoListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>> __entityPropertyTypeMap;

    private _XapUserPo() {
        __listener = new szlh.iih.sync.po.XapUserPoListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "XapUserPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "iemr_xap_user";
        __qualifiedTableName = "iemr_xap_user";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>>(19);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>>(19);
        __idList.add($xapUserId);
        __list.add($xapUserId);
        __map.put("xapUserId", $xapUserId);
        __list.add($xapUserPk);
        __map.put("xapUserPk", $xapUserPk);
        __list.add($userId);
        __map.put("userId", $userId);
        __list.add($empId);
        __map.put("empId", $empId);
        __list.add($userStaCd);
        __map.put("userStaCd", $userStaCd);
        __list.add($SignPic);
        __map.put("SignPic", $SignPic);
        __list.add($pwd);
        __map.put("pwd", $pwd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($nmSpell);
        __map.put("nmSpell", $nmSpell);
        __list.add($sexCd);
        __map.put("sexCd", $sexCd);
        __list.add($email);
        __map.put("email", $email);
        __list.add($jobTitleCd);
        __map.put("jobTitleCd", $jobTitleCd);
        __list.add($mobileNo);
        __map.put("mobileNo", $mobileNo);
        __list.add($telNo);
        __map.put("telNo", $telNo);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($loginNm);
        __map.put("loginNm", $loginNm);
        __list.add($delF);
        __map.put("delF", $delF);
        __list.add($dctNsF);
        __map.put("dctNsF", $dctNsF);
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
    public void preInsert(szlh.iih.sync.po.XapUserPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.sync.po.XapUserPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.sync.po.XapUserPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.sync.po.XapUserPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.sync.po.XapUserPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.sync.po.XapUserPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.sync.po.XapUserPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.sync.po.XapUserPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.sync.po.XapUserPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.sync.po.XapUserPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.sync.po.XapUserPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.sync.po.XapUserPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.XapUserPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.sync.po.XapUserPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.sync.po.XapUserPo newEntity() {
        return new szlh.iih.sync.po.XapUserPo();
    }

    @Override
    public szlh.iih.sync.po.XapUserPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.sync.po.XapUserPo();
    }

    @Override
    public Class<szlh.iih.sync.po.XapUserPo> getEntityClass() {
        return szlh.iih.sync.po.XapUserPo.class;
    }

    @Override
    public szlh.iih.sync.po.XapUserPo getOriginalStates(szlh.iih.sync.po.XapUserPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.sync.po.XapUserPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _XapUserPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _XapUserPo newInstance() {
        return new _XapUserPo();
    }

}
