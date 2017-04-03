Ext.define('iih.sy.patient.action.CheckPatientChangeAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	execute : function(context) {
		var block2 = this.getBlock('left');// 当前页面patientLeftListView
		var plugin = document.getElementById('iemrEditor');
		if (plugin != undefined && plugin.valid && plugin.IsModified()) {
			Ext.Msg.alert('提示', '请保存并关闭当前书写的病历后再进行切换患者操作^_^');
			// 当前页面patientLeftListView
//			var grid = block2.down('xapgrid');
//			var curId=IMER_GLOBAL.curId;
//			alert(curId);
//			grid.getSelectionModel().select(curId);

			return false;
		} else {
//			var patientRightList = this.getOwner().getActionChain('patientRightList');
//			patientRightList.execute();
		}

	}
});
