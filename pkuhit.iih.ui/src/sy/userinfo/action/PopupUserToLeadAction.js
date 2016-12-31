Ext.define('iih.sy.userinfo.action.PopupUserToLeadAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: [],
	
	/*
	* @Override
	*/
	execute: function(context) {
			console.log(this.getOwner()); //userinfomanageview
    	var config = {
    		width: 800,
    		contentConfig: {
    			xtype: 'usertoleadview',
    			initChain: {
    				name: 'init',
    				context: {
    					customerData: 'ttttt',
                        sourceView: this.getOwner()
    				}
    			}
    		}
    	};
    	this.callParent([config]);
    }
});
