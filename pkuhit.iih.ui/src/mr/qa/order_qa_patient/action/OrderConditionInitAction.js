Ext.define('iih.mr.qa.order_qa_patient.action.OrderConditionInitAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var block = this.getBlock('content');
	    var curDeptNm = block.down('comboxgrid[name=curDeptNm]');
		curDeptNm.select(IMER_GLOBAL.department.code,true,true) ;
		curDeptNm.comboxHiddenValue = IMER_GLOBAL.department.code;
	}

});
