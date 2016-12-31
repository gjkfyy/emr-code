Ext.define('iih.mr.wr.mr.action.MrTypeDelAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        var record = context.mrtp;
        var operations = context.operations;
        var url = this.url + '/' + record.code;
        var operation = {
            url: url,
            mclass: null,
            method: 'DELETE',
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var view = this.getOwner();
        var chain = view.getActionChain('tree');
        chain.execute();
    }
});