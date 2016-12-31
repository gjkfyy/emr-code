/** 
 * 缺陷一览BLOCK
 * @extends Xap.ej.block.Block
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.order_qa_work.block.QaOrderListBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.qaorderlistblock',

	layout: 'fit',
   
	items: [{
		title: '',
		xtype: 'xapgrid',
		checkboxShow : false,
		showHeaderCheckbox:true,
		sortableColumns : false,
		tbar:[{
	        xtype: 'xapcheckboxgroup',
	        margin:'5 10 0 5',
	        name:'longterm',
	        align:'left',
	        vertical: true,
	        items: [
	            { boxLabel: '长期', name: 'longterm', inputValue: 'order1' ,checked:true}
	        ]
	    },{
	        xtype: 'xapcheckboxgroup',
	        margin:'5 10 0 5',
	        name:'temporary',
	        vertical: true,
	        align:'left',
	        items: [
	            { boxLabel: '临时', name: 'temporary', inputValue: 'order2',checked:true}
	        ]
	    }],
		//simple点击行起作用，multi点击checkbox起作用
		//mode: 'SIMPLE',
		CM_JR_Record: [
			   {header: '长/临',dataIndex: 'longOrNm',field: 'textfield',type: 'string',width:60},
               {header: '组',dataIndex: 'groupFlag',field: 'textfield',type: 'string',width:30},
              /* {header: '类型',dataIndex: 'orTpNm',field: 'textfield',type: 'string',width:80},*/
               {header: '医嘱',dataIndex: 'svNm',field: 'textfield',type: 'string',width:250},
               {header: '剂量',dataIndex: 'dosage',field: 'textfield',type: 'string',width:80},
               {header: '频率',dataIndex: 'freqNm',field: 'textfield',type: 'string',width:80},
               {header: '天数',dataIndex: 'persistDays',field: 'textfield',type: 'string',width:40},
               {header: '用法',dataIndex: 'routeNm',field: 'textfield',type: 'string',width:80},
               {header: '开始时间',dataIndex: 'orStdTime',field: 'textfield',xtype:'xapdatecolumn',width:150},
               {header: '结束/执行时间',dataIndex: 'orStpTime',field: 'textfield',xtype:'xapdatecolumn',width:150},
               {header: '医嘱状态',dataIndex: 'orStaNm',field: 'textfield',type: 'string',width:80},
               {header: '嘱托',dataIndex: 'orNoteNm',field: 'textfield',type: 'string',flex:1}
               //{hidden: 'parOrPk',dataIndex: 'parOrPk',field: 'textfield',type: false,width:30}
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