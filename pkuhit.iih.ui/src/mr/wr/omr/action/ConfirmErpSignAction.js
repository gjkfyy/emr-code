Ext.define('iih.mr.wr.omr.action.ConfirmErpSignAction', {
	extend : 'iih.mr.wr.omr.action.BtnStaErpSignAction',

	/*
	 * @Override
	 */
	execute : function(context) {
		var operations = context.operations;
		if (!operations) {
			return;
		}
		var self=this;
		XapMessageBox.confirm2('签名保存后将无法对病历进行修改和再次签名，请确认是否继续保存签名？', function(
				btn) {
			if (btn == 'yes') {
				var erpSiqnSave=self.getOwner().getActionChain("erpSiqnSave");
				erpSiqnSave.execute();
			}

		});
	}

});
