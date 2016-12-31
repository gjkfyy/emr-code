Ext.define('iih.mr.archive.patient_mediclRecord_archive.action.MrConfirmArchiveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	execute : function(context) {
		var operations = context.operations;
		if (!operations) {
			return;
		}
		var self=this;
		XapMessageBox.confirm2('归档进行中，是否确认归档?', function(
				btn) {
			if (btn == 'yes') {
				var mediclRecordarchivefile=self.getOwner().getActionChain("mediclRecordarchivefile");
				mediclRecordarchivefile.execute();
			}

		});
	}

});
