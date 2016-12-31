Ext.define('iih.mr.qa.process_qa_search.view.InProcessWorkSearchView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.inprocessworksearchview',

	requires:[
		'Xap.ej.element.field.ComboBox',
   		'Xap.ej.element.field.Checkbox',
		'Xap.ej.element.radiogroup.RadioGroup',
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.form.Form',
		'Xap.ej.element.grid.Grid',
   		'Xap.ej.element.label.Label',
   		'Xap.ej.element.field.DateField', 
   		'Xap.ej.element.grid.column.Date',
   		'Xap.ej.element.grid.column.CheckColumn',
   		'iih.mr.qa.process_qa_search.view.InProcessWorkInitView',
   		'iih.mr.qa.process_qa_search.block.InProcessWorkSearchGridBlock',
   		'iih.mr.qa.process_qa_search.action.InProcessWorkSearchAction',
   		'iih.mr.qa.process_qa_search.action.JudgeBtnAction',
   		'iih.mr.qa.process_qa_search.action.ToProcessQaDefectAction',
   		'iih.mr.qa.process_qa_search.action.InProcessWorkViewreadyAction',
   		'iih.mr.qa.process_qa_work.action.QaWorkUserAcAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.qa.process_qa_search.view.InProcessWorkInitView',
				height:86
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
				xclass: 'iih.mr.qa.process_qa_search.block.InProcessWorkSearchGridBlock',
				flex:1
			}
		},
		actions: {
			'search': {
				xclass: 'iih.mr.qa.process_qa_search.action.InProcessWorkSearchAction',
				url:'qa/inprocesswork',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'judgeBtn':{
				xclass: 'iih.mr.qa.process_qa_search.action.JudgeBtnAction',
				blocks: {
				    result: 'result'
				}
			},
			'look': {
				xclass: 'iih.mr.qa.process_qa_search.action.ToProcessQaDefectAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'inProcessWorkViewready': {
				xclass: 'iih.mr.qa.process_qa_search.action.InProcessWorkViewreadyAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'qaWorkUserAcAction': {
				url:'/user/roles',
				xclass: 'iih.mr.qa.process_qa_work.action.QaWorkUserAcAction',
				blocks: {
					content:'result'
				}
			}
		},

		chains: {
			'search': ['search'],
			'judgeBtn':['judgeBtn'],
			'look':['look'],
			'inProcessWorkViewready':['inProcessWorkViewready']
		},

		connections: {
			'condition':[{
                selector: 'comboxgrid[method=curDeptNm]',
                event: 'combochange',
                chain: 'search'
			},{
                selector: 'comboxgrid[name=crtUserNm]',
                event: 'combochange',
                chain: 'search'
			},{
                selector: 'comboxgrid[name=currentManageDoctorName]',
                event: 'combochange',
                chain: 'search'
			}],
			'result': [/*{
				event: 'afterrender',
				chain: 'search'
			},*/{
				selector: 'xapgrid',
				event : 'viewready',
				chain: 'inProcessWorkViewready'
			},{
				selector: 'xapgrid',
				event : 'itemclick',
				chain: 'judgeBtn'
			},{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'look'
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