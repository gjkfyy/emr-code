Ext.define('iih.masterdata.dataelement.dimensionvalue.action.DictDataDeletedAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
		var owner = this.getOwner();
    	var me = this;
		var block = this.getOwner().getBlock('result');
		var grid = block.down('xapgrid');
		var record = grid.getSelectionModel().getSelection();
        if(record ==undefined || Ext.isEmpty(record,false)){
			XapMessageBox.info('请选择一条记录进行操作！');
			return;
		}
		var pkDictgendata = record[0].data.dataElementValueCd;
    	var operations = context.operations;
            	if(!operations) {
            		return;
        }
		me.prepareOperations(operations,pkDictgendata);
    },
    
    prepareOperations: function(operations,pkDictgendata){
        var url = this.url;//+'/'+pkDictgendata
        var ids = [];
        ids.push(pkDictgendata);
        var data = {'ids':ids};
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_DELETE,
            condition: null,	
    		scope: this,
    		data:data,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        //刷新列表
    	var owner = this.getOwner();
    	var initChain = owner.getActionChain('init');
    	initChain.execute();
    }
});
