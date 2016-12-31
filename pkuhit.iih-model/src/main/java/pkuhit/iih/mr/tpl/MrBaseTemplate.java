package pkuhit.iih.mr.tpl;

import java.math.BigInteger;
import java.sql.Timestamp;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class MrBaseTemplate extends BaseMasterModel {

	public MrBaseTemplate() {

		super();

	}

	public MrBaseTemplate(String code) {

		super(code);

	}

	public static final String OBJ_CD = "MRK01";

	// 医疗记录基础模板编码
	public static final String CODE = "MRK01.AT01";
	// 组织机构编码
	public static final String ORGANIZATION_CODE = "MRK01.AT02";
	// 文件主键
	public static final String FILE_PK = "MRK01.AT03";
	// 根医疗记录基础模板编码
	public static final String ROOT_CODE = "MRK01.AT04";
	// 版本号
	public static final String VERSION_NO = "MRK01.AT05";
	// 医疗记录基础模板状态编码
	public static final String STATUS_CODE = "MRK01.AT06";
	// 名称
	public static final String NAME = "MRK01.AT07";
	// 描述
	public static final String DESCRIPTION = "MRK01.AT08";
	// 纸张类型编码
	public static final String PAPER_TYPE_CODE = "MRK01.AT11";

	// 医疗记录基础模板编码
	@Column(name = "MR_BASE_TPL_CD")
	private String code;

	// 组织机构编码
	@Column(name = "ORG_CD")
	private String organizationCode;

	// 文件主键
	@Column(name = "FILE_PK")
	private String filePk;

	// 根医疗记录基础模板编码
	@Column(name = "RT_MR_BASE_TPL_CD")
	private String rootCode;

	// 版本号
	@Column(name = "VER_NO")
	private BigInteger versionNo;

	// 医疗记录基础模板状态编码
	@Column(name = "MR_BASE_TPL_STA_CD")
	private String statusCode;

	// 名称
	@Column(name = "NM")
	private String name;

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

	// 创建人名称
	@DictionaryTag(code = "lastUpdateUserId", objCd = "ORGB04")
	private String lastUpdateUserName;

	// 描述
	@Column(name = "DES")
	private String description;
	// 组织机构名称
	// @DictionaryTag(code = "organizationCode",objCd ="ORGB01")
	private String organizationName;
	// 医疗记录基础模板状态名称
	@DictionaryTag(code = "statusCode", objCd = "MRM06")
	private String statusName;

	// 纸张类型编码
	@Column(name = "PAPER_TP_CD")
	private String paperTypeCode;
	// 纸张类型名称
	@DictionaryTag(code = "paperTypeCode", objCd = "MDM07")
	private String paperTypeName;
	// 可删除标志
	private Integer canDelete;
	// 可停用标志
	private Integer canStop;
	// 可升级标志
	private Integer canUpgrade;
	// 可启用标志
	private Integer canActivated;
	// 可更新标志
	private Integer canUpdate;
	// 可应用标志
	private Integer canAapply;

	public Integer getCanAapply() {
		return canAapply;
	}

	public void setCanAapply(Integer canAapply) {
		this.canAapply = canAapply;
	}

	public Integer getCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(Integer canUpdate) {
		this.canUpdate = canUpdate;
	}

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

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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

	public Integer getCanStop() {
		return this.canStop;
	}

	public void setCanStop(Integer canStop) {
		this.canStop = canStop;
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
	
	

}