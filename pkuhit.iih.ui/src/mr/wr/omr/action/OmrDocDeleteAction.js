Ext.define('iih.mr.wr.omr.action.OmrDocDeleteAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
    	var self=this;
    	var owner = self.getOwner();
		var left=owner.getBlock('left');
		var mrTree=left.down("xaptree");
		var treeNode = mrTree.getSelectionModel().getSelection();		
		var parNode = treeNode[0].data.parentId;
		owner.parNode=parNode;
		var mr=treeNode[0].raw;
        var data={
            	mrPk:mr.mrPk,
            	encounterPk:mr.enPk,
            	updateCount:mr.updateCount
            };
		self.prepareOperations(context.operations,data);
	},
    prepareOperations: function(operations,datas) {
        var url = this.url;
        url += '/' + datas.mrPk;       
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_DELETE,
            condition: null,
            data:datas,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var owner = this.getOwner();
        
        var deleteBtn=owner.down('toolbar button[method=delete]');
     	var property=owner.down('toolbar button[method=property]');
     	property.setDisabled(true);
     	deleteBtn.setDisabled(true);
        var chain = owner.getActionChain('refresh');
        if(chain) {
            chain.execute({from:'delete'});
        }
    }
});