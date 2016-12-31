Ext.define('iih.mr.tm.fr.view.FrTplEditView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: ['iih.mr.block.editor.MrDocEditBlock', 
               'iih.mr.tm.fr.action.FrTplEditAction', 
               'iih.mr.tm.fr.action.FrTplSaveAction', 
               'iih.mr.action.editor.EmrCmdDispatchAction', 
               'iih.mr.action.editor.EmrEditorOperatorAction',
               'iih.mr.tm.fr.action.EditorCallBackAction',
               'iih.mr.tm.fr.action.DisabledOfficeToolBarAction'],

    alias: 'widget.frtpleditview',
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
                xclass: 'iih.mr.tm.fr.action.FrTplEditAction',
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
                xclass: 'iih.mr.tm.fr.action.FrTplSaveAction',
                url: 'mr/tpl/frtpl',
                blocks: {
                    content: 'content'
                }
            },
            'emrEditorOperator': {
                xclass: 'iih.mr.action.editor.EmrEditorOperatorAction'
            },
            'emrRelease': {//模板进行启用
                xclass: 'iih.mr.tm.fr.action.FrTplEditReleaseAction',
                url:'mr/tpl/activated/frtpl',
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
            },
            'showHyperlink':{
            	xclass: 'iih.mr.action.editor.ShowHyperlinkWindowAction',
            	blocks: {
                     content: 'content'
                }
            },
            'emrHyperlink':{
            	xclass: 'iih.mr.action.editor.EmrHyperlinkAction',
                blocks: {
                    content: 'content'
                }
            },
            'emrExportXML':{
            	xclass: 'iih.mr.wr.mr.action.EmrEmrExportXMLAction',
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
            'doSave': ['emrSave'],
            'editorCallBackAction':['editorCallBackAction'],
            'disabledOfficeToolBarAction':['disabledOfficeToolBarAction'],
            'showHyperlink':['showHyperlink'],
            'emrExportXML':['emrExportXML'],
            'emrHyperlink':['emrHyperlink']
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