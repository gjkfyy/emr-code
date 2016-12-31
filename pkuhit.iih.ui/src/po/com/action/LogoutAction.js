Ext.define('iih.po.com.action.LogoutAction', {
	extend: 'Xap.ej.action.LogoutAction',

	url: 'logout',

	onSuccess : function() {
		//window.location.reload(true);
	    /*IMER_GLOBAL.user.code = null;
        IMER_GLOBAL.user.name = null;
        IMER_GLOBAL.hospitalArea.code = null;
        IMER_GLOBAL.hospitalArea.name = null;
        IMER_GLOBAL.department.code = null;
        IMER_GLOBAL.department.name = null;
        IMER_GLOBAL.portal.code = null;
        IMER_GLOBAL.portal.name = null;
        IMER_GLOBAL.encounterSn = null;*/
	    var app = Ext.getCmp('commonappmain');
        var layout = app.getLayout();
        layout.setActiveItem(0);
        Ext.TaskManager.stopAll();
	}
});
