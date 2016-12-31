Ext.define('iih.po.assistant.action.EditMrKnowledgeTypeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var owner = this.getOwner();
		var parentView = context.owner;
		if(parentView!=undefined){
			var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        properties.setData({
	        	parentView:context.owner
	        });
		}
		//登陆用户
        var userCode = IMER_GLOBAL.user.code;
        //初始化
		this.prepareOperations(context.operations,userCode);
	},
	prepareOperations: function(operations,userCode){
		var url = this.url+'?userId='+userCode;;
		var operation = {
			url: url,
			method: 'get',
			scope: this,
			success: this.onSuccess
		};
		operations.push(operation);
	},  
    onSuccess: function(operation) {
    	var data = operation.result.dataList;
    	var block = this.getOwner().getBlock('list');
    	//得到返回结果、填充数据
        block.setData(data);
    } 
});