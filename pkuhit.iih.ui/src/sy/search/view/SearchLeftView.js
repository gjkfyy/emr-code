Ext.define('iih.sy.search.view.SearchLeftView', {
	extend : 'Xap.ej.template.BaseTemplate',

	alias : 'widget.searchleftview',
	id:'searchleftview',

	requires : [
		'iih.sy.search.action.HistoryDeleteAction'
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
			},
			'delete': {
				xclass: 'iih.sy.search.action.HistoryDeleteAction',
				url:"deleteCondition",
				blocks: {
					result: 'historyGrid'
				}
			},
			'loadCondition':{
				xclass : 'iih.sy.search.action.LoadConditionAction'
					
			}
		},

		chains : {
			'init' : [ 'init' ],
			'delete' : ['delete'],
			'loadCondition' : ['loadCondition']
		},

		connections : {
			'historyGrid':[{// 
				selector : 'xapgrid',
				event : 'itemdblclick',
				chain : 'loadCondition'
			}]
			
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