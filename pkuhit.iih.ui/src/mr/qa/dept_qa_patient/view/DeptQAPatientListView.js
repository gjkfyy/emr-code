Ext.define('iih.mr.qa.dept_qa_patient.view.DeptQAPatientListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.deptqapatientlistview',

	requires:[
		'Xap.ej.element.grid.Grid',
	   	'Xap.ej.element.grid.column.Date',
		'Xap.ej.element.field.ComboBox',
		'Xap.ej.element.radiogroup.RadioGroup',
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.form.Form',
		'iih.mr.qa.QaStatusGlobal',
		'iih.mr.qa.dept_qa_patient.block.DeptQAPatientListBlock',
		'iih.mr.qa.dept_qa_patient.block.DeptQAPatientListGridBlock',
		'iih.mr.qa.dept_qa_patient.action.DeptQAPatientListSearchAction',
		'iih.mr.qa.dept_qa_patient.action.DeptViewreadyAction',
		'iih.mr.qa.dept_qa_patient.action.JudgeBtnAction',
		'iih.mr.qa.terminal_qa_patient.action.TerminalBackAction',
		'iih.mr.qa.process_qa_work.action.ProcessWorkAction',
		'iih.mr.qa.terminal_qa_patient.action.TerminalFinishAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.qa.dept_qa_patient.block.DeptQAPatientListBlock',
				height:56
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
				xclass: 'iih.mr.qa.dept_qa_patient.block.DeptQAPatientListGridBlock',
				flex:1
			}
		},
		actions: {
			'init':{
				xclass:'iih.mr.qa.dept_qa_patient.action.ConditionInitAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'search': {
				xclass: 'iih.mr.qa.dept_qa_patient.action.DeptQAPatientListSearchAction',
				url:'qa/terminal/amrs',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'deptViewready': {
				xclass: 'iih.mr.qa.dept_qa_patient.action.DeptViewreadyAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			/*'judgeState': { //判断表格中按钮的状态
				xclass: 'iih.mr.qa.terminal_qa_patient.action.JudgeStateAction',
				url:'qa/judgeState/amr',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},*/
			'judgeBtn': { //判断按钮的状态
				xclass: 'iih.mr.qa.dept_qa_patient.action.JudgeBtnAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'back': {//打回
				xclass: 'iih.mr.qa.terminal_qa_patient.action.TerminalBackAction',
				url:'qa/back/amr',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'inDept': { //进入科室质控
				xclass: 'iih.mr.qa.process_qa_work.action.ProcessWorkAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'finishDept': {//完成科室质控
				xclass: 'iih.mr.qa.terminal_qa_patient.action.TerminalFinishAction',
				url:'qa/qaCompletedDept/amr',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'init':['init'],
			'search': ['search'],
			'judgeBtn':['judgeBtn'],
//			'judgeState': ['judgeState'],
			'back':['back'],
			'inDept':['inDept'],
			'finishDept':['finishDept'],
			'deptViewready':['deptViewready']
		},

		connections: {
			'condition':[{
				event: 'afterrender',
				chain: 'init'
			},{
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
			'result': [{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'deptViewready'
			},{
				selector: 'xapgrid',
				event: 'select',
				chain: 'judgeBtn'
			},{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'inDept'
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