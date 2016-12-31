Ext.define('iih.mr.wr.omr.action.iemrCallHisAction', {
	    extend: 'Xap.ej.action.ServiceInvocation',
	    
	    doExecute: function(context) {
			this.prepareOperations(context.operations);
			
		},
	    prepareOperations: function(operations) {
	        var url = this.url;
	        url = url;  
	        var mclass = null;
	        var METHODS = this.getInvocationMethods();
	        var operation = {
	            url: url,
	            mclass: mclass,
	            method: METHODS.METHOD_GET,
	            condition: null,
	            scope: this,
	            success: this.onSuccess
	        };
	        operations.push(operation);
	    },
	    onSuccess: function(operation) {
	    	var owner=this.getOwner();
	    	var iemrCallCisParam=operation.result.data.iemrCallCisParam;
	    	var callOrderBtn=Ext.getCmp('callOrderBtn');
	    	var encounterOverBtn=Ext.getCmp('encounterOverBtn');
	    	var callPatCaseBtn=Ext.getCmp('callPatCaseBtn');
	    	
	    	if(iemrCallCisParam){
	    		var btnEnableParams = iemrCallCisParam.split(":");
	    		if(btnEnableParams.length!=3)return;
	    		if(btnEnableParams[0]=='1'){
	    			callOrderBtn.show();
	    		}else {
	    			callOrderBtn.hide();
	    		}
	    		if(btnEnableParams[1]=='1'){
	    			encounterOverBtn.show();
	    		}else {
	    			encounterOverBtn.hide();
	    		}
	    		if(btnEnableParams[2]=='1'){
	    			callPatCaseBtn?callPatCaseBtn.show():'';
	    		}else {
	    			callPatCaseBtn?callPatCaseBtn.hide():'';
	    		}
	    		
	    	}
	    }
	});

