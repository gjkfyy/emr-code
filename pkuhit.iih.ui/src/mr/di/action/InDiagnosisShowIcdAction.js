Ext.define('iih.mr.di.action.InDiagnosisShowIcdAction', {
	extend: 'Xap.ej.action.Action',

	requires: [],

    execute: function(context) {
    	var record = context.record;
    	var block = this.getBlock('content');
        var diCd = record.value;
		var icdCd = block.down('xaptextfield[name=icdCd]');
		icdCd.setValue(diCd);
    }
});
