Ext.define('iih.mr.qa.dept_qa_auto_search.action.QaMrDocInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	    execute: function(context) {	    	
	    	this. showLoading();
	    	var owner = this.getOwner();
	    	var encounterSn = context.encounterSn;
	        this.prepareOperations(context.operations,encounterSn);
	    },
	    prepareOperations: function(operations,encounterSn) {
	         var url = this.url+'?encounterPk='+encounterSn;
	         var operation = {
	             url: url,
	             method: 'get',
	             scope: this,
	             success: this.onSuccess
	         };
	         operations.push(operation);
	     },
	     onSuccess: function(operation) {
	         var block = this.getBlock('content'); 
	         // TODO 数据格式就这样了？
	         if(operation.result.dataList){
	     	 	 block.setData(operation.result.dataList);
	         }else{
	        	 block.setData(null);
	         }
	     }
});
