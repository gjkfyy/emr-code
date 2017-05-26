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
				url: 'searchCondition'
			},
			'cancel':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains : {
			'save':['save'],
			'cancel':['cancel']
		},
		connections : {
			'content': [{
				selector: 'button[name=confim]',
				event: 'click',
				chain: 'save'
			},{
				selector: 'button[name=cancel]',
				event: 'click',
				chain: 'cancel'
			}]
		},
		
		initComponent : function() {
			this.callParent();
			
		}
	}
})