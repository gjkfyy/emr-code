Ext.define('iih.mr.wr.mr.action.OpenMrAction', {
    extend: 'Xap.ej.action.PopAction',

    
    /*
    * @Override
    */
    execute: function(context) {
        var mrSn=context.mrSn;
        if(undefined!=mrSn){
            this.openOperations(context.operations,mrSn);
        }
    },
    openOperations: function(operations, mrSn) {
        var url = this.url+'/'+mrSn;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
        var mrDocEditPage=this.getOwner();
        mrDocEditPage.medicalRecord=operation.result.data;
        plugin.OpenFromString(operation.result.data.fileData,1);
    }
});
