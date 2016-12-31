Ext.define('iih.po.com.action.OtherOmrImplWayAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        var operations = context.operations;
        var url = this.url+'?key=IMPL_WAY';
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var view = this.getOwner();
        var block = this.getBlock('helpContent');
        var otherOmr = block.down('button[itemId=otherOmr]');
        var m = operation.result;
		if(m.data != null && m.data == '1'){ //调用cis病历
			view.url='externalInterf';
		}else if(m.data != null && m.data == '0'){ //0 为六院调用安博维病历
			view.url='mr/other';
	    }
    }
});