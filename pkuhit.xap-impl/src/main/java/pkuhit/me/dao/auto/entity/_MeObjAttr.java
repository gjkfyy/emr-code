package pkuhit.me.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.339+0800")
public final class _MeObjAttr extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.me.dao.auto.entity.MeObjAttr> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MeObjAttr __singleton = new _MeObjAttr();

    /** the objAttrCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $objAttrCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objAttrCd", "OBJ_ATTR_CD");

    /** the objCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $objCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "objCd", "OBJ_CD", true, true);

    /** the fkObjCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $fkObjCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fkObjCd", "FK_OBJ_CD", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "DES", true, true);

    /** the shtNmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $shtNmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "shtNmEn", "SHT_NM_EN", true, true);

    /** the nmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $nmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nmEn", "NM_EN", true, true);

    /** the dtTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $dtTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dtTpCd", "DT_TP_CD", true, true);

    /** the unitCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $unitCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "unitCd", "UNIT_CD", true, true);

    /** the len */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object> $len = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "len", "LEN", true, true);

    /** the prec */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object> $prec = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "prec", "PREC", true, true);

    /** the minVal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $minVal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "minVal", "MIN_VAL", true, true);

    /** the maxVal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $maxVal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "maxVal", "MAX_VAL", true, true);

    /** the dftVal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $dftVal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dftVal", "DFT_VAL", true, true);

    /** the alignCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $alignCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "alignCd", "ALIGN_CD", true, true);

    /** the nmCacheF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $nmCacheF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "nmCacheF", "NM_CACHE_F", true, true);

    /** the upperF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $upperF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "upperF", "UPPER_F", true, true);

    /** the lowerF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $lowerF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "lowerF", "LOWER_F", true, true);

    /** the pkF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $pkF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "pkF", "PK_F", true, true);

    /** the fkF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $fkF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "fkF", "FK_F", true, true);

    /** the nnF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $nnF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "nnF", "NN_F", true, true);

    /** the unF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $unF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "unF", "UN_F", true, true);

    /** the inF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $inF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "inF", "IN_F", true, true);

    /** the persF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $persF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "persF", "PERS_F", true, true);

    /** the secuF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $secuF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "secuF", "SECU_F", true, true);

    /** the staAuF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $staAuF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "staAuF", "STA_AU_F", true, true);

    /** the valiRule */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $valiRule = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "valiRule", "VALI_RULE", true, true);

    /** the shwFmt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $shwFmt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "shwFmt", "SHW_FMT", true, true);

    /** the editHight */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object> $editHight = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "editHight", "EDIT_HIGHT", true, true);

    /** the editWidth */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object> $editWidth = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "editWidth", "EDIT_WIDTH", true, true);

    /** the gridColWidth */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object> $gridColWidth = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "gridColWidth", "GRID_COL_WIDTH", true, true);

    /** the tipMsgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $tipMsgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "tipMsgCd", "TIP_MSG_CD", true, true);

    /** the mrUseF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $mrUseF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "mrUseF", "MR_USE_F", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.math.BigInteger, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.sql.Timestamp, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.String, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, java.lang.Short, java.lang.Object>(pkuhit.me.dao.auto.entity.MeObjAttr.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.me.dao.auto.entity.MeObjAttrListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>> __entityPropertyTypeMap;

    private _MeObjAttr() {
        __listener = new pkuhit.me.dao.auto.entity.MeObjAttrListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MeObjAttr";
        __catalogName = "";
        __schemaName = "";
        __tableName = "ME_OBJ_ATTR";
        __qualifiedTableName = "ME_OBJ_ATTR";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>>(45);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>>(45);
        __idList.add($objAttrCd);
        __list.add($objAttrCd);
        __map.put("objAttrCd", $objAttrCd);
        __list.add($objCd);
        __map.put("objCd", $objCd);
        __list.add($fkObjCd);
        __map.put("fkObjCd", $fkObjCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($des);
        __map.put("des", $des);
        __list.add($shtNmEn);
        __map.put("shtNmEn", $shtNmEn);
        __list.add($nmEn);
        __map.put("nmEn", $nmEn);
        __list.add($dtTpCd);
        __map.put("dtTpCd", $dtTpCd);
        __list.add($unitCd);
        __map.put("unitCd", $unitCd);
        __list.add($len);
        __map.put("len", $len);
        __list.add($prec);
        __map.put("prec", $prec);
        __list.add($minVal);
        __map.put("minVal", $minVal);
        __list.add($maxVal);
        __map.put("maxVal", $maxVal);
        __list.add($dftVal);
        __map.put("dftVal", $dftVal);
        __list.add($alignCd);
        __map.put("alignCd", $alignCd);
        __list.add($nmCacheF);
        __map.put("nmCacheF", $nmCacheF);
        __list.add($upperF);
        __map.put("upperF", $upperF);
        __list.add($lowerF);
        __map.put("lowerF", $lowerF);
        __list.add($pkF);
        __map.put("pkF", $pkF);
        __list.add($fkF);
        __map.put("fkF", $fkF);
        __list.add($nnF);
        __map.put("nnF", $nnF);
        __list.add($unF);
        __map.put("unF", $unF);
        __list.add($inF);
        __map.put("inF", $inF);
        __list.add($persF);
        __map.put("persF", $persF);
        __list.add($secuF);
        __map.put("secuF", $secuF);
        __list.add($staAuF);
        __map.put("staAuF", $staAuF);
        __list.add($valiRule);
        __map.put("valiRule", $valiRule);
        __list.add($shwFmt);
        __map.put("shwFmt", $shwFmt);
        __list.add($editHight);
        __map.put("editHight", $editHight);
        __list.add($editWidth);
        __map.put("editWidth", $editWidth);
        __list.add($gridColWidth);
        __map.put("gridColWidth", $gridColWidth);
        __list.add($tipMsgCd);
        __map.put("tipMsgCd", $tipMsgCd);
        __list.add($mrUseF);
        __map.put("mrUseF", $mrUseF);
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
    public void preInsert(pkuhit.me.dao.auto.entity.MeObjAttr entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.me.dao.auto.entity.MeObjAttr> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.me.dao.auto.entity.MeObjAttr entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.me.dao.auto.entity.MeObjAttr> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.me.dao.auto.entity.MeObjAttr entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.me.dao.auto.entity.MeObjAttr> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.me.dao.auto.entity.MeObjAttr entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.me.dao.auto.entity.MeObjAttr> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.me.dao.auto.entity.MeObjAttr entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.me.dao.auto.entity.MeObjAttr> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.me.dao.auto.entity.MeObjAttr entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.me.dao.auto.entity.MeObjAttr> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.me.dao.auto.entity.MeObjAttr, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.me.dao.auto.entity.MeObjAttr, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeObjAttr newEntity() {
        return new pkuhit.me.dao.auto.entity.MeObjAttr();
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeObjAttr newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.me.dao.auto.entity.MeObjAttr();
    }

    @Override
    public Class<pkuhit.me.dao.auto.entity.MeObjAttr> getEntityClass() {
        return pkuhit.me.dao.auto.entity.MeObjAttr.class;
    }

    @Override
    public pkuhit.me.dao.auto.entity.MeObjAttr getOriginalStates(pkuhit.me.dao.auto.entity.MeObjAttr __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.me.dao.auto.entity.MeObjAttr __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MeObjAttr getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MeObjAttr newInstance() {
        return new _MeObjAttr();
    }

}
