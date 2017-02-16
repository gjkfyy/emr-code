package pkuhit.xap.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-02-16T21:21:02.420+0800")
public final class _IemrPatient extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.xap.dao.auto.entity.IemrPatient> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _IemrPatient __singleton = new _IemrPatient();

    /** the patientId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $patientId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientId", "PATIENT_ID");

    /** the patientName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $patientName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientName", "PATIENT_NAME", true, true);

    /** the inpatientNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $inpatientNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "inpatientNo", "INPATIENT_NO", true, true);

    /** the xpianNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $xpianNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "xpianNo", "XPIAN_NO", true, true);

    /** the sex */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $sex = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sex", "SEX", true, true);

    /** the parentName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $parentName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "parentName", "PARENT_NAME", true, true);

    /** the age */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $age = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "age", "AGE", true, true);

    /** the nation */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $nation = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nation", "NATION", true, true);

    /** the parity */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $parity = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "parity", "PARITY", true, true);

    /** the marriage */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $marriage = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "marriage", "MARRIAGE", true, true);

    /** the admissionDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.sql.Timestamp, java.lang.Object> $admissionDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "admissionDate", "ADMISSION_DATE", true, true);

    /** the occupation */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $occupation = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "occupation", "OCCUPATION", true, true);

    /** the education */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $education = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "education", "EDUCATION", true, true);

    /** the onsetAge */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $onsetAge = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "onsetAge", "ONSET_AGE", true, true);

    /** the familyHistory */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $familyHistory = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "familyHistory", "FAMILY_HISTORY", true, true);

    /** the pathogeny */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $pathogeny = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "pathogeny", "PATHOGENY", true, true);

    /** the provider */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $provider = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "provider", "PROVIDER", true, true);

    /** the medicalHistory */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $medicalHistory = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "medicalHistory", "MEDICAL_HISTORY", true, true);

    /** the treatmentHistory */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $treatmentHistory = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "treatmentHistory", "TREATMENT_HISTORY", true, true);

    /** the lumbarSurgeryHistory */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $lumbarSurgeryHistory = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lumbarSurgeryHistory", "LUMBAR_SURGERY_HISTORY", true, true);

    /** the orthopedicSurgeryHistory */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $orthopedicSurgeryHistory = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orthopedicSurgeryHistory", "ORTHOPEDIC_SURGERY_HISTORY", true, true);

    /** the adress */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $adress = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "adress", "ADRESS", true, true);

    /** the tel */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $tel = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "tel", "TEL", true, true);

    /** the otherContact */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $otherContact = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "otherContact", "OTHER_CONTACT", true, true);

    /** the physicalExam */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $physicalExam = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "physicalExam", "PHYSICAL_EXAM", true, true);

    /** the growth */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $growth = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "growth", "GROWTH", true, true);

    /** the nutrition */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $nutrition = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nutrition", "NUTRITION", true, true);

    /** the height */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $height = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "height", "HEIGHT", true, true);

    /** the weight */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $weight = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "weight", "WEIGHT", true, true);

    /** the specialityExam */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $specialityExam = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "specialityExam", "SPECIALITY_EXAM", true, true);

    /** the isPic */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $isPic = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "isPic", "IS_PIC", true, true);

    /** the isVideo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $isVideo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "isVideo", "IS_VIDEO", true, true);

    /** the otherDiseasesHistory */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $otherDiseasesHistory = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "otherDiseasesHistory", "OTHER_DISEASES_HISTORY", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.math.BigInteger, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, java.lang.Short, java.lang.Object>(pkuhit.xap.dao.auto.entity.IemrPatient.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.xap.dao.auto.entity.IemrPatientListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>> __entityPropertyTypeMap;

    private _IemrPatient() {
        __listener = new pkuhit.xap.dao.auto.entity.IemrPatientListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "IemrPatient";
        __catalogName = "";
        __schemaName = "";
        __tableName = "IEMR_PATIENT";
        __qualifiedTableName = "IEMR_PATIENT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>>(41);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>>(41);
        __idList.add($patientId);
        __list.add($patientId);
        __map.put("patientId", $patientId);
        __list.add($patientName);
        __map.put("patientName", $patientName);
        __list.add($inpatientNo);
        __map.put("inpatientNo", $inpatientNo);
        __list.add($xpianNo);
        __map.put("xpianNo", $xpianNo);
        __list.add($sex);
        __map.put("sex", $sex);
        __list.add($parentName);
        __map.put("parentName", $parentName);
        __list.add($age);
        __map.put("age", $age);
        __list.add($nation);
        __map.put("nation", $nation);
        __list.add($parity);
        __map.put("parity", $parity);
        __list.add($marriage);
        __map.put("marriage", $marriage);
        __list.add($admissionDate);
        __map.put("admissionDate", $admissionDate);
        __list.add($occupation);
        __map.put("occupation", $occupation);
        __list.add($education);
        __map.put("education", $education);
        __list.add($onsetAge);
        __map.put("onsetAge", $onsetAge);
        __list.add($familyHistory);
        __map.put("familyHistory", $familyHistory);
        __list.add($pathogeny);
        __map.put("pathogeny", $pathogeny);
        __list.add($provider);
        __map.put("provider", $provider);
        __list.add($medicalHistory);
        __map.put("medicalHistory", $medicalHistory);
        __list.add($treatmentHistory);
        __map.put("treatmentHistory", $treatmentHistory);
        __list.add($lumbarSurgeryHistory);
        __map.put("lumbarSurgeryHistory", $lumbarSurgeryHistory);
        __list.add($orthopedicSurgeryHistory);
        __map.put("orthopedicSurgeryHistory", $orthopedicSurgeryHistory);
        __list.add($adress);
        __map.put("adress", $adress);
        __list.add($tel);
        __map.put("tel", $tel);
        __list.add($otherContact);
        __map.put("otherContact", $otherContact);
        __list.add($physicalExam);
        __map.put("physicalExam", $physicalExam);
        __list.add($growth);
        __map.put("growth", $growth);
        __list.add($nutrition);
        __map.put("nutrition", $nutrition);
        __list.add($height);
        __map.put("height", $height);
        __list.add($weight);
        __map.put("weight", $weight);
        __list.add($specialityExam);
        __map.put("specialityExam", $specialityExam);
        __list.add($isPic);
        __map.put("isPic", $isPic);
        __list.add($isVideo);
        __map.put("isVideo", $isVideo);
        __list.add($otherDiseasesHistory);
        __map.put("otherDiseasesHistory", $otherDiseasesHistory);
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
    public void preInsert(pkuhit.xap.dao.auto.entity.IemrPatient entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.xap.dao.auto.entity.IemrPatient> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.xap.dao.auto.entity.IemrPatient entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.xap.dao.auto.entity.IemrPatient> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.xap.dao.auto.entity.IemrPatient entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.xap.dao.auto.entity.IemrPatient> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.xap.dao.auto.entity.IemrPatient entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.xap.dao.auto.entity.IemrPatient> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.xap.dao.auto.entity.IemrPatient entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.xap.dao.auto.entity.IemrPatient> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.xap.dao.auto.entity.IemrPatient entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.xap.dao.auto.entity.IemrPatient> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.IemrPatient, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.IemrPatient, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.IemrPatient newEntity() {
        return new pkuhit.xap.dao.auto.entity.IemrPatient();
    }

    @Override
    public pkuhit.xap.dao.auto.entity.IemrPatient newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.xap.dao.auto.entity.IemrPatient();
    }

    @Override
    public Class<pkuhit.xap.dao.auto.entity.IemrPatient> getEntityClass() {
        return pkuhit.xap.dao.auto.entity.IemrPatient.class;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.IemrPatient getOriginalStates(pkuhit.xap.dao.auto.entity.IemrPatient __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.xap.dao.auto.entity.IemrPatient __entity) {
    }

    /**
     * @return the singleton
     */
    public static _IemrPatient getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _IemrPatient newInstance() {
        return new _IemrPatient();
    }

}
