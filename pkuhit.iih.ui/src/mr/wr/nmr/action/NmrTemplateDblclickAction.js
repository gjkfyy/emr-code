Ext.define('iih.mr.wr.nmr.action.NmrTemplateDblclickAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	execute: function(context) {
		var view = Ext.getCmp('createdocview');
		var chain = view.getActionChain('confim');
        if(chain) {
            chain.execute();
        }
	}     
});
