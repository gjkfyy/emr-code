package pkuhit.iih.mr.tth.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.225+0800")
public final class _MrTeethExam extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MrTeethExam __singleton = new _MrTeethExam();

    /** the teethPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $teethPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "teethPk", "TEETH_PK");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the examDoctorCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $examDoctorCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "examDoctorCd", "EXAM_DOCTOR_CD", true, true);

    /** the examDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.util.Date, java.lang.Object> $examDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.util.Date, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.util.Date.class, org.seasar.doma.wrapper.UtilDateWrapper.class, null, null, "examDate", "EXAM_DATE", true, true);

    /** the bop */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $bop = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "bop", "BOP", true, true);

    /** the diDesc */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $diDesc = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diDesc", "DI_DESC", true, true);

    /** the othDesc */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $othDesc = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "othDesc", "OTH_DESC", true, true);

    /** the treatDesign */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $treatDesign = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "treatDesign", "TREAT_DESIGN", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.String, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>> __entityPropertyTypeMap;

    private _MrTeethExam() {
        __listener = new pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MrTeethExam";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MR_TEETH_EXAM";
        __qualifiedTableName = "MR_TEETH_EXAM";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>>(20);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>>(20);
        __idList.add($teethPk);
        __list.add($teethPk);
        __map.put("teethPk", $teethPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($examDoctorCd);
        __map.put("examDoctorCd", $examDoctorCd);
        __list.add($examDate);
        __map.put("examDate", $examDate);
        __list.add($bop);
        __map.put("bop", $bop);
        __list.add($diDesc);
        __map.put("diDesc", $diDesc);
        __list.add($othDesc);
        __map.put("othDesc", $othDesc);
        __list.add($treatDesign);
        __map.put("treatDesign", $treatDesign);
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
    public void preInsert(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam newEntity() {
        return new pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam();
    }

    @Override
    public pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam();
    }

    @Override
    public Class<pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam> getEntityClass() {
        return pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam.class;
    }

    @Override
    public pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam getOriginalStates(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MrTeethExam getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MrTeethExam newInstance() {
        return new _MrTeethExam();
    }

}
