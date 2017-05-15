Ext.define('iih.sy.followup.action.FollowUpGetDateAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer'],
	doExecute: function(context) {
        var operations = context.operations;    
        this.flag = context.flag;
        this.prepareOperations(operations);  
	},  
	
	prepareOperations: function(operations) { 
		 var operation = {
            url: this.url,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	 };
    	 operations.length = 0;
    	 operations.push(operation);  
	 },
	 
	 onFail: function(operation) { 
		 alert("查询失败");
	 },  
     onSuccess: function(operation) {
    	 var block = this.getBlock('result');
         var fuDate = operation.result;
         //从服务器端返回时间并设值
         var startDate = block.down('xapdatefield[name=startDate]');
         var endDate = block.down('xapdatefield[name=endDate]');
         console.log("aaaa"+this.flag);
         if(this.flag=='14'){
             startDate.setValue(new Date(fuDate-7*24*60*60*1000));
             endDate.setValue(new Date(fuDate+7*24*60*60*1000));
         }else if(this.flag=='7'){
        	 startDate.setValue(new Date(fuDate+1*24*60*60*1000));
             endDate.setValue(new Date(fuDate+7*24*60*60*1000));
         }else if(this.flag=='-7'){
        	 startDate.setValue(new Date(fuDate-7*24*60*60*1000));
             endDate.setValue(new Date(fuDate-1*24*60*60*1000));
         }else if(this.flag=='all'){
        	 startDate.setValue('');
             endDate.setValue('');
         }
         
     }    
});