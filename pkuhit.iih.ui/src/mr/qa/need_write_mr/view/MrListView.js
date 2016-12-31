Ext.define('iih.mr.qa.need_write_mr.view.MrListView',{
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	    'Xap.ej.element.grid.column.CheckColumn',
	    'Xap.ej.element.grid.Grid', 
        'Xap.ej.element.field.Checkbox',
        'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.button.Button',
        'Xap.ej.element.label.Label',
        'Xap.ej.element.grid.column.CheckColumn',
        'Xap.ej.element.grid.column.ActionColumn',
	    'Xap.ej.element.grid.column.Date',
	    'Xap.ej.block.GridBlock',
	    'iih.mr.qa.need_write_mr.block.MrListBlock',
	    'iih.mr.qa.need_write_mr.action.MrListSearchAction'
	    
	],

	alias:'widget.mrlistview',
 
	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.qa.need_write_mr.block.MrListBlock'
				
			}
		},

		actions: {
			'init': {
				xclass: 'iih.mr.qa.need_write_mr.action.MrListSearchAction',
				url: 'qacustom/needSubmitMr',
				blocks: {
					content: 'content'
				}
			}
		},

		chains: {
			'init':['init']
		},

		connections: {
			'content': [{
				event: 'afterrender',
				chain: 'init'
			}
			
			]
		}
	}
})