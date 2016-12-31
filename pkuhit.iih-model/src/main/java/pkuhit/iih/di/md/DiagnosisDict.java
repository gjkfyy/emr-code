package pkuhit.iih.di.md;

import xap.sv.annotation.Column;
import xap.model.BaseMasterModel;

public class DiagnosisDict extends BaseMasterModel {

	public DiagnosisDict() {
		super();
	}

	public DiagnosisDict(String code) {
		super(code);
	}

	public static final String OBJ_CD = "DIM01";

	// 诊断编码
	public static final String CODE = "DIM01.AT01";
	// 组织机构编码
	public static final String ORGANIZATION_CODE = "DIM01.AT02";
	// 名称
	public static final String NAME = "DIM01.AT03";
	// 描述
	public static final String DESCRIPTION = "DIM01.AT04";
	// ICD编码
	public static final String ICD_CODE = "DIM01.AT05";
	// 传染病标志
	public static final String INFECTIOUS_FLAG = "DIM01.AT06";
	// 症状标志
	public static final String SYMPTOM_FLAG = "DIM01.AT07";

	// 诊断编码
	@Column(name = "DI_CD")
	private String code;

	// 组织机构编码
	@Column(name = "ORG_CD")
	private String organizationCode;

	// 名称
	@Column(name = "NM")
	private String name;

	// 描述
	@Column(name = "DES")
	private String description;

	// ICD编码
	@Column(name = "ICD_CD")
	private String icdCode;

	// 传染病标志
	@Column(name = "INF_F")
	private Integer infectiousFlag;

	// 症状标志
	@Column(name = "SYM_F")
	private Integer symptomFlag;
	// 组织机构名称
	// @DictionaryTag(code = "organizationCode")
	private String organizationName;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrganizationCode() {
		return this.organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
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

	public String getIcdCode() {
		return this.icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public Integer getInfectiousFlag() {
		return this.infectiousFlag;
	}

	public void setInfectiousFlag(Integer infectiousFlag) {
		this.infectiousFlag = infectiousFlag;
	}

	public Integer getSymptomFlag() {
		return this.symptomFlag;
	}

	public void setSymptomFlag(Integer symptomFlag) {
		this.symptomFlag = symptomFlag;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

}