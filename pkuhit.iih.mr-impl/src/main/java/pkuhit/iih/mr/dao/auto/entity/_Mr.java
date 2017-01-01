package pkuhit.iih.mr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.275+0800")
public final class _Mr extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.dao.auto.entity.Mr> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _Mr __singleton = new _Mr();

    /** the mrPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $mrPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrPk", "MR_PK");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the mrTplCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $mrTplCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTplCd", "MR_TPL_CD", true, true);

    /** the filePk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $filePk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "filePk", "FILE_PK", true, true);

    /** the caFilePk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $caFilePk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "caFilePk", "CA_FILE_PK", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the mrTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $mrTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTpCd", "MR_TP_CD", true, true);

    /** the encounterSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $encounterSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "encounterSn", "ENCOUNTER_SN", true, true);

    /** the mrStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $mrStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrStaCd", "MR_STA_CD", true, true);

    /** the mrQaStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $mrQaStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrQaStaCd", "MR_QA_STA_CD", true, true);

    /** the completedF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Short, java.lang.Object> $completedF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "completedF", "COMPLETED_F", true, true);

    /** the signLvlCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $signLvlCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "signLvlCd", "SIGN_LVL_CD", true, true);

    /** the bizTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object> $bizTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "bizTime", "BIZ_TIME", true, true);

    /** the supDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $supDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "supDctId", "SUP_DCT_ID", true, true);

    /** the submitCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $submitCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "submitCd", "SUBMIT_CD", true, true);

    /** the lgcSmtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object> $lgcSmtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lgcSmtTime", "LGC_SMT_TIME", true, true);

    /** the submitDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object> $submitDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "submitDate", "SUBMIT_DATE", true, true);

    /** the deptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $deptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptCd", "DEPT_CD", true, true);

    /** the treatDoctorCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $treatDoctorCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "treatDoctorCd", "TREAT_DOCTOR_CD", true, true);

    /** the mastDoctorCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $mastDoctorCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mastDoctorCd", "MAST_DOCTOR_CD", true, true);

    /** the mastDoctorDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object> $mastDoctorDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "mastDoctorDate", "MAST_DOCTOR_DATE", true, true);

    /** the dirDoctorCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $dirDoctorCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dirDoctorCd", "DIR_DOCTOR_CD", true, true);

    /** the dirDoctorDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object> $dirDoctorDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "dirDoctorDate", "DIR_DOCTOR_DATE", true, true);

    /** the mrSource */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $mrSource = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrSource", "MR_SOURCE", true, true);

    /** the arcTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object> $arcTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "arcTime", "ARC_TIME", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT");

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the arcF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Short, java.lang.Object> $arcF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "arcF", "ARC_F", true, true);

    /** the xmlFilePk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $xmlFilePk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "xmlFilePk", "XML_FILE_PK", true, true);

    /** the txtFilePk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $txtFilePk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "txtFilePk", "TXT_FILE_PK", true, true);

    /** the printCount */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Integer, java.lang.Object> $printCount = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Integer, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "printCount", "PRINT_COUNT", true, true);

    /** the xmlCvetF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Integer, java.lang.Object> $xmlCvetF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.Integer, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "xmlCvetF", "XML_CVET_F", true, true);

    /** the splFmPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $splFmPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "splFmPk", "SPL_FM_PK", true, true);

    /** the upDocCheckSubmit */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object> $upDocCheckSubmit = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.Mr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "upDocCheckSubmit", "UP_DOC_CHECK_SUBMIT", true, true);

    private final pkuhit.iih.mr.dao.auto.entity.MrListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>> __entityPropertyTypeMap;

    private _Mr() {
        __listener = new pkuhit.iih.mr.dao.auto.entity.MrListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "Mr";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MR";
        __qualifiedTableName = "MR";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>>(44);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>>(44);
        __idList.add($mrPk);
        __list.add($mrPk);
        __map.put("mrPk", $mrPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($mrTplCd);
        __map.put("mrTplCd", $mrTplCd);
        __list.add($filePk);
        __map.put("filePk", $filePk);
        __list.add($caFilePk);
        __map.put("caFilePk", $caFilePk);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($mrTpCd);
        __map.put("mrTpCd", $mrTpCd);
        __list.add($encounterSn);
        __map.put("encounterSn", $encounterSn);
        __list.add($mrStaCd);
        __map.put("mrStaCd", $mrStaCd);
        __list.add($mrQaStaCd);
        __map.put("mrQaStaCd", $mrQaStaCd);
        __list.add($completedF);
        __map.put("completedF", $completedF);
        __list.add($signLvlCd);
        __map.put("signLvlCd", $signLvlCd);
        __list.add($bizTime);
        __map.put("bizTime", $bizTime);
        __list.add($supDctId);
        __map.put("supDctId", $supDctId);
        __list.add($submitCd);
        __map.put("submitCd", $submitCd);
        __list.add($lgcSmtTime);
        __map.put("lgcSmtTime", $lgcSmtTime);
        __list.add($submitDate);
        __map.put("submitDate", $submitDate);
        __list.add($deptCd);
        __map.put("deptCd", $deptCd);
        __list.add($treatDoctorCd);
        __map.put("treatDoctorCd", $treatDoctorCd);
        __list.add($mastDoctorCd);
        __map.put("mastDoctorCd", $mastDoctorCd);
        __list.add($mastDoctorDate);
        __map.put("mastDoctorDate", $mastDoctorDate);
        __list.add($dirDoctorCd);
        __map.put("dirDoctorCd", $dirDoctorCd);
        __list.add($dirDoctorDate);
        __map.put("dirDoctorDate", $dirDoctorDate);
        __list.add($mrSource);
        __map.put("mrSource", $mrSource);
        __list.add($arcTime);
        __map.put("arcTime", $arcTime);
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
        __list.add($arcF);
        __map.put("arcF", $arcF);
        __list.add($xmlFilePk);
        __map.put("xmlFilePk", $xmlFilePk);
        __list.add($txtFilePk);
        __map.put("txtFilePk", $txtFilePk);
        __list.add($printCount);
        __map.put("printCount", $printCount);
        __list.add($xmlCvetF);
        __map.put("xmlCvetF", $xmlCvetF);
        __list.add($splFmPk);
        __map.put("splFmPk", $splFmPk);
        __list.add($upDocCheckSubmit);
        __map.put("upDocCheckSubmit", $upDocCheckSubmit);
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
    public void preInsert(pkuhit.iih.mr.dao.auto.entity.Mr entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.dao.auto.entity.Mr> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.dao.auto.entity.Mr entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.dao.auto.entity.Mr> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.dao.auto.entity.Mr entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.dao.auto.entity.Mr> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.dao.auto.entity.Mr entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.dao.auto.entity.Mr> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.dao.auto.entity.Mr entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.dao.auto.entity.Mr> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.dao.auto.entity.Mr entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.dao.auto.entity.Mr> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.Mr, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.Mr, ?, ?> getVersionPropertyType() {
        return $updCnt;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.Mr newEntity() {
        return new pkuhit.iih.mr.dao.auto.entity.Mr();
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.Mr newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.dao.auto.entity.Mr();
    }

    @Override
    public Class<pkuhit.iih.mr.dao.auto.entity.Mr> getEntityClass() {
        return pkuhit.iih.mr.dao.auto.entity.Mr.class;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.Mr getOriginalStates(pkuhit.iih.mr.dao.auto.entity.Mr __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.dao.auto.entity.Mr __entity) {
    }

    /**
     * @return the singleton
     */
    public static _Mr getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _Mr newInstance() {
        return new _Mr();
    }

}
