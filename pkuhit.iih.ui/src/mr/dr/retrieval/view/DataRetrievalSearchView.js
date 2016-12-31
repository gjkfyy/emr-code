Ext.define('iih.mr.dr.retrieval.view.DataRetrievalSearchView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.dataretrievalsearchview',

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
   		'iih.mr.dr.retrieval.block.DataRetrievalSearchBlock',
   		'iih.mr.dr.retrieval.action.DataRetrievalSearchInitAction'
	],

	layout: {
        type : 'fit'
    },
	
	xapConfig: {
		blocks: {
			'content':{
				xclass: 'iih.mr.dr.retrieval.block.DataRetrievalSearchBlock'
			}
		},
		actions: {
			'init': {
				xclass: 'iih.mr.dr.retrieval.action.DataRetrievalSearchInitAction',
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