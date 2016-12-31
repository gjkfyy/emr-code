Ext.define('iih.mr.qa.process_qa_patient.view.InProcessQAPatientListView',{
	extend : 'Xap.ej.template.BaseTemplate',
//	extend : 'Xap.ej.stl.view.SearchTemplate',

	alias:'widget.inprocessqapatientlistview',

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
		'iih.mr.qa.process_qa_patient.view.InProcessQAPatientConditionView',
		'iih.mr.qa.process_qa_patient.block.InProcessQAPatientListGridBlock',
   		'iih.mr.qa.process_qa_patient.action.InProcessQAPatientListSearchAction',
   		'iih.mr.qa.process_qa_patient.action.InProcessViewreadyAction',
   		'iih.mr.qa.process_qa_work.action.ProcessWorkAction',
   		'iih.mr.qa.process_qa_patient.action.JudgeBtnAction',
   		'iih.mr.qa.process_qa_patient.action.ToProcessQaDefectAction',
   		'iih.mr.qa.process_qa_work.action.QaWorkUserAcAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.qa.process_qa_patient.view.InProcessQAPatientConditionView',
				height:115
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
				xclass: 'iih.mr.qa.process_qa_patient.block.InProcessQAPatientListGridBlock',
				flex:1
			}
		},
		actions: {
			'search': {
				xclass: 'iih.mr.qa.process_qa_patient.action.InProcessQAPatientListSearchAction',
				url:'inprocess/amrs',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'judgeBtn':{
				xclass: 'iih.mr.qa.process_qa_patient.action.JudgeBtnAction',
				blocks: {
				    result: 'result'
				}
			},
			'confirmOpen': {
				xclass: 'iih.mr.qa.process_qa_patient.action.ConfirmOpenAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'inProcess': {
				xclass: 'iih.mr.qa.process_qa_work.action.ProcessWorkAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'defects':{
				xclass: 'iih.mr.qa.process_qa_patient.action.ToProcessQaDefectAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'inProcessViewready': {
				xclass: 'iih.mr.qa.process_qa_patient.action.InProcessViewreadyAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			/*'qaWorkUserAcAction': {
				url:'/user/roles',
				xclass: 'iih.mr.qa.process_qa_work.action.QaWorkUserAcAction',
				blocks: {
					content:'result'
				}
			},*/
			'showDateField': {//完成终末质控
				xclass: 'iih.mr.qa.process_qa_patient.action.ShowDateFieldAction',
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
			'inProcess':['inProcess'],
			'defects':['defects'],
			'inProcessViewready':['inProcessViewready'],
			//'qaWorkUserAcAction':['qaWorkUserAcAction'],
			'showDateField':['showDateField']
		},

		connections: {
			'condition':[{
                selector: 'comboxgrid[method=curDeptNm]',
                event: 'combochange',
                chain: 'search'
			},{
                selector: 'xapcheckboxgroup[method=checkFlag]',
                event: 'change',
                chain: 'search'
			},{
                selector: 'xapradiogroup[method=changeTime]',
                event: 'change',
                chain: 'search'
			},{
                selector: 'xapradiogroup[method=inOrOut]',
                event: 'change',
                chain: 'search'
			},{
                selector: 'xapdatefield[name=beginTime]',
                event: 'change',
                chain: 'showDateField'
            },{
                selector: 'xapdatefield[name=endTime]',
                event: 'change',
                chain: 'showDateField'
            },{
                selector: 'xapcombobox[name=specialMr]',
                event: 'change',
                chain: 'search'
            }],
			'result': [/*{
				event: 'afterrender',
				chain: 'search'
			},*/{
				selector: 'xapgrid',
				event : 'viewready',
				chain: 'inProcessViewready'
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