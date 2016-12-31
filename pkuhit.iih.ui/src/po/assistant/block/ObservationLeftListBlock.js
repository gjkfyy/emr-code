Ext.define('iih.po.assistant.block.ObservationLeftListBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.grid.column.ActionColumn'
	],

	alias:'widget.observationleftlistblock',

	layout: 'fit',
	
	border: false,

	items: [{
		title: '',
		xtype: 'xapgrid',
		name: 'observationLeftList',
		CM_JR_Record: [
			   {header: '报告时间',xtype:'xapdatecolumn',dataIndex: 'rlsTime',field: 'textfield',type: 'string',width:120},
               {header: '报告名称',dataIndex: 'obRpNm',field: 'textfield',type: 'string',width:200},
               {header: '报告医师',dataIndex: 'rlsUserNm',field: 'textfield',type: 'string',width:120},
               {header: '报告状态',dataIndex: 'obRpStaNm',field: 'textfield',type: 'string',width:100},
               {header: '报告单号',dataIndex: 'obRpNo',field: 'textfield',type: 'string',width:100},
               {header: '检查时间',xtype:'xapdatecolumn',dataIndex: 'execTime',field: 'textfield',type: 'string',width:120},
               {header: '申请医师',dataIndex: 'rqsDctNm',field: 'textfield',type: 'string',width:120},
               {header: '申请时间',xtype:'xapdatecolumn',dataIndex: 'rqsTime',field: 'textfield',type: 'string',width:120},
               {header: '检查印象',dataIndex: 'obImpr',field: 'textfield',type: 'string',hidden:true},
               {header: '测量结果',dataIndex: 'obVal',field: 'textfield',type: 'string',hidden:true},
               {header: '检查所见',dataIndex: 'obFndg',field: 'textfield',type: 'string',hidden:true},
               {header: '检查诊断',dataIndex: 'obDi',field: 'textfield',type: 'string',hidden:true},
               {header: '建议',dataIndex: 'adv',field: 'textfield',type: 'string',hidden:true}
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