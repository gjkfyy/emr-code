Ext.define('iih.po.assistant.action.LabReportRightListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		console.log('----------------LabReportRightListAction-------------------');
		this.callParent();
        var operations = context.operations;      
        this.prepareOperations(operations);
    },
    prepareOperations : function(operations) {
    	var west = this.getBlock('west');
    	var grid = west.down('xapgrid[name=labReportLeftList]');
    	var records = grid.getSelectionModel().getSelection();
    	var labRpPk;
    	if(records.length>0){
    		labRpPk = records[0].get('labRpPk');
    		var condition = '?labRpPk='+labRpPk+ '&currentPageIndex=1&pageSize=25';   
            var url = this.url + condition;    
            console.log(url);
            var METHODS = this.getInvocationMethods();
            var operation = {
                url: url,
                mclass: null,
                method: METHODS.METHOD_GET,
                condition: null,
                data:condition,
                scope: this,
                success: this.onSuccess,
                //fail: this.onFail
            };
            operations.push(operation);	
    	}else{//如果不请求后台服务,则说明没有结果集
    		var block = this.getBlock('center')
    		block.setData([]);
    	}
    },
	onSuccess : function(operation) {
		//alert("success");
        var block = this.getBlock('center');
        var m = operation.result.dataList;
        //console.log(m);
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//console.log(m);				
				block.setData(m);
			}
		}else{
			block.setData([]);
		}
    }
});
