Ext.define('iih.mr.wr.nsv.action.NurScoreDocDeleteConfirmAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
    	var self=this;
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
