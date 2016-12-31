Ext.define('iih.po.com.action.CloseWorkPageAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.callParent();
	    var portal = this.getOwner();
	    var workArea = portal.down('xaptabpanel[id=workareapageview]');
	    var callBack = workArea.callBack;
	    var closePages = workArea.closePages;
	    if(closePages){
	        if(closePages.length > 0){
	            workArea.closeWorkPage = true;
	            workArea.remove(closePages[0]);
	            return;
	        }
	    }else{
	        var tabs = workArea.items.items;
            if(tabs.length > 0){
                workArea.closeWorkPage = true;
                workArea.remove(0);
                return;
            }
	    };
	    var callBack = workArea.callBack;
        workArea.closeWorkPage = false;
        if(callBack){
            var method = callBack.method;
            var scope = callBack.scope;
            var params = callBack.params;
            if(method && Ext.isFunction(method)){
                method.apply(scope, params);
                workArea.callBack = null;
                workArea.closePages = null;
            }
        }
	}
});