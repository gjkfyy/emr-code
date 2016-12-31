Ext.define('iih.po.com.action.SetDoctorSaveAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        this.showSubmitProgressBar();
        var operations = context.operations;
        var block = this.getBlock('content');
        var data = block.getData();
        var url = this.url;
        url+= '/' + data.pk;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:data,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var view = this.getOwner();
        var win = view.up('window');
        var parent = Ext.getCmp('patientpopview');
        var fn = function(){
            win.close();
            if(parent){
                var chain = parent.getActionChain('init');
                chain.execute();
            }
        };
        if(Ext.isObject(operation.data) && win){
            XapMessageBox.info('三级医师设置成功！',fn,win);
        }
    }
});