Ext.define('iih.po.com.action.GetPatientInfoAndCallbackAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	
	/*
	* @Override
	*/
	callback: null,
	doExecute: function(context) {
	    this.callParent();
	    
	    this.callback = context.callback;
	    
	    var operations = context.operations;
        var url = 'mr/ens/' + context.patient.pk;
        var mclass = null;
        param = {
            'id': context.patient.pk
        };
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            params: [param],
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var data = operation.result.data;
        if (this.callback) {
        	this.callback.apply(this, [data]);
        }
    }
});
