Ext.define('iih.mr.wr.nsv.action.SubmitAndRevokeCheckAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        var cmd=context.event.arguments[0];
        this.cmd=cmd;
        if(!operations) {
            return;
        }
        var medicalRecord=this.getOwner().medicalRecord;
        if('emrSubmit'!=this.cmd&&(!medicalRecord||medicalRecord.statusCode=='MRM04.02')){
        	//执行整洁打印
            var emrNeatPrint = this.getOwner().getActionChain('emrNeatPrint');
            if(emrNeatPrint) {
            	emrNeatPrint.execute();
            }
            return;
        }
        this.prepareOperations(operations);
    },
    prepareOperations: function(operations) {
        var url=this.url+'/SYSM01.7';
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var me=this;
    	var parms=operation.result.dataList;
		for(parm in parms ){
			if(parms[parm].value=='0'){
				var emrNeatPrint = me.getOwner().getActionChain('emrNeatPrint');
	            if(emrNeatPrint) {
	            	emrNeatPrint.execute();
	            }
			}else{
				var emrSubmit = me.getOwner().getActionChain('emrSubmit');
	            if(emrSubmit) {
	            	emrSubmit.execute({cmd:this.cmd});
	            }
			}
		}
		if(parms.length==0){
			var emrSubmit = me.getOwner().getActionChain('emrSubmit');
            if(emrSubmit) {
            	emrSubmit.execute({cmd:this.cmd});
            }
		}
    }
});
