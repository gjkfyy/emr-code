Ext.define('iih.po.com.view.KnowledgeView', {
    extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    
    requires: ['iih.po.com.action.KnowledgeSearchAction'],
    
    alias: 'widget.knowledgeview',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.po.com.block.KnowledgeSearchBlock',
                height:25
                
            },
            /*'bottom': {
                xclass: 'iih.po.com.block.KnowledgeListBlock',
                flex:1
            },*/
            'bottom': {
                xclass: 'iih.po.com.view.KnowledgeSidebarView',
                flex:1
            }
        },

        actions: {
            'search': {
                xclass: 'iih.po.com.action.KnowledgeSearchAction',
                //url: 'knowledges',
                blocks: {
                    condition: 'top',
                    result: 'bottom'
                }
            }
        },

        chains: {
            'search': ['search']
        },

        connections: {
            'bottom': [{
                event: 'afterrender',
                chain: 'search'
            }],
            'top': [{
                selector: 'tool[itemId=refresh]',
                event: 'click',
                chain: 'search'
            }]
        }
    },
    
    initComponent : function() {
        this.callParent();
        var me = this;
        this.addEvents("writeMrDoc");//为视图添加事件
        this.addListener('writeMrDoc', function(){//添加监听事件
            //写回病历
            var hisDocPlugin=document.getElementById('iemrEditor');
            if(!hisDocPlugin.IsReadOnly()){
                var text,textArea,area;
                textArea = me.down('xaptextarea[name=fragmentTplContent]');
                area = textArea.value;
                var ta = textArea.inputEl.dom;
				var s = ta.selectionStart;
				var e = ta.selectionEnd;
				if(Ext.isEmpty(area,false)){
					area = '';
				}
				var text = area.substring(s,e); 
                if(!Ext.isEmpty(text,false)){
                    hisDocPlugin.InsertText(text);
                }else if(!Ext.isEmpty(area,false)){
                	hisDocPlugin.InsertText(area);
                }else{
                	XapMessageBox.info("请选择文本！");
                }
            }
        });
    }
});