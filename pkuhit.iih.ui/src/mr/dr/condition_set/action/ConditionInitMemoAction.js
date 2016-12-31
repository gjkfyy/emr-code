Ext.define('iih.mr.dr.condition_set.action.ConditionInitMemoAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		var me = this;
	    var owner = this.getOwner();   
	    var conditionView = owner.sourceView;
	    var retrievalRecord = owner.retrievalRecord;
	    var retrievalCd = owner.retrievalCd;
	    this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var me = this;
	    var owner = this.getOwner();   
	    var retrievalCd = owner.retrievalCd;
		var operations = context.operations;
        var url = this.url;
        var qs = 'retrievalCd=' + retrievalCd ;
    	var operation = {
            url: url + '?' +qs,
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
        var block = this.getBlock('result');
        var data = operation.result.data;
        if(data!=null && data!='undefined'){
	        var memo = data.memo; 
			var condMemo = block.down('xaptextarea[name=conditionMemo]');
			condMemo.setValue(memo);
	    }
    }
});
