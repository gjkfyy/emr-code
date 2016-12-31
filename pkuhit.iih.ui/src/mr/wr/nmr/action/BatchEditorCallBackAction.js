Ext.define('iih.mr.wr.nmr.action.BatchEditorCallBackAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    
    /*
    * @Override
    */
    execute: function(context) {
    	var self=this;
    	var operations = context.operations;
        if(!operations) {
            return;
        }
    	var opType=this.getOwner().opType;
    	
    	var gui = require('nw.gui');
		var win = gui.Window.get();
		var page = this.getOwner();
		if ('open'==opType){
            //设置编辑器按钮状态
    		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
			
    	}
    	setTimeout(function() {
    		var plugin = document.getElementById('iemrOpenEditor');
    		if(plugin){
	    		plugin.GotoMark('');
	    		plugin.EnableOCX(true);
    		}
		},700);
    	setTimeout(function() {
    		var emrPrint = self.getOwner().getActionChain("emrPrint");
    		emrPrint.execute();
		},750);
    },
    
    prepareOperations: function(operations) {
        var url=this.url+'/SYSM01.6';
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
		var parms=operation.result.dataList;
		for(parm in parms ){
			if(parms[parm].value==IMER_GLOBAL.department.code){
				//如果当前科室设置了不自动刷新处方，则退出此方法，不执行刷新处方的chain
				return;
			}
		}
//		console.log('emrRefreshPrescription');
//		var emrRefreshPrescription=this.getOwner().getActionChain("emrRefreshOutpatientDisposal");
//		emrRefreshPrescription.execute();
    }
});
