Ext.define('iih.po.assistant.action.DiagnosisHelperInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
	    this.showLoading();
		var enPk = context.enPk;
        if(enPk==undefined){
        	enPk = IMER_GLOBAL.encounterSn;
        }
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,enPk);
    },

    prepareOperations: function(operations,enPk) {   
        
        var url = this.url+'?enPk='+enPk+'&currentPageIndex=1&pageSize=20';
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
    		mclass: null,
    		method: METHODS.METHOD_GET,
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
            block.setData(m.dataList);
        }
    }
});