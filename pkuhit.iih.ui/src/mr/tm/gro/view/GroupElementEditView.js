Ext.define('iih.mr.tm.gro.view.GroupElementEditView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: [
               'iih.mr.block.editor.MrDocEditBlock', 
               'iih.mr.tm.gro.action.GroupElementEditAction', 
                /*'iih.mr.tm.gro.action.GroupElementSaveAction', */
               'iih.mr.action.editor.EmrCmdDispatchAction', 
               'iih.mr.action.editor.EmrEditorOperatorAction'
               ],

    alias: 'widget.groupelementeditview',
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
                xclass: 'iih.mr.tm.gro.action.GroupElementEditAction',
                url: 'mr/tpl/groupElement',
                blocks: {
                    content: 'content'
                }
            }, 
            /* 'emrSave': {
            	//http://guozhongbao:8081/
                xclass: 'iih.mr.tm.bas.action.GroupElementSaveAction',
                url: 'mr/tpl/baseTemplate',
                blocks: {
                    content: 'content'
                }
            },*/
            'emrCmdDispatch': {
                xclass: 'iih.mr.action.editor.EmrCmdDispatchAction',
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
            /*'emrSave': ['emrSave'],*/
            'emrCmdDispatch': ['emrCmdDispatch'],
        },

        connections: {
            'content': [{
                selector: 'button[method=editorEvent]',
                event: 'editorEvent',
                chain: 'emrCmdDispatch'
            }/**/, {
                event: 'afterrender',
                chain: 'init'
            }]
        }
    }
})