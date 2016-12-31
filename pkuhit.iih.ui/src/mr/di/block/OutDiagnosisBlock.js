Ext.define('iih.mr.di.block.OutDiagnosisBlock',{
	//extend : 'Xap.ej.block.Block',
	extend : 'Xap.ej.block.FormBlock',
	
	requires:['iih.mr.di.block.DiagnosisFilterTree','iih.mr.di.model.OutDiagnosisModel'],
	border:false,
	id:'outdiagnosisblock',
	alias:'widget.outdiagnosisblock',
	items:[{
		 xtype: 'diagnosisfiltertree'
		 //title:'诊断录入',
	}]
	,setBtnCommitDisabled:function(flag) {
	    var btnCommit = this.ownerCt.down('[action=commitBtn]');
		console.log('flag');
		console.log(flag);
		btnCommit.setDisabled(flag);		
	}
});