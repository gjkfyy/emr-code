Ext.define('iih.mr.tm.fr.view.FrTplProEditView',{
	extend : 'Xap.ej.stl.view.SingleRecordEditTemplate',

	requires: [
	           'iih.mr.tm.fr.block.FrTplProEditBlock',
	           'iih.mr.tm.fr.action.FrTplProEditConfimAction',
	           'iih.mr.tm.fr.action.FrTplProEditCancelAction',
	           'iih.mr.tm.fr.action.FrTplProEditCheckAction'
	           ],
	alias:'widget.frtplproeditview',
	
	layout: 'fit',
	
	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.tm.fr.block.FrTplProEditBlock'
			}
		},

		actions: {
			'create': { 
				xclass: 'iih.mr.tm.fr.action.FrTplProInitAction',
				url: 'mr/tpl/frtpl',
				blocks: {
                    result:'content'
                }
			},
			'confim': {
                xclass: 'iih.mr.tm.fr.action.FrTplProEditConfimAction',
                url:'mr/tpl/frtpl',
                blocks: {
                    result: 'content'
                }
            },
            'cancel': {
                xclass: 'iih.mr.tm.fr.action.FrTplProEditCancelAction',
                blocks: {
                    result: 'content'
                }
            },
            'check': {
                xclass: 'iih.mr.tm.fr.action.FrTplProEditCheckAction',
                url:'mr/tpl/frtpl/check',
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
	        var gridBlock = this.down('frtpllistblock');
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