Ext.define('iih.po.com.action.KnowledgeSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var view = this.getOwner();
		var bottom = view.down('knowledgesidebarview');
		var chain =  bottom.getActionChain('init');
        chain.execute({
        	
        });
	}
});
