Ext.define('iih.mr.qa.process_qa_work.action.QaItmSndSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var block = this.getBlock('content');
        var qaItmFst=block.down('[name=qaItmFst]').getValue();
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
        var qaItmFst=block.down('[name=qaItmFst]');
        var qaItmSnd=block.down('[name=qaItmSnd]');
    	if(operation.result.dataList){
            qaItmSnd.setData(operation.result.dataList);
        }
        var qaItmFstValue = qaItmFst.getValue();
        qaItmSnd.select("ALL");
        var qaItmSndValue = qaItmSnd.getValue();
        if(qaItmSndValue == 'ALL'){
        	qaItmSndValue = "";
        }
        var view = this.getOwner();
        var initChain = view.getActionChain('init');
        initChain.execute({
        	qaItmFst: qaItmFstValue,
        	qaItmSnd : qaItmSndValue,
        	encounterPk:data.encounterPk,
    		mrTypeCode:data.mrTypeCode,
    		mrSegmemtTypeCode:data.mrSegmemtTypeCode
        });
    }
});
