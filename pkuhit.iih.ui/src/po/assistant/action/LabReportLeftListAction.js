Ext.define('iih.po.assistant.action.LabReportLeftListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.showLoading();
		console.log('----------------LabReportLeftListAction-------------------');
		this.callParent();
        var operations = context.operations;      
        this.prepareOperations(operations,context);
    },
    prepareOperations : function(operations,context) {
    	var enPk = context.enPk||IMER_GLOBAL.encounterSn;//'838535';
    	var condition = '?enPk='+enPk+ '&currentPageIndex=1&pageSize=1000';   
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
        operations.length = 0;
        operations.push(operation);	 
    },
	onSuccess : function(operation) {
		//alert("success");
        var block = this.getBlock('west');
        var m = operation.result.dataList;
        // TODO 数据格式就这样了？
		if(m){
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//console.log(m);
				block.setData(m);
				var grid = block.down('xapgrid[name=labReportLeftList]');
				grid.getSelectionModel().select(0);
				var checkview = block.up('labreportview');
    		    var chain = checkview.getActionChain('center');
    		    chain.execute();
			}
		}else{
			block.setData([]);
			var checkview = block.up('labreportview');
		    var chain = checkview.getActionChain('center');
		    chain.execute();
		}
    }
});
