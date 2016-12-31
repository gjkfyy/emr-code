Ext.define('iih.po.com.action.SearchPortalAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.element.field.ComboBox'],
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    var operations = context.operations;
	    var orgCd;
        var event = context.event;
        if(event){
            var args = event.arguments;
            orgCd = args[1];
        }else{
            orgCd = IMER_GLOBAL.department.code;
        }
	    var url = this.url;
        var mclass = null;
        var condition = {
            userId: IMER_GLOBAL.user.code,
            orgCd: orgCd
        };
        var qs = Ext.Object.toQueryString(condition);
        url += '?' + qs;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: condition,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
	onSuccess : function(operation) {
	    var data = operation.result;
        var block = this.getBlock("context");
        block.setPortalData(data);
	}
});
