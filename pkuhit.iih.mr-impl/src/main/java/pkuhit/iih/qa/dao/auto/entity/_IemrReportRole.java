package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.222+0800")
public final class _IemrReportRole extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _IemrReportRole __singleton = new _IemrReportRole();

    /** the iemrReportRoleId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $iemrReportRoleId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "iemrReportRoleId", "IEMR_REPORT_ROLE_ID");

    /** the iemrReportId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $iemrReportId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "iemrReportId", "IEMR_REPORT_ID", true, true);

    /** the roleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $roleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "roleCd", "ROLE_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.IemrReportRoleListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>> __entityPropertyTypeMap;

    private _IemrReportRole() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.IemrReportRoleListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "IemrReportRole";
        __catalogName = "";
        __schemaName = "";
        __tableName = "IEMR_REPORT_ROLE";
        __qualifiedTableName = "IEMR_REPORT_ROLE";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>>(15);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>>(15);
        __idList.add($iemrReportRoleId);
        __list.add($iemrReportRoleId);
        __map.put("iemrReportRoleId", $iemrReportRoleId);
        __list.add($iemrReportId);
        __map.put("iemrReportId", $iemrReportId);
        __list.add($roleCd);
        __map.put("roleCd", $roleCd);
        __list.add($memo);
        __map.put("memo", $memo);
        __list.add($sortNo);
        __map.put("sortNo", $sortNo);
        __list.add($spellNo);
        __map.put("spellNo", $spellNo);
        __list.add($wubiNo);
        __map.put("wubiNo", $wubiNo);
        __list.add($updCnt);
        __map.put("updCnt", $updCnt);
        __list.add($crtTime);
        __map.put("crtTime", $crtTime);
        __list.add($crtUserId);
        __map.put("crtUserId", $crtUserId);
        __list.add($crtDeptCd);
        __map.put("crtDeptCd", $crtDeptCd);
        __list.add($lastUpdTime);
        __map.put("lastUpdTime", $lastUpdTime);
        __list.add($lastUpdDeptCd);
        __map.put("lastUpdDeptCd", $lastUpdDeptCd);
        __list.add($lastUpdUserId);
        __map.put("lastUpdUserId", $lastUpdUserId);
        __list.add($delF);
        __map.put("delF", $delF);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.IemrReportRole entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.IemrReportRole> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.IemrReportRole entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.IemrReportRole> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.IemrReportRole entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.IemrReportRole> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.IemrReportRole entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.IemrReportRole> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.IemrReportRole entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.IemrReportRole> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.IemrReportRole entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.IemrReportRole> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.IemrReportRole, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.IemrReportRole newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.IemrReportRole();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.IemrReportRole newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.IemrReportRole();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.IemrReportRole> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.IemrReportRole.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.IemrReportRole getOriginalStates(pkuhit.iih.qa.dao.auto.entity.IemrReportRole __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.IemrReportRole __entity) {
    }

    /**
     * @return the singleton
     */
    public static _IemrReportRole getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _IemrReportRole newInstance() {
        return new _IemrReportRole();
    }

}
