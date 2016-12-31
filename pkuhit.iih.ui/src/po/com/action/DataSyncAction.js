Ext.define('iih.po.com.action.DataSyncAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        this.getOwner().openMask();
        var operations = context.operations;
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess,
            failure: this.onFailure
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        this.getOwner().closeMask();
        XapMessageBox.info('数据同步完成！','',this.getOwner());
    },
    
    onFailure: function(operation) {
        this.getOwner().closeMask();
        XapMessageBox.info('数据同步失败！','',this.getOwner());
    }
});