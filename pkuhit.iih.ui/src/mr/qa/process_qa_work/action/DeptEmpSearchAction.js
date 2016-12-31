Ext.define('iih.mr.qa.process_qa_work.action.DeptEmpSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*   
	* @Override
	*/
	execute: function(context) {      
    
    	var owner = this.getOwner();
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}

    	var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,	
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length=0;
    	operations.push(operation);
    
    	
    	
    },
    onSuccess: function(operation) {
        
    	//获取质控项目block
		var block = this.getBlock('content');
		var rfmUserCmp = block.down('xapcombobox[name=rfmUser]');
		rfmUserCmp.select(null);
	        if(operation.result){
	        	rfmUserCmp.setData(operation.result.dataList);
	        }
    }
});
