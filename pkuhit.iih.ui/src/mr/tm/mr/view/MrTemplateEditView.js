Ext.define('iih.mr.tm.mr.view.MrTemplateEditView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: ['iih.mr.block.editor.MrDocEditBlock', 
               'iih.mr.tm.mr.action.MrTemplateEditAction', 
               'iih.mr.tm.mr.action.MrTemplateSaveAction', 
               'iih.mr.action.editor.EmrCmdDispatchAction', 
               'iih.mr.action.editor.EmrEditorOperatorAction',
               'iih.mr.tm.mr.action.GroupElementLibAction',
               'iih.mr.tm.mr.action.DisabledOfficeToolBarAction',
               'iih.mr.tm.mr.action.EditorCallBackAction',
               'iih.mr.tm.mr.action.PropertyTemplateSaveAsAction',
               'iih.mr.tm.mr.action.PropertyTemplateDocAction',
               'iih.mr.tm.mr.action.MrTemplatePrintAction',
               'iih.mr.tm.xml.action.FormXmlCreateAction',
               'iih.mr.tm.mr.action.TemplatePropertySaveAction'],

    alias: 'widget.mrtemplateeditview',
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
                xclass: 'iih.mr.tm.mr.action.MrTemplateEditAction',
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
                xclass: 'iih.mr.tm.mr.action.MrTemplateSaveAction',
                url: 'mr/tpl/template',//修改url+换新的iemr地址 /mr/tpl/template2014-12-24
                blocks: {
                    content: 'content'
                }
            },
            'emrDocProperty': {
                xclass: 'iih.mr.tm.mr.action.PropertyTemplateDocAction',
                url: 'mr/tpl/template',//修改url+换新的iemr地址 /mr/tpl/template2014-12-24
                blocks: {
                    content: 'content'
                }
            },
            'emrSaveAs': {
                xclass: 'iih.mr.tm.mr.action.PropertyTemplateSaveAsAction',
                url: 'mr/tpl/template',
                blocks: {
                	content: 'content',
                	result: 'content'
                }
            },
            'emrUpdateTempl': {
                xclass: 'iih.mr.tm.mr.action.TemplateResetUseAction',
                blocks: {
                	content: 'content',
                	result: 'content'
                }
            },
            'emrChangeBaseTempl': {
                xclass: 'iih.mr.tm.mr.action.TemplateResetUseSelAction',
                blocks: {
                	content: 'content',
                	result: 'content'
                }
            },
            'emrRelease': {
                xclass: 'iih.mr.tm.mr.action.MrTemplateReleaseAction',
				url:'mr/tpl/template',
                blocks: {
                    content: 'content'
                }
            },
            'emrEditorOperator': {
                xclass: 'iih.mr.action.editor.EmrEditorOperatorAction'
            },
            'groupElementLib': {
                xclass: 'iih.mr.tm.mr.action.GroupElementLibAction'
            },
            'editorCallBackAction': {
                xclass: 'iih.mr.tm.mr.action.EditorCallBackAction',
                blocks: {
                    content: 'content'
                }
            },
            'disabledOfficeToolBarAction': {
                xclass: 'iih.mr.tm.mr.action.DisabledOfficeToolBarAction',
                blocks: {
                    content: 'content'
                }
            },
			'saveBaseCode': {
                xclass: 'iih.mr.tm.mr.action.TemplatePropertySaveAction',
                url:'mr/tpl/template/reset',
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
			'emrTableElement': {
				xclass: 'iih.mr.tm.xml.action.FormXmlCreateAction',
				blocks: {
					left: 'left',
					result: 'right'
				}
			},
			'emrPrint': {
				xclass: 'iih.mr.tm.mr.action.MrTemplatePrintAction',
				blocks: {
					 content: 'content'
				}
			},
			'emrExportXML':{
            	xclass: 'iih.mr.wr.mr.action.EmrEmrExportXMLAction',
                blocks: {
                    content: 'content'
                }
            },
            'emrPrintSelected': {
                xclass: 'iih.mr.wr.mr.action.SelectedPrintAction',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'init': ['init'],
            'emrCmdDispatch': ['emrCmdDispatch'],
            'emrSave': ['emrSave'],
            'emrUpdateTempl': ['emrUpdateTempl'],
            'emrChangeBaseTempl': ['emrChangeBaseTempl'],
            'doSave': ['emrSave'],
            'emrDocProperty': ['emrDocProperty'],
            'emrSaveAs': ['emrSaveAs'],
            'IDD_GROUP_ELEMENT_LIB': ['groupElementLib'],
            'emrRelease': ['emrRelease'],
            'editorCallBackAction':['editorCallBackAction'],
            'disabledOfficeToolBarAction':['disabledOfficeToolBarAction'],
            'saveBaseCode': ['saveBaseCode'],
            'showHyperlink':['showHyperlink'],
            'emrTableElement':['emrTableElement'],
            'emrPrint':['emrPrint'],
            'emrHyperlink':['emrHyperlink'],
            'emrPrintSelected':['emrPrintSelected'],
            'emrExportXML':['emrExportXML']
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