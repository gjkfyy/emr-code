Ext.define('iih.mr.qa.qa_apply.view.QaApplyInferView',{
	extend : 'Xap.ej.template.BaseTemplate',

    alias:'widget.qaapplyinferview',
	
	requires:[
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
	    'Xap.ej.element.field.RangeNumberField'
	],

	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.qa.qa_apply.block.QaApplyInferBlock',
				height:573
			}
		},
		actions: {
			'init':{
				xclass: 'iih.mr.qa.qa_apply.action.QaApplyEditInitAction',
				blocks: {
					result: 'content'
				}
			},
			'send': {
				xclass: 'iih.mr.qa.qa_apply.action.MrApplySaveAction',
				url:"mr/saveapply",
				blocks: {
					result: 'content'
				}
			},
			'cancel': {
				xclass: 'iih.mr.qa.qa_apply.action.CancelAction',
				blocks: {
					result: 'content'
				}
			}
		},

		chains: {
			'init': ['init'],
			'send': ['send'],
			'cancel': ['cancel']
		},

		connections: {
			'content': [{
				event: 'afterrender',
				chain: 'init'
			},{
				selector: 'button[method=send]',
				event: 'click',
				chain: 'send'
			},{
				selector: 'button[method=cancel]',
				event: 'click',
				chain: 'cancel'
			}]
		}
	}
})