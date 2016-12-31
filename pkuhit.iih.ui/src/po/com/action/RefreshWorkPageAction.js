Ext.define('iih.po.com.action.RefreshWorkPageAction', {
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
	    var openPages = workArea.openPages;
	    var openPageCount = workArea.openPageCount;
	    if(openPages && openPages.length > 0){
	        if(openPageCount && openPageCount > 0){
	            var tab = openPages[openPageCount-1];
	            var page = workArea.getMainPage(tab.tabId);
	            workArea.openPageCount = workArea.openPageCount -1;
	            page.fireEvent("contentRefresh");
	            return;
	        }
	    };
	    var callBack = workArea.callBack;
        if(callBack){
            var method = callBack.method;
            var scope = callBack.scope;
            var params = callBack.params;
            if(method && Ext.isFunction(method)){
                method.apply(scope, params);
                workArea.callBack = null;
                workArea.openPages = null;
                workArea.openPageCount = 0;
            }
        }
	}
});