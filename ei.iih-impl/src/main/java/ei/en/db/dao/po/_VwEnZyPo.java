package ei.en.db.dao.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.805+0800")
public final class _VwEnZyPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.en.db.dao.po.VwEnZyPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _VwEnZyPo __singleton = new _VwEnZyPo();

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the deptQaScr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $deptQaScr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptQaScr", "DEPT_QA_SCR", true, true);

    /** the id */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.Integer, java.lang.Object> $id = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.Integer, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "id", "id");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the paId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $paId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paId", "PA_ID", true, true);

    /** the enCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.Integer, java.lang.Object> $enCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.Integer, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "enCnt", "EN_CNT", true, true);

    /** the paNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $paNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paNm", "PA_NM", true, true);

    /** the sexCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $sexCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sexCd", "SEX_CD", true, true);

    /** the age */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $age = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "age", "AGE", true, true);

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "ORG_CD", true, true);

    /** the amrNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $amrNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "amrNo", "AMR_NO", true, true);

    /** the enNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $enNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enNo", "EN_NO", true, true);

    /** the enTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $enTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enTpCd", "EN_TP_CD", true, true);

    /** the enStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $enStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enStaCd", "EN_STA_CD", true, true);

    /** the amrStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $amrStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "amrStaCd", "AMR_STA_CD", true, true);

    /** the amrRankCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $amrRankCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "amrRankCd", "AMR_RANK_CD", true, true);

    /** the qaScr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $qaScr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaScr", "QA_SCR", true, true);

    /** the regTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $regTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "regTime", "REG_TIME", true, true);

    /** the regUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $regUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "regUserId", "REG_USER_ID", true, true);

    /** the regDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $regDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "regDeptCd", "REG_DEPT_CD", true, true);

    /** the rcvUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $rcvUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rcvUserId", "RCV_USER_ID", true, true);

    /** the rcvDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $rcvDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rcvDeptCd", "RCV_DEPT_CD", true, true);

    /** the rcvTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $rcvTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rcvTime", "RCV_TIME", true, true);

    /** the illStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $illStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "illStaCd", "ILL_STA_CD", true, true);

    /** the nuLvlCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $nuLvlCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nuLvlCd", "NU_LVL_CD", true, true);

    /** the curMainDiCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curMainDiCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curMainDiCd", "CUR_MAIN_DI_CD", true, true);

    /** the curDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curDeptCd", "CUR_DEPT_CD", true, true);

    /** the curDeptInfoTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curDeptInfoTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curDeptInfoTime", "CUR_DEPT_INTO_TIME", true, true);

    /** the curWardCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curWardCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curWardCd", "CUR_WARD_CD", true, true);

    /** the curWardInfoTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curWardInfoTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curWardInfoTime", "CUR_WARD_INTO_TIME", true, true);

    /** the curGrpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curGrpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curGrpCd", "CUR_GRP_CD", true, true);

    /** the curBedCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curBedCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curBedCd", "CUR_BED_CD", true, true);

    /** the curMngDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curMngDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curMngDctId", "CUR_MNG_DCT_ID", true, true);

    /** the curMojDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curMojDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curMojDctId", "CUR_MOJ_DCT_ID", true, true);

    /** the curDrcDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curDrcDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curDrcDctId", "CUR_DRC_DCT_ID", true, true);

    /** the curMngNurId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $curMngNurId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "curMngNurId", "CUR_MNG_NUR_ID", true, true);

    /** the suF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $suF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "suF", "SU_F", true, true);

    /** the deathF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $deathF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deathF", "DEATH_F", true, true);

    /** the readmF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $readmF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "readmF", "READM_F", true, true);

    /** the callBackF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $callBackF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "callBackF", "CALL_BACK_F", true, true);

    /** the flupVisitF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $flupVisitF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "flupVisitF", "FLUP_VISIT_F", true, true);

    /** the fnshTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $fnshTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fnshTime", "FNSH_TIME", true, true);

    /** the fnshUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $fnshUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fnshUserId", "FNSH_USER_ID", true, true);

    /** the fnshDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $fnshDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fnshDeptCd", "FNSH_DEPT_CD", true, true);

    /** the termQaCmplTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $termQaCmplTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "termQaCmplTime", "TERM_QA_CMPL_TIME", true, true);

    /** the termQaCmplUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $termQaCmplUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "termQaCmplUserId", "TERM_QA_CMPL_USER_ID", true, true);

    /** the termQaCmplDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $termQaCmplDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "termQaCmplDeptCd", "TERM_QA_CMPL_DEPT_CD", true, true);

    /** the inprocess */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $inprocess = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "inprocess", "INPROCESS", true, true);

    /** the terminal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $terminal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "terminal", "TERMINAL", true, true);

    /** the deptTerminal */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $deptTerminal = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deptTerminal", "DEPT_TERMINAL", true, true);

    /** the paInsurCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $paInsurCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paInsurCd", "PA_INSUR_CD", true, true);

    /** the paInsurNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $paInsurNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paInsurNm", "PA_INSUR_NM", true, true);

    /** the idCard */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $idCard = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "idCard", "ID_CARD", true, true);

    /** the hicNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $hicNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "hicNo", "HIC_NO", true, true);

    /** the homeTel */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $homeTel = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "homeTel", "HOME_TEL", true, true);

    /** the socialSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $socialSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "socialSn", "SOCIAL_SN", true, true);

    /** the birthDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object> $birthDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, java.lang.String, java.lang.Object>(ei.en.db.dao.po.VwEnZyPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "birthDate", "BIRTH_DATE", true, true);

    private final ei.en.db.dao.po.VwEnZyPoListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>> __entityPropertyTypeMap;

    private _VwEnZyPo() {
        __listener = new ei.en.db.dao.po.VwEnZyPoListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "VwEnZyPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "VW_EN_ZY";
        __qualifiedTableName = "VW_EN_ZY";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>>(68);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>>(68);
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
        __list.add($deptQaScr);
        __map.put("deptQaScr", $deptQaScr);
        __idList.add($id);
        __list.add($id);
        __map.put("id", $id);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($paId);
        __map.put("paId", $paId);
        __list.add($enCnt);
        __map.put("enCnt", $enCnt);
        __list.add($paNm);
        __map.put("paNm", $paNm);
        __list.add($sexCd);
        __map.put("sexCd", $sexCd);
        __list.add($age);
        __map.put("age", $age);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($amrNo);
        __map.put("amrNo", $amrNo);
        __list.add($enNo);
        __map.put("enNo", $enNo);
        __list.add($enTpCd);
        __map.put("enTpCd", $enTpCd);
        __list.add($enStaCd);
        __map.put("enStaCd", $enStaCd);
        __list.add($amrStaCd);
        __map.put("amrStaCd", $amrStaCd);
        __list.add($amrRankCd);
        __map.put("amrRankCd", $amrRankCd);
        __list.add($qaScr);
        __map.put("qaScr", $qaScr);
        __list.add($regTime);
        __map.put("regTime", $regTime);
        __list.add($regUserId);
        __map.put("regUserId", $regUserId);
        __list.add($regDeptCd);
        __map.put("regDeptCd", $regDeptCd);
        __list.add($rcvUserId);
        __map.put("rcvUserId", $rcvUserId);
        __list.add($rcvDeptCd);
        __map.put("rcvDeptCd", $rcvDeptCd);
        __list.add($rcvTime);
        __map.put("rcvTime", $rcvTime);
        __list.add($illStaCd);
        __map.put("illStaCd", $illStaCd);
        __list.add($nuLvlCd);
        __map.put("nuLvlCd", $nuLvlCd);
        __list.add($curMainDiCd);
        __map.put("curMainDiCd", $curMainDiCd);
        __list.add($curDeptCd);
        __map.put("curDeptCd", $curDeptCd);
        __list.add($curDeptInfoTime);
        __map.put("curDeptInfoTime", $curDeptInfoTime);
        __list.add($curWardCd);
        __map.put("curWardCd", $curWardCd);
        __list.add($curWardInfoTime);
        __map.put("curWardInfoTime", $curWardInfoTime);
        __list.add($curGrpCd);
        __map.put("curGrpCd", $curGrpCd);
        __list.add($curBedCd);
        __map.put("curBedCd", $curBedCd);
        __list.add($curMngDctId);
        __map.put("curMngDctId", $curMngDctId);
        __list.add($curMojDctId);
        __map.put("curMojDctId", $curMojDctId);
        __list.add($curDrcDctId);
        __map.put("curDrcDctId", $curDrcDctId);
        __list.add($curMngNurId);
        __map.put("curMngNurId", $curMngNurId);
        __list.add($suF);
        __map.put("suF", $suF);
        __list.add($deathF);
        __map.put("deathF", $deathF);
        __list.add($readmF);
        __map.put("readmF", $readmF);
        __list.add($callBackF);
        __map.put("callBackF", $callBackF);
        __list.add($flupVisitF);
        __map.put("flupVisitF", $flupVisitF);
        __list.add($fnshTime);
        __map.put("fnshTime", $fnshTime);
        __list.add($fnshUserId);
        __map.put("fnshUserId", $fnshUserId);
        __list.add($fnshDeptCd);
        __map.put("fnshDeptCd", $fnshDeptCd);
        __list.add($termQaCmplTime);
        __map.put("termQaCmplTime", $termQaCmplTime);
        __list.add($termQaCmplUserId);
        __map.put("termQaCmplUserId", $termQaCmplUserId);
        __list.add($termQaCmplDeptCd);
        __map.put("termQaCmplDeptCd", $termQaCmplDeptCd);
        __list.add($inprocess);
        __map.put("inprocess", $inprocess);
        __list.add($terminal);
        __map.put("terminal", $terminal);
        __list.add($deptTerminal);
        __map.put("deptTerminal", $deptTerminal);
        __list.add($paInsurCd);
        __map.put("paInsurCd", $paInsurCd);
        __list.add($paInsurNm);
        __map.put("paInsurNm", $paInsurNm);
        __list.add($idCard);
        __map.put("idCard", $idCard);
        __list.add($hicNo);
        __map.put("hicNo", $hicNo);
        __list.add($homeTel);
        __map.put("homeTel", $homeTel);
        __list.add($socialSn);
        __map.put("socialSn", $socialSn);
        __list.add($birthDate);
        __map.put("birthDate", $birthDate);
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
    public void preInsert(ei.en.db.dao.po.VwEnZyPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.en.db.dao.po.VwEnZyPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.en.db.dao.po.VwEnZyPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.en.db.dao.po.VwEnZyPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.en.db.dao.po.VwEnZyPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.en.db.dao.po.VwEnZyPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.en.db.dao.po.VwEnZyPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.en.db.dao.po.VwEnZyPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.en.db.dao.po.VwEnZyPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.en.db.dao.po.VwEnZyPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.en.db.dao.po.VwEnZyPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.en.db.dao.po.VwEnZyPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.en.db.dao.po.VwEnZyPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.en.db.dao.po.VwEnZyPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.en.db.dao.po.VwEnZyPo newEntity() {
        return new ei.en.db.dao.po.VwEnZyPo();
    }

    @Override
    public ei.en.db.dao.po.VwEnZyPo newEntity(java.util.Map<String, Object> __args) {
        return new ei.en.db.dao.po.VwEnZyPo();
    }

    @Override
    public Class<ei.en.db.dao.po.VwEnZyPo> getEntityClass() {
        return ei.en.db.dao.po.VwEnZyPo.class;
    }

    @Override
    public ei.en.db.dao.po.VwEnZyPo getOriginalStates(ei.en.db.dao.po.VwEnZyPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.en.db.dao.po.VwEnZyPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _VwEnZyPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _VwEnZyPo newInstance() {
        return new _VwEnZyPo();
    }

}
