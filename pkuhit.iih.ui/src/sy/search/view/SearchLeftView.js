Ext.define('iih.sy.search.view.SearchLeftView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.searchleftview',
	
	requires :[

	],
	xapConfig: {
		blocks: {
			'top':{
				xclass: 'iih.sy.search.block.SearchHistoryBlock',
				height:300
			}
		},
		actions: {
			'init': {
				xclass: 'iih.sy.search.action.SearchHistoryAction',
				url: 'iemrPatients',
				blocks: {
					result: 'result'
				}
			}
		},

		chains: {
			'init':['init']
		},

		connections: {
			'top'	:[{
				selector: 'xapgrid',
				event: 'itemclick',
				chain: 'init'
			}]
		}
	}
})