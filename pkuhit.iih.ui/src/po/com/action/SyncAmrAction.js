Ext.define('iih.po.com.action.SyncAmrAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        this.getBlock('portal').openMask();
        var operations = context.operations;
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        this.getBlock('portal').closeMask();
        XapMessageBox.info('数据同步完成！','',this.getBlock('portal'));
    }
});