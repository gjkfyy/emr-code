Ext.define('iih.mr.qa.process_qa_search.view.InProcessWorkInitView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.inprocessworkinitview',

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
   		'iih.mr.qa.process_qa_search.block.InProcessWorkSearchBlock',
   		'iih.mr.qa.process_qa_search.action.InProcessWorkInitAction'
	],

	layout: {
        type : 'fit'
    },
	
	xapConfig: {
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.process_qa_search.block.InProcessWorkSearchBlock'
			}
		},
		actions: {
			'init': {
				xclass: 'iih.mr.qa.process_qa_search.action.InProcessWorkInitAction',
				blocks: {
					content: 'content'
				}
			}
		},

		chains: {
			'init': ['init']
		},

		connections: {
			'content':[{
				event: 'afterrender',
				chain: 'init'
			}]
		}
	}
})