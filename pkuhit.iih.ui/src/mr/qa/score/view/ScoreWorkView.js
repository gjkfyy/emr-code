Ext.define('iih.mr.qa.score.view.ScoreWorkView',{
	extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',

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
	    'iih.mr.qa.score.block.ScoreFormBlock',
	    'iih.mr.qa.score.block.ScoreItemListBlock',
	    'iih.mr.qa.score.action.ScoreViewreadyAction',
	    'iih.mr.qa.score.action.ScoreItemListSearchAction',
	    'iih.mr.qa.score.action.QaScoreDeleteAction',
	    'iih.mr.qa.score.action.QaScoreCompleteAction',
	    'iih.mr.qa.score.action.PopupScoreItemViewAction',
	    'iih.mr.qa.score.action.ScoreItemClickAction'
	    
	],

	alias:'widget.scoreworkview',
	
	ownerProperty:{completed:false},
 
	xapConfig: {
		blocks: {
		    'top': {
                xclass: 'iih.mr.qa.score.block.ScoreFormBlock',
                height: 60
            },
			'bottom': {
				xclass: 'iih.mr.qa.score.block.ScoreItemListBlock'
				
			}
		},

		actions: {
			'init': {
				xclass: 'iih.mr.qa.score.action.ScoreItemListSearchAction',
				url: 'qacustom/dropScoreItems',
				blocks: {
					top: 'top',
					bottom: 'bottom'
				}
			},
			'scoreViewready': {
				xclass: 'iih.mr.qa.score.action.ScoreViewreadyAction',
				blocks: {
					top: 'top',
					bottom: 'bottom'
				}
			},
			'qaScoreItemAdd': {
				xclass: 'iih.mr.qa.score.action.PopupScoreItemViewAction',
				blocks: {
					top: "top",
					bottom: 'bottom'
				}
			},
			'qaScoreItemDelete': {
				xclass: 'iih.mr.qa.score.action.QaScoreDeleteAction',
				url:'qacustom/dropScoreItem',
				blocks: {
					top: "top",
					bottom: 'bottom'
				}
			},
			'qaScoreComplete': {
				xclass: 'iih.mr.qa.score.action.QaScoreCompleteAction',
				url:'qacustom/completeScore',
				blocks: {
					top: "top",
					bottom: 'bottom'
				}
			},
			'qaScoreSearch': {
				xclass: 'iih.mr.qa.score.action.QaScoreSearchAction',
				url: 'qacustom/amrScore',
				//url: 'http://172.18.73.65:8083/scored/amr',
				blocks: {
					condition: 'properties',
					result: 'top'
				}
			},
			'itemClickAction':{
				xclass: 'iih.mr.qa.score.action.ScoreItemClickAction',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			}
			/*'qaScoreComplete': {
				xclass: 'iih.mr.qa.score.action.QaScoreCompleteAction',
				//url:'mr/qaCompleted/amr',
				blocks: {
					top: "top",
					bottom: 'bottom'
				}
			},
			'qaScoreSearch': {
				xclass: 'iih.mr.qa.score.action.QaScoreSearchAction',
				url: 'scored/amr',
				//url: 'http://172.18.73.65:8083/scored/amr',
				blocks: {
					condition: 'properties',
					result: 'top'
				}
			},
			'QaScoreDelete': {
				xclass: 'iih.mr.qa.score.action.QaScoreDeleteAction',
				url: 'qa/fault',
				blocks: {
					top: 'top',
					bottom: 'bottom'
				}
			}*/
		},

		chains: {
			'init':['init'],
			'qaScoreItemAdd':['qaScoreItemAdd'],
			'qaScoreItemDelete':['qaScoreItemDelete'],
			'qaScoreComplete':['qaScoreComplete'],
			'qaScoreSearch':['qaScoreSearch'],
			'itemClickAction':['itemClickAction'],
			'scoreViewready':['scoreViewready']
			
		},

		connections: {
			'top': [/*{
				event: 'afterrender',
				chain: 'init'
			},*/
			],
			'bottom': [{
				event: 'afterrender',
				chain: 'init'
			},{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'scoreViewready'
			},
			{
				selector : 'xapgrid',
				event: 'itemclick',
				chain: 'itemClickAction'
			},
			{
				selector : 'xapactioncolumn[name=qaScoreItemDelete]',
				event: 'clickEvent',
				chain: 'qaScoreItemDelete'
			}
			
			]
		}
	}
})