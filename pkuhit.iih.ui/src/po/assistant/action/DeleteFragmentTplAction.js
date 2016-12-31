Ext.define('iih.po.assistant.action.DeleteFragmentTplAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
	    var fragmentTplCd = context.fragmentTplCd;
    	this.prepareOperations(context.operations,fragmentTplCd);
	},
    prepareOperations: function(operations,fragmentTplCd) {
        var url = this.url;
        url += '/' + fragmentTplCd;       
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_DELETE,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var owner = this.getOwner();
        var chain = owner.getActionChain('init');
        if(chain) {
            chain.execute();
        }
        var center = owner.getBlock('center');
		center.down('xaptextarea').setValue();
    }
});