Ext.define('iih.po.com.action.ReLoginAction', {
	extend: 'Xap.ej.action.LoginAction',

	url: 'xap_login',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
    	this.callParent();
    	var operations = context.operations;
    	var block = this.getBlock('content');
    	var data = block.getForm().getValues();
    	if(!Ext.isEmpty(data, false)){
    	    var username = data.username;
            var password = data.password;
            if(Ext.isEmpty(username, false)){
                XapMessageBox.warn('用户名不能为空!');
                return null;
            };
            if(Ext.isEmpty(password, false)){
                XapMessageBox.warn('密码不能为空!');
                return null;
            };
            context.data = data;
            context.data.username = data.username;
    	};
    	return true;
    },

	onLoginSuccess : function(info) {
	    var block = this.getBlock('content');
	    XapMessageBox.info('登录成功!');
	},

	onLoginFailure : function(error) {
		var block = this.getBlock('content');
		var errorText = null;
		if(error) {
			errorText = error.desc;
		}
		if(!errorText) {
			errorText = '系统故障';
		}
		XapMessageBox.warn(errorText);
	}
});
