Ext.define('iih.mr.qa.order_qa_patient.view.OrderQAPatientListView',{
	extend : 'Xap.ej.template.BaseTemplate',
//	extend : 'Xap.ej.stl.view.SearchTemplate',

	alias:'widget.orderqapatientlistview',

	requires:[
		'Xap.ej.element.field.ComboBox',
   		'Xap.ej.element.field.Checkbox',
		'Xap.ej.element.radiogroup.RadioGroup',
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.form.Form',
		'Xap.ej.element.grid.Grid',
   		'Xap.ej.element.label.Label',
   		'Xap.ej.element.grid.column.Date',
   		'Xap.ej.element.grid.column.CheckColumn',
		'iih.mr.qa.order_qa_patient.view.OrderQAPatientConditionView',
		'iih.mr.qa.order_qa_patient.block.OrderQAPatientListGridBlock',
   		'iih.mr.qa.order_qa_patient.action.OrderQAPatientListSearchAction',
   		'iih.mr.qa.order_qa_patient.action.OrderViewreadyAction',
   		'iih.mr.qa.process_qa_work.action.ProcessWorkAction',
   		'iih.mr.qa.order_qa_patient.action.JudgeBtnAction',
   		'iih.mr.qa.order_qa_patient.action.ToProcessQaDefectAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.qa.order_qa_patient.view.OrderQAPatientConditionView',
				height:76
			},
			'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
					xtype: 'button',
					iconCls: 'icon-Search',
					text: '查询',
					action: 'search'
				}]
			},
			'result':{
				xclass: 'iih.mr.qa.order_qa_patient.block.OrderQAPatientListGridBlock',
				flex:1
			}
		},
		actions: {
			'search': {
				xclass: 'iih.mr.qa.order_qa_patient.action.OrderQAPatientListSearchAction',
				url:'qa/terminal/amrs',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'judgeBtn':{
				xclass: 'iih.mr.qa.order_qa_patient.action.JudgeBtnAction',
				blocks: {
				    result: 'result'
				}
			},
			'confirmOpen': {
				xclass: 'iih.mr.qa.order_qa_patient.action.ConfirmOpenAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'inOrder': {
				xclass: 'iih.mr.qa.process_qa_work.action.ProcessWorkAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'inOrderViewready': {
				xclass: 'iih.mr.qa.order_qa_patient.action.OrderViewreadyAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'search': ['search'],
			'judgeBtn':['judgeBtn'],
			'confirmOpen':['confirmOpen'],
			'inOrder':['inOrder'],
			'inOrderViewready':['inOrderViewready']
		},

		connections: {
			'condition':[{
                selector: 'comboxgrid[method=curDeptNm]',
                event: 'combochange',
                chain: 'search'
			},{
                selector: 'xaptextfield[name=amrNo]',
                event: 'blur',
                chain: 'search'
			},{
                selector: 'xaptextfield[name=patientName]',
                event: 'blur',
                chain: 'search'
			}],
			'result': [/*{
				event: 'afterrender',
				chain: 'search'
			},*/{
				selector: 'xapgrid',
				event : 'viewready',
				chain: 'inOrderViewready'
			},{
				selector: 'xapgrid',
				event : 'itemclick',
				chain: 'judgeBtn'
			},{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'confirmOpen'
			},{
				selector: 'xapgrid',
				event:'linkClick',
				chain: 'confirmOpen'
			},{//翻页操作
				selector: 'xapgrid',
				event: 'turnpage',
				chain: 'search'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'search'
			}]
		}
	},
		
	initComponent : function() {
			this.callParent();
			this.addEvents("pageRefresh");//为视图添加刷新事件
			this.addListener('pageRefresh', function(){//添加监听事件
				 var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
		        var chain = this.getActionChain('search');
		        var block = this.getBlock('result');
//		        var pageSize = block.pageSize;
		        if(properties.data == undefined){
		        	 if(chain) {
		            chain.execute({});
		        	}
		        }else{
		        	var pageSize = properties.data.pageSize;
			        var pageNum = properties.data.pageNum;
			        if(chain) {
			            chain.execute({
			            	pageSize:pageSize,
			            	pageNum:pageNum
			            });
			        }
		        }
			});
		}
})