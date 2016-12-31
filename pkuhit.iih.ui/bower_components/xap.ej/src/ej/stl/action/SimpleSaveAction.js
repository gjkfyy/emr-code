Ext.define('Xap.ej.stl.action.SimpleSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [
        'Xap.ej.data.DataModel'
    ],

    doExecute: function(context) {
        if(!this.doValid()) {
            // TODO
            return false;
        }
        if(!this.doSave(context))
            return false;
        return true;
    },

    doValid: function() {
        var content = this.getBlock('content');
        if(content) {
            return content.isValid();
        }
        return true;
    },

    doSave: function(context) {
        var data = this.getData(context);
        if(!data) {
            return false;
        }
        var METHODS = this.getInvocationMethods();
        var o = {};
        o.data = data;
        o.url = this.url;
        // TODO 根据条件判断是创建还是更新，目前是更新
        o.method = this.getMethod(context) || METHODS.METHOD_UPDATE;
        context.operations.push(o);
        return true;
    },

    getData: function(context) {
        var data = context.data;
        if(!data) {
            var content = this.getBlock('content');
            if(content) {
                data = content.getData();
            }
        }
        return data;
    },

    getMethod: Ext.emptyFn
});
