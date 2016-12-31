Ext.define('iih.mr.qa.qa_divide_level.action.QaItmFstTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	    execute: function(context) {
	    	this.showLoading();
	        this.prepareOperations(context.operations);
	        
	    },
	    prepareOperations: function(operations) {
	         
	         var url = this.url;
	         var operation = {
	             url: url,
	             method: 'get',
	             scope: this,
	             success: this.onSuccess
	         };
	         operations.length = 0;
	         operations.push(operation);
	     },
	     onSuccess: function(operation) {
	         var block = this.getBlock('left'); 
	         // TODO 数据格式就这样了？
	         if(operation.result.data){
	         	 block.setData(operation.result.data.children);
	         	 var tree = block.down('xaptree'); 
//		         tree.getSelectionModel().select(0,false,false);//默认选中
	         }else{
	        	 block.setData(null);
	         }
	     }
});
