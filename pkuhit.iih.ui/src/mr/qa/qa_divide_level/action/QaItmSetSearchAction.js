Ext.define('iih.mr.qa.qa_divide_level.action.QaItmSetSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var data = context.data;
		var qaItmCd = data.qaItmCd;

		if(data.eventNm == 'addClick'){
			
    	}else{
    		var operations = context.operations;
	    	if(!operations) {
	    		return;
	    	}
			this.prepareOperations(operations,qaItmCd);
    	}
	},
    
    prepareOperations: function(operations,qaItmCd) {
		var url = this.url + '?qaItmCd=' + qaItmCd;
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
        var block = this.getBlock('content');
        var  qaItmFst = block.down('xapcombobox[name=fstCd]');
        var  qaItmSnd = block.down('xapcombobox[name=sndCd]');
        var m = operation.result;
        qaItmFst.select(m.fstCd);
        qaItmSnd.select(m.sndCd);
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
        	block.setData(m);
        	console.log(m);
        }
    }
});
