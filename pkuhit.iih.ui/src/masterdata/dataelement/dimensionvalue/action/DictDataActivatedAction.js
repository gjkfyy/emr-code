Ext.define('iih.masterdata.dataelement.dimensionvalue.action.DictDataActivatedAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
		var owner = this.getOwner();
    	var me = this;
		var block = this.getOwner().getBlock('result');
		var grid = block.down('xapgrid');
		var record = grid.getSelectionModel().getSelection();
		var pkDictgendata = record[0].data.pkDictgendata;
    	var operations = context.operations;
            	if(!operations) {
            		return;
        }
		me.prepareOperations(operations,pkDictgendata);
    },
    
    prepareOperations: function(operations,pkDictgendata){
        var url = this.url+'/'+pkDictgendata;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
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
