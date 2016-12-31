Ext.define('iih.po.assistant.view.MrDocHelperView', {
	extend: 'Xap.ej.stl.view.LeftRightSplitTemplate',

	requires: [
	    'iih.po.assistant.block.MrDocHelperTreeBlock',
		'iih.mr.wr.mr.view.MrDocEditView',
		'iih.po.assistant.action.MrDocTreeNodeChangeAction',
		'iih.po.assistant.action.OutMrPrintAction'
	],

	alias:'widget.mrdochelperview',

	xapConfig: {
		blocks: {
			'left': {
				xclass: 'iih.po.assistant.block.MrDocHelperTreeBlock',
				width: CONFIG_PARAM.OUT_MR_WRITE_LEFT_WIDTH  //220
            },
			'right': {
				xclass: 'iih.mr.wr.mr.view.MrDocEditView'
			}
		},
		
		actions: {
			'refresh': {
				xclass: 'iih.po.assistant.action.MrDocHelperTreeInitAction',
				url: 'mr_doc_tree/mrs',
				blocks: {
					result: 'left'
				}
			},
            'treeNodeChange': {
                xclass: 'iih.po.assistant.action.MrDocTreeNodeChangeAction',
                blocks: {
                    result: 'left'
                }
            },
			'outMrPrint': {
				xclass: 'iih.po.assistant.action.OutMrPrintAction',
				blocks: {
					result: 'left'
				}
			},
            'mrPrintOPLog':{
                xclass: 'iih.mr.wr.omr.action.OmrPrintOpLogAction',
                url: 'omr/print/log',
                blocks: {
                    content: 'content'
                }
            }
		},

		chains: {
			'refresh': ['refresh'],
			'treeNodeChange': ['treeNodeChange'],
		    'outMrPrint': ['outMrPrint'],
            'mrPrintOPLog':['mrPrintOPLog']
		},

		connections: {
			'left': [/*{
				event: 'afterrender',
				chain: 'refresh'
			},*/{
                selector: 'xaptree',
                event: 'itemclick',
                chain: 'treeNodeChange'
		    },{
		    	selector: 'button[method=print]',
                event: 'click',
				chain: 'outMrPrint'
		    }]
		}
     },initComponent : function() {
		this.callParent();
		this.addEvents("writeMrDoc");//为视图添加事件
		this.addListener('writeMrDoc', function() {//添加监听事件
			//写回病历
			var plugin = document.getElementById('iemrEditor');
			var iemrEditorRead = document.getElementById('iemrEditorRead');
			if(plugin!=null&&iemrEditorRead!=null)
			{
				if(!plugin.IsReadOnly()){
					if(iemrEditorRead.HasSelection(0)){
						iemrEditorRead.OfficeCopy();
						var bool= plugin.ImportClipboard(0);
						if(bool==1){
							XapMessageBox.info('带元素内容，不能写入元素标签中');
						}
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
	}
});