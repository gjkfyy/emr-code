package pkuhit.org.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.352+0800")
public final class _OrgEmp extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.org.dao.auto.entity.OrgEmp> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _OrgEmp __singleton = new _OrgEmp();

    /** the empId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "EMP_ID");

    /** the deptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $deptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptCd", "DEPT_CD", true, true);

    /** the empNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $empNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empNo", "EMP_NO", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the nmSpell */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $nmSpell = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nmSpell", "NM_SPELL", true, true);

    /** the sexCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $sexCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sexCd", "SEX_CD", true, true);

    /** the birthday */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.sql.Timestamp, java.lang.Object> $birthday = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "birthday", "BIRTHDAY", true, true);

    /** the idCardNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $idCardNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "idCardNo", "ID_CARD_NO", true, true);

    /** the email */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $email = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "email", "EMAIL", true, true);

    /** the jobTitleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $jobTitleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "jobTitleCd", "JOB_TITLE_CD", true, true);

    /** the positionCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $positionCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "positionCd", "POSITION_CD", true, true);

    /** the profCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $profCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "profCd", "PROF_CD", true, true);

    /** the telNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $telNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "telNo", "TEL_NO", true, true);

    /** the mobileNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $mobileNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mobileNo", "MOBILE_NO", true, true);

    /** the iemrJobTitleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $iemrJobTitleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "iemrJobTitleCd", "IEMR_JOB_TITLE_CD", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.math.BigInteger, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, java.lang.Short, java.lang.Object>(pkuhit.org.dao.auto.entity.OrgEmp.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.org.dao.auto.entity.OrgEmpListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>> __entityPropertyTypeMap;

    private _OrgEmp() {
        __listener = new pkuhit.org.dao.auto.entity.OrgEmpListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "OrgEmp";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ORG_EMP";
        __qualifiedTableName = "ORG_EMP";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>>(27);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>>(27);
        __idList.add($empId);
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
    public void preInsert(pkuhit.org.dao.auto.entity.OrgEmp entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.org.dao.auto.entity.OrgEmp> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.org.dao.auto.entity.OrgEmp entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.org.dao.auto.entity.OrgEmp> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.org.dao.auto.entity.OrgEmp entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.org.dao.auto.entity.OrgEmp> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.org.dao.auto.entity.OrgEmp entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.org.dao.auto.entity.OrgEmp> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.org.dao.auto.entity.OrgEmp entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.org.dao.auto.entity.OrgEmp> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.org.dao.auto.entity.OrgEmp entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.org.dao.auto.entity.OrgEmp> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.OrgEmp, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.OrgEmp, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgEmp newEntity() {
        return new pkuhit.org.dao.auto.entity.OrgEmp();
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgEmp newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.org.dao.auto.entity.OrgEmp();
    }

    @Override
    public Class<pkuhit.org.dao.auto.entity.OrgEmp> getEntityClass() {
        return pkuhit.org.dao.auto.entity.OrgEmp.class;
    }

    @Override
    public pkuhit.org.dao.auto.entity.OrgEmp getOriginalStates(pkuhit.org.dao.auto.entity.OrgEmp __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.org.dao.auto.entity.OrgEmp __entity) {
    }

    /**
     * @return the singleton
     */
    public static _OrgEmp getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _OrgEmp newInstance() {
        return new _OrgEmp();
    }

}
