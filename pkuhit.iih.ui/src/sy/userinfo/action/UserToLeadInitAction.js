Ext.define('iih.sy.userinfo.action.UserToLeadInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            parentWindow: context.parentWindow,
            sourceView: context.sourceView
        });
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        var block = this.getBlock('condition');
    	var condition = block.getData();
        var url = this.url;
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
//            alert(qs);
            if(qs) {
                url += '?' + qs;
            }
            console.log(url);
        }
        var mclass = null;
        if(block.getModelClass) {
            mclass = block.getModelClass();
        }
    	var operation = {
            url: url,
    		mclass: mclass,
    		method: 'get',
    		condition: condition,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('result');
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
        }
        // var r = rb.getData();
    }
});
