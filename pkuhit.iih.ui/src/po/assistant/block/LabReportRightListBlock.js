Ext.define('iih.po.assistant.block.LabReportRightListBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.grid.column.ActionColumn'
	],

	alias:'widget.labreportrightlistblock',

	layout: 'fit',
	
	border: false,

	items: [{
		title: '',
		xtype: 'xapgrid',
		checkboxShow:true,
		showHeaderCheckbox:true,
        autoScroll:true,
        mode: "SIMPLE",
		CM_JR_Record: [
               {header: '项目名称',dataIndex: 'labItmNm',field: 'textfield',type: 'string',width:200},
               {header: '标识',dataIndex: 'labItmCompare',field: 'textfield',type: 'string',width:30},
               {header: '结果值',dataIndex: 'labItmVal',field: 'textfield',type: 'string',width:150},
               {header: '单位',dataIndex: 'labItmUnitNm',field: 'textfield',type: 'string',width:50},
               {header: '参考范围',dataIndex: 'referRange',field: 'textfield',type: 'string',width:150},
               {header: '备注',dataIndex: 'memo',field: 'textfield',type: 'string',flex:1},
               {header: 'Id',dataIndex: 'mrLabRpItmPk',hidden:true},
               {header: 'maxNrmlVal',dataIndex: 'maxNrmlVal',hidden:true},
               {header: 'minNrmlVal',dataIndex: 'minNrmlVal',hidden:true}
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