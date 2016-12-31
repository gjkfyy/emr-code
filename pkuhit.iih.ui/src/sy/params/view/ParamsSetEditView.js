Ext.define('iih.sy.params.view.ParamsSetEditView',{
	extend : 'Xap.ej.stl.view.SingleRecordEditTemplate',

	requires: [
				'iih.sy.params.action.ParamsSetEditInitAction',
				'iih.sy.params.action.CancelParamsSetEditAction',
				'iih.sy.params.action.ParamsSetEditInitAction'
	           ],
	alias:'widget.paramsseteditview',
	
	layout: 'fit',
	
	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.sy.params.block.ParamsSetEditBlock'
			}
		},

		actions: {
			'init': { 
				xclass: 'iih.sy.params.action.ParamsSetEditInitAction',
				url: 'param/set/one',
				blocks: {
                    result:'content'
                }
			},
			'confim': {
                xclass: 'iih.sy.params.action.ConfimParamsSetEditAction',
                url:'param/set/update',
                blocks: {
                    result: 'content'
                }
            },
            'cancel': {
                xclass: 'iih.sy.params.action.CancelParamsSetEditAction',
                blocks: {
                    result: 'content'
                }
            },
            'check': {
                xclass: 'iih.sy.params.action.CheckParamsSetEditAction',
                url:'param/set/check',
                blocks: {
                    result: 'content'
                }
            }
		},

		chains: {
			'init': ['init'],
            'confim': ['confim'],
            'cancel': ['cancel'],
            'check': ['check']
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
                chain: 'check'
            },{    
                //取消按钮
                selector: 'button[method=cancel]',
                event: 'click',
                chain: 'cancel'
            }]
		}
	},
	initComponent : function() {
		this.callParent();
	}
})