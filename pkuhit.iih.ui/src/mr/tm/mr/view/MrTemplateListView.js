Ext.define('iih.mr.tm.mr.view.MrTemplateListView',{
	extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',

	requires: [
	           	'Xap.ej.element.grid.column.Date',
 				'iih.mr.tm.mr.block.MrTemplateTreeBlock',
 				'iih.mr.tm.mr.block.MrTemplateListBlock',
				'iih.mr.tm.mr.block.MrTemplateWorkBlock',
				'iih.mr.tm.mr.action.MrTemplateListSearchAction',
				'iih.mr.tm.mr.action.MrTemplateActivateAction',
				'iih.mr.tm.mr.action.MrTemplateLoadTreeDataAction',
				'iih.mr.tm.mr.action.MrTemplateTreeNodeChangeAction',
				'iih.mr.tm.mr.action.CreateTemplateAction',
				'iih.mr.tm.mr.action.OpenTemplateAction',
				'iih.mr.tm.mr.action.SubmitTemplateAction',
				'iih.mr.tm.mr.action.DeleteMrTemplateListAction',
				'iih.mr.tm.mr.action.PropertyTemplateListAction',
				'iih.mr.tm.mr.action.DisableTemplateAction',
				'iih.mr.tm.mr.action.MrTemplateUpSortAction',
				'iih.mr.tm.mr.action.MrTemplateDownSortAction',
				'iih.mr.tm.mr.action.EnableTemplateAction'],
               
	alias:'widget.mrtemplatelistview',	

	xapConfig: {
		blocks: {
			'left': {
                xclass: 'iih.mr.tm.mr.block.MrTemplateTreeBlock',
                width:200
            },
            'right': {
                xclass: 'iih.mr.tm.mr.block.MrTemplateWorkBlock',
                flex:1
            }
		},		
		actions: {
			'search': {
				//xclass: 'iih.mr.tm.mr.action.MrTemplateListSearchAction',
				//url:'mr/tpl/template',
				xclass: 'iih.mr.tm.mr.action.MrTemplateListNewSearchAction',
                url:'mr/tpl/search',
				blocks: {
					left: 'left',
					result: 'right'
				}
			},
			'mrTemplateActivate': {
				xclass: 'iih.mr.tm.mr.action.MrTemplateActivateAction',
				url:'mr/basefile',
				blocks: {
					result: 'right'
				}
			},
			'refreshTree': {
                //xclass: 'iih.mr.tm.mr.action.MrTemplateLoadTreeDataAction',
                //url:'mr/tpl/tree/notlazy',
                xclass: 'iih.mr.tm.mr.action.MrTemplateLoadTreeAction',
                url:'mr/tpl/newtree',
                blocks: {
                    result: 'left',
                }
            },
			'mrtemplateClick': {
				xclass: 'iih.mr.tm.mr.action.MrtemplateClickAction',
				blocks: {
					result: 'right'
				}
			},
            'mrTemplateTreeNodeChange': {
                //xclass: 'iih.mr.tm.mr.action.MrTemplateTreeNodeChangeAction',
                //url:'mr/tpl/template',
                xclass: 'iih.mr.tm.mr.action.MrTemplateListNewSearchAction',
                url:'mr/tpl/search',
                blocks: {
                    result: 'left',
                    right: 'right'
                }
            },
			'createTemplate': {
				xclass: 'iih.mr.tm.mr.action.CreateTemplateAction',
				blocks: {
					result: 'right'
                }      
			}, 
			'openTemplate': {
				xclass: 'iih.mr.tm.mr.action.OpenTemplateAction',
				blocks: {
					result: 'right'
                }      
			},            
			'submitTemplate': {
				xclass: 'iih.mr.tm.mr.action.SubmitTemplateAction',
				url:'mr/tpl/submitted/template',
				blocks: {
					result: 'right'
                }      
			},
			'deleteTemplate': {
				xclass: 'iih.mr.tm.mr.action.DeleteMrTemplateListAction',
				url:'mr/tpl/template',
				blocks: {
					result: 'right'
                }      
			},
			'propertyTemplate': {
				xclass: 'iih.mr.tm.mr.action.PropertyTemplateListAction',
				url:'mr/tpl/template',
				blocks: {
					result: 'right'
                }      
			},
			'disableTemplate': {
				xclass: 'iih.mr.tm.mr.action.DisableTemplateAction',
				url:'mr/tpl/stopped/template',
				blocks: {
					result: 'right'
                }      
			},
			'enableTemplate': {
				xclass: 'iih.mr.tm.mr.action.EnableTemplateAction',
				url:'mr/tpl/activated/template',
				blocks: {
					result: 'right'
                }      
			},
			'defaultTemplate': {
				xclass: 'iih.mr.tm.mr.action.DefaultTemplateAction',
				url:'mr/tpl/default/template',
				blocks: {
					result: 'right'
                }      
			},
			'selectionchange':{
                xclass: 'iih.mr.tm.mr.action.MrTemplateRowclickAction',
                blocks: {
                    result: 'right'
                }
            } ,
			'btnstatus':{
                xclass: 'iih.mr.tm.mr.action.MrTemplateBtnStatusAction',
                blocks: {
                    result: 'right'
                }
            },
            'mrTypeCodeInit': { 
				xclass: 'iih.mr.tm.mr.action.MrTypeCodeInitAction',
				url:'mr/type/tree',
				blocks: {
                    result:'left'
                }
			},
            'mrCcatCodeInit': { 
				xclass: 'iih.mr.tm.mr.action.MrCcatCodeInitAction',
				url:'mr/ccat/tree',
				blocks: {
                    result:'left'
                }
			},
			'upSort': {
				xclass: 'iih.mr.tm.mr.action.MrTemplateUpSortAction',
				url:'mr/tpl/template/changeSort',
				blocks: {
					left: 'left',
					result: 'right'
				}
			},
			'downSort': {
				xclass: 'iih.mr.tm.mr.action.MrTemplateDownSortAction',
				url:'mr/tpl/template/changeSort',
				blocks: {
					left: 'left',
					result: 'right'
				}
			}
		},

		chains: {
			'init': ['search'],
			'initTree': ['refreshTree'],
			'mrTemplateTreeNodeChange': ['mrTemplateTreeNodeChange'],
			//'treeItemExpand': ['treeItemExpand'],
			'beforeActivate': ['mrTemplateActivate'],
			'mrtemplateClick': ['mrtemplateClick'],
			'createTemplate': ['createTemplate'],
			'openTemplate': ['openTemplate'],
			'submitTemplate': ['submitTemplate'],
			'deleteTemplate': ['deleteTemplate'],
			'propertyTemplate': ['propertyTemplate'],
			'disableTemplate': ['disableTemplate'],
			'enableTemplate': ['enableTemplate'],
			'defaultTemplate': ['defaultTemplate'],
			'selectionchange':['selectionchange'],	
			/*'issueTemplate': ['issueTemplate'],
			'verifyTemplate': ['verifyTemplate'],
			'rejectTemplate': ['rejectTemplate'],
			'cancleVerifyTemplate': ['cancleVerifyTemplate'],
			'mrTemplateStatCdChange': ['mrTemplateStatCdChange'],*/
 			'btnstatus':['btnstatus'],
 			'upSort':['upSort'],
 			'downSort':['downSort'],
			'mrCcatCodeInit':['mrCcatCodeInit'],
			'mrTypeCodeInit':['mrTypeCodeInit'],
			'searchAll':['search','refreshTree'],
			'ccatselect':['search','refreshTree','mrTypeCodeInit']
			},
			
			connections: {
				'left': [{
				    selector: 'xapcombobox[name=mrTplCCat]',
				    event: 'afterrender',
				    chain: 'mrCcatCodeInit'
				},{
				    selector: 'xapcombobox[name=mrTplTypeCd]',
				    event: 'afterrender',
				    chain: 'mrTypeCodeInit'
				}/*,{
	                selector: 'xaptree[name=mrTemplate]',
	                event: 'afterrender',
	                chain: 'initTree'
				}*/,{
	                 selector: 'xaptree[name=mrTemplate]',
	                 event: 'itemclick',
	                 chain: 'mrTemplateTreeNodeChange'
				},{
	                 selector: 'xaptrigger[name=mrTemplateTrigger]',
	                 event: 'onTriggerClick',
	                 chain: 'initTree'
				},{
				    //combox的change时间
				    selector: 'xapcombobox[name=mrTplCCat]',
				    event: 'select',
				    chain: 'ccatselect'
				}
				,{
				    //combox的change时间
				    selector: 'xapcombobox[name=mrTplTypeCd]',
				    event: 'select',
				    chain: 'initTree'
				},{
				    //combox的change时间
				    selector: 'xapcombobox[name=mrTplStatCd]',
				    event: 'select',
				    chain: 'initTree'
				}
				],
			'right': [
			          {	//翻页操作
							selector: 'mrtemplatelistblock',
							event: 'turnpage',
							chain: 'init'
					 }/*,{    
						selector: 'mrtemplatelistblock',
					    event: 'afterrender',
					    chain: 'init'
					 }*/,{  
						 selector: 'mrtemplatelistblock',
		                 event: 'cellclick',
		                 chain: 'selectionchange'
					 },{  
						 selector: 'mrtemplatelistblock',
		                 event: 'celldblclick',
		                 chain: 'openTemplate'
					 },{
		                //新建按钮
		                selector: 'button[method=create]',
		                event: 'click',
		                chain: 'createTemplate'
		            },{
		                //打开按钮
		                selector: 'button[method=open]',
		                event: 'click',
		                chain: 'openTemplate'
		            }/*,{
		                //删除按钮
		                selector: 'button[method=delete]',
		                event: 'click',
		                chain: 'deleteTemplate'
		            }*/,{
		                //属性按钮
		                selector: 'button[method=property]',
		                event: 'click',
		                chain: 'propertyTemplate'
		            },{
		                //停用按钮
		                selector: 'button[method=disable]',
		                event: 'click',
		                chain: 'disableTemplate'
		            },{
		                //启用按钮
		                selector: 'button[method=enable]',
		                event: 'click',
		                chain: 'enableTemplate'
		            },{
		                //向上
		                selector: 'button[method=upSort]',
		                event: 'click',
		                chain: 'upSort'
		            },{
		                //向下
		                selector: 'button[method=downSort]',
		                event: 'click',
		                chain: 'downSort'
		            },{
		                //模板默认设置按钮
		                selector: 'button[method=default]',
		                event: 'click',
		                chain: 'defaultTemplate'
		            }/*,{//行点击时，触发判断操作按钮的有效无效
	                    selector: 'mrtemplatelistblock',
	                    event: 'selectionchange',
	                    chain: 'selectionchange'
	                }*/]
		}
		
	},
	initComponent : function() {
		this.callParent();
		var self = this;
		var gridBlock = self.down('mrtemplatelistblock');
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
	        var chainTree = this.getActionChain('initTree');
	        if(chainTree) {
	        	chainTree.execute();
	        }
		});
		var delBtn = gridBlock.down('button[method=delete]');
		var msg = '确认删除？';
		delBtn.on('click',function(btn){
			XapMessageBox.confirm2(msg, function(btn){
        		if(btn=='yes'){
        			var chainDel = self.getActionChain('deleteTemplate');
        			chainDel.execute();
        		}
        	});
		});
	}
})
