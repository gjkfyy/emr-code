Ext.define('iih.sy.patient.action.PatientCreateAction', {
	extend : 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		   IMER_GLOBAL.hospitalArea.code = context.hospitalAreaCode;
	        IMER_GLOBAL.hospitalArea.name = context.hospitalAreaName;
	        IMER_GLOBAL.department.code = context.departmentCode;
	        IMER_GLOBAL.department.name = context.departmentName;
	        IMER_GLOBAL.portal.code = context.portalCode;
	        IMER_GLOBAL.portal.name = context.portalName;
		var owner=this.getOwner();
		var create=owner.getActionChain('create');
		create.execute();
	},
});
