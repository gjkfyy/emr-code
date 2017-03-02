Ext.define('iih.sy.search.action.SearchHistoryAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		return;
		this.showLoading();
    	var owner = this.getOwner();
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	
    	this.prepareOperations(operations,context);
    },
    
    prepareOperations: function(operations,context) {

    },

    onSuccess: function(operation) {

    }
});
