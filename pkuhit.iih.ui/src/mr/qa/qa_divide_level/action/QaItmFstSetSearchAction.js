Ext.define('iih.mr.qa.qa_divide_level.action.QaItmFstSetSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
		owner.fstNm = context.fstNm;
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
         	properties.setData({
            	eventNm : context.eventNm,
            	fstCd : context.fstCd
        });
		var data = {
			eventNm : context.eventNm,
			fstCd : context.fstCd
		}
		if(context.eventNm == 'addClick'){
    		
    	}else{
    		var operations = context.operations;
	    	if(!operations) {
	    		return;
	    	}
			this.prepareOperations(operations,data);
    	}
	},
    
    prepareOperations: function(operations,data) {
		var url = this.url + '?fstCd=' + data.fstCd;
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
        var m = operation.result;
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
