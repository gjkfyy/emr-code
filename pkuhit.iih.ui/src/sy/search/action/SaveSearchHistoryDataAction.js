Ext.define('iih.sy.search.action.SaveSearchHistoryDataAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer',
	           'iih.sy.search.block.EMRSearchConditionBlock'],
	
	doExecute: function(context) {
		 
		this.showLoading();
	    this.callParent();
	    var owner = this.getOwner();
	    
		var contentBlock = owner.getBlock('content');
		//var conditionBlock = owner.getBlock('condition');
		var conditionBlock=Ext.getCmp('emrsearchconditionblock');
		
		var userId = IMER_GLOBAL.user.code;

	    console.log(context);
	    
	    var content = contentBlock.getItemData(contentBlock);
	    var condition = conditionBlock.getItemData(conditionBlock);
	    
	    for(var key in condition){
	    	
	    	if(condition[key] instanceof Date){
	    		var date = condition[key];
	    		condition[key] = Ext.Date.format(date,'Y-m-d H:i:s');
	    	}
	    }
	    
	    var data = {};
	    data.conditionName = content.conditionData;
	    data.userId = userId;
	    data.condition = Ext.JSON.encode(condition);
		
        var operations = context.operations;      
        this.prepareOperations(operations,data);  
	},  
	 prepareOperations: function(operations,data) { 
        var url = this.url;   
        var METHODS = this.getInvocationMethods();
        
        var operation = {
            url: url,
            mclass: null,
            method: 'post',
            condition: null,
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