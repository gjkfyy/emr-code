Ext.define('iih.mr.qa.qa_apply.action.ResetAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
    	this.callParent();
    	var owner = this.getOwner();
		var block = owner.getBlock('content');
		var form= block.getForm();
		form.reset();
    }
});
