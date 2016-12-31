Ext.define('iih.mr.dr.condition_set.action.ConditionPanelAddAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
    	this.callParent();
    	var owner = this.getOwner();
		var block = owner.ownerCt.getBlock('right');
		var form= block.getForm();
		form.reset();
    }
});
