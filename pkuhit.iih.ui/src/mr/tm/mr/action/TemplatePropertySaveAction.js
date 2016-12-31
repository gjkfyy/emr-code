Ext.define('iih.mr.tm.mr.action.TemplatePropertySaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
	   this.callParent();
	   console.log('--------------------- TemplatePropertySaveAction -----------------------------');
	   var operations = context.operations;
	   var data = {};
	   data.code = context.code;
	   data.baseTemplateCode = context.baseCode;
	   this.prepareOperations(operations,data);
	},
    prepareOperations: function(operations,data) {
        var url = this.url+'/'+data.code;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:data,
            scope: this,
            success: this.onSuccess
            // fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var result = operation.result;
    	return;
    },
    
    onFail: function(operation) {
    	return;
    }
});
