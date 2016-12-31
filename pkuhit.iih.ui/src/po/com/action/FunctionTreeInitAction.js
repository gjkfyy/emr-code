Ext.define('iih.po.com.action.FunctionTreeInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        this.menuCd = context.menuCd;
        var operations = context.operations;
        var block = this.getBlock('content');
        var url = this.url;
        var mclass = null;
        var condition = {
           userId: IMER_GLOBAL.user.code,
           orgCd: IMER_GLOBAL.department.code,
           portalCd: IMER_GLOBAL.portal.code
        };
        var qs = Ext.Object.toQueryString(condition);
        url += '?' + qs;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: condition,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var portal = this.getOwner();
        var block = portal.down('functionnavigationblock');
        var m = operation.result;
        if(m){
            block.setData(m.root.children,this.menuCd);
        }
    }
});