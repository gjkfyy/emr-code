Ext.define('iih.sy.search.view.HistorySaveView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.sy.search.block.HistorySaveBlock'
	],

	alias:'widget.historysaveview',
	
	layout: 'fit',

	xapConfig: {
		blocks: {
			'content': {
                xclass: 'iih.sy.search.block.HistorySaveBlock'
            }
		},
		actions : {
			'save' : {
				xclass : 'iih.sy.search.action.SaveSearchHistoryDataAction',
				url: 'searchCondition',
			}
		},
		chains : {
			'save':['save']
		},
		connections : {
			'content': [{
				selector: 'button[name=confim]',
				event: 'click',
				chain: 'save'
			},{
				selector: 'button[name=cancel]',
				event: 'click',
				chain: 'saveHistory'
			}],
		},
		
		initComponent : function() {
			this.callParent();
			
		}
	}
})