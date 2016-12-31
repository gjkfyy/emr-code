Ext.define('iih.po.com.view.MrDocTreeView', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	           'iih.po.com.block.MrDocTreeBlock',
	           'iih.po.com.action.MrDocTreeInitAction'
	           ],

	alias:'widget.mrdoctreeview',
	
	layout:'fit',
	
	xapConfig: {
		blocks: {
			'list': {
	                xclass: 'iih.po.com.block.MrDocTreeBlock',
	                width:200
	                
	        }
		},

		actions: {
			'refreshTree': {
				//url:'tree/mrs',
				url: 'mr_doc_tree/mrs',
                xclass: 'iih.po.com.action.MrDocTreeInitAction',
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