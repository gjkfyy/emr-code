Ext.define('iih.po.assistant.action.ObservationLeftListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.showLoading();
		console.log('----------------ObservationLeftListAction-------------------');
		this.callParent();
        var operations = context.operations;      
        this.prepareOperations(operations,context);
    },
    prepareOperations : function(operations,context) {
    	var enSn = context.enPk||IMER_GLOBAL.encounterSn;//'838535';
    	var condition = '?enPk='+enSn+ '&currentPageIndex=1&pageSize=1000';   
    	 var url = this.url + condition;    
        //console.log(url);
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
    },
	onSuccess : function(operation) {
		//alert("success");
        var block = this.getBlock('west');
        var m = operation.result.dataList;
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				block.setData(m);
				var grid = block.down('xapgrid[name=observationLeftList]');
				grid.getSelectionModel().select(0);
				var observationreportview = block.up('observationreportview');
    		    var chain = observationreportview.getActionChain('center');
    		    chain.execute();
			}
		}else{
			block.setData([]);
			var observationreportview = block.up('observationreportview');
		    var chain = observationreportview.getActionChain('center');
		    chain.execute();
		}
    }
});
