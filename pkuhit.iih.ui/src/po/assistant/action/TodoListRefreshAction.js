Ext.define('iih.po.assistant.action.TodoListRefreshAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	requires: ['iih.po.com.block.AssistantBlock'],
	
	doExecute: function(context) {
        this.callParent();
        var operations = context.operations;
        var url = this.url;
        var mclass = null;
        var view = this.getOwner();
        var assistant = view.up('assistantblock');
        var condition = {
           tgtObCd: assistant.tgtObCd,
           tgtObPk: assistant.tgtObPk
        };
        var qs = Ext.Object.toQueryString(condition);
        url += '?' + qs;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: condition,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },

	onSuccess : function(operation) {
		var block = this.getBlock('content');
		var m = operation.result;
		block.setData(m);
	}
});
