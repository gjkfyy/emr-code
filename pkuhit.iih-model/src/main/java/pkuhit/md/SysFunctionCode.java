package pkuhit.md;

public class SysFunctionCode {
	/**
	 * 门诊病历提交后是否允许撤回
	 */
	public static final String OMR_REVORKE_ENABLE = "SYSM01.0";
	/**
	 * 是否启用就诊组
	 */
	public static final String AMR_GROUP_ENABLE = "SYSM01.1";
	/**
	 * 是否启用组套
	 */
	public static final String CSA_ENABLE = "SYSM01.2";
	/**
	 * 诊断是否同步到HIS
	 */
	public static final String DIAGNOSTIC_AUTO_TO_HIS = "SYSM01.3";
	/**
	 * 诊断是否同步到HIS中
	 */
//	public static final String DIAGNOSTIC_AUTO_TO_HIS_ENABLE = "SYSM01.4";
	/**
	 * 门诊处方小模板设置
	 */
	public static final String OUT_PRESCRIPTION_TEMPLATE_CONFIG = "SYSM01.5";
	/**
	 * 不启用自动刷新处方处置科室
	 */
	public static final String NOT_AUTO_REFRESH_PRESCRIPTION_DEPT = "SYSM01.6";
	/**
	 * 是否启用提交撤回流程
	 */
	public static final String SUBMIT_REVOKE_ENABLE = "SYSM01.7";
	/**
	 * 按类别选择模板查询条件配置
	 */
	public static final String SEARCH_TEMPLATE_CONFIG = "SYSM01.8";
	/**
	 * 门诊处方处置占位小模板
	 */
	public static final String OUT_DISPOSAL_AND_PRESCRIPTION_SIGN_TEMPLATE_CONFIG = "SYSM01.9";
	/**
	 * 门诊处方占位小模板设置
	 */
	public static final String OUT_PRESCRIPTION_SIGN_TEMPLATE_CONFIG = "SYSM01.10";
	/**
	 * 门诊中成药处方小模板设置
	 */
	public static final String OUT_CPM_PRESCRIPTION_TEMPLATE_CONFIG = "SYSM01.20";
	/**
	 * 门诊中成药处方占位小模板设置
	 */
	public static final String OUT_CPM_PRESCRIPTION_SIGN_TEMPLATE_CONFIG = "SYSM01.21";
	/**
	 * 门诊中草药非协定处方小模板设置
	 */
	public static final String OUT_CFXD_PRESCRIPTION_TEMPLATE_CONFIG = "SYSM01.22";
	/**
	 * 门诊处置占位小模板设置
	 */
	public static final String OUT_DISPOSAL_SIGN_TEMPLATE_CONFIG = "SYSM01.11";
	/**
	 * 自动归档时间配置
	 */
	public static final String AUTO_AMR_ARCHIVED_CONFIG = "SYSM01.12";
	/**
	 * 补充自动质控配置
	 */
	public static final String QA_AUTO_CONFIG = "SYSM01.13";
	/**
	 * 补充自动质控配置
	 */
	public static final String IEMR_VERSION = "SYSM01.14";
	/**
	 * 病历修改时间限制设置
	 */
	public static final String MR_UPDATE_TIME_LIMIT_CONFIG = "SYSM01.15";
	/**
	 * 配置就诊源的位置  0-本库   1-his 2-cis 3
	 */
	public static final String DATA_SOURCE = "SYSM01.16";
	
	/**
	 * 配置助手检查检验数据来源 cis his tocis
	 */
	public static final String ASS_SOURCE = "SYSM01.17";
	/**
	 * 配置病例归档路径
	 */
	public static final String EMR_WRITER_FILE_PATH = "SYSM01.19";
	/**
	 * 配置自助打印次数
	 */
	public static final String EMR_SELF_PRINT_NUMBER = "SYSM01.23";
	
	/**
	 * 配置调用其它病历路径
	 */
	public static final String OTHER_EMR_PATH = "SYSM01.24";
	
	/**
	 * 配置调用His处方录入等功能
	 */
	public static final String EMR_CALL_CIS = "SYSM01.25";
	
	/**
	 * 配置用户同步时，是否同步用户密码功能
	 */
	public static final String SYNC_USER_PWD = "SYSM01.26";
	
	/**
	 * 获取消息时时限类型截止时间前多长时间进行提醒
	 */
	public static final String MESSAGE_REMIND_LASTTIME = "SYSM01.28";
	
	/**
	 * 配置住院患者列表：读视图or读本地mr_amr表
	 */
	public static final String IN_PATIENT_VIEW = "SYSM01.29";
}