Ext.define('iih.mr.wr.omr.action.ErpSignBtnStatusAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
		var operations = context.operations;
        if(!operations) {
            return;
        }
        
		this.addPrepareOperations(operations);
				
	},
    addPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+"?key=GULOU_CA_ENABLED";
        var operation = {
            url: url,
            method: 'get',
            //data:data,
            scope: this,
            success: this.onAddSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onAddSuccess: function(returnData) {
    	 var res = returnData.result.data;
//    	 if(res && res.length>0){
    		 var serchErpSignBtn=Ext.getCmp('serchErpSignBtn');
    		 var erpSignBtn=Ext.getCmp('erpSignBtn');
    		 //IMER_GLOBAL.department.code
//    		 for(var i=0;i<res.length;i++){
    			 if(res == '1'){
    				 //显示
    				 serchErpSignBtn.show();
    				 erpSignBtn.show();
//    				 break;
    			 }
//    		 }
    		 
//    	 }
    }
});
