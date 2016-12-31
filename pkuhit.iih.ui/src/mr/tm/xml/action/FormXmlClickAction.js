Ext.define('iih.mr.tm.xml.action.FormXmlClickAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		console.log('----------------FormXmlClickAction-------------------');
		this.callParent();
        var operations = context.operations;      
        this.prepareOperations(operations);
    },
    prepareOperations : function(operations) {
    	var me = this;
    	var view = me.getOwner();
    	var grid = view.down('xapgrid[name=dataResourceGrid]');
    	var records = grid.getSelectionModel().getSelection();
    	var labRpPk;
    	if(records.length>0){
    		labRpPk = records[0].get('dataElementCd');
            var url = this.url + '/'+labRpPk;    
            var METHODS = this.getInvocationMethods();
            var operation = {
                url: url,
                mclass: null,
                method: METHODS.METHOD_GET,
                condition: null,
                scope: this,
                success: this.onSuccess,
                //fail: this.onFail
            };
            operations.push(operation);	
    	}else{//如果不请求后台服务,则说明没有结果集
    		var block = view.ownerCt.down('formxmldatarightblock');
    		block.setData([]);
    	}
    },
	onSuccess : function(operation) {
		//alert("success");
        var me = this;
    	var view = me.getOwner();
    	var grid = view.down('xapgrid[name=dataResourceGrid]');
    	var records = grid.getSelectionModel().getSelection();
    	var block = view.ownerCt.down('formxmldatarightblock');
    	var dataNameDis = block.down('xapdisplayfield[name=dataElementNm]');
    	var dataCodeDis = block.down('xapdisplayfield[name=dataElementCd]');
    	if(records.length>0){
    		dataCodeDis.setValue(records[0].get('dataElementCd'));
    		dataNameDis.setValue(records[0].get('dataElementNm'));
    	}
        var m = operation.result;
        //console.log(m);
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//console.log(m);				
				block.setData(m);
			}
		}else{
			block.setData([]);
		}
    }
});
