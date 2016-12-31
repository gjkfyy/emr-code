Ext.define('iih.po.com.action.SelectPortalAction', {
    extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var block = this.getBlock('selectportals');
	    var hospitalArea = block.down('xapcombobox[name=hosArea]');
	    var department = block.down('xapcombobox[name=dept]');
	    var messageInfo = block.down('xapdisplayfield');
	    if(Ext.isEmpty(hospitalArea.getValue(), false)){
	        messageInfo.setValue('<font color=red>请选择院区!</font>');
            return null;
	    };
	    if(Ext.isEmpty(department.getValue(), false)){
	        messageInfo.setValue('<font color=red>请选择科室!</font>');
            return null;
        };
        IMER_GLOBAL.hospitalArea.code = hospitalArea.getValue();
        IMER_GLOBAL.hospitalArea.name = hospitalArea.rawValue;
        IMER_GLOBAL.department.code = department.getValue();
        IMER_GLOBAL.department.name = department.rawValue;
        IMER_GLOBAL.portal.code = context.action;
        IMER_GLOBAL.portal.name = context.tooltip;
        
        var app = block.up('app');
        var portal = app.down('portalview');
        var chain = portal.getActionChain('init');
        chain.execute({
            hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
            hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
            departmentCode:IMER_GLOBAL.department.code,
            departmentName:IMER_GLOBAL.department.name,
            portalCode:IMER_GLOBAL.portal.code,
            portalName:IMER_GLOBAL.portal.name
        });
    	this.callParent();
    }
});
