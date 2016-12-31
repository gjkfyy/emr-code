Ext.define('Xap.ej.action.RemoteChainExecutor2', {
    extend: 'Xap.ej.action.RemoteChainExecutor',

    requires: [
        'Xap.ej.action.ServiceInvocation',
		'Xap.ej.util.MsgUtil'
    ],

    doRemote: function(command) {
        var serviceInvocation = Xap.ej.action.ServiceInvocation;
        var self = this;
        var payload = {
            operations: []
        };
		//用于记录提示信息 add by chenyajie 2014年12月4日14:47:39
		var errorMsgs = '';
		var operLength = command.operations.length;
		var chainCallBack = self.getChain().callBack;
        for(var i = 0; i < operLength; i++) {
            var co = command.operations[i];
            co.data = co.data || {};
			var baseUrl = this.baseUrl || "";
            var url = co.url;
            if(url && url.indexOf('http://') < 0) {
                url = baseUrl + url;
            }
            var method = co.method;
            if(!method) {
                method = serviceInvocation.METHOD_GET;
            }
            // 兼容旧的方式
            else if(method == 'save') {
                method = method = serviceInvocation.METHOD_POST;
            }
            else if(method == 'get') {
                method = method = serviceInvocation.METHOD_GET;
            }

            // TODO 更合适的位置调用
            Xap.getApp().fireEvent('beforerequest');

            var headers = {};
            var sessionId = Ext.util.Cookies.get('xap-sessionId');
            if(sessionId) {
                headers['xap-sessionId'] = sessionId;
            }
            else {
                headers['xap-header'] = '1';
            }
            Ext.Ajax.request({
                url: url,
                params: co.params || {},
                jsonData: co.data || {},
                method: method,
                headers: headers,
				co: co,
				sort: i+1,
				chainCallBack: chainCallBack,
                success: function(response, opts) {
					var operation = opts.co;
					var sort = opts.sort;
                    Xap.debug('success');
                    var obj = Ext.JSON.decode(response.responseText);
                    // Xap.debug(response);
                    // TODO
                    if(obj && obj.result) {
                        operation.result = obj.result;
                    }
                    else if(obj) {
                        operation.result = obj;
                    }
					if(operation.scope){
						operation.scope.hideLoading();
						operation.scope.closeSubmitProgressBar();
					}
					self.doOperationCallback(operation);
					if(operLength==sort){
						if(opts.chainCallBack && Ext.isFunction(opts.chainCallBack)){
							opts.chainCallBack(operation.scope.getOwner());
						}
					}
                    // TODO 更合适的位置调用
                    Xap.getApp().fireEvent('afterrequest', 'success');
                },
                failure: function(response, opts) {
					var operation = opts.co;
					var sort = opts.sort;
                    Xap.debug('fail');
                    Xap.debug(response);

                    // TODO 更合适的位置调用
                    Xap.getApp().fireEvent('afterrequest', 'failure');
					
					//用于记录提示信息 add by chenyajie 2014年12月4日14:47:39
					if(404==response.status){//404
						errorMsgs += '请求的资源不存在！<br/>';
					}else if(500==response.status){//500
						var obj = Ext.decode( response.responseText ) ;
						if(obj.errorMsg){
							Ext.Array.forEach(obj.errorMsg,function(errorMsg,index,array){ 
								errorMsgs += errorMsg.msg+ '<br/>';
							});
						}else{
							errorMsgs += '请求的资源内部发生错误！<br/>';
						}
					}else if(0==response.status){
						errorMsgs += '请求被拒绝！<br/>';
					}else if(400==response.status){
						var login = Xap.create({
							xclass: 'iih.po.com.action.PopupLoginAction'
						});
						Xap.runAction(login);
					};
					//最后一次遍历时 提示出错误信息 add by chenyajie 2014年12月4日14:58:21
					if(operLength==sort){
						operation.scope.doFailureCallback();
						if(errorMsgs)
							Xap.ej.util.MsgUtil.MsgBoxInfo(errorMsgs);
					};

					if(operation.scope){
						operation.scope.hideLoading();
						operation.scope.closeSubmitProgressBar();
					}
                }
            });
        }
    }
});