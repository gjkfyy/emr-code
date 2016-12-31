Ext.define('iih.mr.wr.nmr.action.NmrCheckFinishAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations,mrSn) {
    	var url = this.url;
        url = url+'/'+IMER_GLOBAL.encounterSn;  
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
    	if(operation.result.data){
    		if(operation.result.data.msg){
    			XapMessageBox.info(operation.result.data.msg);
    		}else{
    			var finish=this.getOwner().getActionChain('finish');
        		finish.execute();
    		}
    	}
    }
});
