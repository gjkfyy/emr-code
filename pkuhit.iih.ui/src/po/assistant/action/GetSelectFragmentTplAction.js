Ext.define('iih.po.assistant.action.GetSelectFragmentTplAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
		var self=this;  
		var rb = this.getBlock('west');
		var grid = rb.down('xapgrid'); 
		var selected=grid.getSelectionModel().getSelection();
		if(selected.length > 0){
			if(selected[0].raw.crtUserId!=IMER_GLOBAL.user.code){
				XapMessageBox.info("当前用户没有权限！");
				return;
			}
			XapMessageBox.confirm2('是否确定删除？', function(id){
				if(id=='yes'){
			    	var owner = self.getOwner();
			        var chain = owner.getActionChain('delete');
			        if(chain) {
			            chain.execute({
			            	fragmentTplCd:selected[0].data.fragmentTplCd
			            });
			        }
				}
			});
		}else {
			XapMessageBox.info("请选择一条记录！");
		}; 
	}
});