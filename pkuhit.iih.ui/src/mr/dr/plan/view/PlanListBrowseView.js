Ext.define('iih.mr.dr.plan.view.PlanListBrowseView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.planlistbrowseview',

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
   		'iih.mr.dr.plan.view.PlanSearchView',
   		'iih.mr.dr.plan.block.PlanGridBrowseBlock',
   		'iih.mr.dr.plan.action.PlanSearchAction',
   		'iih.mr.dr.plan.action.PlanExecSearchAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.dr.plan.view.PlanSearchView',
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
				xclass: 'iih.mr.dr.plan.block.PlanGridBrowseBlock',
				flex:1
			}
		},
		actions: {
			'search':{
				xclass: 'iih.mr.dr.plan.action.PlanSearchAction',
				url:'dr/retrieval/list',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},'execResult':{
				xclass: 'iih.mr.dr.plan.action.PlanExecSearchAction',
				url:'dr/retrievalpa/list',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'search': ['search'],
			'execResult': ['execResult']
		},

		connections: {
			'result': [{
				event: 'afterrender',
				chain: 'search'
			},{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'execResult'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'search'
			}]
		}
			
	}
})