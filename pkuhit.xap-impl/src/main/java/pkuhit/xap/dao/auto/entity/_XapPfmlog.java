package pkuhit.xap.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.301+0800")
public final class _XapPfmlog extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.xap.dao.auto.entity.XapPfmlog> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _XapPfmlog __singleton = new _XapPfmlog();

    /** the pfmlogPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $pfmlogPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "pfmlogPk", "PFMLOG_PK");

    /** the userId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $userId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "userId", "USER_ID", true, true);

    /** the xsvCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $xsvCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "xsvCd", "XSV_CD", true, true);

    /** the input */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $input = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "input", "INPUT", true, true);

    /** the output */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $output = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "output", "OUTPUT", true, true);

    /** the elapsedTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.math.BigInteger, java.lang.Object> $elapsedTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.math.BigInteger, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "elapsedTime", "ELAPSED_TIME", true, true);

    /** the beginTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.sql.Timestamp, java.lang.Object> $beginTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "beginTime", "BEGIN_TIME", true, true);

    /** the endTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.sql.Timestamp, java.lang.Object> $endTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "endTime", "END_TIME", true, true);

    /** the actDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $actDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "actDeptCd", "ACT_DEPT_CD", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.math.BigInteger, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, java.lang.Short, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapPfmlog.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.xap.dao.auto.entity.XapPfmlogListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>> __entityPropertyTypeMap;

    private _XapPfmlog() {
        __listener = new pkuhit.xap.dao.auto.entity.XapPfmlogListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "XapPfmlog";
        __catalogName = "";
        __schemaName = "";
        __tableName = "XAP_PFMLOG";
        __qualifiedTableName = "XAP_PFMLOG";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>>(17);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>>(17);
        __idList.add($pfmlogPk);
        __list.add($pfmlogPk);
        __map.put("pfmlogPk", $pfmlogPk);
        __list.add($userId);
        __map.put("userId", $userId);
        __list.add($xsvCd);
        __map.put("xsvCd", $xsvCd);
        __list.add($input);
        __map.put("input", $input);
        __list.add($output);
        __map.put("output", $output);
        __list.add($elapsedTime);
        __map.put("elapsedTime", $elapsedTime);
        __list.add($beginTime);
        __map.put("beginTime", $beginTime);
        __list.add($endTime);
        __map.put("endTime", $endTime);
        __list.add($actDeptCd);
        __map.put("actDeptCd", $actDeptCd);
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
    public void preInsert(pkuhit.xap.dao.auto.entity.XapPfmlog entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.xap.dao.auto.entity.XapPfmlog> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.xap.dao.auto.entity.XapPfmlog entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.xap.dao.auto.entity.XapPfmlog> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.xap.dao.auto.entity.XapPfmlog entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.xap.dao.auto.entity.XapPfmlog> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.xap.dao.auto.entity.XapPfmlog entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.xap.dao.auto.entity.XapPfmlog> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.xap.dao.auto.entity.XapPfmlog entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.xap.dao.auto.entity.XapPfmlog> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.xap.dao.auto.entity.XapPfmlog entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.xap.dao.auto.entity.XapPfmlog> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapPfmlog, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapPfmlog, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapPfmlog newEntity() {
        return new pkuhit.xap.dao.auto.entity.XapPfmlog();
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapPfmlog newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.xap.dao.auto.entity.XapPfmlog();
    }

    @Override
    public Class<pkuhit.xap.dao.auto.entity.XapPfmlog> getEntityClass() {
        return pkuhit.xap.dao.auto.entity.XapPfmlog.class;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapPfmlog getOriginalStates(pkuhit.xap.dao.auto.entity.XapPfmlog __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.xap.dao.auto.entity.XapPfmlog __entity) {
    }

    /**
     * @return the singleton
     */
    public static _XapPfmlog getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _XapPfmlog newInstance() {
        return new _XapPfmlog();
    }

}
