Ext.define('iih.mr.qa.process_qa_work.action.DefectNoticeInferInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/** 
	 * 本次质控完成确认页面初始化
	 * @extends Xap.ej.action.Action
	 * @author ：yao_lijie
	 */
	execute: function(context) {
		var owner = this.getOwner();
		var socuseOwner = owner.socuseOwner;//传入上级视图
		var datas = {};
		var workScreen = context.workScreen;
		//if(workScreen!=null && workScreen!=undefined)
		if(workScreen == '1' || workScreen == '4' || workScreen == '8' || workScreen == '13'){
			datas.encounterPk = context.patientRecord.pk,//得到就诊号
			datas.qaTypeCode = context.qaTypeCode,//质控类型编码
			datas.revisionCd = context.revisionCd,//通知书主键
			datas.workScreen = context.workScreen //质控类型编码
		}else if(workScreen == '2' || workScreen == '5' || workScreen == '9'){
			datas.encounterPk = context.patientRecord.enPk,//得到就诊号
			datas.qaTypeCode = context.qaTypeCode,//质控类型编码
			datas.revisionCd = context.revisionCd,//通知书主键
			datas.workScreen = context.workScreen //质控类型编码
		}
    	var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);//DefectNoticeInferview
        properties.setData({
            parentWindow: context.parentWindow,
            sourceView: socuseOwner,
            encounterPk: datas.encounterPk,
            qaTypeCode: datas.qaTypeCode,
            qaTypeName: context.qaTypeName,
            patientRecord:context.patientRecord,  //患者就诊记录      
            workScreen:context.workScreen,
            revisionCd:context.revisionCd,
            haveFault:context.haveFault
            
        });
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,datas);
    },

    /*
    * @return {mclass: '', condition: {}}
    */
    prepareOperations: function(operations,datas) {
        var url = this.url+"?encounterPk=" + datas.encounterPk + "&revisionCd="  + datas.revisionCd + "&workScreen=" + datas.workScreen;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
    		mclass: null,
    		method: METHODS.METHOD_GET,
//    		data:datas,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var m = operation.result.data;
        
        var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
        //新建对象，赋值给弹出的画面
        var workScreen = properties.data.workScreen;
        //主画面传递过来的参数
        var mainPageParams;
        var currentDeptCode; //患者当前科室
		var curMngDctId; //整改医生编码
		var currentDeptName;
		var currentManageDoctorName;
        if(workScreen == '1' || workScreen == '4' || workScreen == '8' || workScreen == '13'){
        	mainPageParams = properties.data.patientRecord;
        	currentDeptCode = mainPageParams.currentDeptCode; //患者当前科室
			curMngDctId = mainPageParams.currentManageDoctorId;//整改医生编码
			currentDeptName = mainPageParams.currentDeptName;
			currentManageDoctorName = mainPageParams.currentManageDoctorName;
        }else if(workScreen == '2' || workScreen == '5' || workScreen == '9'){
        	mainPageParams = properties.data.patientRecord.data;
        	//环节质控追踪的参数有变化，故改为给变量赋值
        	currentDeptCode = mainPageParams.rfmDeptCd; //患者当前科室
			curMngDctId = mainPageParams.rfmDoctorCd;//整改医生编码
			currentDeptName = mainPageParams.rfmDeptNM;
			currentManageDoctorName = mainPageParams.rfmDoctorNM;
        }
        var obj = {
				encounterSn: properties.data.encounterSn,
				qaTypeCode: properties.data.qaTypeCode,    //质控类型编码
				qaTypeName: properties.data.qaTypeName,  //质控类型名称
				currentDeptCode: currentDeptCode, //患者当前科室
				curMngDctId: curMngDctId,//整改医生编码
				currentDeptName: currentDeptName,
				currentManageDoctorName: currentManageDoctorName,
				patientName: mainPageParams.patientName,
				patientName1:mainPageParams.patientName,
				patientRecord: mainPageParams,  //患者就诊记录 
				excuteUserName: IMER_GLOBAL.user.name,
				executeDeptName: IMER_GLOBAL.department.name
        };
        m.formData = obj;
        block.setData(m);
       /*	var form = block.down('xapform'); 
        var faultSubmited = form.down('xapdisplayfield[name=faultSubmited]');		//需整改缺陷
        var submitedValue = faultSubmited.value;
        var reformDeadline = form.down('xapnumberfield[name=reformDeadline]');		//整改期限
       	if(submitedValue == "0"){
       		reformDeadline.setDisabled(true);
       	}*/
    }
});