package ei.ass.di.auto.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.776+0800")
public final class _MzPatientDiagnosisEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.ass.di.auto.po.MzPatientDiagnosisEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MzPatientDiagnosisEntity __singleton = new _MzPatientDiagnosisEntity();

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the sn */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.Integer, java.lang.Object> $sn = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.Integer, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "sn", "sn", __idGenerator);

    /** the patientId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $patientId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientId", "patient_id", true, true);

    /** the times */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.Short, java.lang.Object> $times = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.Short, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "times", "times", true, true);

    /** the doctorSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $doctorSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "doctorSn", "doctor_sn", true, true);

    /** the deptSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $deptSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptSn", "dept_sn", true, true);

    /** the diagStr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $diagStr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diagStr", "diag_str", true, true);

    /** the diagCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $diagCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diagCode", "diag_code", true, true);

    /** the icdCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $icdCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "icdCode", "icd_code", true, true);

    /** the commentStr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $commentStr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "commentStr", "comment_str", true, true);

    /** the mainFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $mainFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mainFlag", "main_flag", true, true);

    /** the uncertainFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $uncertainFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "uncertainFlag", "uncertain_flag", true, true);

    /** the suspectedFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $suspectedFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "suspectedFlag", "suspected_flag", true, true);

    /** the contagionFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $contagionFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "contagionFlag", "contagion_flag", true, true);

    /** the lv1sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $lv1sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lv1sortNo", "lvl1_sort_no", true, true);

    /** the lv2sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $lv2sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lv2sortNo", "lvl2_sort_no", true, true);

    /** the inputDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.sql.Timestamp, java.lang.Object> $inputDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.sql.Timestamp, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "inputDate", "input_date", true, true);

    /** the symptom */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object> $symptom = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, java.lang.String, java.lang.Object>(ei.ass.di.auto.po.MzPatientDiagnosisEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "symptom", "symptom", true, true);

    private final ei.ass.di.auto.po.MzPatientDiagnosisEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>> __entityPropertyTypeMap;

    private _MzPatientDiagnosisEntity() {
        __listener = new ei.ass.di.auto.po.MzPatientDiagnosisEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MzPatientDiagnosisEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "mz_patient_diagnosis";
        __qualifiedTableName = "mz_patient_diagnosis";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>>(17);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>>(17);
        __idList.add($sn);
        __list.add($sn);
        __map.put("sn", $sn);
        __list.add($patientId);
        __map.put("patientId", $patientId);
        __list.add($times);
        __map.put("times", $times);
        __list.add($doctorSn);
        __map.put("doctorSn", $doctorSn);
        __list.add($deptSn);
        __map.put("deptSn", $deptSn);
        __list.add($diagStr);
        __map.put("diagStr", $diagStr);
        __list.add($diagCode);
        __map.put("diagCode", $diagCode);
        __list.add($icdCode);
        __map.put("icdCode", $icdCode);
        __list.add($commentStr);
        __map.put("commentStr", $commentStr);
        __list.add($mainFlag);
        __map.put("mainFlag", $mainFlag);
        __list.add($uncertainFlag);
        __map.put("uncertainFlag", $uncertainFlag);
        __list.add($suspectedFlag);
        __map.put("suspectedFlag", $suspectedFlag);
        __list.add($contagionFlag);
        __map.put("contagionFlag", $contagionFlag);
        __list.add($lv1sortNo);
        __map.put("lv1sortNo", $lv1sortNo);
        __list.add($lv2sortNo);
        __map.put("lv2sortNo", $lv2sortNo);
        __list.add($inputDate);
        __map.put("inputDate", $inputDate);
        __list.add($symptom);
        __map.put("symptom", $symptom);
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
    public void preInsert(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.ass.di.auto.po.MzPatientDiagnosisEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.ass.di.auto.po.MzPatientDiagnosisEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.ass.di.auto.po.MzPatientDiagnosisEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.ass.di.auto.po.MzPatientDiagnosisEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.ass.di.auto.po.MzPatientDiagnosisEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.ass.di.auto.po.MzPatientDiagnosisEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.ass.di.auto.po.MzPatientDiagnosisEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?, ?> getGeneratedIdPropertyType() {
        return $sn;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.ass.di.auto.po.MzPatientDiagnosisEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.ass.di.auto.po.MzPatientDiagnosisEntity newEntity() {
        return new ei.ass.di.auto.po.MzPatientDiagnosisEntity();
    }

    @Override
    public ei.ass.di.auto.po.MzPatientDiagnosisEntity newEntity(java.util.Map<String, Object> __args) {
        return new ei.ass.di.auto.po.MzPatientDiagnosisEntity();
    }

    @Override
    public Class<ei.ass.di.auto.po.MzPatientDiagnosisEntity> getEntityClass() {
        return ei.ass.di.auto.po.MzPatientDiagnosisEntity.class;
    }

    @Override
    public ei.ass.di.auto.po.MzPatientDiagnosisEntity getOriginalStates(ei.ass.di.auto.po.MzPatientDiagnosisEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.ass.di.auto.po.MzPatientDiagnosisEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MzPatientDiagnosisEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MzPatientDiagnosisEntity newInstance() {
        return new _MzPatientDiagnosisEntity();
    }

}
