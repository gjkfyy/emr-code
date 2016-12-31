Ext.define('iih.mr.tm.xml.action.FormXmlDataeResetAction', {
	extend: 'Xap.ej.action.Action',
	requires:[],
	/*
	* @Override
	*/
	execute: function(context) {
		var operations = context.operations;
		if (!operations) {
			return;
		}
		var self=this;
		XapMessageBox.confirm2('表格已编辑，是否确认重置?', function(btn) {
			if (btn == 'yes') {
				var resetTable=self.getOwner().getActionChain("resetTable");
				resetTable.execute();
			}

		});
	}

});
