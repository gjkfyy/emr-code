Ext.define('iih.mr.wr.omr.view.OutMrWriteView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	           'iih.mr.wr.omr.action.CreateOrderAction',
	           'iih.mr.wr.omr.action.iemrCallHisAction',
	           'iih.mr.wr.omr.action.OmrDocTempSortTreeInitAction'
//	    'iih.po.assistant.block.MrDocHelperTreeBlock',
//		'iih.mr.wr.mr.view.MrDocEditView',
//		'iih.po.assistant.action.MrDocTreeNodeChangeAction'
	],

	alias:'widget.outmrwriteview',
	id:'outmrwriteview',
	layout:'border',
	xapConfig: {
		blocks: {
			'left': {
				xclass: 'iih.mr.wr.omr.block.OutMrPatientTreeBlock',
				region:'west',
				split: true,
                collapsible: true,
                header:false,
				width: CONFIG_PARAM.OUT_MR_WRITE_LEFT_WIDTH //220
            },
			'right': {
				xclass: 'iih.mr.wr.omr.view.OutMrDocEditView',
				region:'center',
				flex:1
			},
			'helper': {
			    xclass: 'iih.po.com.view.RightEditView',
			    workscene:'mr',
			    region:'east',
			    split: true,
                collapsible: true,
                collapsed: true,
                header:false,
                width: 250
			}
		},
		
		actions: {
			'refresh': {
				xclass: 'iih.mr.wr.omr.action.OutMrDocTreeInitAction',
				url: 'omr/tree/mrs',
				blocks: {
					result: 'left'
				}
			},
			'treeInit': {
				xclass: 'iih.mr.wr.omr.action.OutMrTreeInitAction',
				url: '/omr/tree/init',
				blocks: {
					result: 'left'
				}
			},
			'tempInit': {
				xclass: 'iih.mr.wr.omr.action.OmrDocTempSortTreeInitAction',
				url: 'mr/tpl/tree/use/notlazy',
				blocks: {
				   result: 'left'
				}
            },
			'amrGroupCreate': {
				xclass: 'iih.mr.wr.omr.action.OmrAmrGroupCreateAction',
				url: '/mr/amr/group/',
				blocks: {
					result: 'left'
				}
			},
			'accordAmrGroupCheck': {
				xclass: 'iih.mr.wr.omr.action.OmrAccordAmrGroupCheckAction',
				url: '/mr/amr/group/',
				blocks: {
					result: 'left'
				}
			},
			'toolbarsInit': {
				xclass: 'iih.mr.wr.omr.action.OmrToolbarsInitAction',
				url: '/mr/amr/',
				blocks: {
					result: 'left'
				}
			},
            'treeNodeChange': {
                xclass: 'iih.mr.wr.omr.action.OutMrDocTreeNodeChangeAction',
                blocks: {
                    result: 'left'
                }
            },
            'createMenu': {
                xclass: 'iih.mr.wr.omr.action.MenuCreateAction',
                blocks: {
                    result: 'left'
                }
            },
            'delete': {
                xclass: 'iih.mr.wr.omr.action.OmrDocDeleteAction',
                url: 'omr',
                blocks: {
                    result: 'right'
                }
            },
            'hasEditConfirm': {
                xclass: 'iih.mr.wr.omr.action.HasEditConfirmAction',
                url: 'omr',
                blocks: {
                    result: 'right'
                }
            },
            'tmpHasEditConfirm': {
                xclass: 'iih.mr.wr.omr.action.TempHasEditConfirmAction',
                url: 'omr',
                blocks: {
                    result: 'right'
                }
            },
            'deleteConfirm': {
                xclass: 'iih.mr.wr.omr.action.OmrDocDeleteConfirmAction',
                url: 'omr',
                blocks: {
                    result: 'right'
                }
            },
            'create': {
                xclass: 'iih.mr.wr.omr.action.CreateOmrDocAction',
                url:'param',
                blocks:{
                    result:'left'
                }
            },
            'createOrder': {//创建处方录入弹出框
                xclass: 'iih.mr.wr.omr.action.CreateOrderAction',
                url:'param',
                blocks:{
                    result:'left'
                }
            },
            'createErpSign': {
                xclass: 'iih.mr.wr.omr.action.CreateErpSingAction',
                url:'param',
                blocks:{
                    result:'left'
                }
            },
            'emrDocProperty': {
                xclass: 'iih.mr.wr.omr.action.OmrDocPropertyAction',
                url: 'omr',
                blocks: {
                    content: 'content'
                }
            },
            'complete': {
                xclass: 'iih.mr.wr.omr.action.CompleteOmrAction',
                url: '/mr/archived/amr',
                blocks: {
                    content: 'content'
                }
            },
            'doSave': {
                xclass: 'iih.mr.wr.omr.action.OmrDoSaveAction',
//                url: '/mr/archived/amr',
                blocks: {
                    content: 'content'
                }
            },
            'cancelComplete': {
                xclass: 'iih.mr.wr.omr.action.CancelCompleteOmrAction',
                url: '/mr/archived/amr',
                blocks: {
                    content: 'content'
                }
            },
            'erpSignBtnStatus':{
            	 xclass: 'iih.mr.wr.omr.action.ErpSignBtnStatusAction',
                 url: 'param/set/getflagbykey',
                 blocks: {
                     content: 'content'
                 }
            },
            'iemrCallHis':{
           	 xclass: 'iih.mr.wr.omr.action.iemrCallHisAction',
                url: '/mr/call/his',
                blocks: {
                    content: 'content'
                }
           },
           'showDoctor': { 
		    	xclass: 'iih.mr.wr.omr.action.ShowDoctorSelectAction',
		        url:'mr/create/init',
		        blocks: {
		            content:'content'
		        }
		    },
		    'createDoc':{
		    	xclass:'iih.mr.wr.omr.action.CreateOmrAction',
                url:'mr_doc_file',
                blocks:{
                    content:'content'
                }
            },
            'showSyqyComp': {//创建指纹采集器
                xclass: 'iih.mr.wr.mr.action.ShowSyqyCompAction',
                url:'param',
                blocks:{
                    result:'left'
                }
            }
		},

		chains: {
			'refresh': ['refresh'],
			'treeInit':['treeInit'],
			'doSave':['doSave'],
			'hasEditConfirm':['hasEditConfirm'],
			'amrGroupCreate':['amrGroupCreate'],
			'accordAmrGroupCheck':['accordAmrGroupCheck'],
			'toolbarsInit':['toolbarsInit'],
			'complete': ['complete'],
			'cancelComplete': ['cancelComplete'],
			'treeNodeChange': ['treeNodeChange'],
			'createMenu': ['createMenu'],
			'create': ['create'],
			'createOrder': ['createOrder'],
            'emrDocProperty':['emrDocProperty'],
            'delete': ['delete'],
            'deleteConfirm':['deleteConfirm'],
            'createErpSign':['createErpSign'],
            'erpSignBtnStatus':['erpSignBtnStatus'],
		    'iemrCallHis':['iemrCallHis'],
		    'tempInit':['tempInit'],
		    'showDoctor':['showDoctor'],
		    'createDoc':['createDoc'],
		    'showSyqyComp':['showSyqyComp'],
		    'tmpHasEditConfirm':['tmpHasEditConfirm']
		},

		connections: {
			'left': [{
				event: 'afterrender',
				chain: 'accordAmrGroupCheck'
			},{
                selector: 'xaptree',
                event: 'itemclick',
                chain: 'treeNodeChange'
		    },{
		    	selector: 'xaptree',
		    	event: 'itemcontextmenu',
		    	chain: 'createMenu'
		    },{
                selector: 'toolbar button[method=delete]',
                event: 'click',
                chain: 'deleteConfirm'
            },{
                selector: 'toolbar button[method=create]',
                event: 'click',
                chain: 'hasEditConfirm'
            },{
                selector: 'toolbar button[method=property]',
                event: 'click',
                chain: 'emrDocProperty'
            },{
                selector: 'toolbar button[method=complete]',
                event: 'click',
                chain: 'complete'
            },{
                selector: 'toolbar button[method=cancelComplete]',
                event: 'click',
                chain: 'cancelComplete'
            },
            {
                selector: 'xaptree[name=omrTempSortTree]',
                event: 'itemdblclick',
                chain: 'tmpHasEditConfirm'
            }]
		}
	},initComponent : function() {
		this.callParent();
		var me = this;
		this.addEvents("writeMrDoc");//为视图添加事件
		this.addListener('writeMrDoc', function() {//添加监听事件
			//写回病历
			var plugin = document.getElementById('iemrEditor');
			var iemrEditorRead = document.getElementById('iemrEditorRead');
			console.log(plugin);
			console.log(iemrEditorRead);
			if(plugin!=null&&iemrEditorRead!=null)
			{
				if(!plugin.IsReadOnly()){
					if(iemrEditorRead.HasSelection(0)){
						iemrEditorRead.OfficeCopy();
						plugin.OfficePaste();
					}
				}
			}
		});
		this.addEvents("changeEncounter");//为视图添加刷新事件
        this.addListener('changeEncounter', function(enPk){//添加监听事件
        	var chainTree = this.getActionChain('treeInit');
	        if(chainTree) {
	            chainTree.execute({
	            	enPk:enPk
	            });
	        }
        });
        this.addEvents("contentRefresh");//为视图添加刷新事件
        this.addListener('contentRefresh', function(){//添加监听事件
            if(this.hasEdit()){
                var workPage = me.up('workareapageview');
                workPage.showConfirm(function() {
                    page = me;
                    workPage.callControllerMethod(page, function(page) {
                        var view = page.up('portalview');
                        var chain = view.getActionChain('openWorkPage');
                        if(chain) {
                            chain.execute({});
                        };
                    });
                }, function() {
                    var view = me.up('portalview');
                    var chain = view.getActionChain('openWorkPage');
                    if(chain) {
                        chain.execute({});
                    };
                }, function() {
                });
            }else{
                var view = me.up('portalview');
                var chain = view.getActionChain('openWorkPage');
                if(chain) {
                    chain.execute({});
                }; 
            }
        });
        this.addEvents("selectEncounter");//为视图添加刷新事件
        this.addListener('selectEncounter', function(){//添加监听事件
            var accordAmrGroupCheck = this.getActionChain('accordAmrGroupCheck');
            if(accordAmrGroupCheck) {
                accordAmrGroupCheck.execute({});
            };
//	        var chainTemplateTree = this.getActionChain('tempInit');
//	        if(chainTemplateTree) {
//	        	chainTemplateTree.execute();
//	        }
        });
	},
	
	hasEdit: function() {
        var plugin = document.getElementById('iemrEditor');
        if (plugin != undefined &&plugin.valid&&plugin.IsModified()) {
            return true;
        } else {
            return false;
        }
    }
});