Ext.define('iih.mr.tm.fr.view.FrTplSidebarView', {
    extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    
    requires: [
               	'iih.mr.tm.fr.action.FrTplTreeInitAction',
               	'iih.mr.tm.fr.action.FrTplTreeNodeAction',
               	'iih.mr.tm.fr.action.FrTplTreeRebackAction',
               	'iih.mr.tm.fr.action.FrTplTextRebackAction'
               ],
    
    alias: 'widget.frtplsidebarview',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.mr.tm.fr.block.FrTplTreeBlock',
                height:300
                
            },
            'bottom': {
                xclass: 'iih.mr.tm.fr.block.FrTplTextAreaBlock',
                flex:1
            }
        },

        actions: {
        	'init': {
				xclass: 'iih.mr.tm.fr.action.FrTplTreeInitAction',
				url:'mr/tpl/tree/frtpl',
				blocks: {
					top: 'top',
					result: 'bottom'
				}
			},
			'treeClick': {
                xclass: 'iih.mr.tm.fr.action.FrTplTreeNodeAction',
                url:'knowledge',
                blocks: {
                	top: 'top',
					result: 'bottom'
                }
            },
			'treeReback': {
                xclass: 'iih.mr.tm.fr.action.FrTplTreeRebackAction',
                blocks: {
                	top: 'top',
					result: 'bottom'
                }
            },
			'textReback': {
                xclass: 'iih.mr.tm.fr.action.FrTplTextRebackAction',
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
            'bottom': [],
            'top': [{
                	event: 'afterrender',
                	chain: 'init'
            	}]
        	}
    },
    
    initComponent : function() {
        this.callParent();
        var me = this,clickNtime,clickOtime,ctime,textArea,area,content;
        me.clicktime = '';
        var tree = me.down('[name=frTplTree]');
        tree.addListener('itemclick', function(v,r,it,i,e,eOpts){
    		var chain = me.getActionChain('treeClick');
    		var mrFrTplCd = r.raw.id,leaf = r.raw.leaf;
    		var bottom = me.down('frtpltextareablock');
    		clickNtime = new Date();
        	if(!Ext.isEmpty(me.clicktime,false)){
        		clickOtime = me.clicktime;
        		ctime = clickNtime-clickOtime;
        		me.clicktime = clickNtime;
        		//ctime = Math.round(ctime/1000);
        		if(ctime>500){
        			if(leaf){
        				content = r.raw.content;
                        textArea = bottom.down('xaptextarea[name=contentText]');
                        textArea.setValue(content);
                        me.oldTreeCd = mrFrTplCd;
            		}
        		}else{
        			if(leaf){
        				var hisDocPlugin = document.getElementById('iemrEditor'),content,odtFile,temp;
        				if(!Ext.isEmpty(me.oldTreeCd,false)){
            				if(me.oldTreeCd==mrFrTplCd){
            					if(!hisDocPlugin.IsReadOnly()){
            						odtFile = r.raw.odtFile;
                        			if(!Ext.isEmpty(odtFile,false)){
                        				/*temp = hisDocPlugin.SaveToString();
                        				hisDocPlugin.OpenFromString(odtFile,2);
                        				hisDocPlugin.InsertFromString(temp,0);*/
                        				hisDocPlugin.InsertFromString(odtFile,0);
                                    }
                                }
            				}else{
            					me.oldTreeCd = mrFrTplCd;
            					content = r.raw.content;
                                textArea = bottom.down('xaptextarea[name=contentText]');
                                textArea.setValue(content);
            				}
            			}else{
            				me.oldTreeCd = mrFrTplCd;
                    		if(!hisDocPlugin.IsReadOnly()){
                    			odtFile = r.raw.odtFile;
                    			if(!Ext.isEmpty(odtFile,false)){
                    				/*temp = hisDocPlugin.SaveToString();
                    				hisDocPlugin.OpenFromString(odtFile,2);
                    				hisDocPlugin.InsertFromString(temp,0);*/
                    				hisDocPlugin.InsertFromString(odtFile,0);
                                }
                            }
            			}
                	}
        		}
        	}else{
        		me.clicktime = clickNtime;
    			if(leaf){
        			content = r.raw.content;
                    textArea = bottom.down('xaptextarea[name=contentText]');
                    textArea.setValue(content);
                    me.oldTreeCd = mrFrTplCd;
        		}
        	}
        });
    }
});