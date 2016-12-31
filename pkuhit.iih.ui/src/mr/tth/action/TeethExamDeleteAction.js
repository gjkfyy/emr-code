Ext.define('iih.mr.tth.action.TeethExamDeleteAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
    doExecute: function(context) {
    	this.callParent();
    	this.showLoading('处理中...');
    	var me = this;
    	var operations = context.operations;
        if(!operations) {
            return;
        };
    	this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        var block = this.getBlock('content');
        var pk = block.down('xaptextfield[name=teethPk]').getValue();
        var url = this.url + '/' + pk;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: 'DELETE',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.length = 0;
        operations.push(operation);
    },
    
    onSuccess: function(operation){
        if(operation.result){
            var block = this.getBlock('content');
            block.setData(operation.result);
            XapMessageBox.info('删除成功!');
        }
    },
    
    onFail: function(operation){
        this.hideLoading();
    }
});