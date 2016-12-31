Ext.define('iih.mr.wr.mr.action.MrTypeCcatSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var url = this.url;
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
                // fail: this.onFail
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	if(operation.result){
            var block = this.getBlock('content');
            if(block)
                block.setListData(operation.result.dataList);
        }
    }
});
