Ext.define('Xap.ej.stl.action.DictionaryAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

    requires: ['Xap.ej.block.Layer'],

    doExecute: function(context) {
        this.prepareOperations(context);
    },

    prepareOperations: function(context) {
        var operations = context.operations;
        if(!operations) 
            return;
        var layer = this.getCanvasLayer();
        var data = layer.getData();

        var params = [];
        for(var name in data) {
            params.push(name);
        }
        if(params.length <= 0)
            return;
         var url = '/dictionary';
        if(params.length > 0) {
            url += '?id=' + params.toString();
        }

    	var operation = {
            url: url,
    		method: 'get',
    		scope: this,
    		success: this.onSuccess,
            // TODO 更好的Callback方案，目前的实现只是为了跑通
            callback: context.callback
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var result = operation.result;
        var layer = this.getCanvasLayer();
        if(Ext.isArray(result)) {
            var data = {};
            for(var i = 0; i < result.length; i++) {
                var d = result[i];
                if(d.id) {
                    data[d.id] = d;
                }
            }
            result = data;
        }
        layer.setData(result);
        // TODO 更好的Callback方案，目前的实现只是为了跑通
        if(operation.callback && Ext.isFunction(operation.callback)) {
            operation.callback(layer);
        }
    },

    getCanvasLayer: function() {
        var block = this.getBlock('target');
        var layer = block.getLayer(Xap.ej.block.Layer.DEFAULT);
        return layer;
    }
});
