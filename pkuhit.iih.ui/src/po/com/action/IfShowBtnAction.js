Ext.define('iih.po.com.action.IfShowBtnAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        var operations = context.operations;
        var url = this.url+'?key=IF_SHOW_BTN';
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
		if(m.data != null && m.data == '1'){ //显示
			otherOmr.show();
			var chain = view.getActionChain('otherOmrImplWay');
	        chain.execute();
		}else if(m.data != null && m.data == '0'){ //0 为不显示
	        otherOmr.hide();
	    }
    }
});