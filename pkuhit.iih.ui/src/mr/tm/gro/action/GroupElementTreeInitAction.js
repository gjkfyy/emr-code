Ext.define('iih.mr.tm.gro.action.GroupElementTreeInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		console.log('---------------------------- GroupElementTreeInitAction ---------------------------------');
	    this.callParent();
    	var operations = context.operations;
    	var url = this.url;
        var condition = {};
    	var METHODS = this.getInvocationMethods();
    	var method = METHODS.METHOD_GET;
        condition = Ext.apply(condition,{typeCode:'MRM11.01'});
    	var mclass = null;
    	var form = this.getOwner().getBlock('top');
    	condition = Ext.apply(condition,form.getData());
    	var qs = Ext.Object.toQueryString(condition);
    	url += '?' + qs;
    	console.log(url);
    	var operation = {
    	    url: url,
    	    mclass: mclass,
    	    method: method,
    	    condition: null,
            scope: this,
            success: this.onSuccess
    	};
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var block = this.getBlock('bottom');
        var tree;
        var m = operation.result;
        console.log(m);
		if(m){//组合元素
			tree = block.down('xaptree[name=grpTree]');
            tree.setData(m.root);
        }
    }
});