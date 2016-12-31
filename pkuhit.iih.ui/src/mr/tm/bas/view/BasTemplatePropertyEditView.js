Ext.define('iih.mr.tm.bas.view.BasTemplatePropertyEditView',{
	extend : 'Xap.ej.stl.view.SingleRecordEditTemplate',

	requires: [
	           'iih.mr.tm.bas.block.BasTemplatePropertyEditViewBlock',
	           'iih.mr.tm.bas.action.ConfimBasTemplatePropertyEditAction',
	           'iih.mr.tm.bas.action.CancelBasTemplatePropertyEditAction',
	           'iih.mr.tm.bas.action.CheckBasTemplatePropertyEditAction'
	           ],
	alias:'widget.bastemplatepropertyeditview',
	
	layout: 'fit',
	
	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.tm.bas.block.BasTemplatePropertyEditViewBlock'
			}
		},

		actions: {
			'create': { 
				xclass: 'iih.mr.tm.bas.action.BasTemplatePropertyInitAction',
				url: 'mr/tpl/baseTemplate',
				blocks: {
                    result:'content'
                }
			},
			'confim': {
                xclass: 'iih.mr.tm.bas.action.ConfimBasTemplatePropertyEditAction',
                url:'mr/tpl/baseTemplate',
                blocks: {
                    result: 'content'
                }
            },
            'cancel': {
                xclass: 'iih.mr.tm.bas.action.CancelBasTemplatePropertyEditAction',
                blocks: {
                    result: 'content'
                }
            },
            'check': {
                xclass: 'iih.mr.tm.bas.action.CheckBasTemplatePropertyEditAction',
                url:'mr/tpl/baseTemplate/HasDuplicationOfName',
                blocks: {
                    result: 'content'
                }
            }
			
		},

		chains: {
			'init': ['create'],
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
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
	        var gridBlock = this.down('mrtemplatelistblock');
	        var pageNum = gridBlock.currentPage;
	        var chain = this.getActionChain('init');
	        if(chain) {
	        	chain.execute({
	        		pageNum:pageNum,
	            	pageSize:'25'
	        	});
	        }
		});
	}
})