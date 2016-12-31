// TODO 此类仅供测试代码用，需要一套访问存储服务的代码接口
Ext.define('Xap.ej.action.StorageServiceInvocation', {
	extend: 'Xap.ej.action.Action',

	/*
	* @Override
	*/
    execute:function(context){
        var options = context.options;
        if(!options) 
            options = {};
        if(!options.data)
            return;

        var app = Xap.getApp();
        var url = app.getBaseUrl() + this.url;
        options.url = url;
        options.headers = {'xap-header': 1};
        if(!options.scope) {
            options.success = this.onSuccess;
            options.failure = this.onFailure;
            options.scope = this;
        }
        if(!options.method) {
            return;
        }
        else if(options.method == 'GET') {
            if(!options.jsonData) {
                options.jsonData = {};
            }
            options.binary = true;
        }
        else if(options.method == 'POST') {
            // if(options.binaryData) {
            //     options.binary = true;
            // }
            // TODO find mime
            options.headers['Content-Type'] = 'image/jpeg';
            options.rawData = options.data;
        }
        Ext.Ajax.request(options);
    },

    doExecute: Ext.emptyFn,

    onSuccess: function(o) {
        console.log(o);
    },

    onFailure: function(o) {
    }
});