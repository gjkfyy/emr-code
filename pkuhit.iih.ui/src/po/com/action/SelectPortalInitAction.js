Ext.define('iih.po.com.action.SelectPortalInitAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
    	var view = this.getOwner();
    	var chain = view.getActionChain('searchHospitalArea');
    	chain.execute();
    }
});
