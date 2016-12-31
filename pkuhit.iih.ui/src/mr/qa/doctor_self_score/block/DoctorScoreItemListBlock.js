Ext.define('iih.mr.qa.doctor_self_score.block.DoctorScoreItemListBlock',{
	extend : 'Xap.ej.block.Block',


	alias:'widget.doctorscoreitemListblock',

	layout: 'fit',

	items: [{
		xtype: 'xapgridblock',
		title: '扣分项目',
		autoScroll:true,
		plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],
		CM_JR_Record: [
				/*	{
						header : '扣分项目表主键',
						name: 'qaDivideCd',
						dataIndex : 'qaDivideCd',
						hidden:true
					},
					{
						header : '质控项目主键',
						name: 'qaItmPk',
						dataIndex : 'qaItmPk',
						hidden:true
					},
		 */
                  /* { header: '就诊序号', dataIndex: 'enSn', hidden: true},*/
                   { header: '质控类别', dataIndex: 'itemFirstNM', width:160},
                   { header: '评分项目', dataIndex: 'req', width:400,flex:1},
                   { header: '评分标准', dataIndex: 'deductDes', width:150},
                   { header: '扣分说明', dataIndex: 'drpDes', width:360}
		]
	}],

	setData: function(data) {
		
		var grid = this.down('xapgridblock');
		if(data){
			grid.setData(data.dataList);
		}else{
			grid.setData([]);
		}
	}
})