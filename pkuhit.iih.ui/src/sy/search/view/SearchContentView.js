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
			},
			'export' : {
				xclass : 'iih.sy.search.action.ExportExcelAction',
				url: 'file-export'
			},
			'comboboxInit' :{
				xclass : 'iih.sy.search.action.MrComboboxInitAction',
				url: 'mr/md/shareElement'
			}

		},
		chains : {
			'init':['search'],
			'search': ['search'],
			'clear' : ['clear'],
			'viewMrDocListAction': ['viewMrDocListAction'],
			'saveHistory' : ['saveHistory'],
			'export' : ['export'],
			'comboboxInit' : ['comboboxInit']
		},

		connections : {
			'result': [{// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'search'
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
			},{
				selector: 'button[action=export]',
				event: 'click',
				chain: 'export'
			}],
			'condition' : [{
					event: 'afterrender',
					chain: 'comboboxInit'
			}]
		},
		
		initComponent : function() {
			this.callParent();
			
		}
	}
});