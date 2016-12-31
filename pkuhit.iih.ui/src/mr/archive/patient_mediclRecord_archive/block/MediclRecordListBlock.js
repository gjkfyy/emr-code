Ext.define('iih.mr.archive.patient_mediclRecord_archive.block.MediclRecordListBlock', {
	extend : 'Xap.ej.block.FormBlock',

	requires : [],

	alias : 'widget.mediclrecordlistblock',

	border : 0,

	items : [ {
		// title: '患者病历查询',
		xtype : 'xapform',
		layout : {
			type : 'table',
			columns : 6,
			// width: 1024,
			tableAttrs : {
				border : 0,
				cellpadding : 0,
				cellspacing : 1,
				width : '100%',
				height : 56
			},
			tdAttrs : {
				valign : 'left'
			}
		},
		items : [ {
			xtype : 'button',
			text : '病历上传',
			name : 'uploadFileBtn',
			height : 35,
			width : 80,
			disabled:true,
			iconCls: 'icon-archive',
			margin : '10 0 10 850',
			handler: function() {
				var owner = this.up('mediclrecordview');
				var finishDeptChain = owner.getActionChain("mrconfirmArchive");
				finishDeptChain.execute();
			}	
		} ]
	} ]

});