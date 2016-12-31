Ext.define('iih.mr.wr.omr.action.OmrSubmitAndRevokeCheckAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(context.event){
			var cmd=context.event.arguments[0];
			this.cmd=cmd;
		}
        if(context.submitF){//第三方socket调用刷新处置后提交标识
			var submitF=context.submitF;
			this.submitF=submitF;
		}
        if(!operations) {
            return;
        }
        var medicalRecord=this.getOwner().medicalRecord;
        if('emrSubmit'!=this.cmd&&(!medicalRecord||medicalRecord.statusCode=='MRM04.02')){
        	//执行整洁打印
            var emrNeatPrint = this.getOwner().getActionChain('emrNeatPrint');
            if(emrNeatPrint) {
            	emrNeatPrint.execute({submitF:this.submitF});
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
	            	emrNeatPrint.execute({submitF:this.submitF});
	            }
			}else{
				var emrSubmit = me.getOwner().getActionChain('emrSubmit');
	            if(emrSubmit) {
	            	emrSubmit.execute({cmd:this.cmd,submitF:this.submitF});
	            }
			}
		}
		if(parms.length==0){
			var emrSubmit = me.getOwner().getActionChain('emrSubmit');
            if(emrSubmit) {
            	emrSubmit.execute({cmd:this.cmd,submitF:this.submitF});
            }
		}
    }
});
