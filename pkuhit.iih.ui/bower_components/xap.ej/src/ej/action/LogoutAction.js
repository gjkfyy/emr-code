Ext.define('Xap.ej.action.LogoutAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

    doExecute: function(context) {
        var operations = context.operations;
        if(!operations) 
            return;
        var url = this.url || 'logout';
        var operation = {
            url: url,
            method: 'post',
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },

    onSuccess: Ext.emptyFn,

    onFailure: Ext.emptyFn
});
