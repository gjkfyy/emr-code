Ext.define('iih.po.assistant.action.CancelEditMrKnowledgeTypeAction', {
    extend: 'Xap.ej.action.Action',
    
    execute: function(context) {
    	var me = this;
        //关闭窗口
    	var owner = this.getOwner()
    	//得到grid，判断是否有未保存的修改。若存在提示保存。
    	var block = owner.getBlock('list');
        var grid=block.down('xapgrid');
	    //通过Store获取数据集方便判断
        var store = grid.getStore();
		var datas = store.getModifiedRecords();
		var deleted = store.removed;
    	//遍历判断被修改、和新建的记录添加到集合变量中
		var updateData=0;
    	for(var i=0;i<datas.length;i++){
    		if(datas[i].dirty){
    			updateData++;
    		}
    	}
    	for(var i=0;i<deleted.length;i++){
			updateData++;
    	}
    	if(updateData>0){
    		Ext.Msg.confirm("提示","还有未保存的数据,是否确认退出？",function(id){
    			if(id=='no'){
    				return;
    			}
    			if(id=='yes'){
    				me.freshType();//关闭画面，刷新类别
    			}
    		});
    	}else{
    		me.freshType();
    	}
	} ,
	//关闭画面，刷新类别
	freshType:function(){
		//关闭类别编辑画面
		var owner = this.getOwner();
		var ownerCt = owner.ownerCt;
        ownerCt.close();
        //初始化类别下拉列表
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		var parentView = properties.data.parentView;
		var chain = parentView.getActionChain('init');
        if(chain) {
            chain.execute();
        }
	}
});
