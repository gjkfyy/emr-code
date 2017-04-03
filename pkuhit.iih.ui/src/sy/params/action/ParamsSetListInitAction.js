Ext.define('iih.sy.params.action.ParamsSetListInitAction', {
			extend : 'Xap.ej.action.ServiceInvocation',

	requires : ['Xap.ej.block.Layer'],

	/*
	 * @Override
	 */
	doExecute : function(context) {
		this.showLoading();
		this.callParent();
		var pageNum, pageSize;
		if(context.event!= undefined){
			if (context.event.name != 'click') {
				pageNum = context.event.arguments[0];
				pageSize = context.event.arguments[1];
			} else {
				pageNum = 1;
				pageSize = 20;
			}
		}else{
			pageNum = context.pageNum;
			pageSize = 20;
		}
		pageSize = 20;
		var block = this.getOwner().getBlock('searchCondition');;
		var condition = block.getData();
		console.info(condition);
		var data = {
			pageNum : pageNum,
			pageSize : pageSize,
			conditionNm:condition.conditionNm
		}
		if(condition.onlyFlag){
			data.code = 'SYSM01.0';
		}
		var operations = context.operations;
		this.prepareOperations(operations, data);
	},

	prepareOperations : function(operations, data) {
		var url = this.url;

		var METHODS = this.getInvocationMethods();
		var operation = {
			url : url,
			mclass : null,
			method : METHODS.METHOD_GET,
			 params: data,
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
		// alert("success");
		var gridBlock = this.getBlock('result');
		var m = operation.result;
		// TODO 数据格式就这样了？
		if (m instanceof Ext.data.Model) {
			gridBlock.setData({
						mclass : operation.mclass,
						data : m.getData(true)
					});
		} else {
			gridBlock.setGridData(m);
			gridBlock.getSelectionModel().select(0)
		}
	}
});
