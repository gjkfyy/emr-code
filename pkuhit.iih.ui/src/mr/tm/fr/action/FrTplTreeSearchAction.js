Ext.define('iih.mr.tm.fr.action.FrTplTreeSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var view = this.getOwner();
		var bottom = view.down('frtplsidebarview');
		var chain =  bottom.getActionChain('init');
        chain.execute({
        });
	}
});
