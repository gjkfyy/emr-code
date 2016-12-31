Ext.define('iih.mr.wr.nmr.view.NursingRecordsView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: ['Xap.ej.element.grid.column.Date'],

	alias:'widget.nursingrecordsview',
	id:'nursingrecordsview',
	layout:'border',
	xapConfig: {
		blocks: {
			'left': {//左边栏
				xclass: 'iih.mr.wr.nmr.block.NursingRecordsTreeBlock',
				region:'west',
				split: true,
                collapsible: true,
                header:false,
				width: 220
            },
			'right': {//中间默认打开文档用
				xclass: 'iih.mr.wr.nmr.view.NursingRecordsContentView',
				region:'center',
				flex:1
			},
			'helper': {//通用右边个人知识库
			    xclass: 'iih.po.com.view.RightEditView',
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
				xclass: 'iih.mr.wr.nmr.action.NmrTreeInitAction',
				url: '/nmr/tree/nmrs',
				blocks: {
					result: 'left'
				}
			},
            'treeNodeChange': {
                xclass: 'iih.mr.wr.nmr.action.NmrDocTreeNodeChangeAction',
                blocks: {
                    result: 'left'
                }
            },
            'createMenu': {
                xclass: 'iih.mr.wr.nmr.action.MenuCreateAction',
                blocks: {
                    result: 'left'
                }
            },
            'delete': {
                xclass: 'iih.mr.wr.nmr.action.NmrDocDeleteAction',
                url: 'nmr',
                blocks: {
                    result: 'right'
                }
            },
            'hasEditConfirm': {//验证中间文档时否修改过
                xclass: 'iih.mr.wr.nmr.action.HasEditConfirmAction',
               // url: 'omr',
                blocks: {
                    result: 'right'
                }
            },
            'deleteConfirm': {
                xclass: 'iih.mr.wr.nmr.action.NmrDocDeleteConfirmAction',
                url: 'nmr',
                blocks: {
                    result: 'right'
                }
            },
            'create': {
                xclass: 'iih.mr.wr.nmr.action.CreateNmrDocAction',
                url:'param',
                blocks:{
                    result:'left'
                }
            },
            'showCreateView':{
            	xclass: 'iih.mr.wr.nmr.action.NmrShowCreateAction',
            	 blocks:{
                   result:'left'
               }
            },
            'emrDocProperty': {
                xclass: 'iih.mr.wr.nmr.action.NmrDocPropertyAction',
                url: 'nmr',
                blocks: {
                    content: 'content'
                }
            },
            'finish': {
                xclass: 'iih.mr.wr.nmr.action.NmrDocFinishWriteAction',
                url: 'mr/writeCompleted/amr',
                blocks: {
                    content: 'content'
                }
            },
            'checkFinish': {
                xclass: 'iih.mr.wr.nmr.action.NmrCheckFinishAction',
                url: 'checkFinish',
                blocks: {
                    content: 'content'
                }
            },
            'showSyqyComp': {//创建指纹采集器
                xclass: 'iih.mr.wr.mr.action.ShowSyqyCompAction',
                url:'param',
                blocks:{
                    result:'left'
                }
            },
            'showBatchPrint': {//批量打印页面
                xclass: 'iih.mr.wr.nmr.action.ShowBatchPrintAction',
                url:'param',
                blocks:{
                    result:'left'
                }
            },
            'emrSave' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocSaveAction',
				url : 'nmr',
				// url: 'http://127.0.0.1:8081/mr',
				blocks : {
					content : 'content'
				}
			}
            
		},

		chains: {
			'refresh': ['refresh'],
			'doSave': ['emrSave'],
			'showCreateView':['showCreateView'],
			'hasEditConfirm':['hasEditConfirm'],
			'treeNodeChange': ['treeNodeChange'],
			'createMenu': ['createMenu'],
			'create': ['showCreateView'],
			'finish':['finish'],
            'emrDocProperty':['emrDocProperty'],
            'delete': ['delete'],
            'deleteConfirm':['deleteConfirm'],
            'showSyqyComp':['showSyqyComp'],
            'checkFinish':['checkFinish'],
            'showBatchPrint':['showBatchPrint']
		},

		connections: {
			'left': [{
				event: 'afterrender',
				chain: 'refresh'
			},{
		    	selector: 'xaptree',
		    	event: 'itemcontextmenu',
		    	chain: 'createMenu'
		    },
			{
                selector: 'xaptree',
                event: 'itemclick',
                chain: 'treeNodeChange'
		    },
		    {
                selector: 'toolbar button[method=delete]',
                event: 'click',
                chain: 'deleteConfirm'
            },
			{
                selector: 'toolbar button[method=create]',
                event: 'click',
                chain: 'hasEditConfirm'
            }
				,{
                selector: 'toolbar button[method=property]',
                event: 'click',
                chain: 'emrDocProperty'
            }
//				,
//            {
//                selector: 'toolbar button[method=complete]',
//                event: 'click',
//                chain: 'complete'
//            },
//            {
//                selector: 'toolbar button[method=cancelComplete]',
//                event: 'click',
//                chain: 'cancelComplete'
//            }
            ]
		}
	},
	initComponent : function() {
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
        	var chainTree = this.getActionChain('refresh');
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
    		var accordAmrGroupCheck = this.getActionChain('refresh');
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