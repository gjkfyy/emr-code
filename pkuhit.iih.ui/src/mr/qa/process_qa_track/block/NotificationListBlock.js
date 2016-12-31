
/** 
 * 整改通知列表block
 * @author ：cheng_feng
 */
 
Ext.define('iih.mr.qa.process_qa_track.block.NotificationListBlock',{
	extend : 'Xap.ej.block.Block',


	alias:'widget.notificationlistblock',

	layout: 'fit',

	items: [{
		title: '环节整改通知',

		xtype: 'xapgrid',
		ifSelect : true,
        selectBy: 'revisionCd',
		tools:[{
				xtype: 'xapcheckbox',
				boxLabel : '已审核（7天内）',
				action: 'isVerified',
				padding:'0 870 0 0'
			},
			{
				xtype: 'xapbutton',
				text: '开始审核',
				action: 'inQaWork',
				disabled: true
			}
		],
		autoScroll:true,
		CM_JR_Record: [
				        { header: '整改通知主键', dataIndex: 'revisionCd',field: 'textfield',type: 'string',hidden:true },
				        { header: '患者编码', dataIndex: 'patientId',field: 'textfield',type: 'string',hidden:true },
				        { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',hidden:true },
				        { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',hidden:true },
				        { header: '病案号', dataIndex: 'amrNo',field: 'textfield',type: 'string',hidden:true },
				        { header: '就诊号', dataIndex: 'encounterNo',field: 'textfield',type: 'string',hidden:true },
				        { header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',hidden:true },
				        /*{ header: '入院时间', dataIndex: 'currentDeptIntoTime',
					        field: {
								xtype: 'datetimefield'
							},
							renderer: function(v){
								if(v){
									v = new Date(v);
									return Ext.util.Format.date(v, 'Y-m-d H:i');
								}
								return v;
							},hidden:true },*/
           				/*{ header: '入院时间', dataIndex: 'currentDeptIntoTime', xtype: 'xapdatecolumn',  width: 120},*/
				        { header: '床位号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',hidden:true },
				        { header: '质控类型', dataIndex: 'qaTyCd',field: 'textfield',type: 'string',hidden:true },
		  				{ header: '状态编码', dataIndex: 'status',field: 'textfield',type: 'string',hidden:true },
		  				{ header: '状态', dataIndex: 'statusNM',field: 'textfield',type: 'string' },
		  				/*{ header: '发送时间', dataIndex: 'sendTime', 
							field: {
								xtype: 'datetimefield'
							},
							renderer: function(v){
								if(v){
									v = new Date(v);
									return Ext.util.Format.date(v, 'Y-m-d H:i');
								}
								return v;
							}
						 },*/
           				{header: '发送时间', dataIndex: 'sendTime', xtype: 'xapdatecolumn',  width: 120},
			            { header: '整改医师编码',dataIndex: 'rfmDoctorCd',field: 'textfield',type: 'string',hidden:true},
		                { header: '整改医师',dataIndex: 'rfmDoctorNM',field: 'textfield',type: 'string'},
		                { header: '整改科室编码', dataIndex: 'rfmDeptCd',field: 'textfield',type: 'string',hidden:true},
		                { header: '整改科室', dataIndex: 'rfmDeptNM',field: 'textfield',type: 'string'},
		  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string'},
		  				{ header: '缺陷数', dataIndex: 'defectCount',field: 'textfield',type: 'string'},
		                { header: '整改期限', dataIndex: 'rfmDeadline',field: 'textfield',type: 'string' },
		                /*{ header: '截止时间', dataIndex: 'deadline', 
							field: {
								xtype: 'datetimefield'
							},
							renderer: function(v){
								if(v){
									v = new Date(v);
									return Ext.util.Format.date(v, 'Y-m-d H:i');
								}
								return v;
							}
						},*/
           				{header: '截止时间', dataIndex: 'deadline', xtype: 'xapdatecolumn',  width: 120},
		                { header: '整改说明', dataIndex: 'memo',field: 'textfield',type: 'string',flex:1 },
           				{ header: '整改时间', dataIndex: 'rfmTime', xtype: 'xapdatecolumn',  width: 120}
		        ]
	}],

	setData: function(data) {
		if(data){
			var grid = this.down('xapgrid');
			/*var resultList = [];
			for(var i in data){
				var cusAmr = data[i].cusAmr;
	        	var encounterModel = data[i].encounterModel;
	        	var rs = Ext.Object.merge(cusAmr,encounterModel);//不严谨
				var patientEncounterModel = Ext.create('iih.mr.model.QAPatientEncounterModel',cusAmr);
				resultList.push(patientEncounterModel);
			}
			grid.setData(resultList);*/
			if(grid){
				if(data){
					grid.setData(data);
				}else{
					grid.setData([]);
				}
			}
		}
	}
})