Ext.define('iih.mr.wr.mr.action.MrSignDisposeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    
    /*
    * @Override
    */
    execute: function(context) {
    	var opType=this.getOwner().opType;
    	var plugin = document.getElementById('iemrEditor');
    	if ('open'==opType){
    		var operations = context.operations;
            if(!operations) {
                return;
            }
    		plugin.ShowRedline(1);
        	this.openPrepareOperations(operations);
    	}
    },
    openPrepareOperations: function(operations) {
    	var url=this.url;
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
    	var user=operation.result.data;
        var plugin = document.getElementById('iemrEditor');
        var signatureLevel=0;
        if('MRM02.03'==user.signLevelCode){
        	signatureLevel=2;
        	
        }else if('MRM02.04'==user.signLevelCode){
        	signatureLevel=3;
        }
//        console.log('审签等级'+signatureLevel);
        if(signatureLevel>0){
            plugin.EditDocument();
            plugin.SwitchRedline(signatureLevel, user.id);
            plugin.ShowRedline(1);
            plugin.SetModified(false);
        }
    }
});
