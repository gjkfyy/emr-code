Ext.define('iih.mr.wr.nmr.action.NmrCloseCreateAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	/*
	* @Override
	*/
	execute: function(context) {
		var parent=this.getOwner();
		//parent.ownerCt.setWidth(200);
		//parent.ownerCt.setHeight(200)
		parent.ownerCt.close();
	}
});
