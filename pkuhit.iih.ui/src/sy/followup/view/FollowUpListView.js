Ext.define('iih.sy.followup.view.FollowUpListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	           'iih.sy.followup.block.FollowUpListBlock',
	          ],
	
	alias:'widget.followUpListView',	
	
	layout:'fit',
	id:'followuplistview',
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
			},
			'getDate':{
				xclass: 'iih.sy.followup.action.FollowUpGetDateAction',
				url:'followUp/getDate',
				blocks: {
					result: 'right'
				}
			},
			'flagEdit': {
                xclass: 'iih.sy.followup.action.FollowUpFlagEditAction',
                url:'',
                blocks:{
                    result:'right'
                }
            },
            'export': {
				xclass: 'iih.sy.followup.action.FollowUpListExportAction',
				url:'file-export',
				blocks: {
					result: 'right'
				}
			}
		},
		chains: {		
			'init': ['search'],
			'getDate': ['getDate'],
			'flagEdit': ['flagEdit'],
			'export': ['export']
		},
		connections: {	
				'right': [{// 翻页操作
					selector : 'xapgrid',
					event : 'turnpage',
					chain : 'init'
				},{
		                selector: 'xapgrid[name=followUpListBlock]',
		                event: 'linkClick',
		                chain: 'flagEdit'
		         }]	
        }
	},
	
	initComponent : function() {
		this.callParent();
		
		//从服务器端获取时间
		var chain = this.getActionChain('getDate');
		chain.execute({
			flag:'14'
		});
	    
		var self = this;
        var gridBlock = this.down('xapgrid[name=followUpListBlock]')
        var pageNum = '1';
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
	        var chain = this.getActionChain('init');
	        if(chain) {
	        	chain.execute({
        			pageNum:pageNum,
                	pageSize:gridBlock.pageSize
	        	});
	        }
		});
		
		
	}
})
