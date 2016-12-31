/** 
 * 缺陷列表block
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_search.block.NotificationDefectListBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [
   		'Xap.ej.element.grid.Grid',
		'Xap.ej.element.grid.column.Date'
   	],
   	
	alias:'widget.notificationdefectlistblock',

	layout: 'fit',

	items: [{
		xtype: 'xapgrid',
		tools:[{
            itemId: 'up',
            hidden: false,
            xtype: 'tool',
            type: 'up'
        },{
            itemId: 'down',
            hidden: true,
            xtype: 'tool',
            type: 'down'
        }
	],
		autoScroll:true,
		title:'缺陷列表',
		CM_JR_Record: [
		   {header: '状态', dataIndex: 'fltStaNm', field: 'textfield', type: 'string', width: 80},
           {header: '文书名称', dataIndex: 'mrName', alink:true,field: 'textfield', type: 'string', width: 170},
           {header: '缺陷描述', dataIndex: 'req', field: 'textfield', type: 'string',flex:1},
           {header: '扣分标准', dataIndex: 'deductDes', field: 'textfield',type: 'string', width: 80},
           {header: '缺陷次数',dataIndex: 'deductScrTimes', field: 'textfield', type: 'string' ,width: 80},
           { header: '提出日期', dataIndex: 'sbmtTime', xtype: 'xapdatecolumn',width:130},
           {header: '提出人', dataIndex: 'crtUserNm', field: 'textfield', type: 'string', width: 80},
           {header: '整改说明', dataIndex: 'rfmDes', field: 'textfield', type: 'string', flex:1},
           {header : '缺陷主键', name: 'qaFltPk', dataIndex : 'qaFltPk', hidden:true },
		   {header : '质控项', name: 'qaItmCd', dataIndex : 'qaItmCd', hidden:true },
           {header: '文书主键', dataIndex: 'mrPk', field: 'textfield', type: 'string', hidden:true },
		   {header: '缺陷状态编码', dataIndex: 'fltStaCd', field: 'textfield', type: 'string', hidden:true}
		]
	}],

	setData: function(data) {
		var grid = this.down('xapgrid');
		if(data){
			grid.setData(data);
		}else{
			grid.setData([]);
		}
	}
})