Ext.define('iih.mr.wr.mr.action.MrDocBtnUsableAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	doExecute : function(context) {
		var encounterSn = IMER_GLOBAL.encounterSn;
		this.prepareOperations(context.operations, encounterSn);
	},
	prepareOperations : function(operations, encounterSn) {
		var url = this.url + '/' + encounterSn;

		var mclass = null;
		var operation = {
			url : url,
			mclass : mclass,
			method : 'get',
			condition : null,
			scope : this,
			success : this.onSuccess
		};
		operations.push(operation);
	},
	onSuccess : function(operation) {
		var openType = this.getOwner().openType;
		var block = this.getBlock('result');
		if (operation.result.data) {
			var amr = operation.result.data;
			var statusCode = amr.statusCode;
			var deleteBtn = block.down('toolbar button[method=create]');
			var finishBtn = block.down('toolbar button[method=finish]');
			if ('ENM02.04' != amr.encounterStatusCode
					&& 'ENM02.06' != amr.encounterStatusCode) {
				finishBtn.setDisabled(true);
			} else {
				finishBtn.setDisabled(false);
			}
			if (statusCode != 'MRM22.01') {
				deleteBtn.setDisabled(true);
			} else {
				if (deleteBtn) {
					deleteBtn.setDisabled(false);
				}
			}
		}
		if (openType && openType == true) {
			var createBtn = block.down('toolbar button[method=create]');
			var deleteBtn = block.down('toolbar button[method=delete]');
			var mergerBtn = block.down('toolbar button[method=merger]');
			createBtn.hide();
			deleteBtn.hide();
			mergerBtn.hide();
		}
		

	}
});
