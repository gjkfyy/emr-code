Ext.define('iih.sy.userinfo.view.UserToLeadView',{
	extend : 'Xap.ej.stl.view.SearchTemplate',

	alias:'widget.usertoleadview',

	requires:[
		'iih.sy.userinfo.block.UserToLeadBlock',
		'iih.sy.userinfo.block.UserToLeadGridBlock'
	],

	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.sy.userinfo.block.UserToLeadBlock'
			},
			'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
					xtype: 'button',
					text: '检索',
					action: 'search'
				}]
			},
			'result':{
				xclass: 'iih.sy.userinfo.block.UserToLeadGridBlock'
			}
		},
		actions: {
			'init': {
				xclass: 'iih.sy.userinfo.action.UserToLeadInitAction',
				url: 'user_toLead_search',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'toLead': {
				xclass: 'iih.sy.userinfo.action.UserToLeadAction',
				url: 'user_toLead',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'search': {
				xclass: 'Xap.ej.stl.action.SimpleSearchAction',
				url: 'user_toLead_search',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'init':['init'],
			'toLead':['toLead'],
			'search':['search']
		},

		connections: {
			'result': [{
				event: 'afterrender',
				chain: 'init'
			},{
				selector:'xapbutton[method=toLead]',
				event: 'click',
				chain: 'toLead'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'search'
			}]
		}
	}
})