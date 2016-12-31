Ext.define('iih.mr.qa.qa_divide_level.action.QaDivideLevelSetSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
         	properties.setData({
            	eventNm : context.eventNm,
            	qaDivideLevelCd : context.qaDivideLevelCd
        });
		var block = this.getBlock('content');
		var lvl = block.down('xapcombobox[name=lvl]');
		var data = {
			eventNm : context.eventNm,
			qaDivideLevelCd : context.qaDivideLevelCd
		}
		if(context.eventNm == 'addClick'){
    		lvl.disabled = false;
    	}else{
    		lvl.disabled = true;
    		var operations = context.operations;
	    	if(!operations) {
	    		return;
	    	}
			this.prepareOperations(operations,data);
    	}
	},
    
    prepareOperations: function(operations,data) {
		var url = this.url + '?qaDivideLevelCd=' + data.qaDivideLevelCd;
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
