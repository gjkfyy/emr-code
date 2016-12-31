Ext.define('iih.po.com.action.LoginResetAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
        var loginview = this.getBlock('lvblock');
        if(loginview) {
        	loginview.getForm().reset();
        }
    	/*var login = this.getOwner();
    	var app = login.ownerCt;
    	app.close();*/
    }
});
