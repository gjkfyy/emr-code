Ext.define('iih.mr.wr.mr.action.WaitDeptSignInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    execute: function(context) {
//    	this.showLoading();
    	var pageNum,pageSize;
		if(context.event == undefined){
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}else{
			pageNum = context.event.arguments[0]; 
			pageSize = context.event.arguments[1]; 
		}
		var block = this.getBlock('content');
		block.pageSize = pageSize;
		var data = {
			pageNum : pageNum,
			pageSize : pageSize
		};
        this.waitDeptPrepareOperations(context.operations,data);
    },
     waitDeptPrepareOperations: function(operations,data) {
    	 var url = this.url+'?userId='+IMER_GLOBAL.user.code+'&deptCd='+IMER_GLOBAL.department.code+'&pageNum='+data.pageNum+'&pageSize='+data.pageSize;
    	 var block = this.getBlock('content');
         var patientId=block.down('[name=waitDeptSignPatient]').getValue();
         if(patientId&&patientId.length>0){
        	 url=url+'&patientId='+patientId;
         }
         var operation = {
             url: url,
             method: 'get',
             scope: this,
             success: this.waitDeptOnSuccess
         };
         operations.push(operation);
     },
     waitDeptOnSuccess: function(operation) {
         var block = this.getBlock('content');
         var pageSize = block.pageSize;
         var m = operation.result;
         m.pageSize = pageSize;
         block.setData(m,'waitDeptSign');
     }
});
