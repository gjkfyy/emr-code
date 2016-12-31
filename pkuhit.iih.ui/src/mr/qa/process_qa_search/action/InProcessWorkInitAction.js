Ext.define('iih.mr.qa.process_qa_search.action.InProcessWorkInitAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var block = this.getBlock('content');
		var crtTimeStart = block.down('xapdatefield[name=crtTimeStart]');
	    var crtTimeEnd = block.down('xapdatefield[name=crtTimeEnd]');
	    var crtUserNm = block.down('comboxgrid[name=crtUserNm]');
	    var curDeptNm = block.down('comboxgrid[name=curDeptNm]');
	    var curDate = new Date();
		var curDateTime = curDate.getTime();
		var preDateTime = curDateTime - 24*60*60*1000;  
		crtTimeStart.setValue(preDateTime);
		crtTimeEnd.setValue(curDateTime);
//		crtUserNm.setValue(IMER_GLOBAL.user.name);
		crtUserNm.select(IMER_GLOBAL.user.code,true,true) ;
		crtUserNm.comboxHiddenValue = IMER_GLOBAL.user.code;
		curDeptNm.select(IMER_GLOBAL.department.code,true,true) ;
		curDeptNm.comboxHiddenValue = IMER_GLOBAL.department.code;
	}

});
