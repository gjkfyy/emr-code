Ext.define('iih.po.com.action.GetCertUserAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
    requires:[],
    
    doExecute: function(context) {
    	this.callParent();
    	var uniqueId = context.uniqueId;
    	var caSubject = context.caSubject;
        var url = this.url;
        var condition = {
            'caSubject': caSubject,
            'uniqueId': uniqueId
        };
        var qs = Ext.Object.toQueryString(condition);
        url += '?' + qs;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            condition: condition,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        var operations = context.operations;
        operations.push(operation);
    },
    
    onSuccess : function(operation) {
        var data = operation.result.data;
        var view = this.getOwner();
        var block = this.getBlock('lvblock');
        var username = block.down('xaptextfield[name=username]');
        username.setValue(data.loginName);
        var password = block.down('xaptextfield[name=password]');
        password.setValue(data.password);
        var chain = view.getActionChain("login");
        chain.execute();
    },
    
    onFail: function(operation) {
        var view = this.getOwner();
        var block = this.getBlock('lvblock');
        var showInfo = block.down('xapdisplayfield');
        showInfo.setValue('<font color=red>获取用户信息失败!</font>');
    }
});
