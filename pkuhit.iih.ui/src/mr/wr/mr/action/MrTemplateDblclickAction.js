Ext.define('iih.mr.wr.mr.action.MrTemplateDblclickAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	execute: function(context) {
		var bottom = this.getOwner().ownerCt.getBlock('bottom');
		var chain = bottom.getActionChain('confim');
        if(chain) {
            chain.execute();
        }
	}     
});
