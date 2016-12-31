Ext.define('iih.mr.qa.qa_divide_level.action.QaDivideLevelSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		this.showLoading();
		var operations = context.operations;
	    	if(!operations) {
	    		return;
	    	}
		this.prepareOperations(operations);
	},
    
    prepareOperations: function(operations) {
		var url = this.url;
		
    	var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('content');
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
        	block.setData(m);
        	console.log(m);
        }
    }
});
