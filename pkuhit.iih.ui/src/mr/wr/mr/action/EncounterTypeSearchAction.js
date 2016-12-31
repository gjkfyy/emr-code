Ext.define('iih.mr.wr.mr.action.EncounterTypeSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var typeCode = context.typeCode;
	    this.prepareOperations(context.operations,typeCode);
    },
    prepareOperations: function(operations,typeCode) {
        var url = this.url + '?typeCode=' + typeCode;
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
                block.setEnTypeValue(operation.result.dataList);
        }
    }
});
