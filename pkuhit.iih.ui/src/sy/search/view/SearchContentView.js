Ext.define('iih.sy.search.view.SearchContentView', {
	extend : 'Xap.ej.template.BaseTemplate',
	alias : 'widget.searchcontentview',
	requires : [ 'iih.sy.search.view.SearchLeftView' ],

	autoScroll : true,
	xapConfig : {
		blocks : {
			'condition' : {
				xclass : 'iih.sy.search.block.EMRSearchConditionBlock'
			},
			'result' : {
				xclass : 'iih.sy.search.block.EMRSearchResultGridBlock'
			}
		},

		actions : {
			// 搜索
			'search' : {
				xclass : 'iih.sy.search.action.AdvancedSearchAction',
				url : 'advancedSearch',
				blocks : {
					result : 'result'
				}
			},
			'clear' : {
				xclass : 'iih.sy.search.action.ClearSearchConditionAction'
					
			},
        	'viewMrDocListAction': {
				xclass: 'iih.sy.search.action.ViewMrDocListAction',
				url: 'omr',
				blocks: {
					result: 'result'
				}
			},
			'saveHistory' : {
				xclass : 'iih.sy.search.action.SaveSearchHistoryAction'
			}

		},
		chains : {
			'init':['search'],
			'search': ['search'],
			'clear' : ['clear'],
			'viewMrDocListAction': ['viewMrDocListAction'],
			'saveHistory' : ['saveHistory']
		},

		connections : {
			'result': [{// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'init'
			},{
				event: 'afterrender',
				chain: 'init'
			},{// 
				selector : 'xapgrid',
				event : 'itemdblclick',
				chain : 'viewMrDocListAction'
			},{
				selector: 'button[action=clear]',
				event: 'click',
				chain: 'clear'
			},{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'saveHistory'
			}],
		},
		
		initComponent : function() {
			this.callParent();
			
		}
	}
});