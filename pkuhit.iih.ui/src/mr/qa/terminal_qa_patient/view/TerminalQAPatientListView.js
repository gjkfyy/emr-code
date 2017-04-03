Ext.define('iih.mr.qa.terminal_qa_patient.view.TerminalQAPatientListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.terminalqapatientlistview',

	requires:[
		'Xap.ej.element.grid.Grid',
	   	'Xap.ej.element.grid.column.Date',
		'Xap.ej.element.field.ComboBox',
		'Xap.ej.element.radiogroup.RadioGroup',
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.form.Form',
		'iih.mr.qa.QaStatusGlobal',
		'iih.mr.qa.terminal_qa_patient.block.TerminalQAPatientListBlock',
		'iih.mr.qa.terminal_qa_patient.action.TerminalViewreadyAction',
		'iih.mr.qa.terminal_qa_patient.action.TerminalQAPatientListSearchAction',
		'iih.mr.qa.terminal_qa_patient.action.JudgeBtnAction',
		'iih.mr.qa.terminal_qa_patient.action.JudgeStateAction',
		'iih.mr.qa.terminal_qa_patient.action.TerminalSignAction',
		'iih.mr.qa.terminal_qa_patient.action.TerminalBackAction',
		'iih.mr.qa.process_qa_work.action.ProcessWorkAction',
		'iih.mr.qa.terminal_qa_patient.action.TerminalFinishAction'
	],

	layout: {
        type : 'fit'
    },
	
	xapConfig: {
		blocks: {
			/*'condition':{
				xclass: 'iih.mr.qa.terminal_qa_patient.block.TerminalQAPatientListBlock'
			},
			'result':{
				xclass: 'iih.mr.qa.terminal_qa_patient.block.TerminalQAPatientListGridBlock'
			}*/
			'result': {
                xclass: 'iih.mr.qa.terminal_qa_patient.block.TerminalQAPatientListBlock',
                flex:1
            }
		},
		actions: {
			'search': {
				xclass: 'iih.mr.qa.terminal_qa_patient.action.TerminalQAPatientListSearchAction',
				url:'qa/terminal/amrs',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'terminalViewready': {
				xclass: 'iih.mr.qa.terminal_qa_patient.action.TerminalViewreadyAction',
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
			'sign': {//签收
				xclass: 'iih.mr.qa.terminal_qa_patient.action.TerminalSignAction',
				url:'qa/qaStarted/amr',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'inTerminal': {
				xclass: 'iih.mr.qa.process_qa_work.action.ProcessWorkAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'judgeBtn':{//判断签收按钮状态
				xclass: 'iih.mr.qa.terminal_qa_patient.action.JudgeBtnAction',
				blocks: {
				    result: 'result'
				}
			},
			'judgeAlreadyBtn': { //判断进入终末质控按钮的状态
				xclass: 'iih.mr.qa.terminal_qa_patient.action.JudgeAlreadyBtnAction',
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
			
			'finishTerminal': {//完成终末质控
				xclass: 'iih.mr.qa.terminal_qa_patient.action.TerminalFinishAction',
				url:'qa/qaCompleted/amr',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'search': ['search'],
			'judgeBtn': ['judgeBtn'],
			'judgeAlreadyBtn':['judgeAlreadyBtn'],
//			'judgeState': ['judgeState'],
			'sign':['sign'],
			'back':['back'],
			'inTerminal':['inTerminal'],
			'finishTerminal':['finishTerminal'],
			'terminalViewready':['terminalViewready'],
			'showDateField':['showDateField']
		},

		connections: {
			'result': [/*{
				event: 'afterrender',
				chain: 'search'
			},*/{
                selector: 'comboxgrid[method=curDeptNmWait]',
                event: 'combochange',
                chain: 'search'
			},{
                selector: 'button[action=searchWait]',
                event: 'click',
                chain: 'search'
			},{
                selector: 'comboxgrid[method=curDeptNmAlready]',
                event: 'combochange',
                chain: 'search'
			},{
                selector: 'button[action=searchAlready]',
                event: 'click',
                chain: 'search'
			},{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'terminalViewready'
			},{
				selector: 'xapgrid[name=waitSignGrid]',
				event: 'itemclick',
				chain: 'judgeBtn'
			},{
				selector: 'xapgrid[name=alreadySignGrid]',
				event: 'itemclick',
				chain: 'judgeAlreadyBtn'
			},{
				selector: 'xapgrid[name=alreadySignGrid]',
				event: 'itemdblclick',
				chain: 'inTerminal'
			},{//翻页操作
				selector: 'xapgrid',
				event: 'turnpage',
				chain: 'search'
			},{
                selector: 'xaptabpanel',
                event: 'tabchange',
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