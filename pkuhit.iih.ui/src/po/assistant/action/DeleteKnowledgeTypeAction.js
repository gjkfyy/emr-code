Ext.define('iih.po.assistant.action.DeleteKnowledgeTypeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
    	var self=this;
		var block = this.getOwner().getBlock('list');//EditKnowledgeTypeBlock
        var grid=block.down('xapgrid');
        
		var selected=grid.getSelectionModel().getSelection();
		if(selected.length > 0){
			var useCount = selected[0].raw.useCount;//加载列表时从后台查出该类别当前使用次数
			if(useCount>0){//大于0时不可删除
				XapMessageBox.info("该类别已被使用，现不能删除！");
				return;
			}
			var selected=grid.getView().getSelectedNodes();
    		var rowIndex = selected[0].rowIndex;//选中数据的行号
    		var store = grid.getStore();//store
    		record = store.getAt(rowIndex);
    		//将删除的数据放入removed中，用于保存时使用
    		store.removed.push(record);
    		//删除数据
    		store.remove(record);//只删除store中的数据
    		//刷新视图，重新排序
    		grid.getView().refresh();
		}else {
			XapMessageBox.info("请选择一条记录！");
		}; 
	}
});