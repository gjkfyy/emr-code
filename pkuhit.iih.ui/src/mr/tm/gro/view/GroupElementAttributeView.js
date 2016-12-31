Ext.define('iih.mr.tm.gro.view.GroupElementAttributeView',{
	extend : 'Xap.ej.stl.view.SingleRecordEditTemplate',

	requires: [
	           'iih.mr.tm.gro.block.GroupElementPropertyEditViewBlock',
	           'iih.mr.tm.gro.action.GroupElementPropertyInitAction',
	           'iih.mr.tm.gro.action.ConfimGroupElementPropertyEditAction',
	           'iih.mr.tm.gro.action.CancelGroupElementPropertyEditAction'
	           ],
	alias:'widget.groupelementattributeview',
	
	layout: 'fit',

	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.tm.gro.block.GroupElementPropertyEditViewBlock'
			}
		},

		actions: {
			'create': { 
			    url:'template_property',
				xclass: 'iih.mr.tm.gro.action.GroupElementPropertyInitAction',
				blocks: {
                    result:'content'
                }
			},
			'confim': {
                xclass: 'iih.mr.tm.gro.action.ConfimGroupElementPropertyEditAction',
                url:'mr/tpl/baseTemplate',
                blocks: {
                    result: 'content'
                }
            },
            'cancel': {
                xclass: 'iih.mr.tm.gro.action.CancelGroupElementPropertyEditAction',
                blocks: {
                    result: 'content'
                }
            }			
		},

		chains: {
			'init': ['create'],
            'confim': ['confim'],
            'cancel': ['cancel'],
		},

		connections: {
			'content': [{    
			    //加载数据
                event: 'afterrender',
                chain: 'init'
            },{    
                //确认按钮
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