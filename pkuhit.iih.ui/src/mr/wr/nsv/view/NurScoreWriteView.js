Ext.define('iih.mr.wr.nsv.view.NurScoreWriteView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	       'iih.mr.wr.nsv.action.NurScoreShowCreateAction',
	       'iih.mr.wr.nsv.action.HasEditConfirmAction',
	       'iih.mr.wr.nsv.action.NurScoreDocDeleteConfirmAction',
	       'iih.mr.wr.nsv.action.NurScoreDocPropertyAction',
	       'iih.mr.wr.nsv.action.NurScoreTreeInitAction'
	],

	alias:'widget.nurscorewriteview',
	id:'nurscorewriteview',
	layout:'border',
	xapConfig: {
		blocks: {
			'left': {
				xclass: 'iih.mr.wr.nsv.block.NurScoreDocTreeBlock',
				region:'west',
				split: true,
                collapsible: true,
                header:false,
				width: 220
            },
			'right': {
				xclass: 'iih.mr.wr.nsv.view.NurScoreDocEditView',
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
				xclass: 'iih.mr.wr.nsv.action.NurScoreTreeInitAction',
				url: '/nsv/tree/init',
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
                xclass: 'iih.mr.wr.nsv.action.NurScoreTreeChangeAction',
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
                xclass: 'iih.mr.wr.nsv.action.NurScoreDocDeleteAction',
                url: 'nsv',
                blocks: {
                    result: 'right'
                }
            },
            'hasEditConfirm': {
                xclass: 'iih.mr.wr.nsv.action.HasEditConfirmAction',
                url: 'omr',
                blocks: {
                    result: 'right'
                }
            },
            'deleteConfirm': {
                xclass: 'iih.mr.wr.nsv.action.NurScoreDocDeleteConfirmAction',
                url: 'omr',
                blocks: {
                    result: 'right'
                }
            },
            'create': {
                xclass: 'iih.mr.wr.nsv.action.NurScoreShowCreateAction',
                url:'param',
                blocks:{
                    result:'left'
                }
            },
            'showcreateview': {
                xclass: 'iih.mr.wr.nsv.action.NurScoreShowCreateAction',
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
                xclass: 'iih.mr.wr.nsv.action.NurScoreDocPropertyAction',
                url: 'nsv',
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
            }
		},

		chains: {
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
            'emrDocProperty':['emrDocProperty'],
            'delete': ['delete'],
            'deleteConfirm':['deleteConfirm'],
            'createErpSign':['createErpSign'],
            'showcreateview':['showcreateview'],
            'erpSignBtnStatus':['erpSignBtnStatus']
		},

		connections: {
			'left': [{
				event: 'afterrender',
				chain: 'treeInit'
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