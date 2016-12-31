package ei.pa.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.769+0800")
public final class _PatientInfoForXMLPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.pa.po.PatientInfoForXMLPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _PatientInfoForXMLPo __singleton = new _PatientInfoForXMLPo();

    /** the hospitalCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $hospitalCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "hospitalCode", "hospitalCode", true, true);

    /** the hospitalName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $hospitalName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "hospitalName", "hospitalName", true, true);

    /** the roomNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $roomNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "roomNo", "roomNo", true, true);

    /** the age */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $age = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "age", "age", true, true);

    /** the patientId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $patientId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientId", "patientId", true, true);

    /** the legalName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $legalName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "legalName", "legalName", true, true);

    /** the socialNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $socialNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "socialNo", "socialNo", true, true);

    /** the gender */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $gender = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "gender", "gender", true, true);

    /** the genderTxt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $genderTxt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "genderTxt", "genderTxt", true, true);

    /** the maritalStatusCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $maritalStatusCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "maritalStatusCode", "maritalStatusCode", true, true);

    /** the maritalTxt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $maritalTxt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "maritalTxt", "maritalTxt", true, true);

    /** the birthTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $birthTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "birthTime", "birthTime", true, true);

    /** the bloodType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $bloodType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "bloodType", "bloodType", true, true);

    /** the raceCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $raceCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "raceCode", "raceCode", true, true);

    /** the raceName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $raceName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "raceName", "raceName", true, true);

    /** the citizenCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $citizenCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "citizenCode", "citizenCode", true, true);

    /** the citizenName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $citizenName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "citizenName", "citizenName", true, true);

    /** the birthPlace */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $birthPlace = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "birthPlace", "birthPlace", true, true);

    /** the birthPlaceName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $birthPlaceName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "birthPlaceName", "birthPlaceName", true, true);

    /** the occupationCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $occupationCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "occupationCode", "occupationCode", true, true);

    /** the occupationName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $occupationName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "occupationName", "occupationName", true, true);

    /** the patientAddress */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $patientAddress = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientAddress", "patientAddress", true, true);

    /** the address */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $address = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "address", "address", true, true);

    /** the telAddr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $telAddr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "telAddr", "telAddr", true, true);

    /** the relationName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $relationName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "relationName", "relationName", true, true);

    /** the relationCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $relationCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "relationCode", "relationCode", true, true);

    /** the relationCodeNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $relationCodeNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "relationCodeNm", "relationCodeNm", true, true);

    /** the responseType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $responseType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "responseType", "responseType", true, true);

    /** the responseName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $responseName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "responseName", "responseName", true, true);

    /** the encType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $encType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "encType", "encType", true, true);

    /** the patientNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $patientNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientNo", "patientNo", true, true);

    /** the encId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $encId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "encId", "encId", true, true);

    /** the effectiveB */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $effectiveB = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "effectiveB", "effectiveB", true, true);

    /** the admissionResponsibleParty */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $admissionResponsibleParty = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "admissionResponsibleParty", "admissionResponsibleParty", true, true);

    /** the admissWard */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $admissWard = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "admissWard", "admissWard", true, true);

    /** the admitter */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $admitter = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "admitter", "admitter", true, true);

    /** the activityB */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $activityB = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "activityB", "activityB", true, true);

    /** the ryzd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $ryzd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ryzd", "ryzd", true, true);

    /** the ryzdmc */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $ryzdmc = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ryzdmc", "ryzdmc", true, true);

    /** the orgId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $orgId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgId", "orgId", true, true);

    /** the orgName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $orgName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgName", "orgName", true, true);

    /** the wardCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $wardCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wardCode", "wardCode", true, true);

    /** the ward */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $ward = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ward", "ward", true, true);

    /** the bed */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $bed = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "bed", "bed", true, true);

    /** the attender */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $attender = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "attender", "attender", true, true);

    /** the nurser */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $nurser = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nurser", "nurser", true, true);

    /** the deptDirector */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $deptDirector = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptDirector", "deptDirector", true, true);

    /** the activityE */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $activityE = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "activityE", "activityE", true, true);

    /** the effectiveE */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $effectiveE = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "effectiveE", "effectiveE", true, true);

    /** the dischargeResponsibleParty */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $dischargeResponsibleParty = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dischargeResponsibleParty", "dischargeResponsibleParty", true, true);

    /** the disWard */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $disWard = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "disWard", "disWard", true, true);

    /** the discharger */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $discharger = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "discharger", "discharger", true, true);

    /** the cyzd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $cyzd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "cyzd", "cyzd", true, true);

    /** the cyzdmc */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $cyzdmc = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "cyzdmc", "cyzdmc", true, true);

    /** the inVisitTimes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $inVisitTimes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "inVisitTimes", "inVisitTimes", true, true);

    /** the nurseLevel */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $nurseLevel = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nurseLevel", "nurseLevel", true, true);

    /** the nurseLevelName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object> $nurseLevelName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, java.lang.String, java.lang.Object>(ei.pa.po.PatientInfoForXMLPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nurseLevelName", "nurseLevelName", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<ei.pa.po.PatientInfoForXMLPo> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>> __entityPropertyTypeMap;

    private _PatientInfoForXMLPo() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<ei.pa.po.PatientInfoForXMLPo>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "PatientInfoForXMLPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "PatientInfoForXMLPo";
        __qualifiedTableName = "PatientInfoForXMLPo";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>>(57);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>>(57);
        __list.add($hospitalCode);
        __map.put("hospitalCode", $hospitalCode);
        __list.add($hospitalName);
        __map.put("hospitalName", $hospitalName);
        __list.add($roomNo);
        __map.put("roomNo", $roomNo);
        __list.add($age);
        __map.put("age", $age);
        __list.add($patientId);
        __map.put("patientId", $patientId);
        __list.add($legalName);
        __map.put("legalName", $legalName);
        __list.add($socialNo);
        __map.put("socialNo", $socialNo);
        __list.add($gender);
        __map.put("gender", $gender);
        __list.add($genderTxt);
        __map.put("genderTxt", $genderTxt);
        __list.add($maritalStatusCode);
        __map.put("maritalStatusCode", $maritalStatusCode);
        __list.add($maritalTxt);
        __map.put("maritalTxt", $maritalTxt);
        __list.add($birthTime);
        __map.put("birthTime", $birthTime);
        __list.add($bloodType);
        __map.put("bloodType", $bloodType);
        __list.add($raceCode);
        __map.put("raceCode", $raceCode);
        __list.add($raceName);
        __map.put("raceName", $raceName);
        __list.add($citizenCode);
        __map.put("citizenCode", $citizenCode);
        __list.add($citizenName);
        __map.put("citizenName", $citizenName);
        __list.add($birthPlace);
        __map.put("birthPlace", $birthPlace);
        __list.add($birthPlaceName);
        __map.put("birthPlaceName", $birthPlaceName);
        __list.add($occupationCode);
        __map.put("occupationCode", $occupationCode);
        __list.add($occupationName);
        __map.put("occupationName", $occupationName);
        __list.add($patientAddress);
        __map.put("patientAddress", $patientAddress);
        __list.add($address);
        __map.put("address", $address);
        __list.add($telAddr);
        __map.put("telAddr", $telAddr);
        __list.add($relationName);
        __map.put("relationName", $relationName);
        __list.add($relationCode);
        __map.put("relationCode", $relationCode);
        __list.add($relationCodeNm);
        __map.put("relationCodeNm", $relationCodeNm);
        __list.add($responseType);
        __map.put("responseType", $responseType);
        __list.add($responseName);
        __map.put("responseName", $responseName);
        __list.add($encType);
        __map.put("encType", $encType);
        __list.add($patientNo);
        __map.put("patientNo", $patientNo);
        __list.add($encId);
        __map.put("encId", $encId);
        __list.add($effectiveB);
        __map.put("effectiveB", $effectiveB);
        __list.add($admissionResponsibleParty);
        __map.put("admissionResponsibleParty", $admissionResponsibleParty);
        __list.add($admissWard);
        __map.put("admissWard", $admissWard);
        __list.add($admitter);
        __map.put("admitter", $admitter);
        __list.add($activityB);
        __map.put("activityB", $activityB);
        __list.add($ryzd);
        __map.put("ryzd", $ryzd);
        __list.add($ryzdmc);
        __map.put("ryzdmc", $ryzdmc);
        __list.add($orgId);
        __map.put("orgId", $orgId);
        __list.add($orgName);
        __map.put("orgName", $orgName);
        __list.add($wardCode);
        __map.put("wardCode", $wardCode);
        __list.add($ward);
        __map.put("ward", $ward);
        __list.add($bed);
        __map.put("bed", $bed);
        __list.add($attender);
        __map.put("attender", $attender);
        __list.add($nurser);
        __map.put("nurser", $nurser);
        __list.add($deptDirector);
        __map.put("deptDirector", $deptDirector);
        __list.add($activityE);
        __map.put("activityE", $activityE);
        __list.add($effectiveE);
        __map.put("effectiveE", $effectiveE);
        __list.add($dischargeResponsibleParty);
        __map.put("dischargeResponsibleParty", $dischargeResponsibleParty);
        __list.add($disWard);
        __map.put("disWard", $disWard);
        __list.add($discharger);
        __map.put("discharger", $discharger);
        __list.add($cyzd);
        __map.put("cyzd", $cyzd);
        __list.add($cyzdmc);
        __map.put("cyzdmc", $cyzdmc);
        __list.add($inVisitTimes);
        __map.put("inVisitTimes", $inVisitTimes);
        __list.add($nurseLevel);
        __map.put("nurseLevel", $nurseLevel);
        __list.add($nurseLevelName);
        __map.put("nurseLevelName", $nurseLevelName);
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
    public void preInsert(ei.pa.po.PatientInfoForXMLPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.pa.po.PatientInfoForXMLPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.pa.po.PatientInfoForXMLPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.pa.po.PatientInfoForXMLPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.pa.po.PatientInfoForXMLPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.pa.po.PatientInfoForXMLPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.pa.po.PatientInfoForXMLPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.pa.po.PatientInfoForXMLPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.pa.po.PatientInfoForXMLPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.pa.po.PatientInfoForXMLPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.pa.po.PatientInfoForXMLPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.pa.po.PatientInfoForXMLPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.pa.po.PatientInfoForXMLPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.pa.po.PatientInfoForXMLPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.pa.po.PatientInfoForXMLPo newEntity() {
        return new ei.pa.po.PatientInfoForXMLPo();
    }

    @Override
    public ei.pa.po.PatientInfoForXMLPo newEntity(java.util.Map<String, Object> __args) {
        return new ei.pa.po.PatientInfoForXMLPo();
    }

    @Override
    public Class<ei.pa.po.PatientInfoForXMLPo> getEntityClass() {
        return ei.pa.po.PatientInfoForXMLPo.class;
    }

    @Override
    public ei.pa.po.PatientInfoForXMLPo getOriginalStates(ei.pa.po.PatientInfoForXMLPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.pa.po.PatientInfoForXMLPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _PatientInfoForXMLPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _PatientInfoForXMLPo newInstance() {
        return new _PatientInfoForXMLPo();
    }

}
