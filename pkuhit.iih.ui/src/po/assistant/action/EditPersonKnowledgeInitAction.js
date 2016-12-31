Ext.define('iih.po.assistant.action.EditPersonKnowledgeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		//用于关闭画面
		var parentView = context.parentView;
		//用于区别新建、编辑
		var method = context.method;
		//储存画面间参数
		var owner = this.getOwner();   
		if(parentView!=undefined&&method!=undefined){
			var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        properties.setData({
	        	parentView:parentView,
	        	method:method
	        });
		}
        //登陆用户
        var userCode = IMER_GLOBAL.user.code;
        //初始化个人知识库类别
		this.prepareOperations(context.operations,userCode);
	},
	prepareOperations: function(operations,userCode) {
		var url = this.url+'?userId='+userCode;//查询本人创建的类别
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
    	//得到返回结果、为知识库类别下拉框填充数据
        var fragmentTplType=block.down('[name=fragmentTplTypeCd]');
        if(data){
            fragmentTplType.setData(data);
        }
    	
    	var owner=this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		var method = properties.data.method;
		//如果为编辑则查询选中数据
		if(method=='edit'){
			var chain = owner.getActionChain('prapareData');
	        if(chain) {
	            chain.execute();
	        }
		}
    } 
});