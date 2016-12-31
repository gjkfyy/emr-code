Ext.define('iih.po.com.action.SyncOrgAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        var operations = context.operations;
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        
    }
});