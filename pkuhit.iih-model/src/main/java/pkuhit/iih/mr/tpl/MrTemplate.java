package pkuhit.iih.mr.tpl;

import java.math.BigInteger;
import java.sql.Timestamp;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class MrTemplate extends BaseMasterModel {

	public MrTemplate() {

		super();

	}

	public MrTemplate(String code) {

		super(code);

	}

	public static final String OBJ_CD = "MRK02";

	// 医疗记录模板编码
	public static final String CODE = "MRK02.AT01";
	// 组织机构编码
	public static final String ORGANIZATION_CODE = "MRK02.AT02";
	// 医疗记录基础模板编码
	public static final String BASE_TEMPLATE_CODE = "MRK02.AT03";
	// 文件主键
	public static final String FILE_PK = "MRK02.AT04";
	// 根医疗记录模板编码
	public static final String ROOT_CODE = "MRK02.AT05";
	// 版本号
	public static final String VERSION_NO = "MRK02.AT06";
	// 医疗记录模板状态编码
	public static final String STATUS_CODE = "MRK02.AT07";
	// 名称
	public static final String NAME = "MRK02.AT08";
	// 描述
	public static final String DESCRIPTION = "MRK02.AT09";
	// 所属类型编码
	public static final String OWNER_TYPE_CODE = "MRK02.AT10";
	// 所属编码
	public static final String OWNER_CODE = "MRK02.AT11";
	// 纸张类型编码
	public static final String PAPER_TYPE_CODE = "MRK02.AT17";
	// 医疗记录类型编码
	public static final String MR_TYPE_CODE = "MRK02.AT26";
	// 医疗记录类型名称
	public static final String MR_TYPE_NAME = "MRK02.AT27";
	// 就诊类型编码
	public static final String EN_TP_CD = "MRK02.AT28";

	// 就诊类型编码
	@Column(name = "EN_TP_CD")
	private String enTypeCode;

	// 医疗记录模板编码
	@Column(name = "MR_TPL_CD")
	private String code;

	// 组织机构编码
	@Column(name = "ORG_CD")
	private String organizationCode;

	// 医疗记录基础模板编码
	@Column(name = "MR_BASE_TPL_CD")
	private String baseTemplateCode;

	// 文件主键
	@Column(name = "FILE_PK")
	private String filePk;
	
	// 文件主键
	@Column(name = "XML_FILE_PK")
	private String xmlFilePk;

	// 根医疗记录模板编码
	@Column(name = "RT_MR_BASE_TPL_CD")
	private String rootCode;

	// 版本号
	@Column(name = "VER_NO")
	private BigInteger versionNo;

	// 医疗记录模板状态编码
	@Column(name = "MR_TPL_STA_CD")
	private String statusCode;

	// 名称
	@Column(name = "NM")
	private String name;

	// 描述
	@Column(name = "DES")
	private String description;

	// 所属类型编码
	@Column(name = "OWN_TP_CD")
	private String ownerTypeCode;

	// 所属编码
	@Column(name = "OWN_CD")
	private String ownerCode;

	// 创建时间
	@Column(name = "CRT_TIME")
	private Timestamp crtTime;

	// 创建人编码
	@Column(name = "CRT_USER_ID")
	private String createUserId;

	// 创建人名称
	@DictionaryTag(code = "createUserId", objCd = "ORGB04")
	private String createUserName;

	// 创建人编码
	@Column(name = "LAST_UPD_USER_ID")
	private String lastUpdateUserId;
	
	// 默认模板
    @Column(name = "DEFAULT_F")
    private Short defaultF;
    
    private String defaultName;


    // 创建人名称
	@DictionaryTag(code = "lastUpdateUserId", objCd = "ORGB04")
	private String lastUpdateUserName;

	// 组织机构名称
	// @DictionaryTag(code = "organizationCode",objCd ="ORGB01")
	private String organizationName;
	// 医疗记录基础模板名称
	@DictionaryTag(code = "baseTemplateCode", objCd = "MRK01")
	private String baseTemplateName;
	// 医疗记录模板状态名称
	@DictionaryTag(code = "statusCode", objCd = "MRM07")
	private String statusName;
	// 所属类型名称
	@DictionaryTag(code = "ownerTypeCode", objCd = "MDM08")
	private String ownerTypeName;
	// 所属名称
	// @DictionaryTag(code = "ownerCode",objCd ="null")
	private String ownerName;

	// 纸张类型编码
	@Column(name = "PAPER_TP_CD")
	private String paperTypeCode;
	// 纸张类型名称
	@DictionaryTag(code = "paperTypeCode", objCd = "MDM07")
	private String paperTypeName;

	private String[] diCodeArray;// 适应病种数组
	private String[] diNameArray; // 适应病种数组
	private String diCodes; // 适应病种 以,分隔
	private String diNames;// 适应病种 以,分隔

	private String signLevelCode; // 审签等级
	@DictionaryTag(code = "signLevelCode", objCd = "MRM02")
	private String signLevelName;// 审签等级

	private String tplUseTypeCode;// 模板适用类型编码
	private String tplUseTypeName;// 模板适用类型名称
	private String[] tplUseCodeArray;// 模板适用编码数组
	private String[] tplUseNameArray; // 模板适用名称数组
	private String tplUseCodes; // 模板适用编码 以,分隔
	private String tplUseNames;// 模板适用名称 以,分隔

	public String getTplUseTypeCode() {
		return tplUseTypeCode;
	}

	public Timestamp getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Timestamp crtTime) {
		this.crtTime = crtTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public void setTplUseTypeCode(String tplUseTypeCode) {
		this.tplUseTypeCode = tplUseTypeCode;
	}

	public String getTplUseTypeName() {
		return tplUseTypeName;
	}

	public void setTplUseTypeName(String tplUseTypeName) {
		this.tplUseTypeName = tplUseTypeName;
	}

	public String[] getTplUseCodeArray() {
		return tplUseCodeArray;
	}

	public void setTplUseCodeArray(String[] tplUseCodeArray) {
		this.tplUseCodeArray = tplUseCodeArray;
	}

	public String[] getTplUseNameArray() {
		return tplUseNameArray;
	}

	public void setTplUseNameArray(String[] tplUseNameArray) {
		this.tplUseNameArray = tplUseNameArray;
	}

	public String getTplUseCodes() {
		return tplUseCodes;
	}

	public void setTplUseCodes(String tplUseCodes) {
		this.tplUseCodes = tplUseCodes;
	}

	public String getTplUseNames() {
		return tplUseNames;
	}

	public void setTplUseNames(String tplUseNames) {
		this.tplUseNames = tplUseNames;
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

	public String[] getDiCodeArray() {
		return diCodeArray;
	}

	public void setDiCodeArray(String[] diCodeArray) {
		this.diCodeArray = diCodeArray;
	}

	public String[] getDiNameArray() {
		return diNameArray;
	}

	public void setDiNameArray(String[] diNameArray) {
		this.diNameArray = diNameArray;
	}

	public String getDiCodes() {
		return diCodes;
	}

	public void setDiCodes(String diCodes) {
		this.diCodes = diCodes;
	}

	public String getDiNames() {
		return diNames;
	}

	public void setDiNames(String diNames) {
		this.diNames = diNames;
	}
	
	public Short getDefaultF(){
        return defaultF;
    }

    public void setDefaultF(Short defaultF){
        this.defaultF = defaultF;
    }
    
    public String getDefaultName(){
        return defaultName;
    }

    public void setDefaultName(String defaultName){
        this.defaultName = defaultName;
    }

	// 可删除标志
	private Integer canDelete;
	// 可驳回标志
	private Integer canReject;
	// 可升级标志
	private Integer canUpgrade;
	// 可启用标志
	private Integer canActivated;
	// 可提交标志
	private Integer canSubmit;
	// 可审批标志
	private Integer canReview;
	// 可取消审批标志
	private Integer canCancelReview;
	// 可发布标志
	private Integer canPublish;
	// 可停用标志
	private Integer canStop;

	/*
	 * //可审批 private Integer canVerify;
	 * 
	 * public Integer getCanVerify() { return canVerify; }
	 * 
	 * public void setCanVerify(Integer canVerify) { this.canVerify = canVerify;
	 * }
	 */

	public Integer getCanCancelReview() {
		return canCancelReview;
	}

	public void setCanCancelReview(Integer canCancelReview) {
		this.canCancelReview = canCancelReview;
	}

	public Integer getCanPublish() {
		return canPublish;
	}

	public void setCanPublish(Integer canPublish) {
		this.canPublish = canPublish;
	}

	// 可修改标志
	private Integer canUpdate;

	public Integer getCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(Integer canUpdate) {
		this.canUpdate = canUpdate;
	}

	// 医疗记录类型编码
	@Column(name = "MR_TP_CD")
	private String mrTypeCode;

	// 医疗记录类型名称
	@DictionaryTag(code = "mrTypeCode", objCd = "MRM16")
	@Column(name = "MR_TP_NM")
	private String mrTypeName;

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

	public String getBaseTemplateCode() {
		return this.baseTemplateCode;
	}

	public String getEnTypeCode() {
		return enTypeCode;
	}

	public void setEnTypeCode(String enTypeCode) {
		this.enTypeCode = enTypeCode;
	}

	public void setBaseTemplateCode(String baseTemplateCode) {
		this.baseTemplateCode = baseTemplateCode;
	}

	public String getFilePk() {
		return this.filePk;
	}

	public void setFilePk(String filePk) {
		this.filePk = filePk;
	}

	public String getRootCode() {
		return this.rootCode;
	}

	public void setRootCode(String rootCode) {
		this.rootCode = rootCode;
	}

	public BigInteger getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(BigInteger versionNo) {
		this.versionNo = versionNo;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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

	public String getOwnerTypeCode() {
		return this.ownerTypeCode;
	}

	public void setOwnerTypeCode(String ownerTypeCode) {
		this.ownerTypeCode = ownerTypeCode;
	}

	public String getOwnerCode() {
		return this.ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getBaseTemplateName() {
		return this.baseTemplateName;
	}

	public void setBaseTemplateName(String baseTemplateName) {
		this.baseTemplateName = baseTemplateName;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getOwnerTypeName() {
		return this.ownerTypeName;
	}

	public void setOwnerTypeName(String ownerTypeName) {
		this.ownerTypeName = ownerTypeName;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPaperTypeCode() {
		return this.paperTypeCode;
	}

	public void setPaperTypeCode(String paperTypeCode) {
		this.paperTypeCode = paperTypeCode;
	}

	public String getPaperTypeName() {
		return this.paperTypeName;
	}

	public void setPaperTypeName(String paperTypeName) {
		this.paperTypeName = paperTypeName;
	}

	public Integer getCanDelete() {
		return this.canDelete;
	}

	public void setCanDelete(Integer canDelete) {
		this.canDelete = canDelete;
	}

	public Integer getCanReject() {
		return this.canReject;
	}

	public void setCanReject(Integer canReject) {
		this.canReject = canReject;
	}

	public Integer getCanUpgrade() {
		return this.canUpgrade;
	}

	public void setCanUpgrade(Integer canUpgrade) {
		this.canUpgrade = canUpgrade;
	}

	public Integer getCanActivated() {
		return this.canActivated;
	}

	public void setCanActivated(Integer canActivated) {
		this.canActivated = canActivated;
	}

	public Integer getCanSubmit() {
		return this.canSubmit;
	}

	public void setCanSubmit(Integer canSubmit) {
		this.canSubmit = canSubmit;
	}

	public Integer getCanReview() {
		return this.canReview;
	}

	public void setCanReview(Integer canReview) {
		this.canReview = canReview;
	}

	public Integer getCanStop() {
		return this.canStop;
	}

	public void setCanStop(Integer canStop) {
		this.canStop = canStop;
	}

	public String getMrTypeCode() {
		return this.mrTypeCode;
	}

	public void setMrTypeCode(String mrTypeCode) {
		this.mrTypeCode = mrTypeCode;
	}

	public String getMrTypeName() {
		return this.mrTypeName;
	}

	public void setMrTypeName(String mrTypeName) {
		this.mrTypeName = mrTypeName;
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public String getLastUpdateUserName() {
		return lastUpdateUserName;
	}

	public void setLastUpdateUserName(String lastUpdateUserName) {
		this.lastUpdateUserName = lastUpdateUserName;
	}

	public String getXmlFilePk() {
		return xmlFilePk;
	}

	public void setXmlFilePk(String xmlFilePk) {
		this.xmlFilePk = xmlFilePk;
	}

}