Ext.define('iih.mr.qa.process_qa_work.action.TabChangeAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
    	var owner = this.getOwner();
    	var block = this.getBlock('bottomcontent');
    	var tabpanel = block.down('xaptabpanel');
        var view = tabpanel.getActiveTab();
        if(view.xtype == 'qaworkhelperview'){
        	var helpView = view.getActiveTab();
        	if(helpView == null){
        		var helpView = view.setActiveTab(0);
        	}
        }
    }
});