Ext.define('iih.mr.dr.plan.view.PlanInferView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	requires:[
	  	'Xap.ej.stl.action.SimpleSearchAction',
	  	'Xap.ej.element.grid.Grid',
	    'Xap.ej.element.form.Form',
	    'Xap.ej.element.label.Label',
	    'Xap.ej.element.field.TextField',
	    'Xap.ej.element.field.ComboBox',
	    'Xap.ej.element.field.TextArea',
	    'Xap.ej.element.toolbarbutton.ToolBarButton',
	    'Xap.ej.element.button.Button',
	    'Xap.ej.element.field.NumberField',
	    'Xap.ej.element.field.DisplayField',
	    'Xap.ej.element.field.RangeNumberField',
	    'iih.mr.dr.plan.block.PlanInferBlock',
	    'iih.mr.dr.plan.action.PlanSaveAction',
	    'iih.mr.dr.plan.action.PlanInitAction',
	    'iih.mr.dr.plan.action.CancelAction'
	],

    alias:'widget.planinferview',
	
	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.dr.plan.block.PlanInferBlock',
				height:480
			}
		},
		actions: {
			'init':{
				xclass: 'iih.mr.dr.plan.action.PlanEditInitAction',
				blocks: {
					result: 'content'
				}
			},
			'save': {
				xclass: 'iih.mr.dr.plan.action.PlanSaveAction',
				url:"dr/saveretrieval",
				blocks: {
					result: 'content'
				}
			},
			'cancel': {
				xclass: 'iih.mr.dr.plan.action.CancelAction',
				blocks: {
					result: 'content'
				}
			}
		},

		chains: {
			'init': ['init'],
			'save': ['save'],
			'cancel': ['cancel']
		},

		connections: {
			'content': [/*{
				event: 'afterrender',
				chain: 'refresh'
			},*/{
				selector: 'button[method=save]',
				event: 'click',
				chain: 'save'
			},{
				selector: 'button[method=cancel]',
				event: 'click',
				chain: 'cancel'
			}]
		}
	}
})