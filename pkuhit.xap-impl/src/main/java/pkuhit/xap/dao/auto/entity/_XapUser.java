package pkuhit.xap.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.306+0800")
public final class _XapUser extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.xap.dao.auto.entity.XapUser> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _XapUser __singleton = new _XapUser();

    /** the xapUserPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $xapUserPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "xapUserPk", "XAP_USER_PK");

    /** the userId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $userId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "userId", "USER_ID", true, true);

    /** the empId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "EMP_ID", true, true);

    /** the userStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $userStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "userStaCd", "USER_STA_CD", true, true);

    /** the signPic */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.sql.Clob, java.lang.Object> $signPic = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.sql.Clob, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.sql.Clob.class, org.seasar.doma.wrapper.ClobWrapper.class, null, null, "signPic", "SIGN_PIC", true, true);

    /** the pwd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $pwd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "pwd", "PWD", true, true);

    /** the iemrPwd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $iemrPwd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "iemrPwd", "IEMR_PWD", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the nmSpell */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $nmSpell = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nmSpell", "NM_SPELL", true, true);

    /** the sexCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $sexCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sexCd", "SEX_CD", true, true);

    /** the email */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $email = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "email", "EMAIL", true, true);

    /** the jobTitleCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $jobTitleCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "jobTitleCd", "JOB_TITLE_CD", true, true);

    /** the mobileNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $mobileNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mobileNo", "MOBILE_NO", true, true);

    /** the telNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $telNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "telNo", "TEL_NO", true, true);

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD", true, true);

    /** the loginNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $loginNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "loginNm", "LOGIN_NM", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.math.BigInteger, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.Short, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the dctNsF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.Short, java.lang.Object> $dctNsF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, java.lang.Short, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapUser.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "dctNsF", "DCT_NS_F", true, true);

    private final pkuhit.xap.dao.auto.entity.XapUserListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>> __entityPropertyTypeMap;

    private _XapUser() {
        __listener = new pkuhit.xap.dao.auto.entity.XapUserListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "XapUser";
        __catalogName = "";
        __schemaName = "";
        __tableName = "XAP_USER";
        __qualifiedTableName = "XAP_USER";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>>(29);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>>(29);
        __idList.add($xapUserPk);
        __list.add($xapUserPk);
        __map.put("xapUserPk", $xapUserPk);
        __list.add($userId);
        __map.put("userId", $userId);
        __list.add($empId);
        __map.put("empId", $empId);
        __list.add($userStaCd);
        __map.put("userStaCd", $userStaCd);
        __list.add($signPic);
        __map.put("signPic", $signPic);
        __list.add($pwd);
        __map.put("pwd", $pwd);
        __list.add($iemrPwd);
        __map.put("iemrPwd", $iemrPwd);
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
        __list.add($dctNsF);
        __map.put("dctNsF", $dctNsF);
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
    public void preInsert(pkuhit.xap.dao.auto.entity.XapUser entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.xap.dao.auto.entity.XapUser> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.xap.dao.auto.entity.XapUser entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.xap.dao.auto.entity.XapUser> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.xap.dao.auto.entity.XapUser entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.xap.dao.auto.entity.XapUser> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.xap.dao.auto.entity.XapUser entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.xap.dao.auto.entity.XapUser> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.xap.dao.auto.entity.XapUser entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.xap.dao.auto.entity.XapUser> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.xap.dao.auto.entity.XapUser entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.xap.dao.auto.entity.XapUser> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapUser, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapUser, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapUser newEntity() {
        return new pkuhit.xap.dao.auto.entity.XapUser();
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapUser newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.xap.dao.auto.entity.XapUser();
    }

    @Override
    public Class<pkuhit.xap.dao.auto.entity.XapUser> getEntityClass() {
        return pkuhit.xap.dao.auto.entity.XapUser.class;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapUser getOriginalStates(pkuhit.xap.dao.auto.entity.XapUser __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.xap.dao.auto.entity.XapUser __entity) {
    }

    /**
     * @return the singleton
     */
    public static _XapUser getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _XapUser newInstance() {
        return new _XapUser();
    }

}
