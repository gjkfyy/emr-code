Ext.define('iih.sy.search.action.HistoryDeleteAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		var owner = this.getOwner();
    	var me = this;
    	//获取方案列表的 block
		var block = this.getBlock('result');
		var retrievalGrid = block.down('xapgrid');
		var record = context.record;
    	var operations = context.operations;
            	if(!operations) {
            		return;
        }
		me.prepareOperations(operations,record);
    },
    
    prepareOperations: function(operations,record){
        var url = this.url+'/'+record.data.id;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_DELETE,
            condition: null,	
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        //刷新方案列表
    	var owner = this.getOwner();
    	var searchPlanChain = owner.getActionChain('init');
    	searchPlanChain.execute();
    }
})