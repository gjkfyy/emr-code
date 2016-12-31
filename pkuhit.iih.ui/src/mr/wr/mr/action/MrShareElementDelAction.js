Ext.define('iih.mr.wr.mr.action.MrShareElementDelAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        var record = context.data;
        var operations = context.operations;
        var url = this.url + '/' + record.mrShareElementCd;
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
        var chain = view.getActionChain('search');
        chain.execute();
    }
});