Ext.define('iih.sy.params.action.ParamsSetRefreshAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override delete
	* 当删除前的列表个数大于等于待删除个数，根据列表grid.store.gridBlock.store.lastOptions 进行查询。树不做操作。
	* 当删除后个数0，按照左上角的条件进行刷新树和列表。
	*/
    doExecute: function(context) {
		this.showLoading();
		this.callParent();
		var pageNum, pageSize;
		var view =this.getOwner();	
		var grid = view.down('paramssetlistblock');
		if(context.event!= undefined){
			if (context.event.name == 'click') {
				pageNum = grid.currentPage;
				pageSize = 25;
			} else {
				pageNum = 1;
				pageSize = 25;
			}
		}else{
			pageNum = context.pageNum;
			pageSize = context.pageSize;
		}
		
		var data = {
			pageNum : pageNum,
			pageSize : pageSize
		}
		var operations = context.operations;
		this.prepareOperations(operations, data);
	},

	prepareOperations : function(operations, data) {
		var pageNum = data.pageNum;
		var pageSize = data.pageSize;
		var url = this.url;
		url += '?pageNum=' + pageNum + '&pageSize=' + pageSize;
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
