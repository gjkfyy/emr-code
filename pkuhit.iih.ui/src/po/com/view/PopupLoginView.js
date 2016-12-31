Ext.define('iih.po.com.view.PopupLoginView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.popuploginview', 
	
	requires:[],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.po.com.block.PopupLoginBlock'
			}
		},
		actions:{
		    'reLogin': {
                xclass: 'iih.po.com.action.ReLoginAction',
                blocks: {
                    content: 'content'
                }
            }
		},
		chains:{
		    'reLogin': ['reLogin']
		},
		connections:{
		    'content': [{
		        selector: 'button[action=login]',
                event: 'click',
                chain: 'reLogin'
            }]
		}
	}
})