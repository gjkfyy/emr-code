Ext.define('iih.mr.tth.action.TeethExamInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
    doExecute: function(context) {
    	this.callParent();
    	this.showLoading();
    	if(!IMER_GLOBAL.encounterSn){
    	    this.hideLoading();
            return;
        };
        var operations = context.operations;
        if(!operations) {
            this.hideLoading();
            return;
        }
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        var url = this.url + '/' + IMER_GLOBAL.encounterSn;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.length = 0;
        operations.push(operation);
    },
    
    onSuccess: function(operation){
        if(operation.result){
            var block = this.getBlock('content');
            block.setData(operation.result);
        }
    },
    
    onFail: function(operation){
        this.hideLoading();
    }
});