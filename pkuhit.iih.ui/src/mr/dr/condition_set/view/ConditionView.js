Ext.define('iih.mr.dr.condition_set.view.ConditionView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.conditionview',

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
   		'iih.mr.dr.condition_set.view.ConditionPanelView',
   		'iih.mr.dr.condition_set.block.ConditionMemoBlock',
   		'iih.mr.dr.condition_set.action.ConditionInitAction',
   		'iih.mr.dr.condition_set.action.ConditionInitMemoAction',
   		'iih.mr.dr.condition_set.action.ConditionPanelResetAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.dr.condition_set.view.ConditionPanelView',
				flex:1
			},
			'result':{
				xclass: 'iih.mr.dr.condition_set.block.ConditionMemoBlock',
				height:160
			}
		},
		actions: {
			'init':{
				xclass: 'iih.mr.dr.condition_set.action.ConditionInitAction',
				url:'dr/retrievalcond/tree',
//				url:'dr/retrievalcond/list',
				blocks: {
					result: 'condition'
				}
			},'initMemo':{
				xclass:'iih.mr.dr.condition_set.action.ConditionInitMemoAction',
				url:'dr/retrievalcond/memo',
				blocks: {
					result: 'result'
				}
			},'save':{
				xclass:'iih.mr.dr.condition_set.action.ConditionPanelSaveAction',
				url:'dr/savecondition',
				blocks: {
					result: 'result'
				}
			},'reset':{
				xclass:'iih.mr.dr.condition_set.action.ConditionPanelResetAction',
				blocks: {
					result: 'condition'
				}
			}
		},

		chains: {
		'init': ['init'],
		'initMemo': ['initMemo'],
		'reset': ['reset'],
		'save': ['save']
		},

		connections: {
			'condition':[{
				event: 'afterrender',
				chain: 'init'
			}],
			'result': [{
				selector: 'button[method=save]',
				event: 'click',
				chain: 'save'
			},{
				selector: 'button[method=reset]',
				event: 'click',
				chain: 'reset'
			}]
		}
	}
})