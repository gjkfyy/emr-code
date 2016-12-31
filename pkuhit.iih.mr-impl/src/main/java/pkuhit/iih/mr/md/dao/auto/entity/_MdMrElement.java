package pkuhit.iih.mr.md.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.835+0800")
public final class _MdMrElement extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MdMrElement __singleton = new _MdMrElement();

    /** the mrElementCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $mrElementCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrElementCd", "MR_ELEMENT_CD");

    /** the mrPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $mrPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrPk", "MR_PK", true, true);

    /** the mrElementBizCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $mrElementBizCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrElementBizCd", "MR_ELEMENT_BIZ_CD", true, true);

    /** the mrElementVer */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $mrElementVer = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "mrElementVer", "MR_ELEMENT_VER", true, true);

    /** the mrElementNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $mrElementNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrElementNm", "MR_ELEMENT_NM", true, true);

    /** the elementNmEn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $elementNmEn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "elementNmEn", "ELEMENT_NM_EN", true, true);

    /** the macroelementFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $macroelementFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "macroelementFlag", "MACROELEMENT_FLAG", true, true);

    /** the macroelementTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $macroelementTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "macroelementTypeCd", "MACROELEMENT_TYPE_CD", true, true);

    /** the mrElementTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $mrElementTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrElementTypeCd", "MR_ELEMENT_TYPE_CD", true, true);

    /** the tipNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $tipNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "tipNm", "TIP_NM", true, true);

    /** the deleteableFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $deleteableFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "deleteableFlag", "DELETEABLE_FLAG", true, true);

    /** the readonlyFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $readonlyFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "readonlyFlag", "READONLY_FLAG", true, true);

    /** the notNullFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $notNullFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "notNullFlag", "NOT_NULL_FLAG", true, true);

    /** the printalbeFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $printalbeFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "printalbeFlag", "PRINTALBE_FLAG", true, true);

    /** the showOutlineBorderFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $showOutlineBorderFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "showOutlineBorderFlag", "SHOW_OUTLINE_BORDER_FLAG", true, true);

    /** the secrecyFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $secrecyFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "secrecyFlag", "SECRECY_FLAG", true, true);

    /** the showUnitFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $showUnitFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "showUnitFlag", "SHOW_UNIT_FLAG", true, true);

    /** the lengthLimit */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Integer, java.lang.Object> $lengthLimit = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Integer, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "lengthLimit", "LENGTH_LIMIT", true, true);

    /** the metaElementCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $metaElementCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "metaElementCd", "META_ELEMENT_CD", true, true);

    /** the dataTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $dataTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataTypeCd", "DATA_TYPE_CD", true, true);

    /** the dictRangeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $dictRangeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dictRangeCd", "DICT_RANGE_CD", true, true);

    /** the custormRange */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $custormRange = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "custormRange", "CUSTORM_RANGE", true, true);

    /** the mrElementGroupCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $mrElementGroupCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrElementGroupCd", "MR_ELEMENT_GROUP_CD", true, true);

    /** the defaultValue */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $defaultValue = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "defaultValue", "DEFAULT_VALUE", true, true);

    /** the radioFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $radioFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "radioFlag", "RADIO_FLAG", true, true);

    /** the positivePrefix */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $positivePrefix = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "positivePrefix", "POSITIVE_PREFIX", true, true);

    /** the femininePrefix */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $femininePrefix = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "femininePrefix", "FEMININE_PREFIX", true, true);

    /** the unitCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $unitCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "unitCd", "UNIT_CD", true, true);

    /** the valuePrecision */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Long, java.lang.Object> $valuePrecision = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Long, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Long.class, org.seasar.doma.wrapper.LongWrapper.class, null, null, "valuePrecision", "VALUE_PRECISION", true, true);

    /** the minValue */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $minValue = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "minValue", "MIN_VALUE", true, true);

    /** the maxValue */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $maxValue = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "maxValue", "MAX_VALUE", true, true);

    /** the showFormat */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $showFormat = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "showFormat", "SHOW_FORMAT", true, true);

    /** the normalMinValue */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $normalMinValue = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "normalMinValue", "NORMAL_MIN_VALUE", true, true);

    /** the normalMaxValue */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $normalMaxValue = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "normalMaxValue", "NORMAL_MAX_VALUE", true, true);

    /** the spellingCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $spellingCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellingCd", "SPELLING_CD", true, true);

    /** the wubiCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $wubiCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiCd", "WUBI_CD", true, true);

    /** the enabledFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $enabledFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "enabledFlag", "ENABLED_FLAG", true, true);

    /** the deData */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $deData = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deData", "DE_DATA", true, true);

    /** the cascadeData */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $cascadeData = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "cascadeData", "CASCADE_DATA", true, true);

    /** the ownerTypeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $ownerTypeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerTypeCd", "OWNER_TYPE_CD", true, true);

    /** the ownerCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $ownerCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "ownerCd", "OWNER_CD", true, true);

    /** the showSignFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $showSignFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "showSignFlag", "SHOW_SIGN_FLAG", true, true);

    /** the showSign */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $showSign = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "showSign", "SHOW_SIGN", true, true);

    /** the descriptions */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $descriptions = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "descriptions", "DESCRIPTIONS", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.String, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.mr.md.dao.auto.entity.MdMrElementListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>> __entityPropertyTypeMap;

    private _MdMrElement() {
        __listener = new pkuhit.iih.mr.md.dao.auto.entity.MdMrElementListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MdMrElement";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MD_MR_ELEMENT";
        __qualifiedTableName = "MD_MR_ELEMENT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>>(56);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>>(56);
        __idList.add($mrElementCd);
        __list.add($mrElementCd);
        __map.put("mrElementCd", $mrElementCd);
        __list.add($mrPk);
        __map.put("mrPk", $mrPk);
        __list.add($mrElementBizCd);
        __map.put("mrElementBizCd", $mrElementBizCd);
        __list.add($mrElementVer);
        __map.put("mrElementVer", $mrElementVer);
        __list.add($mrElementNm);
        __map.put("mrElementNm", $mrElementNm);
        __list.add($elementNmEn);
        __map.put("elementNmEn", $elementNmEn);
        __list.add($macroelementFlag);
        __map.put("macroelementFlag", $macroelementFlag);
        __list.add($macroelementTypeCd);
        __map.put("macroelementTypeCd", $macroelementTypeCd);
        __list.add($mrElementTypeCd);
        __map.put("mrElementTypeCd", $mrElementTypeCd);
        __list.add($tipNm);
        __map.put("tipNm", $tipNm);
        __list.add($deleteableFlag);
        __map.put("deleteableFlag", $deleteableFlag);
        __list.add($readonlyFlag);
        __map.put("readonlyFlag", $readonlyFlag);
        __list.add($notNullFlag);
        __map.put("notNullFlag", $notNullFlag);
        __list.add($printalbeFlag);
        __map.put("printalbeFlag", $printalbeFlag);
        __list.add($showOutlineBorderFlag);
        __map.put("showOutlineBorderFlag", $showOutlineBorderFlag);
        __list.add($secrecyFlag);
        __map.put("secrecyFlag", $secrecyFlag);
        __list.add($showUnitFlag);
        __map.put("showUnitFlag", $showUnitFlag);
        __list.add($lengthLimit);
        __map.put("lengthLimit", $lengthLimit);
        __list.add($metaElementCd);
        __map.put("metaElementCd", $metaElementCd);
        __list.add($dataTypeCd);
        __map.put("dataTypeCd", $dataTypeCd);
        __list.add($dictRangeCd);
        __map.put("dictRangeCd", $dictRangeCd);
        __list.add($custormRange);
        __map.put("custormRange", $custormRange);
        __list.add($mrElementGroupCd);
        __map.put("mrElementGroupCd", $mrElementGroupCd);
        __list.add($defaultValue);
        __map.put("defaultValue", $defaultValue);
        __list.add($radioFlag);
        __map.put("radioFlag", $radioFlag);
        __list.add($positivePrefix);
        __map.put("positivePrefix", $positivePrefix);
        __list.add($femininePrefix);
        __map.put("femininePrefix", $femininePrefix);
        __list.add($unitCd);
        __map.put("unitCd", $unitCd);
        __list.add($valuePrecision);
        __map.put("valuePrecision", $valuePrecision);
        __list.add($minValue);
        __map.put("minValue", $minValue);
        __list.add($maxValue);
        __map.put("maxValue", $maxValue);
        __list.add($showFormat);
        __map.put("showFormat", $showFormat);
        __list.add($normalMinValue);
        __map.put("normalMinValue", $normalMinValue);
        __list.add($normalMaxValue);
        __map.put("normalMaxValue", $normalMaxValue);
        __list.add($spellingCd);
        __map.put("spellingCd", $spellingCd);
        __list.add($wubiCd);
        __map.put("wubiCd", $wubiCd);
        __list.add($enabledFlag);
        __map.put("enabledFlag", $enabledFlag);
        __list.add($deData);
        __map.put("deData", $deData);
        __list.add($cascadeData);
        __map.put("cascadeData", $cascadeData);
        __list.add($ownerTypeCd);
        __map.put("ownerTypeCd", $ownerTypeCd);
        __list.add($ownerCd);
        __map.put("ownerCd", $ownerCd);
        __list.add($showSignFlag);
        __map.put("showSignFlag", $showSignFlag);
        __list.add($showSign);
        __map.put("showSign", $showSign);
        __list.add($descriptions);
        __map.put("descriptions", $descriptions);
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
    public void preInsert(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.md.dao.auto.entity.MdMrElement, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMrElement newEntity() {
        return new pkuhit.iih.mr.md.dao.auto.entity.MdMrElement();
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMrElement newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.md.dao.auto.entity.MdMrElement();
    }

    @Override
    public Class<pkuhit.iih.mr.md.dao.auto.entity.MdMrElement> getEntityClass() {
        return pkuhit.iih.mr.md.dao.auto.entity.MdMrElement.class;
    }

    @Override
    public pkuhit.iih.mr.md.dao.auto.entity.MdMrElement getOriginalStates(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.md.dao.auto.entity.MdMrElement __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MdMrElement getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MdMrElement newInstance() {
        return new _MdMrElement();
    }

}
