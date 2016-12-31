Ext.define('iih.mr.wr.mr.view.MrDocListView', {
	extend: 'Xap.ej.stl.view.LeftRightContainerTemplate',

	requires: [
	           'iih.mr.wr.mr.block.MrDocListBlock',
	           'iih.mr.wr.mr.block.MrDocSortTreeBlock',
	           'iih.mr.wr.mr.action.MrDocSortTreeInitAction',
	           'iih.mr.wr.mr.action.MrDocTreeSelectAction',
	           'iih.mr.wr.mr.action.MrDocListInitAction',
	           'iih.mr.wr.mr.action.MrDocBtnUsableAction',
	           'iih.mr.wr.mr.action.MrDocListSelectAction',
	           'iih.mr.wr.mr.action.OpenMrDocAction',
	           'iih.mr.wr.mr.action.CreateMrDocAction',
	           'iih.mr.wr.mr.action.MrDocListDeleteAction',
               'iih.mr.wr.mr.action.MrDocPropertyAction',
               'iih.mr.wr.mr.action.ConfirmCompleteAction',
               'iih.mr.wr.mr.action.MrDocFinishWriteAction',
               'iih.mr.wr.mr.action.MrDocTempSortTreeInitAction',
               'iih.mr.wr.mr.action.MrDocListFreshAction',
               'iih.mr.wr.mr.action.ShowDoctorSelectAction',
               'iih.mr.qa.pat_case.action.PatCasePopAction'
       
    ],
    
	alias:'widget.mrdoclistview',
    id:'mrdoclistview',
	xapConfig: {
		
		blocks: {
			'left': {
		        xclass: 'iih.mr.wr.mr.block.MrDocSortTreeBlock',
		        width:200
            },
		    'right': {
		        xclass: 'iih.mr.wr.mr.block.MrDocListBlock'
            }
		},
        actions: {
        	'init': {
				xclass: 'iih.mr.wr.mr.action.MrDocSortTreeInitAction',
				url: 'sorttree/mrs',
				blocks: {
				   result: 'left'
				}
            },
            'tempInit': {
				xclass: 'iih.mr.wr.mr.action.MrDocTempSortTreeInitAction',
				url: 'mr/tpl/tree/use/notlazy',
				blocks: {
				   result: 'left'
				}
            },
            'treeSelect': {
				xclass: 'iih.mr.wr.mr.action.MrDocTreeSelectAction',
				url: 'mrs',
				blocks: {
				   result: 'right'
				}
            },
		    'btnUsable':{
                xclass:'iih.mr.wr.mr.action.MrDocBtnUsableAction',
                url:'mr/amr',
                blocks:{
                    result:'right'
                }
            },
		    'select':{
                xclass:'iih.mr.wr.mr.action.MrDocListSelectAction',
                url:'mr',
                blocks:{
                    result:'right'
                }
            },
            'create': {
                xclass: 'iih.mr.wr.mr.action.CreateMrDocAction',
                blocks:{
                    result:'left'
                }
            },
            'open': {
                xclass: 'iih.mr.wr.mr.action.OpenMrDocAction',
                blocks: {
                    result: 'right'
                }
            },
            'emrDocProperty': {
                xclass: 'iih.mr.wr.mr.action.MrDocPropertyAction',
                url: 'mr',
                blocks: {
                    content: 'content'
                }
            },
            'templateProperty': {
                xclass: 'iih.mr.wr.mr.action.MrTemplatePropertyInitAction',
                url:'mr/tpl/template',
                blocks: {
                    content: 'content'
                }
            },
            'getSelect': {
                xclass: 'iih.mr.wr.mr.action.MrDocListGetSelectAction',
                blocks: {
                    result: 'right'
                }
            },
            'confirmComplete': {
                xclass: 'iih.mr.wr.mr.action.ConfirmCompleteAction'
            },
            'finish': {
                xclass: 'iih.mr.wr.mr.action.MrDocFinishWriteAction',
                url: 'mr/writeCompleted/amr'
            },
            'delete': {
                xclass: 'iih.mr.wr.mr.action.MrDocListDeleteAction',
                url: 'mr',
                blocks: {
                    result: 'right'
                }
            },
            'merger': {
                xclass: 'iih.mr.wr.mr.action.MrMergerShowAction',
                url: 'mr',
                blocks: {
                    result: 'right'
                }
            },
            'createDoc':{
                xclass:'iih.mr.wr.mr.action.CreateMrAction',
                url:'mr_doc_file',
                blocks:{
                    content:'content'
                }
            },
            'searchTask': {
                xclass: 'iih.po.com.action.TaskSearchAction',
                url: 'task/en',
                blocks: {
                    result: 'right'
                }
            },
            'showDoctor': { 
		    	xclass: 'iih.mr.wr.mr.action.ShowDoctorSelectAction',
		        url:'app/sup/doctors',
		        blocks: {
		            content:'content'
		        }
		    },
		    'quality':{
                xclass: 'iih.mr.wr.mr.action.TreeClickQualityAction',
                url: 'qaCheckCreateMr/mr',
                blocks: {
                    content: 'content'
                }
            },
		    'patCase': {//创建处方录入弹出框
                xclass: 'iih.mr.qa.pat_case.action.PatCasePopAction',
                url:'param',
                blocks:{
                    result:'left'
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
        	'init': ['init'],
        	'treeSelect': ['treeSelect'],
            'btnUsable': ['btnUsable'],
            'select': ['select'],
            'create': ['create'],
            'emrDocProperty':['emrDocProperty'],
            'templateProperty':['templateProperty'],
            'getSelect': ['getSelect'],
            'open': ['open'],
            'confirmComplete': ['confirmComplete'],
            'finish': ['finish'],
            'delete': ['delete'],
            'createDoc':['createDoc'],
            'merger': ['merger'],
            'tempInit':['tempInit'],
            'showDoctor':['showDoctor'],
            'searchTask':['searchTask'],
            'quality':['quality'],
            'showSyqyComp':['showSyqyComp'],
            'patCase':['patCase']
        },
        connections: {
        	'left': [/*{
                event: 'afterrender',
                chain: 'init'
            },*/{
                selector: 'xaptree[name=MrDocSortTree]',
                event: 'select',
                chain: 'treeSelect'
            },
            {
                selector: 'xaptree[name=mrTempSortTree]',
                event: 'itemdblclick',
                chain: 'quality'
            }],
            'right': [{
                selector: 'xapgrid[name=mrDocGrid]',
                event: 'select',
                chain: 'select'
            },{
                selector: 'toolbar button[method=create]',
                event: 'click',
                chain: 'create'
            },{
                selector: 'toolbar button[method=delete]',
                event: 'click',
                chain: 'getSelect'
            },{
                selector: 'toolbar button[method=open]',
                event: 'click',
                chain: 'open'
            },{
                selector: 'toolbar button[method=property]',
                event: 'click',
                chain: 'emrDocProperty'
            }/*,{
                selector: 'toolbar button[method=templateProperty]',
                event: 'click',
                chain: 'templateProperty'
            }*/,{
                selector: 'toolbar button[method=finish]',
                event: 'click',
                chain: 'confirmComplete'
            },{
                selector: 'toolbar button[method=merger]',
                event: 'click',
                chain: 'merger'
            },{
                selector: 'xapgrid[name=mrDocGrid]',
                event: 'itemdblclick',
                chain: 'open'
            },{
                selector: 'xapgrid[name=mrDocGrid]',
                event: 'linkClick',
                chain: 'open'
            }/*,{
                selector: 'xapgrid',
                event: 'linkClick',
                chain: 'open'
            }*/]
        }
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
		    //var owner = this.getOwner();
	        /*var chainGrid = this.getActionChain('refresh');
	        if(chainGrid) {
	            chainGrid.execute();
	        };*/
	        var chainTree = this.getActionChain('init');
	        if(chainTree) {
	            chainTree.execute();
	        };
	        var chainTask = this.getActionChain('searchTask');
            if(chainTask) {
                chainTask.execute();
            }
            var chainTemplateTree = this.getActionChain('tempInit');
	        if(chainTemplateTree) {
	        	chainTemplateTree.execute();
	        }
		});
	}
});