Ext.define('Xap.ej.action.LoginAction', {
	extend: 'Xap.ej.action.Action',

    requires: 'Xap.ej.util.Base64',

	/*
	* @Override
	*/
    execute:function(context){
        if(this.doExecute(context)) {
            var app = Xap.getApp();

            var url = app.getBaseUrl() + this.url;

            // 一个ajax form请求
            var requestOptions = {
                success: this.onSuccess,
                failure: this.onFailure,
                scope: this,
                url: url,
                method: 'POST'
                // params: context.data
            };

            if(this.timeout) {
                requestOptions.timeout = this.timeout * 1000;
            }
            this.basicHttpAuthorization(context.data.username, context.data.password, requestOptions);
            Ext.Ajax.request(requestOptions);
        }
    },

    doExecute: Ext.emptyFn,

    basicHttpAuthorization: function(username, password, options) {
        var token = username + ':' + password;
        var hash = Xap.ej.util.Base64.encode(token);
        if(!options.headers) {
            options.headers = {};
        }
        options.headers['Authorization'] = 'Basic ' + hash;
    },

    /* 
    * 成功的回调
    * @param data 后端服务返回的结果
    */
    // onSuccess: Ext.emptyFn,
    onSuccess: function(o) {
        Xap.debug('login request success returned');
        // TODO localstorage
        var sid = o.getResponseHeader('xap-sessionId');
        if(sid) {
            Ext.util.Cookies.set('xap-sessionId', sid);
        }

        var info = Ext.JSON.decode(o.responseText, true);
        if(info && info.userId) {
            this.onLoginSuccess(info);
        }
        else {
            this.onLoginFailure(info);
        }
    },

    // 失败的回调
    // onFailure: Ext.emptyFn
    onFailure: function(o) {
        Xap.debug('login request failed returned');
        this.onLoginFailure();
    },

    onLoginSuccess: Ext.emptyFn,

    onLoginFailure: Ext.emptyFn
});
