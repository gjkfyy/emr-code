Ext.define('iih.sy.followup.action.FollowUpListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer'],
	doExecute: function(context) {
		this.showLoading();
	    this.callParent();
	    var pageNum ,pageSize; 
		if(context.event != undefined){
			console.log("aaa");
			pageNum = context.event.arguments[0];
			pageSize = context.event.arguments[1];
		}else if(context != undefined){
			console.log("bbb");
			pageNum = context.pageNum;
			pageSize = context.pageSize;
		}else{
			console.log("ccc");
			pageNum = 1;
			pageSize = 25;
		}
		var owner = this.getOwner();
		var block = owner.getBlock('right');
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
	    console.log(context);
        var operations = context.operations;      
        this.prepareOperations(operations,data);  
	},  
	 prepareOperations: function(operations,data) { 
        var url = this.url;    
        url += '?'+"&pageNum="+data.pageNum+"&pageSize="+data.pageSize+"&fuDate="+data.fuDate+"&fuFlag="+data.fuFlag+"&fuType="+data.fuType+"&fuValue="+data.fuValue+"&diagnosis="+data.diagnosis;
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