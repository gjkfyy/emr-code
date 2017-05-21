Ext.define('iih.sy.search.view.SearchContentView', {
	extend : 'Xap.ej.template.BaseTemplate',
	alias : 'widget.searchcontentview',
	requires : [ 'iih.sy.search.view.SearchLeftView' ],

	autoScroll : true,
	xapConfig : {
		blocks : {
			'condition' : {
				xclass : 'iih.sy.search.block.EMRSearchConditionBlock',
			},
			'result' : {
				xclass : 'iih.sy.search.block.EMRSearchResultGridBlock',
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

		},
		chains : {
			'init':['search'],
			'search': ['search'],
			'clear' : ['clear'],
			'viewMrDocListAction': ['viewMrDocListAction']
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
			}],
		},
		
		initComponent : function() {
			this.callParent();
			
//			//从服务器端获取时间
//			var chain = this.getActionChain('init');
//            chain.execute({
//            	pageNum:1,
//            	pageSize:20
//            });
			
		}
	}
});