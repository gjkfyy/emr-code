Ext.define('iih.sy.patient.action.PatientCreateAction', {
	extend : 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner=this.getOwner();
		var create=owner.getActionChain('create');
		create.execute();
	},
});
