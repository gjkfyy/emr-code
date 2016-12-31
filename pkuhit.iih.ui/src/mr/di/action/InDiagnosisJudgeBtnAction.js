Ext.define('iih.mr.di.action.InDiagnosisJudgeBtnAction', {
	extend: 'Xap.ej.action.Action',

	requires: [],

    execute: function(context) {
    	var owner = this.getOwner();
		var block = this.getBlock('content');
		var curEnPK = block.enPk;
		var enPk = IMER_GLOBAL.encounterSn;
		var diInGrid = block.down('xapgrid');
		//子诊断按钮
		var sonDi = diInGrid.down('button[method=sonDi]');
		//编辑按钮
		var editDi = diInGrid.down('button[method=editDi]');
		//删除按钮
		var delDi = diInGrid.down('button[method=delDi]');
		var selModel = diInGrid.getSelectionModel();
		var record = selModel.getSelection()[0];
	    if(record != undefined){
	    	if(curEnPK == enPk){
	    		if(record.data.parDiSn !=''){
	    			sonDi.setDisabled(true);
	    		}else{
	    			sonDi.setDisabled(false);
	    		}
				editDi.setDisabled(false);
				delDi.setDisabled(false);
	    	}else{
	    		
				editDi.setDisabled(true);
				delDi.setDisabled(true);
	    	}
	    }
    }
});
