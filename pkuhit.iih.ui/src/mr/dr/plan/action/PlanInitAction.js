Ext.define('iih.mr.dr.plan.action.PlanInitAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var block = this.owner.getBlock('content');
	    /*var crtUserNm = block.down('comboxgrid[name=responsibleCd]');
	    var curDeptNm = block.down('comboxgrid[name=deptCd]');
		crtUserNm.select(IMER_GLOBAL.user.code,true,true) ;
		crtUserNm.comboxHiddenValue = IMER_GLOBAL.user.code;
		curDeptNm.select(IMER_GLOBAL.department.code,true,true) ;
		curDeptNm.comboxHiddenValue = IMER_GLOBAL.department.code;*/
	}
});
