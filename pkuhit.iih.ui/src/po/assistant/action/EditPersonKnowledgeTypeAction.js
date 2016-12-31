Ext.define('iih.po.assistant.action.EditPersonKnowledgeTypeAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.po.assistant.view.EditKnowledgeTypeView'],
	
	execute: function(context) {
		var owner = this.getOwner();
    	var config = {
    	    modal: true,           
    		width: 335,
    		height:300,
    		title :'编辑类别',
    		contentConfig: {
    			xtype: 'editknowledgetypeview',
    			initChain: {
    				name: 'init',
    				context: {
    					owner:owner
    				}
    			}
    		}
    	};
    	this.callParent([config]);
    }
});
