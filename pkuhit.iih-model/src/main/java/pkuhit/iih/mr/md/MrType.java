package pkuhit.iih.mr.md;

import java.math.BigInteger;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class MrType extends BaseMasterModel {

	public MrType() {

		super();

	}

	public MrType(String code) {

		super(code);

	}

	public static final String OBJ_CD = "MRM16";
	// 医疗记录类型编码
	public static final String CODE = "MRM16.AT01";
	// 父医疗记录类型编码
	public static final String PARENT_CODE = "MRM16.AT02";
	// 名称
	public static final String NAME = "MRM16.AT03";
	// 描述
	public static final String DESCRIPTION = "MRM16.AT04";
	// 英文简称
	public static final String SHORT_ENGLISH_NAME = "MRM16.AT05";
	// 英文名称
	public static final String ENGLISH_NAME = "MRM16.AT06";
	// 层级
	public static final String LEVEL = "MRM16.AT07";
	// 叶节点标志
	public static final String LEAF_FLAG = "MRM16.AT08";
	// 门(急)诊初诊病历
	public static final String OUT_FIRST_RECORD = "MRM16.47";
	// 门(急)诊复诊病历
	public static final String OUT_REPLY_RECORD = "MRM16.48";
	// 医疗记录类型编码
	@Column(name = "MR_TP_CD")
	private String code;

	// 父医疗记录类型编码
	@Column(name = "PAR_MR_TP_CD")
	private String parentCode;

	// 名称
	@DictionaryTag(code = "code", objCd = "MRM16")
	@Column(name = "NM")
	private String name;

	// 描述
	@Column(name = "DES")
	private String description;

	// 英文简称
	@Column(name = "SHT_NM_EN")
	private String shortEnglishName;

	// 英文名称
	@Column(name = "NM_EN")
	private String englishName;

	// 层级
	@Column(name = "LVL")
	private Integer level;

	// 叶节点标志
	@Column(name = "LEAF_F")
	private Integer leafFlag;
	// 父医疗记录类型名称
	@DictionaryTag(code = "parentCode")
	private String parentName;

	@Column(name = "MR_SIGN_LVL_CD")
	private String signLevelCode; // 审签等级
	@DictionaryTag(code = "signLevelCode", objCd = "MRM02")
	@Column(name = "MR_SIGN_LVL_NAME")
	private String signLevelName;// 审签等级

	/** */
	@Column(name = "SORT_NO")
	String sortNo;

	private String path;// root:"/" "/a/"

	/** */
	@Column(name = "MEMO")
	String memo;
	
	/** 只可建一份标识 */
	@Column(name = "ONLY_F")
	BigInteger onlyF;

	/** 新起一页打印标识 */
	@Column(name = "NEW_PAGE_F")
	BigInteger newPageF;

	/** 独占一页打印标识 */
	@Column(name = "ALONE_PAGE_F")
	BigInteger alonePageF;

	/** 关联分组编码 */
	@Column(name = "MR_TP_CCAT_CD")
	private String mrTpCcatCd;

	/** 就诊类型编码 */
	@Column(name = "EN_TP_CD")
	private String encounterTypeCode;

	/** 就诊类型 */
	@DictionaryTag(code = "encounterTypeCode", objCd = "ENM01")
	private String encounterTypeName;

	/** 是否允许非本人修改病历 */
	@Column(name = "PERMIT_F")
	Short permitF;
	
	/** 转换xml的json */
	@Column(name = "XML_JSON_PK")
	String xmlJsonPk;
	
	/** xml转换目标模板 */
	@Column(name = "XML_TEMPLATE_PK")
	String xmlTemplatePk;

	public String getXmlJsonPk() {
		return xmlJsonPk;
	}

	public void setXmlJsonPk(String xmlJsonPk) {
		this.xmlJsonPk = xmlJsonPk;
	}

	public String getXmlTemplatePk() {
		return xmlTemplatePk;
	}

	public void setXmlTemplatePk(String xmlTemplatePk) {
		this.xmlTemplatePk = xmlTemplatePk;
	}

	public BigInteger getOnlyF() {
		return onlyF;
	}

	public void setOnlyF(BigInteger onlyF) {
		this.onlyF = onlyF;
	}

	public BigInteger getNewPageF() {
		return newPageF;
	}

	public void setNewPageF(BigInteger newPageF) {
		this.newPageF = newPageF;
	}

	public String getMrTpCcatCd() {
		return mrTpCcatCd;
	}

	public void setMrTpCcatCd(String mrTpCcatCd) {
		this.mrTpCcatCd = mrTpCcatCd;
	}

	public String getEncounterTypeCode() {
		return encounterTypeCode;
	}

	public void setEncounterTypeCode(String encounterTypeCode) {
		this.encounterTypeCode = encounterTypeCode;
	}

	public String getEncounterTypeName() {
		return encounterTypeName;
	}

	public void setEncounterTypeName(String encounterTypeName) {
		this.encounterTypeName = encounterTypeName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortEnglishName() {
		return this.shortEnglishName;
	}

	public void setShortEnglishName(String shortEnglishName) {
		this.shortEnglishName = shortEnglishName;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLeafFlag() {
		return this.leafFlag;
	}

	public void setLeafFlag(Integer leafFlag) {
		this.leafFlag = leafFlag;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getSignLevelCode() {
		return signLevelCode;
	}

	public void setSignLevelCode(String signLevelCode) {
		this.signLevelCode = signLevelCode;
	}

	public String getSignLevelName() {
		return signLevelName;
	}

	public void setSignLevelName(String signLevelName) {
		this.signLevelName = signLevelName;
	}

	public String getSortNo() {
		return sortNo;
	}

	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	public BigInteger getAlonePageF() {
		return alonePageF;
	}

	public void setAlonePageF(BigInteger alonePageF) {
		this.alonePageF = alonePageF;
	}

	public Short getPermitF() {
		return permitF;
	}

	public void setPermitF(Short permitF) {
		this.permitF = permitF;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}