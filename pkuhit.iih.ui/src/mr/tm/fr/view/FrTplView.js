Ext.define('iih.mr.tm.fr.view.FrTplView', {
    extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    
    requires: ['iih.mr.tm.fr.action.FrTplTreeSearchAction'],
    
    alias: 'widget.frtplview',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.mr.tm.fr.block.FrTplSearchBlock',
                height:25
                
            },
            'bottom': {
                xclass: 'iih.mr.tm.fr.view.FrTplSidebarView',
                flex:1
            }
        },

        actions: {
            'search': {
                xclass: 'iih.mr.tm.fr.action.FrTplTreeSearchAction',
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
                textArea = me.down('xaptextarea[name=contentText]');
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