
/** 
 * 整改通知列表block
 * @author ：yao_lijie
 */
 
Ext.define('iih.mr.qa.process_qa_reform.block.RfmNotificationListBlock',{
	extend : 'Xap.ej.block.Block',


	alias:'widget.rfmnotificationlistblock',

	layout: 'fit',

	items: [{
		xtype: 'xapgrid',
		ifSelect : true,
        selectBy: 'revisionCd',
		tools:[
			{
				xtype: 'xapbutton',
				text: '开始整改',
				margin:'0 10 0 0',
				action: 'stertRfm'
			}
		],
		autoScroll:true,
		CM_JR_Record: [
						//为了显示top信息
						{ header: '就诊外键', dataIndex: 'enPk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
						{ header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:70 ,hidden:true},
			            { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:70,hidden:true},
						{  dataIndex: 'patientId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
						{ header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:90 ,hidden:true},
						{ header: '床位号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',flex:1,hidden:true},
						{ header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
						{ header: '入院时间', dataIndex: 'currentDeptIntoTime',field: 'textfield',type: 'string',flex:1 ,hidden:true},
				        { header: '整改通知主键', dataIndex: 'revisionCd',field: 'textfield',type: 'string',flex:1,hidden:true },
		  				{ header: '状态编码', dataIndex: 'status',field: 'textfield',type: 'string',flex:1,hidden:true },
		  				{ header: '状态', dataIndex: 'statusNM',field: 'textfield',type: 'string',flex:1},
  						{ header: '发送时间', dataIndex: 'sendTime',xtype: 'xapdatecolumn',  width: 135},
  						/*{ header: '发送时间', dataIndex: 'sendTime', width: 135,
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
		                { header: '质控医师',dataIndex: 'execDoctorNM',field: 'textfield',type: 'string', flex:1},
		                { header: '质控科室', dataIndex: 'execDeptNM',field: 'textfield',type: 'string',flex:1},
		  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',flex:1},
		  				{ header: '缺陷数', dataIndex: 'defectCount',field: 'textfield',type: 'string',flex:1},
		                { header: '整改期限', dataIndex: 'rfmDeadline',field: 'textfield',type: 'string',flex:1 },
		                { header: '截止时间', dataIndex: 'deadline',xtype: 'xapdatecolumn',  width: 135},
		                { header: '整改说明', dataIndex: 'memo',field: 'textfield',type: 'string',flex:1}
		        ]
	}],

	setData: function(data) {
		var grid = this.down('xapgrid');
		if(grid){
			if(data){
			grid.setData(data);
			}else{
				grid.setData([]);
			}
		}
	}
})