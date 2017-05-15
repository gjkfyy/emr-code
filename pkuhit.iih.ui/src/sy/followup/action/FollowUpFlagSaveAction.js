Ext.define('iih.sy.followup.action.FollowUpFlagSaveAction', {
	extend : 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) { 
    	var owner = this.getOwner();
		var block = this.getBlock('content');
		var form= block.getForm();
        var data = form.getValues();
        
        //获取患者ID、被修改的随访状态和备注信息三个
        console.log('');
        
        
		var operations = context.operations;
        if(!operations) {
     		return;
	    }
        
        this.editFlag(operations,data)
    },
    
    //修改患者信息
    editFlag: function(operations,data) {
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
    	
    	//刷新随访信息列表
    		
		/*var patientleftlistview = Ext.getCmp('patientleftlistview');
    	var chain = patientleftlistview.getActionChain('init');
        	chain.execute();*/
    },
    editFail: function(operation) {
        XapMessageBox.info('修改失败!');
    }
});
