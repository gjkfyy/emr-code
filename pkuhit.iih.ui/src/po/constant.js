Ext.define('IMER_CONSTANT', {
	singleton: true,
	
	TOP_HEIGHT: 80,
	ASSISTANT_HEIGHT: 150,
	PORTALLEFT_WIDTH: 200,
	WORKAREA_PADDING: 40,
	WORKAREA_MIN_WIDTH: 740,
	WORKAREA_MIN_HEIGHT: 250,
	BUTTON_MIN_WIDTH: 75,
	BUTTON_MIN_HEIGHT: 21,
	QUERY_COLUMNS: 4,
	PORTLET_WIDTH: 340,
	PORTLET_HEIGHT: 340,
	
	CONSTRAIN_WIDTH: 800,
	CONSTRAIN_HEIGHT: 600,
	FIXED_WIDTH: 242,		//2*parseInt(WORKAREA_PADDING) + PORTALLEFT_WIDTH + 2,
	WORKAREA_WIDTH: 400,	//CONSTRAIN_WIDTH - FIXED_WIDTH,
	BODY_TOP_PADDING: '5 0 0 0',
	BODY_LEFT_PADDING: '0 5 0 0',
	
	SYSTEMNAME: '病例管理系统V1.0',
	VERSION: '(版本2.2.2.75.20170101)',
	IP: '(Server:localhost:8081)',

	//CLIENT: 'browser',
	CLIENT: 'webkit',
	
	FORM_URL: '',
	
	SERVER_URL: 'http://172.18.96.226:8080/AjaxPatient.json',
	
	/********************宏元素编码********************/
	//姓名
    MR_ELEMENT_CD_1 :'MR.M.013.D.1',
    //  性别
    MR_ELEMENT_CD_2 : 'MR.M.013.D.2',
    //  年龄
    MR_ELEMENT_CD_3 : 'MR.M.013.D.3',
    //  婚姻状况
    MR_ELEMENT_CD_4 : 'MR.M.013.D.4',
    //  民族
    MR_ELEMENT_CD_5 : 'MR.M.013.D.5',
    //  职业
    MR_ELEMENT_CD_6 : 'MR.M.013.D.6',
    //  出生地
    MR_ELEMENT_CD_7 : 'MR.M.013.D.7',
    //  工作单位
    MR_ELEMENT_CD_8 : 'MR.M.013.D.8',
    //  身份证号
    MR_ELEMENT_CD_9 : 'MR.M.013.D.9',
    //现住址
    MR_ELEMENT_CD_10 : 'MR.M.013.D.10',
    //电话
    MR_ELEMENT_CD_11 : 'MR.M.013.D.11',
    //ID号
    MR_ELEMENT_CD_12 : 'MR.M.013.D.12',
    //住院号
    MR_ELEMENT_CD_13 : 'MR.M.013.D.13',
    //住院次
    MR_ELEMENT_CD_14 : 'MR.M.013.D.14',
    //床号
    MR_ELEMENT_CD_15 : 'MR.M.013.D.15',
    //入院日期
    MR_ELEMENT_CD_16 : 'MR.M.013.D.16',
    //出院日期
    MR_ELEMENT_CD_17 : 'MR.M.013.D.17',
    //科室
    MR_ELEMENT_CD_18 : 'MR.M.013.D.18',
    //病区
    MR_ELEMENT_CD_19 : 'MR.M.013.D.19',
    //住院目的
    MR_ELEMENT_CD_20 : 'MR.M.013.D.20',
    //入院情况
    MR_ELEMENT_CD_21 : 'MR.M.013.D.21',
    //主要诊断
    MR_ELEMENT_CD_22 : 'MR.M.013.D.22',
    //费别
    MR_ELEMENT_CD_23 : 'MR.M.013.D.23',
    //主任医师
    MR_ELEMENT_CD_24 : 'MR.M.013.D.24',
    //主治医师
    MR_ELEMENT_CD_25 : 'MR.M.013.D.25',
    //住院医师
    MR_ELEMENT_CD_26 : 'MR.M.013.D.26',
    //医师签名
    MR_ELEMENT_CD_27 : 'MR.M.013.D.27',
    //业务时间
    MR_ELEMENT_CD_28 : 'MR.M.013.D.28',
    //业务时间
    MR_ELEMENT_CD_29 : 'MR.M.013.D.29',
    //心率
    MR_ELEMENT_CD_30 : 'MR.M.013.D.30',
    //体重
    MR_ELEMENT_CD_31 : 'MR.M.013.D.31',
    //上级医生
    MR_ELEMENT_CD_32 : 'MR.M.013.D.32',
    //门诊卡号
    MR_ELEMENT_CD_33 : 'MR.M.013.D.33',
    //血氧
    MR_ELEMENT_CD_34 : 'MR.M.013.D.34',
    //患者ID
    MR_ELEMENT_CD_35 : 'MR.M.013.D.35',
    //就诊日期
    MR_ELEMENT_CD_36 : 'MR.M.013.D.36',
    //护士签名
    MR_ELEMENT_CD_37 : 'MR.M.013.D.37',
    //二级护士签名
    MR_ELEMENT_CD_38 : 'MR.M.013.D.38',
    //三级护士签名
    MR_ELEMENT_CD_39 : 'MR.M.013.D.39',
    //体温
    MR_ELEMENT_CD_101 : 'MR.M.013.D.101',
    //呼吸
    MR_ELEMENT_CD_102 : 'MR.M.013.D.102',
    //脉搏
    MR_ELEMENT_CD_103 : 'MR.M.013.D.103',
    //收缩压
    MR_ELEMENT_CD_104 : 'MR.M.013.D.104',
    //舒张压
    MR_ELEMENT_CD_105 : 'MR.M.013.D.105',
    //上级查房医师名称
    MR_ELEMENT_CD_106 : 'MR.M.013.D.106',
    //门诊卡号
    MR_ELEMENT_CD_107 : 'MR.M.013.D.107',
    //急诊病历编号
    MR_ELEMENT_CD_110 : 'MR.M.013.D.110',
    //全部诊断
    MR_ELEMENT_CD_111 : 'MR.M.013.D.111',
    //户口地址
    MR_ELEMENT_CD_115 : 'MR.M.013.D.115',
    
    //Braden评估分
    MR_ELEMENT_CD_117 : 'MR.M.013.D.117',
    //Barther评估分
    MR_ELEMENT_CD_118 : 'MR.M.013.D.118',
    //Fall评估分
    MR_ELEMENT_CD_119 : 'MR.M.013.D.119',
    //CATHETHER评估分
    MR_ELEMENT_CD_120 : 'MR.M.013.D.120',
    //病人来源
    MR_ELEMENT_CD_121 : 'MR.M.013.D.121',
    //病人诊断
    MR_ELEMENT_CD_122 :'MR.M.013.D.122',
    //护理级别
    MR_ELEMENT_CD_123 :'MR.M.013.D.123',
    
    //联系人
    MR_ELEMENT_CD_124 :'MR.M.013.D.124',
    //与患者关系
    MR_ELEMENT_CD_125 :'MR.M.013.D.125',
    //联系人电话
    MR_ELEMENT_CD_126 :'MR.M.013.D.126',
    
    /***************************医疗记录类型编码****************************/
    //病案首页
    MRM_MR_TYPE_CD_1 : 'MRM003.1',
    //初次入院记录
    MRM_MR_TYPE_CD_2 : 'MRM003.2',
    //首次病程记录
    MRM_MR_TYPE_CD_3 : 'MRM003.3',
    //日常病程记录
    MRM_MR_TYPE_CD_4 : 'MRM003.4',
    //抢救记录
    MRM_MR_TYPE_CD_5 : 'MRM003.5',
    //交（接）班记录
    MRM_MR_TYPE_CD_6 : 'MRM003.6',
    //转科记录
    MRM_MR_TYPE_CD_7 : 'MRM003.7',
    //阶段小结
    MRM_MR_TYPE_CD_8 : 'MRM003.8',
    //会诊记录
    MRM_MR_TYPE_CD_9 : 'MRM003.9',
    //疑难病例讨论记录
    MRM_MR_TYPE_CD_10 : 'MRM003.10',
    //有创诊疗操作记录
    MRM_MR_TYPE_CD_11 : 'MRM003.11',
    //上级医师首次查房记录
    MRM_MR_TYPE_CD_12 : 'MRM003.12',
    //专科病历
    MRM_MR_TYPE_CD_13 : 'MRM003.13',
    //手术记录
    MRM_MR_TYPE_CD_14 : 'MRM003.14',
    //术前讨论记录
    MRM_MR_TYPE_CD_15 : 'MRM003.15',
    //死亡记录
    MRM_MR_TYPE_CD_16 : 'MRM003.16',
    //出院记录
    MRM_MR_TYPE_CD_17 : 'MRM003.17',
    //基本要求及医嘱单
    MRM_MR_TYPE_CD_18 : 'MRM003.18',
    //手术知情同意书
    MRM_MR_TYPE_CD_19 : 'MRM003.19',
    //麻醉知情同意书
    MRM_MR_TYPE_CD_20 : 'MRM003.20',
    //病危（重）通知书
    MRM_MR_TYPE_CD_21 : 'MRM003.21',
    //输血治疗知情同意书
    MRM_MR_TYPE_CD_22 : 'MRM003.22',
    //三测单
    MRM_MR_TYPE_CD_23 : 'MRM003.23',
    //医嘱单
    MRM_MR_TYPE_CD_24 : 'MRM003.24',
    //护理记录
    MRM_MR_TYPE_CD_25 : 'MRM003.25',
    //再次或多次入院记录
    MRM_MR_TYPE_CD_26 : 'MRM003.26',
    //门(急)诊复诊病历
    MRM_MR_TYPE_CD_27 : 'MRM003.27',
    //门(急)诊初诊病历
    MRM_MR_TYPE_CD_28 : 'MRM003.28',
    //24小时内出入院记录
    MRM_MR_TYPE_CD_29 : 'MRM003.29',
    //24小时内入院死亡记录
    MRM_MR_TYPE_CD_30 : 'MRM003.30',
    //上级医师日常查房记录
    MRM_MR_TYPE_CD_31 : 'MRM003.31',
    //术前小结
    MRM_MR_TYPE_CD_32 : 'MRM003.32',
    //麻醉记录
    MRM_MR_TYPE_CD_33 : 'MRM003.33',
    //手术记录
    MRM_MR_TYPE_CD_34 : 'MRM003.34',
    //手术清点记录
    MRM_MR_TYPE_CD_35 : 'MRM003.35',
    //手术安全核查记录
    MRM_MR_TYPE_CD_36 : 'MRM003.36',
    //术后首次病程记录
    MRM_MR_TYPE_CD_37 : 'MRM003.37',
    //麻醉术后访视记录
    MRM_MR_TYPE_CD_38 : 'MRM003.38',
    //死亡病例讨论记录
    MRM_MR_TYPE_CD_39 : 'MRM003.39',
    //其他知情同意书
    MRM_MR_TYPE_CD_40 : 'MRM003.40',
    //手术记录
    MRM_MR_TYPE_CD_41 : 'MRM003.41',
    //有创诊疗操作记录
    MRM_MR_TYPE_CD_42 : 'MRM003.42',
    //手术同意书
    MRM_MR_TYPE_CD_43 : 'MRM003.43',
    //麻醉同意书
    MRM_MR_TYPE_CD_44 : 'MRM003.44',
    //输血治疗知情同意书
    MRM_MR_TYPE_CD_45 : 'MRM003.45',
    //麻醉记录
    MRM_MR_TYPE_CD_46 : 'MRM003.46',
    //病危（病重）通知书
    MRM_MR_TYPE_CD_47 : 'MRM003.47',
    //其他知情同意书
    MRM_MR_TYPE_CD_48 : 'MRM003.48',
    //诊断证明书
    MRM_MR_TYPE_CD_49 : 'MRM003.49',
    //出院证明书
    MRM_MR_TYPE_CD_50 : 'MRM003.50',
    //死亡证明
    MRM_MR_TYPE_CD_51 : 'MRM003.51',
    //转诊申请单
    MRM_MR_TYPE_CD_52 : 'MRM003.52',
    //休假证明书
    MRM_MR_TYPE_CD_53 : 'MRM003.53',
    //留观登记
    MRM_MR_TYPE_CD_54 : 'MRM003.54',
    
    /***************************医疗记录自定义类型编码****************************/
    //门诊病历
    MRM_MR_CUST_CLA_CD_1 : 'MRM002.1',
    //入院记录
    MRM_MR_CUST_CLA_CD_2 : 'MRM002.2',
    //病程记录
    MRM_MR_CUST_CLA_CD_3 : 'MRM002.3',
    //会诊资料
    MRM_MR_CUST_CLA_CD_4 : 'MRM002.4',
    //手术资料
    MRM_MR_CUST_CLA_CD_5 : 'MRM002.5',
    //手术资料
    MRM_MR_CUST_CLA_CD_6 : 'MRM002.6',
    //知情同意书
    MRM_MR_CUST_CLA_CD_7 : 'MRM002.7',
    //讨论记录
    MRM_MR_CUST_CLA_CD_8 : 'MRM002.8',
    //出院(死亡)记录
    MRM_MR_CUST_CLA_CD_9 : 'MRM002.9',
    //辅助检查
    MRM_MR_CUST_CLA_CD_10 : 'MRM002.10',
    //护理文书
    MRM_MR_CUST_CLA_CD_11 : 'MRM002.11',
    //其他
    MRM_MR_CUST_CLA_CD_12 : 'MRM002.12',
    //有创诊疗操作记录
    MRM_MR_CUST_CLA_CD_13 : 'MRM002.13',
    //知情同意书
    MRM_MR_CUST_CLA_CD_14 : 'MRM002.14',
    //有创诊疗操作记录
    MRM_MR_CUST_CLA_CD_15 : 'MRM002.15',
    //其他
    MRM_MR_CUST_CLA_CD_16 : 'MRM002.16',
    /***************************编辑器工具栏id****************************/
    //提交按钮
    EMR_SUMBIT : 'com.founder.iemr.editor.toolbar:emrSubmit',
    //保存按钮
    EMR_SAVE : 'com.founder.iemr.editor.toolbar:emrSave',
    //撤回按钮
    EMR_REVOKE : 'com.founder.iemr.editor.toolbar:emrRevoke',
    //驳回按钮
    EMR_REJECT : 'com.founder.iemr.editor.toolbar:emrReject',
    //审签通过按钮
    EMR_APPROVE: 'com.founder.iemr.editor.toolbar:emrApprove',
    //审签撤回按钮
    EMR_AUDIT_APPROVE: 'com.founder.iemr.editor.toolbar:emrAuditRevoke',
    //删除按钮
    EMR_DOC_DELETE : 'com.founder.iemr.editor.toolbar:emrDocDelete',
    //刷新宏元素按钮
    EMR_REFRESH_MACRO: 'com.founder.iemr.editor.toolbar:emrRefreshMacro',
    //刷新诊断按钮
    EMR_REFRESH_DIAGNOSIS : 'com.founder.iemr.editor.toolbar:emrRefreshDiagnosis',
    //图片库按钮
    EMR_IMAGE_LIB : 'com.founder.iemr.editor.toolbar:emrImageLibraries',
    //月经史公式编辑
    IDD_MEDICAL_HISTORY : 'com.founder.iemr.editor.toolbar:IDD_MEDICAL_HISTORY',
    //续打按钮
    EMR_CONTINUE_PRINT : 'com.founder.iemr.editor.toolbar:emrContinuePrint',
    //选页打印按钮
    EMR_SELECT_CONTINUE_PRINT : 'com.founder.iemr.editor.toolbar:emrSelectContinuePrint',
    //病历另存为模板
    EMR_SAVE_AS_TEMPLATE : 'com.founder.iemr.editor.toolbar:emrSaveAsTemplate',
    //属性
    EMR_DOC_PROPERTY : 'com.founder.iemr.editor.toolbar:emrDocProperty',
    //发布
    EMR_RELEASE : 'com.founder.iemr.editor.toolbar:emrRelease',
    /***************************审签级别编码****************************/
    //无需审签
    NO_REVIEW_LVL : 'MRM005.01',
    //一级审签
    ONE_REVIEW_LVL : 'MRM005.02',
    //二级审签
    TWO_REVIEW_LVL : 'MRM005.03',
    //三级审签
    THREE_REVIEW_LVL : 'MRM005.04',
    /***************************病历文书状态编码****************************/
    //病历文书状态:新建
    MR_DOC_STATUS_CD_1 : 'MR.M.026.D.1',
    //病历文书状态:已提交
    MR_DOC_STATUS_CD_2 : 'MR.M.026.D.2',
    //病历文书状态:已驳回
    MR_DOC_STATUS_CD_3 : 'MR.M.026.D.3',
    //病历文书状态:主治医已审核
    MR_DOC_STATUS_CD_4 : 'MR.M.026.D.4',
    //病历文书状态:主任医生已审核
    MR_DOC_STATUS_CD_5 : 'MR.M.026.D.5',
    /***************************组织结构类型编码****************************/    
    //集团
    ORG_TYPE_CD_1: 'ORGM01.01',
    //院区
    ORG_TYPE_CD_2: 'ORGM01.02',
    //社区
    ORG_TYPE_CD_3: 'ORGM01.03',
    //部门
    ORG_TYPE_CD_4: 'ORGM01.04',
    //工作组
    ORG_TYPE_CD_5: 'ORGM01.05',
    /***************************门户编码****************************/    
    //门急诊病历
    PORTAL_CD_1: 'XAPM06.01',
    //住院医生站（患者）
    PORTAL_CD_2: 'XAPM06.02',
    //病历模板管理
    PORTAL_CD_3: 'XAPM06.03',
    //病历质控平台
    PORTAL_CD_4: 'XAPM06.04',
    //系统管理
    PORTAL_CD_5: 'XAPM06.05',
    //住院医生站（功能）
    PORTAL_CD_6: 'XAPM06.06',
    //病历浏览平台
    PORTAL_CD_7: 'XAPM06.07',
    //门急诊病历(组套)
    PORTAL_CD_8: 'XAPM06.08',
	//第三方病历浏览
    PORTAL_CD_9: 'XAPM06.09',
    //护理病历
    PORTAL_CD_10: 'XAPM06.10',
    //护理管理
    PORTAL_CD_14: 'XAPM06.14',
    //病历管理
    PORTAL_CD_1001: 'XAPM06.1001',
    //高级检索
    PORTAL_CD_1002: 'XAPM06.1002',
    /***************************任务状态编码****************************/    
    //已发送
    TASK_STATUS_CD_1: 'XAPM05.01',
    //已接收
    TASK_STATUS_CD_2: 'XAPM05.02',
    //已完成
    TASK_STATUS_CD_3: 'XAPM05.03',
    /***************************就诊类型编码****************************/    
    //门诊
    OUTPATIENT: 'ENM01.01',
    //急诊
    EMERGENCY: 'ENM01.02',
    //留观
    EMERGENCY_OBSERVATION: 'ENM01.03',
    //住院
    INPATIENT: 'ENM01.04',
    //体检
    PHYSICAL_EXAMINATION: 'ENM01.05',
    /***************************菜单类型****************************/    
    //功能菜单
    MENU_FUNCTION: 'function',
    //病历文书自定义分类
    MENU_MR_CATEGORY: 'mrCustcategory',
    //病历文书
    MENU_MR_DOC: 'mrDoc',
    /***************************资源对象****************************/    
    //基础模板
    BASE_TPL: 'MRK01',
    //病历模板
    MR_TPL: 'MRK02',
    //组合元素
    GROUP_ELEMENT: 'MRK06',
    /***************************菜单编码****************************/    
    //基础模板管理
    BASE_TPL_MGR: 'XAPM07.23',
    //病历模板管理
    MR_TPL_MGR: 'XAPM07.27',
    //组合元素管理
    GROUP_ELEMENT_MGR: 'XAPM07.24',
    /***************************性别编码****************************/    
    //男
    SEX_NAM: 'MDM05.01',
    //女
    SEX_WOMAN: 'MDM05.02',
    /***************************科室编码****************************/
    //住院临床科室
    INP_DEPT: 'ORGM02.01',
    //门诊科室
    OUT_DEPT: 'ORGM02.05',

    /***************************系统配置功能编码****************************/
    //是否启用就诊组
    AMR_GROUP_ENABLE:'SYSM01.1',
    //是否启用组套
    CSA_ENABLE:'SYSM01.2',
    //诊断是否自动提交
    DIAGNOSTIC_AUTO_SUBMIT_ENABLE:'SYSM01.3',
    //诊断是否同步到HIS中
    DIAGNOSTIC_AUTO_TO_HIS_ENABLE:'SYSM01.4',
    /***************************所属类型编码****************************/
    //全院
    OWNERTYPE_HOS: 'MDM08.01',
    //科室
    OWNERTYPE_DEPT: 'MDM08.02',
    //个人
    OWNERTYPE_PERSON: 'MDM08.03',
    /***************************门户编码****************************/
    PORTAL_OUTP:'XAPM06.01',
    PORTAL_OUTPGL:'XAPM06.08',
    PORTAL_INP:'XAPM06.02',
    
    /*************************** 表格类型 ****************************/
    MR_ELEMENT_TYPE_NAME1:'DateTime',
    MR_ELEMENT_TYPE_NAME2:'Number',
    MR_ELEMENT_TYPE_NAME3:'Text',
    MR_ELEMENT_TYPE_NAME4:'SingleSelect',
    MR_ELEMENT_TYPE_NAME5:'MultiSelect',
    MR_ELEMENT_TYPE_NAME6:'Link',
})