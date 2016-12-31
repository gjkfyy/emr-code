Ext.define('iih.mr.wr.mr.action.WaitDeptSignPatientsInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    execute: function(context) {
        this.PrepareOperations(context.operations);
    },
    PrepareOperations: function(operations) {
    	var block = this.getBlock('content');
    	var patientId=block.down('[name=patient]').getValue();
         var url = this.url+'?userId='+IMER_GLOBAL.user.code+'&deptCd='+IMER_GLOBAL.department.code+'&patientId='+patientId;
         var operation = {
             url: url,
             method: 'get',
             scope: this,
             success: this.OnSuccess
         };
         operations.push(operation);
     },
     OnSuccess: function(operation) {
     	var block = this.getBlock('content');
        var patient=block.down('xapcombobox[name=waitDeptSignPatient]');
	    if(operation.result.dataList){
	     	patient.setData(operation.result.dataList);
	    }else{
	    	patient.setData([]);
	    }
	    patient.select('ALL');
     }
});
