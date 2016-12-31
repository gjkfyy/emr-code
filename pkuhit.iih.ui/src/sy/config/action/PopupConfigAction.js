Ext.define('iih.sy.config.action.PopupConfigAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.sy.config.view.ConfigView'],
	
	execute: function(context){
		var owner = this.getOwner();
		var blockTitle = '设置';
		
		var config = {
				title:blockTitle,
	    		width: 460,
	    		height:250,
	    		contentConfig: {
	    			xtype: 'configview'
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})