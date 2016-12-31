Ext.define('iih.mr.tm.fr.action.FrTplListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
		this.showLoading();
	    this.callParent();
	    var pageNum ,pageSize; 
		if(context.event != undefined){
			pageNum = context.event.arguments[0];
			pageSize = context.event.arguments[1];
		}else{
			pageNum = context.pageNum;
			pageSize = context.pageSize;
		}
	    var data = {
				pageNum : pageNum,
				pageSize : pageSize
		}
        var operations = context.operations;      
        this.prepareOperations(operations,data);  
	},  
	 prepareOperations: function(operations,data) { 
		var pageNum = data.pageNum; 
		var pageSize = data.pageSize;   
        var url = this.url;    
        url +='?' + "&pageNum="+ pageNum +"&pageSize="+ pageSize;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:null,
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
        //alert("success");
        var gridBlock = this.getBlock('result');
//        var gridBlock = block.down('bastemplatelistblock')
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
        	gridBlock.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {        
        	gridBlock.setGridData(m);
        }
    
    }    
});
