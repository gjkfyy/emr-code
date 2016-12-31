Ext.define('iih.mr.qa.qa_divide_level.action.QaItmSndCobSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
		var block = this.getBlock('content');
		block.sndCd = owner.sndCd;
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var block = this.getBlock('content');
        var qaItmFst=block.down('[name=fstCd]').getValue();
        var condition={"qaItmFst":qaItmFst};
        var url = this.url;
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
            if(qs) {
                url += '?'+qs;
            }
        }
        var operation = {
                url: url,
                method: 'get',
                condition: condition,
                scope: this,
                success: this.onSuccess
                // fail: this.onFail
            };
        operations.length = 0;
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var block = this.getBlock('content');
    	var data = block.data;
    	var sndCd = block.sndCd;
        var qaItmFst=block.down('[name=fstCd]');
        var qaItmSnd=block.down('[name=sndCd]');
    	if(operation.result){
            qaItmSnd.setData(operation.result.dataList);
            if(sndCd == undefined || sndCd == ''){
            	qaItmSnd.selectAt(0);
            }else{
            	qaItmSnd.select(sndCd);
            }
            
            var view = this.getOwner();
            var initChain = view.getActionChain('init');
            initChain.execute({
            	data:data
            });
        }
    }
});
