package pkuhit.iih.mr.pub;

public class MessageCode {
	/** 
	 * 病案处于【】状态，不可编辑
	 */
	public static final   String  UN_EDIT_AMR_STA = "MR.MSG.0001";
	/** 
	 * 病历书写已完成，不可编辑
	 */
	public static final   String  UN_EDIT_COMP = "MR.MSG.0002";
	/** 
	 * 病历处于锁定状态，不可编辑
	 */
	public static final   String  UN_EDIT_LOCK = "MR.MSG.0003";
	/**
	 * 处于驳回处理中，不可编辑
	 */
	public static final   String  UN_EDIT_REJECT = "MR.MSG.0004";
	/**
	 * 病历当前状态，不可编辑
	 */
	public static final   String  UN_EDIT_MR_STA = "MR.MSG.0005";
	/**
	 * 审签级别不能对【...】的病历文书签字，不可编辑！
	 */
	public static final   String  UN_EDIT_SIGN_LVL = "MR.MSG.0006";
	/**
	 * 当前病历处于【...】质控状态，不可编辑
	 */
	public static final   String  UN_EDIT_QA_STA = "MR.MSG.0007";
	/**
	 * 审签级别不符，不可签名
	 */
	public static final   String  UN_SIGN_SIGN_LVL = "MR.MSG.0008";
	/**
	 * 当前病历处于【...】质控状态，不可撤销签名
	 */
	public static final   String  UN_CANCEL_SIGN_QA_STA = "MR.MSG.0009";
	/**
	 * 最后一个签名不符不是您，不可撤销签名
	 */
	public static final   String  UN_CANCEL_LAST_SIGNER = "MR.MSG.0010";
	/**
	 * 新建状态，不可驳回
	 */
	public static final   String  UN_REJECT_CREAT = "MR.MSG.0011";
	/**
	 * 状态，不可打印
	 */
	public static final   String  UN_PRINT_MR_STA = "MR.MSG.0012";
	/**
	 * 状态不可删除，仅在新建状态可删除！
	 */
	public static final   String  UN_DEL_MR_STA = "MR.MSG.0013";
	/**
	 * 非创建者也非最后更新者，不可删除
	 */
	public static final   String  UN_DEL_CREAT_LAST_UPDATE = "MR.MSG.0014";
	/**
	 * 非编辑锁定且最后更新者不是是用户自己，不可保存
	 */
	public static final   String  UN_SAVE_NOLOCK_LAST_UPDATE = "MR.MSG.0015";
	/** 
	 * 因病案状态为“已归档”，不能操作质控工作记录
	 */
	public static final   String  UN_OPERATE_AMR_STA = "MR.MSG.0016";
	/**
	 * 病历业务文件不存在
	 */
	public static final   String  BIZ_FILE_NO_EXITS = "MR.MSG.0017";
	/** 
	 * 参数{0}不能为空
	 */
	public static final String MISS_PARAM = "MR_10010";
	/** 
	 * 参数{0}的值不正确
	 */
	public static final String VALID_PARAM = "MR_10020";
	/** 
	 * 数据对象不存在
	 */
	public static final String NOT_EXIST = "MR_10030";
	/**
	 * 只能处理【新建状态，已驳回】的组合元素
	 */
	public static final String UN_EDITABLE_GE = "MR_10040";
	/**
	 * 只能处理【启用，停用】的基础模板，病历模板，组合元素
	 */
	public static final String UN_UPGRADE_TEMPLATE= "MR.MSG.0018";
	/**
	 * 只能处理【新建】的基础模板，病历模板，组合元素
	 */
	public static final String UN_UPDATE_TEMPLATE= "MR.MSG.0019";
	/**
	 * 病历文书状态，不可撤销签名
	 */
	public static final String UN_CANCEL_MR_STA= "MR.MSG.0020";
	/**
	 * 您未审签过该病历，不可进行整改！
	 */
	public static final   String  UN_EDIT_NOT_SIGN_DOCTOR = "MR.MSG.0021";
	/** 
	 * 病历为新建状态，创建者不是您不可编辑！
	 */
	public static final   String  UN_EDIT_NOT_CREATER = "MR.MSG.0022";
	/**
	 * 您不是创建者，不能进行提交操作！
	 */
	public static final   String  UN_SIGN_NOT_CREATER = "MR.MSG.0023";
	/**
	 * 病历状态不可审签！
	 */
	public static final   String  UN_APPROVE_MR_STA = "MR.MSG.0024";
	/**
	 * 病历状态不可提交！
	 */
	public static final   String  UN_SIGN_MR_STA = "MR.MSG.0025";
	/**
	 * 提交人是自己不可审签！
	 */
	public static final   String  UN_APPROVE_SUB_SELF = "MR.MSG.0026";
	/**
	 * 病案状态，不可撤销签名！
	 */
	public static final   String  UN_CANCEL_SIGN_AMR_STA = "MR.MSG.0027";
	/**
	 * 病历已完成不可开始审签！
	 */
	public static final   String  UN_START_APPROVE_MR_COMP = "MR.MSG.0028";
	/**
	 * 乐观锁控制异常,可能其他人已经修改此记录！
	 */
	public static final String OPTIMISTIC_LOCK = "MR.MSG.0029";
	/**
	 * 病案信息不存在，请联系系统管理员！
	 */
	public static final   String  AMR_NOT_EXITS = "MR.MSG.0030";
	/**
	 * 该病历不需要审签！
	 */
	public static final   String  NOT_NEED_APPROVE = "MR.MSG.0031";
	/**
	 * 已经存在，不可新建！
	 */
	public static final   String  CAN_NOT_CREATE = "MR.MSG.0032";
	/**
	 * 病历已超过时间限制，不可修改！
	 */
	public static final   String  UN_EDIT_TIME_OUT = "MR.MSG.0033";
	/**
	 * 非创建者，不可打印！
	 */
	public static final   String  UN_PRINT_NOT_CREATOR = "MR.MSG.0034";
	/**
	 * 所配置的门诊处方小模板不存在！
	 */
	public static final   String  OUT_PRESCRIPTION_TEMPLATE_NOT_EXITS = "MR.MSG.0035";
	/**
	 * 所配置的门诊处方处置占位小模板不存在！
	 */
	public static final   String  OUT_PRESCRIPTION_AND_PRESCRIPTION_SIGN_TEMPLATE_NOT_EXITS = "MR.MSG.0036";
	/**
	 * 请联系系统管理员配置门诊处方小模板！
	 */
	public static final   String  OUT_PRESCRIPTION_TEMPLATE_NOT_SET = "MR.MSG.0037";
	/**
	 * 请联系系统管理员配置门诊处方处置占位小模板！
	 */
	public static final   String  OUT_PRESCRIPTION_AND_PRESCRIPTION_SIGN_TEMPLATE_NOT_SET = "MR.MSG.0038";
	/**
	 * 请联系系统管理员配置门诊处方占位小模板！
	 */
	public static final   String  OUT_PRESCRIPTION_SIGN_TEMPLATE_NOT_SET = "MR.MSG.0039";
	/**
	 * 请联系系统管理员配置门诊处置占位小模板！
	 */
	public static final   String  OUT_DISPOSAL_SIGN_TEMPLATE_NOT_SET = "MR.MSG.0040";
	/**
	 * 病历已经签章不能修改！
	 */
	public static final   String  CAN_NOT_UPDATE_BY_CA = "MR.MSG.0041";
	/**
	 * 所配置的门诊处方占位小模板不存在！
	 */
	public static final   String  OUT_PRESCRIPTION_SIGN_TEMPLATE_NOT_EXITS = "MR.MSG.0042";
	/**
	 * 请联系管理员进行归档上传接口相关设置！
	 */
	public static final   String  MR_ARCHIVE_UPLOAD_CONFIG = "MR.MSG.0043";
	/**
	 * 归档接口配置中{0}有误！
	 */
	public static final   String  MR_ARCHIVE_UPLOAD_CONFIG_ERROR = "MR.MSG.0044";
	/**
	 * 归档文件异常，请重新操作！
	 */
	public static final   String  MR_ARCHIVE_UPLOAD_FILE_ERROR = "MR.MSG.0045";
	/**
	 * 请设置归档类型参数！
	 */
	public static final   String  ARCHIVE_TYPE_PARAM_CONFIG = "MR.MSG.0046";
	/**
	 * 用户{0}签名图片为空！
	 */
	public static final   String  USE_SGIN_PIC_NULL = "MR.MSG.0047";
	/**
	 * 请联系系统管理员配置门诊中成药处方小模板！
	 */
	public static final   String  OUT_CPM_PRESCRIPTION_TEMPLATE_NOT_SET = "MR.MSG.0048";
	/**
	 * 获取文件失败
	 */
	public static final String FILE_GET_FATAL = "MR_10060";
	
	/**
	 * 没有权限
	 */
	public static final String CANNOT_OPERATE_NO_PRI = "MR_10070";
	/**
	 * 没有未完成的质控工作记录
	 */
	public static final String NO_UNCOMPLETED_QARECORD = "QA_NO_UNCOMPLETED_QARECORD";
	
	/**
	 * 存在未确认结果的（非扣分，不扣分）缺陷
	 */
	public static final String  UN_FLT_CFM_RST= "QA.MSG.0001";
	
	public static final String  EXIST_TOREFORM_FAULT= "QA.MSG.0002";
	public static final String  EXIST_REFORMED_FAULT= "QA.MSG.0003";
	public static final String  COMPLETED_REVISION_NOTICE= "QA.MSG.0004";
	/**
	 * 请联系系统管理员配置门诊中成药处方占位小模板！
	 */
	public static final String OUT_CPM_PRESCRIPTION_SIGN_TEMPLATE_NOT_SET = "MR.MSG.0049";
	/**
	 * 请联系系统管理员配置{}！
	 */
	public static final String NOT_SET = "MR.MSG.0050";
	/**
	 * 配置门诊病历提交后是否允许撤回
	 */
	public static final String OMR_SUBMIT_CHECK_REVOKE = "MR.MSG.0051";
	
	/**
	 * 文件保存失败,请重试保存
	 * */
	public static final String FILE_UPDATE_FAILURE = "MR.MSG.0052" ;
	
}
