Ext.define('iih.mr.qa.process_qa_work.view.QaMrDocTreeView', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	           'iih.mr.qa.process_qa_work.block.QaMrDocTreeBlock',
	           'iih.mr.qa.process_qa_work.action.QaMrDocTreeInitAction'
	           ],

	alias:'widget.qamrdoctreeview',
	
	layout:'fit',
	
	xapConfig: {
		blocks: {
			'list': {
	                xclass: 'iih.mr.qa.process_qa_work.block.QaMrDocTreeBlock',
	                width:200
	                
	        }
		},

		actions: {
			'refreshTree': {
				//url:'tree/mrs',
				url: 'mr_doc_tree/mrs',
                xclass: 'iih.mr.qa.process_qa_work.action.QaMrDocTreeInitAction',
                blocks: {
                    result: 'list'
                }
			}
		},

		chains: {
			'initTree': ['refreshTree']
		}

		/*connections: {
			'list': [ {
                selector: 'xaptree',//[name=groupElement]名字加不上
                event: 'afterrender',
                chain: 'initTree'
	         }]
		}*/
	}
	
})