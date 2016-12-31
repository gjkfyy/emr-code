Ext.define('iih.mr.tm.bas.view.BasTemplateEditView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: ['iih.mr.block.editor.MrDocEditBlock', 
               'iih.mr.tm.bas.action.BasTemplateEditAction', 
               'iih.mr.tm.bas.action.BasTemplateSaveAction', 
               'iih.mr.action.editor.EmrCmdDispatchAction', 
               'iih.mr.action.editor.EmrEditorOperatorAction',
               'iih.mr.tm.bas.action.EditorCallBackAction',
               'iih.mr.tm.bas.action.DisabledOfficeToolBarAction'],

    alias: 'widget.bastemplateeditview',
    layout: 'fit',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.mr.block.editor.MrDocEditBlock',
                flex: 1
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.tm.bas.action.BasTemplateEditAction',
                url: 'mr/basefile',
                blocks: {
                    content: 'content'
                }
            },
            'emrCmdDispatch': {
                xclass: 'iih.mr.action.editor.EmrCmdDispatchAction',
                blocks: {
                    content: 'content'
                }
            },
            'emrSave': {
            	//http://guozhongbao:8081/
                xclass: 'iih.mr.tm.bas.action.BasTemplateSaveAction',
                url: 'mr/tpl/baseTemplate',
                blocks: {
                    content: 'content'
                }
            },
            'emrEditorOperator': {
                xclass: 'iih.mr.action.editor.EmrEditorOperatorAction'
            },
            'emrRelease': {//模板进行启用
                xclass: 'iih.mr.tm.bas.action.ReleaseBasTemplateEditAction',
                url:'mr/tpl/activated/baseTemplate',
                blocks: {
                	content: 'content'
                }                
            },
            'emrTableElement':{//编辑表格元素
                xclass: 'iih.mr.tm.xml.action.FormXmlCreateAction',
                blocks: {
                    content: 'content'
                }
            },
            'editorCallBackAction': {
                xclass: 'iih.mr.tm.bas.action.EditorCallBackAction',
                blocks: {
                    content: 'content'
                }
            },
            'disabledOfficeToolBarAction': {
                xclass: 'iih.mr.tm.bas.action.DisabledOfficeToolBarAction',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'init': ['init'],
            'emrCmdDispatch': ['emrCmdDispatch'],
            'emrSave': ['emrSave'],
            'emrRelease': ['emrRelease'],
            'emrTableElement':['emrTableElement'],
            'doSave': ['emrSave'],
            'editorCallBackAction':['editorCallBackAction'],
            'disabledOfficeToolBarAction':['disabledOfficeToolBarAction']
        },

        connections: {
            'content': [{
                selector: 'button[method=editorEvent]',
                event: 'editorEvent',
                chain: 'emrCmdDispatch'
            }, {
                event: 'afterrender',
                chain: 'init'
            }]
        }
    },
    
    hasEdit: function() {
        var plugin = document.getElementById('iemrEditor');
        if (plugin != undefined &&plugin.valid&&plugin.IsModified()) {
            return true;
        } else {
            return false;
        }
    }

})