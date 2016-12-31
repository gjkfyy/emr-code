Ext.define('iih.po.com.action.PopupLoginAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.po.com.view.PopupLoginView'],
	
	execute: function(context){
		var owner = this.getOwner();
		var blockTitle = '操作超时，请重新登录';
		
		var config = {
				title:blockTitle,
	    		width: 350,
	    		height:140,
	    		contentConfig: {
	    			xtype: 'popuploginview'
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})