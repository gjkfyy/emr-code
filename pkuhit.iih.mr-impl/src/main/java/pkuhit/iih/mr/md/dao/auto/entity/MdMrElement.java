package pkuhit.iih.mr.md.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 元素库
 */
@Entity(listener = MdMrElementListener.class)
@Table(name = "MD_MR_ELEMENT")
public class MdMrElement {

    /** MR_ELEMENT_CD */
    @Id
    @Column(name = "MR_ELEMENT_CD")
    String mrElementCd;

    /** MR_PK */
    @Column(name = "MR_PK")
    String mrPk;

    /** MR_ELEMENT_BIZ_CD */
    @Column(name = "MR_ELEMENT_BIZ_CD")
    String mrElementBizCd;

    /** MR_ELEMENT_VER */
    @Column(name = "MR_ELEMENT_VER")
    Short mrElementVer;

    /** MR_ELEMENT_NM */
    @Column(name = "MR_ELEMENT_NM")
    String mrElementNm;

    /** ELEMENT_NM_EN */
    @Column(name = "ELEMENT_NM_EN")
    String elementNmEn;

    /** MACROELEMENT_FLAG */
    @Column(name = "MACROELEMENT_FLAG")
    Short macroelementFlag;

    /** MACROELEMENT_TYPE_CD */
    @Column(name = "MACROELEMENT_TYPE_CD")
    String macroelementTypeCd;

    /** MR_ELEMENT_TYPE_CD */
    @Column(name = "MR_ELEMENT_TYPE_CD")
    String mrElementTypeCd;

    /** TIP_NM */
    @Column(name = "TIP_NM")
    String tipNm;

    /** DELETEABLE_FLAG */
    @Column(name = "DELETEABLE_FLAG")
    Short deleteableFlag;

    /** READONLY_FLAG */
    @Column(name = "READONLY_FLAG")
    Short readonlyFlag;

    /** NOT_NULL_FLAG */
    @Column(name = "NOT_NULL_FLAG")
    Short notNullFlag;

    /** PRINTALBE_FLAG */
    @Column(name = "PRINTALBE_FLAG")
    Short printalbeFlag;

    /** SHOW_OUTLINE_BORDER_FLAG */
    @Column(name = "SHOW_OUTLINE_BORDER_FLAG")
    Short showOutlineBorderFlag;

    /** SECRECY_FLAG */
    @Column(name = "SECRECY_FLAG")
    Short secrecyFlag;

    /** SHOW_UNIT_FLAG */
    @Column(name = "SHOW_UNIT_FLAG")
    Short showUnitFlag;

    /** LENGTH_LIMIT */
    @Column(name = "LENGTH_LIMIT")
    Integer lengthLimit;

    /** META_ELEMENT_CD */
    @Column(name = "META_ELEMENT_CD")
    String metaElementCd;

    /** DATA_TYPE_CD */
    @Column(name = "DATA_TYPE_CD")
    String dataTypeCd;

    /** DICT_RANGE_CD */
    @Column(name = "DICT_RANGE_CD")
    String dictRangeCd;

    /** CUSTORM_RANGE */
    @Column(name = "CUSTORM_RANGE")
    String custormRange;

    /** MR_ELEMENT_GROUP_CD */
    @Column(name = "MR_ELEMENT_GROUP_CD")
    String mrElementGroupCd;

    /** DEFAULT_VALUE */
    @Column(name = "DEFAULT_VALUE")
    String defaultValue;

    /** RADIO_FLAG */
    @Column(name = "RADIO_FLAG")
    Short radioFlag;

    /** POSITIVE_PREFIX */
    @Column(name = "POSITIVE_PREFIX")
    String positivePrefix;

    /** FEMININE_PREFIX */
    @Column(name = "FEMININE_PREFIX")
    String femininePrefix;

    /** UNIT_CD */
    @Column(name = "UNIT_CD")
    String unitCd;

    /** VALUE_PRECISION */
    @Column(name = "VALUE_PRECISION")
    Long valuePrecision;

    /** MIN_VALUE */
    @Column(name = "MIN_VALUE")
    String minValue;

    /** MAX_VALUE */
    @Column(name = "MAX_VALUE")
    String maxValue;

    /** SHOW_FORMAT */
    @Column(name = "SHOW_FORMAT")
    String showFormat;

    /** NORMAL_MIN_VALUE */
    @Column(name = "NORMAL_MIN_VALUE")
    String normalMinValue;

    /** NORMAL_MAX_VALUE */
    @Column(name = "NORMAL_MAX_VALUE")
    String normalMaxValue;

    /** SPELLING_CD */
    @Column(name = "SPELLING_CD")
    String spellingCd;

    /** WUBI_CD */
    @Column(name = "WUBI_CD")
    String wubiCd;

    /** ENABLED_FLAG */
    @Column(name = "ENABLED_FLAG")
    Short enabledFlag;

    /** DE_DATA */
    @Column(name = "DE_DATA")
    String deData;

    /** CASCADE_DATA */
    @Column(name = "CASCADE_DATA")
    String cascadeData;

    /** OWNER_TYPE_CD */
    @Column(name = "OWNER_TYPE_CD")
    String ownerTypeCd;

    /** OWNER_CD */
    @Column(name = "OWNER_CD")
    String ownerCd;

    /** SHOW_SIGN_FLAG */
    @Column(name = "SHOW_SIGN_FLAG")
    Short showSignFlag;

    /** SHOW_SIGN */
    @Column(name = "SHOW_SIGN")
    String showSign;

    /** DESCRIPTIONS */
    @Column(name = "DESCRIPTIONS")
    String descriptions;

    /** */
    @Column(name = "MEMO")
    String memo;

    /** */
    @Column(name = "SORT_NO")
    String sortNo;

    /** */
    @Column(name = "SPELL_NO")
    String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    String wubiNo;

    /** */
    @Column(name = "UPD_CNT")
    BigInteger updCnt;

    /** */
    @Column(name = "CRT_TIME")
    Timestamp crtTime;

    /** */
    @Column(name = "CRT_USER_ID")
    String crtUserId;

    /** */
    @Column(name = "CRT_DEPT_CD")
    String crtDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    /** */
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;

    /** */
    @Column(name = "DEL_F")
    Short delF;

    /** 
     * Returns the mrElementCd.
     * 
     * @return the mrElementCd
     */
    public String getMrElementCd() {
        return mrElementCd;
    }

    /** 
     * Sets the mrElementCd.
     * 
     * @param mrElementCd the mrElementCd
     */
    public void setMrElementCd(String mrElementCd) {
        this.mrElementCd = mrElementCd;
    }

    /** 
     * Returns the mrPk.
     * 
     * @return the mrPk
     */
    public String getMrPk() {
        return mrPk;
    }

    /** 
     * Sets the mrPk.
     * 
     * @param mrPk the mrPk
     */
    public void setMrPk(String mrPk) {
        this.mrPk = mrPk;
    }

    /** 
     * Returns the mrElementBizCd.
     * 
     * @return the mrElementBizCd
     */
    public String getMrElementBizCd() {
        return mrElementBizCd;
    }

    /** 
     * Sets the mrElementBizCd.
     * 
     * @param mrElementBizCd the mrElementBizCd
     */
    public void setMrElementBizCd(String mrElementBizCd) {
        this.mrElementBizCd = mrElementBizCd;
    }

    /** 
     * Returns the mrElementVer.
     * 
     * @return the mrElementVer
     */
    public Short getMrElementVer() {
        return mrElementVer;
    }

    /** 
     * Sets the mrElementVer.
     * 
     * @param mrElementVer the mrElementVer
     */
    public void setMrElementVer(Short mrElementVer) {
        this.mrElementVer = mrElementVer;
    }

    /** 
     * Returns the mrElementNm.
     * 
     * @return the mrElementNm
     */
    public String getMrElementNm() {
        return mrElementNm;
    }

    /** 
     * Sets the mrElementNm.
     * 
     * @param mrElementNm the mrElementNm
     */
    public void setMrElementNm(String mrElementNm) {
        this.mrElementNm = mrElementNm;
    }

    /** 
     * Returns the elementNmEn.
     * 
     * @return the elementNmEn
     */
    public String getElementNmEn() {
        return elementNmEn;
    }

    /** 
     * Sets the elementNmEn.
     * 
     * @param elementNmEn the elementNmEn
     */
    public void setElementNmEn(String elementNmEn) {
        this.elementNmEn = elementNmEn;
    }

    /** 
     * Returns the macroelementFlag.
     * 
     * @return the macroelementFlag
     */
    public Short getMacroelementFlag() {
        return macroelementFlag;
    }

    /** 
     * Sets the macroelementFlag.
     * 
     * @param macroelementFlag the macroelementFlag
     */
    public void setMacroelementFlag(Short macroelementFlag) {
        this.macroelementFlag = macroelementFlag;
    }

    /** 
     * Returns the macroelementTypeCd.
     * 
     * @return the macroelementTypeCd
     */
    public String getMacroelementTypeCd() {
        return macroelementTypeCd;
    }

    /** 
     * Sets the macroelementTypeCd.
     * 
     * @param macroelementTypeCd the macroelementTypeCd
     */
    public void setMacroelementTypeCd(String macroelementTypeCd) {
        this.macroelementTypeCd = macroelementTypeCd;
    }

    /** 
     * Returns the mrElementTypeCd.
     * 
     * @return the mrElementTypeCd
     */
    public String getMrElementTypeCd() {
        return mrElementTypeCd;
    }

    /** 
     * Sets the mrElementTypeCd.
     * 
     * @param mrElementTypeCd the mrElementTypeCd
     */
    public void setMrElementTypeCd(String mrElementTypeCd) {
        this.mrElementTypeCd = mrElementTypeCd;
    }

    /** 
     * Returns the tipNm.
     * 
     * @return the tipNm
     */
    public String getTipNm() {
        return tipNm;
    }

    /** 
     * Sets the tipNm.
     * 
     * @param tipNm the tipNm
     */
    public void setTipNm(String tipNm) {
        this.tipNm = tipNm;
    }

    /** 
     * Returns the deleteableFlag.
     * 
     * @return the deleteableFlag
     */
    public Short getDeleteableFlag() {
        return deleteableFlag;
    }

    /** 
     * Sets the deleteableFlag.
     * 
     * @param deleteableFlag the deleteableFlag
     */
    public void setDeleteableFlag(Short deleteableFlag) {
        this.deleteableFlag = deleteableFlag;
    }

    /** 
     * Returns the readonlyFlag.
     * 
     * @return the readonlyFlag
     */
    public Short getReadonlyFlag() {
        return readonlyFlag;
    }

    /** 
     * Sets the readonlyFlag.
     * 
     * @param readonlyFlag the readonlyFlag
     */
    public void setReadonlyFlag(Short readonlyFlag) {
        this.readonlyFlag = readonlyFlag;
    }

    /** 
     * Returns the notNullFlag.
     * 
     * @return the notNullFlag
     */
    public Short getNotNullFlag() {
        return notNullFlag;
    }

    /** 
     * Sets the notNullFlag.
     * 
     * @param notNullFlag the notNullFlag
     */
    public void setNotNullFlag(Short notNullFlag) {
        this.notNullFlag = notNullFlag;
    }

    /** 
     * Returns the printalbeFlag.
     * 
     * @return the printalbeFlag
     */
    public Short getPrintalbeFlag() {
        return printalbeFlag;
    }

    /** 
     * Sets the printalbeFlag.
     * 
     * @param printalbeFlag the printalbeFlag
     */
    public void setPrintalbeFlag(Short printalbeFlag) {
        this.printalbeFlag = printalbeFlag;
    }

    /** 
     * Returns the showOutlineBorderFlag.
     * 
     * @return the showOutlineBorderFlag
     */
    public Short getShowOutlineBorderFlag() {
        return showOutlineBorderFlag;
    }

    /** 
     * Sets the showOutlineBorderFlag.
     * 
     * @param showOutlineBorderFlag the showOutlineBorderFlag
     */
    public void setShowOutlineBorderFlag(Short showOutlineBorderFlag) {
        this.showOutlineBorderFlag = showOutlineBorderFlag;
    }

    /** 
     * Returns the secrecyFlag.
     * 
     * @return the secrecyFlag
     */
    public Short getSecrecyFlag() {
        return secrecyFlag;
    }

    /** 
     * Sets the secrecyFlag.
     * 
     * @param secrecyFlag the secrecyFlag
     */
    public void setSecrecyFlag(Short secrecyFlag) {
        this.secrecyFlag = secrecyFlag;
    }

    /** 
     * Returns the showUnitFlag.
     * 
     * @return the showUnitFlag
     */
    public Short getShowUnitFlag() {
        return showUnitFlag;
    }

    /** 
     * Sets the showUnitFlag.
     * 
     * @param showUnitFlag the showUnitFlag
     */
    public void setShowUnitFlag(Short showUnitFlag) {
        this.showUnitFlag = showUnitFlag;
    }

    /** 
     * Returns the lengthLimit.
     * 
     * @return the lengthLimit
     */
    public Integer getLengthLimit() {
        return lengthLimit;
    }

    /** 
     * Sets the lengthLimit.
     * 
     * @param lengthLimit the lengthLimit
     */
    public void setLengthLimit(Integer lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    /** 
     * Returns the metaElementCd.
     * 
     * @return the metaElementCd
     */
    public String getMetaElementCd() {
        return metaElementCd;
    }

    /** 
     * Sets the metaElementCd.
     * 
     * @param metaElementCd the metaElementCd
     */
    public void setMetaElementCd(String metaElementCd) {
        this.metaElementCd = metaElementCd;
    }

    /** 
     * Returns the dataTypeCd.
     * 
     * @return the dataTypeCd
     */
    public String getDataTypeCd() {
        return dataTypeCd;
    }

    /** 
     * Sets the dataTypeCd.
     * 
     * @param dataTypeCd the dataTypeCd
     */
    public void setDataTypeCd(String dataTypeCd) {
        this.dataTypeCd = dataTypeCd;
    }

    /** 
     * Returns the dictRangeCd.
     * 
     * @return the dictRangeCd
     */
    public String getDictRangeCd() {
        return dictRangeCd;
    }

    /** 
     * Sets the dictRangeCd.
     * 
     * @param dictRangeCd the dictRangeCd
     */
    public void setDictRangeCd(String dictRangeCd) {
        this.dictRangeCd = dictRangeCd;
    }

    /** 
     * Returns the custormRange.
     * 
     * @return the custormRange
     */
    public String getCustormRange() {
        return custormRange;
    }

    /** 
     * Sets the custormRange.
     * 
     * @param custormRange the custormRange
     */
    public void setCustormRange(String custormRange) {
        this.custormRange = custormRange;
    }

    /** 
     * Returns the mrElementGroupCd.
     * 
     * @return the mrElementGroupCd
     */
    public String getMrElementGroupCd() {
        return mrElementGroupCd;
    }

    /** 
     * Sets the mrElementGroupCd.
     * 
     * @param mrElementGroupCd the mrElementGroupCd
     */
    public void setMrElementGroupCd(String mrElementGroupCd) {
        this.mrElementGroupCd = mrElementGroupCd;
    }

    /** 
     * Returns the defaultValue.
     * 
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /** 
     * Sets the defaultValue.
     * 
     * @param defaultValue the defaultValue
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /** 
     * Returns the radioFlag.
     * 
     * @return the radioFlag
     */
    public Short getRadioFlag() {
        return radioFlag;
    }

    /** 
     * Sets the radioFlag.
     * 
     * @param radioFlag the radioFlag
     */
    public void setRadioFlag(Short radioFlag) {
        this.radioFlag = radioFlag;
    }

    /** 
     * Returns the positivePrefix.
     * 
     * @return the positivePrefix
     */
    public String getPositivePrefix() {
        return positivePrefix;
    }

    /** 
     * Sets the positivePrefix.
     * 
     * @param positivePrefix the positivePrefix
     */
    public void setPositivePrefix(String positivePrefix) {
        this.positivePrefix = positivePrefix;
    }

    /** 
     * Returns the femininePrefix.
     * 
     * @return the femininePrefix
     */
    public String getFemininePrefix() {
        return femininePrefix;
    }

    /** 
     * Sets the femininePrefix.
     * 
     * @param femininePrefix the femininePrefix
     */
    public void setFemininePrefix(String femininePrefix) {
        this.femininePrefix = femininePrefix;
    }

    /** 
     * Returns the unitCd.
     * 
     * @return the unitCd
     */
    public String getUnitCd() {
        return unitCd;
    }

    /** 
     * Sets the unitCd.
     * 
     * @param unitCd the unitCd
     */
    public void setUnitCd(String unitCd) {
        this.unitCd = unitCd;
    }

    /** 
     * Returns the valuePrecision.
     * 
     * @return the valuePrecision
     */
    public Long getValuePrecision() {
        return valuePrecision;
    }

    /** 
     * Sets the valuePrecision.
     * 
     * @param valuePrecision the valuePrecision
     */
    public void setValuePrecision(Long valuePrecision) {
        this.valuePrecision = valuePrecision;
    }

    /** 
     * Returns the minValue.
     * 
     * @return the minValue
     */
    public String getMinValue() {
        return minValue;
    }

    /** 
     * Sets the minValue.
     * 
     * @param minValue the minValue
     */
    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    /** 
     * Returns the maxValue.
     * 
     * @return the maxValue
     */
    public String getMaxValue() {
        return maxValue;
    }

    /** 
     * Sets the maxValue.
     * 
     * @param maxValue the maxValue
     */
    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    /** 
     * Returns the showFormat.
     * 
     * @return the showFormat
     */
    public String getShowFormat() {
        return showFormat;
    }

    /** 
     * Sets the showFormat.
     * 
     * @param showFormat the showFormat
     */
    public void setShowFormat(String showFormat) {
        this.showFormat = showFormat;
    }

    /** 
     * Returns the normalMinValue.
     * 
     * @return the normalMinValue
     */
    public String getNormalMinValue() {
        return normalMinValue;
    }

    /** 
     * Sets the normalMinValue.
     * 
     * @param normalMinValue the normalMinValue
     */
    public void setNormalMinValue(String normalMinValue) {
        this.normalMinValue = normalMinValue;
    }

    /** 
     * Returns the normalMaxValue.
     * 
     * @return the normalMaxValue
     */
    public String getNormalMaxValue() {
        return normalMaxValue;
    }

    /** 
     * Sets the normalMaxValue.
     * 
     * @param normalMaxValue the normalMaxValue
     */
    public void setNormalMaxValue(String normalMaxValue) {
        this.normalMaxValue = normalMaxValue;
    }

    /** 
     * Returns the spellingCd.
     * 
     * @return the spellingCd
     */
    public String getSpellingCd() {
        return spellingCd;
    }

    /** 
     * Sets the spellingCd.
     * 
     * @param spellingCd the spellingCd
     */
    public void setSpellingCd(String spellingCd) {
        this.spellingCd = spellingCd;
    }

    /** 
     * Returns the wubiCd.
     * 
     * @return the wubiCd
     */
    public String getWubiCd() {
        return wubiCd;
    }

    /** 
     * Sets the wubiCd.
     * 
     * @param wubiCd the wubiCd
     */
    public void setWubiCd(String wubiCd) {
        this.wubiCd = wubiCd;
    }

    /** 
     * Returns the enabledFlag.
     * 
     * @return the enabledFlag
     */
    public Short getEnabledFlag() {
        return enabledFlag;
    }

    /** 
     * Sets the enabledFlag.
     * 
     * @param enabledFlag the enabledFlag
     */
    public void setEnabledFlag(Short enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    /** 
     * Returns the deData.
     * 
     * @return the deData
     */
    public String getDeData() {
        return deData;
    }

    /** 
     * Sets the deData.
     * 
     * @param deData the deData
     */
    public void setDeData(String deData) {
        this.deData = deData;
    }

    /** 
     * Returns the cascadeData.
     * 
     * @return the cascadeData
     */
    public String getCascadeData() {
        return cascadeData;
    }

    /** 
     * Sets the cascadeData.
     * 
     * @param cascadeData the cascadeData
     */
    public void setCascadeData(String cascadeData) {
        this.cascadeData = cascadeData;
    }

    /** 
     * Returns the ownerTypeCd.
     * 
     * @return the ownerTypeCd
     */
    public String getOwnerTypeCd() {
        return ownerTypeCd;
    }

    /** 
     * Sets the ownerTypeCd.
     * 
     * @param ownerTypeCd the ownerTypeCd
     */
    public void setOwnerTypeCd(String ownerTypeCd) {
        this.ownerTypeCd = ownerTypeCd;
    }

    /** 
     * Returns the ownerCd.
     * 
     * @return the ownerCd
     */
    public String getOwnerCd() {
        return ownerCd;
    }

    /** 
     * Sets the ownerCd.
     * 
     * @param ownerCd the ownerCd
     */
    public void setOwnerCd(String ownerCd) {
        this.ownerCd = ownerCd;
    }

    /** 
     * Returns the showSignFlag.
     * 
     * @return the showSignFlag
     */
    public Short getShowSignFlag() {
        return showSignFlag;
    }

    /** 
     * Sets the showSignFlag.
     * 
     * @param showSignFlag the showSignFlag
     */
    public void setShowSignFlag(Short showSignFlag) {
        this.showSignFlag = showSignFlag;
    }

    /** 
     * Returns the showSign.
     * 
     * @return the showSign
     */
    public String getShowSign() {
        return showSign;
    }

    /** 
     * Sets the showSign.
     * 
     * @param showSign the showSign
     */
    public void setShowSign(String showSign) {
        this.showSign = showSign;
    }

    /** 
     * Returns the descriptions.
     * 
     * @return the descriptions
     */
    public String getDescriptions() {
        return descriptions;
    }

    /** 
     * Sets the descriptions.
     * 
     * @param descriptions the descriptions
     */
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    /** 
     * Returns the memo.
     * 
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /** 
     * Sets the memo.
     * 
     * @param memo the memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /** 
     * Returns the sortNo.
     * 
     * @return the sortNo
     */
    public String getSortNo() {
        return sortNo;
    }

    /** 
     * Sets the sortNo.
     * 
     * @param sortNo the sortNo
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    /** 
     * Returns the spellNo.
     * 
     * @return the spellNo
     */
    public String getSpellNo() {
        return spellNo;
    }

    /** 
     * Sets the spellNo.
     * 
     * @param spellNo the spellNo
     */
    public void setSpellNo(String spellNo) {
        this.spellNo = spellNo;
    }

    /** 
     * Returns the wubiNo.
     * 
     * @return the wubiNo
     */
    public String getWubiNo() {
        return wubiNo;
    }

    /** 
     * Sets the wubiNo.
     * 
     * @param wubiNo the wubiNo
     */
    public void setWubiNo(String wubiNo) {
        this.wubiNo = wubiNo;
    }

    /** 
     * Returns the updCnt.
     * 
     * @return the updCnt
     */
    public BigInteger getUpdCnt() {
        return updCnt;
    }

    /** 
     * Sets the updCnt.
     * 
     * @param updCnt the updCnt
     */
    public void setUpdCnt(BigInteger updCnt) {
        this.updCnt = updCnt;
    }

    /** 
     * Returns the crtTime.
     * 
     * @return the crtTime
     */
    public Timestamp getCrtTime() {
        return crtTime;
    }

    /** 
     * Sets the crtTime.
     * 
     * @param crtTime the crtTime
     */
    public void setCrtTime(Timestamp crtTime) {
        this.crtTime = crtTime;
    }

    /** 
     * Returns the crtUserId.
     * 
     * @return the crtUserId
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /** 
     * Sets the crtUserId.
     * 
     * @param crtUserId the crtUserId
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    /** 
     * Returns the crtDeptCd.
     * 
     * @return the crtDeptCd
     */
    public String getCrtDeptCd() {
        return crtDeptCd;
    }

    /** 
     * Sets the crtDeptCd.
     * 
     * @param crtDeptCd the crtDeptCd
     */
    public void setCrtDeptCd(String crtDeptCd) {
        this.crtDeptCd = crtDeptCd;
    }

    /** 
     * Returns the lastUpdTime.
     * 
     * @return the lastUpdTime
     */
    public Timestamp getLastUpdTime() {
        return lastUpdTime;
    }

    /** 
     * Sets the lastUpdTime.
     * 
     * @param lastUpdTime the lastUpdTime
     */
    public void setLastUpdTime(Timestamp lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /** 
     * Returns the lastUpdDeptCd.
     * 
     * @return the lastUpdDeptCd
     */
    public String getLastUpdDeptCd() {
        return lastUpdDeptCd;
    }

    /** 
     * Sets the lastUpdDeptCd.
     * 
     * @param lastUpdDeptCd the lastUpdDeptCd
     */
    public void setLastUpdDeptCd(String lastUpdDeptCd) {
        this.lastUpdDeptCd = lastUpdDeptCd;
    }

    /** 
     * Returns the lastUpdUserId.
     * 
     * @return the lastUpdUserId
     */
    public String getLastUpdUserId() {
        return lastUpdUserId;
    }

    /** 
     * Sets the lastUpdUserId.
     * 
     * @param lastUpdUserId the lastUpdUserId
     */
    public void setLastUpdUserId(String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }

    /** 
     * Returns the delF.
     * 
     * @return the delF
     */
    public Short getDelF() {
        return delF;
    }

    /** 
     * Sets the delF.
     * 
     * @param delF the delF
     */
    public void setDelF(Short delF) {
        this.delF = delF;
    }
}