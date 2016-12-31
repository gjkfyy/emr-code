Ext.define('iih.mr.dr.retrieval.action.DataRetrievalSearchInitAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var block = this.getBlock('condition');
		/*
		var view = this.getBlock('condition');
        var block = view.getBlock('content');
    	var condition = block.getData();
    	var crtTimeStart = condition.crtTimeStart;
    	var crtTimeEnd = condition.crtTimeEnd;
    	var rfmTimeStart = condition.rfmTimeStart;
    	var rfmTimeEnd = condition.rfmTimeEnd;
    	if(crtTimeEnd != ""){
    		if(crtTimeEnd < crtTimeStart){
				 XapMessageBox.info("开始日期大于结束日期，请重新选择！");
	    		return;
    		}
    	}
    	if(rfmTimeEnd != ""){
    		if(rfmTimeEnd < rfmTimeStart){
				 XapMessageBox.info("开始日期大于结束日期，请重新选择！");
	    		return;
    		}
    	}
    	*/
//	    var crtUserNm = block.down('comboxgrid[name=responsibleCd]');
//	    var curDeptNm = block.down('comboxgrid[name=deptCd]');
//		crtUserNm.select(IMER_GLOBAL.user.code,true,true) ;
//		crtUserNm.comboxHiddenValue = IMER_GLOBAL.user.code;
//		curDeptNm.select(IMER_GLOBAL.department.code,true,true) ;
//		curDeptNm.comboxHiddenValue = IMER_GLOBAL.department.code;
	}
});
