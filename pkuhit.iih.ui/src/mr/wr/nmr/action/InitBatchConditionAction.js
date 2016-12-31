Ext.define('iih.mr.wr.nmr.action.InitBatchConditionAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var url = this.url+'?doctorNuserFlag=0';
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	console.info(this.url+'?doctorNuserFlag=0');
    	var owner=this.getOwner();
    	var block= owner.getBlock("condition");
        var batchCategoryCode=block.down('[name=batchCategoryCode]');
        if(operation.result.data){
        	if(operation.result.data.mrTypeCustomCategorys&&operation.result.data.mrTypeCustomCategorys.length>0){
        		batchCategoryCode.setData(operation.result.data.mrTypeCustomCategorys);
        		//batchCategoryCode.select('MRM14.14');
                  }
        	}
    }
});
