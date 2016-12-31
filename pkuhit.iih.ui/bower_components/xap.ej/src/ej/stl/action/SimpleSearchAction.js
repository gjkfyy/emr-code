Ext.define('Xap.ej.stl.action.SimpleSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    doExecute: function(context) {
        this.prepareOperations(context.operations);
    },

    /*
    * @return {mclass: '', condition: {}}
    */
    prepareOperations: function(operations) {
        var block = this.getBlock('condition');
    	var condition = block.getData();
        var url = this.url;
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
            if(qs) {
                url += '?' + qs;
            }
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
    		// fail: this.onFail
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
