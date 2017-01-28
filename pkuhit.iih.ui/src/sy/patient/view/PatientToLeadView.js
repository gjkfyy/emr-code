Ext.define('iih.sy.patient.view.PatientToLeadView',{
	extend : 'Xap.ej.stl.view.SearchTemplate',

	alias:'widget.patienttoleadview',

	requires:[
		'iih.sy.patient.block.PatientToLeadBlock',
		'iih.sy.patient.block.PatientToLeadGridBlock'
	],

	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.sy.patient.block.PatientToLeadBlock'
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
				xclass: 'iih.sy.patient.block.PatientToLeadGridBlock'
			}
		},
		actions: {
			'init': {
				xclass: 'iih.sy.patient.action.PatientToLeadInitAction',
				url: 'user_toLead_search',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'toLead': {
				xclass: 'iih.sy.patient.action.PatientToLeadAction',
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