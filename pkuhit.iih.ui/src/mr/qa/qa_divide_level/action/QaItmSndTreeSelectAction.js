Ext.define('iih.mr.qa.qa_divide_level.action.QaItmSndTreeSelectAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    execute: function(context) {
    	var block = this.getBlock('left');
    	var tree = block.down('xaptree');
    	var sndCd = context.sndCd;
    	var fstCd = context.fstCd;
//    	var fstCd;
    	if(sndCd == undefined){
    	var arguments = context.event.arguments[1];
    	sndCd = "";
//    	if(arguments == undefined){
			var leaf = arguments.raw.leaf;
			if(leaf == true){
				fstCd = arguments.parentNode.raw.sndCd;
				sndCd = arguments.raw.sndCd;
				if(fstCd == undefined){//如果一级分类是叶子节点
					fstCd = sndCd;
					tree.fstNodeId = fstCd;
					tree.sndNodeId = '';
				}else{
					tree.sndNodeId = sndCd;
					tree.fstNodeId = '';
				}
			}else{
				fstCd = arguments.raw.sndCd;
				tree.fstNodeId = fstCd;
				tree.sndNodeId = '';
			}
    	}else{
    		var treeBlock = this.getBlock('left');
    		var tree = treeBlock.down('xaptree');
        	var root = tree.getRootNode().childNodes;
	        for(var i=0;i<root.length;i++){
	        	var node = root[i].childNodes;
	        	for(var j=0;j<node.length;j++){
		        	if(node[j].raw.sndCd == sndCd){
		        		tree.getSelectionModel().deselect(node[j]);
		        		tree.getSelectionModel().select(node[j]);
		        		node[j].parentNode.expand();
		        		break;
		        	}
		        }
	        }
    	}
    	var owner = this.getOwner();
    	owner.fstCd = fstCd;
    	owner.sndCd = sndCd;
        this.prepareOperations(context.operations,fstCd,sndCd);
    },
    prepareOperations: function(operations,fstCd,sndCd) {
         
         var url = this.url+'?qaItmFst='+fstCd +"&qaItmSnd="+sndCd;
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
