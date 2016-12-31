/** 
 * 质控报表列表block
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.qa_reports.block.ReportsListBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [
   		'Xap.ej.element.grid.Grid',
		'Xap.ej.element.grid.column.Date'
   	],
   	
	alias:'widget.reportslistblock',

	layout: 'fit',

	items: [{
		xtype: 'xapgrid',
		tools:[{
			xtype: 'xapbutton',
			text : '查看',
			action: 'checkOut',
			disabled: true
		}
	],
		autoScroll:true,
		title:'报表一览',
		CM_JR_Record: [
		   {header : '报表主键', name: 'reportCd', dataIndex : 'reportCd', hidden:true },
		   {header : '报表URL', name: 'url', dataIndex : 'url', hidden:true },
		   {header : '报表参数', name: 'paraNm', dataIndex : 'paraNm', hidden:true },
		   {header : '报表类型', name: 'paraTp', dataIndex : 'paraTp', hidden:true },
           {header: '报表名称', dataIndex: 'reportName', field: 'textfield', type: 'string', width: 200},
           {header: '科室', dataIndex: 'deptName', field: 'textfield',type: 'string', width: 80},
           {header: '描述', dataIndex: 'reportDes', field: 'textfield', type: 'string', flex:1}
		]/*,
		gridData :[{'reportCd':'001', 'reportName':'归档病历检查报告', 'deptName':'全院', 'reportDes':'各科室的病历总数，及其甲乙丙级病历数和所占百分率。'},
		           		{'reportCd':'001', 'reportName':'缺陷率统计', 'deptName':'全院', 'reportDes':'各科室的缺陷率。'}] */
	}],
	
	setData: function(data) {
		var grid = this.down('xapgrid');
		if(grid){
			if(data){
				for(var i=0;i<data.length;i++){
					if(data[i].deptCd==''){
						data[i].deptName=' -- ';
					}
				}
				grid.setData(data);
			}else{
				grid.setData([]);
			}
		}
	}
})