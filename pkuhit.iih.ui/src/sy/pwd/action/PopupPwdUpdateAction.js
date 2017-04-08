Ext.define('iih.sy.pwd.action.PopupPwdUpdateAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.sy.pwd.view.PwdUpdateView'],
	
	execute: function(context){
		var owner = this.getOwner();
		var blockTitle = '密码修改';
		
		var config = {
				title:blockTitle,
	    		width: 520,
	    		height:230,
	    		contentConfig: {
	    			xtype: 'pwdupdateview'
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})