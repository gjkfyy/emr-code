Ext.define('iih.mr.qa.qa_divide_level.action.JudgeDocOpTypeAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
		var block = this.getBlock('content');
		var integrityAuto = block.down('xapform[name=integrityAuto]');
		var jobTitleCd = integrityAuto.down('xapcombobox[name=jobTitleCd]').getValue();
		var dctOpTpCd = integrityAuto.down('xapcombobox[name=dctOpTpCd]');
		if(jobTitleCd == ''){
			dctOpTpCd.setDisabled(true);
			dctOpTpCd.select('');
		}else{
			dctOpTpCd.setDisabled(false);
		}
	}
});
