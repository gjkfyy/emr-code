Ext.define('iih.sy.patient.action.PatientSaveAction', {
	extend : 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {   
    	var owner = this.getOwner();
    	//var userId = IMER_GLOBAL.user.code;
		var block = this.getBlock('content');
		var form= block.getForm();
        var data = form.getValues();
        var valid = form.isValid();
        if(!valid){
        	Ext.MessageBox.alert("错误提示","请检查必填项！");
        	return;
        }
        var userId = IMER_GLOBAL.user.code;
        var deptCd = IMER_GLOBAL.department.code
        data.crtUserId = userId;
        data.crtDeptCd = deptCd;
        data.lastUpdUserId = userId;
        data.lastUpdDeptCd = deptCd;
        //data.admissionDate = data.admissionDate;
        data.admissionDate = Ext.util.Format.date(new Date(data.admissionDate), "Y-m-d H:i:s");
        data.isPic = data.isPic == 'on'? 1 : 0;
        data.isVideo = data.isVideo == 'on'? 1 : 0;
		var operations = context.operations;
        if(!operations) {
     		return;
	    }
        
        //判断是新建还是修改患者信息
        if(Ext.getCmp('flag').getValue()=="edit"){
        	this.editPatient(operations,data)
        }else{
        	this.createPatient(operations,data);
        }
    },
    
    //新建患者信息
    createPatient: function(operations,data){
        var url = this.url; 
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.createSuccess,
    		fail: this.createFail
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    createSuccess: function(operation) {
    	XapMessageBox.info("新建成功!");
    	var owner = this.getOwner();
    	var chain = owner.getActionChain('cancel');
    		chain.execute();
    	var patientleftlistview = Ext.getCmp('patientleftlistview');
    	//var view = this.up('patientleftlistview');
    	var chain = patientleftlistview.getActionChain('init');
        	chain.execute();
    },
    createFail: function(operation) {
        XapMessageBox.info('新建失败!');
    },

    //修改患者信息
    editPatient: function(operations,data) {
    	 var url = this.url+'/' + Ext.getCmp('patientId').getValue();
         var mclass = null;
         var METHODS = this.getInvocationMethods();
     	 var operation = {
             url: url,
             mclass: null,
             method: METHODS.METHOD_UPDATE,
             condition: null,	
             data:data,
     		 scope: this,
     		 success: this.editSuccess,
     		 fail: this.editFail
     	};
     	operations.length = 0;
     	operations.push(operation);
    },
    editSuccess: function(operation) {
    	XapMessageBox.info("修改成功!");
    	var owner = this.getOwner();
    	var chain = owner.getActionChain('cancel');
    		chain.execute();
    	/*
    	var view = this.up('patientleftlistview');
    	var chain = owner.getActionChain('init');
        	chain.execute();*/
    },
    editFail: function(operation) {
        XapMessageBox.info('修改失败!');
    }
});
