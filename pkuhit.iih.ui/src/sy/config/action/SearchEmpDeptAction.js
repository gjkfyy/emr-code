Ext.define('iih.sy.config.action.SearchEmpDeptAction', {
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
	        orgCd = IMER_GLOBAL.hospitalArea.code;
	    }
	    var url = this.url;
        var mclass = null;
        var condition = {
            userId: IMER_GLOBAL.user.code,
            orgTpCd: IMER_CONSTANT.ORG_TYPE_CD_4,
            parOrgCd: orgCd
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
	    if(data){
	        var block = this.getBlock("context");
	        block.setData(data);
	    }
	}
});
