Ext.define('iih.po.com.action.MessageReadAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    var block = this.getBlock('content');
        var grid = block.down('xapgrid');
        var rs = grid.getSelectionModel().getSelection();
        var select = [];
        if (rs.length > 0) {
            for (i = 0; i < rs.length; i++) {
                select[i] = rs[i].data;
            }
            var data = {'ids':select};
            var operations = context.operations;
            if(!operations) {
                return;
            }
            var url = this.url;
            var operation = {
                url: url,
                method: 'put',
                data:data,
                scope: this,
                success: this.onSuccess
            };
            operations.push(operation);
        }else{
            XapMessageBox.warn('请选择消息！');
        };
    },
    
    onSuccess: function(operation) {
        var m = operation.result;
        if(m){
            var view = this.getOwner();
            var chain = view.getActionChain('search');
            chain.execute();
            
            var portal = Ext.getCmp('portalview');
            var refreshMsg = portal.getActionChain('refreshMsg');
            refreshMsg.execute();
        }
    }
});