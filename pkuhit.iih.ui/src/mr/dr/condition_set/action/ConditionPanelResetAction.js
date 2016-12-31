Ext.define('iih.mr.dr.condition_set.action.ConditionPanelResetAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
    	this.callParent();
    	var owner = this.getOwner();
		var block = owner.getBlock('condition').getBlock('right');
		var form= block.getForm();
		form.reset();
    }
});
