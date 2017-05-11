Ext.define('iih.sy.followup.view.FollowUpListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	           'iih.sy.followup.block.FollowUpListBlock',
	          ],
	
	alias:'widget.followUpListView',	
	
	layout:'fit',
	
	xapConfig: {
		blocks: {
            'right': {
                xclass: 'iih.sy.followup.block.FollowUpListBlock'
            }
		},

		actions: {
            //查询列表
           'search': {
				xclass: 'iih.sy.followup.action.FollowUpListSearchAction',
				url:'followUpList',
				blocks: {
					result: 'right'
				}
			}
		},
		chains: {		
			'init': ['search']
		},
		connections: {	
		'right': [{	//翻页操作
						event: 'turnpage',
						chain: 'init'
				 }/*,{
		                selector: 'toolbar button[action=search]',
		                event: 'click',
		                chain: 'search'
		         }*/]	
           }
	},
	
	initComponent : function() {
		this.callParent();
		var self = this;
        var gridBlock = this.down('followuplistblock');
        //var pageNum = gridBlock.currentPage;
        var pageNum = '1';
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
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
