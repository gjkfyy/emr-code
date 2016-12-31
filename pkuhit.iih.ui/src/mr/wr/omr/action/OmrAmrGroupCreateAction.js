Ext.define('iih.mr.wr.omr.action.OmrAmrGroupCreateAction', {
	    extend: 'Xap.ej.action.ServiceInvocation',
	    
	    doExecute: function(context) {
			this.prepareOperations(context.operations);
		},
	    prepareOperations: function(operations) {
	        var url = this.url;
	        url = url+'/'+IMER_GLOBAL.encounterSn;  
	        var mclass = null;
	        var METHODS = this.getInvocationMethods();
	        var operation = {
	            url: url,
	            mclass: mclass,
	            method: METHODS.METHOD_CREATE,
	            condition: null,
	            scope: this,
	            success: this.onSuccess
	        };
	        operations.push(operation);
	    },
	    onSuccess: function(operation) {
	    	var owner=this.getOwner();
			var treeInit = owner.getActionChain('treeInit');
			treeInit.execute();
			var outdiagnosisview=Ext.getCmp('outdiagnosisview');
			outdiagnosisview.fireEvent('selectEncounter');
	    }
	});

