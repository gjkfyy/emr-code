Ext.define('iih.mr.dr.condition_set.action.ConditionInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		/*this. showLoading();
	     this.prepareOperations(context);*/
		var me = this;
	    var owner = this.getOwner();   
	    var conditionView = owner.sourceView;
	    var retrievalRecord = owner.retrievalRecord;
	    var retrievalCd = owner.retrievalCd;
//	    upcond  grade
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
        var block = this.getBlock('result').getBlock('left').getBlock('left');
        var noTree = block.down('xaptree');
        var m = operation; 
        if(m instanceof Ext.data.Model) {
        	gridBlock.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }else {
        	console.log(operation.result);
        	if(operation.result.root.children){
        		block.setData(operation.result.root.children);
        	}else{
        		block.setData(null);
        	}
        }
        noTree.collapseAll();
        
        //调用初始化Action，刷新方案条件设置画面
    	var memoChain = this.getOwner().getActionChain('initMemo');
    	memoChain.execute();
    }
});
