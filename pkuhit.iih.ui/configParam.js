Ext.define('CONFIG_PARAM', {
	singleton: true,
	
	/***************************前端开关/按钮 配置 【12】****************************/
	//1	是否启用科室质控
    QA_DEPT_ENABLE:true,
    
	//2	创建病历是否启用质控流程 true启用 false不启用
    CRT_MR_YN_QUALITY:false,
    
    //3	指纹采集器录入    true为显示指纹录入按钮
    FINGERPRINT_BUTTON_SHOW:false,
    
    //4	调用cis处方录入相关
    CALL_ORDER_BUTTON:false,
    
    //5	调用cis诊毕encounterOverBtn
    ENCOUNTER_OVER_BUTTON:false,
    
    //6	调用cis病案首页callPatCaseBtn
    CALL_PAT_CASE_BUTTON:true,
    
    //7	病历助手区 历次就诊门诊病历文书数 显示与否 开关
    OUT_MR_COUNT:true,
    
    //8	病历助手区 历次就诊 住院病历文书数 显示与否 开关
    IN_MR_COUNT:false,
    
    //9 是否启用护士图片签名
    YES_NO_NURSIGN:false,
    
    //10 是否显示【专项病历查询】
    QA_SPECIAL_MR_ENABLE:true,
    
    //11 助手区生命体征是否添加三测单中的内容
    VITAL_MORE_SHOW:true,
      
    //12 质控-科室、终末并行
    QA_DEPT_TERMINAL_PARALLE:true,
      
    //13 质控-护理质控-提缺陷-添加整改人选择框
    QA_RFMUSER_SELECT:true,
    
    /***************************窗口样式调整****************************/
    //1 门诊助手区高度
    ASSISTANT_HEIGHT: 300, //默认300
    
    //2	门诊病历书写左侧病历树栏宽度
    OUT_MR_WRITE_LEFT_WIDTH:200,  //默认220
    
    //3 住院质控工作界面助手区高度
    ASSISTANT_HEIGHT_ZY: 500, //默认500
    
    /***************************显示格式****************************/
    //1	宏元素，就诊日期显示格式
    MR_ELEMENT_RECEIVE_TIME_FORMAT:'yyyy-MM-dd hh:mm',  //默认'yyyy-MM-dd hh:mm'
    
    /********************门诊病历提交是否将电子病历窗口最小化*********************/
    OMR_SUBMIT_WINDOW_IS_MIN: 0,
    
    /********************门诊病历,cis诊毕是否弹出*********************/
    OMR_EN_OVER_IS_FOCUS: 0,
    
    /********************门诊病历,cis诊毕是否提交*********************/
    OMR_EN_OVER_IS_SUBMIT: 1,
    
    /********************门诊病历,cis诊毕是否打印*********************/
    OMR_SUBMIT_IS_PRINT: 0,
    
    /********************门诊病历,新就诊是否默认弹出模板选择界面*********************/
    OMR_IS_POP_SELECT_TEMPLATE: 1,
    
    /***门诊打印日志是否开启（表为MR_PRINT_OP_LOG）**/
    MR_PRINT_OP_LOG_UEE: false,
    
    /***匿名浏览病历平台查询患者是否默认科室，如果默认请设置科室编码，否则为空（六院）**/
    IF_SELECT_DEPT: '',
    
    /***匿名浏览病历平台是否根据住院号查询门诊患者（六院）**/
    IF_SHOW_OUTPATIENT: false,
        
    /***助手区查看其它病历参数设置 0为【患者Id_就诊次数】、1为【住院号_就诊次数】**/
    ASSISTANT_DISTRICT_SEARCH_MR_PARAM_SETUP: 1,
	
	/********************门诊病历,提交后是否发生平台MQ消息*********************/
    OMR_SUBMIT_IS_SENDMQ: 0,
    
    /********************门诊病历,发送平台MQ消息的服务ID*********************/
    OMR_SENDMQ_SERVICE_ID: 'BS333',
    
    /********************门诊病历,发送平台MQ消息的域ID*********************/
    OMR_SENDMQ_DOMAIN_ID: '01',
    
    /********************CA证书厂商 1：北京CA 2：网政通CA*********************/
    CA_SUBJECT: 1,
    
    /******病历模板中婚育史与月经史是否分开，男性显示婚育史，女性显示婚育月经史*****/
    MR_TPL_PARAGRAPH : true,
    
    /******病历审签时，是否自动出现【上级医师签名】*****/
    IS_USE_AUTO_SIGNA : false,
    
    /******助手区是否按照就诊次查询*****/
    ASSISTANT_BY_ENCOUNTER : false,
    
    /******病历模板中模板所属类别是否包含个人级别*****/
    MR_TPL_OWNER_TYPE : true,
    
    /******住院病历提交、审签签名时，显示职称医师*****/
    MR_JOB_TITLE_SHOW : false
    
})