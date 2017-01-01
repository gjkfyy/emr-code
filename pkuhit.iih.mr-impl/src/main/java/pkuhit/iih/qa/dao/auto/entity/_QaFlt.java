package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.212+0800")
public final class _QaFlt extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.QaFlt> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _QaFlt __singleton = new _QaFlt();

    /** the qaFltPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $qaFltPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaFltPk", "QA_FLT_PK");

    /** the qaItmCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $qaItmCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaItmCd", "QA_ITM_CD", true, true);

    /** the qaTyCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $qaTyCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaTyCd", "QA_TY_CD", true, true);

    /** the fltStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $fltStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fltStaCd", "FLT_STA_CD", true, true);

    /** the revisionCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $revisionCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "revisionCd", "REVISION_CD", true, true);

    /** the sbmtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object> $sbmtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "sbmtTime", "SBMT_TIME", true, true);

    /** the sbmtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $sbmtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sbmtUserId", "SBMT_USER_ID", true, true);

    /** the sbmtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $sbmtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sbmtDeptCd", "SBMT_DEPT_CD", true, true);

    /** the rfmReq */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $rfmReq = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rfmReq", "RFM_REQ", true, true);

    /** the rfmTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object> $rfmTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "rfmTime", "RFM_TIME", true, true);

    /** the rfmUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $rfmUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rfmUserId", "RFM_USER_ID", true, true);

    /** the rfmDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $rfmDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rfmDeptCd", "RFM_DEPT_CD", true, true);

    /** the rfmDes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $rfmDes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rfmDes", "RFM_DES", true, true);

    /** the vrfTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object> $vrfTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "vrfTime", "VRF_TIME", true, true);

    /** the vrfUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $vrfUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "vrfUserId", "VRF_USER_ID", true, true);

    /** the vrfDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $vrfDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "vrfDeptCd", "VRF_DEPT_CD", true, true);

    /** the drpDes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $drpDes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "drpDes", "DRP_DES", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.Short, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the mrPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object> $mrPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrPk", "MR_PK", true, true);

    /** the deductScrTimes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.Integer, java.lang.Object> $deductScrTimes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, java.lang.Integer, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaFlt.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "deductScrTimes", "DEDUCT_SCR_TIMES", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.QaFltListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>> __entityPropertyTypeMap;

    private _QaFlt() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.QaFltListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "QaFlt";
        __catalogName = "";
        __schemaName = "";
        __tableName = "QA_FLT";
        __qualifiedTableName = "QA_FLT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>>(32);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>>(32);
        __idList.add($qaFltPk);
        __list.add($qaFltPk);
        __map.put("qaFltPk", $qaFltPk);
        __list.add($qaItmCd);
        __map.put("qaItmCd", $qaItmCd);
        __list.add($qaTyCd);
        __map.put("qaTyCd", $qaTyCd);
        __list.add($fltStaCd);
        __map.put("fltStaCd", $fltStaCd);
        __list.add($revisionCd);
        __map.put("revisionCd", $revisionCd);
        __list.add($sbmtTime);
        __map.put("sbmtTime", $sbmtTime);
        __list.add($sbmtUserId);
        __map.put("sbmtUserId", $sbmtUserId);
        __list.add($sbmtDeptCd);
        __map.put("sbmtDeptCd", $sbmtDeptCd);
        __list.add($rfmReq);
        __map.put("rfmReq", $rfmReq);
        __list.add($rfmTime);
        __map.put("rfmTime", $rfmTime);
        __list.add($rfmUserId);
        __map.put("rfmUserId", $rfmUserId);
        __list.add($rfmDeptCd);
        __map.put("rfmDeptCd", $rfmDeptCd);
        __list.add($rfmDes);
        __map.put("rfmDes", $rfmDes);
        __list.add($vrfTime);
        __map.put("vrfTime", $vrfTime);
        __list.add($vrfUserId);
        __map.put("vrfUserId", $vrfUserId);
        __list.add($vrfDeptCd);
        __map.put("vrfDeptCd", $vrfDeptCd);
        __list.add($drpDes);
        __map.put("drpDes", $drpDes);
        __list.add($enPk);
        __map.put("enPk", $enPk);
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
        __list.add($mrPk);
        __map.put("mrPk", $mrPk);
        __list.add($deductScrTimes);
        __map.put("deductScrTimes", $deductScrTimes);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.QaFlt entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.QaFlt> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.QaFlt entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaFlt> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.QaFlt entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaFlt> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.QaFlt entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.QaFlt> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.QaFlt entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaFlt> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.QaFlt entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaFlt> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaFlt, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaFlt, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaFlt newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.QaFlt();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaFlt newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.QaFlt();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.QaFlt> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.QaFlt.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaFlt getOriginalStates(pkuhit.iih.qa.dao.auto.entity.QaFlt __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.QaFlt __entity) {
    }

    /**
     * @return the singleton
     */
    public static _QaFlt getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _QaFlt newInstance() {
        return new _QaFlt();
    }

}
