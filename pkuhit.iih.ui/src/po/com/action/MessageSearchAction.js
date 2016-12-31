Ext.define('iih.po.com.action.MessageSearchAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    
	    var pageNum; 
        var pageSize = 20;
        if(context.event && context.event.name == 'turnpage'){
            pageNum = context.event.arguments[0]; 
            pageSize = context.event.arguments[1];
        }
        this.turnpage = false;
        if(pageNum)
            this.turnpage = true;
        
    	var operations = context.operations;
    	var url = this.url;
    	var mclass = null;
    	var condition = {
    	   userCd: IMER_GLOBAL.user.code,
    	   pageSize: pageSize,
           pageNum: pageNum
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
        var grid = view.down('xapgrid');
        if(m && m.dataList && grid){
            if(this.turnpage)
                grid.setData(m.dataList);
            else
                grid.setPageData(m);
        }
    }
});