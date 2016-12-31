// RemoteChainExecutor.baseUrl="http://172.18.96.159:9080"
Ext.define('Xap.ej.action.RemoteChainExecutor', {
    extend: 'Xap.ej.action.LocalChainExecutor',

    requires: [
        'Xap.ej.model.Command',
		'Xap.ej.action.RemoteProxy'
    ],

    // @Override
    doExecute: function(flow, context) {
		var self = this;
        // TODO 
        var command = {
			operations: []
		};
        // 清空所有模型数据
        // 遍历Action列表
        for(var i = 0; i < flow.length; i++) {
            var action = flow[i];
            self.preRequest(action, command, context);
        }
        // 只有operations有值，才执行远程调用
        if(command.operations && command.operations.length > 0) {
            this.doRemote(command);
        }
    },

    doRemote: function(command) {
        var self = this;
        var payload = {
            operations: []
        };
        for(var i = 0; i < command.operations.length; i++) {
            var o = command.operations[i];
            payload.operations.push({
                url: o.url
            });
        }
        // 发起请求
        var cm = Ext.create('Xap.ej.model.Command', payload);
        // TODO 不必每次都创建
        var proxy = Ext.create('Xap.ej.action.RemoteProxy', {
            // url: 'http://172.18.96.159:9080',
            url: this.baseUrl,
            model: 'Xap.ej.model.Command'
        });
        var o = Ext.create('Ext.data.Operation', {
            action: 'create',
            records: [cm]
        });
        proxy.doRequest(o, function(o) {
            var data = cm.getData();
            var operations = command.operations;
            for(var i = 0; i < operations.length; i++) {
                var operation = operations[i];
                // TODO 只取结果？
                operation.result = data.operations[i].result;
            }
            self.afterRequest(command);
        });
    },

    preRequest: function(action, command, context) {
        var ctx = {
            operations: []
        };
        ctx = Ext.apply(ctx, context);
        action.execute(ctx);
        if(action instanceof Xap.ej.action.ServiceInvocation) {
            Ext.Array.push(command.operations, ctx.operations);
        }
    },

    /*
    * @param action Action对象
    * @param data 后端返回的数据，与此Action对象对应
    */
    afterRequest: function(command) {
        var operations = command.operations;
        for(var i = 0; i < operations.length; i++) {
            var operation = operations[i];
            this.doOperationCallback(operation);
        }
    }
});