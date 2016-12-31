Ext.define('iih.po.com.action.SetDoctorInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var view = this.getOwner();
	    var block = view.getBlock('content');
	    block.setData(context.patient);
    }
});
