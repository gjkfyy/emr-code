Ext.define('iih.mr.dr.plan.action.PlanExecSearchAction', {
	
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this. showLoading();
	    this.prepareOperations(context);
	},
	prepareOperations: function(context) {
		var me = this;
	    var owner = this.getOwner();   

		var operations = context.operations;
        var bottomBlock = this.getBlock('result');  
        var event = context.event;
        var url = this.url;
        var enGrid = bottomBlock.down('xapgrid');
	    var selModel = enGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
		var retrievalCd = record.data.retrievalCd;
		url += "/"+retrievalCd;
        /*var conditionView = owner.getBlock('condition');
        var conditionBlock = conditionView.getBlock('content');
    	var condition = conditionBlock.getData();
		if(condition) {
            var qs = Ext.Object.toQueryString(condition);
            url += '?' +qs;
		}*/
    	var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	var owner = this.getOwner();  
    	var socuseOwner = owner.socuseOwner;
        var block = socuseOwner.getBlock('result');
        var conditionGrid = block.down('xapgrid');
        var m = operation.result;
        if(Ext.isEmpty(m.dataList,true)){
        	conditionGrid.setData([]);
        }else{
        	conditionGrid.setData(m.dataList);
        }
        owner.ownerCt.close();
    }
});
