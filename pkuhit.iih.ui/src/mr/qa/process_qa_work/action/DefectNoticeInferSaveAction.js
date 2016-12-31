Ext.define('iih.mr.qa.process_qa_work.action.DefectNoticeInferSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		
		var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        var data = properties.getData();
        var haveFault = data.haveFault;
        
        var block = this.getBlock('result');
    	
    	var isValid = block.down('xapform').getForm().isValid();
        if(!isValid){
    		return;
    	}
        if(haveFault){
        	
        	this.showSubmitProgressBar();
        }
    
    	
    	var owner = this.getOwner();
    	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        var encounterPk = properties.data.encounterPk;
        var qaTypeCode = properties.data.qaTypeCode;
        var dataList = properties.data.dataList;
        var workScreen = properties.data.workScreen;
        var revisionCd = properties.data.revisionCd;
        var haveFault = properties.data.haveFault;
        
        var executeEndTimeValue = block.getData().executeEndTime;//质控时间
        var reformDeadlineValue = block.getData().reformDeadline;
        var currentDeptCode = block.getData().currentDeptCode;
        var curMngDctId = block.getData().curMngDctId;
        var reformMemo = block.getData().reformMemo;
        var patientName = block.getData().patientName;
        var data = {
        	'executeEndTime' :executeEndTimeValue,
			'reformDeadline' : reformDeadlineValue,
			'reformMemo' : reformMemo,
			'enPk' : encounterPk, // 就诊主键，就诊序号
			'qaTypeCode' : qaTypeCode,// 质控类型
			'haveFault': haveFault,
			'currentDeptCode':currentDeptCode, //患者当前科室
			'curMngDctId':curMngDctId,//整改医生编码
			'dataList' : dataList, //需整改缺陷质控工作记录     
			'workScreen':workScreen,
			'revisionCd':revisionCd,
			'patientName':patientName
		};
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,data);
    },
    prepareOperations: function(operations,data){
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            data:data,
    		scope: this,
    		success: this.onSuccess,
    		failure: this.onFail
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    onSuccess: function(operation) {
    	//关闭窗口
    	var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        var data = properties.getData();
        var haveFault = data.haveFault;
        var workScreen = properties.data.workScreen;
        if(haveFault){
        	 XapMessageBox.info("发送整改通知成功");
        }else if(workScreen !='2' && workScreen !='5' && workScreen !='9'){
        	 XapMessageBox.info("本次质控完成");
        }
       
        if(data.parentWindow){
        	  data.parentWindow.close();
        }
      
        
        var defectinAndmreditview = properties.data.sourceView; 	//缺陷一览画面
        if(defectinAndmreditview){
        	//初始化缺陷一览列表
            var chain = defectinAndmreditview.getActionChain('searchDefectsAction');
            if(chain) {
                chain.execute();
            }
        }
        
       // var workScreen = properties.data.workScreen;
        if(workScreen=='2' || workScreen=='5' || workScreen=='9'){
        	XapMessageBox.info('发送再整改通知成功！');
        	var contentBlock = defectinAndmreditview.getBlock('bottom');
    	    // 审核通过按钮
            var checkPass = contentBlock.down('xapgrid xapbutton[action=checkPass]');
            // 扣分按钮
            var deduction = contentBlock.down('xapgrid xapbutton[action=deduction]');
            // 再整改按钮
            var rectification = contentBlock.down('xapgrid xapbutton[action=rectification]');
            // 完成本次审核按钮
            var finishCheck = contentBlock.down('xapgrid xapbutton[action=finishCheck]');
            // 设置按钮不可用
            checkPass.setDisabled(true);
            deduction.setDisabled(true);
            rectification.setDisabled(true);
            finishCheck.setDisabled(true);
            
            //储存画面间参数
    	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
            properties.setData({
        		revisionStatus:iih.mr.qa.QaStatusGlobal.revisionNoticeToReform
            });
        }
		
    },
    onFail:function(operation){
    	XapMessageBox.info('失败');
    }
});