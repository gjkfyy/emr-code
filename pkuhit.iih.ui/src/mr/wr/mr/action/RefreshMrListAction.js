Ext.define('iih.mr.wr.mr.action.RefreshMrListAction', {
	extend : 'Xap.ej.action.ServiceInvocation',
	doExecute : function(context) {
			IMER_GLOBAL.editing = 0;
			var patientrightview = Ext.getCmp('patientrightview');// .getOwner().ownerCt;
			var init = patientrightview.getActionChain('init');
			init.execute();
	}
});
