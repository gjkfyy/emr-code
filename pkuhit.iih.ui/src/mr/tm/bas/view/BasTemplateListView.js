Ext.define('iih.mr.tm.bas.view.BasTemplateListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.tm.bas.block.BasTemplateListBlock',	           
	           'iih.mr.tm.bas.action.OpenBasTemplateFileAction',
	           'iih.mr.tm.bas.action.DeleteBasTemplateListAction',
	           'iih.mr.tm.bas.action.PropertyBasTemplateListAction',
	           'iih.mr.tm.bas.action.ActivatedBasTemplateListAction',
	           'iih.mr.tm.bas.action.StoppedBasTemplateListAction',
	           'iih.mr.tm.bas.action.CreateBasTemplateAction'
	          ],
	
	alias:'widget.basicTemplateListView',	
	
	layout:'fit',

	xapConfig: {
		
		blocks: {
            'right': {
                xclass: 'iih.mr.tm.bas.block.BasTemplateListBlock'
            }
		},

		actions: {
            //查询列表
           'search': {
				xclass: 'iih.mr.tm.bas.action.BasTemplateListSearchAction',
				url:'mr/tpl/baseTemplate',
				blocks: {
					result: 'right'
				}
			},
			'openBasTemplate': {//打开模板
                xclass: 'iih.mr.tm.bas.action.OpenBasTemplateFileAction',
                blocks: {
                	result: 'right'
                }                
            },
			'delete': {//删除
                url:'mr/tpl/baseTemplate',
                xclass: 'iih.mr.tm.bas.action.DeleteBasTemplateListAction',
                blocks: {
                    result: 'right'
                }                
            },
			'property': {//属性编辑
                xclass: 'iih.mr.tm.bas.action.PropertyBasTemplateListAction',
                blocks: {
                    result: 'right'
                }                    
            },
			'activatedbastemplate': {//模板进行启用
                xclass: 'iih.mr.tm.bas.action.ActivatedBasTemplateListAction',
                url:'mr/tpl/activated/baseTemplate',
                blocks: {
                    result: 'right'
                }                
            }, 
            'stoppedbastemplate': {//模板进行停用
                url:'mr/tpl/stopped/baseTemplate',
                xclass: 'iih.mr.tm.bas.action.StoppedBasTemplateListAction',
                blocks: {
                    result: 'right'
                }                
            },
            'createBasTemplate': {//新建基础模板
				xclass: 'iih.mr.tm.bas.action.CreateBasTemplateAction',
				blocks: {
                    result: 'right'
                }      
			},
            'selectionchange':{
                xclass: 'iih.mr.tm.bas.action.BasTemplateRowclickAction',
                blocks: {
                    result: 'right'
                }
            } ,
            'btnstatus':{
                xclass: 'iih.mr.tm.bas.action.BasTemplateBtnStatusAction',
                blocks: {
                    result: 'right'
                }
            }
			},

		chains: {		
			'init': ['search','btnstatus'],
			'openBasTemplate': ['openBasTemplate'],		
			'delete': ['delete'],
			'property': ['property'],
			'activatedbastemplate': ['activatedbastemplate'],
			'stoppedbastemplate': ['stoppedbastemplate'],		 
			'create': ['createBasTemplate'],		
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
	                chain: 'openBasTemplate'
	            }/*,{
	                //删除按钮，更新模板状态删除状态
	                selector: 'button[method=delete]',
	                event: 'click',
	                chain: 'delete'
	            }*/,{	//只能修改新建的属性
	                selector: 'button[method=property]',
	                event: 'click',
	                chain: 'property'
	            },{
	                selector: 'button[method=activated]',
	                event: 'click',
	                chain: 'activatedbastemplate'
	            },{
	                selector: 'button[method=stopped]',
	                event: 'click',
	                chain: 'stoppedbastemplate'
	            },{
					selector: 'button[method=create]',
					event: 'click',
					chain: 'create'
				},{
	                event: 'celldblclick',
	                chain: 'openBasTemplate'
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
        var gridBlock = this.down('bastemplatelistblock');
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
