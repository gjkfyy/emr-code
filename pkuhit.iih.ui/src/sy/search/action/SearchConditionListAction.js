Ext.define('iih.sy.search.action.SearchConditionListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer'],
	
	
	doExecute: function(context) {
		 
		//this.showLoading();
	    this.callParent();
	    var pageNum ,pageSize; 
	    var owner = this.getOwner();
	    
		this.turnpage = false;
	    if(context.event && context.event.name == "turnpage"){
	    	this.turnpage = true;
    		pageNum = context.event.arguments[0];
    		pageSize = context.event.arguments[1];
		}else {
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}
	    console.log(context);
	    
	    var userId = IMER_GLOBAL.user.code;
	    
	    if(pageNum == null){
	    	pageNum = 1;
	    }
	    if(pageSize == null){
	    	pageSize = 20;
	    }
	    
	    var data = {};
	    data.userId = userId;
	    data.pageNum = pageNum+"";
	    data.pageSize = pageSize+"";
	    
	    console.log(context);
	   
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
        
        var operation = {
            url: url,
            mclass: null,
            method: 'get',
            condition: data,
            data:data,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);	    
	 },
	 
	 onFail: function(operation) { 
		 alert("查询失败");
	 },  
     onSuccess: function(operation) {
         var data;
    	 var pageSize=this.getOwner().pageSize;
    	 var block = this.getBlock('result');
         // TODO 数据格式就这样了？
         if(operation.result){
 	        resultData=operation.result;
 	        if(this.turnpage){
 	        	resultData.pageSize =undefined;
 	        }
 	        console.log(resultData);
     	 	block.setData(resultData);
         }else{
        	block.setData(null);
         }
     }    
});