Ext.define('Xap.ej.stl.action.ProcessTaskAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

    doExecute: function(context) {
        this.callParent();
        var data = this.getData(context);
        if(!data)
            // TODO 
            return false;
        var METHODS = this.getInvocationMethods();
        var o = {};
        o.data = data;
        o.url = this.getUrl(context);
        o.method = METHODS.METHOD_UPDATE;
        context.operations.push(o);
        return true;
    },

    getData: function(context) {
        var data = context.data;
        if(!data && context.event) {
            var event = context.event;
            // TODO 目前只考虑了Event的第二个参数
            var args = event.arguments;
            if(args.length >= 2) {
                data = args[1];
            }
        }
        if(data && (data instanceof Ext.data.Model)) {
            data = data.getData(true);
        }
        return data;        
    },

    getUrl: function(context) {
        var url = "process";
        if(context.event) {
            var event = context.event;
            var args = event.arguments;
            if(args.length >= 3) {
                task = args[2];
                var processId = task.processId;
                var taskName = task.method;
                // TODO 使用taskId
                var taskId = task.id;
                url += '/' + processId;
                url += '/task/' + taskName;
            }
        }
        return url;
    }
});