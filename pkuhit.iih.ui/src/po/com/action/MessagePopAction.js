Ext.define('iih.po.com.action.MessagePopAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.po.com.view.MessageView'],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var view = this.getOwner();
    	var config = {
    	    modal: true,           
    		width: 800,
    		height:600,
    		title :'消息列表',
    		name:'messagewin',
    		contentConfig: {
    			xtype: 'messageview',
    			initChain: {
    				name: 'search'
    			}
    		}
    	};
    	this.callParent([config]);
    }
});
