Ext.define('iih.mr.wr.omr.action.OmrDoSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
		/*var owner=this.getOwner();
		var mrEditView=owner.getBlock('right');
		var doSaveChain =  mrEditView.getActionChain('doSave');
		if(doSaveChain){
			doSaveChain.execute();
		}*/
		
	    var view = this.getOwner();
        var block = view.down('outmrdoceditview');
        /*block._tabPanel = view._tabPanel;
        block._removeTab = view._removeTab;
        block._removeTab.ensureRemove = true;*/
        var chain = block.getActionChain('emrSave');
        chain.callBack = this.getOwner().getActionChain('doSave').callBack;
        chain.execute();
    }
});
