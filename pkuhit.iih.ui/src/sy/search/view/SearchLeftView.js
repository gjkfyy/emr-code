Ext.define('iih.sy.search.view.SearchLeftView', {
	extend : 'Xap.ej.template.BaseTemplate',

	alias : 'widget.searchleftview',

	requires : [

	],
	xapConfig : {
		blocks : {
			'historyGrid' : {
				xclass : 'iih.sy.search.block.SearchHistoryBlock'
			}
		},
		actions : {
			'init' : {
				xclass : 'iih.sy.search.action.SearchConditionListAction',
				url : 'searchConditionList',
				blocks : {
					result : 'historyGrid'
				}
			}
		},

		chains : {
			'init' : [ 'init' ]
		},

		connections : {
			
		}
	},
	

	initComponent : function() {
		this.callParent();

		 //初始化"我的搜索"
		 var chain = this.getActionChain('init');
		 chain.execute({
			 pageNum:1,
			 pageSize:20
		 });

	}
})