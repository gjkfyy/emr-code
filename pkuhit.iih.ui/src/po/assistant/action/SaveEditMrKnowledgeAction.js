Ext.define('iih.po.assistant.action.SaveEditMrKnowledgeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
		var block = this.getOwner().getBlock('list');
        var grid=block.down('xapgrid');
	    //通过Store获取数据集方便判断
        var store = grid.getStore();
        //得到store中修改过的数据（新增、修改，此方法得不到删除过的数据）
		var datas = store.getModifiedRecords();
		//得到removed中的数据，为删除数据做准备，得到删除过的数据
		var deleted = store.removed;
    	//遍历判断被修改、和新建的记录添加到集合变量中
		var updateData= [];
    	for(var i=0;i<datas.length;i++){
    		if(datas[i].dirty){
    			var obj = new Object();
    			obj.fragmentTplTypeCd = datas[i].data.fragmentTplTypeCd;
    			obj.fragmentTplTypeNm = datas[i].data.fragmentTplTypeNm;
    			updateData.push(obj);
    		}
    	}
    	//遍历判断被删除的记录添加到集合变量中
    	var deleteData= [];
    	for(var i=0;i<deleted.length;i++){
			var obj = new Object();
			obj.fragmentTplTypeCd = deleted[i].data.fragmentTplTypeCd;
			obj.fragmentTplTypeNm = deleted[i].data.fragmentTplTypeNm;
			deleteData.push(obj);
    	}
    	//得到被修改、新建、删除的数据传入后台进行持久化操作
    	var updatas = {'updateData':updateData,'deleteData':deleteData};
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,updatas);
	},    
    prepareOperations: function(operations,updatas) {
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:updatas,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function() {
    	//保存成功，刷新
    	var owner=this.getOwner();
        var chain = owner.getActionChain('init');
        if(chain) {
            chain.execute();
        }
    }
});