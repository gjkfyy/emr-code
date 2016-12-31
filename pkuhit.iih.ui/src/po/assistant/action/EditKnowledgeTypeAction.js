Ext.define('iih.po.assistant.action.EditKnowledgeTypeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
    	var block = this.getOwner().getBlock('list');//EditKnowledgeTypeBlock
        var grid=block.down('xapgrid');//类别grid
        //得到选中行
        var selected=grid.getView().getSelectedNodes();
        if(selected.length > 0){//若选择行数大于0，则开启编辑功能
			var rowIndex = selected[0].rowIndex;
	        //开启可编辑功能
	        grid.getPlugin().startEdit(rowIndex,1);
		}else {
			XapMessageBox.info("请选择一条记录！");
		}; 
	}
});