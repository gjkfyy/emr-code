Ext.define('iih.mr.wr.mr.action.MrDocListSelectAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		var self=this;  
		var rb = this.getBlock('result');
		var grid = rb.down('xapgrid[name=mrDocGrid]'); 
		var selected=grid.getSelectionModel().getSelection();
		var mrPk = selected[0].data.mrPk;
		self.prepareOperations(context.operations,mrPk);
	},
    prepareOperations: function(operations,mrPk) {
    	
        var url = this.url;
        url += '/'+mrPk+'?withFile=false';  
        
        var mclass = null;
        var METHODS = this.getInvocationMethods();
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
    	var canDelete = operation.result.data.canDelete;
    	var owner = this.getOwner();
        var deleteBtn=owner.down('toolbar button[method=delete]');
    	if(canDelete!=1){
			deleteBtn.setDisabled(true);
    	}else{
    		deleteBtn.setDisabled(false);
    	}
    }
});
