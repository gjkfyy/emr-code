Ext.define('iih.sy.patient.action.OmrTemplateDblclickAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	execute: function(context) {
		var bottom = this.getOwner().ownerCt.ownerCt.ownerCt.ownerCt;
		var chain = bottom.getActionChain('confim');
        if(chain) {
            chain.execute();
        }
	}     
});
