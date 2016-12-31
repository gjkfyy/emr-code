Ext.define('iih.mr.qa.need_write_mr.block.MrListBlock',{
	extend : 'Xap.ej.block.Block',


	alias:'widget.mrlistblock',

	layout: 'fit',

	modCount: 0,//gird修改次数
	
	canSave: false,
	items: [{
		xtype: 'xapgridblock',
		title: '',
		autoScroll:true,
		plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],
		CM_JR_Record: [
					
		 
                  // { header: '就诊序号', dataIndex: 'enSn', hidden: true},
                   { header: '文书类型', dataIndex: 'mrType', width:160},
                   { header: '质控项目', dataIndex: 'qaItem', width:400,flex:1},
                   { header: '截止时间', dataIndex: 'deadDate', xtype: 'xapdatecolumn', width:150},
                   { header: '剩余时间', dataIndex: 'surplusTime', width:150}
		]
	}],

	setData: function(data) {
		
		var grid = this.down('xapgridblock');
		if(data.dataList){
			grid.setData(data.dataList);
		}else{
			grid.setData([]);
		}
	}
})