Ext.define('iih.po.com.action.TaskSearchAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
    	var operations = context.operations;
    	if(!IMER_GLOBAL.encounterSn)return;
    	var url = this.url;
    	var mclass = null;
    	var condition = {
    	   encounterSn: IMER_GLOBAL.encounterSn
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
    
    onSuccess: function(operation) {
        var view = this.getOwner();
        var m = operation.result;
        var grid = view.down('xapgrid[name=taskGrid]');
        if(m && m.dataList && grid){
            grid.setData(m.dataList);
        }
    }
});