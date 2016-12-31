Ext.define('iih.mr.wr.omr.action.GetSystemConfigAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
    		var url=this.url+'/SYSM01.6';
            var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
            };
            operations.push(operation);
    },
    onSuccess: function(operation) {
    	var configs=operation.result.dataList;
    	var mr=this.getOwner().medicalRecord;
    	if(mr.mrTypeCustomCode=='MRM14.09'){
        	var config=null;
    		var f=true;
    		if(configs){
    			for(i in configs){
    				config=configs[i];
    				if(config.value==IMER_GLOBAL.department.code){
    					f=false;
    				}
    			}
    		}
    		if(f){
    			var emrRefreshOutpatientDisposal = this.getOwner().getActionChain('emrRefreshOutpatientDisposal');
    			emrRefreshOutpatientDisposal.execute();
    		}
        }
    }
});
