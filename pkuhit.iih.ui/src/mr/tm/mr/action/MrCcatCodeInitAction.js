Ext.define('iih.mr.tm.mr.action.MrCcatCodeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
	    this.callParent();
	    var sourceView = this.getOwner();
	    var enTypeCode = sourceView.enTypeCode;
        var operations = context.operations;
        this.prepareOperations(operations);        
	},  
	 prepareOperations: function(operations) {
		//查询
        //var condition = '?statusCode='+'MRM06.02';
		 var sourceView = this.getOwner();
		 var enTypeCode = sourceView.enTypeCode;
		 
        var url = this.url + '?enTypeCode='+enTypeCode;   
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:null,
            scope: this,
            success: this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	    
    onSuccess: function(operation) {
    	
        var block = this.getBlock('result').down('[name=mrTplCCat]')
        var m = operation.result;
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}
			else {
				//遍历结果,重新赋值，对于不对应的dataIndex
				var data =m.dataList
				Ext.Array.forEach(data,function(node,index,array){ 
						node.mrTypeCd = node.name;
				});
				block.setData(m.dataList);
			}
		
		}
    }    
});

