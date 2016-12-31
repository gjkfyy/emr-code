Ext.define('iih.mr.wr.mr.action.MrTypeCcatTreeSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.element.tree.Tree'],
	/*
	* @Override
	*/
	execute: function(context) {
	    var block = this.getBlock('result');
        block.loadingMask = Ext.create('Xap.ej.element.window.LoadMask', block);
        block.loadingMask.show();
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var url = this.url;
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess,
                fail: this.onFail
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	if(operation.result){
    	    var block = this.getBlock('result');
    	    var tree = block.down('xaptree');
            if(tree){
                var obj=eval(operation.result.data.children);  
                tree.setData(obj);
            }
        };
        var block = this.getBlock('result');
        block.loadingMask.hide();
        block.updateLayout();
    },
    onFail: function(operation) {
        var block = this.getBlock('result');
        block.loadingMask.hide();
        block.updateLayout();
    }
});
