Ext.define('iih.mr.qa.QaStatusGlobal', {
	
    singleton: true,
    
    faultConfirmStatus:'QAM07.01', //未确认
    
    faultRectificationStatus:'QAM07.02', //整改
    
    faultDropStatus:'QAM07.03', //扣分
    
    faultNoDropStatus:'QAM07.04', //不扣分
    	
    workScreenWorkProcess: '1', //环节质控-工作画面
    
    workScreenTrackProcess: '2', //环节质控-追踪画面
    
    workScreenReformProcess: '3', //环节质控-医生整改
    
    workScreenWorkTerminal: '4', //终末质控-工作画面
    
    workScreenTrackTerminal: '5', //终末质控-追踪画面
    
    workScreenReformTerminal: '6', //终末质控-医生整改
    
    workScreenScore: '7', //终末质控评分画面

    workScreenWorkDept: '8', //科室质控-工作画面
    
    workScreenTrackDept: '9', //科室质控-追踪画面
    
    workScreenReformDept: '10', //科室质控-医生整改
    
    workScreenScoreDept: '11', //科室质控评分画面
    
    workScreenScoreAuto: '12', //自动质控评分(环节质控质量自评)画面
    
    workScreenWorkOrder: '13', //医嘱质控-工作画面
    
    workScreenReformOrder: '14', //医嘱质控-医生整改
    
    workScreenQaReport: '15', //质控报表-工作画面
    
    workScreenNSReport: '16', //护理报表-工作画面

    
    writeStarted: 'MRM22.01',//病案状态  书写已开始
    
    writeCompleted: 'MRM22.02',//病案状态  书写已完成
    
    qaDept:'MRM22.03',// 病案状态 已科室质控
    
    qaDeptScored:'MRM22.04',// 病案状态 已科室评分
    
    qaStarted:'MRM22.05',// 病案状态 已签收
    
    qaCompleted:'MRM22.06',// 病案状态 已完成终末质控
    
    qaScored:'MRM22.08',// 已终末评分
    
    archived:'MRM22.07',// 病案状态 已归档
    	
    defectCreate:'QAM01.01',// 新建
    
    defectSubmitted:'QAM01.02',// 已提出
    
    defectReformed:'QAM01.03',// 已整改
    
    defectVerified:'QAM01.04',// 已审核
    
    workScreenReform:'1', 	// 环节整改通知
    workScreenTrack:'2', 	// 环节质控追踪
    
    //缺陷状态
    faultToReform:'QAM12.01', //待整改
    faultReformed:'QAM12.02', //已整改
    faultVerified:'QAM12.03', //审核通过
    faultDeductioned:'QAM12.04', //扣分
    
    //整改通知单状态
    revisionNoticeToReform:'QAM11.01', //待整改
    revisionNoticeReforming:'QAM11.02', //整改中
    revisionNoticeReformed:'QAM11.03', //已整改
    revisionNoticeVerified:'QAM11.04', //已审核
    
    //质控类型编码
    qaTypeCodeProcess: 'QAM13.01', //环节质控
    qaTypeCodeDept: 'QAM13.02', //科室质控
    qaTypeCodeTerminal: 'QAM13.03', //终末质控
    qaTypeCodeAuto: 'QAM13.04', //自动质控-待删除
    
  //  qaAutoTypeCodeProcess: 'QAM13.04', //环节自动质控 --待启用
    qaAutoTypeCodeDept: 'QAM13.05', //科室自动质控
    qaAutoTypeCodeTerminal: 'QAM13.06', //终末自动质控
    
    qaTypeCodeOrder: 'QAM13.07', //医嘱质控
    
    verifiedDeadline:'7', //已审核（7天内）
    
    qaDrpScrTpCdOnce: "QAM02.01", //扣分类型 仅一次扣分
    qaDrpScrTpCdMto: "QAM02.02", //可多次扣分
    qaDrpScrTpCdB: "QAM02.03", //单否乙
    qaDrpScrTpCdC: "QAM02.04", //单否丙
    
    //患者
    patient:{
        patientId:'',
        name:''
    },
    qaUserRoles:[],
    isNurseRole:false,
    nurseMrTpCCat:['MRM14.14','MRM14.15','MRM14.16','MRM14.17','MRM14.18','MRM14.19','MRM14.20','MRM14.21','MRM14.22']

})