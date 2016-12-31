Ext.define('iih.mr.wr.mr.action.AlreadySignInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    execute: function(context) {
//    	this.showLoading();
    	var pageNum,pageSize;
		if(context.event==undefined||context.event.from.name != 'alreadySign'){
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
			var block = this.getBlock('content');
			block.pageSize = pageSize;
		}else{
			pageNum = context.event.arguments[0]; 
			pageSize = context.event.arguments[1]; 
		}
		var data = {
			pageNum : pageNum,
			pageSize : pageSize
		};
        this.signedPrepareOperations(context.operations,data);
    },
    signedPrepareOperations: function(operations,data) {
    	 var block = this.getBlock('content');
         var patientId=block.down('[name=patient]').getValue();
	     var url = this.url+'?userId='+IMER_GLOBAL.user.code+'&deptCd='+IMER_GLOBAL.department.code+'&patientId='+patientId+'&pageNum='+data.pageNum+'&pageSize='+data.pageSize;
	     var operation = {
	         url: url,
	         method: 'get',
	         scope: this,
	         success: this.signedOnSuccess
	     };
	     operations.push(operation);
     },
     signedOnSuccess: function(operation) {
         var block = this.getBlock('content');
         var pageSize = block.pageSize;
         var m = operation.result;
         m.pageSize = pageSize;
         block.setData(m,'alreadySign');
     }
});
