package pkuhit.org.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:53.253+0800")
public final class _EiNisWardConfig extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.org.dao.auto.entity.EiNisWardConfig> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _EiNisWardConfig __singleton = new _EiNisWardConfig();

    /** the nisWardCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $nisWardCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nisWardCd", "NIS_WARD_CD");

    /** the deptSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $deptSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptSn", "DEPT_SN", true, true);

    /** the wardSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $wardSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wardSn", "WARD_SN", true, true);

    /** the wardNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $wardNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wardNm", "WARD_NM", true, true);

    /** the orderStartTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $orderStartTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orderStartTime", "ORDER_START_TIME", true, true);

    /** the orderDays */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $orderDays = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orderDays", "ORDER_DAYS", true, true);

    /** the kfStartTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $kfStartTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "kfStartTime", "KF_START_TIME", true, true);

    /** the kfDays */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $kfDays = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "kfDays", "KF_DAYS", true, true);

    /** the fkfStartTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $fkfStartTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fkfStartTime", "FKF_START_TIME", true, true);

    /** the fkfDays */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $fkfDays = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fkfDays", "FKF_DAYS", true, true);

    /** the feeOrderSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $feeOrderSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "feeOrderSn", "FEE_ORDER_SN", true, true);

    /** the baseGroup */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $baseGroup = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "baseGroup", "BASE_GROUP", true, true);

    /** the wzGroupList */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $wzGroupList = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wzGroupList", "WZ_GROUP_LIST", true, true);

    /** the infusionFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $infusionFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "infusionFlag", "INFUSION_FLAG", true, true);

    /** the ipList */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $ipList = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ipList", "IP_LIST", true, true);

    /** the enableFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $enableFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enableFlag", "ENABLE_FLAG", true, true);

    /** the oweLimit */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $oweLimit = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "oweLimit", "OWE_LIMIT", true, true);

    /** the longOrderWidth */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.math.BigInteger, java.lang.Object> $longOrderWidth = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.math.BigInteger, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "longOrderWidth", "LONG_ORDER_WIDTH", true, true);

    /** the onceOrderWidth */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.math.BigInteger, java.lang.Object> $onceOrderWidth = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.math.BigInteger, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "onceOrderWidth", "ONCE_ORDER_WIDTH", true, true);

    /** the autoBuild */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $autoBuild = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "autoBuild", "AUTO_BUILD", true, true);

    /** the infusionFlag2 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $infusionFlag2 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "infusionFlag2", "INFUSION_FLAG2", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.math.BigInteger, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.sql.Timestamp, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.String, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, java.lang.Short, java.lang.Object>(pkuhit.org.dao.auto.entity.EiNisWardConfig.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.org.dao.auto.entity.EiNisWardConfigListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>> __entityPropertyTypeMap;

    private _EiNisWardConfig() {
        __listener = new pkuhit.org.dao.auto.entity.EiNisWardConfigListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "EiNisWardConfig";
        __catalogName = "";
        __schemaName = "";
        __tableName = "EI_NIS_WARD_CONFIG";
        __qualifiedTableName = "EI_NIS_WARD_CONFIG";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>>(33);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>>(33);
        __idList.add($nisWardCd);
        __list.add($nisWardCd);
        __map.put("nisWardCd", $nisWardCd);
        __list.add($deptSn);
        __map.put("deptSn", $deptSn);
        __list.add($wardSn);
        __map.put("wardSn", $wardSn);
        __list.add($wardNm);
        __map.put("wardNm", $wardNm);
        __list.add($orderStartTime);
        __map.put("orderStartTime", $orderStartTime);
        __list.add($orderDays);
        __map.put("orderDays", $orderDays);
        __list.add($kfStartTime);
        __map.put("kfStartTime", $kfStartTime);
        __list.add($kfDays);
        __map.put("kfDays", $kfDays);
        __list.add($fkfStartTime);
        __map.put("fkfStartTime", $fkfStartTime);
        __list.add($fkfDays);
        __map.put("fkfDays", $fkfDays);
        __list.add($feeOrderSn);
        __map.put("feeOrderSn", $feeOrderSn);
        __list.add($baseGroup);
        __map.put("baseGroup", $baseGroup);
        __list.add($wzGroupList);
        __map.put("wzGroupList", $wzGroupList);
        __list.add($infusionFlag);
        __map.put("infusionFlag", $infusionFlag);
        __list.add($ipList);
        __map.put("ipList", $ipList);
        __list.add($enableFlag);
        __map.put("enableFlag", $enableFlag);
        __list.add($oweLimit);
        __map.put("oweLimit", $oweLimit);
        __list.add($longOrderWidth);
        __map.put("longOrderWidth", $longOrderWidth);
        __list.add($onceOrderWidth);
        __map.put("onceOrderWidth", $onceOrderWidth);
        __list.add($autoBuild);
        __map.put("autoBuild", $autoBuild);
        __list.add($infusionFlag2);
        __map.put("infusionFlag2", $infusionFlag2);
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
    public void preInsert(pkuhit.org.dao.auto.entity.EiNisWardConfig entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.org.dao.auto.entity.EiNisWardConfig> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.org.dao.auto.entity.EiNisWardConfig entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.org.dao.auto.entity.EiNisWardConfig> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.org.dao.auto.entity.EiNisWardConfig entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.org.dao.auto.entity.EiNisWardConfig> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.org.dao.auto.entity.EiNisWardConfig entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.org.dao.auto.entity.EiNisWardConfig> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.org.dao.auto.entity.EiNisWardConfig entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.org.dao.auto.entity.EiNisWardConfig> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.org.dao.auto.entity.EiNisWardConfig entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.org.dao.auto.entity.EiNisWardConfig> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.org.dao.auto.entity.EiNisWardConfig, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.org.dao.auto.entity.EiNisWardConfig, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.org.dao.auto.entity.EiNisWardConfig newEntity() {
        return new pkuhit.org.dao.auto.entity.EiNisWardConfig();
    }

    @Override
    public pkuhit.org.dao.auto.entity.EiNisWardConfig newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.org.dao.auto.entity.EiNisWardConfig();
    }

    @Override
    public Class<pkuhit.org.dao.auto.entity.EiNisWardConfig> getEntityClass() {
        return pkuhit.org.dao.auto.entity.EiNisWardConfig.class;
    }

    @Override
    public pkuhit.org.dao.auto.entity.EiNisWardConfig getOriginalStates(pkuhit.org.dao.auto.entity.EiNisWardConfig __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.org.dao.auto.entity.EiNisWardConfig __entity) {
    }

    /**
     * @return the singleton
     */
    public static _EiNisWardConfig getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _EiNisWardConfig newInstance() {
        return new _EiNisWardConfig();
    }

}
