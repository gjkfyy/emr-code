Ext.define('iih.po.assistant.block.LabReportLeftListBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.grid.column.ActionColumn',
		'Xap.ej.element.grid.column.Date'
	],

	alias:'widget.labreportleftlistblock',

	layout: 'fit',
	
	border: false,

	items: [{
		title: '',
		xtype: 'xapgrid',
		name: 'labReportLeftList',
		CM_JR_Record: [
			   {header: '报告时间',xtype:'xapdatecolumn',dataIndex: 'rlsTime',field: 'textfield',type: 'string',width:120},
               {header: '报告名称',dataIndex: 'labRpNm',field: 'textfield',type: 'string',width:200},
               {header: '报告医师',dataIndex: 'execDctNm',field: 'textfield',type: 'string',width:120},
               {header: '报告状态',dataIndex: 'labRpStaNm',field: 'textfield',type: 'string',width:100},
               {header: '报告单号',dataIndex: 'labRpNo',field: 'textfield',type: 'string',width:100},
               {header: '检查时间',xtype:'xapdatecolumn',dataIndex: 'execTime',field: 'textfield',type: 'string',width:120},
               {header: '申请医师',dataIndex: 'rqsDctNm',field: 'textfield',type: 'string',width:120},
               {header: '申请时间',xtype:'xapdatecolumn',dataIndex: 'rqsTime',field: 'textfield',type: 'string',width:120},
               {header: '编号',dataIndex: 'labRpPk',field: 'textfield',type: 'string',hidden:true}
		  ]
	}],

	setData: function(data) {
		var grid = this.down('xapgrid');
		grid.setData(data);
	},
    getData: function() {
        return null;
    }
})