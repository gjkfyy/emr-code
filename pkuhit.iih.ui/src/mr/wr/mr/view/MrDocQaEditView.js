Ext.define('iih.mr.wr.mr.view.MrDocQaEditView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias: 'widget.mrdocqaeditview',
    layout: {
        type: 'fit'
    },

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.mr.block.editor.MrDocEditBlock',
                flex: 1
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.wr.mr.action.MrDocQaEditAction',
//                url: 'http://127.0.0.1:8081/mr',
                url:'mr',
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
                xclass: 'iih.mr.wr.mr.action.MrDocSaveAction',
                url: 'mr',
//                url: 'http://127.0.0.1:8081/mr',
                blocks: {
                    content: 'content'
                }
            },
            'editorCallBackAction': {
                xclass: 'iih.mr.wr.mr.action.QaEditorCallBackAction',
                url:'signUser',
                blocks: {
                    content: 'content'
                }
            },
            'disabledOfficeToolBarAction': {
                xclass: 'iih.mr.wr.mr.action.QaDisabledOfficeToolBarAction',
                url:'current_user',
                blocks: {
                    content: 'content'
                }
            },
            'emrEditorOperator': {
                xclass: 'iih.mr.action.editor.EmrEditorOperatorAction'
            }
        },

        chains: {
            'init': ['init'],
            'emrCmdDispatch': ['emrCmdDispatch'],
            'emrSave': ['emrSave'],
            'doSave': ['emrSave'],
            'disabledOfficeToolBarAction':['disabledOfficeToolBarAction'],
            'editorCallBackAction':['editorCallBackAction']
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
    }
})