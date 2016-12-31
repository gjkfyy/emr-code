Ext.define('iih.mr.qa.qa_divide_level.action.QaItmFstTreeSelectAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    execute: function(context) {
    	var fstCd = context.fstCd;
    	if(fstCd == undefined){
    		if(context.event){
    			fstCd = context.event.arguments[1].raw.id;
    		};
    	}else{
    		var treeBlock = this.getBlock('left');
        	var tree = treeBlock.down('xaptree'); 
        	var node = tree.getStore().getNodeById(fstCd);
        	var index = node.data.index;
			tree.getSelectionModel().select(index,false,false);
    	}
    	var owner = this.getOwner();
    	owner.fstCd = fstCd;
        this.prepareOperations(context.operations,fstCd);
    },
    prepareOperations: function(operations,fstCd) {
         
         var url = this.url+'?qaItmFst='+fstCd;
         var operation = {
             url: url,
             method: 'get',
             scope: this,
             success: this.onSuccess
         };
         operations.length = 0;
         operations.push(operation);
     },
     onSuccess: function(operation) {
         var block = this.getBlock('right');
         // TODO 数据格式就这样了？
         if(operation.result.dataList){
     	 	 block.setData(operation.result.dataList);
         }else{
        	 block.setData(null);
         }
        /*var grid = block.down('xapgrid');
        var rs = grid.getSelectionModel().getSelection();
        //编辑按钮
		var editLevel = grid.down('button[method=editLevel]');
		//删除按钮
		var delLevel = grid.down('button[method=delLevel]');
		if(rs.length > 0){
			editLevel.setDisabled(false);
	    	delLevel.setDisabled(false);
		}else{
			editLevel.setDisabled(true);
	    	delLevel.setDisabled(true);
		}*/
     }
});
