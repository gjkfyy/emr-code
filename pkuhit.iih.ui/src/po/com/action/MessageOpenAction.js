Ext.define('iih.po.com.action.MessageOpenAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.po.com.view.MessageDetailView'],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var view = this.getOwner();
    	var config = {
    	    modal: true,           
    		width: 650,
    		height:290,
    		title :'消息详情',
    		id:'messageDetailwin',
    		contentConfig: {
    			xtype: 'messagedetailview',
    			initChain: {
    				name: 'search',
    				context: context
    			}
    		}
    	};
    	this.callParent([config]);
    	var chain = view.getActionChain('read');
        chain.execute();
    }
});
