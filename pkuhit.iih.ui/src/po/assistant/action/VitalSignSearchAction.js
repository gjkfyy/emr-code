Ext.define('iih.po.assistant.action.VitalSignSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context){
		var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	var date = context.date;
    	this.prepareOperations(operations,date);
    },

    prepareOperations: function(operations,date) {
    	var encounterSn = IMER_GLOBAL.encounterSn;
    	var startTime = date.beginTime+" 00:00:00";
    	var endTime = date.endTime+" 23:59:59";
    	var params = {enPk:encounterSn,acquisitionStartTime:startTime,acquisitionStopTime:endTime};
    	var url = "nu/vitalsigns";
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
    		mclass: null,
    		method: METHODS.METHOD_GET,
    		condition: null,
    		params:params,
    		scope: this,
    		success: this.onSuccess,
            fail: this.onFail
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	//alert("onSuccess1");
        var block = this.getBlock('result');
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }else{
            block.setData(m);
        }
    },
    onFail: function(operation) {
        alert("保存失败!");
    }
});