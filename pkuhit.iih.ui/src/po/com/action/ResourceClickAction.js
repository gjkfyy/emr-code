Ext.define('iih.po.com.action.ResourceClickAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var event = context.event;
        if(event) {
            var args = event.arguments;
            var data = args[1].raw;
            var owner = this.getOwner();
            var worktab = Ext.getCmp('workareapageview');
            var tabId;
            if(owner.objcd == IMER_CONSTANT.BASE_TPL)
                tabId = IMER_CONSTANT.BASE_TPL_MGR;
            else if(owner.objcd == IMER_CONSTANT.MR_TPL)
                tabId = IMER_CONSTANT.MR_TPL_MGR;
            else if(owner.objcd == IMER_CONSTANT.GROUP_ELEMENT)
                tabId = IMER_CONSTANT.GROUP_ELEMENT_MGR;
            var view = worktab.getMainPage(tabId);
            if(view){
                view.fireEvent("treeItemClick",data);
            }
        };
    }
});