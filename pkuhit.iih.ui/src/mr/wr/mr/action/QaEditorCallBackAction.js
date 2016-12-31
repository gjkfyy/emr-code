Ext.define('iih.mr.wr.mr.action.QaEditorCallBackAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    
    /*
    * @Override
    */
    execute: function(context) {
    	Ext.MessageBox.hide();
    	var opType=this.getOwner().opType;
//    	var plugin = document.getElementById('iemrEditor');
    	if ('reform'==opType){
    		var operations = context.operations;
            if(!operations) {
                return;
            }
    		var disabledOfficeToolBarAction=this.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
    		//2015年5月28日15:38:13确定不需要记录修改痕迹
    		/*var medicalRecord=this.getOwner().medicalRecord;
    		if(medicalRecord.canSign&&medicalRecord.canSign==1){
    			plugin.ShowRedline(1);
        		this.openPrepareOperations(operations);
    		}
    		plugin.GotoSection('主诉',true);
    		plugin.SetModified(false);*/
    	}
    },
    openPrepareOperations: function(operations) {
    	var url=this.url+'?userId='+IMER_GLOBAL.user.code;
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
        	signatureLevel=1;
        	
        }else if('MRM02.04'==user.signLevelCode){
        	signatureLevel=2;
        }
        plugin.SwitchRedline(signatureLevel, user.id);
        plugin.SetModified(false);
    }
});
