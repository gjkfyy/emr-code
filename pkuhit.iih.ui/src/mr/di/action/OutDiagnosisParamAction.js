Ext.define('iih.mr.di.action.OutDiagnosisParamAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:['iih.mr.di.action.Util'],
	
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
  
	        var url = this.url+'/SYSM01.3';
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
	    	 var res = operation.result.dataList;
	    	 var b = true;
	    	 if(res && res.length>0){
	    		 //IMER_GLOBAL.department.code
	    		 for(var i=0;i<res.length;i++){
	    			 if(res[i].value == IMER_GLOBAL.department.code){
	    				 b = true;
	    				 break;
	    			 }
	    		 }
	    		 
	    		 if(b){
	    			     var owner = me.getOwner();
	    			     var diagnosisSavechain = owner.getActionChain("outDiagnosisSaveAction");
	    			     diagnosisSavechain.execute();
	    			     owner.data=null;
	    		 }
	    	 }
		    
	    },
    onFailure: function(operation) {
	    	XapMessageBox.info('参数加载失败!');
	    },  
});
