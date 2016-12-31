Ext.define('iih.mr.tm.xml.action.FormXmlDataInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: ['Xap.ej.block.Layer'],
	
	doExecute: function(context) {
        var operations = context.operations;
        var view = this.getBlock('condition').ownerCt;
        var sourceView = context.sourceView;
        var keyword = context.keyword;
        view.keyword = keyword;
        view.sourceView = sourceView;
        var viewLeft = view.down('formxmldataleftview');
        var initChain = viewLeft.getActionChain('init');
		initChain.execute({
			sourceView:sourceView
		});
    }
});
