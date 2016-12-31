Ext.define('iih.mr.wr.omr.action.OmrToolbarsInitAction', {
	    extend: 'Xap.ej.action.ServiceInvocation',
	    
	    doExecute: function(context) {
			this.prepareOperations(context.operations);
		},
	    prepareOperations: function(operations) {
	        var url = this.url;
	        url = url+''+IMER_GLOBAL.encounterSn;  
	        var mclass = null;
	        var operation = {
	            url: url,
	            mclass: mclass,
	            method: 'get',
	            condition: null,
	            scope: this,
	            success: this.onSuccess
	        };
	        operations.push(operation);
	    },
	    onSuccess: function(operation) {
	        var owner = this.getOwner();
	        var amr=operation.result.data;
	        var deleteBtn=owner.down('toolbar button[method=delete]');
	        var createBtn=owner.down('toolbar button[method=create]');
	        var finishBtn=owner.down('toolbar button[method=complete]');
	        var cancelComplete=owner.down('toolbar button[method=cancelComplete]');
	        if(amr&&'MRM22.01'!=amr.statusCode){
	        	deleteBtn.setDisabled(true);
				createBtn.setDisabled(true);
				finishBtn.setDisabled(true);
				cancelComplete.setDisabled(false);
	        }else{
	        	deleteBtn.setDisabled(false);
				createBtn.setDisabled(false);
				finishBtn.setDisabled(false);
		        cancelComplete.setDisabled(true);
	        }
	    }
	});

