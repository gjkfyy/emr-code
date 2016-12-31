Ext.define('iih.masterdata.dataelement.dimensioncode.action.DictStoppedAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
		var owner = this.getOwner();
    	var me = this;
		var block = this.getBlock('result');
		var grid = block.down('xapgrid');
		var record = grid.getSelectionModel().getSelection();  //context.record;
		var pkDictgeneral = record[0].data.pkDictgeneral;
    	var operations = context.operations;
            	if(!operations) {
            		return;
        }
		me.prepareOperations(operations,pkDictgeneral);
    },
    
    prepareOperations: function(operations,pkDictgeneral){
        var url = this.url+'/'+pkDictgeneral;
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
        //刷新列表
    	var owner = this.getOwner();
    	var initChain = owner.getActionChain('init');
    	initChain.execute();
    }
});
