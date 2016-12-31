Ext.define('iih.masterdata.dataelement.dimensioncode.action.DictDeletedAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
		var owner = this.getOwner();
    	var me = this;
		var block = this.getBlock('result');
		var grid = block.down('xapgrid');
		var record = grid.getSelectionModel().getSelection();  //context.record;
        if(record ==undefined || Ext.isEmpty(record,false)){
			XapMessageBox.info('请选择一条记录进行操作！');
			return;
		}
		var pkDictgeneral = record[0].data.dataElementCd;
    	var operations = context.operations;
            	if(!operations) {
            		return;
        }
		me.prepareOperations(operations,pkDictgeneral);
    },
    
    prepareOperations: function(operations,pkDictgeneral){
        var ids = [];
        ids.push(pkDictgeneral);
        var data = {'ids':ids};
        var url = this.url;
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
