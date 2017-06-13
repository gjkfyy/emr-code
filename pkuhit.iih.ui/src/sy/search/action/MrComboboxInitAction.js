Ext.define('iih.sy.search.action.MrComboboxInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer'],
	
	doExecute: function(context) {
	    this.callParent();
	    var pageNum ,pageSize; 
	    var owner = this.getOwner();
		var block = owner.getBlock('condition');
	    
	    var data = {};
	    
	    if(pageNum == null){
	    	pageNum = 1;
	    }
	    if(pageSize == null){
	    	pageSize = 200;
	    }
	    data.pageNum = pageNum;
	    data.pageSize = pageSize;
	    
	    console.log(context);
        var operations = context.operations;      
        this.prepareOperations(operations,data);  
	},  
	 prepareOperations: function(operations,data) { 
        var url = this.url;   
        url += '?';
        for(var key in data){
        	url += '&'+ key + '=' + data[key];
        }
        var METHODS = this.getInvocationMethods();
        
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
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
     onSuccess: function(operation) {  //operation.result.dataList
         var data;
    	 var pageSize=this.getOwner().pageSize;
		 var owner = this.getOwner();
		 var mrShareElementCd = owner.getBlock('condition').down('xapcombobox[name=mr_element]');
         // TODO 数据格式就这样了？
         if(operation.result){
 	        resultData=operation.result.dataList;
 	        mrShareElementCd.setData(resultData);
         }else{
        	 mrShareElementCd.setData([]);
         }
     }    
});