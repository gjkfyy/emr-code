Ext.define('iih.mr.wr.omr.view.CreateOmrView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.mr.wr.omr.block.CreateMrBlock'
	],

	alias:'widget.createomrview',

	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.mr.wr.omr.block.CreateMrBlock',
                height:515
            }
		},
        actions: {
        	'init': {
				xclass: 'iih.mr.wr.mr.action.MrTemplateInitAction'
            },
            'confim':{
                xclass:'iih.mr.wr.omr.action.ConfimCreateOmrDocAction',
                url:'mr_doc_file',
                blocks:{
                    content:'content'
                }
            },
		    'cancel': {
		        xclass: 'iih.mr.wr.mr.action.CancelCreateMrDocAction',
		        //url:'cancelTemplatePropertyEdit',
		        blocks: {
		            content: 'content'
		        }
		    }
        },  
        chains: {
        	'init': ['init'],
        	'confim': ['confim'],
            'cancel': ['cancel']
        },
        connections: {
        	'content':[{    
                //确认按钮（新建病历选择模板属性）
                selector: 'button[method=confim]',
                event: 'click',
                chain: 'confim'
            },{    
                //取消按钮
                selector: 'button[method=cancel]',
                event: 'click',
                chain: 'cancel'
            }]
        }
	}
})