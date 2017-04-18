Ext.define('iih.sy.patient.action.DelMrDocAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
    	var self=this;
//    	var owner = self.getOwner();
		var result=self.getBlock('result');
		var mrTree=result.down("xapgrid");
		var treeNode = mrTree.getSelectionModel().getSelection();		
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
    	XapMessageBox.info('删除成功');
        var init = owner.getActionChain('init');
        if(init) {
        	init.execute();
        }
    }
});