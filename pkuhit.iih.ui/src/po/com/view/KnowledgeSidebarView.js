Ext.define('iih.po.com.view.KnowledgeSidebarView', {
    extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    
    requires: [
               	'iih.po.com.action.KnowledgeTreeInitAction',
               	'iih.po.com.action.KnowledgeTreeNodeAction',
               	'iih.po.com.action.KnowledgeTreeRebackAction',
               	'iih.po.com.action.KnowledgeTextRebackAction'
               	
               ],
    
    alias: 'widget.knowledgesidebarview',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.po.com.block.KnowledgeTreeBlock',
                height:290
                
            },
            'bottom': {
                xclass: 'iih.po.com.block.KnowledgeTextAreaBlock',
                flex:1
            }
        },

        actions: {
        	'init': {
				xclass: 'iih.po.com.action.KnowledgeTreeInitAction',
				url:'knowledges/tree',
				blocks: {
					top: 'top',
					result: 'bottom'
				}
			},
			'treeClick': {
                xclass: 'iih.po.com.action.KnowledgeTreeNodeAction',
                url:'knowledge',
                blocks: {
                	top: 'top',
					result: 'bottom'
                }
            },
			'treeReback': {
                xclass: 'iih.po.com.action.KnowledgeTreeRebackAction',
                blocks: {
                	top: 'top',
					result: 'bottom'
                }
            },
			'textReback': {
                xclass: 'iih.po.com.action.KnowledgeTextRebackAction',
                blocks: {
                	top: 'top',
					result: 'bottom'
                }
            }
		},

        chains: {
        	'init':['init'],
        	'treeClick':['treeClick'],
        	'treeReback':['treeReback'],
        	'textReback':['textReback']
        },

        connections: {
            'bottom': [/*{
	            	selector: 'xaptextarea[name=fragmentTplContent]',
	                event: 'ondblclick',
	                chain: 'textReback'
	            }*/],
            'top': [{
                    	event: 'afterrender',
                    	chain: 'init'
                	}/*,{
	                 selector: 'xaptree[name=knowledgesTree]',
	                 event: 'itemclick',
	                 chain: 'treeClick'
                	},{
	                 selector: 'xaptree[name=knowledgesTree]',
	                 event: 'itemdblclick',
	                 chain: 'treeReback'
				}*/]
        	}
    },
    
    initComponent : function() {
        this.callParent();
        var me = this,clickNtime,clickOtime,ctime,textArea,area,content;
        me.clicktime = '';
        var tree = me.down('[name=knowledgesTree]');
        tree.addListener('itemclick', function(v,r,it,i,e,eOpts){
    		var chain = me.getActionChain('treeClick');
    		var fragmentTplCd = r.raw.id,leaf = r.raw.leaf;
    		var bottom = me.down('knowledgetextareablock');
    		clickNtime = new Date();
        	if(!Ext.isEmpty(me.clicktime,false)){
        		clickOtime = me.clicktime;
        		ctime = clickNtime-clickOtime;
        		me.clicktime = clickNtime;
        		//ctime = Math.round(ctime/1000);
        		if(ctime>500){
        			if(leaf){
        				content = r.raw.content;
                        textArea = bottom.down('xaptextarea[name=fragmentTplContent]');
                        textArea.setValue(content);
                        me.oldTreeCd = fragmentTplCd;
            		}
        		}else{
        			if(leaf){
        				var hisDocPlugin = document.getElementById('iemrEditor'),content;
        				if(!Ext.isEmpty(me.oldTreeCd,false)){
            				if(me.oldTreeCd==fragmentTplCd){
            					if(!hisDocPlugin.IsReadOnly()){
                        			content = r.raw.content;
                        			if(!Ext.isEmpty(content,false)){
                                    	hisDocPlugin.InsertText(content);
                                    }
                                }
            				}else{
            					me.oldTreeCd = fragmentTplCd;
            					content = r.raw.content;
                                textArea = bottom.down('xaptextarea[name=fragmentTplContent]');
                                textArea.setValue(content);
            				}
            			}else{
            				me.oldTreeCd = fragmentTplCd;
                    		if(!hisDocPlugin.IsReadOnly()){
                    			content = r.raw.content;
                    			if(!Ext.isEmpty(content,false)){
                                	hisDocPlugin.InsertText(content);
                                }
                            }
            			}
                	}
        		}
        	}else{
        		me.clicktime = clickNtime;
    			if(leaf){
        			content = r.raw.content;
                    textArea = bottom.down('xaptextarea[name=fragmentTplContent]');
                    textArea.setValue(content);
                    me.oldTreeCd = fragmentTplCd;
        		}
        	}
        });
    }
});