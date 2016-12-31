Ext.define('Xap.ej.action.LocalChainExecutor', {
    extend: 'Xap.ej.action.ChainExecutor',

    requires: [
        'Xap.ej.action.ChainExecutor',
        'Xap.ej.data.DataManager'
    ],

    // @Override
    doExecute: function(flow, context) {
        // TODO command
        var operations = [];
        for(var i = 0; i < flow.length; i++) {
            var action = flow[i];
            var ctx = {
                operations: []
            };
            ctx = Ext.apply(ctx, context);
            // TODO apply
            var r = action.execute(ctx);
            // 如果是false中断执行
            if(Ext.isBoolean(r) && !r)
                break;
            Ext.Array.push(operations, ctx.operations);
        }
        this.doOperations(operations);
    },

    doOperations: function(operations) {
        for(var i = 0; i < operations.length; i++) {
            var operation = operations[i];

            // 从URL取得查找数据模型的关键信息
            var keyInfo = this.parseUrlToKeyInfo(operation.url);
            var dm = this.findDataModel(keyInfo);
            // 假设数据模型对象已经在应用初始化时被创建，因此程序中不应该出现运行时创建模型对象的代码

            // TODO如果没有找到数据模型对象，则创建一个新的
            /*
            if(!dm) {
                dm = dmgr.createDataModel({
                    key: keyInfo.baseUrl,
                    mclass: operation.mclass
                });
            }
            */

            if(!dm)
                // TODO log 没找到模型对象
                return;

            if('save' == operation.method) {
                dm.save({
                    data: operation.data
                });
            }
            else if ('get' == operation.method) {
                var r = dm.get({
                    condition: keyInfo.query
                });
                operation.result = r;
            }
            // TODO 区分成功和失败
            this.doOperationCallback(operation);
        }
    },

    parseUrlToKeyInfo: function(url) {
        var strings = url.split('?');
        var baseUrl = null;
        var query = null;
        if(strings.length >= 1) {
            baseUrl = strings[0];
        }
        if(strings.length > 1) {
            var queryString = strings[1];
            query = Ext.Object.fromQueryString(queryString);
        }
        var keyInfo = {
            baseUrl: baseUrl,
            query: query
        }
        return keyInfo;
    },

    findDataModel: function(keyInfo) {
        var dmgr = Xap.ej.data.DataManager;
        var baseUrl = keyInfo.baseUrl;
        var paths = baseUrl.split('/');
        if(paths.length > 0) {
            var i = 0;
            var path = paths[i++];
            do {
                var dm = dmgr.getDataModel(path);
                // 找到了
                if(dm) {
                    return dm;
                }
                path = path + '/' + paths[i++];
            }
            while(i <= paths.length);
        }
        return null;
    }
});