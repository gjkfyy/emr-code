Ext.define('iih.sy.params.action.ParamsSetEditInitAction', {
			extend : 'Xap.ej.action.ServiceInvocation',

	requires : ['Xap.ej.block.Layer'],

	/*
	 * @Override
	 */
	doExecute : function(context) {
		this.callParent();
		var operations = context.operations;
		var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		properties.setData({
            customerData: context.customerData,
            data:context.data,
            sourceView:context.sourceView, 
            block:context.block
        });
		if(context.customerData=='new'){
			
		}else if(context.customerData=='edit'){
			var data = context.data;
			this.prepareOperations(operations, data);
		}
	},

	prepareOperations : function(operations, data) {
		var paramCd = data.paramCd;
		var url = this.url;
		url += '/' + paramCd;
		var METHODS = this.getInvocationMethods();
		var operation = {
			url : url,
			mclass : null,
			method : METHODS.METHOD_GET,
			condition : null,
			data : null,
			scope : this,
			success : this.onSuccess,
			fail : this.onFail
		};
		operations.push(operation);
	},

	onFail : function(operation) {
		alert("查询失败");
	},
	onSuccess : function(operation) {
		var result = operation.result.data;
		console.log(result);
		var view =  this.getOwner();
		var paramCd = view.down('xaptextfield[name=paramCd]');
		var nm = view.down('xaptextfield[name=nm]');
		var codeGrid = view.down('[name=code]');
		var key = view.down('xaptextfield[name=key]');
		var value = view.down('xaptextfield[name=value]');
		var updCnt = view.down('xaptextfield[name=updCnt]');
		var memo = view.down('xaptextarea[name=memo]');
		paramCd.setValue(result.paramCd);
		nm.setValue(result.nm);
		var code = result.code;
		var codeName = result.codeName;
		codeGrid.setRecordData({code:code,codeName:codeName});
		key.setValue(result.key);
		value.setValue(result.value);
		updCnt.setValue(result.updCnt);
		memo.setValue(result.memo);
	}
});
