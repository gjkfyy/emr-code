Ext.define('iih.po.assistant.view.VitalSignHelperSearchView', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
		'iih.po.assistant.block.VitalSignHelperSearchBlock',
		'iih.po.assistant.action.VitalSignSearchWindowSearchAction',
		'iih.po.assistant.action.VitalSignSearchCancelAction'
		,'iih.po.assistant.action.VitalSignSearchInitAction'
	],

	alias:'widget.VitalSignHelperSearchView',

	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.po.assistant.block.VitalSignHelperSearchBlock'
			}
        },
		actions: {
			'search': {
				xclass: 'iih.po.assistant.action.VitalSignSearchWindowSearchAction',
				url: 'acquisitionList',
				blocks: {
					result: 'content'
				}
			},
			'init': {
				xclass: 'iih.po.assistant.action.VitalSignSearchInitAction',
				blocks: {
					result: 'content'
				}
			},			
			'cancel': {
				xclass: 'iih.po.assistant.action.VitalSignSearchCancelAction',
				blocks: {
					result: 'content'
				}
			}
			
		},

		chains: {
			'search': ['search'],
			'cancel':['cancel'],
			'init':['init']
		},

		connections: {
			'content': [/*{
				event: 'afterrender',
				chain: 'init'
			},*/{
				selector: 'button[method=Search]',
                event: 'click',
				chain: 'search'
			},
			{
				selector: 'button[method=Cancel]',
                event: 'click',
				chain: 'cancel'
			}]
		}
	}
});