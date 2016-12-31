Ext.define('iih.mr.qa.dept_qa_patient.action.ConditionInitAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var block = this.getBlock('condition');
	    var curDeptNm = block.down('comboxgrid[name=curDeptNm]');
//		crtUserNm.setValue(IMER_GLOBAL.user.name);
	    if(this.getOwner().typeFlag&&this.getOwner().typeFlag!='1'){//排除终末评分
	    	curDeptNm.select(IMER_GLOBAL.department.code,true,true) ;
			curDeptNm.comboxHiddenValue = IMER_GLOBAL.department.code;
			curDeptNm.hide();
	    }else{
	    	curDeptNm.show();
	    }
		
	}

});
