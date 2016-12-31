Ext.define('iih.mr.wr.mr.action.MrDocListGetSelectAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
		var self=this;  
		var rb = this.getBlock('result');
		var grid = rb.down('xapgrid[name=mrDocGrid]'); 
		var selected=grid.getSelectionModel().getSelection();
		if(selected.length > 0){
			XapMessageBox.confirm2('是否确定删除？', function(id){
				if(id=='yes'){
					var owner = self.getOwner();
			        var chain = owner.getActionChain('delete');
			        if(chain) {
			            chain.execute({
			            	mrPk:selected[0].data.mrPk,
			            	encounterPk:IMER_GLOBAL.encounterSn,
			            	updateCount:selected[0].raw.updateCount
			            });
			        }
				}
			});
		}else {
			XapMessageBox.info("请选择一条记录！");
		}; 
	}
});
