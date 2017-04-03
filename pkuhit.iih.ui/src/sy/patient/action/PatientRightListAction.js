Ext.define('iih.sy.patient.action.PatientRightListAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	doExecute : function(context) {
		var block = this.getBlock('condition');// 当前页面patientLeftListView
		var operations = context.operations;
		var block2 = this.getBlock('result');// 当前页面patientLeftListView
		var grid2 = block2.down('xapgrid');
		// 当前页面patientLeftListView
		var grid = block.down('xapgrid');
		var select = grid.getSelectionModel().getSelection();
//		alert(2222);
		console.log(select);
		var id = select[0].data.patientId;
		
//		var selections = grid.getSelectionModel().getSelections();
//
//		var store = grid.getStore();
//
//		var selectData = select[0];
//
//		var dataIndex = store.indexOf(selectData);
//		IMER_GLOBAL.curId=dataIndex;
		var data = {
			'pk' : id
		}
		var rec = data;
		var workArea = Ext.getCmp('workareapageview');
		var callBack = function(patient) {
			var canvas = Xap.getCanvas();
			canvas.fireEvent("updatePatient", {
				patient : patient
			});
		};
		workArea.callBack = {
			method : callBack,
			params : [ rec ]
		};
		var canvas = Xap.getCanvas();
		canvas.fireEvent("portalRender2");

		// 刷新右侧已写的病历
		var block = this.getBlock('result');
//		var enPk = select[0].data.inpatientNo;
//		console.log(enPk);
		/*
		 * if(IMER_GLOBAL.amrNo){ if(enPk!=IMER_GLOBAL.amrNo){ var plugin =
		 * document.getElementById('iemrEditor'); if(plugin != undefined
		 * &&plugin.valid&&plugin.IsModified()){
		 * Ext.Msg.alert('提示','当前病历修改后未保存，建议保存后再进行切换患者操作^_^');
		 * 
		 * XapMessageBox.confirm('请先保存当前修改的病历！', function(btn, text){ if (btn ==
		 * 'yes') { var saveActionChain=right.getActionChain('emrSave');
		 * saveActionChain.execute({callback:callback}); } else if (btn == 'no') {
		 * callback(); } else if (btn == 'cancel') {
		 *  } },right );
		 * 
		 * }else{
		 */
		var initChain = block.getActionChain('init');
		initChain.execute();
		/*
		 * } } }else{ var initChain = block.getActionChain('init');
		 * initChain.execute(); }
		 */
	}
});
