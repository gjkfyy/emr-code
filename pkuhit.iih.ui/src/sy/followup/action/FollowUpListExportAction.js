Ext.define('iih.sy.followup.action.FollowUpListExportAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer'],
	doExecute: function(context) {
		this.showLoading();
	    this.callParent();
	    var pageNum ,pageSize; 
	    var owner = this.getOwner();
		var block = owner.getBlock('right');
		this.turnpage = false;
	    if(context.event && context.event.name == "turnpage"){
	    	this.turnpage = true;
    		pageNum = context.event.arguments[0];
    		pageSize = context.event.arguments[1];
		}else {
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}
	   
		var fuDate = block.down('xapcombobox[name=fuDate]');
		var fuFlag = block.down('xapcombobox[name=fuFlag]');
		var fuType = block.down('xapcombobox[name=fuType]');
		var fuValue = block.down('xaptextfield[name=fuValue]');
		var diagnosis = block.down('xaptextfield[name=diagnosis]');
	    var data = {
				pageNum : pageNum,
				pageSize : pageSize,
				fuDate : fuDate.value,
				fuFlag : fuFlag.value,
				fuType : fuType.value,
				fuValue : fuValue.value,
				diagnosis : diagnosis.value
		}
	   
        var operations = context.operations;      
        this.prepareOperations(operations,data);  
	},  
	 prepareOperations: function(operations,data) { 
        var url = this.url;    
        var from = "&_from=followup"
        url += '?'+"&pageNum="+data.pageNum+"&pageSize="+data.pageSize+"&fuDate="+data.fuDate+"&fuFlag="+data.fuFlag+"&fuType="+data.fuType+"&fuValue="+data.fuValue+"&diagnosis="+data.diagnosis+from;
        var METHODS = this.getInvocationMethods();
        
        var url = Xap.getApp().getBaseUrl()+url;
        
        //window.location.href =url;
        //动态创建iframe访问导出文件url
        var iframe = document.createElement("iframe"); 
        iframe.src = url; 
        if (iframe.attachEvent) {
			iframe.attachEvent("onload", function() {
				this.hideLoading();
			});
		} else {
			iframe.onload = function() {
				this.hideLoading();
			};
		} 
        document.body.appendChild(iframe);
        if (document.readyState == "complete") {
        	this.hideLoading();
        }
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
//        operations.push(operation);	    
	 },
	 
	 onFail: function(operation) { 
		 alert("查询失败");
	 },  
     onSuccess: function(operation) {/*
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
     */}    
});