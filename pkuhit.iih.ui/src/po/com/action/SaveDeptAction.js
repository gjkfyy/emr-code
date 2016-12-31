Ext.define('iih.po.com.action.SaveDeptAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: [],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
        var url = this.url;
        var mclass = null;
        var condition = {
            deptId: IMER_GLOBAL.department.code,
            orgCd: IMER_GLOBAL.hospitalArea.code
        };
        var qs = Ext.Object.toQueryString(condition);
        url += '?' + qs;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: condition,
            scope: this
        };
        var operations = context.operations;
        operations.push(operation);
    }
});