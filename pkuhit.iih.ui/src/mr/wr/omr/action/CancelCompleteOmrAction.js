Ext.define('iih.mr.wr.omr.action.CancelCompleteOmrAction', {
	    extend: 'Xap.ej.action.ServiceInvocation',
	    
	    doExecute: function(context) {
			this.prepareOperations(context.operations);
		},
	    prepareOperations: function(operations) {
	        var url = this.url;
	        url = url+'/'+IMER_GLOBAL.encounterSn;  
	        var mclass = null;
	        var operation = {
	            url: url,
	            mclass: mclass,
	            method: 'delete',
	            condition: null,
	            scope: this,
	            success: this.onSuccess
	        };
	        operations.push(operation);
	    },
	    onSuccess: function(operation) {
	    	XapMessageBox.info('操作成功!');
	        var owner = this.getOwner();
	        var createBtn=owner.down('toolbar button[method=create]');
	        var finishBtn=owner.down('toolbar button[method=complete]');
	        var cancelComplete=owner.down('toolbar button[method=cancelComplete]');
	        cancelComplete.setDisabled(true);
			createBtn.setDisabled(false);
			finishBtn.setDisabled(false);
	    }
	});

