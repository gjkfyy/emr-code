Ext.define('iih.po.assistant.action.CompleteTaskAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	requires: ['iih.po.com.block.AssistantBlock','Xap.ej.element.grid.Grid'],
	
	doExecute: function(context) {
	    /*var app = Xap.getApp();
        app.baseUrl = "http://172.18.73.88:8081/";
        app.chainExecutor.baseUrl= "http://172.18.73.88:8081/";*/
        this.callParent();
        var taskPk = context.data.taskPk;
        var block = this.getBlock('content');
        var grid = block.down('xapgrid');
        var store = grid.getStore();
        var records = store.getModifiedRecords();
        var datasArr = [];
        for(var i=0;i<records.length;i++){
            datasArr.push(records[i].data);
        }
        var data = {taskPk:taskPk,taskArray:datasArr};
        var operations = context.operations;
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:data,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },

	onSuccess : function(operation) {
		var view = this.getOwner();
		var chain = view.getActionChain('search');
		chain.execute();
	}
});
