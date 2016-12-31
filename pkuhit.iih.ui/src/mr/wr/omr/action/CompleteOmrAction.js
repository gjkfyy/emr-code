Ext.define('iih.mr.wr.omr.action.CompleteOmrAction', {
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
	    	XapMessageBox.info('操作成功!');
	        var owner = this.getOwner();
	        var deleteBtn=owner.down('toolbar button[method=delete]');
	        var createBtn=owner.down('toolbar button[method=create]');
	        var finishBtn=owner.down('toolbar button[method=complete]');
			deleteBtn.setDisabled(true);
			createBtn.setDisabled(true);
			finishBtn.setDisabled(true);
			
			var patient={
	        	pk: IMER_GLOBAL.encounterSn
			};
			var canvas = Xap.getCanvas();
			canvas.fireEvent("updatePatient",{patient:patient});
			
	        var chain = owner.getActionChain('refresh');
	        if(chain) {
	            chain.execute();
	        }
	    }
	});

