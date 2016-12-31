Ext.define('iih.mr.tm.fr.view.FrTplListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.tm.fr.block.FrTplListBlock',	           
	           'iih.mr.tm.fr.action.FrTplFileOpenAction',
	           'iih.mr.tm.fr.action.FrTplDelAction',
	           'iih.mr.tm.fr.action.FrTplProAction',
	           'iih.mr.tm.fr.action.FrTplActivatedAction',
	           'iih.mr.tm.fr.action.FrTplStoppedAction',
	           'iih.mr.tm.fr.action.FrTplCreateAction',
	           'iih.mr.tm.fr.action.FrTplRowclickAction',
	           'iih.mr.tm.fr.action.FrTplBtnStatusAction'
	          ],
	
	alias:'widget.frtpllistview',	
	
	layout:'fit',

	xapConfig: {
		
		blocks: {
            'right': {
                xclass: 'iih.mr.tm.fr.block.FrTplListBlock'
            }
		},

		actions: {
            //查询列表
           'search': {
				xclass: 'iih.mr.tm.fr.action.FrTplListSearchAction',
				url:'mr/tpl/frtpl',
				blocks: {
					result: 'right'
				}
			},
			'frtplopen': {//打开模板
                xclass: 'iih.mr.tm.fr.action.FrTplFileOpenAction',
                blocks: {
                	result: 'right'
                }                
            },
			'delete': {//删除
                url:'mr/tpl/frtpl',
                xclass: 'iih.mr.tm.fr.action.FrTplDelAction',
                blocks: {
                    result: 'right'
                }                
            },
			'property': {//属性编辑
                xclass: 'iih.mr.tm.fr.action.FrTplProAction',
                blocks: {
                    result: 'right'
                }                    
            },
			'activated': {//模板进行启用
                xclass: 'iih.mr.tm.fr.action.FrTplActivatedAction',
                url:'mr/tpl/activated/frtpl',
                blocks: {
                    result: 'right'
                }                
            }, 
            'stopped': {//模板进行停用
                url:'mr/tpl/stopped/frtpl',
                xclass: 'iih.mr.tm.fr.action.FrTplStoppedAction',
                blocks: {
                    result: 'right'
                }                
            },
            'create': {//新建基础模板
				xclass: 'iih.mr.tm.fr.action.FrTplCreateAction',
				blocks: {
                    result: 'right'
                }      
			},
            'selectionchange':{
                xclass: 'iih.mr.tm.fr.action.FrTplRowclickAction',
                blocks: {
                    result: 'right'
                }
            } ,
            'btnstatus':{
                xclass: 'iih.mr.tm.fr.action.FrTplBtnStatusAction',
                blocks: {
                    result: 'right'
                }
            }
		},

		chains: {		
			'init': ['search','btnstatus'],
			'frtplopen': ['frtplopen'],		
			'delete': ['delete'],
			'property': ['property'],
			'activated': ['activated'],
			'stopped': ['stopped'],		 
			'create': ['create'],		
            'selectionchange':['selectionchange'],
            'btnstatus':['btnstatus']
		},

		connections: {	
		'right': [
	            {	//翻页操作
						event: 'turnpage',
						chain: 'init'
				 },{
	                selector: 'button[method=open]',
	                event: 'click',
	                chain: 'frtplopen'
	            },{	//只能修改新建的属性
	                selector: 'button[method=property]',
	                event: 'click',
	                chain: 'property'
	            },{
	                selector: 'button[method=activated]',
	                event: 'click',
	                chain: 'activated'
	            },{
	                selector: 'button[method=stopped]',
	                event: 'click',
	                chain: 'stopped'
	            },{
					selector: 'button[method=create]',
					event: 'click',
					chain: 'create'
				},{
	                event: 'celldblclick',
	                chain: 'frtplopen'
	            },{//行点击时，触发判断操作按钮的有效无效
                    event: 'selectionchange',
                    chain: 'selectionchange'
                }
			]	
           }
	},
	
	initComponent : function() {
		this.callParent();
		var self = this;
        var gridBlock = this.down('frtpllistblock');
        var pageNum = gridBlock.currentPage;
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
		var delBtn = gridBlock.down('button[method=delete]');
		var msg = '确认删除？';
		delBtn.on('click',function(btn){
			XapMessageBox.confirm2(msg, function(btn){
        		if(btn=='yes'){
        			var chainDel = self.getActionChain('delete');
        			chainDel.execute();
        		}
        	});
		});
	}
})
