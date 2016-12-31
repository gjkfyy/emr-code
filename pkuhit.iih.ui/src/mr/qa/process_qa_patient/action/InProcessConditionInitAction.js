Ext.define('iih.mr.qa.process_qa_patient.action.InProcessConditionInitAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var block = this.getBlock('content');
	    var curDeptNm = block.down('comboxgrid[name=curDeptNm]');
		curDeptNm.select(IMER_GLOBAL.department.code,true,true) ;
		curDeptNm.comboxHiddenValue = IMER_GLOBAL.department.code;
		var specialMr = block.down('xapcombobox[name=specialMr]');
		var checkFlag = block.down('xapcheckboxgroup[method=checkFlag]');
		if(CONFIG_PARAM.QA_SPECIAL_MR_ENABLE == true){
			specialMr.hidden = false;
			checkFlag.remove(checkFlag.items.items[0]);
			checkFlag.remove(checkFlag.items.items[0]);
//			checkFlag.items.items[0].hide(true);
		}else{
			specialMr.hidden = true;
		}
	}

});
