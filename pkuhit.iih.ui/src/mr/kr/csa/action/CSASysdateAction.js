Ext.define('iih.mr.kr.csa.action.CSASysdateAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:[],
	
	
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	var me = this;
        	var url = this.url;
	        var METHODS = this.getInvocationMethods();
	    	var operation = {
	            url: url,
	    		mclass: null,
	    		method: METHODS.METHOD_GET,
	    		condition: null,
	    		scope: this,
	    		success: this.onSuccess,
	    	    fail: this.onFailure
	    	};
	    	operations.push(operation);
	    },
	
	onSuccess : function(operation) {
	    	var me = this;
	    	var tree = me.getBlock('leftblock').down('xaptree[action=csatree]');
	        var mrTime =  operation.result.sysdateStr;
	        var mrTimeField = me.getOwner().ownerCt.down('datetimefield[action=ywDate]');
	        mrTimeField.setRawValue(mrTime);
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
