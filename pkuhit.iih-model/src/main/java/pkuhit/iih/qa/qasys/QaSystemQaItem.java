package pkuhit.iih.qa.qasys;

import java.math.BigDecimal;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class QaSystemQaItem extends BaseMasterModel {

	public QaSystemQaItem() {

		super();

	}

	public QaSystemQaItem(String code) {

		super(code);

	}

	public static final String OBJ_CD = "QAK05";

	// 质控体系质控项目编码
	public static final String CODE = "QAK05.AT01";
	// 质控体系医疗记录编码
	public static final String QA_SYSTEM_MR_CODE = "QAK05.AT02";
	// 质控体系段落编码
	public static final String QA_SYSTEM_SEGMENT_CODE = "QAK05.AT03";
	// 质控体系病案编码
	public static final String QA_SYSTEM_AMR_CODE = "QAK05.AT04";
	// 质控要求
	public static final String REQUIREMENT = "QAK05.AT05";
	// 质控扣分类型编码
	public static final String QA_DROP_SCORE_TYPE_CODE = "QAK05.AT06";
	// 单次扣分值
	public static final String ONCE_DROP_SCORE = "QAK05.AT07";
	// 累计最大扣分值
	public static final String MAX_DROP_SCORE = "QAK05.AT08";
	// 默认整改标志
	public static final String DEFAULT_REFORM_FLAG = "QAK05.AT09";
	// 自动质控标志
	public static final String AUTO_QA_FLAG = "QAK05.AT10";
	// 质控项目类型编码
	public static final String QA_ITEM_TYPE_CODE = "QAK05.AT12";

	// 质控体系质控项目编码
	@Column(name = "QA_SYS_ITM_CD")
	private String code;

	// 质控体系医疗记录编码
	@Column(name = "QA_SYS_MR_CD")
	private String qaSystemMrCode;

	// 质控体系段落编码
	@Column(name = "QA_SYS_SEG_CD")
	private String qaSystemSegmentCode;

	// 质控体系病案编码
	@Column(name = "QA_SYS_AMR_CD")
	private String qaSystemAmrCode;

	// 质控要求
	@Column(name = "REQ")
	private String requirement;

	// 质控扣分类型编码
	@Column(name = "QA_DRP_SCR_TP_CD")
	private String qaDropScoreTypeCode;

	// 单次扣分值
	@Column(name = "ONCE_DRP_SCR")
	private BigDecimal onceDropScore;

	// 累计最大扣分值
	@Column(name = "MAX_DRP_SCR")
	private BigDecimal maxDropScore;

	// 默认整改标志
	@Column(name = "DFT_RFM_F")
	private Integer defaultReformFlag;

	// 自动质控标志
	@Column(name = "AUTO_QA_F")
	private Integer autoQaFlag;
	// 质控扣分类型名称
	@DictionaryTag(code = "qaDropScoreTypeCode", objCd = "QAM02")
	private String qaDropScoreTypeName;

	// 质控项目类型编码
	@Column(name = "QA_ITM_TP_CD")
	private String qaItemTypeCode;
	// 质控项目类型名称
	@DictionaryTag(code = "qaItemTypeCode", objCd = "QAM06")
	private String qaItemTypeName;
	// 质控体系医疗记录名称
	@DictionaryTag(code = "qaSystemMrCode", objCd = "null")
	private String qaSystemMrName;
	// 质控体系段落名称
	@DictionaryTag(code = "qaSystemSegmentCode", objCd = "QAK04")
	private String qaSystemSegmentName;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getQaSystemMrCode() {
		return this.qaSystemMrCode;
	}

	public void setQaSystemMrCode(String qaSystemMrCode) {
		this.qaSystemMrCode = qaSystemMrCode;
	}

	public String getQaSystemSegmentCode() {
		return this.qaSystemSegmentCode;
	}

	public void setQaSystemSegmentCode(String qaSystemSegmentCode) {
		this.qaSystemSegmentCode = qaSystemSegmentCode;
	}

	public String getQaSystemAmrCode() {
		return this.qaSystemAmrCode;
	}

	public void setQaSystemAmrCode(String qaSystemAmrCode) {
		this.qaSystemAmrCode = qaSystemAmrCode;
	}

	public String getRequirement() {
		return this.requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getQaDropScoreTypeCode() {
		return this.qaDropScoreTypeCode;
	}

	public void setQaDropScoreTypeCode(String qaDropScoreTypeCode) {
		this.qaDropScoreTypeCode = qaDropScoreTypeCode;
	}

	public BigDecimal getOnceDropScore() {
		return onceDropScore;
	}

	public void setOnceDropScore(BigDecimal onceDropScore) {
		this.onceDropScore = onceDropScore;
	}

	public BigDecimal getMaxDropScore() {
		return maxDropScore;
	}

	public void setMaxDropScore(BigDecimal maxDropScore) {
		this.maxDropScore = maxDropScore;
	}

	public Integer getDefaultReformFlag() {
		return this.defaultReformFlag;
	}

	public void setDefaultReformFlag(Integer defaultReformFlag) {
		this.defaultReformFlag = defaultReformFlag;
	}

	public Integer getAutoQaFlag() {
		return this.autoQaFlag;
	}

	public void setAutoQaFlag(Integer autoQaFlag) {
		this.autoQaFlag = autoQaFlag;
	}

	public String getQaDropScoreTypeName() {
		return this.qaDropScoreTypeName;
	}

	public void setQaDropScoreTypeName(String qaDropScoreTypeName) {
		this.qaDropScoreTypeName = qaDropScoreTypeName;
	}

	public String getQaItemTypeCode() {
		return this.qaItemTypeCode;
	}

	public void setQaItemTypeCode(String qaItemTypeCode) {
		this.qaItemTypeCode = qaItemTypeCode;
	}

	public String getQaItemTypeName() {
		return this.qaItemTypeName;
	}

	public void setQaItemTypeName(String qaItemTypeName) {
		this.qaItemTypeName = qaItemTypeName;
	}

	public String getQaSystemMrName() {
		return this.qaSystemMrName;
	}

	public void setQaSystemMrName(String qaSystemMrName) {
		this.qaSystemMrName = qaSystemMrName;
	}

	public String getQaSystemSegmentName() {
		return this.qaSystemSegmentName;
	}

	public void setQaSystemSegmentName(String qaSystemSegmentName) {
		this.qaSystemSegmentName = qaSystemSegmentName;
	}

}