Ext.define('iih.po.com.action.BackPortalAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
    	this.callParent();
    	var sp = this.getOwner();
    	var app = sp.ownerCt;
    	//console.log(app);
    	var layout = app.getLayout();
    	layout.setActiveItem(0);
    }
});
