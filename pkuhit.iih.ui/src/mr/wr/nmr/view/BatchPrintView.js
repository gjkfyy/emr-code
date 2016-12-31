Ext.define('iih.mr.wr.nmr.view.BatchPrintView', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [],

	alias : 'widget.batchprintview',
	id : 'batchprintview',
	layout : {
		type : 'vbox',
		align : 'stretch'
	},
	xapConfig : {
		blocks : {
			'condition' : {
				xclass : 'iih.mr.wr.nmr.block.BatchConditionBolck',
				height : 45
			},
			'content' : {
				xclass : 'iih.mr.wr.nmr.block.BatchDocListBlock'
			},
			'bottom':{
				xclass : 'iih.mr.wr.nmr.view.BatchDocEditView',
				height : 600//flex : 1
			}
		},

		actions : {
			'init': {
				xclass: 'iih.mr.wr.nmr.action.BatchMrSearchAction',
				url: 'batchPrint/mrs',
				blocks: {
					content: 'content'
				}
            },
			'initBatchCustCla' : {
				xclass : 'iih.mr.wr.nmr.action.InitBatchConditionAction',
				url : 'mr/create/init',
				blocks : {
					condition : 'condition'
				}
			},
			'searchBatchType' : {
				xclass : 'iih.mr.wr.nmr.action.SearchBatchTypeAction',
				url : 'mrtypes',
				blocks : {
					condition : 'condition'
				}
			},
            'printMrInit' : {
				xclass : 'iih.mr.wr.nmr.action.BatchDocInitAction',
				url : 'nmr',
				blocks : {
					bottom : 'bottom'
				}
			},
			'btachMrsCheckPrint' : {
				xclass : 'iih.mr.wr.nmr.action.BatchSelectedCheckAction',
				url : 'nmr',
				blocks : {
					bottom : 'bottom'
				}
			}
		},
		chains : {
			'init' : [ 'init' ],
			'searchBatchType' : [ 'searchBatchType' ],
			'initBatchCustCla' : [ 'initBatchCustCla' ],
//            'editorCallBackAction':['editorCallBackAction'],
//            'disabledOfficeToolBarAction':['disabledOfficeToolBarAction'],
            'printMrInit':['printMrInit'],
            'btachMrsCheckPrint':['btachMrsCheckPrint']
		},
		connections : {
			'condition' : [ {
				event : 'afterrender',
				chain : 'initBatchCustCla'
			}, {
				selector : 'xapcombobox[name=batchCategoryCode]',
				event : 'change',
				chain : 'searchBatchType'
			}, {
				selector : 'xapcombobox[name=batchCategoryCode]',
				event : 'select',
				chain : 'init'
			} ],
			'content': [ {
				event : 'afterrender',
				chain : 'init'
			}, {// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'init'
			}
//			, {// grid双击
//				selector : 'xapgrid',
//				event : 'itemdblclick',
//				chain : 'printMrInit'
//			}
			]

		}
	}
});