Ext.define('Xap.ej.action.IntelligentInputAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

    requires: ['Xap.ej.block.Layer'],

    doExecute: function(context) {
        this.prepareOperations(context);
    },

    prepareOperations: function(context) {
        var operations = context.operations;
        if(!operations) 
            return;
        var params = context.params;
        if(params && params.length >= 1) {
            var param = params[0];
            if(param) {
                var url = context.url;
                url += '?' + Ext.Object.toQueryString(param);
                var operation = {
                    url: url,
                    method: 'get',
                    scope: this,
                    success: this.onSuccess,
                    // TODO 更好的Callback方案，目前的实现只是为了跑通
                    callback: context.callback
                };
                operations.push(operation);
            }
        }
    },

    onSuccess: function(operation) {
        var result = operation.result;
		var data;
		if(Ext.isArray(result.dataList)) {
			data = result.dataList;
		};
		if(!Ext.isEmpty(result.data,false)) {
			data = result.data;
		};
		if(Ext.isArray(result) && Ext.isEmpty(result.data,false) && !Ext.isArray(result.dataList)) {
            var data = {};
            for(var i = 0; i < result.length; i++) {
                var d = result[i];
                if(d.id) {
                    data[d.id] = d;
                }
            }
        };
        if(operation.callback && Ext.isFunction(operation.callback)) {
			operation.callback(data);
		}
    }
});
