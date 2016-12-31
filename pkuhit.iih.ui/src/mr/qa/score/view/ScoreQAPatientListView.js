Ext.define('iih.mr.qa.score.view.ScoreQAPatientListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.scoreqapatientlistview',

	requires:[
		'Xap.ej.element.grid.Grid',
	   	'Xap.ej.element.grid.column.Date',
		'Xap.ej.element.field.ComboBox',
		'Xap.ej.element.radiogroup.RadioGroup',
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.form.Form',
		'iih.mr.qa.QaStatusGlobal',
		'iih.mr.qa.score.block.ScoreQAPatientListBlock',
		'iih.mr.qa.score.block.ScoreQAPatientListGridBlock',
		'iih.mr.qa.score.action.ScoreQAPatientListSearchAction',
		'iih.mr.qa.score.action.ScorePatientViewreadyAction',
		'iih.mr.qa.score.action.JudgeBtnAction',
		'iih.mr.qa.score.action.TerminalScoreAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.qa.score.block.ScoreQAPatientListBlock',
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
				xclass: 'iih.mr.qa.score.block.ScoreQAPatientListGridBlock',
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
				xclass: 'iih.mr.qa.score.action.ScoreQAPatientListSearchAction',
				url:'qa/terminal/amrs',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'judgeBtn':{
				xclass: 'iih.mr.qa.score.action.JudgeBtnAction',
				blocks: {
				    result: 'result'
				}
			},
			'scoreViewready': {
				xclass: 'iih.mr.qa.score.action.ScorePatientViewreadyAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'score': {//评分
				xclass: 'iih.mr.qa.score.action.TerminalScoreAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'init':['init'],
			'search': ['search'],
			'score':['score'],
			'judgeBtn':['judgeBtn'],
			'scoreViewready':['scoreViewready']
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
			},{
                selector: 'xapradiogroup[method=ifScore]',
                event: 'change',
                chain: 'search'
			}],
			'result': [{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'scoreViewready'
			},{
				selector: 'xapgrid',
				event : 'itemclick',
				chain: 'judgeBtn'
			},{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'score'
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