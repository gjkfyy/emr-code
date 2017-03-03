Ext.define('iih.sy.patient.view.CreateOmrView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.sy.patient.block.CreateMrBlock'
	],

	alias:'widget.createomrview',

	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.sy.patient.block.CreateMrBlock',
                height:515
            }
		},
        actions: {
        	'init': {
				xclass: 'iih.mr.wr.mr.action.MrTemplateInitAction'
            },
            'confimOmr':{
                xclass:'iih.sy.patient.action.ConfimCreateOmrDocAction',
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
        	'confimOmr': ['confimOmr'],
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