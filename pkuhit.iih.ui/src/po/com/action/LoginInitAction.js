Ext.define('iih.po.com.action.LoginInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    doExecute: function(context) {
        var view = this.getOwner();
        var username = view.down('textfield[name=username]');
        var password = view.down('textfield[name=password]');
        var rememberInfo = view.down('checkbox[name=rememberInfo]');
        var userId = Ext.util.Cookies.get('userId');
        if(userId){
            username.setValue(userId);
            var psw = Ext.util.Cookies.get('password');
            password.setValue(psw);
            rememberInfo.setValue(true);
        }
        password.focus(false, 100);
        
        var METHODS = this.getInvocationMethods();
        var url = this.url;
        var operation = {
            url: url,
            method: METHODS.METHOD_POST,
            scope: this,
            success: this.onSuccess,
            fail: this.onFailure
        };
        //context.operations.push(operation);
    },

    onSuccess: function(operation) {
        var info = operation.result;
        //console.log(info);
        if(info.userId) {
            var login = this.getOwner();
            var app = login.ownerCt;
            var layout = app.getLayout();
            var portal = app.down('selectportal');
            var chain = portal.getActionChain('init');
            chain.execute();
            layout.setActiveItem(1);
        }
        this.callParent();
    }
});
