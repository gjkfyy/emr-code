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
        data.admissionDate = Ext.getCmp("admissionDate").getValue();
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
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
    	XapMessageBox.info("保存成功");
    	var owner = this.getOwner();
    	var chain = owner.getActionChain('cancel');
    		chain.execute();
    	
    	var view = this.up('patientleftlistview');
    	var chain = owner.getActionChain('init');
        	chain.execute();
    }

});
