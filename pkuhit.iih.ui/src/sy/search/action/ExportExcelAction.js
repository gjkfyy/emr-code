Ext.define('iih.sy.search.action.ExportExcelAction', {
extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer'],
	doExecute: function(context) {
		 
		this.showLoading();
	    this.callParent();
	    var pageNum ,pageSize; 
	    var owner = this.getOwner();
		var block = owner.getBlock('condition');
		this.turnpage = false;
	    if(context.event && context.event.name == "turnpage"){
	    	this.turnpage = true;
    		pageNum = context.event.arguments[0];
    		pageSize = context.event.arguments[1];
		}else {
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}
    	 
	    
	    var data = block.getItemData(block);
		
	    for(var key in data){
	    	if(data[key] == null || data[key] == undefined){
	    		delete data[key];
	    	}
	    	
	    	if(data[key] instanceof Date){
	    		var date = data[key];
	    		data[key] = Ext.Date.format(date,'Y-m-d H:i:s');
	    		//data.key = date.format("Y-m-d H:i:s");
	    	}
	    }
	   
        var operations = context.operations;      
        this.prepareOperations(operations,data);  
	},  
	
	 prepareOperations: function(operations,data) { 
        var url = this.url;   
        if(data) {
            var qs = Ext.Object.toQueryString(data);
            if(qs) {
                url += '?' + qs;
            }
        }
        var METHODS = this.getInvocationMethods();
        var url = Xap.getApp().getBaseUrl()+url;
        window.location.href =url;
//        var operation = {
//            url: url,
//            mclass: null,
//            method: METHODS.METHOD_GET,
//            condition: null,
//            data:data,
//            scope: this,
//            success: this.onSuccess,
//            fail: this.onFail
//        };
        //operations.push(operation);	    
	 },
	 
	 onFail: function(operation) { 
		 alert("查询失败");
	 },  
     onSuccess: function(operation) {

     }    
});
