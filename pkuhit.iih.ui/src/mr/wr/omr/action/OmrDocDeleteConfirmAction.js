Ext.define('iih.mr.wr.omr.action.OmrDocDeleteConfirmAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
    	var self=this;
    	var owner = self.getOwner();
		var left=owner.getBlock('left');
		var mrTree=left.down("xaptree");
		var treeNode = mrTree.getSelectionModel().getSelection();
		if(treeNode&&treeNode.length>0){
			var mr=treeNode[0].raw;
	        if(IMER_GLOBAL.encounterSn!=mr.encounterPk){
	        	XapMessageBox.info('非本次就诊的病历不可删除!');
	        	return;
	        }
		}
		
		XapMessageBox.confirm2('是否确定删除？', function(id){
			if(id=='yes'){
				var owner = self.getOwner();
		        var chain = owner.getActionChain('delete');
		        if(chain){
		        	chain.execute(context);
		        }
			}
		});
	}
});
